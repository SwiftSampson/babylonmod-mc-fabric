package com.palana.babylonmod.item;

import com.palana.babylonmod.BabylonMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
// import net.minecraft.registry.Registries;
// import net.minecraft.util.Identifier;
// import net.minecraft.registry.Registry;
// import net.minecraft.item.*;

public class ModItems {
    // private static Item registerItem(String name, Item item) {
    // return Registry.register(Registries.ITEM, new Identifier(BabylonMod.MOD_ID,
    // name), item);
    // }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        // entries.add(PINK_GARNET);
        // entries.add(RAW_PINK_GARNET);

        // entries.add(ModBlocks.PINK_GARNET_BLOCK);
        // entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
    }

    public static void registerModItems() {
        BabylonMod.LOGGER.info("Registering Mod Items for " + BabylonMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
