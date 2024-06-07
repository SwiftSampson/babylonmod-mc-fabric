package com.palana.babylonmod.datagen;

import java.util.function.Function;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BabylonMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        // blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        // blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        // blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        // blockWithItem(ModBlocks.END_STONE_ALEXANDRITE_ORE);
        // blockWithItem(ModBlocks.NETHER_ALEXANDRITE_ORE);

        // stairsBlock((StairBlock) ModBlocks.LAPIS_BRICK_STAIRS.get(),
        // blockTexture(ModBlocks.LAPIS_BRICK.get()));
        // slabBlock((SlabBlock) ModBlocks.LAPIS_BRICK_SLAB.get(),
        // blockTexture(ModBlocks.LAPIS_BRICK.get()),
        // blockTexture(ModBlocks.LAPIS_BRICK.get()));

        // // blockItem(ModBlocks.LAPIS_BRICK_STAIRS);
        // blockItem(ModBlocks.LAPIS_BRICK_SLAB);

        // fenceBlock((FenceBlock) ModBlocks.POLISHED_SANDSTONE_FENCE.get(),
        // blockTexture(ModBlocks.LAPIS_BRICK.get()));

        // logBlock(((RotatedPillarBlock) ModBlocks.PALM_LOG.get()));
        // axisBlock(((RotatedPillarBlock) ModBlocks.WALNUT_WOOD.get()),
        // blockTexture(ModBlocks.WALNUT_LOG.get()),
        // blockTexture(ModBlocks.WALNUT_LOG.get()));
        // axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WALNUT_LOG.get(),
        // new ResourceLocation(BabylonMod.MOD_ID, "block/stripped_walnut_log"),
        // new ResourceLocation(BabylonMod.MOD_ID, "block/stripped_walnut_log_top"));
        // axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WALNUT_WOOD.get(),
        // new ResourceLocation(BabylonMod.MOD_ID, "block/stripped_walnut_log"),
        // new ResourceLocation(BabylonMod.MOD_ID, "block/stripped_walnut_log"));

        // blockItem(ModBlocks.PALM_LOG);
        // blockItem(ModBlocks.WALNUT_WOOD);
        // blockItem(ModBlocks.STRIPPED_WALNUT_LOG);
        // blockItem(ModBlocks.STRIPPED_WALNUT_WOOD);

        // blockWithItem(ModBlocks.WALNUT_PLANKS);

        // leavesBlock(ModBlocks.PALM_LEAVES);
        saplingBlock(ModBlocks.PALM_SAPLING);
        saplingBlock(ModBlocks.PALM_SAPLING_SMALL);
        saplingBlock(ModBlocks.PALM_SAPLING_LARGE);

        // blockItem(ModBlocks.PALM_LOG);
        // logBlock(((RotatedPillarBlock) ModBlocks.PALM_LOG.get()));

        // stairsBlock((StairBlock) ModBlocks.SANDSTONE_PEAK.get(),
        // blockTexture(ModBlocks.LAPIS_BRICK.get()));

    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                "babylonmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
