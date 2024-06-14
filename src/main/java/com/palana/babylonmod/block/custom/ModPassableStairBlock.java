package com.palana.babylonmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

public class ModPassableStairBlock extends StairsBlock {

    private Supplier<BlockState> stateSupplier;
    private Object baseState;
    private Block base;
    private static final int[] SHAPE_BY_STATE = new int[] { 12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4,
            1, 2, 8 };

    public ModPassableStairBlock(BlockState baseBlockState, AbstractBlock.Settings settings) {

        super(baseBlockState, settings);
        this.setDefaultState(
                (BlockState) ((BlockState) ((BlockState) ((BlockState) ((BlockState) this.stateManager
                        .getDefaultState())
                        .with(FACING, Direction.NORTH))
                        .with(HALF, BlockHalf.BOTTOM))
                        .with(SHAPE, StairShape.STRAIGHT))
                        .with(WATERLOGGED, Boolean.valueOf(false)));
        this.base = Blocks.AIR; // These are unused, fields are redirected
        this.baseState = Blocks.AIR.getDefaultState();
        // this.stateSupplier = state;

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
        System.out.println("BLOCK SHAPE" + asdas);
        System.out.println("FACING" + ctx.getHorizontalPlayerFacing());
        System.out.println("HALF" + blockstate.get(HALF));

        return blockstate.with(SHAPE, asdas);
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

    private static boolean isDifferentOrientation(BlockState pState, BlockView world, BlockPos pPos, Direction pFace) {
        BlockState blockstate = world.getBlockState(pPos.offset(pFace));
        return !isStairs(blockstate) || blockstate.get(FACING) != pState.get(FACING)
                || blockstate.get(HALF) != pState.get(HALF);
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

}