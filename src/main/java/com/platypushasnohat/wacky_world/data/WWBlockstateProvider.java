package com.platypushasnohat.wacky_world.data;

import com.platypushasnohat.wacky_world.WackyWorld;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static com.platypushasnohat.wacky_world.registry.WWBlocks.*;

public class WWBlockstateProvider extends BlockStateProvider {

    public WWBlockstateProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), WackyWorld.MOD_ID, event.getExistingFileHelper());
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    @Override
    protected void registerStatesAndModels() {
        this.cubeAllBlock(MYORITE);
        this.stairs(MYORITE_STAIRS, this.blockTexture(MYORITE.get()));
        this.slab(MYORITE_SLAB, this.blockTexture(MYORITE.get()));
        this.wall(MYORITE_WALL, this.blockTexture(MYORITE.get()));

        this.cubeAllBlock(POLISHED_MYORITE);
        this.stairs(POLISHED_MYORITE_STAIRS, this.blockTexture(POLISHED_MYORITE.get()));
        this.slab(POLISHED_MYORITE_SLAB, this.blockTexture(POLISHED_MYORITE.get()));
        this.wall(POLISHED_MYORITE_WALL, this.blockTexture(POLISHED_MYORITE.get()));

        this.cubeAllBlock(MYORITE_BRICKS);
        this.stairs(MYORITE_BRICK_STAIRS, this.blockTexture(MYORITE_BRICKS.get()));
        this.slab(MYORITE_BRICK_SLAB, this.blockTexture(MYORITE_BRICKS.get()));
        this.wall(MYORITE_BRICK_WALL, this.blockTexture(MYORITE_BRICKS.get()));
        this.cubeAllBlock(CHISELED_MYORITE_BRICKS);

        this.tintedPottedPlant(SHRUB, POTTED_SHRUB);
        this.tintedPottedPlant(TWIRLY_GRASS, POTTED_TWIRLY_GRASS);
        this.tintedPottedPlant(SHORT_GRASS, POTTED_SHORT_GRASS);

        this.pottedPlant(SHORT_MYCELIUM_GRASS, POTTED_SHORT_MYCELIUM_GRASS);
        this.pottedPlant(MYCELIUM_GRASS, POTTED_MYCELIUM_GRASS);

        this.tallPlant(MIAN_SHRUB);
        this.cubeAllBlockWithRenderType(MIAN_BUSH, "cutout");

        this.pottedPlant(CAVE_PATTY, POTTED_CAVE_PATTY);
        this.pottedPlant(COPPER_ENOKI, POTTED_COPPER_ENOKI);
        this.pottedPlant(RAINCAP, POTTED_RAINCAP);
        this.pottedPlant(CREAM_CAP, POTTED_CREAM_CAP);
        this.pottedPlant(CHICKEN_OF_THE_CAVES, POTTED_CHICKEN_OF_THE_CAVES);
        this.pottedPlant(POWDER_GNOME, POTTED_POWDER_GNOME);

        this.pottedPlant(CAP_OF_EYE, POTTED_CAP_OF_EYE);
        this.pottedPlant(PURPLE_KNOB, POTTED_PURPLE_KNOB);
        this.pottedPlant(SLIPPERY_TOP, POTTED_SLIPPERY_TOP);

        this.pottedPlant(INK_CAP, POTTED_INK_CAP);
        this.pottedPlant(PRINCESS_JELLY, POTTED_PRINCESS_JELLY);
        this.pottedPlant(POP_CAP, POTTED_POP_CAP);
        this.pottedPlant(LIME_NUB, POTTED_LIME_NUB);
        this.pottedPlant(GREEN_FUNK, POTTED_GREEN_FUNK);
        this.pottedPlant(BLUE_TRUMPET, POTTED_BLUE_TRUMPET);
        this.pottedPlant(DEATH_CAP, POTTED_DEATH_CAP);
        this.pottedPlant(QUEEN_IN_PURPLE, POTTED_QUEEN_IN_PURPLE);
        this.pottedPlant(ORBSHROOM, POTTED_ORBSHROOM);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    // item
    private void itemModel(RegistryObject<Block> block) {
        this.itemModels().withExistingParent(getItemName(block.get()), this.blockTexture(block.get()));
    }

    private void generatedItem(ItemLike item, TextureFolder folder) {
        String name = getItemName(item);
        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc(folder.format(name)));
    }

    // block
    private void cubeAllBlock(RegistryObject<Block> block) {
        this.simpleBlock(block.get());
        this.itemModel(block);
    }

    private void stairs(RegistryObject<Block> stairs, ResourceLocation texture) {
        this.stairsBlock((StairBlock) stairs.get(), texture);
        this.itemModel(stairs);
    }

    private void slab(RegistryObject<Block> slab, ResourceLocation texture) {
        this.slabBlock((SlabBlock) slab.get(), texture, texture);
        this.itemModel(slab);
    }

    private void wall(RegistryObject<Block> wall, ResourceLocation texture) {
        this.wallBlock((WallBlock) wall.get(), texture);
        this.itemModels().wallInventory(getItemName(wall.get()), texture);
    }

    private void pillar(RegistryObject<Block> pillar) {
        this.axisBlock((RotatedPillarBlock) pillar.get(), this.blockTexture(pillar.get()), this.modLoc("block/" + getItemName(pillar.get()) + "_top"));
        this.itemModel(pillar);
    }

    private void pillarNoTop(RegistryObject<Block> pillar) {
        this.axisBlock((RotatedPillarBlock) pillar.get(), this.blockTexture(pillar.get()), this.modLoc("block/" + getItemName(pillar.get()) + "_top"));
        this.itemModel(pillar);
    }

    private void wood(RegistryObject<Block> log, ResourceLocation texture) {
        this.axisBlock((RotatedPillarBlock) log.get(), texture, texture);
        this.itemModel(log);
    }

    private void fence(RegistryObject<Block> fence, ResourceLocation texture) {
        this.fenceBlock((FenceBlock) fence.get(), texture);
        this.itemModels().fenceInventory(getItemName(fence.get()), texture);
    }

    private void fenceGate(RegistryObject<Block> gate, ResourceLocation texture) {
        this.fenceGateBlock((FenceGateBlock) gate.get(), texture);
        this.itemModel(gate);
    }

    private void trapdoor(RegistryObject<Block> trapdoor) {
        this.trapdoorBlock((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true);
        this.itemModels().withExistingParent(getItemName(trapdoor.get()), this.modLoc("block/" + getItemName(trapdoor.get()) + "_bottom"));
    }

    private void trapdoorCutout(RegistryObject<Block> trapdoor) {
        this.trapdoorBlockWithRenderType((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true, "cutout");
        this.itemModels().withExistingParent(getItemName(trapdoor.get()), this.modLoc("block/" + getItemName(trapdoor.get()) + "_bottom"));
    }

    private void door(RegistryObject<Block> door) {
        String name = getItemName(door.get());
        this.doorBlock((DoorBlock) door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"));
        this.generatedItem(door.get(), TextureFolder.ITEM);
    }

    private void doorCutout(RegistryObject<Block> door) {
        String name = getItemName(door.get());
        this.doorBlockWithRenderType((DoorBlock) door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"), "cutout");
        this.generatedItem(door.get(), TextureFolder.ITEM);
    }

    private void button(RegistryObject<Block> button, ResourceLocation texture) {
        this.buttonBlock((ButtonBlock) button.get(), texture);
        this.itemModels().buttonInventory(getItemName(button.get()), texture);
    }

    private void pressurePlate(RegistryObject<Block> pressurePlate, ResourceLocation texture) {
        this.pressurePlateBlock((PressurePlateBlock) pressurePlate.get(), texture);
        this.itemModel(pressurePlate);
    }

    private void leaves(RegistryObject<Block> leaves) {
        this.simpleBlock(leaves.get(), this.models().withExistingParent(getItemName(leaves.get()), "block/leaves").texture("all", this.blockTexture(leaves.get())));
        this.itemModel(leaves);
    }

    private void cubeAllBlockWithRenderType(RegistryObject<Block> block, String renderType) {
        this.simpleBlock(block.get(), models().getBuilder(name(block.get())).parent(new ModelFile.UncheckedModelFile(new ResourceLocation("block/cube_all"))).renderType(renderType).texture("all", blockTexture(block.get())));
        this.itemModel(block);
    }

    private void simpleCross(RegistryObject<Block> block) {
        this.simpleBlock(block.get(), this.models().cross(getItemName(block.get()), this.blockTexture(block.get())).renderType("cutout"));
    }

    private void simpleTintedCross(RegistryObject<Block> block) {
        this.simpleBlock(block.get(), this.models().withExistingParent(getItemName(block.get()), "block/tinted_cross").texture("cross", this.blockTexture(block.get())).renderType("cutout"));
        this.itemModel(block);
    }

    private void tallPlant(RegistryObject<Block> flower) {
        String name = getItemName(flower.get());
        Function<String, ModelFile> model = s -> this.models().cross(name + "_" + s, this.modLoc("block/" + name + "_" + s)).renderType("cutout");

        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc("block/" + name + "_top"));
        this.getVariantBuilder(flower.get()).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(model.apply("top"))).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(model.apply("bottom")));
    }

    private void pot(RegistryObject<Block> pot, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(getBlockName(pot.get()), "block/flower_pot_cross").texture("plant", texture).renderType("cutout");
        this.simpleBlock(pot.get(), model);
    }

    private void tintedPot(RegistryObject<Block> pot, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(getBlockName(pot.get()), "block/tinted_flower_pot_cross").texture("plant", texture).renderType("cutout");
        this.simpleBlock(pot.get(), model);
    }

    private void pottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pot) {
        this.pot(pot, this.blockTexture(plant.get()));
        this.simpleCross(plant);
        this.generatedItem(plant.get(), TextureFolder.BLOCK);
    }

    private void tintedPottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pot) {
        this.tintedPot(pot, this.blockTexture(plant.get()));
        this.simpleTintedCross(plant);
        this.generatedItem(plant.get(), TextureFolder.BLOCK);
    }

    // utils
    private static String getItemName(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem()).getPath();
    }

    private static String getBlockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private enum TextureFolder {
        ITEM, BLOCK;
        public String format(String itemName) {
            return this.name().toLowerCase() + '/' + itemName;
        }
    }
}
