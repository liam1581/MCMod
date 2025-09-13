package com.leonyk2.mcmod.keybind;

import com.leonyk2.mcmod.McMod;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = McMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Keybinds {
    public static final KeyMapping ANTRAG_KEY = new KeyMapping(
            "key.mcmod.antrag_key",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_H,
            "key.categories.mcmod"
            );

    /*
    public static final KeyMapping TEST_KEY = new KeyMapping(
            "key.mcmod.test",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_P,
            "key.categories.mcmod"
    );
     */

    @SubscribeEvent
    public static void registerKeyMapping(RegisterKeyMappingsEvent event) {
        event.register(ANTRAG_KEY);
        //event.register(TEST_KEY);

        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
    }
}
