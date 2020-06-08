package com.otakusaikou.spritcraft.capability;

import com.otakusaikou.spritcraft.spirit.SpiritType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpiritContainerCapability implements ISpiritContainerCapability {
    private SpiritType type;
    private int maxVolume;
    private int volume;
    private World world;
    private BlockPos pos;

    public SpiritContainerCapability(SpiritType type, int maxVolume, int volume) {
        this.type = type;
        this.maxVolume = maxVolume;
        this.volume = volume;
    }

    @Override
    public SpiritType getType() {
        return this.type;
    }

    @Override
    public void putType(SpiritType type) {
        this.type = type;
    }

    @Override
    public int getMaxVolume() {
        return this.maxVolume;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public int putVolume(int i) {
        if (i > 0) {
            if (this.volume + i >= this.maxVolume) {
                int val = this.volume + i - this.maxVolume;
                this.volume = this.maxVolume;
                return val;
            } else {
                this.volume += i;
            }
        }
        return 0;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();
        compound.putString("type", this.type.name());
        compound.putInt("volume", this.volume);
        compound.putInt("max_volume", this.maxVolume);
        return compound;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.type = SpiritType.valueOf(nbt.getString("type"));
        this.volume = nbt.getInt("volume");
        this.maxVolume = nbt.getInt("max_volume");
    }
}

