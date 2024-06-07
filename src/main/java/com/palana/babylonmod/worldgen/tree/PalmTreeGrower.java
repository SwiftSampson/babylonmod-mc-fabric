package com.palana.babylonmod.worldgen.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.worldgen.ModConfiguredFeatures;

public class PalmTreeGrower extends AbstractTreeGrower {

    private SizeType size;

    public PalmTreeGrower(BlockPos pPos, BlockState pState, SizeType size) {
        super();
        this.size = size;
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {

        switch (this.size) {
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
