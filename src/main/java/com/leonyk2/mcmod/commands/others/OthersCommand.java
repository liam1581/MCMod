package com.leonyk2.mcmod.commands.others;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ResourceArgument;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;


import java.util.Optional;

import static com.leonyk2.mcmod.util.Functions.*;

public class OthersCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext ctx) {
        dispatcher.register(
                Commands.literal("rts")
                        .requires(source -> source.hasPermission(2))
                        .then(
                                Commands.argument("number", IntegerArgumentType.integer())
                                        .executes(OthersCommand::rtsCommand))
        );
        dispatcher.register(
                Commands.literal("nv")
                        .requires(source -> source.hasPermission(2))
                        .executes(OthersCommand::nvCommand)
        );
        dispatcher.register(
                Commands.literal("schwänze")
                        .requires(source -> source.hasPermission(0))
                        .executes(OthersCommand::dicksCommand)
        );
        dispatcher.register(
                Commands.literal("enchantB")
                        .requires(source -> source.hasPermission(2)) // Permission level
                        .then(Commands.argument("player", EntityArgument.player())
                                .then(Commands.argument("enchantment", ResourceArgument.resource(ctx, Registries.ENCHANTMENT))
                                        .then(Commands.argument("lvl", IntegerArgumentType.integer(0, 255)) // 0-255
                                                .executes(context -> {
                                                    ServerPlayer target = EntityArgument.getPlayer(context, "player");

                                                    Holder.Reference<Enchantment> enchant = ResourceArgument.getEnchantment(context, "enchantment");

                                                    int level = IntegerArgumentType.getInteger(context, "lvl");

                                                    return customEnchant(target, enchant.value(), level, context.getSource());
                                                })))));
        dispatcher.register(
                Commands.literal("enchantAll")
                        .requires(source -> source.hasPermission(2))
                        .executes(OthersCommand::enchantAll)
        );
        dispatcher.register(
                Commands.literal("smelt")
                        .requires(commandSourceStack ->  commandSourceStack.hasPermission(0))
                        .executes(commandContext -> {
                            CommandSourceStack source = commandContext.getSource();

                            ServerPlayer player = source.getPlayerOrException();
                            ItemStack held = player.getMainHandItem();

                            if (held.isEmpty()) {
                                source.sendFailure(Component.literal("You dumb fuck, you gotta have something IN HAND to smelt!"));
                                return 0;
                            }

                            Level lvl = player.level();
                            RecipeManager recipeMan = lvl.getRecipeManager();

                            SimpleContainer container = new SimpleContainer(held);

                            Optional<SmeltingRecipe> recipe = recipeMan.getRecipeFor(RecipeType.SMELTING, container, lvl);

                            if (recipe.isEmpty()) {
                                source.sendFailure(Component.literal("No recipe found for smelting!"));
                                return 0;
                            }

                            ItemStack result = recipe.get().getResultItem(lvl.registryAccess());
                            if (result.isEmpty()) {
                                return 0;
                            }

                            ItemStack smelted = result.copy();
                            smelted.setCount(result.getCount() * held.getCount());

                            player.setItemInHand(InteractionHand.MAIN_HAND, smelted);

                            source.sendSuccess(
                                    () -> Component.literal("Smelted held items"),
                                    false);

                            return 1;
                        })
        );
    }

    private static int customEnchant(ServerPlayer player, Enchantment enchant, int level, CommandSourceStack source) {
        ItemStack stack = player.getMainHandItem();

        if (stack.isEmpty()) {
            source.sendFailure(Component.literal("The target player is not holding any item in their main hand!"));
            return 0;
        }

        enchant(stack, enchant, level);

        return 1;

    }

    private static int rtsCommand(CommandContext<CommandSourceStack> context) {
        int number = IntegerArgumentType.getInteger(context, "number");
        String command = "gamerule randomTickSpeed " + number;

        runCommand(command);
        return 1;
    }

    private static int nvCommand(CommandContext<CommandSourceStack> context) {
        String command = "effect give @a minecraft:night_vision infinite 255 true";

        runCommand(command);
        return 1;
    }

    private static int dicksCommand(CommandContext<CommandSourceStack> context) {
        runCommand("msg @a " + Component.translatable("commands.mcmod.schwänze.text").getString() +  "🤤");
        return 1;
    }

    private static int enchantAll(CommandContext<CommandSourceStack> context) {
        if (context.getSource().getEntity() instanceof ServerPlayer player) {
            ItemStack stack = player.getMainHandItem();

            if (stack.isEmpty()) {
                return 0;
            }

            enchantWithAll(stack);
        }
        return 1;
    }
}
