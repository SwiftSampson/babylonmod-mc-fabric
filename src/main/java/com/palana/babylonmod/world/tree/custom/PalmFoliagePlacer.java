package com.palana.babylonmod.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import com.palana.babylonmod.block.custom.types.SizeType;
import com.palana.babylonmod.world.tree.ModFoliagePlacerTypes;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final Codec<PalmFoliagePlacer> CODEC = RecordCodecBuilder
            .create((palmFoliagePlacerInstance) -> fillFoliagePlacerFields(palmFoliagePlacerInstance)
                    .and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height))
                    .and(Codec.intRange(0, 16).fieldOf("size").forGetter(fp -> fp.size))
                    .apply(palmFoliagePlacerInstance, PalmFoliagePlacer::new));
    protected final int height;
    protected final int size;

    public PalmFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height, int size) {
        super(pRadius, pOffset);
        this.height = height;
        this.size = size;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
            int trunkHeight,
            TreeNode treeNode, int foliageHeight, int radius, int offset) {

        BlockState blockstate = config.foliageProvider.get(random,
                treeNode.getCenter());

        // tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, attachment.pos());
        // blockstate = blockstate.with(FACING, Direction.WEST);
        // blockstate = DirectionalPalmLeaves.rotate(blockstate, Direction.WEST);

        // top block (no facing)
        // foliageSetter.set(attachment.pos(), baseBlockstate);

        DirectionProperty FACING = HorizontalFacingBlock.FACING;
        EnumProperty<SizeType> SIZE = EnumProperty.of("size", SizeType.class);

        switch (this.size) {
            case 0:
                blockstate = blockstate.with(SIZE, SizeType.SMALL);
                break;
            case 1:
                blockstate = blockstate.with(SIZE, SizeType.MEDIUM);
                break;
            case 2:
                blockstate = blockstate.with(SIZE, SizeType.LARGE);
                break;
            default:
                blockstate = blockstate.with(SIZE, SizeType.MEDIUM);
                break;
        }

        blockstate = blockstate.with(FACING, Direction.EAST);
        placer.placeBlock(treeNode.getCenter().east(1), blockstate);
        // foliageSetter.set(attachment.pos().east(1).north(1), blockstate);

        blockstate = blockstate.with(FACING, Direction.WEST);
        placer.placeBlock(treeNode.getCenter().west(1), blockstate);

        blockstate = blockstate.with(FACING, Direction.NORTH);
        placer.placeBlock(treeNode.getCenter().north(1), blockstate);

        blockstate = blockstate.with(FACING, Direction.SOUTH);
        placer.placeBlock(treeNode.getCenter().south(1), blockstate);

    }

    @Override
    public int getRandomHeight(Random random, int pHeight, TreeFeatureConfig pConfig) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}