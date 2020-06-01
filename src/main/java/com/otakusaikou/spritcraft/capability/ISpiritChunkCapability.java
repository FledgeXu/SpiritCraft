package com.otakusaikou.spritcraft.capability;

import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritGrowRate;
import com.otakusaikou.spritcraft.spirit.SpiritLimit;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface ISpiritChunkCapability extends INBTSerializable<CompoundNBT> {
    Spirit getSpirit();

    SpiritLimit getSpiritLimit();

    SpiritGrowRate getSpiritGrowRate();

    void update();
}
