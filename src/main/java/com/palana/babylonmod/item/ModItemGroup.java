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

    public static final ItemGroup BABYLON_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BabylonMod.MOD_ID, "babylon_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.babylon_group"))
                    .icon(() -> new ItemStack(Blocks.SANDSTONE)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.SMALL_BARREL);
                        entries.add(ModBlocks.LAPIS_BRICK_STAIRS);

                    }).build());

    public static void registerItemGroups() {

    }
}
