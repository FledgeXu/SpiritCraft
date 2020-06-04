package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.SpiritType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

public class GlassJarTileEntity extends TileEntity {
    private static final int MAX_CAPACITY = 64;
    private SpiritType spiritType = SpiritType.none;
    private int volume = 0;

    public GlassJarTileEntity() {
        super(TileEntityTypeRegistry.glassJarTileEntity.get());
    }

    public static int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public int getVolume() {
        return volume;
    }

    public SpiritType getSpiritType() {
        return spiritType;
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();
        compoundNBT = serialization(compoundNBT);
        return compoundNBT;
    }

    @Override
    public void handleUpdateTag(CompoundNBT tag) {
        deserialization(tag);
    }

    public CompoundNBT serialization(CompoundNBT compound) {
        compound.putString("type", this.spiritType.name());
        compound.putInt("volume", this.volume);
        return compound;
    }

    public void deserialization(CompoundNBT compound) {
        this.spiritType = SpiritType.valueOf(compound.getString("type"));
        this.volume = compound.getInt("volume");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        serialization(compound);
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        deserialization(compound);
        super.read(compound);
    }
}
