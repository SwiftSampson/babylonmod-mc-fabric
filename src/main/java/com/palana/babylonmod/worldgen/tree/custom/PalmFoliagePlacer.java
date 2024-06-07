package com.palana.babylonmod.worldgen.tree.custom;

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;

import java.io.Console;
import java.lang.System.Logger;

import org.jline.utils.Log;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.palana.babylonmod.block.ModBlocks;
import com.palana.babylonmod.block.custom.DirectionalPalmLeaves;
import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.worldgen.tree.ModFoliagePlacerTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final Codec<PalmFoliagePlacer> FOLIAGE_CODEC = RecordCodecBuilder
            .create((instance) -> foliagePlacerParts(instance)
                    .and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height))
                    .and(Codec.intRange(0, 16).fieldOf("size").forGetter(fp -> fp.size))
                    .apply(instance, PalmFoliagePlacer::new));
    protected final int height;
    protected final int size;

    public PalmFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height, int size) {
        super(pRadius, pOffset);
        this.height = height;
        this.size = size;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.PALM_FOLIAGE_PLACER.get();
    }

    // protected void createCustomFoliage(LevelSimulatedReader pLevel, FoliageSetter
    // foliageSetter, RandomSource pRandom,
    // TreeConfiguration pConfig, int maxFreeTreeHeight,
    // FoliagePlacer.FoliageAttachment attachment, int foliageHeight, int
    // foliageRadius, int offset) {

    // createFoliage(pLevel, foliageSetter, pRandom, pConfig, offset, attachment,
    // offset, offset);
    // }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter foliageSetter, RandomSource pRandom,
            TreeConfiguration pConfig, int maxFreeTreeHeight,
            FoliagePlacer.FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        // Creating the foliage
        // attachment.pos() is the first position ABOVE the last places log

        // tryPlaceLeaf() // places one leave at given position!
        // for (int i = 0; i < 4; i++) {
        // this.placeLeavesRow(pLevel, foliageSetter, pRandom, pConfig,
        // attachment.pos().above(0), 2, i + 1,
        // attachment.doubleTrunk());
        // }
        // TreeConfiguration topBlockTreeConfiguration = new
        // TreeConfiguration.TreeConfigurationBuilder(
        // BlockStateProvider.simple(ModBlocks.PALM_TRUNK.get()),
        // new PalmTrunkPlacer(4, 3, 2),
        // BlockStateProvider.simple(ModBlocks.PALM_TOP.get()),
        // new PalmFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 3),
        // new TwoLayersFeatureSize(1, 0, 2)).build();

        // System.out.println("HELLOE!" + this.size);
        // BlockState baseBlockstate =
        // topBlockTreeConfiguration.foliageProvider.getState(pRandom,
        // attachment.pos());
        BlockState blockstate = pConfig.foliageProvider.getState(pRandom,
                attachment.pos());

        // tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, attachment.pos());
        // blockstate = blockstate.setValue(FACING, Direction.WEST);
        // blockstate = DirectionalPalmLeaves.rotate(blockstate, Direction.WEST);

        // top block (no facing)
        // foliageSetter.set(attachment.pos(), baseBlockstate);

        DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
        EnumProperty<SizeType> SIZE = EnumProperty.create("size", SizeType.class);

        switch (this.size) {
            case 0:
                blockstate = blockstate.setValue(SIZE, SizeType.SMALL);
                break;
            case 1:
                blockstate = blockstate.setValue(SIZE, SizeType.MEDIUM);
                break;
            case 2:
                blockstate = blockstate.setValue(SIZE, SizeType.LARGE);
                break;
            default:
                blockstate = blockstate.setValue(SIZE, SizeType.MEDIUM);
                break;
        }

        blockstate = blockstate.setValue(FACING, Direction.EAST);
        foliageSetter.set(attachment.pos().east(1), blockstate);
        // foliageSetter.set(attachment.pos().east(1).north(1), blockstate);

        blockstate = blockstate.setValue(FACING, Direction.WEST);
        foliageSetter.set(attachment.pos().west(1), blockstate);

        blockstate = blockstate.setValue(FACING, Direction.NORTH);
        foliageSetter.set(attachment.pos().north(1), blockstate);

        blockstate = blockstate.setValue(FACING, Direction.SOUTH);
        foliageSetter.set(attachment.pos().south(1), blockstate);
        // System.out.println(blockstate.getValue(FACING));
        // tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,
        // attachment.pos().below(1).north(1));
        // tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,
        // attachment.pos().below(1).east(1));
        // tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,
        // attachment.pos().below(1).south(1));
        // customTryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig,
        // attachment.pos().below(1).west(1));

        // foliageSetter.set(attachment.pos().below(1).west(1),
        // pConfig.foliageProvider.getState(pRandom,
        // attachment.pos().below(1).west(1)));

    }

    protected static boolean customTryPlaceLeaf(LevelSimulatedReader p_273596_, FoliagePlacer.FoliageSetter p_273054_,
            RandomSource p_272977_, TreeConfiguration p_273040_, BlockPos p_273406_) {
        if (!TreeFeature.validTreePos(p_273596_, p_273406_)) {
            return false;
        } else {
            BlockState blockstate = p_273040_.foliageProvider.getState(p_272977_, p_273406_);
            blockstate = blockstate.setValue(BlockStateProperties.FACING, Direction.WEST);
            p_273054_.set(p_273406_, blockstate);
            return true;
        }

    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange,
            boolean pLarge) {
        return false;
    }
}