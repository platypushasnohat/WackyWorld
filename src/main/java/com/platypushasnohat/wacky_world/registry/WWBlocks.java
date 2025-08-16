package com.platypushasnohat.wacky_world.registry;

import com.platypushasnohat.wacky_world.WackyWorld;
import com.platypushasnohat.wacky_world.blocks.*;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WWBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WackyWorld.MOD_ID);
    public static List<RegistryObject<? extends Block>> AUTO_TRANSLATE = new ArrayList<>();

    public static final RegistryObject<Block> MYORITE = registerBlock("myorite", () -> new Block(WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> MYORITE_STAIRS = registerBlock("myorite_stairs", () -> new StairBlock(() -> MYORITE.get().defaultBlockState(), WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> MYORITE_SLAB = registerBlock("myorite_slab", () -> new SlabBlock(WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> MYORITE_WALL = registerBlock("myorite_wall", () -> new WallBlock(WWBlockProperties.MYORITE));

    public static final RegistryObject<Block> POLISHED_MYORITE = registerBlock("polished_myorite", () -> new Block(WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> POLISHED_MYORITE_STAIRS = registerBlock("polished_myorite_stairs", () -> new StairBlock(() -> POLISHED_MYORITE.get().defaultBlockState(), WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> POLISHED_MYORITE_SLAB = registerBlock("polished_myorite_slab", () -> new SlabBlock(WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> POLISHED_MYORITE_WALL = registerBlock("polished_myorite_wall", () -> new WallBlock(WWBlockProperties.MYORITE));

    public static final RegistryObject<Block> MYORITE_BRICKS = registerBlock("myorite_bricks", () -> new Block(WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> MYORITE_BRICK_STAIRS = registerBlock("myorite_brick_stairs", () -> new StairBlock(() -> MYORITE_BRICKS.get().defaultBlockState(), WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> MYORITE_BRICK_SLAB = registerBlock("myorite_brick_slab", () -> new SlabBlock(WWBlockProperties.MYORITE));
    public static final RegistryObject<Block> MYORITE_BRICK_WALL = registerBlock("myorite_brick_wall", () -> new WallBlock(WWBlockProperties.MYORITE));

    public static final RegistryObject<Block> CHISELED_MYORITE_BRICKS = registerBlock("chiseled_myorite_bricks", () -> new Block(WWBlockProperties.MYORITE));

    public static final RegistryObject<Block> SHRUB = registerBlock("shrub", () -> new PlantBlock(WWBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_SHRUB = registerBlockWithoutItem("potted_shrub", () -> new FlowerPotBlock(SHRUB.get(), registerFlowerPot()));

    public static final RegistryObject<Block> TWIRLY_GRASS = registerBlock("twirly_grass", () -> new PlantBlock(WWBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_TWIRLY_GRASS = registerBlockWithoutItem("potted_twirly_grass", () -> new FlowerPotBlock(TWIRLY_GRASS.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SHORT_GRASS = registerBlock("short_grass", () -> new ShortGrassBlock(WWBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_SHORT_GRASS = registerBlockWithoutItem("potted_short_grass", () -> new FlowerPotBlock(SHORT_GRASS.get(), registerFlowerPot()));

    private static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        WWItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        AUTO_TRANSLATE.add(block);
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerBlockNoLang(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        WWItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerBlockWithoutItem(String name, Supplier<B> block) {
        return BLOCKS.register(name, block);
    }

    public static BlockBehaviour.Properties registerFlowerPot(FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }
        return properties;
    }
}
