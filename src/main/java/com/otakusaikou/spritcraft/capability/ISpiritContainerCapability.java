package com.otakusaikou.spritcraft.capability;

import com.otakusaikou.spritcraft.spirit.SpiritType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface ISpiritContainerCapability extends INBTSerializable<CompoundNBT> {
    SpiritType getType();

    void putType(SpiritType type);

    int getMaxVolume();

    int getVolume();

    int putVolume(int i);
}
