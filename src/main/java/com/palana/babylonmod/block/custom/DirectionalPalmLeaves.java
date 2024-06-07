package com.palana.babylonmod.block.custom;

import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;

import com.palana.babylonmod.block.custom.types.SizeType;

public class DirectionalPalmLeaves extends Block {
    public static DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    // public static BooleanProperty IS_CORNER = BlockStateProperties.CRACKED;
    public static EnumProperty<SizeType> SIZE = EnumProperty.create("size", SizeType.class);

    public DirectionalPalmLeaves(Properties pProperties) {

        super(pProperties);
        System.out.println("HELLOE!");
        System.out.println(pProperties);

    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        System.out.println("HELLOE THIS IS THE LEAVES BLCOK!");
        return this.defaultBlockState().setValue(FACING, placeContext.getHorizontalDirection()).setValue(SIZE,
                SizeType.MEDIUM);
    }

    public BlockState getRandomBlockState() {
        System.out.println("HELLOE Is corner:" + this.defaultBlockState());

        return this.defaultBlockState().setValue(FACING, Direction.EAST).setValue(SIZE,
                SizeType.MEDIUM);
    }

    public static BlockState rotate(BlockState pState, Direction direction) {
        return pState.setValue(FACING, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SIZE);
    }

}