package com.leonyk2.mcmod.screen;

import com.leonyk2.mcmod.widget.DropdownWidget;
import com.leonyk2.mcmod.widget.DropdownWidgetTranslatable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.leonyk2.mcmod.util.Functions.runCommand;

public class AntragScreen extends Screen {
    private EditBox antragField;
    private DropdownWidgetTranslatable dropdown;
    private DropdownWidgetTranslatable operator_dropdown;

    private static final List<String> OPTIONS = List.of("screens.mcmod.antrag.OPTIONS.antrag", "screens.mcmod.antrag.OPTIONS.delete", "screens.mcmod.antrag.OPTIONS.list");
    private static final List<String> OPERATOR_OPTIONS = List.of("screens.mcmod.antrag.OPTIONS.accept", "screens.mcmod.antrag.OPTIONS.deny");

    public AntragScreen() {
        super(Component.literal(Component.translatable("screens.mcmod.antarg.name").toString()));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2 - 100;
        int y = this.height / 2;

        dropdown = new DropdownWidgetTranslatable(centerX, y - 20, 100, 20, OPTIONS);
        operator_dropdown = new DropdownWidgetTranslatable(centerX + 110, y - 20, 100, 20, OPERATOR_OPTIONS);
        antragField = new EditBox(this.font, centerX, y + 90, 100, 20, Component.literal("idk"));
        Button submitButton = Button.builder(Component.translatable("screens.mcmod.antarg.button.submit"), b -> {
            switch (dropdown.getSelected()) {
                case "":
                    break;
                case "screens.mcmod.antrag.OPTIONS.antrag":
                    runCommand("antrag " + antragField.getValue());
                    break;
                case "screens.mcmod.antrag.OPTIONS.delete":
                    runCommand("antrag delete " + antragField.getValue());
                    break;
                case "screens.mcmod.antrag.OPTIONS.list":
                    runCommand("antrag list");
                    break;
            }
            switch (operator_dropdown.getSelected()) {
                case "":
                    break;
                case "screens.mcmod.antrag.OPTIONS.accept":
                    runCommand("antrag accept " + antragField.getValue());
                    break;
                case "screens.mcmod.antrag.OPTIONS.deny":
                    runCommand("antrag deny " + antragField.getValue());
                    break;
            }
        }).bounds(centerX + 110, y + 90, 60, 20).build();

        this.addRenderableWidget(dropdown);
        assert Minecraft.getInstance().player != null;
        if (Minecraft.getInstance().player.hasPermissions(2)) this.addRenderableWidget(operator_dropdown);
        this.addRenderableWidget(antragField);
        this.addRenderableWidget(submitButton);
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }
}
