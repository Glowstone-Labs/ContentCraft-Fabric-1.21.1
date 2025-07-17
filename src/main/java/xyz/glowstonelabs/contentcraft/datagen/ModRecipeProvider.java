package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;
import xyz.glowstonelabs.contentcraft.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generates crafting, smelting, blasting, and compacting recipes for ContentCraft mod.
 * Automatically creates the JSON recipe files that Minecraft reads to add crafting mechanics.
 */
public class ModRecipeProvider extends FabricRecipeProvider {

    /**
     * Constructor to connect this recipe provider with Fabric's data generator.
     *
     * @param output           Output location for generated JSON files.
     * @param registriesFuture Provides access to game registries.
     */
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    /**
     * This method is called during data generation to define all recipes.
     *
     * @param exporter Used to save generated recipes.
     */
    @Override
    public void generate(RecipeExporter exporter) {
        // List of items and blocks that can be smelted or blasted into Xaenon ingots
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_XAENON, ModBlocks.XAENON_ORE);

        // Smelting recipe: smelting raw xaenon or ore gives an ingot, 0.25 XP, 200 ticks cooking time
        offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.XAENON_INGOT, 0.25f, 200, "xaenon");

        // Blasting recipe: faster version of smelting (100 ticks), same results and XP
        offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.XAENON_INGOT, 0.25f, 100, "xaenon");

        // Compacting recipe: ingots <-> block (9 ingots make 1 block and vice versa)
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.XAENON_INGOT, RecipeCategory.DECORATIONS, ModBlocks.XAENON_BLOCK);

        // Shaped crafting recipe: 3x3 grid of raw xaenon items to make a raw xaenon block
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_XAENON_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_XAENON)
                .criterion(hasItem(ModItems.RAW_XAENON), conditionsFromItem(ModItems.RAW_XAENON))
                .offerTo(exporter);

        // Shapeless crafting recipe: breaking a raw xaenon block back into 9 raw xaenon items
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_XAENON, 9)
                .input(ModBlocks.RAW_XAENON_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_XAENON_BLOCK), conditionsFromItem(ModBlocks.RAW_XAENON_BLOCK))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIRT_SLAB, 3)
                .pattern("XXX")
                .input('X', Items.DIRT)
                .criterion(
                        "has_grass_block", // Unique ID for the condition
                        conditionsFromItem(Blocks.GRASS_BLOCK) // Player must have grass block
                )
                .offerTo(exporter);

        // Shaped crafting recipe: 3x3 grid of raw xaenon items to make a raw xaenon block
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TROWEL)
                .pattern("  I")
                .pattern(" S ")
                .pattern("S  ")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
    }
}