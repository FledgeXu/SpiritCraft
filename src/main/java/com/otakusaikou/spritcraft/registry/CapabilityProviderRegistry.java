package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.capability.ModCapability;
import com.otakusaikou.spritcraft.capability.SpiritChunkCapabilityProvider;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class CapabilityProviderRegistry {
    @SubscribeEvent
    public static void onCapabilityProviderAttach(AttachCapabilitiesEvent<Chunk> event) {
        Chunk chunk = event.getObject();
        if (!chunk.getCapability(ModCapability.SPIRIT_CHUNK_CAPABILITY).isPresent()) {
            event.addCapability(new ResourceLocation(ModConstants.MOD_ID, "chunk_spirit"), new SpiritChunkCapabilityProvider(chunk.getWorld(), chunk.getPos()));
        }
    }
}
