package com.leonyk2.mcmod.keybind;

import com.leonyk2.mcmod.screen.AntragScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.leonyk2.mcmod.keybind.Keybinds.ANTRAG_KEY;

public class KeyInputHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        if (ANTRAG_KEY.isDown()) {
            Minecraft.getInstance().setScreen(new AntragScreen());
        }
        /*
        if (TEST_KEY.isDown()) {
            Minecraft.getInstance().setScreen(new TestScreen());
        }
         */
    }
}
