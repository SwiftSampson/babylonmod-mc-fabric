package com.palana.babylonmod.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.worldgen.tree.ModTrunkPlacerTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final Codec<PalmTrunkPlacer> TRUNK_CODEC = RecordCodecBuilder
            .create(palmTrunkPlacerInstance -> trunkPlacerParts(palmTrunkPlacerInstance)
                    .apply(palmTrunkPlacerInstance, PalmTrunkPlacer::new));

    public PalmTrunkPlacer(int pBaseHeight, int minHeight, int maxHeight) {
        super(pBaseHeight, minHeight, maxHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.PALM_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel,
            BiConsumer<BlockPos, BlockState> pBlockSetter,
            RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        // THIS IS WHERE THE BLOCK PLACING LOGIC IS!

        // int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 1)
        int random1 = pRandom.nextInt(heightRandA, heightRandB);
        int random2 = pRandom.nextInt(heightRandB - 1, heightRandB + 1);

        // create random object
        Random ran = new Random();

        // Print next int value
        // Returns number between 0-9
        int nxt = ran.nextInt(heightRandB - heightRandA + 1) + heightRandA;
        int height = nxt;
        System.out.println("TOTAL HEIGHT=" + height + "between" + heightRandA + "and" + heightRandB);

        // + pRandom.nextInt(heightRandB - 1, heightRandB + 1);

        EnumProperty<SizeType> SIZE = EnumProperty.create("size", SizeType.class);
        for (int i = 0; i < height; i++) {
            BlockState blockstate = pConfig.trunkProvider.getState(pRandom, pPos);
            // pBlockSetter.accept(pPos.above(i), blockstate.setValue(SIZE,
            // SizeType.MEDIUM));
            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
            // pBlockSetter.accept(pPos, blockstate.setValue(SIZE, SizeType.MEDIUM));
            // blockstate.setValue(SIZE, SizeType.MEDIUM);
            // if (height < 6) {
            //     pBlockSetter.accept(pPos.above(i), blockstate.setValue(SIZE, SizeType.SMALL));
            // } else {
                pBlockSetter.accept(pPos.above(i), blockstate.setValue(SIZE, SizeType.MEDIUM));
           // }

            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

            // BiConsumer<BlockPos, BlockState> newBlockSetter = (pos, state) -> {

            // BlockState newState = blockstate.setValue(SIZE, 3);
            // pBlockSetter.accept(pPos.above(i), newState);

            // };

            // emulate this:
            // foliageSetter.set(attachment.pos().east(1), blockstate);

            // pBlockSetter.accept(pPos, blockstate.setValue(SIZE, 3));

            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
            // if (i % 2 == 0 && pRandom.nextBoolean()) {

            // if (pRandom.nextFloat() > 0.25f) {
            // for (int x = 0; x < 4; x++) {
            // pBlockSetter.accept(pPos, blockstate.setValue(SIZE, 3));
            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
            // }
            // }

            // if (pRandom.nextFloat() > 0.25f) {
            // for (int x = 0; x < 4; x++) {
            // pBlockSetter.accept(pPos, blockstate.setValue(SIZE, 2));
            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
            // }
            // }

            // if (pRandom.nextFloat() > 0.25f) {
            // for (int x = 0; x < 4; x++) {
            // pBlockSetter.accept(pPos, blockstate.setValue(SIZE, 1));
            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
            // }
            // }

            // if (pRandom.nextFloat() > 0.25f) {
            // for (int x = 0; x < 4; x++) {
            // pBlockSetter.accept(pPos, blockstate.setValue(SIZE, 5));
            // placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
            // }
            // }
            // }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));// add
                                                                                                   // different
        // foliage options,
        // eg for top, sides
        // etc
    }
}