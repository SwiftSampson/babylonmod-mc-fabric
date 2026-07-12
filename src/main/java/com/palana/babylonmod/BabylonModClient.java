package com.palana.babylonmod;

import com.palana.babylonmod.block.ModBlocks;

import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;

public class BabylonModClient implements ClientModInitializer {
    public static final String MOD_ID = "babylonmod";

    @Override
    public void onInitializeClient() {
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> BabylonMod.MOD_ID.equals(location.getNamespace()));

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.OAK_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.OAK_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BABYLON_WHEAT_CROP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_SAPLING_XSMALL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_SAPLING_SMALL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_SAPLING_LARGE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_LEAVES_2, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYPRESS,
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYPRESS_LARGE,
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYPRESS_SMALL,
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYPRESS_POT,
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYPRESS_POT_SMALL,
                RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRASS_BLOCK, RenderLayer.getCutoutMipped());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.GRASS_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.GRASS_BLOCK);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRASS_ONE, RenderLayer.getCutoutMipped());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.GRASS_ONE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.GRASS_ONE);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRASS_TWO, RenderLayer.getCutoutMipped());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.GRASS_TWO);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.GRASS_TWO);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRASS_THREE, RenderLayer.getCutoutMipped());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.GRASS_THREE);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.GRASS_THREE);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRASS_FOUR, RenderLayer.getCutoutMipped());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.GRASS_FOUR);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.GRASS_FOUR);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BABYLON_SHORT_GRASS, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.BABYLON_SHORT_GRASS);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.BABYLON_SHORT_GRASS);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BABYLON_FERN, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.BABYLON_FERN);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.BABYLON_FERN);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BABYLON_LARGE_FERN, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.BABYLON_LARGE_FERN);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.BABYLON_LARGE_FERN);

        // Foliage Light — fixed colour sampled from BabylonCraft oak_leaves colormap
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FOLIAGE_LIGHT, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xAFB260, ModBlocks.FOLIAGE_LIGHT);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xAFB260, ModBlocks.FOLIAGE_LIGHT);

        // Foliage Dark — untinted azalea leaves, texture colour is used as-is
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FOLIAGE_DARK, RenderLayer.getCutout());

        // Foliage Flowers — untinted flowering azalea, texture colour is used as-is
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FOLIAGE_FLOWERS, RenderLayer.getCutout());
    }
}
