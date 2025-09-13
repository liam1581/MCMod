package com.leonyk2.datagen;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
        public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, McMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.SAPPHIRE_SWORD);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.LINSENEINTOPF);
        simpleItem(ModItems.NETHER_STICK);

        diskItem(ModItems.LEICHE_MUSIC_DISC);
        diskItem(ModItems.BEATS_BB_MUSIC_DISC);
        diskItem(ModItems.BEATS_MUSIC_DISC);
        diskItem(ModItems.CRUSH_BB_MUSIC_DISC);
        diskItem(ModItems.CRUSH_MUSIC_DISC);
        diskItem(ModItems.TAGE_WACH_BB_MUSIC_DISC);
        diskItem(ModItems.TAGE_WACH_MUSIC_DISC);
    }

    private void diskItem(RegistryObject<Item> item) {
        assert item.getId() != null;
        withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(McMod.MOD_ID, "item/disc"));
    }

    private void simpleItem(RegistryObject<Item> item) {
        assert item.getId() != null;
        withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(McMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void handheldItem(RegistryObject<Item> item) {
        assert item.getId() != null;
        withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(McMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    /*
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        assert item.getId() != null;
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(McMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    */
}
