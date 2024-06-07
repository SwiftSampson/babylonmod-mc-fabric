package com.palana.babylonmod.block.custom;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import org.jetbrains.annotations.Nullable;

import com.palana.babylonmod.block.custom.types.LocationType;

public class ModDirectionalSlabBlock extends SlabBlock {
    public static DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static final BooleanProperty IS_ABOVE_FENCE = BooleanProperty.create("is_above_fence");
    protected static final EnumProperty<LocationType> LOCATION = EnumProperty.create("location", LocationType.class);

    public ModDirectionalSlabBlock(Properties pProperties) {

        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any());
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        // System.out.println("HELLOE THIS IS THE DIRECTIONAL BLCOK!" +
        // placeContext.getHorizontalDirection());
        // return this.defaultBlockState().setValue(FACING,
        // placeContext.getHorizontalDirection()).setValue(TYPE,
        // SlabType.BOTTOM).setValue(WATERLOGGED, Boolean.valueOf(false));

        BlockPos blockpos = placeContext.getClickedPos();
        BlockState blockstate = placeContext.getLevel().getBlockState(blockpos);
        // blockstate.setValue(IS_ABOVE_FENCE, false).setValue(LOCATION,
        // LocationType.MIDDLE);
        if (blockstate.is(this)) {
            return blockstate.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, Boolean.valueOf(false))
                    .setValue(IS_ABOVE_FENCE, false)
                    .setValue(LOCATION, LocationType.MIDDLE);
        } else {
            FluidState fluidstate = placeContext.getLevel().getFluidState(blockpos);
            BlockState blockstate1 = this.defaultBlockState()
                    .setValue(TYPE, SlabType.BOTTOM)
                    .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER))
                    .setValue(FACING, placeContext.getHorizontalDirection())
                    .setValue(IS_ABOVE_FENCE, false)
                    .setValue(LOCATION, LocationType.MIDDLE);
            Direction direction = placeContext.getClickedFace();
            return direction != Direction.DOWN && (direction == Direction.UP
                    || !(placeContext.getClickLocation().y - (double) blockpos.getY() > 0.5D))
                            ? blockstate1
                            : blockstate1.setValue(TYPE, SlabType.TOP);
        }
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel,
            BlockPos pCurrentPos, BlockPos pFacingPos) {

        var belowBlockName = pLevel.getBlockState(pCurrentPos.below(1)).getBlock().getDescriptionId();

        boolean isAboveFence = false;
        LocationType location = LocationType.MIDDLE;
        Direction blockFacing = pState.getValue(FACING);

        if (belowBlockName.equals("block.babylonmod.offset_fence_post")) {
            isAboveFence = true;

            // if (northBlockName == southBlockName || eastBlockName == westBlockName) {
            // System.out.println("SLAB LOGS MIDDLE BLOCK");
            // location = LocationType.MIDDLE;
            // }

            Direction clockwiseDirection = blockFacing.getClockWise();
            Direction oppositeClockwiseDirection = clockwiseDirection.getOpposite();

            var clockwiseBlock = pLevel.getBlockState(pCurrentPos.relative(clockwiseDirection)).getBlock()
                    .getDescriptionId();
            var oppositeClockwiseBlock = pLevel.getBlockState(pCurrentPos.relative(oppositeClockwiseDirection))
                    .getBlock()
                    .getDescriptionId();

            // System.out.println("SLAB LOGS clockwiseblock " + clockwiseDirection +
            // clockwiseBlock);
            if (clockwiseBlock.equals("block.babylonmod.market_roof_slanted")
                    && oppositeClockwiseBlock.equals("block.babylonmod.market_roof_slanted")) {

                System.out.println("SLAB LOGS MIDDLE BLOCK");
                location = LocationType.MIDDLE;
                System.out.println(
                        "SLAB BLOCKS. direction: " + pState.getValue(FACING) + ", isAboveFence: " + isAboveFence
                                + ", location: " + location + ", blockType: " + pState.getValue(TYPE));

                return pState.setValue(IS_ABOVE_FENCE, isAboveFence).setValue(LOCATION, LocationType.MIDDLE);
            } else if (clockwiseBlock.equals("block.babylonmod.market_roof_slanted")) {
                System.out.println("SLAB LOGS LEFT BLOCK");
                location = LocationType.LEFT;
                System.out.println(
                        "SLAB BLOCKS. direction: " + pState.getValue(FACING) + ", isAboveFence: " + isAboveFence
                                + ", location: " + location + ", blockType: " + pState.getValue(TYPE));

                return pState.setValue(IS_ABOVE_FENCE, isAboveFence).setValue(LOCATION, LocationType.LEFT);
            } else if (oppositeClockwiseBlock.equals("block.babylonmod.market_roof_slanted")) {
                System.out.println("SLAB LOGS RIGHT BLOCK");
                location = LocationType.RIGHT;
                System.out.println(
                        "SLAB BLOCKS. direction: " + pState.getValue(FACING) + ", isAboveFence: " + isAboveFence
                                + ", location: " + location + ", blockType: " + pState.getValue(TYPE));

                return pState.setValue(IS_ABOVE_FENCE, isAboveFence).setValue(LOCATION, LocationType.RIGHT);

            }

        }
        System.out.println(
                "SLAB BLOCKS. direction: " + pState.getValue(FACING) + ", isAboveFence: " + isAboveFence
                        + ", location: " + location + ", blockType: " + pState.getValue(TYPE));

        return pState.setValue(IS_ABOVE_FENCE, isAboveFence);

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, WATERLOGGED, IS_ABOVE_FENCE, LOCATION);
    }

}