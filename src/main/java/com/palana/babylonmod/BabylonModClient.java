package com.palana.babylonmod;

import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.fabricmc.api.ClientModInitializer;

public class BabylonModClient implements ClientModInitializer {
    public static final String MOD_ID = "babylonmod";

    @Override
    public void onInitializeClient() {
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> BabylonMod.MOD_ID.equals(location.getNamespace()));
    }

}
