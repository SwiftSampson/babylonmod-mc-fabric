package com.palana.babylonmod.world.tree;

import com.palana.babylonmod.BabylonMod;
import com.palana.babylonmod.mixin.TrunkPlacerTypeInvoker;
import com.palana.babylonmod.world.tree.custom.PalmTrunkPlacer;

import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> PALM_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("palm_trunk_placer",
            PalmTrunkPlacer.CODEC);

    public static void register() {
        BabylonMod.LOGGER.info("Registering Trunk Placers for " + BabylonMod.MOD_ID);
    }
}