package com.palana.babylonmod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class ModSaplingBlock extends SaplingBlock {
    public ModSaplingBlock(AbstractTreeGrower pTreeGrower, AbstractBlock.Settings settings) {
        super(pTreeGrower, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return true;
    }
}