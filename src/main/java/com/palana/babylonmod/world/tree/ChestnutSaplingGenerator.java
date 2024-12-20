package com.palana.babylonmod.world.tree;

import org.jetbrains.annotations.Nullable;

import com.palana.babylonmod.world.ModConfiguredFeatures;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ChestnutSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.CHESTNUT_KEY;
    }
}
