package com.leonyk2.mcmod.util;

import com.leonyk2.mcmod.McMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(McMod.MOD_ID, name));
        }
    }
}
