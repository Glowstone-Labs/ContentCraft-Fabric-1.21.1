package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;
import xyz.glowstonelabs.contentcraft.util.ModTags;

import java.util.concurrent.CompletableFuture;

/**
 * Generates item tags for ContentCraft items.
 * These tags are used by Minecraft to determine tool classification, burnable logs, etc.
 * The resulting data is generated as JSON under `data/minecraft/tags/items/` or `data/yourmodid/tags/items/`.
 */
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    /**
     * Constructor for the item tag provider.
     *
     * @param output             Output directory for the generated files.
     * @param completableFuture  A future providing access to the registry lookup system.
     */
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    /**
     * Called automatically during data generation. This is where you define what items go into which tags.
     */
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        // ===============
        // Tool Tags
        // ===============

        // Add Xaenon tools to vanilla tool tags so they behave like standard tools
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.XAENON_SWORD)
                .add(ModItems.ARTIFICIAL_DIAMOND_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.XAENON_PICKAXE)
                .add(ModItems.ARTIFICIAL_DIAMOND_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.XAENON_SHOVEL)
                .add(ModItems.ARTIFICIAL_DIAMOND_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.XAENON_AXE)
                .add(ModItems.ARTIFICIAL_DIAMOND_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.XAENON_HOE)
                .add(ModItems.ARTIFICIAL_DIAMOND_HOE);


        getOrCreateTagBuilder(ModTags.Items.WOOD_BARKS)
                .add(ModItems.OAK_BARK)
                .add(ModItems.BIRCH_BARK)
                .add(ModItems.SPRUCE_BARK)
                .add(ModItems.DARK_OAK_BARK)
                .add(ModItems.ACACIA_BARK)
                .add(ModItems.JUNGLE_BARK)
                .add(ModItems.MANGROVE_BARK)
                .add(ModItems.CHERRY_BARK)
                .add(ModItems.WARPED_BARK)
                .add(ModItems.CRIMSON_BARK)
                .add(ModItems.MAPLE_BARK);
;

        // ===============
        // Armor Tags
        // ===============

        // Allows Xaenon armor to be customized with smithing templates (armor trims)
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.XAENON_HELMET)
                .add(ModItems.XAENON_CHESTPLATE)
                .add(ModItems.XAENON_LEGGINGS)
                .add(ModItems.XAENON_BOOTS);

        // Allows Artificial Diamond armor to be customized with smithing templates (armor trims)
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ARTIFICIAL_DIAMOND_HELMET)
                .add(ModItems.ARTIFICIAL_DIAMOND_CHESTPLATE)
                .add(ModItems.ARTIFICIAL_DIAMOND_LEGGINGS)
                .add(ModItems.ARTIFICIAL_DIAMOND_BOOTS);

        // ===============
        // Block-Derived Item Tags
        // ===============

        // Add log-type blocks as items to the "logs_that_burn" tag so they work as fuel and fire sources
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.asItem())
                .add(ModBlocks.MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.asItem());

        // plank.
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.MAPLE_PLANKS.asItem());
    }
}
