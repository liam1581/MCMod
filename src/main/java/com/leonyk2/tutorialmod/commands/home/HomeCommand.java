package com.leonyk2.tutorialmod.commands.home;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class HomeCommand {

    private static PublicHomesData getPublicData(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                PublicHomesData::load,
                PublicHomesData::new,
                PUBLIC_HOMES_ID
        );
    }

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("home")
                        // PRIVATE HOMES
                        .then(
                                Commands.literal("set")
                                        .then(Commands.argument("id", IntegerArgumentType.integer(0, 255))
                                                .executes(ctx -> setPrivateHome(ctx.getSource().getPlayerOrException(),
                                                        IntegerArgumentType.getInteger(ctx, "id")))
                                        )
                        )
                        .then(
                                Commands.literal("tp")
                                        .then(Commands.argument("id", IntegerArgumentType.integer(0, 255))
                                                .executes(ctx -> tpPrivateHome(ctx.getSource().getPlayerOrException(),
                                                        IntegerArgumentType.getInteger(ctx, "id")))
                                        )
                        )
                        .then(
                                Commands.literal("clear")
                                        .then(Commands.argument("id", IntegerArgumentType.integer(0, 255))
                                                .executes(ctx -> clearPrivateHome(ctx.getSource().getPlayerOrException(),
                                                        IntegerArgumentType.getInteger(ctx, "id")))
                                        )
                        )

                        // PUBLIC HOMES
                        .then(
                                Commands.literal("public")
                                        .then(
                                                Commands.literal("set")
                                                        .then(Commands.argument("id", IntegerArgumentType.integer(0, 255))
                                                                .executes(ctx -> setPublicHome(ctx.getSource().getPlayerOrException(),
                                                                        IntegerArgumentType.getInteger(ctx, "id")))
                                                        )
                                        )
                                        .then(
                                                Commands.literal("tp")
                                                        .then(Commands.argument("id", IntegerArgumentType.integer(0, 255))
                                                                .executes(ctx -> tpPublicHome(ctx.getSource().getPlayerOrException(),
                                                                        IntegerArgumentType.getInteger(ctx, "id")))
                                                        )
                                        )
                                        .then(
                                                Commands.literal("clear")
                                                        .then(Commands.argument("id", IntegerArgumentType.integer(0, 255))
                                                                .executes(ctx -> clearPublicHome(ctx.getSource(),
                                                                        ctx.getSource().getPlayerOrException(),
                                                                        IntegerArgumentType.getInteger(ctx, "id")))
                                                        )
                                        )
                        )
        );
    }

    private static final String PUBLIC_HOMES_ID = "public_homes";

    private static int setPrivateHome(ServerPlayer player, int id) {
        CompoundTag persistent = player.getPersistentData();
        CompoundTag homes = persistent.getCompound("Homes");

        CompoundTag homeTag = new CompoundTag();
        homeTag.putDouble("x", player.getX());
        homeTag.putDouble("y", player.getY());
        homeTag.putDouble("z", player.getZ());

        homes.put(String.valueOf(id), homeTag);
        persistent.put("Homes", homes);

        player.sendSystemMessage(Component.literal("Home " + id + " set at " +
                player.getX() + ", " + player.getY() + ", " + player.getZ()));
        return 1;
    }

    private static int tpPrivateHome(ServerPlayer player, int id) {
        CompoundTag homes = player.getPersistentData().getCompound("Homes");
        if (!homes.contains(String.valueOf(id))) {
            player.sendSystemMessage(Component.literal("No private home found at id " + id));
            return 0;
        }

        CompoundTag tag = homes.getCompound(String.valueOf(id));
        double x = tag.getDouble("x");
        double y = tag.getDouble("y");
        double z = tag.getDouble("z");

        player.teleportTo(player.serverLevel(), x, y, z, player.getYRot(), player.getXRot());
        player.sendSystemMessage(Component.literal("Teleported to home " + id));
        return 1;
    }

    private static int clearPrivateHome(ServerPlayer player, int id) {
        CompoundTag homes = player.getPersistentData().getCompound("Homes");
        if (!homes.contains(String.valueOf(id))) {
            player.sendSystemMessage(Component.literal("No private home found at id " + id));
            return 0;
        }

        homes.remove(String.valueOf(id));
        player.getPersistentData().put("Homes", homes);

        player.sendSystemMessage(Component.literal("Home " + id + " cleared."));
        return 1;
    }

    // ================================
    // PUBLIC HOMES (SavedData)
    // ================================
    private static int setPublicHome(ServerPlayer player, int id) {
        ServerLevel level = player.serverLevel();
        PublicHomesData data = getPublicData(level);

        CompoundTag homeTag = new CompoundTag();
        homeTag.putDouble("x", player.getX());
        homeTag.putDouble("y", player.getY());
        homeTag.putDouble("z", player.getZ());
        homeTag.putString("owner", player.getGameProfile().getName());

        data.homes.put(id, homeTag);
        data.setDirty();

        player.sendSystemMessage(Component.literal("Public home " + id + " set at " +
                player.getX() + ", " + player.getY() + ", " + player.getZ()));
        return 1;
    }

    private static int tpPublicHome(ServerPlayer player, int id) {
        PublicHomesData data = getPublicData(player.serverLevel());
        CompoundTag tag = data.homes.get(id);

        if (tag == null) {
            player.sendSystemMessage(Component.literal("No public home found at id " + id));
            return 0;
        }

        double x = tag.getDouble("x");
        double y = tag.getDouble("y");
        double z = tag.getDouble("z");

        player.teleportTo(player.serverLevel(), x, y, z, player.getYRot(), player.getXRot());
        player.sendSystemMessage(Component.literal("Teleported to public home " + id));
        return 1;
    }

    private static int clearPublicHome(CommandSourceStack source, ServerPlayer player, int id) {
        PublicHomesData data = getPublicData(player.serverLevel());
        CompoundTag tag = data.homes.get(id);

        if (tag == null) {
            player.sendSystemMessage(Component.literal("No public home at id " + id));
            return 0;
        }

        String owner = tag.getString("owner");
        boolean isOwner = owner.equals(player.getGameProfile().getName());
        boolean isOp = source.hasPermission(2);

        if (!isOwner && !isOp) {
            player.sendSystemMessage(Component.literal("You cannot clear public home " + id +
                    " (owned by " + owner + ")"));
            return 0;
        }

        data.homes.remove(id);
        data.setDirty();

        player.sendSystemMessage(Component.literal("Public home " + id + " cleared."));
        return 1;
    }
}
