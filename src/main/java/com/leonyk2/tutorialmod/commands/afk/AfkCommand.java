package com.leonyk2.tutorialmod.commands.afk;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;

public class AfkCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("afk-init")
                        .requires(source -> source.hasPermission(2))
                        .executes(AfkCommand::initAfk)
        );

        dispatcher.register(
                Commands.literal("afk")
                        .requires(source -> source.hasPermission(0))
                        .executes(AfkCommand::markAfk)
        );

        dispatcher.register(
                Commands.literal("un-afk")
                        .requires(source -> source.hasPermission(0))
                        .executes(AfkCommand::unmarkAfkCommand)
        );
    }

    private static int initAfk(CommandContext<CommandSourceStack> context) {
        Scoreboard sb = context.getSource().getServer().getScoreboard();

        Objective obj = sb.getObjective("AFK");
        if (obj == null) {
            obj = sb.addObjective(
                    "AFK",
                    ObjectiveCriteria.DUMMY,
                    Component.literal("AFK Players"),
                    ObjectiveCriteria.RenderType.INTEGER
            );
        }

        // 1 = sidebar
        sb.setDisplayObjective(1, obj);

        context.getSource().sendSuccess(() -> Component.literal("AFK scoreboard initialized."), true);
        return 1;
    }


    private static int markAfk(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        Scoreboard sb = player.getScoreboard();
        Objective obj = sb.getObjective("AFK");

        if (obj == null) {
            player.sendSystemMessage(Component.literal("AFK scoreboard not initialized. Ask an admin to run /afk-init."));
            return 0;
        }

        sb.getOrCreatePlayerScore(player.getScoreboardName(), obj).setScore(1);

        player.sendSystemMessage(Component.literal(player.getName().getString() + " is now AFK."));
        return 1;
    }

    private static int unmarkAfkCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        return unmarkAfk(player);
    }

    public static int unmarkAfk(ServerPlayer player) {
        Scoreboard sb = player.getScoreboard();
        Objective obj = sb.getObjective("AFK");

        if (obj == null) return 0;

        sb.resetPlayerScore(player.getScoreboardName(), obj);

        player.sendSystemMessage(Component.literal(player.getName().getString() + " is no longer AFK."));
        return 1;
    }
}
