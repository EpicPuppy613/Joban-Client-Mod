package com.lx862.jcm.mod.block;

import com.lx862.jcm.mod.block.base.WallAttachedBlock;
import com.lx862.jcm.mod.data.BlockProperties;
import com.lx862.jcm.mod.util.BlockUtil;
import com.lx862.jcm.mod.util.TextUtil;
import com.lx862.jcm.mod.util.Utils;
import com.lx862.jcm.mod.util.VoxelUtil;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.tool.HolderBase;

import java.util.List;

public class KCREmergencyStopSign extends WallAttachedBlock {
    public static final BooleanProperty POINT_TO_LEFT = BlockProperties.POINT_TO_LEFT;
    public KCREmergencyStopSign(BlockSettings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape2(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelUtil.getDirectionalShape16(BlockUtil.getProperty(state, FACING), 0, 0, 6.5, 26, 7, 9.5);
    }

    @Override
    public BlockState getPlacementState2(ItemPlacementContext ctx) {
        if (ctx.getSide() == Direction.DOWN || ctx.getSide() == Direction.UP) {
            return Blocks.getAirMapped().getDefaultState();
        }

        return super.getPlacementState2(ctx).with(new Property<>(FACING.data), ctx.getPlayerFacing().data);
    }

    @Override
    public ActionResult onUse2(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        super.onUse2(state, world, pos, player, hand, hit);
        return getBrushActionResult(player);
    }

    @Override
    public void onServerUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(Utils.playerHoldingBrush(player)) {
            world.setBlockState(pos, state.cycle(new Property<>(POINT_TO_LEFT.data)));
            player.sendMessage(Text.cast(TextUtil.translatable(TextUtil.TextCategory.HUD, "kcr_emg_stop_sign.success")), true);
        }
    }

    @Override
    public void addBlockProperties(List<HolderBase<?>> properties) {
        super.addBlockProperties(properties);
        properties.add(POINT_TO_LEFT);
    }

    @Override
    public Direction getOffsetDirection(Direction defaultDirection) {
        return defaultDirection.rotateYCounterclockwise();
    }
}
