package com.palana.babylonmod.block.custom;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

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
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
            WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        System.out.println("getStateForNeighborUpdate");

        boolean shouldBeWaterlogged = isAdjacentToWater(world, pos);

        // Update the WATERLOGGED property if necessary
        return state.with(WATERLOGGED, shouldBeWaterlogged);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);

        boolean shouldBeWaterlogged = isAdjacentToWater(world, pos);

        // Update the WATERLOGGED property if necessary
        if (state.get(WATERLOGGED) != shouldBeWaterlogged) {
            world.setBlockState(pos, state.with(WATERLOGGED, shouldBeWaterlogged), Block.NOTIFY_ALL);
        }
    }

    public static BlockState postProcessState(BlockState state, WorldAccess world, BlockPos pos) {

        boolean shouldBeWaterlogged = isAdjacentToWater(world, pos);

        // Update the WATERLOGGED property if necessary
        return state.with(WATERLOGGED, shouldBeWaterlogged);
    }

    private static boolean isAdjacentToWater(WorldAccess world, BlockPos pos) {
        System.out.println("isAdjacentToWater");

        // Offset the position vertically down by 2
        BlockPos belowPos = pos;

        // Iterate through horizontal directions only (NORTH, SOUTH, EAST, WEST)
        for (Direction direction : Direction.Type.HORIZONTAL) {
            FluidState fluidState = world.getFluidState(belowPos.offset(direction));
            if (fluidState.getFluid() == Fluids.WATER || fluidState.getFluid() == Fluids.FLOWING_WATER) {
                return true; // Return true if any adjacent block has water
            }
        }
        return false; // No adjacent block has water
    }

}