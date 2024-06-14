package com.palana.babylonmod.block.custom;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ModIshtarGateBlock extends Block {
        public static final IntProperty VARIANT = IntProperty.of("variant", 0, 6);

        public ModIshtarGateBlock(Settings settings) {
                super(settings);
        }

        @Nullable
        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {

                Direction facing = ctx.getHorizontalPlayerFacing();

                BlockState leftBlock;
                String blockName = this.getDefaultState().getBlock().getTranslationKey();

                World blockgetter = ctx.getWorld();
                BlockPos blockpos = ctx.getBlockPos();
                BlockState belowBlock = blockgetter.getBlockState(blockpos.down());

                if (facing == Direction.NORTH) {

                        leftBlock = blockgetter.getBlockState(blockpos.west());
                } else if (facing == Direction.SOUTH) {

                        leftBlock = blockgetter.getBlockState(blockpos.east());
                } else if (facing == Direction.EAST) {

                        leftBlock = blockgetter.getBlockState(blockpos.north());
                } else {

                        leftBlock = blockgetter.getBlockState(blockpos.south());
                }

                if (belowBlock.getBlock().getTranslationKey()
                                .equals(blockName)) {
                        if (belowBlock.get(VARIANT) == 3) {
                                return this.getDefaultState().with(VARIANT, 1);
                        } else if (belowBlock.get(VARIANT) == 4) {
                                return this.getDefaultState().with(VARIANT, 2);
                        } else if (belowBlock.get(VARIANT) == 1) {
                                return this.getDefaultState().with(VARIANT, 3);
                        } else {
                                return this.getDefaultState().with(VARIANT, 4);
                        }
                } else if (leftBlock.getBlock().getTranslationKey()
                                .equals(blockName)) {
                        if (leftBlock.get(VARIANT) == 3) {
                                return this.getDefaultState().with(VARIANT, 4);
                        } else {
                                return this.getDefaultState().with(VARIANT, 3);
                        }

                } else {
                        return this.getDefaultState().with(VARIANT, 3);
                }
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
                builder.add(VARIANT);
        }

}