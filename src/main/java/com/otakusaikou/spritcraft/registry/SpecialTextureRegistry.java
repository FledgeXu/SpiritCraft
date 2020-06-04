package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpecialTextureRegistry {
    public static final ResourceLocation METAL_SPIRIT_TEXTURE = new ResourceLocation(ModConstants.MOD_ID, "ter/metal_ter");
    public static final ResourceLocation WOODEN_SPIRIT_TEXTURE = new ResourceLocation(ModConstants.MOD_ID, "ter/wooden_ter");
    public static final ResourceLocation WATER_SPIRIT_TEXTURE = new ResourceLocation(ModConstants.MOD_ID, "ter/water_ter");
    public static final ResourceLocation FIRE_SPIRIT_TEXTURE = new ResourceLocation(ModConstants.MOD_ID, "ter/fire_ter");
    public static final ResourceLocation EARTH_SPIRIT_TEXTURE = new ResourceLocation(ModConstants.MOD_ID, "ter/earth_ter");

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().getTextureLocation().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE)) {
            return;
        }
        event.addSprite(METAL_SPIRIT_TEXTURE);
        event.addSprite(WOODEN_SPIRIT_TEXTURE);
        event.addSprite(WATER_SPIRIT_TEXTURE);
        event.addSprite(FIRE_SPIRIT_TEXTURE);
        event.addSprite(EARTH_SPIRIT_TEXTURE);
    }
}
