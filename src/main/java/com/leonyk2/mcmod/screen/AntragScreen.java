package com.leonyk2.mcmod.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import static com.leonyk2.mcmod.util.Functions.runCommand;

public class AntragScreen extends Screen {
    private EditBox antragField;
    private EditBox idField;
    private EditBox acceptField;
    private EditBox denyField;

    public AntragScreen() {
        super(Component.literal(Component.translatable("screens.mcmod.antarg.name").toString()));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2 - 100;
        int y = this.height / 4;

        // Antrag field
        antragField = new EditBox(this.font, centerX, y, 150, 20, Component.literal("Antrag text"));
        this.addRenderableWidget(antragField);
        this.addRenderableWidget(Button.builder(Component.translatable("screens.mcmod.antarg.button.submit"), b -> {
            runCommand("antrag " + antragField.getValue());
        }).bounds(centerX + 155, y, 60, 20).build());

        // Delete field
        idField = new EditBox(this.font, centerX, y + 30, 100, 20, Component.literal("ID"));
        this.addRenderableWidget(idField);
        this.addRenderableWidget(Button.builder(Component.translatable("screens.mcmod.antarg.button.delete"), b -> {
            runCommand("antrag delete " + idField.getValue());
        }).bounds(centerX + 105, y + 30, 110, 20).build());

        // List
        this.addRenderableWidget(Button.builder(Component.translatable("screens.mcmod.antarg.button.list"), b -> {
            runCommand("antrag list");
        }).bounds(centerX, y + 60, 100, 20).build());

        // Operator-only buttons
        if (Minecraft.getInstance().player.hasPermissions(2)) {
            acceptField = new EditBox(this.font, centerX, y + 90, 100, 20, Component.literal("ID"));
            this.addRenderableWidget(acceptField);
            this.addRenderableWidget(Button.builder(Component.translatable("screens.mcmod.antarg.button.accept"), b -> {
                runCommand("antrag accept " + acceptField.getValue());
            }).bounds(centerX + 105, y + 90, 110, 20).build());

            denyField = new EditBox(this.font, centerX, y + 120, 100, 20, Component.literal("ID"));
            this.addRenderableWidget(denyField);
            this.addRenderableWidget(Button.builder(Component.translatable("screens.mcmod.antarg.button.deny"), b -> {
                runCommand("antrag deny " + denyField.getValue());
            }).bounds(centerX + 105, y + 120, 110, 20).build());
        }
    }
}
