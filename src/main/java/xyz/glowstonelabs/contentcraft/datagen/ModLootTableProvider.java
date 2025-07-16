package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;

import java.util.concurrent.CompletableFuture;

/**
 * This class generates loot tables for blocks in the ContentCraft mod.
 * It determines what items drop when blocks are broken, including support for things like silk touch and fortune.
 */
public class ModLootTableProvider extends FabricBlockLootTableProvider {

    /**
     * Constructor to link this provider with the data generator system.
     *
     * @param dataOutput       Output location for generated files.
     * @param registryLookup   Provides access to necessary game registries.
     */
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    /**
     * Called automatically during data generation.
     * This is where you define which blocks drop what items.
     */
    @Override
    public void generate() {
        // Simple block drops (drops itself when broken)
        addDrop(ModBlocks.XAENON_BLOCK);
        addDrop(ModBlocks.ARTIFICIAL_DIAMOND_BLOCK);
        addDrop(ModBlocks.RAW_XAENON_BLOCK);
        addDrop(ModBlocks.MAPLE_LOG);
        addDrop(ModBlocks.MAPLE_WOOD);
        addDrop(ModBlocks.STRIPPED_MAPLE_LOG);
        addDrop(ModBlocks.STRIPPED_MAPLE_WOOD);
        addDrop(ModBlocks.MAPLE_PLANKS);
        addDrop(ModBlocks.MAPLE_SAPLING);

        // Ore block that drops raw Xaenon when not silk-touched
        addDrop(ModBlocks.XAENON_ORE, oreDrops(ModBlocks.XAENON_ORE, ModItems.RAW_XAENON));

        // Leaves drop saplings with a low chance (e.g., 6.25%)
        addDrop(ModBlocks.MAPLE_LEAVES, leavesDrops(ModBlocks.MAPLE_LEAVES, ModBlocks.MAPLE_SAPLING, 0.0625f));
    }

    /**
     * Utility method to create a loot table that supports:
     * - Silk Touch (drops the block itself if Silk Touch is used)
     * - Fortune (increases drops if the Fortune enchantment is applied)
     * - Explosion decay (if the block is broken by an explosion)
     *
     * @param drop       The block this loot table is for
     * @param item       The item it drops (e.g. raw ore)
     * @param minDrops   Minimum number of items dropped
     * @param maxDrops   Maximum number of items dropped
     * @return A complete loot table builder with bonus logic
     */
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        // Get enchantment registry (used for Fortune)
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        // Build a loot table that:
        // - Applies explosion decay
        // - Applies set count (random between min and max)
        // - Applies Fortune bonus
        // - Falls back to Silk Touch behavior if needed
        return this.dropsWithSilkTouch(drop,
                this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder<?>) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                        ).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
