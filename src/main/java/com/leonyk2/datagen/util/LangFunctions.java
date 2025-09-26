package com.leonyk2.datagen.util;

import com.leonyk2.mcmod.block.ModBlocks;
import com.leonyk2.mcmod.item.ModItems;
import com.leonyk2.mcmod.keybind.Keybinds;
import com.leonyk2.mcmod.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;

public class LangFunctions {
    public static void addLang(BiConsumer<String, String> adder, BiConsumer<Item, String> itemAdder, BiConsumer<Block, String> blockAdder, String locale) {
        if (locale.equalsIgnoreCase("en_us")) {
            // Items
            itemAdder.accept(ModItems.LINSENEINTOPF.get(), "Linseneintopf");
            itemAdder.accept(ModItems.UNCOMPLETE_DIAMOND.get(), "Incomplete Diamond");
            itemAdder.accept(ModItems.UNCOMPLETE_DIAMOND_BLOCK.get(), "Incomplete Diamond Block");
            itemAdder.accept(ModItems.SAPPHIRE.get(), "Sapphire");
            itemAdder.accept(ModItems.SAPPHIRE_SWORD.get(), "Sapphire Sword");
            itemAdder.accept(ModItems.NETHER_STICK.get(), "Nether Star Stick");

            // Blocks
            //adder.accept(ModBlocks.TEST_PONDER.get(), "Ponder test Block");
            blockAdder.accept(ModBlocks.OAK_TABLE.get(), "Oak Table");
            blockAdder.accept(ModBlocks.DARK_OAK_TABLE.get(), "Dark Oak Table");
            blockAdder.accept(ModBlocks.BIRCH_TABLE.get(), "Birch Table");
            blockAdder.accept(ModBlocks.JUNGLE_TABLE.get(), "Jungle Table");
            blockAdder.accept(ModBlocks.SPRUCE_TABLE.get(), "Spruce Table");
            blockAdder.accept(ModBlocks.ACACIA_TABLE.get(), "Acacia Table");
            blockAdder.accept(ModBlocks.MANGROVE_TABLE.get(), "Mangrove Table");
            blockAdder.accept(ModBlocks.CHERRY_TABLE.get(), "Cherry Table");

            // Creative Mode Tabs
            adder.accept("creativetab.tutorial_tab", "McMod Tab");

            // Keybinds / Category's
            adder.accept(Keybinds.ANTRAG_KEY.getCategory(), "McMod");
            adder.accept(Keybinds.ANTRAG_KEY.getName(), "Antrag Key");

            // Screens & subcategory's
            adder.accept("screens.mcmod.antarg.name", "Antrag Menu");
            adder.accept("screens.mcmod.antarg.button.submit", "Submit");

            adder.accept("screens.mcmod.antarg.OPTIONS.antrag", "Antrag");
            adder.accept("screens.mcmod.antarg.OPTIONS.delete", "Delete");
            adder.accept("screens.mcmod.antarg.OPTIONS.list", "List");
            adder.accept("screens.mcmod.antarg.OPTIONS.accept", "Accept");
            adder.accept("screens.mcmod.antarg.OPTIONS.deny", "Deny");

            // Commands
            adder.accept("commands.mcmod.afk.players", "AFK Players");
            adder.accept("commands.mcmod.afk.scoreboard_init", "AFK Scoreboard initialized");
            adder.accept("commands.mcmod.afk.scoreboard_not_init", "AFK scoreboard not initialized. Ask an admin to run /afk-init.");
            adder.accept("commands.mcmod.afk.is_afk", "is now AFK");
            adder.accept("commands.mcmod.afk.is_no_afk", "is no longer AFK");

            adder.accept("commands.mcmod.schwänze.text", "Schwänze sind lecker :D");

            // Sounds
            adder.accept("sounds." + ModSounds.BEATS.getId().toLanguageKey(), "Beats");
            adder.accept("sounds." + ModSounds.BEATS_BB.getId().toLanguageKey(), "Beats (BB)");
            adder.accept("sounds." + ModSounds.CRUSH.getId().toLanguageKey(), "Crush");
            adder.accept("sounds." + ModSounds.CRUSH_BB.getId().toLanguageKey(), "Crush (BB)");
            adder.accept("sounds." + ModSounds.TAGE_WACH.getId().toLanguageKey(), "7 Tage Wach");
            adder.accept("sounds." + ModSounds.TAGE_WACH_BB.getId().toLanguageKey(), "7 Tage Wach (BB)");
            adder.accept("sounds." + ModSounds.LEICHE.getId().toLanguageKey(), "Ne Leiche");

            // Music Discs / Desc
            itemAdder.accept(ModItems.BEATS_BB_MUSIC_DISC.get(), "150 Beats (BB) - Music Disc");
            itemAdder.accept(ModItems.BEATS_MUSIC_DISC.get(), "150 Beats - Music Disc");
            itemAdder.accept(ModItems.TAGE_WACH_BB_MUSIC_DISC.get(), "7 Tage Wach (BB) - Music Disc");
            itemAdder.accept(ModItems.TAGE_WACH_MUSIC_DISC.get(), "7 Tage Wach - Music Disc");
            itemAdder.accept(ModItems.LEICHE_MUSIC_DISC.get(), "Ne Leiche - Music Disc");
            itemAdder.accept(ModItems.CRUSH_BB_MUSIC_DISC.get(), "Crush (BB)- Music Disc");
            itemAdder.accept(ModItems.CRUSH_MUSIC_DISC.get(), "Crush - Music Disc");

            adder.accept("item.mcmod." + ModItems.BEATS_BB_MUSIC_DISC.get() + ".desc", "Rob & Chris - 150 Beats (BB)");
            adder.accept("item.mcmod." + ModItems.BEATS_MUSIC_DISC.get() + ".desc", "Rob & Chris - 150 Beats");
            adder.accept("item.mcmod." + ModItems.CRUSH_BB_MUSIC_DISC.get() + ".desc", "DrDonk - Crush (BB)");
            adder.accept("item.mcmod." + ModItems.CRUSH_MUSIC_DISC.get() + ".desc", "DrDonk - Crush");
            adder.accept("item.mcmod." + ModItems.TAGE_WACH_BB_MUSIC_DISC.get() + ".desc", "TekkSchuster - 7 Tage Wach (BB)");
            adder.accept("item.mcmod." + ModItems.TAGE_WACH_MUSIC_DISC.get() + ".desc", "TekkSchuster - 7 Tage Wach");
            adder.accept("item.mcmod." + ModItems.LEICHE_MUSIC_DISC.get() + ".desc", "SDP & Sido - Ne Leiche");
        } else if (locale.equalsIgnoreCase("de_de")) {
            // Items
            itemAdder.accept(ModItems.LINSENEINTOPF.get(), "Linseneintopf");
            itemAdder.accept(ModItems.UNCOMPLETE_DIAMOND.get(), "Unvollständiger Diamant");
            itemAdder.accept(ModItems.UNCOMPLETE_DIAMOND_BLOCK.get(), "Unvollständiger Diamant Block");
            itemAdder.accept(ModItems.SAPPHIRE.get(), "Saphir");
            itemAdder.accept(ModItems.SAPPHIRE_SWORD.get(), "Saphir Schwert");
            itemAdder.accept(ModItems.NETHER_STICK.get(), "Nether stern stock");

            // Blocks
            //adder.accept(ModBlocks.TEST_PONDER.get(), "Ponder test Block");
            blockAdder.accept(ModBlocks.OAK_TABLE.get(), "Eichen Tisch");
            blockAdder.accept(ModBlocks.DARK_OAK_TABLE.get(), "Schwarzeichen Tisch");
            blockAdder.accept(ModBlocks.BIRCH_TABLE.get(), "Birken Tisch");
            blockAdder.accept(ModBlocks.JUNGLE_TABLE.get(), "Jungel Tisch");
            blockAdder.accept(ModBlocks.SPRUCE_TABLE.get(), "Fichten Tisch");
            blockAdder.accept(ModBlocks.ACACIA_TABLE.get(), "Akazien Tisch");
            blockAdder.accept(ModBlocks.MANGROVE_TABLE.get(), "Mangroven Tisch");
            blockAdder.accept(ModBlocks.CHERRY_TABLE.get(), "Kirsch Tisch");

            // Creative Mode Tabs
            adder.accept("creativetab.tutorial_tab", "McMod Tab");

            // Keybinds / Category's
            adder.accept(Keybinds.ANTRAG_KEY.getCategory(), "McMod");
            adder.accept(Keybinds.ANTRAG_KEY.getName(), "Antrag Knopf");

            // Screens & subcategory's
            adder.accept("screens.mcmod.antarg.name", "Antrag Menü");
            adder.accept("screens.mcmod.antarg.button.submit", "Abgeben");

            adder.accept("screens.mcmod.antarg.OPTIONS.antrag", "Antrag");
            adder.accept("screens.mcmod.antarg.OPTIONS.delete", "Löschen");
            adder.accept("screens.mcmod.antarg.OPTIONS.list", "Listen");
            adder.accept("screens.mcmod.antarg.OPTIONS.accept", "Akzeptieren");
            adder.accept("screens.mcmod.antarg.OPTIONS.deny", "Ablehnen");

            // Commands
            adder.accept("commands.mcmod.afk.players", "AFK Spieler");
            adder.accept("commands.mcmod.afk.scoreboard_init", "AFK Scoreboard initialisiert");
            adder.accept("commands.mcmod.afk.scoreboard_not_init", "AFK scoreboard nicht initialisiert. Frage einen admin ob er /afk-init ausführen kann.");
            adder.accept("commands.mcmod.afk.is_afk", "ist jetzt AFK");
            adder.accept("commands.mcmod.afk.is_no_afk", "ist nicht mehr AFK");

            adder.accept("commands.mcmod.schwänze.text", "Schwänze sind lecker :D");

            // Sounds
            adder.accept("sounds." + ModSounds.BEATS.getId().toLanguageKey(), "Beats");
            adder.accept("sounds." + ModSounds.BEATS_BB.getId().toLanguageKey(), "Beats (BB)");
            adder.accept("sounds." + ModSounds.CRUSH.getId().toLanguageKey(), "Crush");
            adder.accept("sounds." + ModSounds.CRUSH_BB.getId().toLanguageKey(), "Crush (BB)");
            adder.accept("sounds." + ModSounds.TAGE_WACH.getId().toLanguageKey(), "7 Tage Wach");
            adder.accept("sounds." + ModSounds.TAGE_WACH_BB.getId().toLanguageKey(), "7 Tage Wach (BB)");
            adder.accept("sounds." + ModSounds.LEICHE.getId().toLanguageKey(), "Ne Leiche");

            // Music Discs / Desc
            itemAdder.accept(ModItems.BEATS_BB_MUSIC_DISC.get(), "150 Beats (BB) - Music Disc");
            itemAdder.accept(ModItems.BEATS_MUSIC_DISC.get(), "150 Beats - Music Disc");
            itemAdder.accept(ModItems.TAGE_WACH_BB_MUSIC_DISC.get(), "7 Tage Wach (BB) - Music Disc");
            itemAdder.accept(ModItems.TAGE_WACH_MUSIC_DISC.get(), "7 Tage Wach - Music Disc");
            itemAdder.accept(ModItems.LEICHE_MUSIC_DISC.get(), "Ne Leiche - Music Disc");
            itemAdder.accept(ModItems.CRUSH_BB_MUSIC_DISC.get(), "Crush (BB)- Music Disc");
            itemAdder.accept(ModItems.CRUSH_MUSIC_DISC.get(), "Crush - Music Disc");

            adder.accept("item.mcmod." + ModItems.BEATS_BB_MUSIC_DISC.get() + ".desc", "Rob & Chris - 150 Beats (BB)");
            adder.accept("item.mcmod." + ModItems.BEATS_MUSIC_DISC.get() + ".desc", "Rob & Chris - 150 Beats");
            adder.accept("item.mcmod." + ModItems.CRUSH_BB_MUSIC_DISC.get() + ".desc", "DrDonk - Crush (BB)");
            adder.accept("item.mcmod." + ModItems.CRUSH_MUSIC_DISC.get() + ".desc", "DrDonk - Crush");
            adder.accept("item.mcmod." + ModItems.TAGE_WACH_BB_MUSIC_DISC.get() + ".desc", "TekkSchuster - 7 Tage Wach (BB)");
            adder.accept("item.mcmod." + ModItems.TAGE_WACH_MUSIC_DISC.get() + ".desc", "TekkSchuster - 7 Tage Wach");
            adder.accept("item.mcmod." + ModItems.LEICHE_MUSIC_DISC.get() + ".desc", "SDP & Sido - Ne Leiche");
        }
    }
}
