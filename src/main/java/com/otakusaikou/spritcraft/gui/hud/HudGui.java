package com.otakusaikou.spritcraft.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;

public class HudGui extends AbstractGui {
    protected int width;
    protected int height;
    protected Minecraft minecraft;
    protected FontRenderer fontRenderer;

    public HudGui() {
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight();
        this.minecraft = Minecraft.getInstance();
        this.fontRenderer = this.minecraft.fontRenderer;
    }

    public void render() {
    }
}
