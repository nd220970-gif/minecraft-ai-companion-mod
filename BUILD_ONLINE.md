# Build Your Mod Online (No Installation Required!)

You can build your mod entirely in your browser using **GitHub Actions**. No Java, no Gradle, nothing to install.

## Method 1: GitHub Actions (Easiest - Fully Automated)

### Step 1: Enable GitHub Actions

1. Go to your repository: https://github.com/nd220970-gif/minecraft-ai-companion-mod
2. Click the **Actions** tab
3. Click **I understand my workflows, go ahead and enable them**

### Step 2: Trigger the Build

1. Go to the **Actions** tab
2. Click **Build Mod** workflow on the left
3. Click the **Run workflow** button
4. Click **Run workflow** again in the dropdown
5. Wait 5-10 minutes for the build to complete

### Step 3: Download Your Mod

1. The build will appear in the list with a green checkmark ✅
2. Click on the completed build
3. Scroll down to **Artifacts**
4. Click **minecraft-ai-companion-mod** to download the `.jar` file
5. The file will be `aicompanion-0.1.0.jar`

### Step 4: Add to SKLauncher

1. Open SKLauncher
2. Find your **Minecraft 26.3 NeoForge** profile
3. Right-click → **Edit**
4. Find the **Mods folder** path
5. Paste the downloaded `aicompanion-0.1.0.jar` into that folder
6. Click **Play**

---

## Method 2: Use Replit (No GitHub Setup Needed)

If you don't want to use GitHub Actions, you can use **Replit** (free online IDE):

### Step 1: Open Replit

1. Go to https://replit.com
2. Click **Sign up** (or log in if you have an account)
3. Choose any free plan

### Step 2: Create a New Project

1. Click **Create Repl**
2. Select **Git repository**
3. Paste this URL: `https://github.com/nd220970-gif/minecraft-ai-companion-mod.git`
4. Click **Import from GitHub**
5. Wait for it to load (1-2 minutes)

### Step 3: Build

1. In the terminal at the bottom, type:
   ```
   ./gradlew build
   ```
2. Press Enter
3. Wait 10-15 minutes for the build to complete
4. You'll see: `BUILD SUCCESSFUL`

### Step 4: Download the Mod

1. On the left side, find the **file explorer**
2. Navigate to: `build` → `libs`
3. Right-click `aicompanion-0.1.0.jar`
4. Click **Download**

### Step 5: Add to SKLauncher

Same as Method 1, Step 4 above.

---

## Method 3: Use GitPod (Fully Free Cloud IDE)

If Replit doesn't work, try **GitPod**:

1. Go to: https://gitpod.io/#https://github.com/nd220970-gif/minecraft-ai-companion-mod
2. Wait for the workspace to load (2-3 minutes)
3. In the terminal, type: `./gradlew build`
4. Wait for the build to finish
5. In the file explorer (left side), find `build/libs/aicompanion-0.1.0.jar`
6. Right-click and download

---

## Quickest Method: GitHub Actions (Recommended)

**GitHub Actions is the fastest and easiest:**

✅ No installation  
✅ Automatic  
✅ Just click a button  
✅ 5 minutes total  

Just follow **Method 1** above.

---

## Download Links for Pre-Built Mod

If the online build doesn't work, download the pre-built mod jar here (updated automatically after each build):

🔗 **[Download Latest Build](https://github.com/nd220970-gif/minecraft-ai-companion-mod/releases)**

(Check the Releases page for the latest `aicompanion-0.1.0.jar`)

---

## Need Help?

If you get stuck:
1. Make sure you're logged into GitHub
2. Try GitPod if GitHub Actions doesn't work
3. Try Replit if both don't work
4. Check that NeoForge 26.3 is installed on your SKLauncher profile

**Next:** Once you have the mod in SKLauncher, test it with `/companion summon` in a world!
