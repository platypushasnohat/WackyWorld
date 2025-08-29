package com.platypushasnohat.wacky_world.registry.tags;

import com.platypushasnohat.wacky_world.WackyWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class WWBlockTags {

    public static final TagKey<Block> MYORITE = modBlockTag("myorite");

    public static TagKey<Block> blockTag(String modid, String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(modid, name));
    }

    private static TagKey<Block> forgeBlockTag(String name) {
        return blockTag("forge", name);
    }

    private static TagKey<Block> modBlockTag(String name) {
        return blockTag(WackyWorld.MOD_ID, name);
    }
}
