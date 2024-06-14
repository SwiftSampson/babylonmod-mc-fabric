package com.palana.babylonmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
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
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

public class ModConnectedBlock extends StairsBlock {

    private Supplier<BlockState> stateSupplier;
    private Object baseState;
    private Block base;
    private static final int[] SHAPE_BY_STATE = new int[] { 12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4,
            1, 2, 8 };
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<BlockHalf> HALF = Properties.BLOCK_HALF;
    public static final EnumProperty<StairShape> SHAPE = Properties.STAIR_SHAPE;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty IS_CENTER = BooleanProperty.of("is_center");

    public ModConnectedBlock(BlockState baseBlockState, AbstractBlock.Settings settings) {

        super(baseBlockState, settings);
        this.setDefaultState(
                (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) this.stateManager
                        .getDefaultState())
                        .with(FACING, Direction.NORTH))
                        .with(HALF, BlockHalf.BOTTOM))
                        .with(SHAPE, StairShape.STRAIGHT))
                        .with(WATERLOGGED, Boolean.valueOf(false))
                        .with(IS_CENTER, false));
        this.base = Blocks.AIR; // These are unused, fields are redirected
        this.baseState = Blocks.AIR.getDefaultState();

        // this.stateSupplier = baseBlockState;

    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getSide();
        BlockPos blockpos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(blockpos);
        BlockState blockstate = this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing()).with(
                HALF,
                direction != Direction.DOWN && (direction == Direction.UP
                        || !(ctx.getHitPos().y - (double) blockpos.getY() > 0.5D)) ? BlockHalf.BOTTOM : BlockHalf.TOP)
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        var asdas = getStairsShape(blockstate, ctx.getWorld(), blockpos);

        var isInternalBlock = checkIfInternalBlock(blockstate, blockpos, ctx);

        return blockstate.with(SHAPE, asdas).with(IS_CENTER, isInternalBlock);
    }

    private static Boolean checkIfInternalBlock(BlockState blockstate, BlockPos blockpos, ItemPlacementContext ctx) {

        var currentBlockName = blockstate.getBlock().getTranslationKey();
        var northBlockName = ctx.getWorld().getBlockState(blockpos.north(1)).getBlock().getTranslationKey();
        var southBlockName = ctx.getWorld().getBlockState(blockpos.south(1)).getBlock().getTranslationKey();
        var eastBlockName = ctx.getWorld().getBlockState(blockpos.east(1)).getBlock().getTranslationKey();
        var westBlockName = ctx.getWorld().getBlockState(blockpos.west(1)).getBlock().getTranslationKey();
        // System.out.println("getStairsShape" + asdasd);

        int surroundingMatchingBlocksCount = 0;
        if (currentBlockName == northBlockName) {
            surroundingMatchingBlocksCount++;
        }
        if (currentBlockName == southBlockName) {
            surroundingMatchingBlocksCount++;
        }
        if (currentBlockName == eastBlockName) {
            surroundingMatchingBlocksCount++;
        }
        if (currentBlockName == westBlockName) {
            surroundingMatchingBlocksCount++;
        }

        if (surroundingMatchingBlocksCount >= 4) {
            System.out.println("Make it center block");
            return true;
        } else {
            return false;
        }

    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState pState, Direction pFacing, BlockState pFacingState,
            WorldAccess world,
            BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.get(WATERLOGGED)) {
            world.scheduleFluidTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        var currentBlockName = pState.getBlock().getTranslationKey();
        var northBlockName = world.getBlockState(pCurrentPos.north(1)).getBlock().getTranslationKey();
        var southBlockName = world.getBlockState(pCurrentPos.south(1)).getBlock().getTranslationKey();
        var eastBlockName = world.getBlockState(pCurrentPos.east(1)).getBlock().getTranslationKey();
        var westBlockName = world.getBlockState(pCurrentPos.west(1)).getBlock().getTranslationKey();
        // System.out.println("getStairsShape" + asdasd);
        boolean asdasd = false;
        int surroundingMatchingBlocksCount = 0;
        if (currentBlockName == northBlockName) {
            surroundingMatchingBlocksCount++;
        }
        if (currentBlockName == southBlockName) {
            surroundingMatchingBlocksCount++;
        }
        if (currentBlockName == eastBlockName) {
            surroundingMatchingBlocksCount++;
        }
        if (currentBlockName == westBlockName) {
            surroundingMatchingBlocksCount++;
        }

        if (surroundingMatchingBlocksCount >= 4) {
            System.out.println("Make it center block");
            asdasd = true;
        }

        return pFacing.getAxis().isHorizontal()
                ? pState.with(SHAPE, getStairsShape(pState, world, pCurrentPos)).with(IS_CENTER, asdasd)
                : super.getStateForNeighborUpdate(pState, pFacing, pFacingState, world, pCurrentPos, pFacingPos);
    }

    private static StairShape getStairsShape(BlockState pState, BlockView pWorld, BlockPos pPos) {

        Direction direction = pState.get(FACING);
        BlockState blockstate = pWorld.getBlockState(pPos.offset(direction));

        if (isStairs(blockstate) && pState.get(HALF) == blockstate.get(HALF)) {
            Direction direction1 = blockstate.get(FACING);
            if (direction1.getAxis() != pState.get(FACING).getAxis()
                    && isDifferentOrientation(pState, pWorld, pPos, direction1.getOpposite())) {

                if (direction1 == direction.rotateYCounterclockwise()) {
                    return StairShape.OUTER_LEFT;
                }

                return StairShape.OUTER_RIGHT;
            }
        }

        BlockState blockstate1 = pWorld.getBlockState(pPos.offset(direction.getOpposite()));
        if (isStairs(blockstate1) && pState.get(HALF) == blockstate1.get(HALF)) {
            Direction direction2 = blockstate1.get(FACING);
            if (direction2.getAxis() != pState.get(FACING).getAxis()
                    && isDifferentOrientation(pState, pWorld, pPos, direction2)) {
                if (direction2 == direction.rotateYCounterclockwise()) {
                    return StairShape.INNER_LEFT;
                }

                return StairShape.INNER_RIGHT;
            }
        }

        return StairShape.STRAIGHT;
    }

    private static boolean isDifferentOrientation(BlockState state, BlockView world, BlockPos pos, Direction dir) {
        BlockState blockstate = world.getBlockState(pos.offset(dir));
        return !isStairs(blockstate) || blockstate.get(FACING) != state.get(FACING)
                || blockstate.get(HALF) != state.get(HALF);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {

        var asdas = (state.get(HALF) == BlockHalf.TOP ? TOP_SHAPES : BOTTOM_SHAPES)[SHAPE_BY_STATE[this
                .getShapeIndex(state)]];

        return asdas;
    }

    @Nullable
    public int getShapeIndex(BlockState pState) {

        return pState.get(SHAPE).ordinal() * 4 + pState.get(FACING).getHorizontal();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, SHAPE, WATERLOGGED, IS_CENTER);
    }

}