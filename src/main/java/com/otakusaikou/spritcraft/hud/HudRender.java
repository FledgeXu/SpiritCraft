package com.otakusaikou.spritcraft.hud;

import com.otakusaikou.spritcraft.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Hand;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HudRender {
    public static final ChunkSpiritHUD chunkSpiritHub = new ChunkSpiritHUD();

    @SubscribeEvent
    public static void onOverlayRender(RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if (Minecraft.getInstance().player == null || Minecraft.getInstance().player.getHeldItem(Hand.MAIN_HAND).getItem() != ItemRegistry.spiriter.get()) {
            return;
        }
        chunkSpiritHub.render();
    }
}
