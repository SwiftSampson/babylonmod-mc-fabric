package com.palana.babylonmod.block.custom;

import org.jetbrains.annotations.Nullable;

import com.palana.babylonmod.block.custom.types.LocationType;

import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.WorldAccess;

public class ModDirectionalSlabBlock extends SlabBlock {
    public static DirectionProperty FACING = Properties.FACING;
    public static final EnumProperty<SlabType> TYPE = Properties.SLAB_TYPE;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape BOTTOM_AABB = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape TOP_AABB = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static final BooleanProperty IS_ABOVE_FENCE = BooleanProperty.of("is_above_fence");
    protected static final EnumProperty<LocationType> LOCATION = EnumProperty.of("location", LocationType.class);

    public ModDirectionalSlabBlock(Settings settings) {

        super(settings);
        // this.registerDefaultState(this.getStateDefinition().any());
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {

        BlockPos blockpos = ctx.getBlockPos();
        BlockState blockstate = ctx.getWorld().getBlockState(blockpos);
        // blockstate.with(IS_ABOVE_FENCE, false).with(LOCATION,
        // LocationType.MIDDLE);
        if (blockstate.isOf(this)) {
            return blockstate.with(TYPE, SlabType.DOUBLE).with(WATERLOGGED, Boolean.valueOf(false))
                    .with(IS_ABOVE_FENCE, false)
                    .with(LOCATION, LocationType.MIDDLE);
        } else {
            FluidState fluidstate = ctx.getWorld().getFluidState(ctx.getBlockPos());
            BlockState blockstate1 = this.getDefaultState()
                    .with(TYPE, SlabType.BOTTOM)
                    .with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER))
                    .with(FACING, ctx.getHorizontalPlayerFacing())
                    .with(IS_ABOVE_FENCE, false)
                    .with(LOCATION, LocationType.MIDDLE);
            Direction direction = ctx.getHorizontalPlayerFacing();
            return direction != Direction.DOWN && (direction == Direction.UP
                    || !(ctx.getHitPos().y - (double) blockpos.getY() > 0.5D))
                            ? blockstate1
                            : blockstate1.with(TYPE, SlabType.TOP);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState pState, Direction pFacing, BlockState pFacingState,
            WorldAccess pWorld,
            BlockPos pCurrentPos, BlockPos pFacingPos) {

        var belowBlockName = pWorld.getBlockState(pCurrentPos.down(1)).getBlock().getTranslationKey();

        boolean isAboveFence = false;
        LocationType location = LocationType.MIDDLE;
        Direction blockFacing = pState.get(FACING);

        if (belowBlockName.equals("block.babylonmod.offset_fence_post")) {
            isAboveFence = true;

            // if (northBlockName == southBlockName || eastBlockName == westBlockName) {
            // System.out.println("SLAB LOGS MIDDLE BLOCK");
            // location = LocationType.MIDDLE;
            // }

            Direction clockwiseDirection = blockFacing.rotateYClockwise();
            Direction oppositeClockwiseDirection = clockwiseDirection.getOpposite();

            var clockwiseBlock = pWorld.getBlockState(pCurrentPos.offset(clockwiseDirection)).getBlock()
                    .getTranslationKey();
            var oppositeClockwiseBlock = pWorld.getBlockState(pCurrentPos.offset(oppositeClockwiseDirection))
                    .getBlock()
                    .getTranslationKey();

            if (clockwiseBlock.equals("block.babylonmod.market_roof_slanted")
                    && oppositeClockwiseBlock.equals("block.babylonmod.market_roof_slanted")) {

                System.out.println("SLAB LOGS MIDDLE BLOCK");
                location = LocationType.MIDDLE;
                System.out.println(
                        "SLAB BLOCKS. direction: " + pState.get(FACING) + ", isAboveFence: " + isAboveFence
                                + ", location: " + location + ", blockType: " + pState.get(TYPE));

                return pState.with(IS_ABOVE_FENCE, isAboveFence).with(LOCATION, LocationType.MIDDLE);
            } else if (clockwiseBlock.equals("block.babylonmod.market_roof_slanted")) {
                System.out.println("SLAB LOGS LEFT BLOCK");
                location = LocationType.LEFT;
                System.out.println(
                        "SLAB BLOCKS. direction: " + pState.get(FACING) + ", isAboveFence: " + isAboveFence
                                + ", location: " + location + ", blockType: " + pState.get(TYPE));

                return pState.with(IS_ABOVE_FENCE, isAboveFence).with(LOCATION, LocationType.LEFT);
            } else if (oppositeClockwiseBlock.equals("block.babylonmod.market_roof_slanted")) {
                System.out.println("SLAB LOGS RIGHT BLOCK");
                location = LocationType.RIGHT;
                System.out.println(
                        "SLAB BLOCKS. direction: " + pState.get(FACING) + ", isAboveFence: " + isAboveFence
                                + ", location: " + location + ", blockType: " + pState.get(TYPE));

                return pState.with(IS_ABOVE_FENCE, isAboveFence).with(LOCATION, LocationType.RIGHT);

            }

        }
        System.out.println(
                "SLAB BLOCKS. direction: " + pState.get(FACING) + ", isAboveFence: " + isAboveFence
                        + ", location: " + location + ", blockType: " + pState.get(TYPE));

        return pState.with(IS_ABOVE_FENCE, isAboveFence);

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, WATERLOGGED, IS_ABOVE_FENCE, LOCATION);
    }

}