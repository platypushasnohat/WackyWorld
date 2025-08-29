package com.platypushasnohat.wacky_world.data;

import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;

import static com.platypushasnohat.wacky_world.registry.WWBlocks.*;

public class WWBlockLootTableProvider extends BlockLootSubProvider {

    private final Set<Block> knownBlocks = new HashSet<>();
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    public WWBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void add(Block pBlock, LootTable.Builder pBuilder) {
        super.add(pBlock, pBuilder);
        knownBlocks.add(pBlock);
    }

    @Override
    protected void generate() {
        dropSelf(CAVE_PATTY.get());
        dropSelf(CREAM_CAP.get());
        dropSelf(CHICKEN_OF_THE_CAVES.get());
        dropSelf(COPPER_ENOKI.get());
        dropSelf(RAINCAP.get());
        dropSelf(POWDER_GNOME.get());
        dropSelf(CAP_OF_EYE.get());
        dropSelf(PURPLE_KNOB.get());
        dropSelf(SLIPPERY_TOP.get());
        dropSelf(ORBSHROOM.get());
        dropSelf(QUEEN_IN_PURPLE.get());
        dropSelf(INK_CAP.get());
        dropSelf(PRINCESS_JELLY.get());
        dropSelf(POP_CAP.get());
        dropSelf(LIME_NUB.get());
        dropSelf(GREEN_FUNK.get());
        dropSelf(BLUE_TRUMPET.get());
        dropSelf(DEATH_CAP.get());

        createPotFlowerItemTable(POTTED_CAVE_PATTY.get(), CAVE_PATTY.get());
        createPotFlowerItemTable(POTTED_CREAM_CAP.get(), CREAM_CAP.get());
        createPotFlowerItemTable(POTTED_CHICKEN_OF_THE_CAVES.get(), CHICKEN_OF_THE_CAVES.get());
        createPotFlowerItemTable(POTTED_COPPER_ENOKI.get(), COPPER_ENOKI.get());
        createPotFlowerItemTable(POTTED_RAINCAP.get(), RAINCAP.get());
        createPotFlowerItemTable(POTTED_POWDER_GNOME.get(), POWDER_GNOME.get());
        createPotFlowerItemTable(POTTED_CAP_OF_EYE.get(), CAP_OF_EYE.get());
        createPotFlowerItemTable(POTTED_PURPLE_KNOB.get(), PURPLE_KNOB.get());
        createPotFlowerItemTable(POTTED_ORBSHROOM.get(), ORBSHROOM.get());
        createPotFlowerItemTable(POTTED_QUEEN_IN_PURPLE.get(), QUEEN_IN_PURPLE.get());
        createPotFlowerItemTable(POTTED_INK_CAP.get(), INK_CAP.get());
        createPotFlowerItemTable(POTTED_PRINCESS_JELLY.get(), PRINCESS_JELLY.get());
        createPotFlowerItemTable(POTTED_POP_CAP.get(), POP_CAP.get());
        createPotFlowerItemTable(POTTED_LIME_NUB.get(), LIME_NUB.get());
        createPotFlowerItemTable(POTTED_GREEN_FUNK.get(), GREEN_FUNK.get());
        createPotFlowerItemTable(POTTED_BLUE_TRUMPET.get(), BLUE_TRUMPET.get());
        createPotFlowerItemTable(POTTED_DEATH_CAP.get(), DEATH_CAP.get());
    }
    protected void createPotFlowerItemTable(Block flowerpotBlock, ItemLike pItem) {
        add(flowerpotBlock ,LootTable.lootTable()
                .withPool(this.applyExplosionCondition(Blocks.FLOWER_POT, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.FLOWER_POT))))
                .withPool(this.applyExplosionCondition(pItem, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(pItem)))));
    }


    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createMultipleDrops(Block pBlock, Item item1, Item item2) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .then(LootItem.lootTableItem(item2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createMultipleBlockDrops(Block pBlock, Block item1, Block item2) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                                LootItem.lootTableItem(item1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .then(LootItem.lootTableItem(item2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }
}
