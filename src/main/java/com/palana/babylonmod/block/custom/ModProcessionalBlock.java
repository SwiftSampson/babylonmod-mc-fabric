package com.palana.babylonmod.block.custom;

import org.jetbrains.annotations.Nullable;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ModProcessionalBlock extends Block {
        public static final IntProperty VARIANT = IntProperty.of("variant", 0, 6);
        public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;

        public ModProcessionalBlock(Settings settings) {
                super(settings);
        }

        @Nullable
        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {

                Integer variant;
                Direction facing = ctx.getHorizontalPlayerFacing();

                BlockState leftBlock;
                String blockName = this.getDefaultState().getBlock().getTranslationKey();

                World blockgetter = ctx.getWorld();
                BlockPos blockpos = ctx.getBlockPos();

                if (facing == Direction.NORTH) {

                        leftBlock = blockgetter.getBlockState(blockpos.west());
                } else if (facing == Direction.SOUTH) {

                        leftBlock = blockgetter.getBlockState(blockpos.east());
                } else if (facing == Direction.EAST) {

                        leftBlock = blockgetter.getBlockState(blockpos.north());
                } else {

                        leftBlock = blockgetter.getBlockState(blockpos.south());
                }

                if (leftBlock.getBlock().getTranslationKey()
                                .equals(blockName)) {
                        if (leftBlock.get(VARIANT) == 0) {
                                variant = 1;
                        } else if (leftBlock.get(VARIANT) == 1) {
                                variant = 2;
                        } else if (leftBlock.get(VARIANT) == 2) {
                                variant = 3;
                        } else if (leftBlock.get(VARIANT) == 3) {
                                variant = 4;
                        } else {
                                variant = 5;

                        }

                } else {
                        variant = 0;

                }
                return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing())
                                .with(VARIANT, variant);

        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
                builder.add(FACING, VARIANT);
        }

}