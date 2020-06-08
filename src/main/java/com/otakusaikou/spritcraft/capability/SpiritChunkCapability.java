package com.otakusaikou.spritcraft.capability;

import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritGrowRate;
import com.otakusaikou.spritcraft.spirit.SpiritHelper;
import com.otakusaikou.spritcraft.spirit.SpiritLimit;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import java.util.Random;

public class SpiritChunkCapability implements ISpiritChunkCapability {
    private final Spirit spirit;
    private final SpiritLimit spiritLimit;
    private final SpiritGrowRate spiritGrowRate;

    public SpiritChunkCapability(World world, ChunkPos pos) {
        Random random = new Random(world.getSeed() + pos.x * 10001921 + pos.z * 10001813);
        this.spiritLimit = new SpiritLimit(random.nextInt(SpiritLimit.SPIRIT_MAX) + 1, random.nextInt(SpiritLimit.SPIRIT_MAX) + 1, random.nextInt(SpiritLimit.SPIRIT_MAX) + 1, random.nextInt(SpiritLimit.SPIRIT_MAX) + 1, random.nextInt(SpiritLimit.SPIRIT_MAX) + 1);
        this.spiritGrowRate = new SpiritGrowRate(random.nextInt(SpiritGrowRate.GROW_RATE) + 1, random.nextInt(SpiritGrowRate.GROW_RATE) + 1, random.nextInt(SpiritGrowRate.GROW_RATE) + 1, random.nextInt(SpiritGrowRate.GROW_RATE) + 1, random.nextInt(SpiritGrowRate.GROW_RATE) + 1);
        this.spirit = new Spirit(random.nextInt(this.spiritLimit.metal) + 1, random.nextInt(this.spiritLimit.wooden) + 1, random.nextInt(this.spiritLimit.water) + 1, random.nextInt(this.spiritLimit.fire) + 1, random.nextInt(this.spiritLimit.earth) + 1);
    }

    @Override
    public Spirit getSpirit() {
        return spirit;
    }

    @Override
    public SpiritLimit getSpiritLimit() {
        return spiritLimit;
    }

    @Override
    public SpiritGrowRate getSpiritGrowRate() {
        return spiritGrowRate;
    }

    @Override
    public void update() {
        SpiritHelper.addWithLimit(this.spirit, this.spiritGrowRate, this.spiritLimit);
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.put("spirit", this.spirit.serializeNBT());
        compoundNBT.put("limit", this.spiritLimit.serializeNBT());
        compoundNBT.put("grow_rate", this.spiritGrowRate.serializeNBT());
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.spirit.deserializeNBT(nbt.getCompound("spirit"));
        this.spiritLimit.deserializeNBT(nbt.getCompound("limit"));
        this.spiritGrowRate.deserializeNBT(nbt.getCompound("grow_rate"));
    }
}
