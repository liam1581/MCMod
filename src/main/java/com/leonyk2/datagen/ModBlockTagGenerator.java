package com.leonyk2.datagen;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, McMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.ACACIA_TABLE.get(),
                        ModBlocks.BIRCH_TABLE.get(),
                        ModBlocks.DARK_OAK_TABLE.get(),
                        ModBlocks.CHERRY_TABLE.get(),
                        ModBlocks.MANGROVE_TABLE.get(),
                        ModBlocks.JUNGLE_TABLE.get(),
                        ModBlocks.OAK_TABLE.get(),
                        ModBlocks.SPRUCE_TABLE.get());
    }
}
