package com.palana.babylonmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import com.palana.babylonmod.block.custom.types.SandType;

public class ModDynamicSandBlock extends Block {
        public static EnumProperty<SandType> SAND_TYPE = EnumProperty.of("sand_type", SandType.class);

        public ModDynamicSandBlock(Settings settings) {
                super(settings);
        }

        @Nullable
        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx) {

                World blockgetter = ctx.getWorld();
                BlockPos blockpos = ctx.getBlockPos();
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

                System.out.println("Northblockstate = dynamic sand: " +
                                northBlockstate.getBlock().getTranslationKey());
                System.out.println("eastBlockstate = dynamic sand: " +
                                eastBlockstate.getBlock().getTranslationKey());
                System.out.println("SouthBlockstate = dynamic sand: " +
                                SouthBlockstate.getBlock().getTranslationKey());
                System.out.println("westBlockstate = dynamic sand: " +
                                westBlockstate.getBlock().getTranslationKey());

                System.out.println("Northblockstate1 = dynamic sand: " +
                                northBlockstate1.getBlock().getTranslationKey());
                System.out.println("eastBlockstate1 = dynamic sand: " +
                                eastBlockstate1.getBlock().getTranslationKey());
                System.out.println("SouthBlockstate1 = dynamic sand: " +
                                SouthBlockstate1.getBlock().getTranslationKey());
                System.out.println("westBlockstate1 = dynamic sand: " +
                                westBlockstate1.getBlock().getTranslationKey());

                if (northBlockstate.getBlock().getTranslationKey().equals("block.babylonmod.dynamic_sand")) {

                        return this.getDefaultState().with(SAND_TYPE, SandType.SAND);
                } else {

                        return this.getDefaultState().with(SAND_TYPE, SandType.SAND);
                }

        }

        @Override
        public void onPlaced(World world, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer,
                        ItemStack pStack) {

                BlockPos blockposNorth = pPos.north();
                BlockState northBlockstate = world.getBlockState(blockposNorth);

                System.out.println("Northblockstate = dynamic sand: " +
                                northBlockstate.getBlock().getTranslationKey() + pPlacer);
                if (northBlockstate.getBlock().getTranslationKey().equals("block.babylonmod.dynamic_sand")) {

                        pState.with(SAND_TYPE, SandType.MYCELIUM);
                } else {

                        pState.with(SAND_TYPE, SandType.SAND);
                }
        }

        @Override
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
                builder.add(SAND_TYPE);
        }

}