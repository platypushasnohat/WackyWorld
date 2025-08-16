package com.platypushasnohat.wacky_world.events;

import com.platypushasnohat.wacky_world.WackyWorld;
import com.platypushasnohat.wacky_world.registry.WWBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = WackyWorld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, world, pos, tintIndex) -> {
                    if (world == null || pos == null) {
                        return FoliageColor.getDefaultColor();
                    }
                    return BiomeColors.getAverageGrassColor(world, pos);
                },
                WWBlocks.SHRUB.get(),
                WWBlocks.TWIRLY_GRASS.get(),
                WWBlocks.SHORT_GRASS.get(),
                WWBlocks.POTTED_SHORT_GRASS.get(),
                WWBlocks.POTTED_TWIRLY_GRASS.get(),
                WWBlocks.POTTED_SHRUB.get()
        );
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
                    BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                    return event.getBlockColors().getColor(blockstate, null, null, tintIndex);
                },
                WWBlocks.SHRUB.get(),
                WWBlocks.TWIRLY_GRASS.get(),
                WWBlocks.SHORT_GRASS.get(),
                WWBlocks.POTTED_SHORT_GRASS.get(),
                WWBlocks.POTTED_TWIRLY_GRASS.get(),
                WWBlocks.POTTED_SHRUB.get()
        );
    }

}
