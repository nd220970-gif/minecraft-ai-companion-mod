# Minecraft AI Companion

A beginner-friendly NeoForge mod for Minecraft Java 26.3 that adds a tameable companion and the foundation for natural-language tasks such as gathering, crafting, building, and fighting.

> **Important:** This repository contains the source project, not a ready-made `.jar` yet. Minecraft 26.3 is a very new target, so the NeoForge version in `gradle.properties` may need to be changed to the matching release from the NeoForge Maven repository before building.

## What works in this first version

- `/companion summon` creates a named companion wolf.
- `/companion dismiss` removes your companion.
- `/companion status` reports whether your companion is active.
- `/companion get <item>` accepts a requested item and gives a clear response. The task system is intentionally conservative until gathering behavior is added.
- The companion follows and protects its owner using vanilla wolf behavior.

## Build it

1. Install the Java version required by the NeoForge 26.3 MDK (the current 26.3 guidance recommends Java 25+).
2. Install Git and download this repository.
3. Open a terminal in the repository folder.
4. Run:

   - Windows: `gradlew.bat build`
   - Linux/macOS: `./gradlew build`

5. Put the generated jar from `build/libs/` into your SKLauncher instance's `mods` folder.
6. Launch the NeoForge 26.3 profile, create a world, and run `/companion summon`.

If Gradle reports that `neo_version` cannot be found, open the NeoForge 26.3 download page and replace that property with the exact matching NeoForge version. Loader versions change during snapshots and previews.

## Commands

- `/companion summon`
- `/companion dismiss`
- `/companion status`
- `/companion get minecraft:oak_log`

Use the fully qualified item ID for now. Examples: `minecraft:oak_log`, `minecraft:iron_ingot`, and `minecraft:bread`.

## Roadmap

1. Add a real companion entity with a task queue.
2. Add item/block/mob registry knowledge so requests can use names as well as IDs.
3. Add safe gathering: search nearby blocks, mine only reachable blocks, collect drops, and return to the owner.
4. Add crafting from recipes and a permission/check system before taking or placing blocks.
5. Add combat goals with owner protection and configurable mob targets.
6. Add optional local AI integration. The mod should never require a paid online AI service to perform basic game tasks.

This is deliberately being built in small steps so it is easier to test and so the companion cannot destroy a world accidentally.