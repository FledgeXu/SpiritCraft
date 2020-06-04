package com.otakusaikou.spritcraft.ter;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;

public class ModRenderType extends RenderType {
    public static final RenderType TRANSLUCENT_FLUID = makeType(
            "translucent",
            DefaultVertexFormats.BLOCK,
            7,
            262144,
            true,
            true,
            RenderType.State.getBuilder().shadeModel(SHADE_ENABLED).lightmap(LIGHTMAP_ENABLED).texture(BLOCK_SHEET_MIPPED).transparency(TRANSLUCENT_TRANSPARENCY).writeMask(COLOR_WRITE).build(true));

    public ModRenderType(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }
}
