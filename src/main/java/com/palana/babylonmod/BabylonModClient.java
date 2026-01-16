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
        // BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING,
        // RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.OAK_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.OAK_LEAVES, RenderLayer.getCutout());
        // BlockRenderLayerMap.INSTANCE.putBlock(BabylonMod.LAPIS_STEPPED_PEAK,
        // RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHESTNUT_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALM_SAPLING,
                RenderLayer.getCutout());

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xbfb755, ModBlocks.GRASS_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xbfb755, ModBlocks.GRASS_BLOCK);

    }

}
