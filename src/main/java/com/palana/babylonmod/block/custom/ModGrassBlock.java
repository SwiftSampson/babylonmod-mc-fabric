package com.palana.babylonmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ModGrassBlock extends GrassBlock {

    public ModGrassBlock(Settings settings) {
        super(settings);
    }

    // @Override
    // public BlockState getPlant(World world, BlockPos pos) {
    // BlockState state = world.getBlockState(pos);
    // if (state.getBlock() != this)
    // return getDefaultState();
    // return state;
    // }

    // @Override
    // public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos
    // pos, Direction facing,
    // IPlantable plantable) {
    // return true;
    // }

}