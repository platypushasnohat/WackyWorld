package com.platypushasnohat.wacky_world.blocks;

import com.platypushasnohat.wacky_world.registry.WWBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import static com.platypushasnohat.wacky_world.WackyWorld.modPrefix;

public class WWMushroomBlock extends BushBlock implements BonemealableBlock {

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public final boolean hasGiantMushroom;

    public WWMushroomBlock(Properties properties, boolean hasGiantMushroom) {
        super(properties);
        this.hasGiantMushroom = hasGiantMushroom;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return state.isSolidRender(blockGetter, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = level.getBlockState(blockpos);
        if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return level.getRawBrightness(pos, 0) < 13 && blockstate.canSustainPlant(level, blockpos, net.minecraft.core.Direction.UP, this);
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isValid) {
        return hasGiantMushroom;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return (double) random.nextFloat() < 0.4D;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.growMushroom(level, pos, state, random);
    }

    public boolean growMushroom(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        level.removeBlock(pos, false);
        Holder<ConfiguredFeature<?, ?>> feature = null;

        if (state.is(WWBlocks.COPPER_ENOKI.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_copper_enoki")))).get());
        if (state.is(WWBlocks.CREAM_CAP.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_cream_cap")))).get());
        if (state.is(WWBlocks.SLIPPERY_TOP.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_slippery_top")))).get());
        if (state.is(WWBlocks.POWDER_GNOME.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_powder_gnome")))).get());
        if (state.is(WWBlocks.CAVE_PATTY.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_cave_patty")))).get());
        if (state.is(WWBlocks.PURPLE_KNOB.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_purple_knob")))).get());
        if (state.is(WWBlocks.RAINCAP.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_raincap")))).get());
        if (state.is(WWBlocks.QUEEN_IN_PURPLE.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_queen_in_purple")))).get());
        if (state.is(WWBlocks.ORBSHROOM.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_orbshroom")))).get());
        if (state.is(WWBlocks.INK_CAP.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_ink_cap")))).get());
        if (state.is(WWBlocks.PRINCESS_JELLY.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_princess_jelly")))).get());
        if (state.is(WWBlocks.POP_CAP.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_pop_cap")))).get());
        if (state.is(WWBlocks.LIME_NUB.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_lime_nub")))).get());
        if (state.is(WWBlocks.GREEN_FUNK.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_green_funk")))).get());
        if (state.is(WWBlocks.BLUE_TRUMPET.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_blue_trumpet")))).get());
        if (state.is(WWBlocks.DEATH_CAP.get())) feature = (level.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap(registry -> registry.getHolder(ResourceKey.create(Registries.CONFIGURED_FEATURE, modPrefix("giant_death_cap")))).get());

        if (feature != null) {
            if ((feature.value()).place(level, level.getChunkSource().getGenerator(), random, pos)) {
                return true;
            } else {
                level.setBlock(pos, state, 3);
                return false;
            }
        }
        else return false;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(25) == 0) {
            int i = 5;

            for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4))) {
                if (level.getBlockState(blockpos).is(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

            for(int k = 0; k < 4; ++k) {
                if (level.isEmptyBlock(blockpos1) && state.canSurvive(level, blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }

            if (level.isEmptyBlock(blockpos1) && state.canSurvive(level, blockpos1)) {
                level.setBlock(blockpos1, state, 2);
            }
        }
    }
}
