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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WWBlocks.MYORITE.get()))
                    .title(Component.translatable("itemGroup.wacky_world"))
                    .displayItems((pParameters, output) -> {

                        output.accept(WWBlocks.MYORITE.get());
                        output.accept(WWBlocks.MYORITE_STAIRS.get());
                        output.accept(WWBlocks.MYORITE_SLAB.get());
                        output.accept(WWBlocks.MYORITE_WALL.get());

                        output.accept(WWBlocks.POLISHED_MYORITE.get());
                        output.accept(WWBlocks.POLISHED_MYORITE_STAIRS.get());
                        output.accept(WWBlocks.POLISHED_MYORITE_SLAB.get());
                        output.accept(WWBlocks.POLISHED_MYORITE_WALL.get());

                        output.accept(WWBlocks.MYORITE_BRICKS.get());
                        output.accept(WWBlocks.MYORITE_BRICK_STAIRS.get());
                        output.accept(WWBlocks.MYORITE_BRICK_SLAB.get());
                        output.accept(WWBlocks.MYORITE_BRICK_WALL.get());

                        output.accept(WWBlocks.CHISELED_MYORITE_BRICKS.get());

                        output.accept(WWBlocks.SHORT_GRASS.get());
                        output.accept(WWBlocks.TWIRLY_GRASS.get());
                        output.accept(WWBlocks.SHRUB.get());

                        output.accept(WWBlocks.SHORT_MYCELIUM_GRASS.get());
                        output.accept(WWBlocks.MYCELIUM_GRASS.get());

                        output.accept(WWBlocks.MIAN_SHRUB.get());
                        output.accept(WWBlocks.MIAN_BUSH.get());

                        output.accept(WWBlocks.BLUE_TRUMPET.get());
                        output.accept(WWBlocks.CAP_OF_EYE.get());
                        output.accept(WWBlocks.CAVE_PATTY.get());
                        output.accept(WWBlocks.CHICKEN_OF_THE_CAVES.get());
                        output.accept(WWBlocks.COPPER_ENOKI.get());
                        output.accept(WWBlocks.CREAM_CAP.get());
                        output.accept(WWBlocks.DEATH_CAP.get());
                        output.accept(WWBlocks.GREEN_FUNK.get());
                        output.accept(WWBlocks.INK_CAP.get());
                        output.accept(WWBlocks.LIME_NUB.get());
                        output.accept(WWBlocks.ORBSHROOM.get());
                        output.accept(WWBlocks.POP_CAP.get());
                        output.accept(WWBlocks.POWDER_GNOME.get());
                        output.accept(WWBlocks.PRINCESS_JELLY.get());
                        output.accept(WWBlocks.PURPLE_KNOB.get());
                        output.accept(WWBlocks.QUEEN_IN_PURPLE.get());
                        output.accept(WWBlocks.RAINCAP.get());
                        output.accept(WWBlocks.SLIPPERY_TOP.get());
                        output.accept(WWBlocks.COPPER_ENOKI_BLOCK.get());
                        output.accept(WWBlocks.CREAM_CAP_BLOCK.get());
                        output.accept(WWBlocks.ORBSHROOM_BLOCK.get());
                        output.accept(WWBlocks.QUEEN_IN_PURPLE_BLOCK.get());
                        output.accept(WWBlocks.SLIPPERY_TOP_BLOCK.get());

                    }).build());
}
