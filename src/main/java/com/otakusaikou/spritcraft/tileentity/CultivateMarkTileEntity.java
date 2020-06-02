package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.capability.ISpiritChunkCapability;
import com.otakusaikou.spritcraft.capability.ModCapability;
import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritCal;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.LazyOptional;

import java.util.Random;

public class CultivateMarkTileEntity extends SpiritConsumeTileEntity {

    public CultivateMarkTileEntity() {
        super(TileEntityTypeRegistry.cultivateMarkTileEntity.get(), new Spirit(0, 1, 0, 0, 0), 5 * 20);
    }


    @Override
    public void doTick() {
        Chunk chunk = (Chunk) this.world.getChunk(this.pos);
        LazyOptional<ISpiritChunkCapability> spiritChunkCapability = chunk.getCapability(ModCapability.SPIRIT_CHUNK_CAPABILITY);
        spiritChunkCapability.ifPresent((cap) -> {
            Random random = new Random(this.world.getGameTime() * 20001);
            BlockPos pos = new BlockPos(this.pos.getX() + random.nextInt(9) - 4, this.pos.getY(), this.pos.getZ() + random.nextInt(9) - 4);
            BlockState state = this.world.getBlockState(pos);
            if (state.getBlock() instanceof IGrowable && SpiritCal.sub(cap.getSpirit(), this.spiritConsume)) {
                ((IGrowable) state.getBlock()).grow((ServerWorld) this.world, world.getRandom(), pos, state);
            }
        });
    }
}
