package com.palana.babylonmod.block.custom;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.Direction;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

public class ModConnectedBlock extends StairBlock {

    private Supplier<BlockState> stateSupplier;
    private Object baseState;
    private Block base;
    private static final int[] SHAPE_BY_STATE = new int[] { 12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4,
            1, 2, 8 };
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty IS_CENTER = BooleanProperty.create("is_center");

    public ModConnectedBlock(java.util.function.Supplier<BlockState> state, BlockBehaviour.Properties properties) {

        super(state, properties);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, Half.BOTTOM)
                        .setValue(SHAPE, StairsShape.STRAIGHT).setValue(WATERLOGGED, Boolean.valueOf(false))
                        .setValue(IS_CENTER, false));
        this.base = Blocks.AIR; // These are unused, fields are redirected
        this.baseState = Blocks.AIR.defaultBlockState();
        this.stateSupplier = state;

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockPos blockpos = pContext.getClickedPos();
        FluidState fluidstate = pContext.getLevel().getFluidState(blockpos);
        BlockState blockstate = this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection()).setValue(
                HALF,
                direction != Direction.DOWN && (direction == Direction.UP
                        || !(pContext.getClickLocation().y - (double) blockpos.getY() > 0.5D)) ? Half.BOTTOM : Half.TOP)
                .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
        var asdas = getStairsShape(blockstate, pContext.getLevel(), blockpos);

        var isInternalBlock = checkIfInternalBlock(blockstate, blockpos, pContext);

        return blockstate.setValue(SHAPE, asdas).setValue(IS_CENTER, isInternalBlock);
    }

    private static Boolean checkIfInternalBlock(BlockState blockstate, BlockPos blockpos, BlockPlaceContext pContext) {

        var currentBlockName = blockstate.getBlock().getDescriptionId();
        var northBlockName = pContext.getLevel().getBlockState(blockpos.north(1)).getBlock().getDescriptionId();
        var southBlockName = pContext.getLevel().getBlockState(blockpos.south(1)).getBlock().getDescriptionId();
        var eastBlockName = pContext.getLevel().getBlockState(blockpos.east(1)).getBlock().getDescriptionId();
        var westBlockName = pContext.getLevel().getBlockState(blockpos.west(1)).getBlock().getDescriptionId();
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
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel,
            BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        var currentBlockName = pState.getBlock().getDescriptionId();
        var northBlockName = pLevel.getBlockState(pCurrentPos.north(1)).getBlock().getDescriptionId();
        var southBlockName = pLevel.getBlockState(pCurrentPos.south(1)).getBlock().getDescriptionId();
        var eastBlockName = pLevel.getBlockState(pCurrentPos.east(1)).getBlock().getDescriptionId();
        var westBlockName = pLevel.getBlockState(pCurrentPos.west(1)).getBlock().getDescriptionId();
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
                ? pState.setValue(SHAPE, getStairsShape(pState, pLevel, pCurrentPos)).setValue(IS_CENTER, asdasd)
                : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    private static StairsShape getStairsShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {

        Direction direction = pState.getValue(FACING);
        BlockState blockstate = pLevel.getBlockState(pPos.relative(direction));

        if (isStairs(blockstate) && pState.getValue(HALF) == blockstate.getValue(HALF)) {
            Direction direction1 = blockstate.getValue(FACING);
            if (direction1.getAxis() != pState.getValue(FACING).getAxis()
                    && canTakeShape(pState, pLevel, pPos, direction1.getOpposite())) {

                if (direction1 == direction.getCounterClockWise()) {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState blockstate1 = pLevel.getBlockState(pPos.relative(direction.getOpposite()));
        if (isStairs(blockstate1) && pState.getValue(HALF) == blockstate1.getValue(HALF)) {
            Direction direction2 = blockstate1.getValue(FACING);
            if (direction2.getAxis() != pState.getValue(FACING).getAxis()
                    && canTakeShape(pState, pLevel, pPos, direction2)) {
                if (direction2 == direction.getCounterClockWise()) {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }

        return StairsShape.STRAIGHT;
    }

    private static boolean canTakeShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pFace) {
        BlockState blockstate = pLevel.getBlockState(pPos.relative(pFace));
        return !isStairs(blockstate) || blockstate.getValue(FACING) != pState.getValue(FACING)
                || blockstate.getValue(HALF) != pState.getValue(HALF);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {

        var asdas = (pState.getValue(HALF) == Half.TOP ? TOP_SHAPES : BOTTOM_SHAPES)[SHAPE_BY_STATE[this
                .getShapeIndex(pState)]];

        return asdas;
    }

    @Nullable
    public int getShapeIndex(BlockState pState) {

        return pState.getValue(SHAPE).ordinal() * 4 + pState.getValue(FACING).get2DDataValue();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, HALF, SHAPE, WATERLOGGED, IS_CENTER);
    }

}