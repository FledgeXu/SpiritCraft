package com.otakusaikou.spritcraft.block;

import com.otakusaikou.spritcraft.tileentity.CultivateMarkTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CultivateMarkBlock extends MarkBlock {
    public CultivateMarkBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CultivateMarkTileEntity();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.AIR) {
            ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
            worldIn.addEntity(itemEntity);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
}
