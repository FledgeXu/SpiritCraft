package com.otakusaikou.spritcraft.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SpiritFurnaceScreen extends ContainerScreen<SpiritFurnaceContainer> {
    private ResourceLocation SPIRIT_SCREEN_BACKGROUND = new ResourceLocation(ModConstants.MOD_ID, "textures/gui/spirit_screen_background.png");

    public SpiritFurnaceScreen(SpiritFurnaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.renderBackground();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(SPIRIT_SCREEN_BACKGROUND);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        blit(i, j, 0, 0, xSize, ySize);
        System.out.println(this.container);
        int k;
        k = (int) (13 * this.container.getProcessFactor());
        this.blit(i + 81, j + 36 + 14 - k, 176, 12 - k, 14, k);
    }
}
