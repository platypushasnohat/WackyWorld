package com.platypushasnohat.wacky_world;

import com.platypushasnohat.wacky_world.registry.WWBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class WackyWorldTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WackyWorld.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WACKY_WORLD_TAB = CREATIVE_TABS.register("wacky_world",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WWBlocks.MYOCINAL_STONE.get()))
                    .title(Component.translatable("itemGroup.wacky_world"))
                    .displayItems((pParameters, output) -> {

                        output.accept(WWBlocks.MYOCINAL_STONE.get());

                    }).build());
}
