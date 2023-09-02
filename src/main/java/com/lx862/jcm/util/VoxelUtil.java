package com.lx862.jcm.util;

import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class VoxelUtil {
    public static VoxelShape getShape16(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return VoxelShapes.cuboid(minX / 16, minY / 16, minZ / 16, maxX / 16, maxY / 16, maxZ / 16);
    }

    public static VoxelShape getDirectionalShape16(Direction direction, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        switch(direction) {
            case NORTH:
                return VoxelUtil.getShape16(minX, minY, minZ, maxX, maxY, maxZ);
            case SOUTH:
                return VoxelUtil.getShape16(16 - maxX, minY, 16 - maxZ, 16 - minX, maxY, 16 - minZ);
            case EAST:
                return VoxelUtil.getShape16(16 - maxZ, minY, minX, 16 - minZ, maxY, maxX);
            case WEST:
                return VoxelUtil.getShape16(minZ, minY, 16 - maxX, maxZ, maxY, 16 - minX);
            default:
                return VoxelShapes.empty();
        }
    }
}
