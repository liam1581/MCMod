package com.leonyk2.datagen.loot;

import com.leonyk2.mcmod.block.ModBlocks;
import com.leonyk2.mcmod.compat.CompatHandler;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.OAK_TABLE.get());
        this.dropSelf(ModBlocks.BIRCH_TABLE.get());
        this.dropSelf(ModBlocks.ACACIA_TABLE.get());
        this.dropSelf(ModBlocks.DARK_OAK_TABLE.get());
        this.dropSelf(ModBlocks.JUNGLE_TABLE.get());
        this.dropSelf(ModBlocks.SPRUCE_TABLE.get());
        this.dropSelf(ModBlocks.MANGROVE_TABLE.get());
        this.dropSelf(ModBlocks.CHERRY_TABLE.get());

        if (CompatHandler.isBopLoaded()) {
            this.dropSelf(ModBlocks.FIR_TABLE.get());
            this.dropSelf(ModBlocks.REDWOOD_TABLE.get());
            this.dropSelf(ModBlocks.MAHOGANY_TABLE.get());
            this.dropSelf(ModBlocks.JACARANDA_TABLE.get());
            this.dropSelf(ModBlocks.PALM_TABLE.get());
            this.dropSelf(ModBlocks.WILLOW_TABLE.get());
            this.dropSelf(ModBlocks.DEAD_TABLE.get());
            this.dropSelf(ModBlocks.MAGIC_TABLE.get());
            this.dropSelf(ModBlocks.UMBRAN_TABLE.get());
            this.dropSelf(ModBlocks.HELLBARK_TABLE.get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
