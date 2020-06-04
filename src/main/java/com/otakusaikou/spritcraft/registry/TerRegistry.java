package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.ter.GlassJarTileEntityRender;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TerRegistry {
    @SubscribeEvent
    public static void onTerRegistry(FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer(TileEntityTypeRegistry.glassJarTileEntity.get(), (GlassJarTileEntityRender::new));
    }
}
