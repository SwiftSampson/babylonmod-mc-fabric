package com.palana.babylonmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

public class ModRugBlock extends Block {
        public static final IntProperty VARIANT = IntProperty.of("variant", 0, 6);
        public static DirectionProperty FACING = Properties.FACING;

        public ModRugBlock(Settings settings) {
                super(settings);
        }

        @Nullable
        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {

                Integer variant;
                Direction facing = ctx.getHorizontalPlayerFacing();

                String blockName = this.getDefaultState().getBlock().getTranslationKey();

                World blockgetter = ctx.getWorld();
                BlockPos blockpos = ctx.getBlockPos();
                BlockState aboveBlock;

                if (facing == Direction.NORTH) {
                        aboveBlock = blockgetter.getBlockState(blockpos.north());

                } else if (facing == Direction.SOUTH) {
                        aboveBlock = blockgetter.getBlockState(blockpos.south());

                } else if (facing == Direction.EAST) {
                        aboveBlock = blockgetter.getBlockState(blockpos.east());

                } else {
                        aboveBlock = blockgetter.getBlockState(blockpos.west());

                }

                if (aboveBlock.getBlock().getTranslationKey()
                                .equals(blockName)) {

                        variant = 1;
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