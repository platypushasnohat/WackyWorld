package com.platypushasnohat.wacky_world.registry;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class WWCompat {

    public static void registerCompat() {
        registerCompostables();
    }

    public static void registerCompostables() {
        registerCompostable(WWBlocks.CAVE_PATTY.get(), 0.65F);
        registerCompostable(WWBlocks.COPPER_ENOKI.get(), 0.65F);
        registerCompostable(WWBlocks.RAINCAP.get(), 0.65F);
        registerCompostable(WWBlocks.CREAM_CAP.get(), 0.65F);
        registerCompostable(WWBlocks.CHICKEN_OF_THE_CAVES.get(), 0.65F);
        registerCompostable(WWBlocks.POWDER_GNOME.get(), 0.65F);
        registerCompostable(WWBlocks.CAP_OF_EYE.get(), 0.65F);
        registerCompostable(WWBlocks.PURPLE_KNOB.get(), 0.65F);
        registerCompostable(WWBlocks.SLIPPERY_TOP.get(), 0.65F);
        registerCompostable(WWBlocks.ORBSHROOM.get(), 0.65F);
        registerCompostable(WWBlocks.QUEEN_IN_PURPLE.get(), 0.65F);
        registerCompostable(WWBlocks.INK_CAP.get(), 0.65F);
        registerCompostable(WWBlocks.PRINCESS_JELLY.get(), 0.65F);
        registerCompostable(WWBlocks.POP_CAP.get(), 0.65F);
        registerCompostable(WWBlocks.LIME_NUB.get(), 0.65F);
        registerCompostable(WWBlocks.GREEN_FUNK.get(), 0.65F);
        registerCompostable(WWBlocks.BLUE_TRUMPET.get(), 0.65F);
        registerCompostable(WWBlocks.DEATH_CAP.get(), 0.65F);

        registerCompostable(WWBlocks.COPPER_ENOKI_BLOCK.get(), 0.85F);
        registerCompostable(WWBlocks.CREAM_CAP_BLOCK.get(), 0.85F);
        registerCompostable(WWBlocks.SLIPPERY_TOP_BLOCK.get(), 0.85F);
        registerCompostable(WWBlocks.ORBSHROOM_BLOCK.get(), 0.85F);
        registerCompostable(WWBlocks.QUEEN_IN_PURPLE_BLOCK.get(), 0.85F);
    }

    public static void registerCompostable(ItemLike item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
}
