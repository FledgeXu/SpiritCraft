package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.capability.ISpiritChunkCapability;
import com.otakusaikou.spritcraft.capability.ModCapability;
import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritHelper;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.LazyOptional;

import java.util.function.Supplier;

public class SpiritConsumeTileEntity extends TileEntity implements ITickableTileEntity {
    protected Spirit spiritConsume;
    protected int idleTime;
    private int counter;

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
        this.counter++;
        if (counter <= this.idleTime) {
            return;
        }
        counter = 0;
        doTick();
    }

    public void doTick() {

    }

    protected LazyOptional<ISpiritChunkCapability> getSpiritChunkCap() {
        Chunk chunk = (Chunk) this.world.getChunk(this.pos);
        return chunk.getCapability(ModCapability.SPIRIT_CHUNK_CAPABILITY);
    }

    protected void consumeSpiritThenDo(Supplier<Void> action) {
        LazyOptional<ISpiritChunkCapability> spiritChunkCapabilityLazyOptional = getSpiritChunkCap();
        spiritChunkCapabilityLazyOptional.ifPresent((cap) -> {
            if (SpiritHelper.sub(cap.getSpirit(), this.spiritConsume)) {
                action.get();
            }
        });
    }
}
