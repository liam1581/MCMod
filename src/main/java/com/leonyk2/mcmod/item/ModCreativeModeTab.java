package com.leonyk2.mcmod.item;

import com.leonyk2.mcmod.McMod;
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

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TAB.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LINSENEINTOPF.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.LINSENEINTOPF.get());
                        pOutput.accept(ModItems.BEATS_MUSIC_DISC.get());
                        pOutput.accept(ModItems.BEATS_BB_MUSIC_DISC.get());
                        pOutput.accept(ModItems.CRUSH_MUSIC_DISC.get());
                        pOutput.accept(ModItems.CRUSH_BB_MUSIC_DISC.get());
                        pOutput.accept(ModItems.TAGE_WACH_MUSIC_DISC.get());
                        pOutput.accept(ModItems.TAGE_WACH_BB_MUSIC_DISC.get());
                        pOutput.accept(ModItems.LEICHE_MUSIC_DISC.get());
                    }))
                    .build());

    public static void registerMod(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
