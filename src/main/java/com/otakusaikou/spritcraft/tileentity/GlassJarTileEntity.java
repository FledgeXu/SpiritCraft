package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.capability.ModCapability;
import com.otakusaikou.spritcraft.capability.SpiritContainerCapability;
import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.SpiritType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class GlassJarTileEntity extends SyncedTileEntity {
    private static final int MAX_CAPACITY = 64;
    private final SpiritContainerCapability spiritContainer = new SpiritContainerCapability(SpiritType.none, MAX_CAPACITY, 0);

    public GlassJarTileEntity() {
        super(TileEntityTypeRegistry.glassJarTileEntity.get());
    }

    public static int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public int getVolume() {
        return this.spiritContainer.getVolume();
    }

    public SpiritType getSpiritType() {
        return this.spiritContainer.getType();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ModCapability.SPIRIT_CONTAINER_CAPABILITY) {
            return LazyOptional.of(() -> this.spiritContainer).cast();
        }
        return LazyOptional.empty();
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

    public CompoundNBT serialization(CompoundNBT compound) {
        compound.put("container", this.spiritContainer.serializeNBT());
        return compound;
    }

    public void deserialization(CompoundNBT compound) {
        this.spiritContainer.deserializeNBT(compound.getCompound("container"));
    }

}
