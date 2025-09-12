package com.leonyk2.mcmod;

import com.leonyk2.mcmod.item.ModCreativeModeTab;
import com.leonyk2.mcmod.item.ModItems;
import com.leonyk2.mcmod.sound.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.leonyk2.mcmod.McMod.MOD_ID;

@Mod(MOD_ID)
public class McMod {
    public static final String MOD_ID = "mcmod";
    public McMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModeTab.registerMod(modEventBus);
        ModSounds.register(modEventBus);

        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
