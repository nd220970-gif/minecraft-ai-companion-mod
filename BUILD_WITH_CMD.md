# Build Your Minecraft Mod with Command Prompt (CMD)

This guide walks you through building the mod step-by-step using only Windows Command Prompt (CMD). No GUI, no IDE, just simple commands.

---

## What You Need (Download & Install)

### 1. Java Development Kit (JDK) 25+

1. Go to: https://www.oracle.com/java/technologies/downloads/
2. Click **Windows** → **x64 Installer**
3. Download the `.exe` file
4. Run it and click **Next** through the installer
5. Click **Finish** when done

**Verify Java is installed:**
1. Open **Command Prompt** (press `Windows key + R`, type `cmd`, press Enter)
2. Type: `java -version`
3. Press Enter
4. You should see something like: `java version "25.0.1"`

If you don't see a version number, Java isn't installed. Try installing again.

---

### 2. Git (for downloading the mod code)

1. Go to: https://git-scm.com/download/win
2. Download the **64-bit** installer
3. Run it and click **Next** through everything (keep default settings)
4. Click **Finish**

**Verify Git is installed:**
1. Open a new **Command Prompt** window
2. Type: `git --version`
3. Press Enter
4. You should see: `git version 2.x.x`

---

## Build Steps

### Step 1: Open Command Prompt

Press `Windows key + R`, type `cmd`, press Enter.

### Step 2: Create a Working Folder

Type these commands one at a time, pressing Enter after each:

```cmd
cd Desktop
mkdir MinecraftMods
cd MinecraftMods
```

You're now in `C:\Users\YourName\Desktop\MinecraftMods`

### Step 3: Download the Mod Code

Type this command and press Enter:

```cmd
git clone https://github.com/nd220970-gif/minecraft-ai-companion-mod.git
```

Wait for it to finish (you'll see text appearing). It should end with:
```
Resolving deltas: 100% ...done
```

### Step 4: Go Into the Mod Folder

Type:
```cmd
cd minecraft-ai-companion-mod
```

Now you're inside the mod folder. You should see in the command prompt:
```
C:\Users\YourName\Desktop\MinecraftMods\minecraft-ai-companion-mod>
```

### Step 5: Build the Mod

Type this command:

```cmd
gradlew.bat build
```

Press Enter and **wait**. This will:
- Download Minecraft 26.3
- Download NeoForge
- Compile your mod
- Build the jar file

**First time takes 10-15 minutes.** Your internet will be busy.

You'll see lots of text scrolling. When done, you'll see:

```
BUILD SUCCESSFUL

Total time: X minutes
```

If you see `BUILD FAILED`, scroll up and look for the error message. Post it and I can help fix it.

---

## Step 6: Find Your Built Mod

Type:
```cmd
dir build\libs
```

You should see a file named:
```
aicompanion-0.1.0.jar
```

This is your mod! Copy the full path. It will be something like:
```
C:\Users\YourName\Desktop\MinecraftMods\minecraft-ai-companion-mod\build\libs\aicompanion-0.1.0.jar
```

---

## Step 7: Add to SKLauncher

1. **Open SKLauncher**
2. **Right-click** your **Minecraft 26.3 NeoForge** profile
3. Click **Edit**
4. Find the **Mods folder** or **Mod directory** field
5. Open that folder (it will be something like `C:\Users\YourName\.sklauncher\instances\minecraft-1.20.6\mods`)
6. **Copy** the `aicompanion-0.1.0.jar` file
7. **Paste** it into that mods folder
8. Close the folder

---

## Step 8: Test in Game

1. In SKLauncher, click **Play** on your NeoForge 26.3 profile
2. Create or load a world
3. Press `T` to open chat
4. Type: `/companion summon`
5. Press Enter

**You should see a wolf named "AI Companion" appear next to you!**

---

## Test More Commands

Try these in chat:
- `/companion status` → Check if companion is active
- `/companion get minecraft:oak_log` → Request wood
- `/companion dismiss` → Remove companion
- `/companion help` → Show all commands

---

## If Build Fails: Troubleshooting

### Error: "gradle command not found"
- Make sure you're in the correct folder
- Type: `cd minecraft-ai-companion-mod` first
- Then run: `gradlew.bat build` again

### Error: "Java not found"
- Java isn't installed correctly
- Go back to "What You Need" section and reinstall Java
- Restart Command Prompt after installing
- Try: `java -version` to verify

### Error: "NeoForge version not found"
- This means the version in `gradle.properties` doesn't exist
- Open the file: `gradle.properties`
- Change: `neo_version=26.3.0` 
- To the latest version from: https://neoforged.net/
- Save the file
- Run build again: `gradlew.bat build`

### Error: "Cannot find module"
- Wait longer - first build can take 15+ minutes
- Try running build again: `gradlew.bat build`

---

## After Your First Successful Build

Each time you **change code** and rebuild:

1. Go back to Command Prompt
2. Make sure you're in the mod folder
3. Run: `gradlew.bat build`
4. Wait for success
5. Copy the new jar from `build\libs`
6. Paste it into SKLauncher mods folder (replace old one)
7. Restart the game

---

## Quick Command Reference

```cmd
# Check Java version
java -version

# Go to Desktop
cd Desktop

# Create a folder
mkdir MinecraftMods

# Go into folder
cd MinecraftMods

# Download mod code
git clone https://github.com/nd220970-gif/minecraft-ai-companion-mod.git

# Go into mod folder
cd minecraft-ai-companion-mod

# Build the mod
gradlew.bat build

# See the built jar file
dir build\libs
```

---

## You Now Have:

✅ A working mod development setup  
✅ The ability to build mods from Command Prompt  
✅ A Minecraft AI Companion mod ready to test  
✅ A mods folder in SKLauncher with your jar file  

**Next Steps:**
- Test the mod works with `/companion summon`
- Then we can add features like:
  - Gathering wood/stone
  - Crafting tools
  - Fighting mobs
  - Following commands
