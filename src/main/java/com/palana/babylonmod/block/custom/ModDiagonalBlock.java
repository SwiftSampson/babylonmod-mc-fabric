package com.palana.babylonmod.block.custom;

import org.jetbrains.annotations.Nullable;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.block.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ModDiagonalBlock extends HorizontalFacingBlock implements Waterloggable {
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public ModDiagonalBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();

        // Check all adjacent blocks for water
        boolean shouldBeWaterlogged = isAdjacentToWater(world, blockPos);

        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing())
                .with(WATERLOGGED, shouldBeWaterlogged);
    }

    @Override
    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos,
            boolean notify) {
        super.neighborUpdate(state, world, pos, block, fromPos, notify);

        // Check all adjacent blocks for water
        boolean shouldBeWaterlogged = isAdjacentToWater(world, pos);

        // Update the WATERLOGGED property if necessary
        if (state.get(WATERLOGGED) != shouldBeWaterlogged) {
            world.setBlockState(pos, state.with(WATERLOGGED, shouldBeWaterlogged), Block.NOTIFY_ALL);
        }
    }

    /**
     * Helper method to check if any adjacent block has still or flowing water.
     */
    private boolean isAdjacentToWater(World world, BlockPos pos) {
        for (Direction direction : Direction.values()) { // Iterate through all six directions
            FluidState fluidState = world.getFluidState(pos.offset(direction));
            if (fluidState.getFluid() == Fluids.WATER || fluidState.getFluid() == Fluids.FLOWING_WATER) {
                return true; // Return true if any adjacent block has water
            }
        }
        return false; // No adjacent block has water
    }
}