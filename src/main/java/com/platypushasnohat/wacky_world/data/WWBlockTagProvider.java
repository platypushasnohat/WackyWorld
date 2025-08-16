package com.platypushasnohat.wacky_world.data;

import com.platypushasnohat.wacky_world.WackyWorld;
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
    }
}
