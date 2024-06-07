package com.palana.babylonmod.block;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.block.custom.DirectionalPalmLeaves;
import com.palana.babylonmod.block.custom.ModConnectedBlock;
import com.palana.babylonmod.block.custom.ModDynamicSandBlock;
import com.palana.babylonmod.block.custom.ModDirectionalBlock;
import com.palana.babylonmod.block.custom.ModDirectionalSlabBlock;
import com.palana.babylonmod.block.custom.ModFlammableRotatedPillarBlock;
import com.palana.babylonmod.block.custom.ModGrassBlock;
import com.palana.babylonmod.block.custom.ModIshtarGateBlock;
import com.palana.babylonmod.block.custom.ModPassableStairBlock;
import com.palana.babylonmod.block.custom.ModProcessionalBlock;
import com.palana.babylonmod.block.custom.ModRugBlock;
import com.palana.babylonmod.block.custom.ModSaplingBlock;
import com.palana.babylonmod.block.custom.ModScalableBlock;
import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.item.ModItems;
import com.palana.babylonmod.worldgen.tree.PalmTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.core.Direction;

import java.util.function.Supplier;

public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        BabylonMod.MOD_ID);

        public static final RegistryObject<Block> LAPIS_BRICK = registerBlock("lapis_brick",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL)));

        public static final RegistryObject<Block> LAPIS_BRICK_STAIRS = registerBlock("lapis_brick_stairs",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS)));

        public static final RegistryObject<Block> LAPIS_BRICK_SLAB = registerBlock("lapis_brick_slab",
                        () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));

        public static final RegistryObject<Block> PALM_CORE_BOTTOM = registerBlock("palm_core_bottom",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.FERN)));

        public static final RegistryObject<Block> PALM_CORE_TOP = registerBlock("palm_core_top",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.FERN)));

        public static final RegistryObject<Block> PALM_LEAVES = registerBlock("palm_leaves",
                        () -> new DirectionalPalmLeaves(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noLootTable()));

        public static final RegistryObject<Block> PALM_LEAVES_2 = registerBlock("palm_leaves_2",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> PALM_TOP = registerBlock("palm_top",
                        () -> new DirectionalPalmLeaves(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noLootTable()));

        public static final RegistryObject<Block> PALM_TRUNK = registerBlock("palm_trunk",
                        () -> new ModScalableBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

        public static final RegistryObject<Block> OAK_LOG_TWO = registerBlock("oak_log_two",
                        () -> new ModScalableBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> PALM_CORE_FROND = registerBlock("palm_core_frond",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.FERN)));

        // Straight tower shit
        public static final RegistryObject<Block> SANDSTONE_PEAK = registerBlock("sandstone_peak",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_PEAK = registerBlock("lapis_peak",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_PEAK_CORNER = registerBlock("lapis_peak_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_STEPPED_PEAK = registerBlock("lapis_stepped_peak",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_STEPPED_PEAK_CORNER = registerBlock("lapis_stepped_peak_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_PEAK = registerBlock("sandstone_stepped_peak",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_PEAK_CORNER = registerBlock(
                        "sandstone_stepped_peak_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_INSET_WINDOW = registerBlock("sandstone_inset_window",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_SINGLE_ARCH = registerBlock("sandstone_single_arch",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_SINGLE_ARCH = registerBlock(
                        "lime_gypsum_plaster_single_arch",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_SINGLE_ARCH_STEPPED = registerBlock(
                        "sandstone_single_arch_stepped",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_DOUBLE_ARCH = registerBlock("sandstone_double_arch",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_DOUBLE_ARCH = registerBlock(
                        "lime_gypsum_plaster_double_arch",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> NARROW_SANDSTONE_PEAK = registerBlock("narrow_sandstone_peak",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_TRIPLE_ARCH = registerBlock("sandstone_triple_arch",
                        () -> new ModPassableStairBlock(() -> Blocks.SANDSTONE_STAIRS.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS)));

        public static final RegistryObject<Block> SANDSTONE_TRIPLE_ARCH_CENTER = registerBlock(
                        "sandstone_triple_arch_center",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_TRIPLE_ARCH = registerBlock(
                        "lime_gypsum_plaster_triple_arch",
                        () -> new ModPassableStairBlock(() -> Blocks.SANDSTONE_STAIRS.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS)));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_TRIPLE_ARCH_CENTER = registerBlock(
                        "lime_gypsum_plaster_triple_arch_center",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_FIVE_ARCH_CENTER = registerBlock(
                        "sandstone_five_arch_center",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_FIVE_ARCH_TOP = registerBlock(
                        "sandstone_five_arch_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_FIVE_ARCH_MID = registerBlock(
                        "sandstone_five_arch_mid",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_FIVE_ARCH_BOTTOM = registerBlock(
                        "sandstone_five_arch_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_FIVE_ARCH_CENTER = registerBlock(
                        "lapis_five_arch_center",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_FIVE_ARCH_TOP = registerBlock(
                        "lapis_five_arch_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_FIVE_ARCH_MID = registerBlock(
                        "lapis_five_arch_mid",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_FIVE_ARCH_BOTTOM = registerBlock(
                        "lapis_five_arch_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> NARROW_SANDSTONE_SINGLE_ARCH = registerBlock(
                        "narrow_sandstone_single_arch",
                        () -> new ModPassableStairBlock(() -> Blocks.SANDSTONE.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> NARROW_SANDSTONE_SINGLE_ARCH_TALL = registerBlock(
                        "narrow_sandstone_single_arch_tall",
                        () -> new ModPassableStairBlock(() -> Blocks.SANDSTONE.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_INSET_WINDOW = registerBlock("lapis_inset_window",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_SINGLE_ARCH = registerBlock("lapis_single_arch",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_DOUBLE_ARCH = registerBlock("lapis_double_arch",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_TRIPLE_ARCH = registerBlock("lapis_triple_arch",
                        () -> new ModPassableStairBlock(() -> Blocks.SANDSTONE_STAIRS.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_TRIPLE_ARCH_CENTER = registerBlock(
                        "lapis_triple_arch_center",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB).noOcclusion()));

        public static final RegistryObject<Block> NARROW_LAPIS_SINGLE_ARCH = registerBlock(
                        "narrow_lapis_single_arch",
                        () -> new ModPassableStairBlock(() -> Blocks.SANDSTONE.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> NARROW_LAPIS_SINGLE_ARCH_TALL = registerBlock(
                        "narrow_lapis_single_arch_tall",
                        () -> new ModPassableStairBlock(() -> Blocks.SANDSTONE.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_PEAK_CORNER = registerBlock("sandstone_peak_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_COVER = registerBlock(
                        "sandstone_cover",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BLOCK_BOTTOM_TOP = registerBlock(
                        "sandstone_stepped_block_bottom_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "sandstone_stepped_block_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BLOCK_BOTTOM_SHADOW = registerBlock(
                        "sandstone_stepped_block_bottom_shadow",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> CHISELED_SANDSTONE_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "chiseled_sandstone_stepped_block_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_WINDOW_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "sandstone_window_stepped_block_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_WINDOW_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "lapis_window_stepped_block_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_STEPPED_BLOCK_BOTTOM = registerBlock(
                        "lapis_stepped_block_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_STEPPED_BLOCK_BOTTOM_TOP = registerBlock(
                        "lapis_stepped_block_bottom_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_EXTENDED_BLOCK = registerBlock(
                        "sandstone_extended_block",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_EXTENDED_FULL_BLOCK = registerBlock(
                        "sandstone_extended_full_block",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_BANDED_EXTENDED_BLOCK = registerBlock(
                        "lapis_banded_extended_block",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_EXTENDED_BLOCK = registerBlock(
                        "lapis_extended_block",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BOTTOM_CORNER_TOP = registerBlock(
                        "sandstone_stepped_bottom_corner_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BOTTOM_CORNER = registerBlock(
                        "sandstone_stepped_bottom_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BOTTOM_CORNER_SHADOW = registerBlock(
                        "sandstone_stepped_bottom_corner_shadow",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> CHISELED_SANDSTONE_STEPPED_BOTTOM_CORNER = registerBlock(
                        "chiseled_sandstone_stepped_bottom_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_STEPPED_BOTTOM_CORNER = registerBlock(
                        "lapis_stepped_bottom_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_STEPPED_BOTTOM_CORNER_TOP = registerBlock(
                        "lapis_stepped_bottom_corner_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_EXTENDED_BLOCK_CORNER = registerBlock(
                        "sandstone_extended_block_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> EXTENDED_CORNER = registerBlock(
                        "extended_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_BANDED_EXTENDED_BLOCK_CORNER = registerBlock(
                        "lapis_banded_extended_block_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_EXTENDED_BLOCK_CORNER = registerBlock(
                        "lapis_extended_block_corner",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        // Diagonal tower shit
        public static final RegistryObject<Block> SANDSTONE_DIAGONAL_WALL = registerBlock(
                        "sandstone_diagonal_wall",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_DIAGONAL_WALL_MUDDY_TOP = registerBlock(
                        "sandstone_diagonal_wall_muddy_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_DIAGONAL_WALL_MUDDY_BOTTOM = registerBlock(
                        "sandstone_diagonal_wall_muddy_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_DIAGONAL_WALL_SHADOWED = registerBlock(
                        "sandstone_diagonal_wall_shadowed",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_PEAK_DIAGONAL = registerBlock("sandstone_peak_diagonal",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> GRASS_TWO = registerBlock("grass_two",
                        () -> new ModGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));

        public static final RegistryObject<Block> SANDY_STONES = registerBlock("sandy_stones",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SAND).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER = registerBlock("lime_gypsum_plaster",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_DARK = registerBlock("lime_gypsum_plaster_dark",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_BOTTOM_FADE = registerBlock(
                        "lime_gypsum_plaster_bottom_fade",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_ROOF = registerBlock("lime_gypsum_plaster_roof",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_RECESS = registerBlock(
                        "lime_gypsum_plaster_recess",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_PEAK_CORNER_DIAGONAL = registerBlock(
                        "sandstone_peak_corner_diagonal",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BLOCK_BOTTOM_DIAGONAL = registerBlock(
                        "sandstone_stepped_block_bottom_diagonal",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BLOCK_BOTTOM_DIAGONAL_SHADOWED = registerBlock(
                        "sandstone_stepped_block_bottom_diagonal_shadowed",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_EXTENDED_BLOCK_DIAGONAL = registerBlock(
                        "sandstone_extended_block_diagonal",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_STEPPED_BOTTOM_CORNER_DIAGONAL = registerBlock(
                        "sandstone_stepped_bottom_corner_diagonal",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_EXTENDED_BLOCK_CORNER_DIAGONAL = registerBlock(
                        "sandstone_extended_block_corner_diagonal",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_ROUND_WINDOW = registerBlock(
                        "sandstone_round_window",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_ROUND_WINDOW_EXTENDED = registerBlock(
                        "sandstone_round_window_extended",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_ROUND_WINDOW = registerBlock(
                        "lapis_round_window",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_ROUND_WINDOW_EXTENDED = registerBlock(
                        "lapis_round_window_extended",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_WINDOW_RECTANGLE = registerBlock(
                        "sandstone_window_rectangle",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> SANDSTONE_WINDOW_RECTANGLE_STEPPED = registerBlock(
                        "sandstone_window_rectangle_stepped",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> POLISHED_SANDSTONE_FENCE = registerBlock(
                        "polished_sandstone_fence",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> POLISHED_SANDSTONE_FENCE_SMALL = registerBlock(
                        "polished_sandstone_fence_small",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> POLISHED_SANDSTONE_FENCE_SHORT = registerBlock(
                        "polished_sandstone_fence_short",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> POLISHED_SANDSTONE_FENCE_SHORT_SMALL = registerBlock(
                        "polished_sandstone_fence_short_small",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_FENCE = registerBlock(
                        "lime_gypsum_plaster_fence",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_FENCE_SMALL = registerBlock(
                        "lime_gypsum_plaster_fence_small",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_FENCE_SHORT = registerBlock(
                        "lime_gypsum_plaster_fence_short",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> LIME_GYPSUM_PLASTER_FENCE_SHORT_SMALL = registerBlock(
                        "lime_gypsum_plaster_fence_short_small",
                        () -> new StairBlock(() -> ModBlocks.LAPIS_BRICK.get().defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).noOcclusion()));

        public static final RegistryObject<Block> DYNAMIC_SAND = registerBlock(
                        "dynamic_sand",
                        () -> new ModDynamicSandBlock(
                                        BlockBehaviour.Properties.copy(Blocks.SAND)));

        public static final RegistryObject<Block> ISHTAR_GATE_AUROCH_GOLD_LEFT = registerBlock(
                        "ishtar_gate_auroch_gold_left",
                        () -> new ModIshtarGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> ISHTAR_GATE_AUROCH_WHITE_LEFT = registerBlock(
                        "ishtar_gate_auroch_white_left",
                        () -> new ModIshtarGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> ISHTAR_GATE_DRAGON_GOLD_LEFT = registerBlock(
                        "ishtar_gate_dragon_gold_left",
                        () -> new ModIshtarGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> ISHTAR_GATE_DRAGON_WHITE_LEFT = registerBlock(
                        "ishtar_gate_dragon_white_left",
                        () -> new ModIshtarGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> ISHTAR_GATE_AUROCH_GOLD_RIGHT = registerBlock(
                        "ishtar_gate_auroch_gold_right",
                        () -> new ModIshtarGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> ISHTAR_GATE_AUROCH_WHITE_RIGHT = registerBlock(
                        "ishtar_gate_auroch_white_right",
                        () -> new ModIshtarGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> ISHTAR_GATE_DRAGON_GOLD_RIGHT = registerBlock(
                        "ishtar_gate_dragon_gold_right",
                        () -> new ModIshtarGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> ISHTAR_GATE_DRAGON_WHITE_RIGHT = registerBlock(
                        "ishtar_gate_dragon_white_right",
                        () -> new ModIshtarGateBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_GATE_BORDER_RIGHT = registerBlock(
                        "lapis_gate_border_right",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> LAPIS_GATE_BORDER_LEFT = registerBlock(
                        "lapis_gate_border_left",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> PALM_SAPLING = registerBlock("palm_sapling",
                        () -> new ModSaplingBlock(new PalmTreeGrower(null, null, SizeType.MEDIUM),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> PALM_SAPLING_LARGE = registerBlock("palm_sapling_large",
                        () -> new ModSaplingBlock(new PalmTreeGrower(null, null, SizeType.LARGE),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> PALM_SAPLING_SMALL = registerBlock("palm_sapling_small",
                        () -> new ModSaplingBlock(new PalmTreeGrower(null, null, SizeType.SMALL),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_BACK_RIGHT = registerBlock(
                        "sandstone_bridge_back_right",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_BACK_LEFT = registerBlock(
                        "sandstone_bridge_back_left",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_CENTER = registerBlock(
                        "sandstone_bridge_front_center",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_RIGHT = registerBlock(
                        "sandstone_bridge_front_right",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_LEFT = registerBlock(
                        "sandstone_bridge_front_left",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> MARKET_STALL = registerBlock(
                        "market_stall",
                        () -> new ModConnectedBlock(() -> Blocks.SANDSTONE_STAIRS.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> OFFSET_FENCE_POST = registerBlock(
                        "offset_fence_post",
                        () -> new ModDirectionalBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> MARKET_ROOF_SLANTED = registerBlock(
                        "market_roof_slanted",
                        () -> new ModDirectionalSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
        public static final RegistryObject<Block> SANDSTONE_BRIDGE_BACK_RIGHT_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_back_right_muddy_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_BACK_LEFT_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_back_left_muddy_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_CENTER_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_front_center_muddy_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_RIGHT_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_front_right_muddy_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_LEFT_MUDDY_BOTTOM = registerBlock(
                        "sandstone_bridge_front_left_muddy_bottom",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_BACK_RIGHT_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_back_right_muddy_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_BACK_LEFT_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_back_left_muddy_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_CENTER_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_front_center_muddy_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_RIGHT_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_front_right_muddy_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SANDSTONE_BRIDGE_FRONT_LEFT_MUDDY_TOP = registerBlock(
                        "sandstone_bridge_front_left_muddy_top",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> LAMASSU = registerBlock(
                        "lamassu",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> SMALL_BARREL = registerBlock(
                        "small_barrel",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> LARGE_BARREL = registerBlock(
                        "large_barrel",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> MARKET_TABLE = registerBlock(
                        "market_table",
                        () -> new ModPassableStairBlock(() -> Blocks.SANDSTONE_STAIRS.defaultBlockState(),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> MARKET_TABLE_SINGLE = registerBlock(
                        "market_table_single",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> MARKET_TRAY_EMPTY = registerBlock(
                        "market_tray_empty",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> MARKET_TRAY_FILLED_BERRIES = registerBlock(
                        "market_tray_filled_berries",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> MARKET_TRAY_FILLED_GRAPES = registerBlock(
                        "market_tray_filled_grapes",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> MARKET_TRAY_FILLED_DATES = registerBlock(
                        "market_tray_filled_dates",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> BLUE_LEFT = registerBlock(
                        "blue_left",
                        () -> new ModProcessionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> BLUE_RIGHT = registerBlock(
                        "blue_right",
                        () -> new ModProcessionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> CYAN_LEFT = registerBlock(
                        "cyan_left",
                        () -> new ModProcessionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> CYAN_RIGHT = registerBlock(
                        "cyan_right",
                        () -> new ModProcessionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).noOcclusion()));

        public static final RegistryObject<Block> SMALL_BLUE_RUG = registerBlock(
                        "small_blue_rug",
                        () -> new ModRugBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_WOOL).noOcclusion()));

        public static final RegistryObject<Block> SMALL_RED_RUG = registerBlock(
                        "small_red_rug",
                        () -> new ModRugBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_WOOL).noOcclusion()));

        public static final RegistryObject<Block> SMALL_WHITE_RUG = registerBlock(
                        "small_white_rug",
                        () -> new ModRugBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_WOOL).noOcclusion()));

        public static final RegistryObject<Block> SMALL_TAN_RUG = registerBlock(
                        "small_tan_rug",
                        () -> new ModRugBlock(
                                        BlockBehaviour.Properties.copy(Blocks.RED_WOOL).noOcclusion()));

        public static final RegistryObject<Block> WHEAT_SACK = registerBlock(
                        "wheat_sack",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> BARLEY_SACK = registerBlock(
                        "barley_sack",
                        () -> new ModDirectionalBlock(
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noOcclusion()));

        public static final RegistryObject<Block> WIDE_VASE = registerBlock(
                        "wide_vase",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> TALL_VASE = registerBlock(
                        "tall_vase",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> BARREL_PLANTER_SMALL = registerBlock(
                        "barrel_planter_small",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> BARREL_PLANTER = registerBlock(
                        "barrel_planter",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> CYPRESS = registerBlock("cypress",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.FERN)));

        public static final RegistryObject<Block> CYPRESS_LARGE = registerBlock("cypress_large",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.FERN)));

        public static final RegistryObject<Block> CYPRES_SMALL = registerBlock("cypress_small",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.FERN)));

        public static final RegistryObject<Block> CYPRESS_POT_SMALL = registerBlock("cypress_pot_small",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> CYPRESS_POT = registerBlock("cypress_pot",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
                RegistryObject<T> toReturn = BLOCKS.register(name, block);
                registerBlockItem(name, toReturn);
                return toReturn;
        }

        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
                return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }
}
