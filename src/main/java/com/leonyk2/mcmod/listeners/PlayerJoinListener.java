package com.leonyk2.mcmod.listeners;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.leonyk2.mcmod.util.Functions.runCommand;

@Mod.EventBusSubscriber
public class PlayerJoinListener {
    public static boolean enabled = false; // toggled by command

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!enabled) return;

        String playerName = event.getEntity().getGameProfile().getName();
        if ("mronien".equalsIgnoreCase(playerName)) {
            System.out.println("The special player has joined: " + playerName);
            runCommand("kick MrOnien");
        }
    }
}
