package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.spirit.Spirit;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class SpiritConsumeTileEntity extends TileEntity implements ITickableTileEntity {
    protected Spirit spiritConsume;
    protected int idleTime;
    private int counter;

    public SpiritConsumeTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public SpiritConsumeTileEntity(TileEntityType<?> tileEntityTypeIn, Spirit spiritConsume, int idleTime) {
        super(tileEntityTypeIn);
        this.spiritConsume = spiritConsume;
        this.idleTime = idleTime;
    }

    @Override
    public void tick() {
        if (world.isRemote) {
            return;
        }
        this.counter++;
        if (counter <= this.idleTime) {
            return;
        }
        counter = 0;
        doTick();
    }

    public void doTick() {

    }
}
