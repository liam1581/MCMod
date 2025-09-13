package com.leonyk2.mcmod.keybind;

import com.leonyk2.mcmod.screen.AntragScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.leonyk2.mcmod.keybind.Keybinds.HELLO_KEY;

public class KeyInputHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        if (HELLO_KEY.isDown()) {
            Minecraft.getInstance().setScreen(new AntragScreen());
        }
    }
}
