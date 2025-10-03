package com.leonyk2.mcmod.commands.others;

import com.leonyk2.mcmod.listeners.PlayerJoinListener;
import com.mojang.brigadier.Command;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Objects;

import static com.leonyk2.mcmod.util.Functions.*;

public class OthersCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext ctx) {
        dispatcher.register(
                Commands.literal("randomTickSpeed")
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
                Commands.literal("testing")
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();

                            Objects.requireNonNull(player.getServer()).execute(() -> {
                                // Run only on client
                                player.connection.send(
                                        new net.minecraft.network.protocol.game.ClientboundOpenScreenPacket(
                                                0, // dummy container id
                                                net.minecraft.world.inventory.MenuType.GENERIC_9x1, // dummy menu type
                                                net.minecraft.network.chat.Component.literal("Opening HiScreen"))
                                );
                            });

                            return 1;
                        }));
        dispatcher.register(
                Commands.literal("enableJoinCheck")
                        .executes(ctx2 -> {
                            PlayerJoinListener.enabled = true;
                            ctx2.getSource().sendSuccess(() -> Component.literal("Join check enabled"), true);
                            return Command.SINGLE_SUCCESS;
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

        runCommand(context.getSource(), command);
        return 1;
    }

    private static int nvCommand(CommandContext<CommandSourceStack> context) {
        String command = "effect give @a minecraft:night_vision infinite 255 true";

        runCommand(context.getSource(), command);
        return 1;
    }

    private static int dicksCommand(CommandContext<CommandSourceStack> context) {
        runCommand(context.getSource(), "msg @a " + Component.translatable("commands.mcmod.schwänze.text").getString() +  "🤤");
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
