package com.palana.babylonmod.worldgen.tree;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.worldgen.tree.custom.PalmTrunkPlacer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister
            .create(Registries.TRUNK_PLACER_TYPE, BabylonMod.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<PalmTrunkPlacer>> PALM_TRUNK_PLACER = TRUNK_PLACERS
            .register("palm_trunk_placer", () -> new TrunkPlacerType<>(PalmTrunkPlacer.TRUNK_CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}