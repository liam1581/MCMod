package com.leonyk2.mcmod.item;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.block.ModBlocks;
import com.leonyk2.mcmod.compat.CompatHandler;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, McMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MCMOD_TAB = CREATIVE_MODE_TAB.register("mcmod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LINSENEINTOPF.get()))
                    .title(Component.translatable("creativetab.mcmod_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.LINSENEINTOPF.get());
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ModItems.NETHER_STICK.get());

                        pOutput.accept(ModItems.BEATS_MUSIC_DISC.get());
                        pOutput.accept(ModItems.BEATS_BB_MUSIC_DISC.get());
                        pOutput.accept(ModItems.CRUSH_MUSIC_DISC.get());
                        pOutput.accept(ModItems.CRUSH_BB_MUSIC_DISC.get());
                        pOutput.accept(ModItems.TAGE_WACH_MUSIC_DISC.get());
                        pOutput.accept(ModItems.TAGE_WACH_BB_MUSIC_DISC.get());
                        pOutput.accept(ModItems.LEICHE_MUSIC_DISC.get());

                        pOutput.accept(ModBlocks.OAK_TABLE.get());
                        pOutput.accept(ModBlocks.DARK_OAK_TABLE.get());
                        pOutput.accept(ModBlocks.SPRUCE_TABLE.get());
                        pOutput.accept(ModBlocks.BIRCH_TABLE.get());
                        pOutput.accept(ModBlocks.JUNGLE_TABLE.get());
                        pOutput.accept(ModBlocks.ACACIA_TABLE.get());
                        pOutput.accept(ModBlocks.MANGROVE_TABLE.get());
                        pOutput.accept(ModBlocks.CHERRY_TABLE.get());
                    }))
                    .build());

    public static final RegistryObject<CreativeModeTab> MCMOD_TAB_BOP = CREATIVE_MODE_TAB.register("mcmod_tab_bop",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.JACARANDA_TABLE.get().asItem()))
                        .title(Component.translatable("creativetab.mcmod_tab_bop"))
                        .displayItems(((pParameters, pOutput) -> {
                            pOutput.accept(ModBlocks.FIR_TABLE.get());
                            pOutput.accept(ModBlocks.REDWOOD_TABLE.get());
                            pOutput.accept(ModBlocks.MAHOGANY_TABLE.get());
                            pOutput.accept(ModBlocks.JACARANDA_TABLE.get());
                            pOutput.accept(ModBlocks.PALM_TABLE.get());
                            pOutput.accept(ModBlocks.WILLOW_TABLE.get());
                            pOutput.accept(ModBlocks.DEAD_TABLE.get());
                            pOutput.accept(ModBlocks.MAGIC_TABLE.get());
                            pOutput.accept(ModBlocks.UMBRAN_TABLE.get());
                            pOutput.accept(ModBlocks.HELLBARK_TABLE.get());
                            pOutput.accept(ModBlocks.HELLBARK_TABLE.get());
                        }))
                        .build());

    public static void registerMod(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
