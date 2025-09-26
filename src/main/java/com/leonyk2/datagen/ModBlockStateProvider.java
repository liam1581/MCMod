package com.leonyk2.datagen;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, McMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.OAK_TABLE.get());
        simpleBlockWithItem(ModBlocks.DARK_OAK_TABLE.get());
        simpleBlockWithItem(ModBlocks.BIRCH_TABLE.get());
        simpleBlockWithItem(ModBlocks.JUNGLE_TABLE.get());
        simpleBlockWithItem(ModBlocks.SPRUCE_TABLE.get());
        simpleBlockWithItem(ModBlocks.ACACIA_TABLE.get());
        simpleBlockWithItem(ModBlocks.MANGROVE_TABLE.get());
        simpleBlockWithItem(ModBlocks.CHERRY_TABLE.get());
    }

    private void simpleBlockWithItem(Block block) {
        String blockName = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();

        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().getExistingFile(fromNamespaceAndPath(McMod.MOD_ID,"block/" + blockName)))
                .build());

        models().withExistingParent("item/" + blockName, fromNamespaceAndPath(McMod.MOD_ID, "block/" + blockName));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(McMod.MOD_ID +
                ":block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath()));
    }
}