package com.palana.babylonmod.worldgen.tree;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.worldgen.tree.custom.PalmFoliagePlacer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister
            .create(Registries.FOLIAGE_PLACER_TYPE, BabylonMod.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<PalmFoliagePlacer>> PALM_FOLIAGE_PLACER = FOLIAGE_PLACERS
            .register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.FOLIAGE_CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}