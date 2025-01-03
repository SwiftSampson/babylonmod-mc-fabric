package com.palana.babylonmod.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.world.tree.ModTrunkPlacerTypes;

import net.minecraft.block.BlockState;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.minecraft.util.math.random.Random;

import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder
            .create(objectInstance -> fillTrunkPlacerFields(objectInstance)
                    .apply(objectInstance, PalmTrunkPlacer::new));
    protected final int baseHeight;
    protected final int firstRandomHeight;
    protected final int secondRandomHeight;

    public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.baseHeight = baseHeight;
        this.firstRandomHeight = firstRandomHeight;
        this.secondRandomHeight = secondRandomHeight;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.PALM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
            Random pRandom, int height, BlockPos pPos, TreeFeatureConfig pConfig) {
        // THIS IS WHERE THE BLOCK PLACING LOGIC IS!

        // int height = pFreeTreeHeight + pRandom.nextInt(firstRandomHeight,
        // firstRandomHeight + 1)

        // create random object
        // Random ran = new Random();

        // Print next int value
        // Returns number between 0-9
        int avgHeight = pRandom.nextBetween(firstRandomHeight, secondRandomHeight);
        // int someheight = nxt;
        System.out.println(
                "TOTAL HEIGHT=" + "between" + firstRandomHeight + "and" + secondRandomHeight + "actual:" + avgHeight);

        // + pRandom.nextInt(secondRandomHeight - 1, secondRandomHeight + 1);

        EnumProperty<SizeType> SIZE = EnumProperty.of("size", SizeType.class);
        for (int i = 0; i < avgHeight; i++) {
            BlockState blockstate = pConfig.trunkProvider.get(pRandom, pPos.up(i));

            replacer.accept(pPos.up(i), blockstate.with(SIZE, SizeType.MEDIUM));

        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(pPos.up(avgHeight), 0, false));// add
                                                                                          // different
        // foliage options,
        // eg for top, sides
        // etc
    }
}