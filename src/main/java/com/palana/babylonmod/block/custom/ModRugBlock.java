package com.palana.babylonmod.block.custom;

import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;

public class ModRugBlock extends Block {
        public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 6);
        public static DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

        public ModRugBlock(Properties pProperties) {
                super(pProperties);
        }

        @Nullable
        @Override
        public BlockState getStateForPlacement(BlockPlaceContext placeContext) {

                Integer variant;
                Direction facing = placeContext.getHorizontalDirection();

                BlockState rightBlock;
                BlockState leftBlock;
                String blockName = this.defaultBlockState().getBlock().getDescriptionId();

                BlockGetter blockgetter = placeContext.getLevel();
                BlockPos blockpos = placeContext.getClickedPos();
                BlockState aboveBlock;// = blockgetter.getBlockState(blockpos.below());

                if (facing == Direction.NORTH) {
                        aboveBlock = blockgetter.getBlockState(blockpos.north());
                        // rightBlock = blockgetter.getBlockState(blockpos.east());
                        // leftBlock = blockgetter.getBlockState(blockpos.west());
                } else if (facing == Direction.SOUTH) {
                        aboveBlock = blockgetter.getBlockState(blockpos.south());
                        // rightBlock = blockgetter.getBlockState(blockpos.west());
                        // leftBlock = blockgetter.getBlockState(blockpos.east());
                } else if (facing == Direction.EAST) {
                        aboveBlock = blockgetter.getBlockState(blockpos.east());
                        // rightBlock = blockgetter.getBlockState(blockpos.south());
                        // leftBlock = blockgetter.getBlockState(blockpos.north());
                } else {
                        aboveBlock = blockgetter.getBlockState(blockpos.west());
                        // rightBlock = blockgetter.getBlockState(blockpos.north());
                        // leftBlock = blockgetter.getBlockState(blockpos.south());
                }

                if (aboveBlock.getBlock().getDescriptionId()
                                .equals(blockName)) {
                        // if (aboveBlock.getValue(VARIANT) == 0) {
                        // variant = 1;
                        // } else if (aboveBlock.getValue(VARIANT) == 1) {
                        // variant = 2;
                        // } else if (leftBlock.getValue(VARIANT) == 2) {
                        // variant = 3;
                        // } else if (leftBlock.getValue(VARIANT) == 3) {
                        // variant = 4;
                        // } else {
                        // variant = 5;

                        // }
                        variant = 1;
                } else {
                        variant = 0;

                }
                return this.defaultBlockState().setValue(FACING, placeContext.getHorizontalDirection())
                                .setValue(VARIANT, variant);

        }

        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
                builder.add(FACING, VARIANT);
        }

}