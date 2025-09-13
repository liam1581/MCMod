package com.leonyk2.mcmod.item;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, McMod.MOD_ID);

    public static RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 2147483647, 0, new Item.Properties()));
    public static RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> NETHER_STICK = ITEMS.register("nether_stick",
            () -> new Item(new Item.Properties()));

    public static RegistryObject<Item> LINSENEINTOPF = ITEMS.register("linseneintopf",
            () -> new Item(new Item.Properties().food(ModFoods.LINSENEINTOPF)));

    public static RegistryObject<Item> BEATS_MUSIC_DISC = ITEMS.register("beats_music_disc",
            () -> new RecordItem(6, ModSounds.BEATS, new Item.Properties().stacksTo(1), 3540));
    public static RegistryObject<Item> BEATS_BB_MUSIC_DISC = ITEMS.register("beats_bb_music_disc",
            () -> new RecordItem(6, ModSounds.BEATS_BB, new Item.Properties().stacksTo(1), 3540));
    public static RegistryObject<Item> CRUSH_MUSIC_DISC = ITEMS.register("crush_music_disc",
            () -> new RecordItem(6, ModSounds.CRUSH, new Item.Properties().stacksTo(1), 4100));
    public static RegistryObject<Item> CRUSH_BB_MUSIC_DISC = ITEMS.register("crush_bb_music_disc",
            () -> new RecordItem(6, ModSounds.CRUSH_BB, new Item.Properties().stacksTo(1), 4100));
    public static RegistryObject<Item> TAGE_WACH_MUSIC_DISC = ITEMS.register("tage_wach_music_disc",
            () -> new RecordItem(6, ModSounds.TAGE_WACH, new Item.Properties().stacksTo(1), 4100));
    public static RegistryObject<Item> TAGE_WACH_BB_MUSIC_DISC = ITEMS.register("tage_wach_bb_music_disc",
            () -> new RecordItem(6, ModSounds.TAGE_WACH_BB, new Item.Properties().stacksTo(1), 4100));
    public static RegistryObject<Item> LEICHE_MUSIC_DISC = ITEMS.register("leiche_music_disc",
            () -> new RecordItem(6, ModSounds.LEICHE, new Item.Properties().stacksTo(1), 6540));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
