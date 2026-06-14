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

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.GRASS_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.GRASS_BLOCK);

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
