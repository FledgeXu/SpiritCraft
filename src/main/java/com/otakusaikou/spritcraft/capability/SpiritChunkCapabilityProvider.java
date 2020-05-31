package com.otakusaikou.spritcraft.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SpiritChunkCapabilityProvider implements INBTSerializable<CompoundNBT>, ICapabilityProvider {
    private final ChunkPos pos;
    private final World world;
    private ISpiritChunkCapability spiritChunkCapability = null;

    public SpiritChunkCapabilityProvider(World world, ChunkPos pos) {
        this.world = world;
        this.pos = pos;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ModCapability.SPIRIT_CHUNK_CAPABILITY) {
            return LazyOptional.of(this::getOrCreate).cast();
        }
        return LazyOptional.empty();
    }

    @Nonnull
    private ISpiritChunkCapability getOrCreate() {
        if (this.spiritChunkCapability == null) {
            this.spiritChunkCapability = new SpiritChunkCapability(this.world, this.pos);
        }
        return this.spiritChunkCapability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return this.getOrCreate().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.getOrCreate().deserializeNBT(nbt);
    }
}
