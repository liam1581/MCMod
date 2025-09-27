package com.leonyk2.datagen;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
        makeTableBlock(ModBlocks.OAK_TABLE.get(), "minecraft", "oak");
        makeTableBlock(ModBlocks.DARK_OAK_TABLE.get(), "minecraft", "dark_oak");
        makeTableBlock(ModBlocks.BIRCH_TABLE.get(), "minecraft", "birch");
        makeTableBlock(ModBlocks.JUNGLE_TABLE.get(), "minecraft", "jungle");
        makeTableBlock(ModBlocks.SPRUCE_TABLE.get(), "minecraft", "spruce");
        makeTableBlock(ModBlocks.ACACIA_TABLE.get(), "minecraft", "acacia");
        makeTableBlock(ModBlocks.MANGROVE_TABLE.get(), "minecraft", "mangrove");
        makeTableBlock(ModBlocks.CHERRY_TABLE.get(), "minecraft", "cherry");
    }

    private void simpleBlockWithItem(Block block) {
        String blockName = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();

        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().getExistingFile(fromNamespaceAndPath(McMod.MOD_ID,"block/" + blockName)))
                .build());

        models().withExistingParent("item/" + blockName, fromNamespaceAndPath(McMod.MOD_ID, "block/" + blockName));
    }

    private void makeTableBlock(Block block, String namesopace,  String woodName) {
        String blockName = woodName + "_table";

        ModelFile model = models().withExistingParent(blockName, modLoc("block/table_base"))
                .texture("0", fromNamespaceAndPath(namesopace, "block/" + woodName + "_log"))
                .texture("2", fromNamespaceAndPath(namesopace, "block/" + woodName + "_log_top"))
                .texture("particle", fromNamespaceAndPath(namesopace, "block/" + woodName + "_log"));

        simpleBlock(block, model);

        itemModels().getBuilder(blockName)
                .parent(new ModelFile.UncheckedModelFile(modLoc("block/" + blockName)));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(McMod.MOD_ID +
                ":block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath()));
    }
}