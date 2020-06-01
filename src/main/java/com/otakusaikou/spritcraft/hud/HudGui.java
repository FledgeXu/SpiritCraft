package com.otakusaikou.spritcraft.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;

public class HudGui extends AbstractGui {
    protected final int width;
    protected final int height;
    protected final Minecraft minecraft;

    public HudGui() {
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight();
        this.minecraft = Minecraft.getInstance();
    }

    public void render() {
    }
}
