package com.otakusaikou.spritcraft.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.util.ResourceLocation;

public class ChunkSpiritHUD extends HudGui {
    private final ResourceLocation HUD = new ResourceLocation(ModConstants.MOD_ID, "textures/gui/chunk_spirit.png");
    int xOffset = (int) (width * 0.05);
    int yOffset = (int) (height * 0.05f);

    @Override
    public void render() {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(HUD);
        for (int i = 0; i < 5; i++) {
            renderProgressBar(xOffset, yOffset + i * 10, 1, 8 + 5 * i, 0.5f);
        }
    }

    private void renderProgressBar(int x, int y, int colorBarU, int colorBarV, float percent) {
        blit(x, y, 0, 0, 48, 7, 48, 48);
        blit(x + 2, y + 2, colorBarU, colorBarV, (int) (46 * percent), 5, 48, 48);
    }
}
