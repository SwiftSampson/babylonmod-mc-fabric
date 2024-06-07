package com.palana.babylonmod.worldgen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.block.ModBlocks;
import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.worldgen.tree.custom.PalmFoliagePlacer;
import com.palana.babylonmod.worldgen.tree.custom.PalmTrunkPlacer;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.FeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
        public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_KEY_SMALL = registerKey("palm_small");
        public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_KEY_MEDIUM = registerKey("palm_medium");
        public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_KEY_LARGE = registerKey("palm_large");
        // public static final ResourceKey<ConfiguredFeature<?, ?>> DYNAMIC_SAND_KEY =
        // registerKey("dynamic_sand");
        // public static final ResourceKey<ConfiguredFeature<?, ?>> SNAPDRAGON_KEY =
        // registerKey("snapdragon");

        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
                RuleTest dynamicSandReplaceables = new BlockMatchTest(Blocks.GRASS_BLOCK);

                // List<OreConfiguration.TargetBlockState> dynamicSandBlocks = List.of(
                // OreConfiguration.target(dynamicSandReplaceables,
                // ModBlocks.DYNAMIC_SAND.get().defaultBlockState()));

                // Block leavesBlock = ModBlocks.PALM_LEAVES.get();
                // leavesBlock.getStateForPlacement(new
                // BlockPlaceContext(HorizontalDirectionalBlock));

                // pHeightRandA = minHeight
                // pHeightRandB = maxHeight
                register(context, PALM_KEY_SMALL, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                                BlockStateProvider.simple(ModBlocks.PALM_TRUNK.get()),
                                new PalmTrunkPlacer(1, 5, 6),
                                BlockStateProvider.simple(ModBlocks.PALM_LEAVES.get()),
                                new PalmFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 3, 1),
                                new TwoLayersFeatureSize(0, 0, 0)).build());

                register(context, PALM_KEY_MEDIUM, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                                BlockStateProvider.simple(ModBlocks.PALM_TRUNK.get()),
                                new PalmTrunkPlacer(1, 7, 8),
                                BlockStateProvider.simple(ModBlocks.PALM_LEAVES.get()),
                                new PalmFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 3, 1),
                                new TwoLayersFeatureSize(0, 0, 0)).build());

                register(context, PALM_KEY_LARGE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                                BlockStateProvider.simple(ModBlocks.PALM_TRUNK.get()),
                                new PalmTrunkPlacer(1, 9, 10),
                                BlockStateProvider.simple(ModBlocks.PALM_LEAVES.get()),
                                new PalmFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 3, 2),
                                new TwoLayersFeatureSize(0, 0, 0)).build());

                // register(context, DYNAMIC_SAND_KEY, Feature.ORE, new
                // OreConfiguration(dynamicSandBlocks, 100));
                // register(context, DYNAMIC_SAND_KEY, Feature.REPLACE_SINGLE_BLOCK,
                // new
                // ReplaceBlockConfiguration(ModBlocks.DYNAMIC_SAND.get().defaultBlockState(),
                // dynamicSandReplaceables));

        }

        public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
                return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BabylonMod.MOD_ID, name));
        }

        private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
                        BootstapContext<ConfiguredFeature<?, ?>> context,
                        ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
                context.register(key, new ConfiguredFeature<>(feature, configuration));
        }
}