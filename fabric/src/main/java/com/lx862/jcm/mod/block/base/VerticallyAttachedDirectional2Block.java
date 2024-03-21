package com.lx862.jcm.mod.block.base;

import com.lx862.jcm.mod.block.behavior.HorizontalDoubleBlockBehavior;
import com.lx862.jcm.mod.block.behavior.VerticallyAttachedBlock;
import com.lx862.jcm.mod.data.BlockProperties;
import com.lx862.jcm.mod.util.BlockUtil;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.tool.HolderBase;

import java.util.List;

public abstract class VerticallyAttachedDirectional2Block extends VerticallyAttachedDirectionalBlock implements HorizontalDoubleBlockBehavior {
    public static final int width = 2;
    public static final BooleanProperty IS_LEFT = BlockProperties.HORIZONTAL_IS_LEFT;

    public VerticallyAttachedDirectional2Block(BlockSettings settings, boolean canAttachTop, boolean canAttachBottom) {
        super(settings, canAttachTop, canAttachBottom);
    }

    public boolean canPlace(BlockState state, BlockPos pos, ItemPlacementContext ctx) {
        boolean canPlaceHorizontally = HorizontalDoubleBlockBehavior.canBePlaced(ctx);
        boolean canPlaceVertically = VerticallyAttachedBlock.canPlace(canAttachTop, canAttachBottom, ctx) && VerticallyAttachedBlock.canPlace(canAttachTop, canAttachBottom, pos.offset(BlockUtil.getProperty(state, FACING).rotateYClockwise()), ctx);
        return canPlaceHorizontally && canPlaceVertically;
    }

    @Override
    public BlockState getPlacementState2(ItemPlacementContext ctx) {
        return canPlace(super.getPlacementState2(ctx), ctx.getBlockPos(), ctx) ? super.getPlacementState2(ctx) : null;
    }

    public void onPlaced2(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        HorizontalDoubleBlockBehavior.placeBlock(world, pos, state, IS_LEFT, Direction.convert(state.get(new Property<>(FACING.data))).rotateYClockwise(), width);
    }

    @Override
    public BlockState getStateForNeighborUpdate2(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        boolean isLeft = BlockUtil.getProperty(state, IS_LEFT);

        if(!HorizontalDoubleBlockBehavior.blockIsValid(pos, state, world, isLeft)) {
            return Blocks.getAirMapped().getDefaultState();
        }

        return super.getStateForNeighborUpdate2(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void addBlockProperties(List<HolderBase<?>> properties) {
        super.addBlockProperties(properties);
        properties.add(IS_LEFT);
    }
}