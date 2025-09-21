package com.leonyk2.datagen;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.item.ModItems;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) { super(pOutput); }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
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



        oreBlasting(pWriter, List.of(Items.COBBLESTONE), RecipeCategory.MISC, Items.STONE, 0.25f, 100, "stone");
        oreBlasting(pWriter, List.of(Items.STONE), RecipeCategory.MISC, Items.SMOOTH_STONE, 0.25f, 100, "stone");
        oreBlasting(pWriter, List.of(Items.SAND), RecipeCategory.MISC, Items.GLASS, 0.25f, 100, "sand");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COAL_BLOCK, 1)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', Items.CHARCOAL)
                .unlockedBy(getHasName(Items.CHARCOAL), has(Items.CHARCOAL))
                .save(pWriter, fromNamespaceAndPath(McMod.MOD_ID, "coal_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.QUARTZ, 4)
                .requires(Items.QUARTZ_BLOCK)
                .unlockedBy(getHasName(Items.QUARTZ_BLOCK), has(Items.QUARTZ_BLOCK))
                .save(pWriter, fromNamespaceAndPath(McMod.MOD_ID, "quartz"));


        SequencedAssemblyRecipeBuilder builder =
                new SequencedAssemblyRecipeBuilder(fromNamespaceAndPath(McMod.MOD_ID, "diamond_from_pressing_sequence_coal"));
        builder.require(Items.COAL);
        builder.transitionTo(ModItems.UNCOMPLETE_DIAMOND.get());
        builder.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder.addOutput(Items.DIAMOND, 1.0f);
        builder.build(pWriter);

        SequencedAssemblyRecipeBuilder builder2 =
                new SequencedAssemblyRecipeBuilder(fromNamespaceAndPath(McMod.MOD_ID, "diamond_block_from_pressing_sequence_coal"));
        builder2.require(Items.COAL_BLOCK);
        builder2.transitionTo(ModItems.UNCOMPLETE_DIAMOND.get());
        builder2.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder2.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder2.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder2.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder2.addStep(PressingRecipe::new, UnaryOperator.identity());
        builder2.addOutput(Items.DIAMOND_BLOCK, 1.0f);
        builder2.build(pWriter);
    }
}
