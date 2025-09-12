package com.leonyk2.tutorialmod.util;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class Functions {
    /**
     * Runs the mc command provided in the arguments
     * @param context the command context
     * @param command the command that should be run
     */
    public static void runCommand(CommandContext<CommandSourceStack> context, String command) {
        context.getSource().getServer().getCommands().performPrefixedCommand(context.getSource(), command);
    }

    /**
     * Modified enchant function (original in {@link net.minecraft.world.item.ItemStack#enchant})
     * @param item the item to enchant
     * @param pEnchantment the enchantment
     * @param pLevel the level (is an int variable type but only enchants between 0-255, which is hard-coded in the game)
     */
    public static void enchant(ItemStack item, Enchantment pEnchantment, int pLevel) {
        item.getOrCreateTag();
        if (!item.getTag().contains("Enchantments", 9)) {
            item.getTag().put("Enchantments", new ListTag());
        }

        ListTag listtag = item.getTag().getList("Enchantments", 10);
        listtag.add(EnchantmentHelper.storeEnchantment(EnchantmentHelper.getEnchantmentId(pEnchantment), pLevel));
    }
}
