package com.palana.babylonmod.world;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.block.ModBlocks;
import com.palana.babylonmod.world.tree.custom.PalmFoliagePlacer;
import com.palana.babylonmod.world.tree.custom.PalmTrunkPlacer;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {
        public static final RegistryKey<ConfiguredFeature<?, ?>> CHESTNUT_KEY = registerKey("chestnut");
        public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_KEY_XSMALL = registerKey("palm_xsmall");
        public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_KEY_SMALL = registerKey("palm_small");
        public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_KEY_MEDIUM = registerKey("palm_medium");
        public static final RegistryKey<ConfiguredFeature<?, ?>> PALM_KEY_LARGE = registerKey("palm_large");

        public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {

                register(context, CHESTNUT_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                                BlockStateProvider.of(Blocks.OAK_LOG),
                                new StraightTrunkPlacer(5, 4, 3),

                                BlockStateProvider.of(Blocks.OAK_LEAVES),
                                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),

                                new TwoLayersFeatureSize(1, 0, 2)).build());

                register(context, PALM_KEY_LARGE, Feature.TREE, new TreeFeatureConfig.Builder(
                                BlockStateProvider.of(ModBlocks.PALM_TRUNK),
                                new PalmTrunkPlacer(1, 9, 10),

                                BlockStateProvider.of(ModBlocks.PALM_LEAVES),
                                new PalmFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), 3,
                                                1),

                                new TwoLayersFeatureSize(0, 0, 0)).build());

                register(context, PALM_KEY_SMALL, Feature.TREE, new TreeFeatureConfig.Builder(
                                BlockStateProvider.of(ModBlocks.PALM_TRUNK),
                                new PalmTrunkPlacer(1, 5, 6),

                                BlockStateProvider.of(ModBlocks.PALM_LEAVES),
                                new PalmFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), 3,
                                                1),

                                new TwoLayersFeatureSize(0, 0, 0)).build());

                register(context, PALM_KEY_XSMALL, Feature.TREE, new TreeFeatureConfig.Builder(
                                BlockStateProvider.of(ModBlocks.PALM_TRUNK),
                                new PalmTrunkPlacer(1, 2, 4),

                                BlockStateProvider.of(ModBlocks.PALM_LEAVES),
                                new PalmFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), 3,
                                                1),

                                new TwoLayersFeatureSize(0, 0, 0)).build());

                register(context, PALM_KEY_MEDIUM, Feature.TREE, new TreeFeatureConfig.Builder(
                                BlockStateProvider.of(ModBlocks.PALM_TRUNK),
                                new PalmTrunkPlacer(1, 7, 8),

                                BlockStateProvider.of(ModBlocks.PALM_LEAVES),
                                new PalmFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), 3,
                                                1),

                                new TwoLayersFeatureSize(0, 0, 0)).build());

                // register(context, PALM_KEY_LARGE, Feature.TREE, new
                // TreeFeatureConfig.Builder(
                // BlockStateProvider.of(ModBlocks.PALM_TRUNK),
                // new PalmTrunkPlacer(1, 7, 8),

                // BlockStateProvider.of(ModBlocks.PALM_LEAVES),
                // new PalmFoliagePlacer(ConstantIntProvider.create(1),
                // ConstantIntProvider.create(1), 3, 1),

                // new TwoLayersFeatureSize(0, 0, 0)).build());
        }

        public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
                return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(BabylonMod.MOD_ID, name));
        }

        private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
                        Registerable<ConfiguredFeature<?, ?>> context,
                        RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
                context.register(key, new ConfiguredFeature<>(feature, configuration));
        }

}
