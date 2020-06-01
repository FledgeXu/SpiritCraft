package com.otakusaikou.spritcraft.gui.hud;

import com.otakusaikou.spritcraft.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Hand;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HudRender {
    public static final ChunkSpiritHud chunkSpiritHub = new ChunkSpiritHud();

    @SubscribeEvent
    public static void onOverlayRender(RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        chunkSpiritHub.update(Minecraft.getInstance());
        if (Minecraft.getInstance().player == null || Minecraft.getInstance().player.getHeldItem(Hand.MAIN_HAND).getItem() != ItemRegistry.spiriter.get()) {
            return;
        }
        chunkSpiritHub.render();
    }
}
