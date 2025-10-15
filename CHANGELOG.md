# 📜 Changelog & Documentation

---
## v3.5.x
### v3.5.1-r2
- added limesand -> White Phosphorous recipe

### v3.5.1
- Bugfix were the language translations where wrong for the Antrag screen

### v3.5.0-r2
- README.md change

### v3.5.0
- Added Creatify block & Sapphire Block
- Added crafting recipe for Sapphire Block and Creatify Block
- Added "crafting recipe" for Creative Motor, Creative Crate, Creative Fluid tank
- Added Loot table for Cretify Block/Sapphire Block
- Changed BlockTags so the Tables need a StoneTool to get dropped, Sapphire Block needs IronTool, Creatify Block needs NetheriteTool
- Changed nutrition and saturationMod for Linseneintopf to 50 & 10.0f
- Changed AttackSpeedModifier for Sapphire Sword to -1
- Moved ModCreativeModeTab
- Changed some things in the CHANGELOG.md
- Added Botarium, Create-New-Age, CreateBB/BB Edibles, SophisticadedBackpacks/SophisticatedCore mods to libs folder
- Botarium and Create New Age are mandatory, any version
- output.jar is from now on mcmod-version.jar

---

## v3.4.x
### v3.4.1
- added recipe for crafting edible blue stuff from create bb/bb edibles
- removed testing command
- removed PlayerJoin thingy
- Changed stuff in CHANGELOG.md (early naming scheme for versions and some other stuff)

### v3.4.0-r3
- exactly same as 3.4.0-r2 but different i guess QwQ
- maybe something changed because i completely re-ran data (deleted generated datagen stuff and just ran it again)

### v3.4.0-r2
- changed "new ResourceLocation()" back to fromNamespaceAndPath() in BlockStateProvider

### v3.4.0
- added BOP tables as well as corresponding lootTABLES and block/item models

---

## v3.3.x
### v3.3.0
- added drop lootTABLES
- added BlockTags so Tables can be mined with axes faster
- removed the ponder (that was just unused code)

---

## v3.2.x
### v3.2.2
- added crafting recipes for tables
- added create mod crafting recipes:
  - added automatable andesite
  - added different belt recipe
  - added different way to "fill" blaze burner

### v3.2.1-r3
- changed the way tables (their blockstates/block models/item models) are created in the datagen

### v3.2.1-r2
- just the jar file of the prev version because i forgor 👉👈

### v3.2.1
- cleanup (removed unused imports)
- made warnings BE GONE

### v3.2.0
- added **ModLanguageProvider** as datagen for de_de and en_us languages
- added unused ponder testing item (for create mod [all the code for that is commented out, and it doesn't have a translation/texture])
- moved DropdownWidgetTranslatable to its own class
- changed both DropdownWidget and DropdownWidgetTranslatable to always add a blank option at the start
- custom block type for tables
- added decoration tables (every wood type in the game)

---

### v3.1.0
- added incomplete diamond block (ITEM)
- changed incomplete diamond to be stackable to 1
- added translation for the block (ITEM) as well as a shitty texture xD

---

### v3.0.0
- McMod is now a create mod addon
- removed the runDataAndClient & runDataAndJar things bcs they dont (fucking) work
- added recipe functions for create mod pressing, crushing, mixing and more
- added diamond recipe (pressing a coal 25 times or a coal block 25 times for a diamond block)
- added Incomplete diamond (for the above recipes)

---

## v2.6.x
### v2.6.1-r2
- changed the build.gradle so i can run the datagen and then client with one thing (bcs im still lazy) as well as datagen + jar
- also corrected some spelling mistakes in this file (CHANGELOG.md) and changed one mistake where i forgot 2 words

### v2.6.1
- added vanilla+ recipes for blasting cobble/stone/sand

### v2.6.0-r4-r7
- README / CHANGELOG.md testing/modfying

### v2.6.0-r3
- Another changelog update XD (again basically useless)

### v2.6.0-r2
- Changelog changed xD (basically useless again)

### v2.6.0
- Added `sendMessage` function and documentation
- Added `debug testCommands` command

---

## v2.5.0
### v2.5.0-r3
- Changed README (so basically this version is useless)

### v2.5.0-r2
- Added German translation
- Added a bunch of `@NotNull` annotations
- Added `output.jar` files for each ongoing version

---

## v2.4.1
### v2.4.1-r2
- Changed datagen package directory

### v2.4.1
- Changed some missed `ResourceLocation` references

---

## v2.3.x
### v2.3.1-r3
- Updated `ResourceLocation` usage so IntelliJ IDEA doesn’t scream

### v2.3.1-r2
- Added crafting recipe for **Sapphire Sword** and **Nether Stick**

### v2.3.1
- Antrag screen shows OP commands only if OP

## v2.3.0
- Added `DropdownMenuWidget`
- Antrag screen now uses dropdowns instead of input fields & buttons
- Added `println` function + documentation

---

## v2.2.x
### v2.2.2-r3
- Removed `#mandatory` from `mods.toml`

### v2.2.2-r2
- Added some `Function` documentation

### v2.2.2
- Fixed datagen bug: vanilla recipes now generate in `data/mcmod` instead of `data/minecraft`
- Added JEI to build environment (not required for mod)

### v2.2.1
- Removed unused imports
- Added overload for `runCommand`:
    - `runCommand(CommandSourceStack, String)`
    - `runCommand(String)`

### v2.2.0-r2
- Added `README.md`

### v2.2.0
- Added testing command that opens a dummy container
- Added `HelloKeybind` (default: **H**) to open AntragScreen
- Added AntragScreen
- Changed `runCommand(CommandContext, String)`

---

## v2.1.x
### v2.1.2
- Added `/enchantAll` command
- Added `enchantWithAll` function

### v2.1.1-r2
- Removed custom `/help` command
- Changed `/randomTickSpeed` and `/nv` permissions to level 2

### v2.1.1
- Added recipes for **coal block from charcoal** & **quartz from quartz block** to datagen
- Changed mod description

### v2.1.0-r2
- Added `run-data` to `.gitignore`
- Added music disc texture

### v2.1.0
- Added new music disc
- Changed creative mode tab name
- Removed unused translation entries

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

---

# ℹ️ Info
- For all music discs (except *Ne Leiche*), you must wait a few seconds before the music starts
- JEI added as a dependency (not mandatory, mainly for build environment)
- Create added as dependency (mandatory)
- Updated parchment version
- Known bug: dropdowns allow OP & non-OP actions at the same time (in Antrag screen)
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

**Tables**
- LLL
- S S
- L = Log
- S = Stick → Log Name-Table

**Quartz (from Quartz Block)** *(Shapeless)*
- Quartz Block → 4 Quartz

**Diamond/Diamond Block** *(Create Recipe Sequence)*
- Pressing coal/coal block 25 times resulting in the corresponding item

**Edible White/Blue Stuff** *(Shapeless)*
- White/Blue Stuff → Edible White/Blue Stuff

---

# Items
- Music Discs:
    - `beats/beats bb`
    - `crush/crush bb`
    - `tage wach/tage wach bb`
    - `leiche`
- Linseneintopf
- Sapphire Sword
- Sapphire
- Nether Star Stick
- Incomplete Diamond
- Incomplete Diamond Block

# Blocks
- Tables (based on the wood types in game)

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
- **Test screen**: GUI for testing stuff i created sometimes, isn't added in the version, just existing not used code

---

# ⌨️ Keybinds
- `H` (default) — opens Antrag screen (configurable in settings)
- `P` (default, in code) - opens Test screen (not used, just existing in code)

---

# 🧩 Widgets
- `DropdownWidget`
- `DropdownWidgetTranslatable` same as DropdownWidget just takes list of id's that are being handled as Component.translatable's
