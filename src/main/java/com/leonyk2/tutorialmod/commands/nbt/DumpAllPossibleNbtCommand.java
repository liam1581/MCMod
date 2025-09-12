package com.leonyk2.tutorialmod.commands.nbt;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class DumpAllPossibleNbtCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("listItemNbtTags")
                        .requires(src -> src.hasPermission(2)) // ops only
                        .executes(ctx -> {
                            String[] tags = {
                                    "display:{Name:'{\"text\":\"Custom Name\"}'}",
                                    "display:{Lore:['{\"text\":\"Line 1\"}','{\"text\":\"Line 2\"}']}",
                                    "Enchantments:[{id:\"minecraft:sharpness\",lvl:5s}]",
                                    "Unbreakable:1b",
                                    "Damage:<int>",
                                    "AttributeModifiers:[{AttributeName:\"generic.max_health\",Amount:4,Operation:0,UUID:[I;1,2,3,4],Slot:\"mainhand\"}]",
                                    "HideFlags:1",
                                    "CustomModelData:<int>",
                                    "CanDestroy:[\"minecraft:stone\"]",
                                    "CanPlaceOn:[\"minecraft:dirt\"]",
                                    "BlockEntityTag:{...}  (for items that place blocks, e.g. shulker boxes)",
                                    "SkullOwner:{Id:<uuid>,Name:\"Player\",Properties:{textures:[{Value:\"base64\"}]}}",
                                    "Potion:\"minecraft:strength\"",
                                    "CustomPotionEffects:[{Id:1,Amplifier:1,Duration:200}]",
                                    "StoredEnchantments:[{id:\"minecraft:mending\",lvl:1s}]",
                                    "map: filled_map specific data",
                                    "fireworks:{Flight:1,Explosions:[...]}"
                            };

                            System.out.println("=== Known Item NBT Tags ===");
                            for (String t : tags) {
                                System.out.println(t);
                            }
                            System.out.println("===========================");

                            ctx.getSource().sendSystemMessage(Component.literal("Printed known item NBT tags to console."));
                            return 1;
                        }));
    }
}
