package com.leonyk2.datagen;

import biomesoplenty.api.block.BOPBlocks;
import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.block.ModBlocks;
import com.leonyk2.mcmod.item.ModItems;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.mixer.CompactingRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
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

        // ----- McMod Recipes ----- //
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

        tableRecipe(Blocks.OAK_LOG, ModBlocks.OAK_TABLE.get(), pWriter);
        tableRecipe(Blocks.BIRCH_LOG, ModBlocks.BIRCH_TABLE.get(), pWriter);
        tableRecipe(Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_TABLE.get(), pWriter);
        tableRecipe(Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_TABLE.get(), pWriter);
        tableRecipe(Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_TABLE.get(), pWriter);
        tableRecipe(Blocks.ACACIA_LOG, ModBlocks.ACACIA_TABLE.get(), pWriter);
        tableRecipe(Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_TABLE.get(), pWriter);
        tableRecipe(Blocks.CHERRY_LOG, ModBlocks.CHERRY_TABLE.get(), pWriter);

        tableRecipe(BOPBlocks.FIR_LOG.get(), ModBlocks.FIR_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.REDWOOD_LOG.get(), ModBlocks.REDWOOD_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.MAHOGANY_LOG.get(), ModBlocks.MAHOGANY_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.JACARANDA_LOG.get(), ModBlocks.JACARANDA_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.PALM_LOG.get(), ModBlocks.PALM_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.WILLOW_LOG.get(), ModBlocks.WILLOW_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.DEAD_LOG.get(), ModBlocks.DEAD_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.MAGIC_LOG.get(), ModBlocks.MAGIC_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.UMBRAN_LOG.get(), ModBlocks.UMBRAN_TABLE.get(), pWriter);
        tableRecipe(BOPBlocks.HELLBARK_LOG.get(), ModBlocks.HELLBARK_TABLE.get(), pWriter);


        // ----- Vanilla+ Recipes ----- //
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



        // ----- Create Recipes ----- //
        // ------- Crafting table --- //
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AllItems.BELT_CONNECTOR, 1)
                .pattern("LLL")
                .pattern("LLL")
                .define('L', Ingredient.of(ItemTags.LEAVES))
                .unlockedBy("has_leaves", has(ItemTags.LEAVES))
                .save(pWriter, fromNamespaceAndPath(McMod.MOD_ID, "belt"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.ANDESITE, 2)
                .pattern("LC")
                .define('L', AllPaletteStoneTypes.LIMESTONE.getBaseBlock().get())
                .define('C', Blocks.COBBLESTONE)
                .unlockedBy(getHasName(Blocks.COBBLESTONE), has(Blocks.COBBLESTONE))
                .save(pWriter, fromNamespaceAndPath(McMod.MOD_ID, "andesite"));
        // ------- Recipe Sequences - //
        SequencedAssemblyRecipeBuilder incomp_dia_builder =
                new SequencedAssemblyRecipeBuilder(fromNamespaceAndPath(McMod.MOD_ID, "diamond_from_pressing_sequence_coal"));
        incomp_dia_builder.require(Items.COAL).transitionTo(ModItems.UNCOMPLETE_DIAMOND.get());
        for (int i = 0; i < 5; i++) {
            incomp_dia_builder.addStep(PressingRecipe::new, UnaryOperator.identity());
        }
        incomp_dia_builder.addOutput(Items.DIAMOND, 1.0f).build(pWriter);

        SequencedAssemblyRecipeBuilder incomp_dia_block_builder =
                new SequencedAssemblyRecipeBuilder(fromNamespaceAndPath(McMod.MOD_ID, "diamond_block_from_pressing_sequence_coal"));
        incomp_dia_block_builder.require(Items.COAL_BLOCK).transitionTo(ModItems.UNCOMPLETE_DIAMOND_BLOCK.get());
        for (int i = 0; i < 5; i++) {
            incomp_dia_block_builder.addStep(PressingRecipe::new, UnaryOperator.identity());
        }
        incomp_dia_block_builder.addOutput(Items.DIAMOND_BLOCK, 1.0f).build(pWriter);

        // ------- ProcessingRecipe - //
        ProcessingRecipeBuilder<FillingRecipe> builder =
                new ProcessingRecipeBuilder<>(FillingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, "blaze_burner_from_filling_empty_blaze_burner"));
        builder.require(AllItems.EMPTY_BLAZE_BURNER).require(Fluids.LAVA, 1000).output(AllBlocks.BLAZE_BURNER).build(pWriter);

        ProcessingRecipeBuilder<CompactingRecipe> builder2 =
                new ProcessingRecipeBuilder<>(CompactingRecipe::new, fromNamespaceAndPath(McMod.MOD_ID, "lava_from_heated_compacting"));
        builder2.require(Items.COBBLESTONE).output(Fluids.LAVA, 100).requiresHeat(HeatCondition.HEATED).build(pWriter);
   }

    private void tableRecipe(Block log, Block result, @NotNull Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result)
                .pattern("LLL")
                .pattern("S S")
                .define('L', log)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(log), has(log))
                .save(pWriter);
    }
}
