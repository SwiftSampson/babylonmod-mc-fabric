package com.palana.babylonmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;

import org.jetbrains.annotations.Nullable;

import com.palana.babylonmod.block.custom.types.SizeType;

public class ModScalableBlock extends HorizontalFacingBlock {
    public static EnumProperty<SizeType> SIZE = EnumProperty.of("size", SizeType.class);

    public ModScalableBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(SIZE, SizeType.MEDIUM);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SIZE);
    }

}