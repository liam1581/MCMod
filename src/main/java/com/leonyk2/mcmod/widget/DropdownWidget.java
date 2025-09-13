package com.leonyk2.mcmod.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

import java.util.List;

public class DropdownWidget extends AbstractWidget {
    private final List<String> options;
    private int selectedIndex = 0;
    private boolean expanded = false;

    public DropdownWidget(int x, int y, int width, int height, List<String> options) {
        super(x, y, width, height, Component.literal(options.get(0)));
        this.options = options;
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Font font = Minecraft.getInstance().font;

        // Draw the selected value
        guiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, 0xFF333333);
        guiGraphics.drawString(font, options.get(selectedIndex), this.getX() + 4, this.getY() + 6, 0xFFFFFF);

        if (expanded) {
            // Draw dropdown options
            for (int i = 0; i < options.size(); i++) {
                int y = this.getY() + (i + 1) * this.height;
                guiGraphics.fill(this.getX(), y, this.getX() + this.width, y + this.height, 0xFF222222);
                guiGraphics.drawString(font, options.get(i), this.getX() + 4, y + 6, 0xFFFFFF);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // If collapsed and user clicks inside the main box → expand
        if (!expanded && mouseX >= this.getX() && mouseX <= this.getX() + this.width
                && mouseY >= this.getY() && mouseY <= this.getY() + this.height) {
            expanded = true;
            return true;
        }

        // If expanded → check if clicked on any option
        if (expanded) {
            for (int i = 0; i < options.size(); i++) {
                int y = this.getY() + (i + 1) * this.height;
                if (mouseX >= this.getX() && mouseX <= this.getX() + this.width
                        && mouseY >= y && mouseY <= y + this.height) {
                    selectedIndex = i;
                    this.setMessage(Component.literal(options.get(i)));
                    expanded = false; // collapse after selecting
                    return true;
                }
            }

            // Clicked outside the dropdown → collapse
            if (!(mouseX >= this.getX() && mouseX <= this.getX() + this.width
                    && mouseY >= this.getY() && mouseY <= this.getY() + this.height)) {
                expanded = false;
                return true;
            }
        }

        return false;
    }

    public String getSelected() {
        return options.get(selectedIndex);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput output) {}
}
