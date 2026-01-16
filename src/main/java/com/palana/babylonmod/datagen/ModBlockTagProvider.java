package com.palana.babylonmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import com.palana.babylonmod.block.ModBlocks;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.GRASS_ONE)
                .add(ModBlocks.GRASS_TWO)
                .add(ModBlocks.GRASS_BLOCK)
                .add(ModBlocks.GRASS_THREE)
                .add(ModBlocks.GRASS_FOUR)
                .add(ModBlocks.PLANTABLE_BARREL_PLANTER)
                .add(ModBlocks.LARGE_PLANTABLE_BARREL_PLANTER);

    }
}