package com.palana.babylonmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import java.util.List;
import java.util.Optional;
import net.minecraft.util.math.random.Random;

public class ModGrassBlock extends GrassBlock {

    public ModGrassBlock(Settings settings) {
        super(settings);
    }

}