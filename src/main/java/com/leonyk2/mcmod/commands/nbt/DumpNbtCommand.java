package com.leonyk2.mcmod.commands.nbt;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class DumpNbtCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("dumpNbt")
                        .requires(src -> src.hasPermission(2))
                        .executes(DumpNbtCommand::dumpNbt)
        );
    }

    private static int dumpNbt(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        ServerPlayer player = ctx.getSource().getPlayerOrException();
        var stack = player.getMainHandItem();

        if (stack.isEmpty()) {
            ctx.getSource().sendSystemMessage(Component.literal("U not holding an item dumbass!"));
            return 0;
        }

        CompoundTag tag = stack.save(new CompoundTag());

        System.out.println("=== NBT Dump ===");
        System.out.println(tag);
        System.out.println("================");

        ctx.getSource().sendSystemMessage(Component.literal("NBT for held be pwinted :3"));

        return 1;
    }
}
