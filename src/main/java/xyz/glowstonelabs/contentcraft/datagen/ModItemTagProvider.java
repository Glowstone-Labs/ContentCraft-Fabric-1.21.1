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
 * The resulting data is generated under:
 * - `data/minecraft/tags/items/` for vanilla tags
 * - `data/contentcraft/tags/items/` for mod-specific tags
 */
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Tool tags
        registerToolTags();

        // Armor tags
        registerArmorTags();

        // Wood and plant tags
        registerWoodAndPlantTags();

        // Custom mod tags
        registerModTags();
    }

    private void registerToolTags() {
        // Tools
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
    }

    private void registerArmorTags() {
        // Armor trimmable tag
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.XAENON_HELMET)
                .add(ModItems.XAENON_CHESTPLATE)
                .add(ModItems.XAENON_LEGGINGS)
                .add(ModItems.XAENON_BOOTS)
                .add(ModItems.ARTIFICIAL_DIAMOND_HELMET)
                .add(ModItems.ARTIFICIAL_DIAMOND_CHESTPLATE)
                .add(ModItems.ARTIFICIAL_DIAMOND_LEGGINGS)
                .add(ModItems.ARTIFICIAL_DIAMOND_BOOTS);
    }

    private void registerWoodAndPlantTags() {
        // Burnable logs
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.asItem())
                .add(ModBlocks.MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.asItem());

        // Planks
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.MAPLE_PLANKS.asItem());

    }

    private void registerModTags() {
        // Custom bark items tag
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
    }
}