package com.otakusaikou.spritcraft.ter;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.otakusaikou.spritcraft.registry.SpecialTextureRegistry;
import com.otakusaikou.spritcraft.tileentity.GlassJarTileEntity;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;

public class GlassJarTileEntityRender extends TileEntityRenderer<GlassJarTileEntity> {
    public static final ResourceLocation TEST = new ResourceLocation(ModConstants.MOD_ID, "textures/ter/water_ter.png");

    public GlassJarTileEntityRender(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(GlassJarTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        switch (tileEntityIn.getSpiritType()) {
            case metal:
                renderSpirit(SpecialTextureRegistry.METAL_SPIRIT_TEXTURE, tileEntityIn.getVolume(), GlassJarTileEntity.getMaxCapacity(), matrixStackIn, bufferIn, combinedLightIn);
                break;
            case wooden:
                renderSpirit(SpecialTextureRegistry.WOODEN_SPIRIT_TEXTURE, tileEntityIn.getVolume(), GlassJarTileEntity.getMaxCapacity(), matrixStackIn, bufferIn, combinedLightIn);
                break;
            case water:
                renderSpirit(SpecialTextureRegistry.WATER_SPIRIT_TEXTURE, tileEntityIn.getVolume(), GlassJarTileEntity.getMaxCapacity(), matrixStackIn, bufferIn, combinedLightIn);
                break;
            case fire:
                renderSpirit(SpecialTextureRegistry.FIRE_SPIRIT_TEXTURE, tileEntityIn.getVolume(), GlassJarTileEntity.getMaxCapacity(), matrixStackIn, bufferIn, combinedLightIn);
                break;
            case earth:
                renderSpirit(SpecialTextureRegistry.EARTH_SPIRIT_TEXTURE, tileEntityIn.getVolume(), GlassJarTileEntity.getMaxCapacity(), matrixStackIn, bufferIn, combinedLightIn);
                break;
        }
    }

    private void renderSpirit(ResourceLocation texture, int volume, float maxVolume, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn) {
        matrixStackIn.push();
        TextureAtlasSprite sprite = Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(texture);
        IVertexBuilder builder = bufferIn.getBuffer(ModRenderType.TRANSLUCENT_FLUID);
        //1
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1 + 11 * volume / maxVolume), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1 + 11 * volume / maxVolume), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        //2
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1 + 11 * volume / maxVolume), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1 + 11 * volume / maxVolume), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();

        //3
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1 + 11 * volume / maxVolume), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1 + 11 * volume / maxVolume), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        //4
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1 + 11 * volume / maxVolume), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1 + 11 * volume / maxVolume), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        //up
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1 + 11 * volume / maxVolume), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1 + 11 * volume / maxVolume), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1 + 11 * volume / maxVolume), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1 + 11 * volume / maxVolume), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        //down1
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        //down2
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(4), getUnit(1), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMinU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1), getUnit(12))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMaxV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        builder.pos(matrixStackIn.getLast().getMatrix(), getUnit(12), getUnit(1), getUnit(4))
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .tex(sprite.getMaxU(), sprite.getMinV())
                .lightmap(combinedLightIn)
                .normal(1, 0, 0)
                .endVertex();
        matrixStackIn.pop();
    }

    private float getUnit(float i) {
        return i / 16f;
    }
}
