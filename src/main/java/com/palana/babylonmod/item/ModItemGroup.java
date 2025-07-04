package com.palana.babylonmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.block.ModBlocks;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup BABYLON_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BabylonMod.MOD_ID, "babylon_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("Babylon Blocks"))
                    .icon(() -> new ItemStack(Blocks.SANDSTONE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.LAPIS_STEPPED_PEAK);
                        entries.add(ModBlocks.LAPIS_STEPPED_PEAK_CORNER);
                        entries.add(ModBlocks.LAPIS_PEAK);
                        entries.add(ModBlocks.LAPIS_PEAK_CORNER);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_PEAK);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_PEAK_CORNER);
                        entries.add(ModBlocks.SANDSTONE_PEAK);
                        entries.add(ModBlocks.SANDSTONE_PEAK_CORNER);

                        entries.add(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM_TOP);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM_SHADOW);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_BOTTOM_CORNER_TOP);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_BOTTOM_CORNER);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_BOTTOM_CORNER_SHADOW);
                        entries.add(ModBlocks.SANDSTONE_EXTENDED_BLOCK);
                        entries.add(ModBlocks.SANDSTONE_EXTENDED_BLOCK_CORNER);
                        entries.add(ModBlocks.SANDSTONE_EXTENDED_FULL_BLOCK);

                        entries.add(ModBlocks.CHISELED_SANDSTONE_STEPPED_BLOCK_BOTTOM);
                        entries.add(ModBlocks.CHISELED_SANDSTONE_STEPPED_BOTTOM_CORNER);

                        entries.add(ModBlocks.LAPIS_STEPPED_BLOCK_BOTTOM_TOP);
                        entries.add(ModBlocks.LAPIS_STEPPED_BLOCK_BOTTOM);
                        entries.add(ModBlocks.LAPIS_STEPPED_BOTTOM_CORNER_TOP);
                        entries.add(ModBlocks.LAPIS_STEPPED_BOTTOM_CORNER);
                        entries.add(ModBlocks.LAPIS_EXTENDED_BLOCK);
                        entries.add(ModBlocks.LAPIS_EXTENDED_BLOCK_CORNER);

                        entries.add(ModBlocks.LAPIS_WINDOW_STEPPED_BLOCK_BOTTOM);
                        entries.add(ModBlocks.SANDSTONE_WINDOW_STEPPED_BLOCK_BOTTOM);

                        entries.add(ModBlocks.LAPIS_BANDED_EXTENDED_BLOCK);
                        entries.add(ModBlocks.LAPIS_BANDED_EXTENDED_BLOCK_CORNER);

                        entries.add(ModBlocks.SANDSTONE_DIAGONAL_WALL);
                        entries.add(ModBlocks.SANDSTONE_DIAGONAL_WALL_MUDDY_BOTTOM);
                        entries.add(ModBlocks.SANDSTONE_DIAGONAL_WALL_MUDDY_TOP);
                        entries.add(ModBlocks.SANDSTONE_DIAGONAL_WALL_SHADOWED);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM_DIAGONAL);
                        entries.add(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM_DIAGONAL_SHADOWED);
                        entries.add(ModBlocks.SANDSTONE_EXTENDED_BLOCK_DIAGONAL);
                        entries.add(ModBlocks.SANDSTONE_PEAK_DIAGONAL);
                        entries.add(ModBlocks.SANDSTONE_PEAK_CORNER_DIAGONAL);
                        entries.add(ModBlocks.EXTENDED_CORNER);

                        entries.add(ModBlocks.SANDSTONE_ROUND_WINDOW);
                        entries.add(ModBlocks.SANDSTONE_ROUND_WINDOW_EXTENDED);
                        entries.add(ModBlocks.LAPIS_ROUND_WINDOW);
                        entries.add(ModBlocks.LAPIS_ROUND_WINDOW_EXTENDED);
                        entries.add(ModBlocks.SANDSTONE_WINDOW_RECTANGLE);
                        entries.add(ModBlocks.SANDSTONE_WINDOW_RECTANGLE_STEPPED);

                        entries.add(ModBlocks.POLISHED_SANDSTONE_FENCE);
                        entries.add(ModBlocks.POLISHED_SANDSTONE_FENCE_SMALL);
                        entries.add(ModBlocks.POLISHED_SANDSTONE_FENCE_SHORT);
                        entries.add(ModBlocks.POLISHED_SANDSTONE_FENCE_SHORT_SMALL);

                        entries.add(ModBlocks.LAPIS_FENCE);
                        entries.add(ModBlocks.LAPIS_FENCE_SMALL);
                        entries.add(ModBlocks.LAPIS_FENCE_SHORT);
                        entries.add(ModBlocks.LAPIS_FENCE_SHORT_SMALL);

                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_FENCE);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_FENCE_SMALL);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_FENCE_SHORT);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_FENCE_SHORT_SMALL);

                        entries.add(ModBlocks.PLASTER_STEPPED_BLOCK_BOTTOM_TOP);
                        entries.add(ModBlocks.PLASTER_STEPPED_BOTTOM_CORNER_TOP);
                        entries.add(ModBlocks.PLASTER_MERLON);
                        entries.add(ModBlocks.PLASTER_MERLON_CORNER);
                        entries.add(ModBlocks.PLASTER_STEPPED_PEAK);
                        entries.add(ModBlocks.PLASTER_STEPPED_PEAK_CORNER);

                        entries.add(ModBlocks.SANDSTONE_INSET_WINDOW);
                        entries.add(ModBlocks.SANDSTONE_SINGLE_ARCH);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_SINGLE_ARCH);
                        entries.add(ModBlocks.SANDSTONE_SINGLE_ARCH_STEPPED);
                        entries.add(ModBlocks.SANDSTONE_DOUBLE_ARCH);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_DOUBLE_ARCH);
                        entries.add(ModBlocks.SANDSTONE_TRIPLE_ARCH);
                        entries.add(ModBlocks.SANDSTONE_TRIPLE_ARCH_CENTER);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_TRIPLE_ARCH);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_TRIPLE_ARCH_CENTER);
                        entries.add(ModBlocks.SANDSTONE_FIVE_ARCH_CENTER);
                        entries.add(ModBlocks.SANDSTONE_FIVE_ARCH_TOP);
                        entries.add(ModBlocks.SANDSTONE_FIVE_ARCH_MID);
                        entries.add(ModBlocks.SANDSTONE_FIVE_ARCH_BOTTOM);

                        entries.add(ModBlocks.NARROW_SANDSTONE_SINGLE_ARCH);
                        entries.add(ModBlocks.NARROW_SANDSTONE_SINGLE_ARCH_TALL);
                        entries.add(ModBlocks.NARROW_SANDSTONE_PEAK);

                        entries.add(ModBlocks.LAPIS_INSET_WINDOW);
                        entries.add(ModBlocks.LAPIS_SINGLE_ARCH);
                        entries.add(ModBlocks.LAPIS_DOUBLE_ARCH);
                        entries.add(ModBlocks.LAPIS_TRIPLE_ARCH);
                        entries.add(ModBlocks.LAPIS_TRIPLE_ARCH_CENTER);
                        entries.add(ModBlocks.NARROW_LAPIS_SINGLE_ARCH);
                        entries.add(ModBlocks.NARROW_LAPIS_SINGLE_ARCH_TALL);
                        entries.add(ModBlocks.LAPIS_FIVE_ARCH_CENTER);
                        entries.add(ModBlocks.LAPIS_FIVE_ARCH_TOP);
                        entries.add(ModBlocks.LAPIS_FIVE_ARCH_MID);
                        entries.add(ModBlocks.LAPIS_FIVE_ARCH_BOTTOM);

                        entries.add(ModBlocks.GRASS_TWO);
                        entries.add(ModBlocks.SANDY_STONES);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_DARK);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_BOTTOM_FADE);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_ROOF);
                        entries.add(ModBlocks.LIME_GYPSUM_PLASTER_RECESS);
                        entries.add(ModBlocks.LAPIS_GATE_BORDER_LEFT);
                        entries.add(ModBlocks.LAPIS_GATE_BORDER_RIGHT);

                        entries.add(ModBlocks.ISHTAR_GATE_AUROCH_GOLD_LEFT);
                        entries.add(ModBlocks.ISHTAR_GATE_AUROCH_WHITE_LEFT);
                        entries.add(ModBlocks.ISHTAR_GATE_DRAGON_GOLD_LEFT);
                        entries.add(ModBlocks.ISHTAR_GATE_DRAGON_WHITE_LEFT);
                        entries.add(ModBlocks.ISHTAR_GATE_AUROCH_GOLD_RIGHT);
                        entries.add(ModBlocks.ISHTAR_GATE_AUROCH_WHITE_RIGHT);
                        entries.add(ModBlocks.ISHTAR_GATE_DRAGON_GOLD_RIGHT);
                        entries.add(ModBlocks.ISHTAR_GATE_DRAGON_WHITE_RIGHT);

                        entries.add(ModBlocks.PALM_SAPLING_XSMALL);
                        entries.add(ModBlocks.PALM_SAPLING_SMALL);
                        entries.add(ModBlocks.PALM_SAPLING);
                        entries.add(ModBlocks.PALM_SAPLING_LARGE);
                        // entries.add(ModBlocks.DRIFTWOOD_SAPLING);
                        entries.add(ModBlocks.CHESTNUT_SAPLING);
                        entries.add(ModBlocks.OAK_LOG_TWO);

                        entries.add(ModBlocks.SANDSTONE_COVER);

                        entries.add(ModBlocks.SANDSTONE_BRIDGE_BACK_LEFT);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_BACK_RIGHT);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_CENTER);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_RIGHT);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_LEFT);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_BACK_RIGHT_MUDDY_BOTTOM);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_CENTER_MUDDY_BOTTOM);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_RIGHT_MUDDY_BOTTOM);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_LEFT_MUDDY_BOTTOM);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_BACK_LEFT_MUDDY_BOTTOM);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_BACK_RIGHT_MUDDY_TOP);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_CENTER_MUDDY_TOP);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_RIGHT_MUDDY_TOP);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_FRONT_LEFT_MUDDY_TOP);
                        entries.add(ModBlocks.SANDSTONE_BRIDGE_BACK_LEFT_MUDDY_TOP);

                        entries.add(ModBlocks.MARKET_STALL);
                        entries.add(ModBlocks.OFFSET_FENCE_POST);
                        entries.add(ModBlocks.MARKET_ROOF_SLANTED);

                        entries.add(ModBlocks.BLUE_LEFT);
                        entries.add(ModBlocks.BLUE_RIGHT);
                        entries.add(ModBlocks.CYAN_LEFT);
                        entries.add(ModBlocks.CYAN_RIGHT);

                        entries.add(ModBlocks.CYPRESS_POT);
                        entries.add(ModBlocks.CYPRESS_POT_SMALL);
                        entries.add(ModBlocks.CYPRES_SMALL);
                        entries.add(ModBlocks.CYPRESS);
                        entries.add(ModBlocks.CYPRESS_LARGE);
                        entries.add(ModBlocks.MUD);
                        entries.add(ModBlocks.MUD_ONE);
                        entries.add(ModBlocks.MUD_TWO);
                        entries.add(ModBlocks.MUD_THREE);

                        entries.add(ModBlocks.SANDSTONE_DIAGONAL_SINGLE_ARCH);
                        entries.add(ModBlocks.SANDSTONE_DIAGONAL_RECTANGLE_WINDOW);
                        entries.add(ModBlocks.SANDSTONE_DIAGONAL_ROUND_WINDOW);

                    }).build());

    public static final ItemGroup MC_BABYLON_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BabylonMod.MOD_ID, "mc_babylon_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("Repurposed Blocks"))
                    .icon(() -> new ItemStack(Blocks.SANDSTONE)).entries((displayContext, entries) -> {

                        entries.add(Blocks.BAMBOO_TRAPDOOR);
                        entries.add(Blocks.WARPED_TRAPDOOR);
                        entries.add(Blocks.DEEPSLATE_BRICKS);
                        entries.add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
                        entries.add(Blocks.CRACKED_DEEPSLATE_BRICKS);
                        entries.add(Blocks.DEEPSLATE);
                        entries.add(Blocks.DEEPSLATE_BRICK_STAIRS);
                        entries.add(Blocks.DEEPSLATE_BRICK_SLAB);
                        entries.add(Blocks.DEEPSLATE_BRICK_WALL);
                        entries.add(Blocks.CRACKED_DEEPSLATE_TILES);
                        entries.add(Blocks.NETHER_BRICKS);
                        entries.add(Blocks.CRACKED_NETHER_BRICKS);
                        entries.add(Blocks.NETHER_BRICK_STAIRS);
                        entries.add(Blocks.NETHER_BRICK_SLAB);
                        entries.add(Blocks.NETHER_BRICK_WALL);
                        entries.add(Blocks.CHISELED_NETHER_BRICKS);
                        entries.add(Blocks.RED_NETHER_BRICKS);
                        entries.add(Blocks.RED_NETHER_BRICK_STAIRS);
                        entries.add(Blocks.RED_NETHER_BRICK_SLAB);
                        entries.add(Blocks.RED_NETHER_BRICK_WALL);
                        entries.add(Blocks.POLISHED_BLACKSTONE);
                        entries.add(Blocks.POLISHED_BLACKSTONE_STAIRS);
                        entries.add(Blocks.POLISHED_BLACKSTONE_SLAB);
                        entries.add(Blocks.POLISHED_BLACKSTONE_WALL);
                        entries.add(Blocks.POLISHED_BLACKSTONE_BRICKS);
                        entries.add(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS);
                        entries.add(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB);
                        entries.add(Blocks.POLISHED_BLACKSTONE_BRICK_WALL);
                        entries.add(Blocks.WHITE_WOOL);
                        entries.add(Blocks.WHITE_CARPET);
                        entries.add(Blocks.LIGHT_GRAY_WOOL);
                        entries.add(Blocks.LIGHT_GRAY_CARPET);
                        entries.add(Blocks.PURPLE_WOOL);
                        entries.add(Blocks.PURPLE_CARPET);
                        entries.add(Blocks.MAGENTA_WOOL);
                        entries.add(Blocks.MAGENTA_CARPET);
                        entries.add(Blocks.RED_CONCRETE);
                        entries.add(Blocks.ANVIL);
                        entries.add(Blocks.CHIPPED_ANVIL);
                        entries.add(Blocks.DAMAGED_ANVIL);
                        entries.add(Blocks.LECTERN);
                        entries.add(Blocks.HOPPER);
                        entries.add(Blocks.CHISELED_SANDSTONE);
                        entries.add(Blocks.SANDSTONE);
                        entries.add(Blocks.SANDSTONE_STAIRS);
                        entries.add(Blocks.SANDSTONE_SLAB);
                        entries.add(Blocks.SANDSTONE_WALL);
                        entries.add(Blocks.RED_SANDSTONE);
                        entries.add(Blocks.CUT_RED_SANDSTONE);
                        entries.add(Blocks.CUT_RED_SANDSTONE_SLAB);
                        entries.add(Blocks.POLISHED_GRANITE);
                        entries.add(Blocks.POLISHED_GRANITE_STAIRS);
                        entries.add(Blocks.STONE_BRICKS);
                        entries.add(Blocks.STONE_BRICK_STAIRS);
                        entries.add(Blocks.POLISHED_ANDESITE);
                        entries.add(Blocks.POLISHED_ANDESITE_SLAB);
                        entries.add(Blocks.POLISHED_ANDESITE_STAIRS);
                        entries.add(Blocks.POLISHED_DEEPSLATE);
                        entries.add(Blocks.POLISHED_DEEPSLATE_SLAB);
                        entries.add(Blocks.POLISHED_DEEPSLATE_STAIRS);
                        entries.add(Blocks.CHERRY_STAIRS);
                        entries.add(Blocks.CHERRY_SLAB);
                        entries.add(Blocks.GRASS_BLOCK);
                        entries.add(Blocks.PODZOL);
                        entries.add(ModBlocks.GRASS_TWO);
                        entries.add(Blocks.RED_SAND);
                        entries.add(Blocks.MYCELIUM);
                        entries.add(Blocks.SAND);
                        entries.add(Blocks.OAK_LEAVES);
                        entries.add(Blocks.AZALEA_LEAVES);
                        entries.add(Blocks.BIRCH_FENCE);
                        entries.add(ModBlocks.OAK_LOG_TWO);

                    }).build());

    public static final ItemGroup ITEMS_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BabylonMod.MOD_ID, "items"),
            FabricItemGroup.builder().displayName(Text.translatable("Items"))
                    .icon(() -> new ItemStack(ModBlocks.SMALL_BARREL)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MARKET_TABLE);
                        entries.add(ModBlocks.MARKET_TABLE_SINGLE);
                        entries.add(ModBlocks.SMALL_BARREL);
                        entries.add(ModBlocks.LARGE_BARREL);
                        entries.add(ModBlocks.MARKET_TRAY_EMPTY);
                        entries.add(ModBlocks.MARKET_TRAY_FILLED_BERRIES);
                        entries.add(ModBlocks.MARKET_TRAY_FILLED_GRAPES);
                        entries.add(ModBlocks.MARKET_TRAY_FILLED_DATES);
                        entries.add(ModBlocks.SMALL_BLUE_RUG);
                        entries.add(ModBlocks.SMALL_WHITE_RUG);
                        entries.add(ModBlocks.SMALL_TAN_RUG);
                        entries.add(ModBlocks.SMALL_RED_RUG);
                        entries.add(ModBlocks.WHEAT_SACK);
                        entries.add(ModBlocks.BARLEY_SACK);
                        entries.add(ModBlocks.WIDE_VASE);
                        entries.add(ModBlocks.TALL_VASE);
                        entries.add(ModBlocks.BARREL_PLANTER_SMALL);
                        entries.add(ModBlocks.BARREL_PLANTER);
                        entries.add(ModBlocks.PLANTABLE_BARREL_PLANTER);
                        entries.add(ModBlocks.LARGE_PLANTABLE_BARREL_PLANTER);
                        entries.add(ModItems.BABYLON_WHEAT_SEEDS);
                        entries.add(ModBlocks.CRATE_1);
                        entries.add(ModBlocks.CRATE_1_ANGLED);
                        entries.add(ModBlocks.CRATE_1_OFFSET);
                        entries.add(ModBlocks.CRATE_1_SMALL);
                        entries.add(ModBlocks.CRATE_1_SMALL_ANGLED);
                        entries.add(ModBlocks.CRATE_1_SMALL_OFFSET);
                        entries.add(ModBlocks.CRATE_1_SMALL_GROUP);
                        entries.add(ModBlocks.CRATE_2);
                        entries.add(ModBlocks.CRATE_2_ANGLED);
                        entries.add(ModBlocks.CRATE_2_OFFSET);
                        entries.add(ModBlocks.CRATE_2_SMALL);
                        entries.add(ModBlocks.CRATE_2_SMALL_ANGLED);
                        entries.add(ModBlocks.CRATE_2_SMALL_OFFSET);
                        entries.add(ModBlocks.SQUARE_BARREL);
                        entries.add(ModBlocks.SQUARE_BARREL_ANGLED);
                        entries.add(ModBlocks.SQUARE_BARREL_OFFSET);

                    }).build());

    public static void registerItemGroups() {

    }
}
