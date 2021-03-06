package com.otakusaikou.spritcraft.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritHelper;
import com.otakusaikou.spritcraft.spirit.SpiritLimit;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

public class ChunkSpiritHud extends HudGui {
    public static Spirit spirit;
    public static SpiritLimit spiritLimit;
    private static float[] percent = new float[]{1, 1, 1, 1, 1};
    private static int[] maxValue = new int[]{0, 0, 0, 0, 0};
    private final ResourceLocation HUD = new ResourceLocation(ModConstants.MOD_ID, "textures/gui/chunk_spirit.png");
    private final PlayerEntity player;
    int xOffset = (int) (width * 0.05);
    int yOffset = (int) (height * 0.05f);

    public ChunkSpiritHud() {
        super();
        this.player = this.minecraft.player;
    }

    @Override
    public void render() {
        if (spirit != null && spiritLimit != null) {
            percent = SpiritHelper.division(spirit, spiritLimit);
            maxValue = new int[]{spiritLimit.metal, spiritLimit.wooden, spiritLimit.water, spiritLimit.fire, spiritLimit.earth};
        }
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(HUD);
        for (int i = 0; i < 5; i++) {
            renderProgressBar(xOffset, yOffset + i * 10, 1, 8 + 5 * i, maxValue[i], percent[i]);
        }
        if (player.isSneaking()) {
            for (int i = 0; i < 5; i++) {
                this.fontRenderer.drawString(Integer.toString(maxValue[i]), xOffset + 50, yOffset + 10 * i, 0xffffff);
            }
        }
    }

    private void renderProgressBar(int x, int y, int colorBarU, int colorBarV, int maxValue, float percent) {
        blit(x, y, 0, 0, 48, 7, 48, 48);
        blit(x + 2, y + 2, colorBarU, colorBarV, (int) (46 * percent), 5, 48, 48);
    }
}
