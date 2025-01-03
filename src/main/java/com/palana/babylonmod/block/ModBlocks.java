package com.palana.babylonmod.block;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.block.custom.DirectionalPalmLeaves;
import com.palana.babylonmod.block.custom.ModConnectedBlock;
import com.palana.babylonmod.block.custom.ModDirectionalBlock;
import com.palana.babylonmod.block.custom.ModDirectionalSlabBlock;
import com.palana.babylonmod.block.custom.ModDynamicSandBlock;
import com.palana.babylonmod.block.custom.ModGrassBlock;
import com.palana.babylonmod.block.custom.ModIshtarGateBlock;
import com.palana.babylonmod.block.custom.ModPassableStairBlock;
import com.palana.babylonmod.block.custom.ModProcessionalBlock;
import com.palana.babylonmod.block.custom.ModRugBlock;
import com.palana.babylonmod.block.custom.ModSaplingBlock;
import com.palana.babylonmod.block.custom.ModScalableBlock;
import com.palana.babylonmod.block.custom.ModWheatBlock;
import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.world.tree.ChestnutSaplingGenerator;
import com.palana.babylonmod.world.tree.PalmSaplingGenerator;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;

// Block transparency: https://fabricmc.net/wiki/tutorial:blockappearance

public class ModBlocks {

        public static Block LAPIS_BRICK = registerBlock("lapis_brick",
                        new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL)));

        public static Block LAPIS_BRICK_STAIRS = registerBlock("lapis_brick_stairs",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS)));

        public static Block LAPIS_BRICK_SLAB = registerBlock("lapis_brick_slab",
                        new SlabBlock(FabricBlockSettings.copyOf(Blocks.SANDSTONE_SLAB)));

        public static Block PALM_CORE_BOTTOM = registerBlock("palm_core_bottom",
                        new Block(FabricBlockSettings.copyOf(Blocks.FERN)));

        public static Block PALM_CORE_TOP = registerBlock("palm_core_top",
                        new Block(FabricBlockSettings.copyOf(Blocks.FERN)));

        public static Block PALM_LEAVES = registerBlock("palm_leaves",
                        new DirectionalPalmLeaves(
                                        FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

        public static Block PALM_LEAVES_2 = registerBlock("palm_leaves_2",
                        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

        public static Block PALM_TOP = registerBlock("palm_top",
                        new DirectionalPalmLeaves(
                                        FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

        public static Block PALM_TRUNK = registerBlock("palm_trunk",
                        new ModScalableBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));

        public static Block OAK_LOG_TWO = registerBlock("oak_log_two",
                        new ModScalableBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block PALM_CORE_FROND = registerBlock("palm_core_frond",
                        new Block(FabricBlockSettings.copyOf(Blocks.FERN)));

        // Straight tower shit
        public static Block SANDSTONE_PEAK = registerBlock("sandstone_peak",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block LAPIS_PEAK = registerBlock("lapis_peak",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_PEAK_CORNER = registerBlock("lapis_peak_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_STEPPED_PEAK = registerBlock("lapis_stepped_peak",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_STEPPED_PEAK_CORNER = registerBlock("lapis_stepped_peak_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block SANDSTONE_STEPPED_PEAK = registerBlock("sandstone_stepped_peak",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_STEPPED_PEAK_CORNER = registerBlock(
                        "sandstone_stepped_peak_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_INSET_WINDOW = registerBlock("sandstone_inset_window",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_SINGLE_ARCH = registerBlock("sandstone_single_arch",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block LIME_GYPSUM_PLASTER_SINGLE_ARCH = registerBlock(
                        "lime_gypsum_plaster_single_arch",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_SINGLE_ARCH_STEPPED = registerBlock(
                        "sandstone_single_arch_stepped",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_DOUBLE_ARCH = registerBlock("sandstone_double_arch",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque()));

        public static Block LIME_GYPSUM_PLASTER_DOUBLE_ARCH = registerBlock(
                        "lime_gypsum_plaster_double_arch",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque()));

        public static Block NARROW_SANDSTONE_PEAK = registerBlock("narrow_sandstone_peak",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL).nonOpaque()));

        public static Block SANDSTONE_TRIPLE_ARCH = registerBlock("sandstone_triple_arch",
                        new ModPassableStairBlock(Blocks.SANDSTONE_STAIRS.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS).nonOpaque()));

        public static Block SANDSTONE_TRIPLE_ARCH_CENTER = registerBlock(
                        "sandstone_triple_arch_center",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block LIME_GYPSUM_PLASTER_TRIPLE_ARCH = registerBlock(
                        "lime_gypsum_plaster_triple_arch",
                        new ModPassableStairBlock(Blocks.SANDSTONE_STAIRS.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS).nonOpaque()));

        public static Block LIME_GYPSUM_PLASTER_TRIPLE_ARCH_CENTER = registerBlock(
                        "lime_gypsum_plaster_triple_arch_center",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_FIVE_ARCH_CENTER = registerBlock(
                        "sandstone_five_arch_center",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque()));

        public static Block SANDSTONE_FIVE_ARCH_TOP = registerBlock(
                        "sandstone_five_arch_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque()));

        public static Block SANDSTONE_FIVE_ARCH_MID = registerBlock(
                        "sandstone_five_arch_mid",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque()));

        public static Block SANDSTONE_FIVE_ARCH_BOTTOM = registerBlock(
                        "sandstone_five_arch_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque()));

        public static Block LAPIS_FIVE_ARCH_CENTER = registerBlock(
                        "lapis_five_arch_center",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_FIVE_ARCH_TOP = registerBlock(
                        "lapis_five_arch_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_FIVE_ARCH_MID = registerBlock(
                        "lapis_five_arch_mid",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_FIVE_ARCH_BOTTOM = registerBlock(
                        "lapis_five_arch_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block NARROW_SANDSTONE_SINGLE_ARCH = registerBlock(
                        "narrow_sandstone_single_arch",
                        new ModPassableStairBlock(Blocks.SANDSTONE.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque()));

        public static Block NARROW_SANDSTONE_SINGLE_ARCH_TALL = registerBlock(
                        "narrow_sandstone_single_arch_tall",
                        new ModPassableStairBlock(Blocks.SANDSTONE.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE).nonOpaque()));

        public static Block LAPIS_INSET_WINDOW = registerBlock("lapis_inset_window",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block LAPIS_SINGLE_ARCH = registerBlock("lapis_single_arch",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block LAPIS_DOUBLE_ARCH = registerBlock("lapis_double_arch",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_TRIPLE_ARCH = registerBlock("lapis_triple_arch",
                        new ModPassableStairBlock(Blocks.SANDSTONE_STAIRS.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_TRIPLE_ARCH_CENTER = registerBlock(
                        "lapis_triple_arch_center",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block NARROW_LAPIS_SINGLE_ARCH = registerBlock(
                        "narrow_lapis_single_arch",
                        new ModPassableStairBlock(Blocks.SANDSTONE.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block NARROW_LAPIS_SINGLE_ARCH_TALL = registerBlock(
                        "narrow_lapis_single_arch_tall",
                        new ModPassableStairBlock(Blocks.SANDSTONE.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block SANDSTONE_PEAK_CORNER = registerBlock("sandstone_peak_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_COVER = registerBlock(
                        "sandstone_cover",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

        public static Block SANDSTONE_STEPPED_BLOCK_BOTTOM_TOP = registerBlock(
                        "sandstone_stepped_block_bottom_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "sandstone_stepped_block_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_STEPPED_BLOCK_BOTTOM_SHADOW = registerBlock(
                        "sandstone_stepped_block_bottom_shadow",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block CHISELED_SANDSTONE_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "chiseled_sandstone_stepped_block_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_WINDOW_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "sandstone_window_stepped_block_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block LAPIS_WINDOW_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "lapis_window_stepped_block_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "lapis_stepped_block_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_STEPPED_BLOCK_BOTTOM_TOP = registerBlock(
                        "lapis_stepped_block_bottom_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block SANDSTONE_EXTENDED_BLOCK = registerBlock(
                        "sandstone_extended_block",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block SANDSTONE_EXTENDED_FULL_BLOCK = registerBlock(
                        "sandstone_extended_full_block",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_BANDED_EXTENDED_BLOCK = registerBlock(
                        "lapis_banded_extended_block",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_EXTENDED_BLOCK = registerBlock(
                        "lapis_extended_block",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block SANDSTONE_STEPPED_BOTTOM_CORNER_TOP = registerBlock(
                        "sandstone_stepped_bottom_corner_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_STEPPED_BOTTOM_CORNER = registerBlock(
                        "sandstone_stepped_bottom_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_STEPPED_BOTTOM_CORNER_SHADOW = registerBlock(
                        "sandstone_stepped_bottom_corner_shadow",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block CHISELED_SANDSTONE_STEPPED_BOTTOM_CORNER = registerBlock(
                        "chiseled_sandstone_stepped_bottom_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block LAPIS_STEPPED_BOTTOM_CORNER = registerBlock(
                        "lapis_stepped_bottom_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_STEPPED_BOTTOM_CORNER_TOP = registerBlock(
                        "lapis_stepped_bottom_corner_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block SANDSTONE_EXTENDED_BLOCK_CORNER = registerBlock(
                        "sandstone_extended_block_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block EXTENDED_CORNER = registerBlock(
                        "extended_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_BANDED_EXTENDED_BLOCK_CORNER = registerBlock(
                        "lapis_banded_extended_block_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_EXTENDED_BLOCK_CORNER = registerBlock(
                        "lapis_extended_block_corner",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        // Diagonal tower shit
        public static Block SANDSTONE_DIAGONAL_WALL = registerBlock(
                        "sandstone_diagonal_wall",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL).nonOpaque()));

        public static Block SANDSTONE_DIAGONAL_WALL_MUDDY_TOP = registerBlock(
                        "sandstone_diagonal_wall_muddy_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL).nonOpaque()));

        public static Block SANDSTONE_DIAGONAL_WALL_MUDDY_BOTTOM = registerBlock(
                        "sandstone_diagonal_wall_muddy_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL).nonOpaque()));

        public static Block SANDSTONE_DIAGONAL_WALL_SHADOWED = registerBlock(
                        "sandstone_diagonal_wall_shadowed",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL).nonOpaque()));

        public static Block SANDSTONE_PEAK_DIAGONAL = registerBlock("sandstone_peak_diagonal",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block GRASS_TWO = registerBlock("grass_two",
                        new ModGrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)));

        public static Block SANDY_STONES = registerBlock("sandy_stones",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SAND)));

        public static Block LIME_GYPSUM_PLASTER = registerBlock("lime_gypsum_plaster",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE)));

        public static Block LIME_GYPSUM_PLASTER_DARK = registerBlock("lime_gypsum_plaster_dark",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE)));

        public static Block LIME_GYPSUM_PLASTER_BOTTOM_FADE = registerBlock(
                        "lime_gypsum_plaster_bottom_fade",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE)));

        public static Block LIME_GYPSUM_PLASTER_ROOF = registerBlock("lime_gypsum_plaster_roof",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE)));

        public static Block LIME_GYPSUM_PLASTER_RECESS = registerBlock(
                        "lime_gypsum_plaster_recess",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS)));

        public static Block SANDSTONE_PEAK_CORNER_DIAGONAL = registerBlock(
                        "sandstone_peak_corner_diagonal",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_STEPPED_BLOCK_BOTTOM_DIAGONAL = registerBlock(
                        "sandstone_stepped_block_bottom_diagonal",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_STEPPED_BLOCK_BOTTOM_DIAGONAL_SHADOWED = registerBlock(
                        "sandstone_stepped_block_bottom_diagonal_shadowed",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_EXTENDED_BLOCK_DIAGONAL = registerBlock(
                        "sandstone_extended_block_diagonal",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_STEPPED_BOTTOM_CORNER_DIAGONAL = registerBlock(
                        "sandstone_stepped_bottom_corner_diagonal",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_EXTENDED_BLOCK_CORNER_DIAGONAL = registerBlock(
                        "sandstone_extended_block_corner_diagonal",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_ROUND_WINDOW = registerBlock(
                        "sandstone_round_window",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block SANDSTONE_ROUND_WINDOW_EXTENDED = registerBlock(
                        "sandstone_round_window_extended",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

        public static Block LAPIS_ROUND_WINDOW = registerBlock(
                        "lapis_round_window",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block LAPIS_ROUND_WINDOW_EXTENDED = registerBlock(
                        "lapis_round_window_extended",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS).nonOpaque()));

        public static Block SANDSTONE_WINDOW_RECTANGLE = registerBlock(
                        "sandstone_window_rectangle",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS).nonOpaque()));

        public static Block SANDSTONE_WINDOW_RECTANGLE_STEPPED = registerBlock(
                        "sandstone_window_rectangle_stepped",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_STAIRS)));

        public static Block POLISHED_SANDSTONE_FENCE = registerBlock(
                        "polished_sandstone_fence",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block POLISHED_SANDSTONE_FENCE_SMALL = registerBlock(
                        "polished_sandstone_fence_small",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block POLISHED_SANDSTONE_FENCE_SHORT = registerBlock(
                        "polished_sandstone_fence_short",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block POLISHED_SANDSTONE_FENCE_SHORT_SMALL = registerBlock(
                        "polished_sandstone_fence_short_small",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block LIME_GYPSUM_PLASTER_FENCE = registerBlock(
                        "lime_gypsum_plaster_fence",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block LIME_GYPSUM_PLASTER_FENCE_SMALL = registerBlock(
                        "lime_gypsum_plaster_fence_small",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block LIME_GYPSUM_PLASTER_FENCE_SHORT = registerBlock(
                        "lime_gypsum_plaster_fence_short",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block LIME_GYPSUM_PLASTER_FENCE_SHORT_SMALL = registerBlock(
                        "lime_gypsum_plaster_fence_short_small",
                        new StairsBlock(ModBlocks.LAPIS_BRICK.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block DYNAMIC_SAND = registerBlock(
                        "dynamic_sand",
                        new ModDynamicSandBlock(
                                        FabricBlockSettings.copyOf(Blocks.SAND)));

        public static Block ISHTAR_GATE_AUROCH_GOLD_LEFT = registerBlock(
                        "ishtar_gate_auroch_gold_left",
                        new ModIshtarGateBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block ISHTAR_GATE_AUROCH_WHITE_LEFT = registerBlock(
                        "ishtar_gate_auroch_white_left",
                        new ModIshtarGateBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block ISHTAR_GATE_DRAGON_GOLD_LEFT = registerBlock(
                        "ishtar_gate_dragon_gold_left",
                        new ModIshtarGateBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block ISHTAR_GATE_DRAGON_WHITE_LEFT = registerBlock(
                        "ishtar_gate_dragon_white_left",
                        new ModIshtarGateBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block ISHTAR_GATE_AUROCH_GOLD_RIGHT = registerBlock(
                        "ishtar_gate_auroch_gold_right",
                        new ModIshtarGateBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block ISHTAR_GATE_AUROCH_WHITE_RIGHT = registerBlock(
                        "ishtar_gate_auroch_white_right",
                        new ModIshtarGateBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block ISHTAR_GATE_DRAGON_GOLD_RIGHT = registerBlock(
                        "ishtar_gate_dragon_gold_right",
                        new ModIshtarGateBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block ISHTAR_GATE_DRAGON_WHITE_RIGHT = registerBlock(
                        "ishtar_gate_dragon_white_right",
                        new ModIshtarGateBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block LAPIS_GATE_BORDER_RIGHT = registerBlock(
                        "lapis_gate_border_right",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block LAPIS_GATE_BORDER_LEFT = registerBlock(
                        "lapis_gate_border_left",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block PALM_SAPLING_XSMALL = registerBlock("palm_sapling_xsmall",
                        new ModSaplingBlock(new PalmSaplingGenerator(null, null, SizeType.XSMALL),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));

        public static Block PALM_SAPLING = registerBlock("palm_sapling",
                        new ModSaplingBlock(new PalmSaplingGenerator(null, null, SizeType.MEDIUM),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));

        public static Block PALM_SAPLING_LARGE = registerBlock("palm_sapling_large",
                        new ModSaplingBlock(new PalmSaplingGenerator(null, null, SizeType.LARGE),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));

        public static Block PALM_SAPLING_SMALL = registerBlock("palm_sapling_small",
                        new ModSaplingBlock(new PalmSaplingGenerator(null, null, SizeType.SMALL),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        // public static final Block DRIFTWOOD_SAPLING =
        // registerBlock("driftwood_sapling",
        // new ModSaplingBlock(new DriftwoodSaplingGenerator(),
        // FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));

        public static final Block CHESTNUT_SAPLING = registerBlock("chestnut_sapling",
                        new ModSaplingBlock(new ChestnutSaplingGenerator(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        // public static final Block PALM_SAPLING = registerBlock("palm_sapling",
        // new ModSaplingBlock(new PalmSaplingGenerator(),
        // FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block SANDSTONE_BRIDGE_BACK_RIGHT = registerBlock(
                        "sandstone_bridge_back_right",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_BACK_LEFT = registerBlock(
                        "sandstone_bridge_back_left",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_CENTER = registerBlock(
                        "sandstone_bridge_front_center",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_RIGHT = registerBlock(
                        "sandstone_bridge_front_right",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_LEFT = registerBlock(
                        "sandstone_bridge_front_left",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block MARKET_STALL = registerBlock(
                        "market_stall",
                        new ModConnectedBlock(Blocks.SANDSTONE_STAIRS.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block OFFSET_FENCE_POST = registerBlock(
                        "offset_fence_post",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block MARKET_ROOF_SLANTED = registerBlock(
                        "market_roof_slanted",
                        new ModDirectionalSlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block SANDSTONE_BRIDGE_BACK_RIGHT_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_back_right_muddy_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_BACK_LEFT_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_back_left_muddy_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_CENTER_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_front_center_muddy_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_RIGHT_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_front_right_muddy_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_LEFT_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_front_left_muddy_bottom",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_BACK_RIGHT_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_back_right_muddy_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_BACK_LEFT_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_back_left_muddy_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_CENTER_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_front_center_muddy_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_RIGHT_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_front_right_muddy_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block SANDSTONE_BRIDGE_FRONT_LEFT_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_front_left_muddy_top",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));

        public static Block LAMASSU = registerBlock(
                        "lamassu",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block SMALL_BARREL = registerBlock(
                        "small_barrel",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block LARGE_BARREL = registerBlock(
                        "large_barrel",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block MARKET_TABLE = registerBlock(
                        "market_table",
                        new ModPassableStairBlock(Blocks.SANDSTONE_STAIRS.getDefaultState(),
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block MARKET_TABLE_SINGLE = registerBlock(
                        "market_table_single",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block MARKET_TRAY_EMPTY = registerBlock(
                        "market_tray_empty",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block MARKET_TRAY_FILLED_BERRIES = registerBlock(
                        "market_tray_filled_berries",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block MARKET_TRAY_FILLED_GRAPES = registerBlock(
                        "market_tray_filled_grapes",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block MARKET_TRAY_FILLED_DATES = registerBlock(
                        "market_tray_filled_dates",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block BLUE_LEFT = registerBlock(
                        "blue_left",
                        new ModProcessionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block BLUE_RIGHT = registerBlock(
                        "blue_right",
                        new ModProcessionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block CYAN_LEFT = registerBlock(
                        "cyan_left",
                        new ModProcessionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block CYAN_RIGHT = registerBlock(
                        "cyan_right",
                        new ModProcessionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS)));

        public static Block SMALL_BLUE_RUG = registerBlock(
                        "small_blue_rug",
                        new ModRugBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_WOOL)));

        public static Block SMALL_RED_RUG = registerBlock(
                        "small_red_rug",
                        new ModRugBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_WOOL)));

        public static Block SMALL_WHITE_RUG = registerBlock(
                        "small_white_rug",
                        new ModRugBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_WOOL)));

        public static Block SMALL_TAN_RUG = registerBlock(
                        "small_tan_rug",
                        new ModRugBlock(
                                        FabricBlockSettings.copyOf(Blocks.RED_WOOL)));

        public static Block WHEAT_SACK = registerBlock(
                        "wheat_sack",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block BARLEY_SACK = registerBlock(
                        "barley_sack",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block WIDE_VASE = registerBlock(
                        "wide_vase",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block TALL_VASE = registerBlock(
                        "tall_vase",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block BARREL_PLANTER_SMALL = registerBlock(
                        "barrel_planter_small",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block BARREL_PLANTER = registerBlock(
                        "barrel_planter",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block CYPRESS = registerBlock("cypress",
                        new Block(FabricBlockSettings.copyOf(Blocks.FERN)));

        public static Block CYPRESS_LARGE = registerBlock("cypress_large",
                        new Block(FabricBlockSettings.copyOf(Blocks.FERN)));

        public static Block CYPRES_SMALL = registerBlock("cypress_small",
                        new Block(FabricBlockSettings.copyOf(Blocks.FERN)));

        public static Block CYPRESS_POT_SMALL = registerBlock("cypress_pot_small",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block CYPRESS_POT = registerBlock("cypress_pot",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block MUD = registerBlock("mud",
                        new Block(
                                        FabricBlockSettings.copyOf(Blocks.SAND)));
        public static Block MUD_ONE = registerBlock("mud_one",
                        new Block(
                                        FabricBlockSettings.copyOf(Blocks.SAND)));
        public static Block MUD_TWO = registerBlock("mud_two",
                        new Block(
                                        FabricBlockSettings.copyOf(Blocks.SAND)));
        public static Block MUD_THREE = registerBlock("mud_three",
                        new Block(
                                        FabricBlockSettings.copyOf(Blocks.SAND)));

        public static Block SANDSTONE_DIAGONAL_SINGLE_ARCH = registerBlock(
                        "sandstone_diagonal_single_arch",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL)));
        public static Block SANDSTONE_DIAGONAL_RECTANGLE_WINDOW = registerBlock(
                        "sandstone_diagonal_rectangle_window",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL)));
        public static Block SANDSTONE_DIAGONAL_ROUND_WINDOW = registerBlock(
                        "sandstone_diagonal_single_window",
                        new ModDirectionalBlock(
                                        FabricBlockSettings.copyOf(Blocks.SANDSTONE_WALL)));

        public static Block CRATE_1 = registerBlock(
                        "crate_1",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_1_ANGLED = registerBlock(
                        "crate_1_angled",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_1_OFFSET = registerBlock(
                        "crate_1_offset",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_1_SMALL = registerBlock(
                        "crate_1_small",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_1_SMALL_ANGLED = registerBlock(
                        "crate_1_small_angled",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_1_SMALL_OFFSET = registerBlock(
                        "crate_1_small_offset",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_1_SMALL_GROUP = registerBlock(
                        "crate_1_small_group",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_2 = registerBlock(
                        "crate_2",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_2_OFFSET = registerBlock(
                        "crate_2_offset",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_2_ANGLED = registerBlock(
                        "crate_2_angled",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_2_SMALL = registerBlock(
                        "crate_2_small",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_2_SMALL_ANGLED = registerBlock(
                        "crate_2_small_angled",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block CRATE_2_SMALL_OFFSET = registerBlock(
                        "crate_2_small_offset",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block SQUARE_BARREL = registerBlock(
                        "square_barrel",
                        new Block(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block SQUARE_BARREL_ANGLED = registerBlock(
                        "square_barrel_angled",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
        public static Block SQUARE_BARREL_OFFSET = registerBlock(
                        "square_barrel_offset",
                        new ModDirectionalBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

        public static Block BABYLON_WHEAT_CROP = registerBlock("babylon_wheat_crop",
                        new ModWheatBlock(
                                        FabricBlockSettings.copyOf(Blocks.WHEAT).noCollision()));

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
