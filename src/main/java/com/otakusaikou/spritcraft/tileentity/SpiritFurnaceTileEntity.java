package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.capability.ISpiritContainerCapability;
import com.otakusaikou.spritcraft.capability.ModCapability;
import com.otakusaikou.spritcraft.gui.SpiritFurnaceContainer;
import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.ItemSpirit;
import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritCal;
import com.otakusaikou.spritcraft.spirit.SpiritType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class SpiritFurnaceTileEntity extends SyncedTileEntity implements ITickableTileEntity, INamedContainerProvider {
    private static Spirit LIMIT = new Spirit(64, 64, 64, 64, 64);
    private Spirit container = new Spirit();
    private Inventory inventory = new Inventory(2);
    private int burnTime = -1;
    private int cookedTime = 0;
    private int totalCookTime = 0;
    private IntArray array = new IntArray(2);

    public SpiritFurnaceTileEntity() {
        super(TileEntityTypeRegistry.spiritFurnaceTileEntity.get());
    }

    @Override
    public void tick() {
        boolean isDirty = false;

        if (this.isBurning()) {
            --burnTime;
            this.array.set(0, burnTime);
        }
        if (!world.isRemote) {
            putSpiritToContainer();
            System.out.println(this.container);
            ItemStack itemStack = this.inventory.getStackInSlot(0);
            ItemStack fuelStack = this.inventory.getStackInSlot(1);
            totalCookTime = 0;
            if (this.isBurning() || !itemStack.isEmpty() && !fuelStack.isEmpty() && ItemSpirit.getSpiritFromItem(itemStack).isPresent()) {
                ItemSpirit.getSpiritFromItem(itemStack).ifPresent((spirit) -> {
                    this.totalCookTime = (spirit.getMetal() + spirit.getWooden() + spirit.getWater() + spirit.getFire() + spirit.getEarth()) * 2;
                });
                if (!this.isBurning()) {
                    this.burnTime = ForgeHooks.getBurnTime(fuelStack);
                    if (this.isBurning()) {
                        fuelStack.shrink(1);
                        this.array.set(1, this.burnTime);
                        isDirty = true;
                    }
                }
                if (this.isBurning() && !itemStack.isEmpty() && ItemSpirit.getSpiritFromItem(itemStack).isPresent()) {
                    this.cookedTime++;
                    if (this.cookedTime == this.totalCookTime) {
                        this.cookedTime = 0;
                        SpiritCal.addWithLimit(this.container, ItemSpirit.getSpiritFromItem(itemStack).get(), LIMIT);
                        itemStack.shrink(1);
                        isDirty = true;
                    }
                } else {
                    this.cookedTime = 0;
                }
            } else if (!this.isBurning() && this.cookedTime > 0) {
                this.cookedTime = MathHelper.clamp(this.cookedTime - 2, 0, this.totalCookTime);
            }
            if (isDirty) {
                markDirty();
                this.world.notifyBlockUpdate(pos, this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
            }
        }
    }

    private void putSpiritToContainer() {
        TileEntity upTileEntity = this.world.getTileEntity(this.pos.up());
        if (upTileEntity == null) {
            return;
        }
        LazyOptional<ISpiritContainerCapability> spiritContainerCapability = upTileEntity.getCapability(ModCapability.SPIRIT_CONTAINER_CAPABILITY);
        spiritContainerCapability.ifPresent((cap) -> {
            if (cap.getType() == SpiritType.none) {
                if (this.container.getMetal() != 0) {
                    cap.putType(SpiritType.metal);
                    this.container.setMetal(cap.putVolume(this.container.getMetal()));
                    world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                    return;
                }
                if (this.container.getWooden() != 0) {
                    cap.putType(SpiritType.wooden);
                    this.container.setWooden(cap.putVolume(this.container.getWooden()));
                    world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                    return;
                }
                if (this.container.getWater() != 0) {
                    cap.putType(SpiritType.water);
                    this.container.setWater(cap.putVolume(this.container.getWater()));
                    world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                    return;
                }
                if (this.container.getFire() != 0) {
                    cap.putType(SpiritType.fire);
                    this.container.setFire(cap.putVolume(this.container.getFire()));
                    world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                    return;
                }
                if (this.container.getEarth() != 0) {
                    cap.putType(SpiritType.earth);
                    this.container.setEarth(cap.putVolume(this.container.getEarth()));
                    world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                    return;
                }
            }
            if (cap.getType() == SpiritType.metal) {
                this.container.setMetal(cap.putVolume(this.container.getMetal()));
                world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                return;
            }
            if (cap.getType() == SpiritType.wooden) {
                this.container.setWooden(cap.putVolume(this.container.getWooden()));
                world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                return;
            }
            if (cap.getType() == SpiritType.water) {
                this.container.setWater(cap.putVolume(this.container.getWater()));
                world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                return;
            }
            if (cap.getType() == SpiritType.fire) {
                this.container.setFire(cap.putVolume(this.container.getFire()));
                world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
                return;
            }
            if (cap.getType() == SpiritType.earth) {
                this.container.setEarth(cap.putVolume(this.container.getEarth()));
                world.notifyBlockUpdate(this.pos.up(), world.getBlockState(this.pos.up()), world.getBlockState(this.pos.up()), Constants.BlockFlags.BLOCK_UPDATE);
            }
        });
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
        compound.putInt("burn_time", this.burnTime);
        compound.put("spirit", this.container.serializeNBT());
        compound.putInt("cooked_time", this.cookedTime);
        return super.serialization(compound);
    }

    @Override
    public void deserialization(CompoundNBT compound) {
        this.inventory.setInventorySlotContents(0, ItemStack.read(compound.getCompound("item")));
        this.inventory.setInventorySlotContents(1, ItemStack.read(compound.getCompound("fuel")));
        this.burnTime = compound.getInt("burn_time");
        this.container.deserializeNBT(compound.getCompound("spirit"));
        this.cookedTime = compound.getInt("cooked_time");
        super.deserialization(compound);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("spirit_furnace");
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
        return new SpiritFurnaceContainer(id, playerInventory, this.world, this.pos, this.array);
    }

    public Boolean isBurning() {
        return this.burnTime > 0;
    }

    public int getBurnLeftScaled() {
        return burnTime;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
