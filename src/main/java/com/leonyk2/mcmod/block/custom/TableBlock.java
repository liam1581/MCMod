package com.leonyk2.mcmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

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
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return COLLISION_SHAPE;
    }
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return COLLISION_SHAPE;
    }
    @Override
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return COLLISION_SHAPE;
    }
}
