package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.Spirit;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class CultivateMarkTileEntity extends SpiritConsumeTileEntity {
    private final BlockPos bottomBlockPost;

    public CultivateMarkTileEntity() {
        super(TileEntityTypeRegistry.cultivateMark.get(), new Spirit(0, 30, 0, 0, 0), 90 * 20);
        bottomBlockPost = this.pos.down();
    }

    @Override
    public void doTick() {
        for (int i = -4; i <= 4; i++) {
            for (int j = -4; j <= 4; j++) {
                BlockPos pos = this.pos.add(i, 0, j);
                BlockState cropBlock = this.world.getWorld().getBlockState(pos);
                if (cropBlock.getBlock() instanceof IGrowable) {
                    ((IGrowable) cropBlock.getBlock()).grow((ServerWorld) this.world, world.getRandom(), pos, cropBlock);
                }
            }
        }
    }
}
