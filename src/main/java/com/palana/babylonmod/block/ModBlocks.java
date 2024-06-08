package com.palana.babylonmod.block;

import com.palana.babylonmod.BabylonMod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.block.*;

public class ModBlocks {

    public static final Block SMALL_BARREL = registerBlock("small_barrel",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block LAPIS_BRICK_STAIRS = registerBlock("lapis_brick_stairs",
            new StairsBlock(Blocks.SANDSTONE.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS)));

    // private static Block registerBlockWithoutBlockItem(String name, Block block)
    // {
    // return Registry.register(Registries.BLOCK, new Identifier(BabylonMod.MOD_ID,
    // name), block);
    // }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BabylonMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BabylonMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BabylonMod.LOGGER.info("Registering ModBlocks for " + BabylonMod.MOD_ID);
    }
}
