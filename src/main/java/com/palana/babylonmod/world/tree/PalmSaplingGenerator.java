package com.palana.babylonmod.world.tree;

import org.jetbrains.annotations.Nullable;

import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.world.ModConfiguredFeatures;

import net.minecraft.block.BlockState;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class PalmSaplingGenerator extends SaplingGenerator {

    private SizeType size;

    public PalmSaplingGenerator(BlockPos pPos, BlockState pState, SizeType size) {
        super();
        this.size = size;
    }

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {

        switch (size) {
            case XSMALL:
                return ModConfiguredFeatures.PALM_KEY_XSMALL;
            case LARGE:
                return ModConfiguredFeatures.PALM_KEY_LARGE;
            case SMALL:
                return ModConfiguredFeatures.PALM_KEY_SMALL;
            case MEDIUM:
                return ModConfiguredFeatures.PALM_KEY_MEDIUM;
            default:
                return ModConfiguredFeatures.PALM_KEY_MEDIUM;
        }
    }
}
