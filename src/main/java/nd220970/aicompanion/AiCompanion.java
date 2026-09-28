package nd220970.aicompanion;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod(AiCompanion.MOD_ID)
public final class AiCompanion {
    public static final String MOD_ID = "aicompanion";
    private static final Map<UUID, UUID> COMPANIONS = new HashMap<>();

    public AiCompanion() {
        // Commands are registered through the NeoForge event bus below.
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static final class CommandsHandler {
        @SubscribeEvent
        public static void registerCommands(RegisterCommandsEvent event) {
            event.getDispatcher().register(Commands.literal("companion")
                .then(Commands.literal("summon").executes(context -> summon(context.getSource().getPlayerOrException())))
                .then(Commands.literal("dismiss").executes(context -> dismiss(context.getSource().getPlayerOrException())))
                .then(Commands.literal("status").executes(context -> status(context.getSource().getPlayerOrException())))
                .then(Commands.literal("get")
                    .then(Commands.argument("item", ResourceLocationArgument.id())
                        .executes(context -> requestItem(
                            context.getSource().getPlayerOrException(),
                            ResourceLocationArgument.getId(context, "item")))))
                .then(Commands.literal("help").executes(context -> help(context.getSource().getPlayerOrException()))));
        }
    }

    private static int summon(ServerPlayer player) {
        dismiss(player);
        Wolf wolf = EntityType.WOLF.create(player.serverLevel());
        if (wolf == null) return 0;
        wolf.moveTo(player.getX() + 1, player.getY(), player.getZ() + 1, player.getYRot(), 0);
        wolf.tame(player);
        wolf.setCustomName(Component.literal("AI Companion"));
        wolf.setCustomNameVisible(true);
        player.serverLevel().addFreshEntity(wolf);
        COMPANIONS.put(player.getUUID(), wolf.getUUID());
        player.sendSystemMessage(Component.literal("Your AI Companion is ready. Try /companion get minecraft:oak_log."));
        return 1;
    }

    private static int dismiss(ServerPlayer player) {
        UUID id = COMPANIONS.remove(player.getUUID());
        if (id != null) {
            var entity = player.serverLevel().getEntity(id);
            if (entity != null) entity.discard();
            player.sendSystemMessage(Component.literal("Your companion has gone home."));
        }
        return 1;
    }

    private static int status(ServerPlayer player) {
        UUID id = COMPANIONS.get(player.getUUID());
        boolean active = id != null && player.serverLevel().getEntity(id) != null;
        player.sendSystemMessage(Component.literal(active
            ? "Your AI Companion is active and protecting you."
            : "You do not currently have a companion. Use /companion summon."));
        return 1;
    }

    private static int requestItem(ServerPlayer player, ResourceLocation id) {
        if (!BuiltInRegistries.ITEM.containsKey(id)) {
            player.sendSystemMessage(Component.literal("I do not know the item " + id + ". Try a Minecraft item ID."));
            return 0;
        }
        Item item = BuiltInRegistries.ITEM.get(id);
        player.sendSystemMessage(Component.literal("Task accepted: I will learn how to fetch " + id + ". Gathering and crafting automation is the next feature being added."));
        // Never create items here: future task code must physically gather or craft them.
        return 1;
    }

    private static int help(ServerPlayer player) {
        player.sendSystemMessage(Component.literal("AI Companion commands: summon, dismiss, status, get <item ID>."));
        return 1;
    }
}
