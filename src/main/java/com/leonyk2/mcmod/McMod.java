package com.leonyk2.mcmod;

import com.leonyk2.mcmod.block.ModBlocks;
import com.leonyk2.mcmod.item.ModCreativeModeTab;
import com.leonyk2.mcmod.item.ModItems;
import com.leonyk2.mcmod.sound.ModSounds;
import com.tterrag.registrate.Registrate;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.leonyk2.mcmod.McMod.MOD_ID;

@Mod(MOD_ID)
public class McMod {
    public static final String MOD_ID = "mcmod";
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public McMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;


        ModSounds.register(modEventBus);
        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);
        //ModBlocks.init(REGISTRATE);

        ModCreativeModeTab.registerMod(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        //DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> McModClient.onCtorClient(modEventBus, forgeEventBus));
    }
}
