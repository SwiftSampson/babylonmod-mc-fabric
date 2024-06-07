package com.palana.babylonmod.item;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, BabylonMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BABYLON_TAB = CREATIVE_MODE_TABS.register("babylon_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.SANDSTONE))
                    .title(Component.translatable("creativetab.babylon_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModBlocks.LAPIS_STEPPED_PEAK.get());
                        output.accept(ModBlocks.LAPIS_STEPPED_PEAK_CORNER.get());
                        output.accept(ModBlocks.LAPIS_PEAK.get());
                        output.accept(ModBlocks.LAPIS_PEAK_CORNER.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_PEAK.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_PEAK_CORNER.get());
                        output.accept(ModBlocks.SANDSTONE_PEAK.get());
                        output.accept(ModBlocks.SANDSTONE_PEAK_CORNER.get());

                        output.accept(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM_TOP.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM_SHADOW.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_BOTTOM_CORNER_TOP.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_BOTTOM_CORNER.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_BOTTOM_CORNER_SHADOW.get());
                        output.accept(ModBlocks.SANDSTONE_EXTENDED_BLOCK.get());
                        output.accept(ModBlocks.SANDSTONE_EXTENDED_BLOCK_CORNER.get());
                        output.accept(ModBlocks.SANDSTONE_EXTENDED_FULL_BLOCK.get());

                        output.accept(ModBlocks.CHISELED_SANDSTONE_STEPPED_BLOCK_BOTTOM.get());
                        output.accept(ModBlocks.CHISELED_SANDSTONE_STEPPED_BOTTOM_CORNER.get());

                        output.accept(ModBlocks.LAPIS_STEPPED_BLOCK_BOTTOM_TOP.get());
                        output.accept(ModBlocks.LAPIS_STEPPED_BLOCK_BOTTOM.get());
                        output.accept(ModBlocks.LAPIS_STEPPED_BOTTOM_CORNER_TOP.get());
                        output.accept(ModBlocks.LAPIS_STEPPED_BOTTOM_CORNER.get());
                        output.accept(ModBlocks.LAPIS_EXTENDED_BLOCK.get());
                        output.accept(ModBlocks.LAPIS_EXTENDED_BLOCK_CORNER.get());

                        output.accept(ModBlocks.LAPIS_WINDOW_STEPPED_BLOCK_BOTTOM.get());
                        output.accept(ModBlocks.SANDSTONE_WINDOW_STEPPED_BLOCK_BOTTOM.get());

                        output.accept(ModBlocks.LAPIS_BANDED_EXTENDED_BLOCK.get());
                        output.accept(ModBlocks.LAPIS_BANDED_EXTENDED_BLOCK_CORNER.get());

                        output.accept(ModBlocks.SANDSTONE_DIAGONAL_WALL.get());
                        output.accept(ModBlocks.SANDSTONE_DIAGONAL_WALL_MUDDY_BOTTOM.get());
                        output.accept(ModBlocks.SANDSTONE_DIAGONAL_WALL_MUDDY_TOP.get());
                        output.accept(ModBlocks.SANDSTONE_DIAGONAL_WALL_SHADOWED.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM_DIAGONAL.get());
                        output.accept(ModBlocks.SANDSTONE_STEPPED_BLOCK_BOTTOM_DIAGONAL_SHADOWED.get());
                        output.accept(ModBlocks.SANDSTONE_EXTENDED_BLOCK_DIAGONAL.get());
                        output.accept(ModBlocks.SANDSTONE_PEAK_DIAGONAL.get());
                        output.accept(ModBlocks.EXTENDED_CORNER.get());

                        output.accept(ModBlocks.SANDSTONE_ROUND_WINDOW.get());
                        output.accept(ModBlocks.SANDSTONE_ROUND_WINDOW_EXTENDED.get());
                        output.accept(ModBlocks.LAPIS_ROUND_WINDOW.get());
                        output.accept(ModBlocks.LAPIS_ROUND_WINDOW_EXTENDED.get());
                        output.accept(ModBlocks.SANDSTONE_WINDOW_RECTANGLE.get());
                        output.accept(ModBlocks.SANDSTONE_WINDOW_RECTANGLE_STEPPED.get());

                        output.accept(ModBlocks.POLISHED_SANDSTONE_FENCE.get());
                        output.accept(ModBlocks.POLISHED_SANDSTONE_FENCE_SMALL.get());
                        output.accept(ModBlocks.POLISHED_SANDSTONE_FENCE_SHORT.get());
                        output.accept(ModBlocks.POLISHED_SANDSTONE_FENCE_SHORT_SMALL.get());

                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_FENCE.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_FENCE_SMALL.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_FENCE_SHORT.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_FENCE_SHORT_SMALL.get());

                        output.accept(ModBlocks.SANDSTONE_INSET_WINDOW.get());
                        output.accept(ModBlocks.SANDSTONE_SINGLE_ARCH.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_SINGLE_ARCH.get());
                        output.accept(ModBlocks.SANDSTONE_SINGLE_ARCH_STEPPED.get());
                        output.accept(ModBlocks.SANDSTONE_DOUBLE_ARCH.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_DOUBLE_ARCH.get());
                        output.accept(ModBlocks.SANDSTONE_TRIPLE_ARCH.get());
                        output.accept(ModBlocks.SANDSTONE_TRIPLE_ARCH_CENTER.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_TRIPLE_ARCH.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_TRIPLE_ARCH_CENTER.get());
                        output.accept(ModBlocks.SANDSTONE_FIVE_ARCH_CENTER.get());
                        output.accept(ModBlocks.SANDSTONE_FIVE_ARCH_TOP.get());
                        output.accept(ModBlocks.SANDSTONE_FIVE_ARCH_MID.get());
                        output.accept(ModBlocks.SANDSTONE_FIVE_ARCH_BOTTOM.get());

                        output.accept(ModBlocks.NARROW_SANDSTONE_SINGLE_ARCH.get());
                        output.accept(ModBlocks.NARROW_SANDSTONE_SINGLE_ARCH_TALL.get());
                        output.accept(ModBlocks.NARROW_SANDSTONE_PEAK.get());

                        output.accept(ModBlocks.LAPIS_INSET_WINDOW.get());
                        output.accept(ModBlocks.LAPIS_SINGLE_ARCH.get());
                        output.accept(ModBlocks.LAPIS_DOUBLE_ARCH.get());
                        output.accept(ModBlocks.LAPIS_TRIPLE_ARCH.get());
                        output.accept(ModBlocks.LAPIS_TRIPLE_ARCH_CENTER.get());
                        output.accept(ModBlocks.NARROW_LAPIS_SINGLE_ARCH.get());
                        output.accept(ModBlocks.NARROW_LAPIS_SINGLE_ARCH_TALL.get());
                        output.accept(ModBlocks.LAPIS_FIVE_ARCH_CENTER.get());
                        output.accept(ModBlocks.LAPIS_FIVE_ARCH_TOP.get());
                        output.accept(ModBlocks.LAPIS_FIVE_ARCH_MID.get());
                        output.accept(ModBlocks.LAPIS_FIVE_ARCH_BOTTOM.get());

                        output.accept(ModBlocks.GRASS_TWO.get());
                        output.accept(ModBlocks.SANDY_STONES.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_DARK.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_BOTTOM_FADE.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_ROOF.get());
                        output.accept(ModBlocks.LIME_GYPSUM_PLASTER_RECESS.get());
                        output.accept(ModBlocks.LAPIS_GATE_BORDER_LEFT.get());
                        output.accept(ModBlocks.LAPIS_GATE_BORDER_RIGHT.get());

                        output.accept(ModBlocks.ISHTAR_GATE_AUROCH_GOLD_LEFT.get());
                        output.accept(ModBlocks.ISHTAR_GATE_AUROCH_WHITE_LEFT.get());
                        output.accept(ModBlocks.ISHTAR_GATE_DRAGON_GOLD_LEFT.get());
                        output.accept(ModBlocks.ISHTAR_GATE_DRAGON_WHITE_LEFT.get());
                        output.accept(ModBlocks.ISHTAR_GATE_AUROCH_GOLD_RIGHT.get());
                        output.accept(ModBlocks.ISHTAR_GATE_AUROCH_WHITE_RIGHT.get());
                        output.accept(ModBlocks.ISHTAR_GATE_DRAGON_GOLD_RIGHT.get());
                        output.accept(ModBlocks.ISHTAR_GATE_DRAGON_WHITE_RIGHT.get());

                        output.accept(ModBlocks.PALM_SAPLING_SMALL.get());
                        output.accept(ModBlocks.PALM_SAPLING.get());
                        output.accept(ModBlocks.PALM_SAPLING_LARGE.get());
                        output.accept(ModBlocks.OAK_LOG_TWO.get());

                        output.accept(ModBlocks.SANDSTONE_COVER.get());

                        output.accept(ModBlocks.SANDSTONE_BRIDGE_BACK_LEFT.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_BACK_RIGHT.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_CENTER.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_RIGHT.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_LEFT.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_BACK_LEFT.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_BACK_RIGHT_MUDDY_BOTTOM.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_CENTER_MUDDY_BOTTOM.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_RIGHT_MUDDY_BOTTOM.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_LEFT_MUDDY_BOTTOM.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_BACK_LEFT_MUDDY_BOTTOM.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_BACK_RIGHT_MUDDY_TOP.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_CENTER_MUDDY_TOP.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_RIGHT_MUDDY_TOP.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_FRONT_LEFT_MUDDY_TOP.get());
                        output.accept(ModBlocks.SANDSTONE_BRIDGE_BACK_LEFT_MUDDY_TOP.get());

                        output.accept(ModBlocks.MARKET_STALL.get());
                        output.accept(ModBlocks.OFFSET_FENCE_POST.get());
                        output.accept(ModBlocks.MARKET_ROOF_SLANTED.get());

                        output.accept(ModBlocks.BLUE_LEFT.get());
                        output.accept(ModBlocks.BLUE_RIGHT.get());
                        output.accept(ModBlocks.CYAN_LEFT.get());
                        output.accept(ModBlocks.CYAN_RIGHT.get());

                        output.accept(ModBlocks.CYPRESS_POT.get());
                        output.accept(ModBlocks.CYPRESS_POT_SMALL.get());
                        output.accept(ModBlocks.CYPRES_SMALL.get());
                        output.accept(ModBlocks.CYPRESS.get());
                        output.accept(ModBlocks.CYPRESS_LARGE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> MC_BABYLON_TAB = CREATIVE_MODE_TABS.register("mc_babylon_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.SANDSTONE))
                    .title(Component.translatable("creativetab.mc_babylon_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(Blocks.BAMBOO_TRAPDOOR);
                        output.accept(Blocks.WARPED_TRAPDOOR);
                        output.accept(Blocks.DEEPSLATE_BRICKS);
                        output.accept(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
                        output.accept(Blocks.CRACKED_DEEPSLATE_BRICKS);
                        output.accept(Blocks.DEEPSLATE);
                        output.accept(Blocks.DEEPSLATE_BRICK_STAIRS);
                        output.accept(Blocks.DEEPSLATE_BRICK_SLAB);
                        output.accept(Blocks.DEEPSLATE_BRICK_WALL);
                        output.accept(Blocks.CRACKED_DEEPSLATE_TILES);
                        output.accept(Blocks.NETHER_BRICKS);
                        output.accept(Blocks.CRACKED_NETHER_BRICKS);
                        output.accept(Blocks.NETHER_BRICK_STAIRS);
                        output.accept(Blocks.NETHER_BRICK_SLAB);
                        output.accept(Blocks.NETHER_BRICK_WALL);
                        output.accept(Blocks.CHISELED_NETHER_BRICKS);
                        output.accept(Blocks.RED_NETHER_BRICKS);
                        output.accept(Blocks.RED_NETHER_BRICK_STAIRS);
                        output.accept(Blocks.RED_NETHER_BRICK_SLAB);
                        output.accept(Blocks.RED_NETHER_BRICK_WALL);
                        output.accept(Blocks.POLISHED_BLACKSTONE);
                        output.accept(Blocks.POLISHED_BLACKSTONE_STAIRS);
                        output.accept(Blocks.POLISHED_BLACKSTONE_SLAB);
                        output.accept(Blocks.POLISHED_BLACKSTONE_WALL);
                        output.accept(Blocks.POLISHED_BLACKSTONE_BRICKS);
                        output.accept(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS);
                        output.accept(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB);
                        output.accept(Blocks.POLISHED_BLACKSTONE_BRICK_WALL);
                        output.accept(Blocks.WHITE_WOOL);
                        output.accept(Blocks.WHITE_CARPET);
                        output.accept(Blocks.LIGHT_GRAY_WOOL);
                        output.accept(Blocks.LIGHT_GRAY_CARPET);
                        output.accept(Blocks.PURPLE_WOOL);
                        output.accept(Blocks.PURPLE_CARPET);
                        output.accept(Blocks.MAGENTA_WOOL);
                        output.accept(Blocks.MAGENTA_CARPET);
                        output.accept(Blocks.RED_CONCRETE);
                        output.accept(Blocks.ANVIL);
                        output.accept(Blocks.CHIPPED_ANVIL);
                        output.accept(Blocks.DAMAGED_ANVIL);
                        output.accept(Blocks.LECTERN);
                        output.accept(Blocks.HOPPER);
                        output.accept(Blocks.CHISELED_SANDSTONE);
                        output.accept(Blocks.SANDSTONE);
                        output.accept(Blocks.SANDSTONE_STAIRS);
                        output.accept(Blocks.SANDSTONE_SLAB);
                        output.accept(Blocks.SANDSTONE_WALL);
                        output.accept(Blocks.RED_SANDSTONE);
                        output.accept(Blocks.CUT_RED_SANDSTONE);
                        output.accept(Blocks.CUT_RED_SANDSTONE_SLAB);
                        output.accept(Blocks.POLISHED_GRANITE);
                        output.accept(Blocks.POLISHED_GRANITE_STAIRS);
                        output.accept(Blocks.STONE_BRICKS);
                        output.accept(Blocks.STONE_BRICK_STAIRS);
                        output.accept(Blocks.POLISHED_ANDESITE);
                        output.accept(Blocks.POLISHED_ANDESITE_SLAB);
                        output.accept(Blocks.POLISHED_ANDESITE_STAIRS);
                        output.accept(Blocks.POLISHED_DEEPSLATE);
                        output.accept(Blocks.POLISHED_DEEPSLATE_SLAB);
                        output.accept(Blocks.POLISHED_DEEPSLATE_STAIRS);
                        output.accept(Blocks.CHERRY_STAIRS);
                        output.accept(Blocks.CHERRY_SLAB);
                        output.accept(Blocks.GRASS_BLOCK);
                        output.accept(Blocks.PODZOL);
                        output.accept(ModBlocks.GRASS_TWO.get());
                        output.accept(Blocks.RED_SAND);
                        output.accept(Blocks.MYCELIUM);
                        output.accept(Blocks.SAND);
                        output.accept(Blocks.OAK_LEAVES);
                        output.accept(Blocks.AZALEA_LEAVES);
                        output.accept(Blocks.BIRCH_FENCE);
                        output.accept(Blocks.SAND);
                        output.accept(ModBlocks.OAK_LOG_TWO.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> ITEMS = CREATIVE_MODE_TABS.register("items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SMALL_BARREL.get()))
                    .title(Component.translatable("creativetab.items"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModBlocks.MARKET_TABLE.get());
                        output.accept(ModBlocks.MARKET_TABLE_SINGLE.get());
                        output.accept(ModBlocks.SMALL_BARREL.get());
                        output.accept(ModBlocks.LARGE_BARREL.get());
                        output.accept(ModBlocks.MARKET_TRAY_EMPTY.get());
                        output.accept(ModBlocks.MARKET_TRAY_FILLED_BERRIES.get());
                        output.accept(ModBlocks.MARKET_TRAY_FILLED_GRAPES.get());
                        output.accept(ModBlocks.MARKET_TRAY_FILLED_DATES.get());
                        output.accept(ModBlocks.SMALL_BLUE_RUG.get());
                        output.accept(ModBlocks.SMALL_WHITE_RUG.get());
                        output.accept(ModBlocks.SMALL_TAN_RUG.get());
                        output.accept(ModBlocks.SMALL_RED_RUG.get());
                        output.accept(ModBlocks.WHEAT_SACK.get());
                        output.accept(ModBlocks.BARLEY_SACK.get());
                        output.accept(ModBlocks.WIDE_VASE.get());
                        output.accept(ModBlocks.TALL_VASE.get());
                        output.accept(ModBlocks.BARREL_PLANTER_SMALL.get());
                        output.accept(ModBlocks.BARREL_PLANTER.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> DEV_TAB = CREATIVE_MODE_TABS.register("dev_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LAPIS_GATE_BORDER_LEFT.get()))
                    .title(Component.translatable("creativetab.dev_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModBlocks.DYNAMIC_SAND.get());

                        output.accept(ModBlocks.PALM_TRUNK.get());

                        // output.accept(ModBlocks.CUSTOM_SANDSTONE.get());

                        // output.accept(ModBlocks.BANANA_CORE_TOP.get());
                        // output.accept(ModBlocks.PALM_LEAVES_2.get());

                        // output.accept(ModBlocks.PALM_CORE_BOTTOM.get());
                        // output.accept(ModBlocks.PALM_CORE_TOP.get());
                        // output.accept(ModBlocks.PALM_CORE_FROND.get());

                        output.accept(ModBlocks.PALM_LEAVES.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
