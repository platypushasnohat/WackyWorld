package com.platypushasnohat.wacky_world.registry;

import com.platypushasnohat.wacky_world.WackyWorld;
import com.platypushasnohat.wacky_world.blocks.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
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

    public static final RegistryObject<Block> SHORT_MYCELIUM_GRASS = registerBlock("short_mycelium_grass", () -> new PlantBlock(WWBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_SHORT_MYCELIUM_GRASS = registerBlockWithoutItem("potted_short_mycelium_grass", () -> new FlowerPotBlock(SHORT_MYCELIUM_GRASS.get(), registerFlowerPot()));

    public static final RegistryObject<Block> MYCELIUM_GRASS = registerBlock("mycelium_grass", () -> new PlantBlock(WWBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_MYCELIUM_GRASS = registerBlockWithoutItem("potted_mycelium_grass", () -> new FlowerPotBlock(MYCELIUM_GRASS.get(), registerFlowerPot()));

    public static final RegistryObject<Block> MIAN_BUSH = registerBlock("mian_bush", () -> new MianBushBlock(WWBlockProperties.leaves(MapColor.COLOR_PURPLE, SoundType.AZALEA_LEAVES)));
    public static final RegistryObject<Block> MIAN_SHRUB = registerBlock("mian_shrub", () -> new TallPlantBlock(WWBlockProperties.PLANT));

    public static final RegistryObject<Block> CHICKEN_OF_THE_CAVES = registerBlock("chicken_of_the_caves", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.TERRACOTTA_YELLOW), false));
    public static final RegistryObject<Block> POTTED_CHICKEN_OF_THE_CAVES = registerBlockWithoutItem("potted_chicken_of_the_caves", () -> new FlowerPotBlock(WWBlocks.CHICKEN_OF_THE_CAVES.get(), registerFlowerPot()));

    public static final RegistryObject<Block> RAINCAP = registerBlock("raincap", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_PURPLE), false));
    public static final RegistryObject<Block> POTTED_RAINCAP = registerBlockWithoutItem("potted_raincap", () -> new FlowerPotBlock(WWBlocks.RAINCAP.get(), registerFlowerPot()));

    public static final RegistryObject<Block> CAVE_PATTY = registerBlock("cave_patty", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_BROWN), false));
    public static final RegistryObject<Block> POTTED_CAVE_PATTY = registerBlockWithoutItem("potted_cave_patty", () -> new FlowerPotBlock(WWBlocks.CAVE_PATTY.get(), registerFlowerPot()));

    public static final RegistryObject<Block> POWDER_GNOME = registerBlock("powder_gnome", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_RED), false));
    public static final RegistryObject<Block> POTTED_POWDER_GNOME = registerBlockWithoutItem("potted_powder_gnome", () -> new FlowerPotBlock(WWBlocks.POWDER_GNOME.get(), registerFlowerPot()));

    public static final RegistryObject<Block> CREAM_CAP = registerBlock("cream_cap", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.TERRACOTTA_WHITE), false));
    public static final RegistryObject<Block> POTTED_CREAM_CAP = registerBlockWithoutItem("potted_cream_cap", () -> new FlowerPotBlock(WWBlocks.CREAM_CAP.get(), registerFlowerPot()));
    public static final RegistryObject<Block> CREAM_CAP_BLOCK = registerBlock("cream_cap_block", () -> new HugeMushroomBlock(WWBlockProperties.hugeMushroomBlock(MapColor.TERRACOTTA_WHITE)));

    public static final RegistryObject<Block> COPPER_ENOKI = registerBlock("copper_enoki", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_ORANGE), false));
    public static final RegistryObject<Block> POTTED_COPPER_ENOKI = registerBlockWithoutItem("potted_copper_enoki", () -> new FlowerPotBlock(WWBlocks.COPPER_ENOKI.get(), registerFlowerPot()));
    public static final RegistryObject<Block> COPPER_ENOKI_BLOCK = registerBlock("copper_enoki_block", () -> new HugeMushroomBlock(WWBlockProperties.hugeMushroomBlock(MapColor.COLOR_ORANGE)));

    public static final RegistryObject<Block> CAP_OF_EYE = registerBlock("cap_of_eye", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_PURPLE), false));
    public static final RegistryObject<Block> POTTED_CAP_OF_EYE = registerBlockWithoutItem("potted_cap_of_eye", () -> new FlowerPotBlock(WWBlocks.CAP_OF_EYE.get(), registerFlowerPot()));

    public static final RegistryObject<Block> PURPLE_KNOB = registerBlock("purple_knob", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_PURPLE), false));
    public static final RegistryObject<Block> POTTED_PURPLE_KNOB = registerBlockWithoutItem("potted_purple_knob", () -> new FlowerPotBlock(WWBlocks.PURPLE_KNOB.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SLIPPERY_TOP = registerBlock("slippery_top", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_YELLOW), false));
    public static final RegistryObject<Block> POTTED_SLIPPERY_TOP = registerBlockWithoutItem("potted_slippery_top", () -> new FlowerPotBlock(WWBlocks.SLIPPERY_TOP.get(), registerFlowerPot()));
    public static final RegistryObject<Block> SLIPPERY_TOP_BLOCK = registerBlock("slippery_top_block", () -> new HugeMushroomBlock(WWBlockProperties.hugeMushroomBlock(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> ORBSHROOM = registerBlock("orbshroom", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_PURPLE), false));
    public static final RegistryObject<Block> POTTED_ORBSHROOM = registerBlockWithoutItem("potted_orbshroom", () -> new FlowerPotBlock(WWBlocks.ORBSHROOM.get(), registerFlowerPot()));
    public static final RegistryObject<Block> ORBSHROOM_BLOCK = registerBlock("orbshroom_block", () -> new HugeMushroomBlock(WWBlockProperties.hugeMushroomBlock(MapColor.COLOR_PURPLE)));

    public static final RegistryObject<Block> QUEEN_IN_PURPLE = registerBlock("queen_in_purple", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_PURPLE), false));
    public static final RegistryObject<Block> POTTED_QUEEN_IN_PURPLE = registerBlockWithoutItem("potted_queen_in_purple", () -> new FlowerPotBlock(WWBlocks.QUEEN_IN_PURPLE.get(), registerFlowerPot()));
    public static final RegistryObject<Block> QUEEN_IN_PURPLE_BLOCK = registerBlock("queen_in_purple_block", () -> new HugeMushroomBlock(WWBlockProperties.hugeMushroomBlock(MapColor.COLOR_PURPLE)));

    public static final RegistryObject<Block> INK_CAP = registerBlock("ink_cap", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_BLACK), false));
    public static final RegistryObject<Block> POTTED_INK_CAP = registerBlockWithoutItem("potted_ink_cap", () -> new FlowerPotBlock(WWBlocks.INK_CAP.get(), registerFlowerPot()));

    public static final RegistryObject<Block> PRINCESS_JELLY = registerBlock("princess_jelly", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_MAGENTA), false));
    public static final RegistryObject<Block> POTTED_PRINCESS_JELLY = registerBlockWithoutItem("potted_princess_jelly", () -> new FlowerPotBlock(WWBlocks.PRINCESS_JELLY.get(), registerFlowerPot()));

    public static final RegistryObject<Block> POP_CAP = registerBlock("pop_cap", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_YELLOW), false));
    public static final RegistryObject<Block> POTTED_POP_CAP = registerBlockWithoutItem("potted_pop_cap", () -> new FlowerPotBlock(WWBlocks.POP_CAP.get(), registerFlowerPot()));

    public static final RegistryObject<Block> LIME_NUB = registerBlock("lime_nub", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_LIGHT_GREEN), false));
    public static final RegistryObject<Block> POTTED_LIME_NUB = registerBlockWithoutItem("potted_lime_nub", () -> new FlowerPotBlock(WWBlocks.LIME_NUB.get(), registerFlowerPot()));

    public static final RegistryObject<Block> GREEN_FUNK = registerBlock("green_funk", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_GREEN), false));
    public static final RegistryObject<Block> POTTED_GREEN_FUNK = registerBlockWithoutItem("potted_green_funk", () -> new FlowerPotBlock(WWBlocks.GREEN_FUNK.get(), registerFlowerPot()));

    public static final RegistryObject<Block> BLUE_TRUMPET = registerBlock("blue_trumpet", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.COLOR_LIGHT_BLUE), false));
    public static final RegistryObject<Block> POTTED_BLUE_TRUMPET = registerBlockWithoutItem("potted_blue_trumpet", () -> new FlowerPotBlock(WWBlocks.BLUE_TRUMPET.get(), registerFlowerPot()));

    public static final RegistryObject<Block> DEATH_CAP = registerBlock("death_cap", () -> new WWMushroomBlock(WWBlockProperties.mushroom(MapColor.SNOW), false));
    public static final RegistryObject<Block> POTTED_DEATH_CAP = registerBlockWithoutItem("potted_death_cap", () -> new FlowerPotBlock(WWBlocks.DEATH_CAP.get(), registerFlowerPot()));

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
