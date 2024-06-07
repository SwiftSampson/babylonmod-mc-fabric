package com.palana.babylonmod.block.custom;

import net.minecraftforge.common.IPlantable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;

public class ModGrassBlock extends GrassBlock implements IPlantable {

    public ModGrassBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this)
            return defaultBlockState();
        return state;
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing,
            IPlantable plantable) {
        return true;
    }

}