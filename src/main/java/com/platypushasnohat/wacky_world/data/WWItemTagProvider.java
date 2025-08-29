package com.platypushasnohat.wacky_world.data;

import com.platypushasnohat.wacky_world.WackyWorld;
import com.platypushasnohat.wacky_world.registry.WWBlocks;
import com.platypushasnohat.wacky_world.registry.tags.WWBlockTags;
import com.platypushasnohat.wacky_world.registry.tags.WWItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class WWItemTagProvider extends ItemTagsProvider {

    public WWItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> lookup, ExistingFileHelper helper) {
        super(output, provider, lookup, WackyWorld.MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.copy(BlockTags.SLABS, ItemTags.SLABS);
        this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
        this.copy(BlockTags.WALLS, ItemTags.WALLS);
        this.copy(WWBlockTags.MYORITE, WWItemTags.MYORITE);

        this.tag(Tags.Items.MUSHROOMS).add(
                WWBlocks.CAP_OF_EYE.get().asItem(),
                WWBlocks.CAVE_PATTY.get().asItem(),
                WWBlocks.CHICKEN_OF_THE_CAVES.get().asItem(),
                WWBlocks.COPPER_ENOKI.get().asItem(),
                WWBlocks.CREAM_CAP.get().asItem(),
                WWBlocks.POWDER_GNOME.get().asItem(),
                WWBlocks.PURPLE_KNOB.get().asItem(),
                WWBlocks.RAINCAP.get().asItem(),
                WWBlocks.SLIPPERY_TOP.get().asItem(),
                WWBlocks.ORBSHROOM.get().asItem(),
                WWBlocks.QUEEN_IN_PURPLE.get().asItem(),
                WWBlocks.INK_CAP.get().asItem(),
                WWBlocks.PRINCESS_JELLY.get().asItem(),
                WWBlocks.POP_CAP.get().asItem(),
                WWBlocks.LIME_NUB.get().asItem(),
                WWBlocks.GREEN_FUNK.get().asItem(),
                WWBlocks.BLUE_TRUMPET.get().asItem(),
                WWBlocks.DEATH_CAP.get().asItem()
        );
    }
}
