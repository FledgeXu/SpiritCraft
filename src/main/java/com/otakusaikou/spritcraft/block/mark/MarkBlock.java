package com.otakusaikou.spritcraft.block.mark;

import com.otakusaikou.spritcraft.block.MachineBlock;
import com.otakusaikou.spritcraft.tileentity.SpiritConsumeTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class MarkBlock extends MachineBlock {
    private static VoxelShape shape = VoxelShapes.fullCube();

    static {
        VoxelShape base = Block.makeCuboidShape(0, 0, 0, 16, 1, 16);
        shape = VoxelShapes.or(base);
    }

    private final Supplier<SpiritConsumeTileEntity> tileEntity;


    public MarkBlock(Properties properties, Supplier<SpiritConsumeTileEntity> tileEntity) {
        super(properties);
        this.tileEntity = tileEntity;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return MarkBlock.shape;
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

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return this.tileEntity.get();
    }
}
