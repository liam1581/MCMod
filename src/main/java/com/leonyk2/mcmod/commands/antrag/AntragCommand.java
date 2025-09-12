package com.leonyk2.mcmod.commands.antrag;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.Objects;

public class AntragCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("antrag")

                // --- Normal create ---
                .then(Commands.argument("text", StringArgumentType.greedyString())
                        .executes(ctx -> {
                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                            String text = StringArgumentType.getString(ctx, "text");
                            AntragManager.createAntrag(player, text);
                            return 1;
                        }))

                // --- Delete ---
                .then(Commands.literal("delete")
                        .then(Commands.argument("id", IntegerArgumentType.integer(0))
                                .executes(ctx -> {
                                    ServerPlayer player = ctx.getSource().getPlayerOrException();
                                    int id = IntegerArgumentType.getInteger(ctx, "id");
                                    boolean success = AntragManager.deleteAntrag(player, id);
                                    ctx.getSource().sendSystemMessage(
                                            Component.literal(success ? "Antrag " + id + " löschen" : " fehlgeschlagen!")
                                    );
                                    return success ? 1 : 0;
                                })))

                // --- List ---
                .then(Commands.literal("list")
                        .executes(ctx -> {
                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                            boolean isOp = ctx.getSource().hasPermission(2);

                            var list = isOp ? AntragManager.listAll() : AntragManager.listByPlayer(player);

                            if (list.isEmpty()) {
                                ctx.getSource().sendSystemMessage(Component.literal("Keine Anträge gefunden"));
                            } else {
                                for (AntragManager.Antrag a : list) {
                                    String status = switch (a.status) {
                                        case ACCEPTED -> " §aAKZEPTIERT";
                                        case DENIED -> " §cABGELEHNT";
                                        default -> "";
                                    };
                                    // Pass the whole Antrag to playerName
                                    String line = a.id + ": \"" + a.text + "\" by " +
                                            playerName(ctx.getSource(), a) + status;
                                    ctx.getSource().sendSystemMessage(Component.literal(line));
                                }
                            }
                            return 1;
                        }))

                // --- Accept ---
                .then(Commands.literal("accept")
                        .requires(src -> src.hasPermission(2))
                        .then(Commands.argument("id", IntegerArgumentType.integer(0))
                                .executes(ctx -> {
                                    int id = IntegerArgumentType.getInteger(ctx, "id");
                                    boolean ok = AntragManager.setStatus(id, AntragManager.Status.ACCEPTED);
                                    ctx.getSource().sendSystemMessage(
                                            Component.literal(ok ? "Antrag " + id + " akzeptiert" : "Falsche Antrag ID")
                                    );
                                    return ok ? 1 : 0;
                                })))

                // --- Deny ---
                .then(Commands.literal("deny")
                        .requires(src -> src.hasPermission(2))
                        .then(Commands.argument("id", IntegerArgumentType.integer(0))
                                .executes(ctx -> {
                                    int id = IntegerArgumentType.getInteger(ctx, "id");
                                    boolean ok = AntragManager.setStatus(id, AntragManager.Status.DENIED);
                                    ctx.getSource().sendSystemMessage(
                                            Component.literal(ok ? "Antrag " + id + " abgelehnt" : "Falsche Antrag ID")
                                    );
                                    return ok ? 1 : 0;
                                })))

                // --- Special ---
                .then(Commands.literal("special")
                        .requires(src -> src.hasPermission(2))
                .then(Commands.argument("player", EntityArgument.player())
                        .then(Commands.argument("text", StringArgumentType.greedyString())
                                .executes(ctx -> {
                                    ServerPlayer target = EntityArgument.getPlayer(ctx, "player");
                                    String text = StringArgumentType.getString(ctx, "text");

                                    int id = AntragManager.createAntragFor(target, text);

                                    ctx.getSource().sendSystemMessage(
                                            Component.literal("Special Antrag (ID: " + id + ") submitted for " +
                                                    target.getGameProfile().getName())
                                    );
                                    target.sendSystemMessage(
                                            Component.literal("A special Antrag (ID: " + id + ") was submitted for you!")
                                    );
                                    return 1;
                                })
                        )
                )

                // 2️⃣ New "custom" variant: any username
                .then(Commands.literal("custom")
                        .then(Commands.argument("username", StringArgumentType.word())
                                .then(Commands.argument("text", StringArgumentType.greedyString())
                                        .executes(ctx -> {
                                            String username = StringArgumentType.getString(ctx, "username");
                                            String text = StringArgumentType.getString(ctx, "text");

                                            int id = AntragManager.createAntragForCustom(username, text);

                                            ctx.getSource().sendSystemMessage(
                                                    Component.literal("Custom special Antrag (ID: " + id + ") submitted for " + username)
                                            );
                                            return 1;
                                        })
                                )
                        )
                )
                )

        );
    }

    private static String playerName(CommandSourceStack src, AntragManager.Antrag antrag) {
        if (antrag.author != null) {
            // Online/registered player
            var server = src.getServer();
            var profile = Objects.requireNonNull(server.getProfileCache()).get(antrag.author);
            return profile.map(GameProfile::getName).orElse("Unknown");
        } else {
            // Custom/Offline author
            return AntragManager.getCustomAuthorName(antrag.id);
        }
    }
}
