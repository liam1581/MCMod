package com.leonyk2.mcmod.commands.debug;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

import static com.leonyk2.mcmod.util.Functions.runCommand;

public class DebugCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("debug")
                        .then(Commands.literal("testCommands")
                                .executes(DebugCommand::debug_testCommands)));
    }

    private static int debug_testCommands(CommandContext<CommandSourceStack> commandSourceStackCommandContext) {
        runCommand("afk-init");
        runCommand("afk");
        runCommand("un-afk");
        runCommand("home set 0");
        runCommand("tp @s ~ ~ ~10");
        runCommand("home set 1");
        runCommand("home tp 0");
        runCommand("home tp 1");
        runCommand("home public set 10");
        runCommand("home tp 10");
        runCommand("home public tp 10");
        runCommand("home tp 0");
        runCommand("nv");
        runCommand("randomTickSpeed 10");
        runCommand("schwänze");
        runCommand("give @s netherite_sword 36");
        Minecraft.getInstance().player.getInventory().selected = 0;
        runCommand("enchantB @s minecraft:sharpness 255");
        Minecraft.getInstance().player.getInventory().selected = 1;
        runCommand("enchantAll");
        runCommand("viewCoords @s");
        runCommand("antrag TEST");
        runCommand("antrag list");
        runCommand("antrag accept 0");
        runCommand("antrag list");
        runCommand("antrag deny 0");
        runCommand("antrag list");
        runCommand("antrag delete 0");
        runCommand("antrag list");
        runCommand("clear @s netherite_sword");
        return 1;
    }
}