package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.gui.SpiritFurnaceScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BindScreenAndContainer {
    @SubscribeEvent
    public static void onClineSetupEvent(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ContainerTypeRegistry.spiritFurnaceContainer.get(), SpiritFurnaceScreen::new);
    }
}
