package com.leonyk2.datagen.util;

import com.leonyk2.mcmod.block.ModBlocks;
import com.leonyk2.mcmod.item.ModItems;
import com.leonyk2.mcmod.keybind.Keybinds;
import com.leonyk2.mcmod.sound.ModSounds;
import net.minecraftforge.common.data.LanguageProvider;

public class LangFunctions {
    public static void addLang(LanguageProvider lang, String locale) {
        lang.add("commands.mcmod.schwänze.text", "Schwänze sind lecker :D");

        assert ModSounds.BEATS.getId() != null;
        assert ModSounds.BEATS_BB.getId() != null;
        assert ModSounds.CRUSH.getId() != null;
        assert ModSounds.CRUSH_BB.getId() != null;
        assert ModSounds.TAGE_WACH.getId() != null;
        assert ModSounds.TAGE_WACH_BB.getId() != null;
        assert ModSounds.LEICHE.getId() != null;
        // Sounds
        lang.add("sounds." + ModSounds.BEATS.getId().toLanguageKey(), "Beats");
        lang.add("sounds." + ModSounds.BEATS_BB.getId().toLanguageKey(), "Beats (BB)");
        lang.add("sounds." + ModSounds.CRUSH.getId().toLanguageKey(), "Crush");
        lang.add("sounds." + ModSounds.CRUSH_BB.getId().toLanguageKey(), "Crush (BB)");
        lang.add("sounds." + ModSounds.TAGE_WACH.getId().toLanguageKey(), "7 Tage Wach");
        lang.add("sounds." + ModSounds.TAGE_WACH_BB.getId().toLanguageKey(), "7 Tage Wach (BB)");
        lang.add("sounds." + ModSounds.LEICHE.getId().toLanguageKey(), "Ne Leiche");

        // Music Discs / Desc
        lang.add(ModItems.BEATS_BB_MUSIC_DISC.get(), "150 Beats (BB) - Music Disc");
        lang.add(ModItems.BEATS_MUSIC_DISC.get(), "150 Beats - Music Disc");
        lang.add(ModItems.TAGE_WACH_BB_MUSIC_DISC.get(), "7 Tage Wach (BB) - Music Disc");
        lang.add(ModItems.TAGE_WACH_MUSIC_DISC.get(), "7 Tage Wach - Music Disc");
        lang.add(ModItems.LEICHE_MUSIC_DISC.get(), "Ne Leiche - Music Disc");
        lang.add(ModItems.CRUSH_BB_MUSIC_DISC.get(), "Crush (BB) - Music Disc");
        lang.add(ModItems.CRUSH_MUSIC_DISC.get(), "Crush - Music Disc");

        lang.add("item.mcmod." + ModItems.BEATS_BB_MUSIC_DISC.get() + ".desc", "Rob & Chris - 150 Beats (BB)");
        lang.add("item.mcmod." + ModItems.BEATS_MUSIC_DISC.get() + ".desc", "Rob & Chris - 150 Beats");
        lang.add("item.mcmod." + ModItems.CRUSH_BB_MUSIC_DISC.get() + ".desc", "DrDonk - Crush (BB)");
        lang.add("item.mcmod." + ModItems.CRUSH_MUSIC_DISC.get() + ".desc", "DrDonk - Crush");
        lang.add("item.mcmod." + ModItems.TAGE_WACH_BB_MUSIC_DISC.get() + ".desc", "TekkSchuster - 7 Tage Wach (BB)");
        lang.add("item.mcmod." + ModItems.TAGE_WACH_MUSIC_DISC.get() + ".desc", "TekkSchuster - 7 Tage Wach");
        lang.add("item.mcmod." + ModItems.LEICHE_MUSIC_DISC.get() + ".desc", "SDP & Sido - Ne Leiche");

        if (locale.equalsIgnoreCase("en_us")) {
            // Items
            lang.add(ModItems.LINSENEINTOPF.get(), "Linseneintopf");
            lang.add(ModItems.INCOMPLETE_DIAMOND.get(), "Incomplete Diamond");
            lang.add(ModItems.INCOMPLETE_DIAMOND_BLOCK.get(), "Incomplete Diamond Block");
            lang.add(ModItems.SAPPHIRE.get(), "Sapphire");
            lang.add(ModItems.SAPPHIRE_SWORD.get(), "Sapphire Sword");
            lang.add(ModItems.NETHER_STICK.get(), "Nether Star Stick");

            // Blocks
            lang.add(ModBlocks.CREATIFY_BLOCK.get(), "Creatify Block");
            lang.add(ModBlocks.SAPPHIRE_BLOCK.get(), "Sapphire Block");
            lang.add(ModBlocks.PONDER_TEST_BLOCK.get(), "Ponder Test Block");
            lang.add(ModBlocks.OAK_TABLE.get(), "Oak Table");
            lang.add(ModBlocks.DARK_OAK_TABLE.get(), "Dark Oak Table");
            lang.add(ModBlocks.BIRCH_TABLE.get(), "Birch Table");
            lang.add(ModBlocks.JUNGLE_TABLE.get(), "Jungle Table");
            lang.add(ModBlocks.SPRUCE_TABLE.get(), "Spruce Table");
            lang.add(ModBlocks.ACACIA_TABLE.get(), "Acacia Table");
            lang.add(ModBlocks.MANGROVE_TABLE.get(), "Mangrove Table");
            lang.add(ModBlocks.CHERRY_TABLE.get(), "Cherry Table");
            // BOP
            lang.add(ModBlocks.FIR_TABLE.get(), "Fir Table");
            lang.add(ModBlocks.REDWOOD_TABLE.get(), "Redwood Table");
            lang.add(ModBlocks.MAHOGANY_TABLE.get(), "Mahogany Table");
            lang.add(ModBlocks.JACARANDA_TABLE.get(), "Jacaranda Table");
            lang.add(ModBlocks.PALM_TABLE.get(), "Palm Table");
            lang.add(ModBlocks.WILLOW_TABLE.get(), "Willow Table");
            lang.add(ModBlocks.DEAD_TABLE.get(), "Dead Table");
            lang.add(ModBlocks.MAGIC_TABLE.get(), "Magic Table");
            lang.add(ModBlocks.UMBRAN_TABLE.get(), "Umbran Table");
            lang.add(ModBlocks.HELLBARK_TABLE.get(), "Hellbark Table");

            // Creative Mode Tabs
            lang.add("creativetab.mcmod_tab", "McMod Tab");
            lang.add("creativetab.mcmod_tables", "McMod Tables");

            // Keybinds / Category's
            lang.add(Keybinds.ANTRAG_KEY.getCategory(), "McMod");
            lang.add(Keybinds.ANTRAG_KEY.getName(), "Antrag Key");

            // Screens & subcategory's
            lang.add("screens.mcmod.antrag.name", "Antrag Menu");
            lang.add("screens.mcmod.antrag.button.submit", "Submit");

            lang.add("screens.mcmod.antrag.OPTIONS.antrag", "Antrag");
            lang.add("screens.mcmod.antrag.OPTIONS.delete", "Delete");
            lang.add("screens.mcmod.antrag.OPTIONS.list", "List");
            lang.add("screens.mcmod.antrag.OPTIONS.add", "Accept");
            lang.add("screens.mcmod.antrag.OPTIONS.deny", "Deny");

            // Commands
            lang.add("commands.mcmod.afk.players", "AFK Players");
            lang.add("commands.mcmod.afk.scoreboard_init", "AFK Scoreboard initialized");
            lang.add("commands.mcmod.afk.scoreboard_not_init", "AFK scoreboard not initialized. Ask an admin to run /afk-init.");
            lang.add("commands.mcmod.afk.is_afk", "is now AFK");
            lang.add("commands.mcmod.afk.is_no_afk", "is no longer AFK");
        } else if (locale.equalsIgnoreCase("de_de")) {
            // Items
            lang.add(ModItems.LINSENEINTOPF.get(), "Linseneintopf");
            lang.add(ModItems.INCOMPLETE_DIAMOND.get(), "Unvollständiger Diamant");
            lang.add(ModItems.INCOMPLETE_DIAMOND_BLOCK.get(), "Unvollständiger Diamant Block");
            lang.add(ModItems.SAPPHIRE.get(), "Saphir");
            lang.add(ModItems.SAPPHIRE_SWORD.get(), "Saphir Schwert");
            lang.add(ModItems.NETHER_STICK.get(), "Nether stern stock");

            // Blocks
            lang.add(ModBlocks.CREATIFY_BLOCK.get(), "Kreatifizierungs Block");
            lang.add(ModBlocks.SAPPHIRE_BLOCK.get(), "Saphir Block");
            lang.add(ModBlocks.PONDER_TEST_BLOCK.get(), "Ponder Test Block");
            lang.add(ModBlocks.OAK_TABLE.get(), "Eichen Tisch");
            lang.add(ModBlocks.DARK_OAK_TABLE.get(), "Schwarzeichen Tisch");
            lang.add(ModBlocks.BIRCH_TABLE.get(), "Birken Tisch");
            lang.add(ModBlocks.JUNGLE_TABLE.get(), "Jungel Tisch");
            lang.add(ModBlocks.SPRUCE_TABLE.get(), "Fichten Tisch");
            lang.add(ModBlocks.ACACIA_TABLE.get(), "Akazien Tisch");
            lang.add(ModBlocks.MANGROVE_TABLE.get(), "Mangroven Tisch");
            lang.add(ModBlocks.CHERRY_TABLE.get(), "Kirsch Tisch");

            // Creative Mode Tabs
            lang.add("creativetab.mcmod_tab", "McMod Tab");
            lang.add("creativetab.mcmod_tab_bop", "McMod Tab BOP");

            // Keybinds / Category's
            lang.add(Keybinds.ANTRAG_KEY.getCategory(), "McMod");
            lang.add(Keybinds.ANTRAG_KEY.getName(), "Antrag Knopf");

            // Screens & subcategory's
            lang.add("screens.mcmod.antrag.name", "Antrag Menü");
            lang.add("screens.mcmod.antrag.button.submit", "Abgeben");

            lang.add("screens.mcmod.antrag.OPTIONS.antrag", "Antrag");
            lang.add("screens.mcmod.antrag.OPTIONS.delete", "Löschen");
            lang.add("screens.mcmod.antrag.OPTIONS.list", "Listen");
            lang.add("screens.mcmod.antrag.OPTIONS.add", "Akzeptieren");
            lang.add("screens.mcmod.antrag.OPTIONS.deny", "Ablehnen");

            // Commands
            lang.add("commands.mcmod.afk.players", "AFK Spieler");
            lang.add("commands.mcmod.afk.scoreboard_init", "AFK Scoreboard initialisiert");
            lang.add("commands.mcmod.afk.scoreboard_not_init", "AFK scoreboard nicht initialisiert. Frage einen admin ob er /afk-init ausführen kann.");
            lang.add("commands.mcmod.afk.is_afk", "ist jetzt AFK");
            lang.add("commands.mcmod.afk.is_no_afk", "ist nicht mehr AFK");
        }
    }
}
