package com.palana.babylonmod.block.custom;

import org.jetbrains.annotations.Nullable;

import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.block.*;
import net.minecraft.state.property.Properties;

public class ModDirectionalBlock extends HorizontalFacingBlock {
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ModDirectionalBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING,
                ctx.getHorizontalPlayerFacing());

    }

    // @SuppressWarnings("deprecation")
    // @Override
    // public FluidState getFluidState(BlockState state) {
    // return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) :
    // super.getFluidState(state);
    // }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}