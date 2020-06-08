package com.otakusaikou.spritcraft.spirit;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class Spirit implements INBTSerializable<CompoundNBT> {
    public int metal;
    public int wooden;
    public int water;
    public int fire;
    public int earth;

    public Spirit() {
    }

    public Spirit(int metal, int wooden, int water, int fire, int earth) {
        this.metal = metal;
        this.wooden = wooden;
        this.water = water;
        this.fire = fire;
        this.earth = earth;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("metal", metal);
        compoundNBT.putInt("wooden", wooden);
        compoundNBT.putInt("water", water);
        compoundNBT.putInt("fire", fire);
        compoundNBT.putInt("earth", earth);
        return compoundNBT;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.metal = nbt.getInt("metal");
        this.wooden = nbt.getInt("wooden");
        this.water = nbt.getInt("water");
        this.fire = nbt.getInt("fire");
        this.earth = nbt.getInt("earth");
    }

    @Override
    public String toString() {
        return "Spirit{" +
                "metal=" + metal +
                ", wooden=" + wooden +
                ", water=" + water +
                ", fire=" + fire +
                ", earth=" + earth +
                '}';
    }
}
