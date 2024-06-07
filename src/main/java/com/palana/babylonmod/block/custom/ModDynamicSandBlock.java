package com.palana.babylonmod.block.custom;

import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.OverrideOnly;

import com.palana.babylonmod.block.custom.types.SandType;

public class ModDynamicSandBlock extends Block {
    public static EnumProperty<SandType> SAND_TYPE = EnumProperty.create("sand_type", SandType.class);

    public ModDynamicSandBlock(Properties pProperties) {

        super(pProperties);

    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {

        //
        // state.getBlock().getClass().getCanonicalName().equals("cethric.stuff.block.BlockMovingController")
        // check the block above
        // var state = placeContext.getClickedPos().north(0);
        // var state = placeContext.;
        // state.getBlock()

        BlockGetter blockgetter = placeContext.getLevel();
        BlockPos blockpos = placeContext.getClickedPos();
        FluidState fluidstate = placeContext.getLevel().getFluidState(placeContext.getClickedPos());
        BlockPos blockposNorth = blockpos.north();
        BlockPos blockposEast = blockpos.east();
        BlockPos blockposSouth = blockpos.south();
        BlockPos blockposWest = blockpos.west();
        BlockState northBlockstate = blockgetter.getBlockState(blockposNorth);
        BlockState eastBlockstate = blockgetter.getBlockState(blockposEast);
        BlockState SouthBlockstate = blockgetter.getBlockState(blockposSouth);
        BlockState westBlockstate = blockgetter.getBlockState(blockposWest);

        BlockPos blockposNorth1 = blockpos.north(2);
        BlockPos blockposEast1 = blockpos.east(2);
        BlockPos blockposSouth1 = blockpos.south(2);
        BlockPos blockposWest1 = blockpos.west(2);
        BlockState northBlockstate1 = blockgetter.getBlockState(blockposNorth1);
        BlockState eastBlockstate1 = blockgetter.getBlockState(blockposEast1);
        BlockState SouthBlockstate1 = blockgetter.getBlockState(blockposSouth1);
        BlockState westBlockstate1 = blockgetter.getBlockState(blockposWest1);

        // String asdasd = northBlockstate.getBlock().getDescriptionId();
        System.out.println("Northblockstate = dynamic sand: " +
                northBlockstate.getBlock().getDescriptionId());
        System.out.println("eastBlockstate = dynamic sand: " +
                eastBlockstate.getBlock().getDescriptionId());
        System.out.println("SouthBlockstate = dynamic sand: " +
                SouthBlockstate.getBlock().getDescriptionId());
        System.out.println("westBlockstate = dynamic sand: " +
                westBlockstate.getBlock().getDescriptionId());

        System.out.println("Northblockstate1 = dynamic sand: " +
                northBlockstate1.getBlock().getDescriptionId());
        System.out.println("eastBlockstate1 = dynamic sand: " +
                eastBlockstate1.getBlock().getDescriptionId());
        System.out.println("SouthBlockstate1 = dynamic sand: " +
                SouthBlockstate1.getBlock().getDescriptionId());
        System.out.println("westBlockstate1 = dynamic sand: " +
                westBlockstate1.getBlock().getDescriptionId());

        if (northBlockstate.getBlock().getDescriptionId().equals("block.babylonmod.dynamic_sand")) {

            return this.defaultBlockState().setValue(SAND_TYPE, SandType.SAND);
        } else {

            return this.defaultBlockState().setValue(SAND_TYPE, SandType.SAND);
        }

    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer,
            ItemStack pStack) {

        BlockPos blockposNorth = pPos.north();
        BlockPos blockposEast = pPos.east();
        BlockPos blockposSouth = pPos.south();
        BlockPos blockposWest = pPos.west();
        BlockState northBlockstate = pLevel.getBlockState(blockposNorth);
        BlockState eastBlockstate = pLevel.getBlockState(blockposEast);
        BlockState SouthBlockstate = pLevel.getBlockState(blockposSouth);
        BlockState westBlockstate = pLevel.getBlockState(blockposWest);

        // String asdasd = northBlockstate.getBlock().getDescriptionId();
        System.out.println("Northblockstate = dynamic sand: " +
                northBlockstate.getBlock().getDescriptionId() + pPlacer);
        if (northBlockstate.getBlock().getDescriptionId().equals("block.babylonmod.dynamic_sand")) {

            pState.setValue(SAND_TYPE, SandType.MYCELIUM);
        } else {

            pState.setValue(SAND_TYPE, SandType.SAND);
        }
    }

    // public BlockState updateFromNeighbourShapes(BlockState pCurrentState,
    // LevelAccessor pLevel, BlockPos pPos) {
    // BlockState blockstate = pCurrentState;
    // BlockPos.MutableBlockPos blockpos$mutableblockpos = new
    // BlockPos.MutableBlockPos();

    // blockpos$mutableblockpos.setWithOffset(pPos, Direction.NORTH);
    // BlockState northState = pLevel.getBlockState(blockpos$mutableblockpos);

    // MutableComponent asdasd = northState.getBlock().getName();
    // System.out.println("HELLOE THIS IS THE DIRECTIONAL BLCOK!" + asdasd);
    // // for(Direction direction : UPDATE_SHAPE_ORDER) {
    // // blockpos$mutableblockpos.setWithOffset(pPos, direction);
    // // blockstate = blockstate.updateShape(direction,
    // // pLevel.getBlockState(blockpos$mutableblockpos), pLevel, pPos,
    // // blockpos$mutableblockpos);
    // // }

    // return blockstate;
    // }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SAND_TYPE);
    }

    // @Override
    // public boolean isOpaqueCube() {
    // return false;
    // }

    // @Override
    // public boolean isFullCube() {
    // return false;
    // }

}