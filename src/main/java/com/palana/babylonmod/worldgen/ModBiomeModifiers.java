package com.palana.babylonmod.worldgen;

import com.palana.babylonmod.BabylonMod;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
        public static final ResourceKey<BiomeModifier> ADD_TREE_PALM = registerKey("add_tree_palm");
        // public static final ResourceKey<BiomeModifier> ADD_DYNAMIC_SAND =
        // registerKey("add_dynamic_sand");
        public static final ResourceKey<BiomeModifier> ADD_SNAPDRAGON = registerKey("add_snapdragon");

        public static void bootstrap(BootstapContext<BiomeModifier> context) {
                var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
                var biomes = context.lookup(Registries.BIOME);

                context.register(ADD_TREE_PALM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), // change to IS_DESERT etc
                                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PALM_PLACED_KEY)),
                                GenerationStep.Decoration.VEGETAL_DECORATION));

                // context.register(ADD_DYNAMIC_SAND, new
                // ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                // biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                // HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DYNAMIC_SAND_PLACED_KEY)),
                // GenerationStep.Decoration.TOP_LAYER_MODIFICATION));

        }

        private static ResourceKey<BiomeModifier> registerKey(String name) {
                return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                                new ResourceLocation(BabylonMod.MOD_ID, name));
        }
}