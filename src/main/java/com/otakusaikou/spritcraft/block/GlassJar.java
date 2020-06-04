package com.otakusaikou.spritcraft.block;

import com.otakusaikou.spritcraft.tileentity.GlassJarTileEntity;
import com.otakusaikou.spritcraft.tileentity.SpiritConsumeTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class GlassJar extends Block {
    private static VoxelShape shape = VoxelShapes.fullCube();
    private Supplier<SpiritConsumeTileEntity> tileEntity;

    static {
        VoxelShape base = Block.makeCuboidShape(3, 1, 12, 13, 12, 13);
        VoxelShape base1 = Block.makeCuboidShape(3, 1, 4, 4, 12, 12);
        VoxelShape base2 = Block.makeCuboidShape(12, 1, 4, 13, 12, 12);
        VoxelShape base3 = Block.makeCuboidShape(3, 1, 3, 13, 12, 4);
        VoxelShape base4 = Block.makeCuboidShape(3, 0, 3, 13, 1, 3);
        VoxelShape base5 = Block.makeCuboidShape(4, 12, 4, 12, 13, 12);
        VoxelShape base6 = Block.makeCuboidShape(3, 13, 3, 13, 15, 13);
        shape = VoxelShapes.or(base, base1, base2, base3, base4, base5, base6);
    }

    public GlassJar(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new GlassJarTileEntity();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return GlassJar.shape;
    }
}
