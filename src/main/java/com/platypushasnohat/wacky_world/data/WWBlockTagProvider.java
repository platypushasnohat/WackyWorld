package com.platypushasnohat.wacky_world.data;

import com.platypushasnohat.wacky_world.WackyWorld;
import com.platypushasnohat.wacky_world.registry.tags.WWBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.platypushasnohat.wacky_world.registry.WWBlocks.*;

public class WWBlockTagProvider extends BlockTagsProvider {

    public WWBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper helper) {
        super(output, provider, WackyWorld.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.STAIRS).add(
                MYORITE_STAIRS.get(), POLISHED_MYORITE_STAIRS.get(), MYORITE_BRICK_STAIRS.get()
        );

        this.tag(BlockTags.SLABS).add(
                MYORITE_SLAB.get(), POLISHED_MYORITE_SLAB.get(), MYORITE_BRICK_SLAB.get()
        );

        this.tag(BlockTags.WALLS).add(
                MYORITE_WALL.get(), POLISHED_MYORITE_WALL.get(), MYORITE_BRICK_WALL.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                MYORITE.get(), POLISHED_MYORITE.get(), MYORITE_BRICKS.get(), CHISELED_MYORITE_BRICKS.get(),
                MYORITE_STAIRS.get(), POLISHED_MYORITE_STAIRS.get(), MYORITE_BRICK_STAIRS.get(),
                MYORITE_SLAB.get(), POLISHED_MYORITE_SLAB.get(), MYORITE_BRICK_SLAB.get(),
                MYORITE_WALL.get(), POLISHED_MYORITE_WALL.get(), MYORITE_BRICK_WALL.get()
        );

        this.tag(WWBlockTags.MYORITE).add(
                MYORITE.get(), POLISHED_MYORITE.get(), MYORITE_BRICKS.get(), CHISELED_MYORITE_BRICKS.get(),
                MYORITE_STAIRS.get(), POLISHED_MYORITE_STAIRS.get(), MYORITE_BRICK_STAIRS.get(),
                MYORITE_SLAB.get(), POLISHED_MYORITE_SLAB.get(), MYORITE_BRICK_SLAB.get(),
                MYORITE_WALL.get(), POLISHED_MYORITE_WALL.get(), MYORITE_BRICK_WALL.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                CREAM_CAP_BLOCK.get(),
                COPPER_ENOKI_BLOCK.get(),
                SLIPPERY_TOP_BLOCK.get(),
                QUEEN_IN_PURPLE_BLOCK.get(),
                ORBSHROOM_BLOCK.get(),

                CAP_OF_EYE.get(),
                CAVE_PATTY.get(),
                CHICKEN_OF_THE_CAVES.get(),
                COPPER_ENOKI.get(),
                CREAM_CAP.get(),
                POWDER_GNOME.get(),
                PURPLE_KNOB.get(),
                RAINCAP.get(),
                SLIPPERY_TOP.get(),
                ORBSHROOM.get(),
                QUEEN_IN_PURPLE.get(),
                INK_CAP.get(),
                PRINCESS_JELLY.get(),
                POP_CAP.get(),
                LIME_NUB.get(),
                GREEN_FUNK.get(),
                BLUE_TRUMPET.get(),
                DEATH_CAP.get()
        );

        this.tag(BlockTags.ENDERMAN_HOLDABLE).add(
                CAP_OF_EYE.get(),
                CAVE_PATTY.get(),
                CHICKEN_OF_THE_CAVES.get(),
                COPPER_ENOKI.get(),
                CREAM_CAP.get(),
                POWDER_GNOME.get(),
                PURPLE_KNOB.get(),
                RAINCAP.get(),
                SLIPPERY_TOP.get(),
                ORBSHROOM.get(),
                QUEEN_IN_PURPLE.get(),
                INK_CAP.get(),
                PRINCESS_JELLY.get(),
                POP_CAP.get(),
                LIME_NUB.get(),
                GREEN_FUNK.get(),
                BLUE_TRUMPET.get(),
                DEATH_CAP.get()
        );

        this.tag(BlockTags.SWORD_EFFICIENT).add(
                CAP_OF_EYE.get(),
                CAVE_PATTY.get(),
                CHICKEN_OF_THE_CAVES.get(),
                COPPER_ENOKI.get(),
                CREAM_CAP.get(),
                POWDER_GNOME.get(),
                PURPLE_KNOB.get(),
                RAINCAP.get(),
                SLIPPERY_TOP.get(),
                ORBSHROOM.get(),
                QUEEN_IN_PURPLE.get(),
                INK_CAP.get(),
                PRINCESS_JELLY.get(),
                POP_CAP.get(),
                LIME_NUB.get(),
                GREEN_FUNK.get(),
                BLUE_TRUMPET.get(),
                DEATH_CAP.get()
        );
    }
}
