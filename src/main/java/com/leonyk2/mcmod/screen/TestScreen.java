package com.leonyk2.mcmod.screen;

import com.leonyk2.mcmod.widget.DropdownWidget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TestScreen extends Screen {
    private static final List<String> OPTIONS = List.of("Option A", "Option B", "Option C");

    public TestScreen() {
        super(Component.translatable("screens.mcmod.test.name"));
    }

    @Override
    protected void init() {
        DropdownWidget dropdown = new DropdownWidget(this.width / 2 - 50, this.height / 2 - 20, 100, 20,
                OPTIONS);

        Button actionButton = Button.builder(Component.translatable("screens.mcmod.test.button.print"), (btn) -> {
            System.out.println("Selected: " + dropdown.getSelected());
        }).bounds(this.width / 2 - 50, this.height / 2 + 100, 100, 20).build();

        this.addRenderableWidget(dropdown);
        this.addRenderableWidget(actionButton);
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }
}
