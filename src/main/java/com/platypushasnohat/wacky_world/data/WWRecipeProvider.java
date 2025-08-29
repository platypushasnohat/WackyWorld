package com.platypushasnohat.wacky_world.data;

import com.platypushasnohat.wacky_world.WackyWorld;
import com.platypushasnohat.wacky_world.registry.tags.WWItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static com.platypushasnohat.wacky_world.registry.WWBlockFamilies.*;
import static com.platypushasnohat.wacky_world.registry.WWBlocks.*;
import static net.minecraft.data.recipes.RecipeCategory.*;

public class WWRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public WWRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, MYORITE.get(), 2).define('#', Blocks.DIORITE).define('X', Tags.Items.MUSHROOMS).pattern("X#").pattern("#X").unlockedBy("has_mushrooms", has(Tags.Items.MUSHROOMS)).save(consumer);
        generateRecipes(consumer, MYORITE_FAMILY);
        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_SLAB.get(), MYORITE.get(), 2);
        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_STAIRS.get(), MYORITE.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_WALL.get(), MYORITE.get());

        stonecutterRecipe(consumer, BUILDING_BLOCKS, POLISHED_MYORITE.get(), MYORITE.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, POLISHED_MYORITE_SLAB.get(), MYORITE.get(), 2);
        stonecutterRecipe(consumer, BUILDING_BLOCKS, POLISHED_MYORITE_STAIRS.get(), MYORITE.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, POLISHED_MYORITE_WALL.get(), MYORITE.get());

        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_BRICKS.get(), MYORITE.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_BRICK_SLAB.get(), MYORITE.get(), 2);
        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_BRICK_STAIRS.get(), MYORITE.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_BRICK_WALL.get(), MYORITE.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, CHISELED_MYORITE_BRICKS.get(), MYORITE.get());

        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, POLISHED_MYORITE.get(), 4).define('#', MYORITE.get()).pattern("##").pattern("##").unlockedBy("has_myorite", has(WWItemTags.MYORITE)).save(consumer);
        generateRecipes(consumer, POLISHED_MYORITE_FAMILY);
        stonecutterRecipe(consumer, BUILDING_BLOCKS, POLISHED_MYORITE_SLAB.get(), POLISHED_MYORITE.get(), 2);
        stonecutterRecipe(consumer, BUILDING_BLOCKS, POLISHED_MYORITE_STAIRS.get(), POLISHED_MYORITE.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, POLISHED_MYORITE_WALL.get(), POLISHED_MYORITE.get());

        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, MYORITE_BRICKS.get(), 4).define('#', POLISHED_MYORITE.get()).pattern("##").pattern("##").unlockedBy("has_myorite", has(WWItemTags.MYORITE)).save(consumer);
        generateRecipes(consumer, MYORITE_BRICKS_FAMILY);
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, CHISELED_MYORITE_BRICKS.get(), 1).define('#', MYORITE_BRICK_SLAB.get()).pattern("#").pattern("#").unlockedBy("has_myorite", has(WWItemTags.MYORITE)).save(consumer);

        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_BRICK_SLAB.get(), MYORITE_BRICKS.get(), 2);
        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_BRICK_STAIRS.get(), MYORITE_BRICKS.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, MYORITE_BRICK_WALL.get(), MYORITE_BRICKS.get());
        stonecutterRecipe(consumer, BUILDING_BLOCKS, CHISELED_MYORITE_BRICKS.get(), MYORITE_BRICKS.get());
    }

    public void storageRecipes(Consumer<FinishedRecipe> consumer, RecipeCategory itemCategory, ItemLike item, RecipeCategory storageCategory, ItemLike storage, String storageName, String storageGroup, String itemName, String itemGroup) {
        nineBlockStorageRecipes(consumer, itemCategory, item, storageCategory, storage, WackyWorld.MOD_ID + ":" + storageName, storageGroup, WackyWorld.MOD_ID + ":" + itemName, itemGroup);
    }
    public void storageRecipes(Consumer<FinishedRecipe> consumer, RecipeCategory itemCategory, ItemLike item, RecipeCategory storageCategory, ItemLike storage) {
        storageRecipes(consumer, itemCategory, item, storageCategory, storage, getSimpleRecipeName(storage), null, getSimpleRecipeName(item), null);
    }

    public void stonecutterRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike output, ItemLike input) {
        this.stonecutterRecipe(consumer, category, output, input, 1);
    }
    public void stonecutterRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike output, ItemLike input, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, output, count).unlockedBy(getHasName(input), has(input)).save(consumer, this.getModConversionRecipeName(output, input) + "_stonecutting");
    }

    public ResourceLocation getModConversionRecipeName(ItemLike output, ItemLike input) {
        return new ResourceLocation(WackyWorld.MOD_ID, getConversionRecipeName(output, input));
    }

    private void wrap(RecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conditions) {
        wrap(builder, WackyWorld.MOD_ID, name, consumer, conditions);
    }

    private void wrap(RecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conditions) {
        ResourceLocation loc = new ResourceLocation(modid, name);
        ConditionalRecipe.Builder cond;
        if (conditions.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conditions));
        } else if (conditions.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conditions[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.save(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0]).generateAdvancement().build(consumer, loc);
    }
}
