package com.leonyk2.mcmod.commands.hide_and_seek;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;

public class Has {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("hide_and_seek")
                        .then(Commands.argument("player", EntityArgument.player())
                                .then(Commands.literal("small").executes(commandContext -> {

                                    return 1;
                                })).then(Commands.literal("normal").executes(commandContext -> {

                                    return 1;
                                }))));
    }
}