package com.leonyk2.datagen;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) { super(pOutput); }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LINSENEINTOPF.get(), 1)
                .requires(Items.APPLE)
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Items.NETHER_STAR)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHER_STICK.get(), 1)
                .pattern("S")
                .pattern("S")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_SWORD.get(), 1)
                .pattern("S")
                .pattern("S")
                .pattern("#")
                .define('S', ModItems.SAPPHIRE.get())
                .define('#', ModItems.NETHER_STICK.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COAL_BLOCK, 1)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', Items.CHARCOAL)
                .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(McMod.MOD_ID, "coal_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.QUARTZ, 4)
                .requires(Items.QUARTZ_BLOCK)
                .unlockedBy(getHasName(Items.QUARTZ_BLOCK), has(Items.QUARTZ_BLOCK))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(McMod.MOD_ID, "quartz"));
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  McMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
