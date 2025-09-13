package com.leonyk2.mcmod.util;

import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class Functions {
    /**
     * Runs the mc command provided in the arguments
     * @param source the CommandSourceStack
     * @param command the command that should be run
     */
    public static void runCommand(CommandSourceStack source, String command) {
        source.getServer().getCommands().performPrefixedCommand(source, command);
    }

    /**
     * Runs the mc command provided in the argument
     * @param command the command that should be run
     */
    public static void runCommand(String command) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.connection.sendCommand(command);
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

    /**
     * Enchants the given item with every enchantment (including mod enchantments) except curses and thorns, on lvl 255
     * @param item the item to be enchanted
     * @return the item stack with the enchantments
     */
    public static ItemStack enchantWithAll(ItemStack item) {
        for (Enchantment en : ForgeRegistries.ENCHANTMENTS) {
            ResourceLocation id = ForgeRegistries.ENCHANTMENTS.getKey(en);

            if (en == null) continue;
            if (en.isCurse()) continue;
            if (id != null && id.toString().equals("minecraft:thorns")) continue;

            enchant(item, en, 255);
        }
        return item;
    }

    /**
     * System.out.println(String) but without the whole System.out thing (bcs it annoys me)
     * @param x the String argument
     */
    public static void println(String x) {
        System.out.println(x);
    }
}
