package com.leonyk2.mcmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TableBlock extends Block {
    private static final VoxelShape COLLISION_SHAPE = Shapes.or(
            // Tabletop
            Block.box(0, 13, 0, 16, 16, 16),
            // Front-left leg
            Block.box(0, 0, 0, 3, 13, 3),
            // Back-left leg
            Block.box(0, 0, 13, 3, 13, 16),
            // Front-right leg
            Block.box(13, 0, 0, 16, 13, 3),
            // Back-right leg
            Block.box(13, 0, 13, 16, 13, 16)
    );

    public TableBlock(Properties properties) {
        super(properties.noOcclusion()); // disables default full-cube occlusion
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return COLLISION_SHAPE;
    }
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return COLLISION_SHAPE;
    }
    @Override
    public @NotNull VoxelShape getOcclusionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return COLLISION_SHAPE;
    }
}
