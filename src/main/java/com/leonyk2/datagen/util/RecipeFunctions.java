package com.leonyk2.datagen.util;

import com.leonyk2.mcmod.McMod;
import com.simibubi.create.content.equipment.sandPaper.SandPaperPolishingRecipe;
import com.simibubi.create.content.kinetics.crusher.CrushingRecipe;
import com.simibubi.create.content.kinetics.fan.processing.HauntingRecipe;
import com.simibubi.create.content.kinetics.millstone.MillingRecipe;
import com.simibubi.create.content.kinetics.mixer.CompactingRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class RecipeFunctions {
    public static void pressing(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<PressingRecipe> builder =
                new ProcessingRecipeBuilder<>(PressingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output) + "_from_pressing_" + getItemName(input)));

        builder.require(input).output(output, value).build(pWriter);
    }
    public static void pressing(ItemLike input, List<ItemLike> output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<PressingRecipe> builder =
                new ProcessingRecipeBuilder<>(PressingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output.get(0)) + "_from_pressing_" + getItemName(input)));

        builder.require(input);
        for (ItemLike out : output)
            builder.output(out, value);

        builder.build(pWriter);
    }
    public static void crushing(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<CrushingRecipe> builder =
                new ProcessingRecipeBuilder<>(CrushingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output) + "_from_crushing_" + getItemName(input)));

        builder.require(input).output(output, value).build(pWriter);
    }
    public static void crushing(ItemLike input, List<ItemLike> output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<CrushingRecipe> builder =
                new ProcessingRecipeBuilder<>(CrushingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output.get(0)) + "_from_crushing_" + getItemName(input)));

        builder.require(input);
        for (ItemLike out : output)
            builder.output(out, value);

        builder.build(pWriter);
    }
    public static void compacting(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<CompactingRecipe> builder =
                new ProcessingRecipeBuilder<>(CompactingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output) + "_from_compacting_" + getItemName(input)));

        builder.require(input).output(output, value).build(pWriter);
    }
    public static void compacting(ItemLike input, List<ItemLike> output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<CompactingRecipe> builder =
                new ProcessingRecipeBuilder<>(CompactingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output.get(0)) + "_from_compacting_" + getItemName(input)));

        builder.require(input);
        for (ItemLike out : output)
            builder.output(out, value);

        builder.build(pWriter);
    }
    public static void sandpaperPolishing(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<SandPaperPolishingRecipe> builder =
                new ProcessingRecipeBuilder<>(SandPaperPolishingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output) + "_from_sandpaper_polishing_" + getItemName(input)));

        builder.require(input).output(output, value).build(pWriter);
    }
    public static void sandpaperPolishing(ItemLike input, List<ItemLike> output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<SandPaperPolishingRecipe> builder =
                new ProcessingRecipeBuilder<>(SandPaperPolishingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output.get(0)) + "_from_sandpaper_polishing_" + getItemName(input)));

        builder.require(input);
        for (ItemLike out : output)
            builder.output(out, value);

        builder.build(pWriter);
    }
    public static void haunting(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<HauntingRecipe> builder =
                new ProcessingRecipeBuilder<>(HauntingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output) + "_from_haunting_" + getItemName(input)));

        builder.require(input).output(output, value).build(pWriter);
    }
    public static void haunting(ItemLike input, List<ItemLike> output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<HauntingRecipe> builder =
                new ProcessingRecipeBuilder<>(HauntingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output.get(0)) + "_from_haunting_" + getItemName(input)));

        builder.require(input);
        for (ItemLike out : output)
            builder.output(out, value);

        builder.build(pWriter);
    }
    public static void milling(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<MillingRecipe> builder =
                new ProcessingRecipeBuilder<>(MillingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output) + "_from_milling_" + getItemName(input)));

        builder.require(input).output(output, value).build(pWriter);
    }
    public static void milling(ItemLike input, List<ItemLike> output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 1;

        ProcessingRecipeBuilder<MillingRecipe> builder =
                new ProcessingRecipeBuilder<>(MillingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output.get(0)) + "_from_milling_" + getItemName(input)));

        builder.require(input);
        for (ItemLike out : output)
            builder.output(out, value);

        builder.build(pWriter);
    }
    /*
    public static void deploying(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 01;

        ProcessingRecipeBuilder<DeployerApplicationRecipe> builder =
                new ProcessingRecipeBuilder<>(DeployerApplicationRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output) + "_from_deploying_" + getItemName(input)));

        builder.require(input).output(output, value).build(pWriter);
    }
    public static void deploying(ItemLike input, List<ItemLike> output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 01;

        ProcessingRecipeBuilder<DeployerApplicationRecipe> builder =
                new ProcessingRecipeBuilder<>(DeployerApplicationRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output.get(0)) + "_from_deploying_" + getItemName(input)));

        builder.require(input);
        for (ItemLike out : output)
            builder.output(out, value);

        builder.build(pWriter);
    }
    protected static void mixing(ItemLike input, ItemLike output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 01;

        ProcessingRecipeBuilder<MixingRecipe> builder =
                new ProcessingRecipeBuilder<>(MixingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output) + "_from_mixing_" + getItemName(input)));

        builder.require(input).output(output, value).build(pWriter);
    }
    protected static void mixing(ItemLike input, List<ItemLike> output, Consumer<FinishedRecipe> pWriter, int... outputAmount) {
        int value = outputAmount.length > 0 ? outputAmount[0] : 01;

        ProcessingRecipeBuilder<MixingRecipe> builder =
                new ProcessingRecipeBuilder<>(MixingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, getItemName(output.get(0)) + "_from_mixing_" + getItemName(input)));

        builder.require(input);
        for (ItemLike out : output)
            builder.output(out, value);

        builder.build(pWriter);
    }
    */

    public static void oreSmelting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTIme, @NotNull String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    public static void oreBlasting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    public static void oreCooking(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  McMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }



    private static String getItemName(ItemLike pItemLike) {
        return BuiltInRegistries.ITEM.getKey(pItemLike.asItem()).getPath();
    }
    private static String getHasName(ItemLike pItemLike) {
        return "has_" + getItemName(pItemLike);
    }
    private static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... pPredicates) {
        return new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, pPredicates);
    }
    private static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItemLike).build());
    }
}
