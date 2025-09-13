package com.leonyk2.mcmod.item;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5, 4, 25,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.LINSENEINTOPF.get())),
            ResourceLocation.fromNamespaceAndPath(McMod.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
}
