package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.Spirit;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CultivateMarkTileEntity extends SpiritConsumeTileEntity {

    public CultivateMarkTileEntity() {
        super(TileEntityTypeRegistry.cultivateMarkTileEntity.get(), new Spirit(0, 1, 0, 0, 0), 3 * 20);
    }


    @Override
    public void doTick() {
        Random random = new Random(this.world.getGameTime() * 20001);
        BlockPos pos = new BlockPos(this.pos.getX() + random.nextInt(9) - 4, this.pos.getY(), this.pos.getZ() + random.nextInt(9) - 4);
        BlockState state = this.world.getBlockState(pos);
        if (state.getBlock() instanceof IGrowable) {
            IGrowable growable = (IGrowable) state.getBlock();
            if (growable.canGrow(this.world, pos, state, false)) {
                consumeSpiritThenDo(() -> {
                    growable.grow((ServerWorld) this.world, world.getRandom(), pos, state);
                    return null;
                });
            }
        }
    }
}
