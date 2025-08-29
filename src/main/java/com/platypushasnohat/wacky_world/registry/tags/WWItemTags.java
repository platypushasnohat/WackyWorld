package com.platypushasnohat.wacky_world.registry.tags;

import com.platypushasnohat.wacky_world.WackyWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class WWItemTags {

    public static final TagKey<Item> MYORITE  = modItemTag("myorite");

    private static TagKey<Item> modItemTag(String name) {
        return itemTag(WackyWorld.MOD_ID, name);
    }

    private static TagKey<Item> forgeItemTag(String name) {
        return itemTag("forge", name);
    }

    public static TagKey<Item> itemTag(String modid, String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(modid, name));
    }
}
