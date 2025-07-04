package com.palana.babylonmod.block.custom;

import java.util.Properties;

import com.palana.babylonmod.item.ModItems;
import net.minecraft.state.property.IntProperty;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class ModWheatBlock extends CropBlock {
    public static final int MAX_AGE = 7;
    public static final IntProperty AGE = IntProperty.of("age", 0, 7);

    public ModWheatBlock(Settings pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return true;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BABYLON_WHEAT_SEEDS;
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public boolean propagatesSkylightDown(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

}