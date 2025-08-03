package com.platypushasnohat.wacky_world.data;

import com.platypushasnohat.wacky_world.WackyWorld;
import com.platypushasnohat.wacky_world.WackyWorldTab;
import com.platypushasnohat.wacky_world.registry.WWBlocks;
import com.platypushasnohat.wacky_world.registry.WWItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Objects;
import java.util.function.Supplier;

public class WWLanguageProvider extends LanguageProvider {

    public WWLanguageProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), WackyWorld.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        // creative tab
        creativeTab(WackyWorldTab.WACKY_WORLD_TAB.get(), "Wacky World");

        // blocks
        WWBlocks.AUTO_TRANSLATE.forEach(this::forBlock);

        // items
        WWItems.AUTO_TRANSLATE.forEach(this::forItem);
    }

    private void forBlock(Supplier<? extends Block> block) {
        addBlock(block, WWTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    private void forItem(Supplier<? extends Item> item) {
        addItem(item, WWTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }

    private void forEntity(Supplier<? extends EntityType<?>> entity) {
        addEntityType(entity, WWTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.get())).getPath()));
    }

    private String format(ResourceLocation registryName) {
        return WordUtils.capitalizeFully(registryName.getPath().replace("_", " "));
    }

    protected void painting(String name, String author) {
        add("painting." + WackyWorld.MOD_ID + "." + name + ".title",  WWTextUtils.createTranslation(name));
        add("painting." + WackyWorld.MOD_ID + "." + name + ".author",  author);
    }

    protected void musicDisc(Supplier<? extends Item> item, String description) {
        String disc = item.get().getDescriptionId();
        add(disc, "Music Disc");
        add(disc + ".desc", description);
    }

    public void creativeTab(CreativeModeTab key, String name){
        add(key.getDisplayName().getString(), name);
    }

    public void sound(Supplier<? extends SoundEvent> key, String subtitle){
        add("subtitles." + key.get().getLocation().getPath(), subtitle);
    }

    public void blockEntity(String beName,String name){
        add(WackyWorld.MOD_ID + ".blockentity." + beName, name);
    }
}
