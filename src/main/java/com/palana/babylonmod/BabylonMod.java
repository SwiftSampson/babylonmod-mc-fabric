package com.palana.babylonmod;

import com.mojang.logging.LogUtils;
import com.palana.babylonmod.block.ModBlocks;
import com.palana.babylonmod.item.ModItemGroup;
import com.palana.babylonmod.item.ModItems;
import com.palana.babylonmod.world.gen.ModWorldGeneration;
import com.palana.babylonmod.world.tree.ModFoliagePlacerTypes;
import com.palana.babylonmod.world.tree.ModTrunkPlacerTypes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class BabylonMod implements ModInitializer {
    public static final String MOD_ID = "babylonmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModWorldGeneration.generateModWorldGen();
        ModTrunkPlacerTypes.register();
        ModFoliagePlacerTypes.register();

    }

    // public BabylonMod() {
    // IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    // ModCreativeModeTabs.register(modEventBus);

    // modEventBus.addListener(this::commonSetup);

    // MinecraftForge.EVENT_BUS.register(this);
    // modEventBus.addListener(this::addCreative);

    // ModTrunkPlacerTypes.register(modEventBus);
    // ModFoliagePlacerTypes.register(modEventBus);

    // }

    // private void commonSetup(final FMLCommonSetupEvent event) {

    // }

    // private void addCreative(BuildCreativeModeTabContentsEvent event) {

    // }

    // // You can use SubscribeEvent and let the Event Bus discover methods to call
    // @SubscribeEvent
    // public void onServerStarting(ServerStartingEvent event) {

    // }

    // // You can use EventBusSubscriber to automatically register all static
    // methods
    // // in the class annotated with @SubscribeEvent
    // @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD,
    // value = Dist.CLIENT)
    // public static class ClientModEvents {
    // @SubscribeEvent
    // public static void onClientSetup(FMLClientSetupEvent event) {

    // }
    // }
}
