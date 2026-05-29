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
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import com.palana.babylonmod.block.custom.types.LocationType;

public class ModConnectedLionBlock extends Block {
    public static final IntProperty VARIANT = IntProperty.of("variant", 1, 6);
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    protected static final EnumProperty<LocationType> LOCATION = EnumProperty.of("location", LocationType.class);

    public ModConnectedLionBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {

        Integer variant = 1;
        LocationType location = LocationType.BOTTOM;
        Direction facing = ctx.getHorizontalPlayerFacing();

        BlockState leftBlock;
        BlockState rightBlock;

        String blockName = this.getDefaultState().getBlock().getTranslationKey();

        World blockgetter = ctx.getWorld();
        BlockPos blockpos = ctx.getBlockPos();

        BlockState belowBlock = blockgetter.getBlockState(blockpos.down());

        if (belowBlock.getBlock().getTranslationKey()
                .equals(blockName) && belowBlock.get(LOCATION) == LocationType.BOTTOM) {
            location = LocationType.TOP;
            variant = belowBlock.get(VARIANT);

        } else {

            if (facing == Direction.NORTH) {
                rightBlock = blockgetter.getBlockState(blockpos.east());
                leftBlock = blockgetter.getBlockState(blockpos.west());
            } else if (facing == Direction.SOUTH) {
                rightBlock = blockgetter.getBlockState(blockpos.west());
                leftBlock = blockgetter.getBlockState(blockpos.east());
            } else if (facing == Direction.EAST) {
                rightBlock = blockgetter.getBlockState(blockpos.south());
                leftBlock = blockgetter.getBlockState(blockpos.north());
            } else {
                rightBlock = blockgetter.getBlockState(blockpos.north());
                leftBlock = blockgetter.getBlockState(blockpos.south());
            }

            if (blockName.contains("left")) {
                if (leftBlock.getBlock().getTranslationKey()
                        .equals(blockName) && leftBlock.get(FACING) == facing) {
                    if (leftBlock.get(VARIANT) == 1) {
                        variant = 2;
                    } else if (leftBlock.get(VARIANT) == 2) {
                        variant = 3;
                    } else if (leftBlock.get(VARIANT) == 3) {
                        variant = 4;
                    }

                }
            } else {
                if (rightBlock.getBlock().getTranslationKey()
                        .equals(blockName) && rightBlock.get(FACING) == facing) {
                    if (rightBlock.get(VARIANT) == 1) {
                        variant = 2;
                    } else if (rightBlock.get(VARIANT) == 2) {
                        variant = 3;
                    } else if (rightBlock.get(VARIANT) == 3) {
                        variant = 4;
                    }
                }
            }
        }

        System.out.println("belowBlock " + belowBlock.getBlock().getTranslationKey());
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing())
                .with(VARIANT, variant).with(LOCATION, location);

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, VARIANT, LOCATION);
    }

}

// private Supplier<BlockState> stateSupplier;
// private Object baseState;
// private Block base;
// private static final IntProperty ORDER = IntProperty.of("order", 1, 4);
// public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
// protected static final EnumProperty<LocationType> LOCATION =
// EnumProperty.of("location", LocationType.class);
// // public static final EnumProperty<StairShape> SHAPE =
// Properties.STAIR_SHAPE;
// // public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
// // public static final BooleanProperty IS_CENTER =
// // BooleanProperty.of("is_center");

// @Override
// public BlockState getPlacementState(ItemPlacementContext ctx) {
// Direction direction = ctx.getSide();
// BlockPos blockpos = ctx.getBlockPos();
// FluidState fluidState = ctx.getWorld().getFluidState(blockpos);
// BlockState blockstate = this.getDefaultState();
// Direction facing = ctx.getHorizontalPlayerFacing();
// int blockOrder = 1;

// WorldAccess world = ctx.getWorld();
// // get name of block to be placed
// String currentBlockName =
// this.getDefaultState().getBlock().getTranslationKey();

// Block leftBlock = null;
// Block rightBlock = null;

// if (facing == Direction.WEST) {
// leftBlock = world.getBlockState(blockpos.north(-1)).getBlock();
// rightBlock = world.getBlockState(blockpos.north(1)).getBlock();

// } else if (facing == Direction.EAST) {
// leftBlock = world.getBlockState(blockpos.south(-1)).getBlock();
// rightBlock = world.getBlockState(blockpos.south(1)).getBlock();
// } else if (facing == Direction.NORTH) {
// leftBlock = world.getBlockState(blockpos.east(-1)).getBlock();
// rightBlock = world.getBlockState(blockpos.east(1)).getBlock();
// } else if (facing == Direction.SOUTH) {
// leftBlock = world.getBlockState(blockpos.west(-1)).getBlock();
// rightBlock = world.getBlockState(blockpos.west(1)).getBlock();
// }
// System.out.println("left block:" + leftBlock.getTranslationKey());
// System.out.println("right block: " + rightBlock.getTranslationKey());

// // System.out.println("Left block: " + leftBlock.getTranslationKey());
// // System.out.println("Right block: " + rightBlock.getTranslationKey());

// System.out.println("current block: " + currentBlockName);

// if (currentBlockName.contains("left") && leftBlock != null) {
// System.out.println("left block:" + leftBlock);
// System.out.println("right block: " + rightBlock);
// System.out
// .println("current blockcontainsee left" + leftBlock.getTranslationKey() +
// "=?" + currentBlockName);

// if (leftBlock.getTranslationKey().equals(currentBlockName)) {
// // get left block order
// Integer leftOrder = leftBlock.getDefaultState().get(ORDER);
// System.out.println("Left state: " + leftBlock.getDefaultState());
// int newOrder = leftOrder == 4 ? 1 : leftOrder + 1;
// System.out.println("update order to: " + newOrder);
// blockOrder = newOrder;

// }
// } else if (currentBlockName.contains("right") && rightBlock != null) {
// if (rightBlock.getTranslationKey().equals(currentBlockName)) {
// // get right block order
// BlockState rightOrder = rightBlock.getDefaultState();
// System.out.println("Right order: " + rightOrder);
// // return blockstate.with(ORDER, Math.max(rightOrder + 1, 1));
// }
// }
// System.out
// .println("final blockstate" + blockstate + "order" + blockOrder);
// return blockstate.with(ORDER, blockOrder).with(FACING,
// ctx.getHorizontalPlayerFacing()).with(LOCATION,
// LocationType.BOTTOM);
// }

// private static Boolean checkIfInternalBlock(BlockState blockstate, BlockPos
// blockpos, ItemPlacementContext ctx) {

// var currentBlockName = blockstate.getBlock().getTranslationKey();
// var northBlockName =
// ctx.getWorld().getBlockState(blockpos.north(1)).getBlock().getTranslationKey();
// var southBlockName =
// ctx.getWorld().getBlockState(blockpos.south(1)).getBlock().getTranslationKey();
// var eastBlockName =
// ctx.getWorld().getBlockState(blockpos.east(1)).getBlock().getTranslationKey();
// var westBlockName =
// ctx.getWorld().getBlockState(blockpos.west(1)).getBlock().getTranslationKey();
// // System.out.println("getStairsShape" + asdasd);

// int surroundingMatchingBlocksCount = 0;
// if (currentBlockName == northBlockName) {
// surroundingMatchingBlocksCount++;
// }
// if (currentBlockName == southBlockName) {
// surroundingMatchingBlocksCount++;
// }
// if (currentBlockName == eastBlockName) {
// surroundingMatchingBlocksCount++;
// }
// if (currentBlockName == westBlockName) {
// surroundingMatchingBlocksCount++;
// }

// if (surroundingMatchingBlocksCount >= 4) {
// System.out.println("Make it center block");
// return true;
// } else {
// return false;
// }

// }

// // @Override
// // public BlockState getStateForNeighborUpdate(BlockState pState, Direction
// // pFacing, BlockState pFacingState,
// // WorldAccess world,
// // BlockPos pCurrentPos, BlockPos pFacingPos) {

// // // check if next to a block with the same name. If the matching block is
// to
// // the
// // // left, increment the order (to max of 4). If to the right, decrement the
// // order
// // // (to min of 1).

// // // var currentBlockName = pState.getBlock().getTranslationKey();
// // // var northBlockName =
// // //
// world.getBlockState(pCurrentPos.north(1)).getBlock().getTranslationKey();
// // // var southBlockName =
// // //
// world.getBlockState(pCurrentPos.south(1)).getBlock().getTranslationKey();
// // // var eastBlockName =
// // //
// world.getBlockState(pCurrentPos.east(1)).getBlock().getTranslationKey();
// // // var westBlockName =
// // //
// world.getBlockState(pCurrentPos.west(1)).getBlock().getTranslationKey();
// // // // System.out.println("getStairsShape" + asdasd);
// // // boolean asdasd = false;
// // // int surroundingMatchingBlocksCount = 0;
// // // if (currentBlockName == northBlockName) {
// // // surroundingMatchingBlocksCount++;
// // // }
// // // if (currentBlockName == southBlockName) {
// // // surroundingMatchingBlocksCount++;
// // // }
// // // if (currentBlockName == eastBlockName) {
// // // surroundingMatchingBlocksCount++;
// // // }
// // // if (currentBlockName == westBlockName) {
// // // surroundingMatchingBlocksCount++;
// // // }

// // // if (surroundingMatchingBlocksCount >= 4) {
// // // System.out.println("Make it center block");
// // // asdasd = true;
// // // }

// // // Get the current block's name
// // String currentBlockName = pState.getBlock().getTranslationKey();

// // Block leftBlock = null;
// // Block rightBlock = null;

// // System.out.println("Current facing: " + pFacing);

// // System.out.println("Block +1 north " +
// // world.getBlockState(pCurrentPos.north(1)).getBlock());
// // System.out.println("Block -1 north " +
// // world.getBlockState(pCurrentPos.north(-1)).getBlock());

// // if (pFacing == Direction.WEST) {
// // leftBlock = world.getBlockState(pCurrentPos.west(1)).getBlock();
// // rightBlock = world.getBlockState(pCurrentPos.west(-1)).getBlock();
// // } else if (pFacing == Direction.EAST) {
// // leftBlock = world.getBlockState(pCurrentPos.east(1)).getBlock();
// // rightBlock = world.getBlockState(pCurrentPos.east(-1)).getBlock();
// // } else if (pFacing == Direction.NORTH) {
// // leftBlock = world.getBlockState(pCurrentPos.north(1)).getBlock();
// // rightBlock = world.getBlockState(pCurrentPos.north(-1)).getBlock();
// // } else if (pFacing == Direction.SOUTH) {
// // leftBlock = world.getBlockState(pCurrentPos.south(1)).getBlock();
// // rightBlock = world.getBlockState(pCurrentPos.south(-1)).getBlock();
// // }

// // // System.out.println("Left block: " + leftBlock.getTranslationKey());
// // // System.out.println("Right block: " + rightBlock.getTranslationKey());

// // // System.out.println("current block: " + currentBlockName);

// // if (currentBlockName.contains("left")) {
// // if (leftBlock.getTranslationKey().equals(currentBlockName)) {
// // // get left block order
// // int leftOrder = leftBlock.getDefaultState().get(ORDER);
// // System.out.println("Left order: " + leftOrder);
// // return pState.with(ORDER, Math.min(leftOrder + 1, 4));
// // }
// // } else if (currentBlockName.contains("right")) {
// // if (rightBlock.getTranslationKey().equals(currentBlockName)) {
// // // get right block order
// // int rightOrder = rightBlock.getDefaultState().get(ORDER);
// // System.out.println("Right order: " + rightOrder);
// // return pState.with(ORDER, Math.max(rightOrder + 1, 1));
// // }
// // }

// // return pState;
// // }

// @Override
// protected void appendProperties(StateManager.Builder<Block, BlockState>
// builder) {
// builder.add(FACING, LOCATION, ORDER);
// }

// }