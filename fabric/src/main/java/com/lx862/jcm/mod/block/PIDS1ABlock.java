package com.lx862.jcm.mod.block;

import com.lx862.jcm.mod.block.entity.PIDS1ABlockEntity;
import org.mtr.mod.block.IBlock;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mod.block.BlockPIDSHorizontalBase;

public class PIDS1ABlock extends BlockPIDSHorizontalBase {
    public static final int MAX_ARRIVALS = 3;
    public PIDS1ABlock() {
        super(MAX_ARRIVALS, "ui.jsblock.pids_1a");
    }

    @Override
    public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape1 = IBlock.getVoxelShapeByDirection(6, 0, 0, 10, 11, 16, IBlock.getStatePropertySafe(state, FACING));
        VoxelShape shape2 = IBlock.getVoxelShapeByDirection(7.5, 11, 12.5, 8.5, 16, 13.5, IBlock.getStatePropertySafe(state, FACING));
        return VoxelShapes.union(shape1, shape2);
    }

    @Override
    public BlockEntityExtension createBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PIDS1ABlockEntity(blockPos, blockState);
    }
}
