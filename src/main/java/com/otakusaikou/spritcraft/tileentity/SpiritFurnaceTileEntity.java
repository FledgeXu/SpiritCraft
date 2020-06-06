package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.gui.SpiritFurnaceContainer;
import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.Spirit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SpiritFurnaceTileEntity extends SyncedTileEntity implements ITickableTileEntity, INamedContainerProvider {
    private Spirit container = new Spirit();
    private Boolean burning = false;
    private Inventory inventory = new Inventory(2);
    private int burnTime = 0;

    public SpiritFurnaceTileEntity() {
        super(TileEntityTypeRegistry.spiritFurnaceTileEntity.get());
    }

    @Override
    public void tick() {
        if (this.burning) {
            --burnTime;
        }
        if (!world.isRemote) {
        }
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return super.getCapability(cap, side);
    }

    @Override
    public CompoundNBT serialization(CompoundNBT compound) {
        compound.put("item", this.inventory.getStackInSlot(0).serializeNBT());
        compound.put("fuel", this.inventory.getStackInSlot(1).serializeNBT());
        compound.putBoolean("burning", this.burning);
        compound.putInt("burn_time", this.burnTime);
        compound.put("spirit", this.container.serializeNBT());
        return super.serialization(compound);
    }

    @Override
    public void deserialization(CompoundNBT compound) {
        this.inventory.setInventorySlotContents(0, ItemStack.read(compound.getCompound("item")));
        this.inventory.setInventorySlotContents(1, ItemStack.read(compound.getCompound("fuel")));
        this.burning = compound.getBoolean("burning");
        this.burnTime = compound.getInt("burn_time");
        this.container.deserializeNBT(compound.getCompound("spirit"));
        super.deserialization(compound);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("spirit_furnace");
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
        return new SpiritFurnaceContainer(id, playerInventory, this.world, this.pos);
    }

    public Boolean isBurning() {
        return this.burning;
    }

    public int getBurnLeftScaled() {
        return burnTime;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
