package com.lx862.jcm.blocks;

import com.lx862.jcm.blocks.base.HorizontalMultiBlock;
import com.lx862.jcm.util.BlockUtil;
import com.lx862.jcm.util.VoxelUtil;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.holder.BlockSettings;

public class HKTrainModelBlock extends HorizontalMultiBlock {
    public HKTrainModelBlock(BlockSettings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape2(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelUtil.getDirectionalShape16(BlockUtil.getStateProperty(state, FACING).data, 0, 0, 3.5, 16, 9, 12.5);
    }
}
