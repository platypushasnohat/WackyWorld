package com.platypushasnohat.wacky_world.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MianBushBlock extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public MianBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE));
    }

    public VoxelShape getBlockSupportShape(BlockState state, BlockGetter getter, BlockPos pos) {
        return Shapes.empty();
    }

    public int getLightBlock(BlockState state, BlockGetter getter, BlockPos pos) {
        return 1;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(WATERLOGGED);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockstate = this.defaultBlockState().setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        return blockstate;
    }
}
