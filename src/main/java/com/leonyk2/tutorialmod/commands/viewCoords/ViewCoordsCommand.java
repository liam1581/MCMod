package com.leonyk2.tutorialmod.commands.viewCoords;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ViewCoordsCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("viewCoords")
                .requires(src -> src.hasPermission(2))
                .then(Commands.argument("player", EntityArgument.player())
                        .executes(ViewCoordsCommand::viewCoords)));
    }

    private static int viewCoords(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        ServerPlayer target = EntityArgument.getPlayer(ctx, "player");

        var pos = target.blockPosition();
        String dim = target.level().dimension().location().toString();

        ctx.getSource().sendSystemMessage(
                Component.literal(target.getGameProfile().getName() + " is at " +
                        pos.getX() + ", " + pos.getY() + ", " + pos.getZ() +
                        " in " + dim)
        );

        return 1;
    }
}
