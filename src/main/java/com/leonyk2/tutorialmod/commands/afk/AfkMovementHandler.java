package com.leonyk2.tutorialmod.commands.afk;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber

public class AfkMovementHandler {
	private static final Map<ServerPlayer, Vec3> lastPositions = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return; // run once per tick at end
        if (!(event.player instanceof ServerPlayer player)) return;

        // Track current vs last pos
        Vec3 currentPos = player.position();
        Vec3 lastPos = lastPositions.get(player);

        // Update last pos
        lastPositions.put(player, currentPos);

        // If no previous position yet, skip
        if (lastPos == null) return;

        // Check for movement
        boolean moved = !currentPos.equals(lastPos);
        if (!moved) return;

        // Check scoreboard to see if player is AFK
        var scoreboard = player.getScoreboard();
        var objective = scoreboard.getObjective("AFK");
        if (objective == null) return;

        if (scoreboard.hasPlayerScore(player.getScoreboardName(), objective)) {
            int score = scoreboard.getOrCreatePlayerScore(player.getScoreboardName(), objective).getScore();
            if (score == 1) {
                // Call the same un-AFK logic as the /un-afk command
                AfkCommand.unmarkAfk(player);
            }
        }
    }
}
