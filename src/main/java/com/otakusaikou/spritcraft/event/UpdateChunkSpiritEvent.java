package com.otakusaikou.spritcraft.event;

import com.otakusaikou.spritcraft.capability.ISpiritChunkCapability;
import com.otakusaikou.spritcraft.capability.ModCapability;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ChunkHolder;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class UpdateChunkSpiritEvent {

    @SubscribeEvent
    public static void onWorldTickEventC(TickEvent.WorldTickEvent event) {
        if (!event.world.isRemote && event.phase == TickEvent.Phase.END) {
            if (event.world.getGameTime() % 20 == 0) {
                event.world.getProfiler().startSection(ModConstants.MOD_ID + ":onWorldTick");
                Iterable<ChunkHolder> chunks = ((ServerChunkProvider) event.world.getChunkProvider()).chunkManager.getLoadedChunksIterable();
                for (ChunkHolder holder : chunks) {
                    Chunk chunk = holder.getChunkIfComplete();
                    if (chunk == null)
                        continue;
                    LazyOptional<ISpiritChunkCapability> spiritChunk = chunk.getCapability(ModCapability.SPIRIT_CHUNK_CAPABILITY, null);
                    spiritChunk.ifPresent(ISpiritChunkCapability::update);
                }
                event.world.getProfiler().endSection();
            }
        }
    }
}
