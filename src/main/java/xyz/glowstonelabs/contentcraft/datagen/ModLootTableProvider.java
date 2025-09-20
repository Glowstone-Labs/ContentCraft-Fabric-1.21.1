package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import xyz.glowstonelabs.contentcraft.block.BlueBerryBushBlock;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;

import java.util.concurrent.CompletableFuture;

/**
 * Generates loot tables for ContentCraft blocks.
 * Defines what items drop when blocks are broken.
 */
public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> enchantmentRegistry =
                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);


        addDrop(ModBlocks.XAENON_BLOCK);
        addDrop(ModBlocks.XAENON_STAIRS);
        addDrop(ModBlocks.XAENON_SLAB);
        addDrop(ModBlocks.RAW_XAENON_BLOCK);
        addDrop(ModBlocks.XAENON_ORE, oreDrops(ModBlocks.XAENON_ORE, ModItems.RAW_XAENON));

        addDrop(ModBlocks.MAPLE_LOG);
        addDrop(ModBlocks.MAPLE_WOOD);
        addDrop(ModBlocks.STRIPPED_MAPLE_LOG);
        addDrop(ModBlocks.STRIPPED_MAPLE_WOOD);
        addDrop(ModBlocks.MAPLE_PLANKS);
        addDrop(ModBlocks.MAPLE_SAPLING);
        addDrop(ModBlocks.MAPLE_LEAVES,
                leavesDrops(ModBlocks.MAPLE_LEAVES, ModBlocks.MAPLE_SAPLING, 0.0625f));
        addDrop(ModBlocks.MAPLE_SLAB, slabDrops(ModBlocks.MAPLE_SLAB));
        addDrop(ModBlocks.MAPLE_STAIRS);
        addDrop(ModBlocks.MAPLE_FENCE);
        addDrop(ModBlocks.MAPLE_FENCE_GATE);
        addDrop(ModBlocks.MAPLE_BUTTON);
        addDrop(ModBlocks.MAPLE_PRESSURE_PLATE);
        addDrop(ModBlocks.MAPLE_TRAPDOOR);
        addDrop(ModBlocks.MAPLE_DOOR, doorDrops(ModBlocks.MAPLE_DOOR));

        addDrop(ModBlocks.DIRT_SLAB);
        addDrop(ModBlocks.DIRT_STAIRS);
        addDrop(ModBlocks.SAND_SLAB);
        addDrop(ModBlocks.SAND_STAIRS);

        addDrop(ModBlocks.ANDESITE_BRICKS);
        addDrop(ModBlocks.ANDESITE_BRICK_SLAB);
        addDrop(ModBlocks.ANDESITE_BRICK_STAIRS);
        addDrop(ModBlocks.ANDESITE_BRICK_WALL);

        addDrop(ModBlocks.GRANITE_BRICKS);
        addDrop(ModBlocks.GRANITE_BRICK_SLAB);
        addDrop(ModBlocks.GRANITE_BRICK_STAIRS);
        addDrop(ModBlocks.GRANITE_BRICK_WALL);

        addDrop(ModBlocks.DIORITE_BRICKS);
        addDrop(ModBlocks.DIORITE_BRICK_SLAB);
        addDrop(ModBlocks.DIORITE_BRICK_STAIRS);
        addDrop(ModBlocks.DIORITE_BRICK_WALL);

        addDrop(ModBlocks.CALCITE_SLAB);
        addDrop(ModBlocks.CALCITE_STAIRS);
        addDrop(ModBlocks.CALCITE_WALL);
        addDrop(ModBlocks.CALCITE_BRICKS);
        addDrop(ModBlocks.CALCITE_BRICK_SLAB);
        addDrop(ModBlocks.CALCITE_BRICK_STAIRS);
        addDrop(ModBlocks.CALCITE_BRICK_WALL);

        addDrop(ModBlocks.DRIPSTONE_SLAB);
        addDrop(ModBlocks.DRIPSTONE_STAIRS);
        addDrop(ModBlocks.DRIPSTONE_WALL);
        addDrop(ModBlocks.DRIPSTONE_BRICKS);
        addDrop(ModBlocks.DRIPSTONE_BRICK_SLAB);
        addDrop(ModBlocks.DRIPSTONE_BRICK_STAIRS);
        addDrop(ModBlocks.DRIPSTONE_BRICK_WALL);

        addDrop(ModBlocks.BLUE_NETHER_BRICKS);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        addDrop(ModBlocks.BLUE_NETHER_BRICK_SLAB, slabDrops(ModBlocks.BLUE_NETHER_BRICK_SLAB));
        addDrop(ModBlocks.BLUE_NETHER_BRICK_WALL);

        addDrop(ModBlocks.BLUEBERRY_BUSH, block -> createBlueberryBushDrops(block, enchantmentRegistry));
    }

    private LootTable.Builder createBlueberryBushDrops(Block block, RegistryWrapper.Impl<Enchantment> enchantmentRegistry) {
        return applyExplosionDecay(block, LootTable.builder()
                .pool(createBerryPool(3, 2.0f, 3.0f, enchantmentRegistry))
                .pool(createBerryPool(2, 1.0f, 2.0f, enchantmentRegistry)));
    }

    private LootPool.Builder createBerryPool(int age, float minCount, float maxCount,
                                             RegistryWrapper.Impl<Enchantment> enchantmentRegistry) {
        return LootPool.builder()
                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH)
                        .properties(StatePredicate.Builder.create()
                                .exactMatch(BlueBerryBushBlock.AGE, age)))
                .with(ItemEntry.builder(ModItems.BLUE_BERRIES))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount)))
                .apply(ApplyBonusLootFunction.uniformBonusCount(enchantmentRegistry.getOrThrow(Enchantments.FORTUNE)));
    }
}