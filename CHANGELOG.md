# 📜 Changelog & Documentation

---

## v2.6.x
### 2.6.1-r2
- changed the build.gradle so i can run the datagen and then client with one thing (bcs im still lazy) as well as datagen + jar
- also corrected some spelling mistakes in this file (CHANGELOG.md) and changed one mistake where i forgot 2 words

### 2.6.1
- added vanilla+ recipes for blasting cobble/stone/sand

### 2.6.0-r4-r7
- README / CHANGELOG.md testing/modfying

### 2.6.0-r3
- Another changelog update XD (again basically useless)

### 2.6.0-r2
- Changelog changed xD (basically useless again)

### 2.6.0
- Added `sendMessage` function and documentation
- Added `debug testCommands` command

---

## v2.5.0
### r3
- Changed README (so basically this version is useless)

### r2
- Added German translation
- Added a bunch of `@NotNull` annotations
- Added `output.jar` files for each ongoing version

---

## v2.4.1
### r2
- Changed datagen package directory

### Base
- Changed some missed `ResourceLocation` references

---

## v2.3.1
### r3
- Updated `ResourceLocation` usage so IntelliJ IDEA doesn’t scream

### r2
- Added crafting recipe for **Sapphire Sword** and **Nether Stick**

### Base
- Antrag screen shows OP commands only if OP

---

## v2.3.0
- Added `DropdownMenuWidget`
- Antrag screen now uses dropdowns instead of input fields & buttons
- Added `println` function + documentation

---

## v2.2.x
### v2.2.2
- Fixed datagen bug: vanilla recipes now generate in `data/mcmod` instead of `data/minecraft`
- Added JEI to build environment (not required for mod)

### v2.2.2-r2
- Added some `Function` documentation

### v2.2.2-r3
- Removed `#mandatory` from `mods.toml`

### v2.2.1
- Removed unused imports
- Added overload for `runCommand`:
    - `runCommand(CommandSourceStack, String)`
    - `runCommand(String)`

### v2.2.0
- Added testing command that opens a dummy container
- Added `HelloKeybind` (default: **H**) to open AntragScreen
- Added AntragScreen
- Changed `runCommand(CommandContext, String)`

### v2.2.0-r2
- Added `README.md`

---

## v2.1.x
### v2.1.2
- Added `/enchantAll` command
- Added `enchantWithAll` function

### v2.1.1
- Added recipes for **coal block from charcoal** & **quartz from quartz block** to datagen
- Changed mod description

### v2.1.1-r2
- Removed custom `/help` command
- Changed `/randomTickSpeed` and `/nv` permissions to level 2

### v2.1.0
- Added new music disc
- Changed creative mode tab name
- Removed unused translation entries

### v2.1.0-r2
- Added `run-data` to `.gitignore`
- Added music disc texture

---

## v2.0.x
### v2.0.2
- Bug fixes after changing the mod_id

### v2.0.1
- Changed mod_id
- Removed `spur_from_copper_nugget` recipe
- Removed `bevel_from_spur` recipe

### v2.0
- **New Content:**
    - Music discs
    - Datagen system
    - Linseneintopf item
    - Sapphire Sword
    - AFK/Antrag/Home/NBT/ViewCoords commands
    - Coal block from charcoal & quartz from quartz block recipes

- **Known Bugs:**
    - Music discs don’t work (missing sound files)

---

# ℹ️ Info
- For all music discs (except *Ne Leiche*), you must wait a few seconds before the music starts
- JEI added as a dependency (not mandatory, mainly for build environment)
- Updated parchment version
- Known bug: dropdowns allow OP & non-OP actions at the same time
- Working on debug check system

---

# 📚 Documented Functions
- `runCommand` (both overloads)
- `enchant`
- `enchantWithAll`
- `println`
- `sendMessage`

---

# 🍳 Recipes

**Coal Block (from Charcoal)**  
- CCC
- CCC
- CCC
- C = Charcoal → Coal Block

**Sapphire (from Nether Stars)**  
- SSS
- SSS
- SSS
- S = Nether Star → Sapphire

**Nether Star Stick (from Sapphire)**  
- S
- S
- S = Sapphire → Nether Star Stick

**Sapphire Sword**  
- S
- S
- \#
- S = Sapphire
- \# = Nether Star Stick → Sapphire Sword

**Quartz (from Quartz Block)** *(Shapeless)*
- Quartz Block → 4 Quartz

---

# 🎵 Items
- Music Discs:
    - `beats/beats bb`
    - `crush/crush bb`
    - `tage wach/tage wach bb`
    - `leiche`
- Linseneintopf
- Sapphire Sword
- Sapphire
- Nether Star Stick

---

# ⌨️ Commands

### `/afk`
- `/afk-init` — initializes AFK scoreboard (OP only)
- `/afk` — marks player as AFK
- `/un-afk` — un-AFKs player

### `/viewCoords`
- Outputs coordinates and dimension of given player

### `/nbt`
- `/dumpNbt` — prints held item’s NBT (console only)
- `/listItemNbtTags` — attempts to print all valid NBT tags (not fully working + console only)

### `/home`
- `/home public/private set` — sets a home
- `/home public/private tp` — teleports to home
- `/home public/private clear` — clears home (special behavior for public homes + OPs)

### `/antrag`
- `/antrag` — creates an antrag with text
- `/antrag delete` — deletes an antrag by ID (slightly buggy)
- `/antrag list` — lists all antrags (more info for OPs)
- `/antrag accept` — accepts an antrag (OP only)
- `/antrag deny` — denies an antrag (OP only)
- `/antrag special` — creates an antrag for another user (OP only)
- `/antrag special custom` — creates an antrag for a custom username (OP only)

### Other Commands
- `/randomTickSpeed` — sets random tick speed (OP only)
- `/nv` — gives all players infinite night vision (OP only)
- `/enchantB` — vanilla `/enchant` but allows levels up to 255 (OP only)
- `/enchantAll` — enchants held item with all enchantments at level 255 (except thorns & curses) (OP only)

### `/debug`
- `/debug testCommands` — runs all mod commands (except itself)

---

# 🖥️ Screens
- **Antrag screen**: GUI equivalent of `/antrag` (no special support)

---

# ⌨️ Keybinds
- `H` (default) — opens Antrag screen (configurable in settings)

---

# 🧩 Widgets
- `DropdownWidget`
