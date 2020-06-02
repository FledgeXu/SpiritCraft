package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.Spirit;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.function.Supplier;

public class HuntMarkTIleEntity extends SpiritConsumeTileEntity {
    public HuntMarkTIleEntity() {
        super(TileEntityTypeRegistry.huntMarkTileEntity.get(), new Spirit(5, 0, 5, 5, 0), 30 * 20);
    }

    @Override
    public void doTick() {
        BlockPos blockInit = new BlockPos(this.pos).add(-8, -8, -8);
        BlockPos blockEnd = new BlockPos(this.pos).add(8, 8, 8);
        List<Entity> list = this.world.getEntitiesInAABBexcluding(null, new AxisAlignedBB(blockInit, blockEnd), null);
        Supplier<Void> action = () -> {
            list.forEach(entity -> {
                entity.attackEntityFrom(DamageSource.GENERIC, 10);
            });
            return null;
        };
        consumeSpiritThenDo(action);
    }
}
