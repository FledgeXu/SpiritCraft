package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.capability.ISpiritChunkCapability;
import com.otakusaikou.spritcraft.capability.ModCapability;
import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritCal;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.LazyOptional;

public class SpiritConsumeTileEntity extends TileEntity implements ITickableTileEntity {
    private Spirit spiritConsume;
    private int idleTime;
    private int counter = 0;

    public SpiritConsumeTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public SpiritConsumeTileEntity(TileEntityType<?> tileEntityTypeIn, Spirit spiritConsume, int idleTime) {
        super(tileEntityTypeIn);
        this.spiritConsume = spiritConsume;
        this.idleTime = idleTime;
    }

    @Override
    public void tick() {
        if (world.isRemote) {
            return;
        }
        counter++;
        if (counter <= idleTime) {
            return;
        }
        Chunk chunk = (Chunk) world.getChunk(this.pos);
        LazyOptional<ISpiritChunkCapability> spiritChunkCapability = chunk.getCapability(ModCapability.SPIRIT_CHUNK_CAPABILITY);
        spiritChunkCapability.ifPresent((cap) -> {
            if (SpiritCal.sub(cap.getSpirit(), this.spiritConsume)) {
                doTick();
            }
        });
        counter = 0;
    }

    public void doTick() {
    }
}
