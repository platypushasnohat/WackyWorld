package com.platypushasnohat.wacky_world;

import com.platypushasnohat.wacky_world.data.WWBlockstateProvider;
import com.platypushasnohat.wacky_world.data.WWItemModelProvider;
import com.platypushasnohat.wacky_world.data.WWLanguageProvider;
import com.platypushasnohat.wacky_world.registry.WWBlocks;
import com.platypushasnohat.wacky_world.registry.WWItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Mod(WackyWorld.MOD_ID)
public class WackyWorld {

    public static final String MOD_ID = "wacky_world";

    public WackyWorld() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::dataSetup);

        WackyWorldTab.CREATIVE_TABS.register(bus);
        WWItems.ITEMS.register(bus);
        WWBlocks.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void dataSetup(GatherDataEvent data) {
        DataGenerator generator = data.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = data.getLookupProvider();
        ExistingFileHelper helper = data.getExistingFileHelper();

        boolean client = data.includeClient();
        generator.addProvider(client, new WWBlockstateProvider(data));
        generator.addProvider(client, new WWItemModelProvider(data));
        generator.addProvider(client, new WWLanguageProvider(data));

        boolean server = data.includeServer();
    }

    public static ResourceLocation modPrefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}

