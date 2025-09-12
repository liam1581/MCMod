package com.leonyk2.tutorialmod;

import com.leonyk2.tutorialmod.item.ModCreativeModeTab;
import com.leonyk2.tutorialmod.item.ModItems;
import com.leonyk2.tutorialmod.sound.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.leonyk2.tutorialmod.TutorialMod.MOD_ID;

@Mod(MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";
    public TutorialMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModeTab.registerMod(modEventBus);
        ModSounds.register(modEventBus);

        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
