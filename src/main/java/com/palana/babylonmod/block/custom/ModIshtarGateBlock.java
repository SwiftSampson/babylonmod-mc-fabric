package com.palana.babylonmod.block.custom;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;

public class ModIshtarGateBlock extends Block {
        public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 6);
        public String asdasdasd = "";
        // public static EnumProperty<IshtarGateType> GATE_TYPE =
        // EnumProperty.create("ishtar_gate_type",
        // IshtarGateType.class);

        public ModIshtarGateBlock(Properties pProperties) {

                super(pProperties);

        }

        @Nullable
        @Override
        public BlockState getStateForPlacement(BlockPlaceContext placeContext) {

                Direction facing = placeContext.getHorizontalDirection();

                BlockState rightBlock;
                BlockState leftBlock;
                String blockName = this.defaultBlockState().getBlock().getDescriptionId();

                BlockGetter blockgetter = placeContext.getLevel();
                BlockPos blockpos = placeContext.getClickedPos();
                BlockState belowBlock = blockgetter.getBlockState(blockpos.below());

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

                if (belowBlock.getBlock().getDescriptionId()
                                .equals(blockName)) {
                        if (belowBlock.getValue(VARIANT) == 3) {
                                return this.defaultBlockState().setValue(VARIANT, 1);
                        } else if (belowBlock.getValue(VARIANT) == 4) {
                                return this.defaultBlockState().setValue(VARIANT, 2);
                        } else if (belowBlock.getValue(VARIANT) == 1) {
                                return this.defaultBlockState().setValue(VARIANT, 3);
                        } else {
                                return this.defaultBlockState().setValue(VARIANT, 4);
                        }
                } else if (leftBlock.getBlock().getDescriptionId()
                                .equals(blockName)) {
                        if (leftBlock.getValue(VARIANT) == 3) {
                                return this.defaultBlockState().setValue(VARIANT, 4);
                        } else {
                                return this.defaultBlockState().setValue(VARIANT, 3);
                        }

                } else {
                        return this.defaultBlockState().setValue(VARIANT, 3);

                }

        }

        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
                builder.add(VARIANT);
        }

}