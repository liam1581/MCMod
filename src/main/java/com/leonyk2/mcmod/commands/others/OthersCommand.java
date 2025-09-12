package com.leonyk2.mcmod.commands.others;

import com.leonyk2.mcmod.util.Functions;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
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

import static com.leonyk2.mcmod.util.Functions.enchant;

public class OthersCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext ctx) {
        dispatcher.register(
                Commands.literal("randomTickSpeed")
                        .requires(source -> source.hasPermission(0))
                        .then(
                                Commands.argument("number", IntegerArgumentType.integer())
                                        .executes(OthersCommand::rtsCommand))
        );
        dispatcher.register(
                Commands.literal("nv")
                        .requires(source -> source.hasPermission(0))
                        .executes(OthersCommand::nvCommand)
        );
        dispatcher.register(
                Commands.literal("help")
                        .requires(source -> source.hasPermission(0))
                        .executes(OthersCommand::helpCmd)
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

        Functions.runCommand(context, command);
        return 1;
    }

    private static int nvCommand(CommandContext<CommandSourceStack> context) {
        String command = "effect give @a minecraft:night_vision infinite 255 true";

        Functions.runCommand(context, command);
        return 1;
    }

    private static int dicksCommand(CommandContext<CommandSourceStack> context) {
        Functions.runCommand(context, "msg @a schwänze sind lecker 🤤");
        return 1;
    }

    private static int helpCmd(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        Component helpMessage = Component.literal(
                """
                        §6== Help Menu ==§r
                        
                        §eAFK§r
                          §7/afk-init§r        (nur OP)
                          §7/afk§r             AFK gehen
                          §7/un-afk§r          AFK verlassen
                          §7(Bewegen beendet AFK automatisch)
                        
                        §eAnträge§r
                          §7/antrag ...§r      Antrag stellen
                          §7/antrag delete ID§r (eigene; OP: alle löschen)
                          §7/antrag list§r     Anträge listen (OP)
                          §7/antrag accept ID§r Antrag annehmen (OP)
                          §7/antrag deny ID§r  Antrag ablehnen (OP)
                        
                        §eHome (privat)§r
                          §7/home set ID§r     Home setzen
                          §7/home tp ID§r      Zu Home teleportieren
                          §7/home clear ID§r   Home löschen (eigene; OP: alle)
                        
                        §eHome (öffentlich)§r
                          §7/home public set ID§r   Public Home setzen
                          §7/home public tp ID§r    Zu Public Home teleportieren
                          §7/home public clear ID§r Public Home löschen (eigene; OP: alle)
                        
                        §eViewCoords§r
                          §7/viewCoords PLAYER§r (nur OP)
                        
                        §eSonstiges§r
                          §7/nv§r               Nachtsicht für alle Spieler (OP)
                          §7/randomTickSpeed N§r Gamerule ändern (OP)
                          §7/schwänze            /msg @a etwas ;)"""
        );


        player.sendSystemMessage(helpMessage);
        return 1;
    }
}
