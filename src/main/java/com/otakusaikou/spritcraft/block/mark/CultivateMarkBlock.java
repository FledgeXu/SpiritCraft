package com.otakusaikou.spritcraft.block.mark;

import com.otakusaikou.spritcraft.tileentity.CultivateMarkTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class CultivateMarkBlock extends MarkBlock {
    public CultivateMarkBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CultivateMarkTileEntity();
    }
}
