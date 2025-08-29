package com.platypushasnohat.wacky_world.registry;

import net.minecraft.data.BlockFamily;

import static com.platypushasnohat.wacky_world.registry.WWBlocks.*;

public class WWBlockFamilies {
    public static final BlockFamily MYORITE_FAMILY = new BlockFamily.Builder(MYORITE.get()).slab(MYORITE_SLAB.get()).stairs(MYORITE_STAIRS.get()).wall(MYORITE_WALL.get()).getFamily();
    public static final BlockFamily POLISHED_MYORITE_FAMILY = new BlockFamily.Builder(POLISHED_MYORITE.get()).slab(POLISHED_MYORITE_SLAB.get()).stairs(POLISHED_MYORITE_STAIRS.get()).wall(POLISHED_MYORITE_WALL.get()).getFamily();
    public static final BlockFamily MYORITE_BRICKS_FAMILY = new BlockFamily.Builder(MYORITE_BRICKS.get()).slab(MYORITE_BRICK_SLAB.get()).stairs(MYORITE_BRICK_STAIRS.get()).wall(MYORITE_BRICK_WALL.get()).getFamily();

}
