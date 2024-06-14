package com.palana.babylonmod.block.custom;

import org.jetbrains.annotations.Nullable;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

import com.palana.babylonmod.block.custom.types.SizeType;

public class DirectionalPalmLeaves extends Block {
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static EnumProperty<SizeType> SIZE = EnumProperty.of("size", SizeType.class);

    public DirectionalPalmLeaves(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing()).with(SIZE,
                SizeType.MEDIUM);
    }

    public BlockState getRandomBlockState() {
        return this.getDefaultState().with(FACING, Direction.EAST).with(SIZE,
                SizeType.MEDIUM);
    }

    public static BlockState rotate(BlockState pState, Direction direction) {
        return pState.with(FACING, direction);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SIZE);
    }

}