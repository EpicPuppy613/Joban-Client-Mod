package com.lx862.jcm.mod.block;

import com.lx862.jcm.mod.block.base.WallAttachedBlock;
import com.lx862.jcm.mod.util.BlockUtil;
import org.mtr.mod.block.IBlock;
import org.mtr.mapping.holder.*;

public class FireAlarmWall extends WallAttachedBlock {
    public FireAlarmWall(BlockSettings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape2(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return IBlock.getVoxelShapeByDirection(5, 5, 0, 11, 11, 1, IBlock.getStatePropertySafe(state, FACING));
    }
}
