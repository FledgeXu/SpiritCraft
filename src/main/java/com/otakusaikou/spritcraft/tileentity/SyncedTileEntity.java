package com.otakusaikou.spritcraft.tileentity;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nullable;

public class SyncedTileEntity extends TileEntity {
    public SyncedTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
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


    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound = super.write(compound);
        serialization(compound);
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        deserialization(compound);
        super.read(compound);
    }

    public CompoundNBT serialization(CompoundNBT compound) {
        return compound;
    }

    public void deserialization(CompoundNBT compound) {
    }
}
