package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.network.HubChannel;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChannelRegistry {
    @SubscribeEvent
    public static void onChannelRegistry(FMLCommonSetupEvent event) {
        HubChannel.registerMessage();
    }
}
