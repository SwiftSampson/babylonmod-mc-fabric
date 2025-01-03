package com.palana.babylonmod.item;

import net.minecraft.registry.Registry;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.block.ModBlocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.Registries;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
// import net.minecraft.registry.Registries;
// import net.minecraft.util.Identifier;
// import net.minecraft.registry.Registry;
// import net.minecraft.item.*;

public class ModItems {

    public static final Item BABYLON_WHEAT_SEEDS = registerItem("babylon_wheat_seeds",
            new AliasedBlockItem(ModBlocks.BABYLON_WHEAT_CROP, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BabylonMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {

        // entries.add(ModBlocks.BABYLON_WHEAT_CROP.asItem());

    }

    public static void registerModItems() {
        BabylonMod.LOGGER.info("Registering Mod Items for " + BabylonMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}