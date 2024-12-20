package com.palana.babylonmod.world.tree;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.mixin.FoliagePlacerTypeInvoker;
import com.palana.babylonmod.world.tree.custom.PalmFoliagePlacer;

import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> PALM_FOLIAGE_PLACER = FoliagePlacerTypeInvoker
            .callRegister("palm_foliage_placer", PalmFoliagePlacer.CODEC);

    public static void register() {
        BabylonMod.LOGGER.info("Registering Foliage Placer for " + BabylonMod.MOD_ID);
    }
}