package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Xaenon recipes
        List<ItemConvertible> smeltables = List.of(
                (ItemConvertible) ModItems.RAW_XAENON,
                (ItemConvertible) ModBlocks.XAENON_ORE
        );
        offerSmelting(exporter, smeltables, RecipeCategory.MISC, ModItems.XAENON_INGOT, 0.25f, 200, "xaenon");
        offerBlasting(exporter, smeltables, RecipeCategory.MISC, ModItems.XAENON_INGOT, 0.25f, 100, "xaenon");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.XAENON_INGOT, RecipeCategory.DECORATIONS, ModBlocks.XAENON_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_XAENON_BLOCK)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModItems.RAW_XAENON)
                .criterion("has_raw_xaenon", conditionsFromItem(ModItems.RAW_XAENON))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_XAENON, 9)
                .input(ModBlocks.RAW_XAENON_BLOCK)
                .criterion("has_raw_xaenon_block", conditionsFromItem(ModBlocks.RAW_XAENON_BLOCK))
                .offerTo(exporter);

        slabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.XAENON_SLAB, ModBlocks.XAENON_BLOCK);
        stairsRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.XAENON_STAIRS, ModBlocks.XAENON_BLOCK);

        // Dirt recipes
        slabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIRT_SLAB, Blocks.DIRT);
        stairsRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIRT_STAIRS, Blocks.DIRT);

        // Sand recipes
        slabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAND_SLAB, Blocks.SAND);
        stairsRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAND_STAIRS, Blocks.SAND);

        // Andesite recipes
        block2x2Recipe(exporter, RecipeCategory.MISC, ModBlocks.ANDESITE_BRICKS, Blocks.ANDESITE);
        slabRecipe(exporter, RecipeCategory.MISC, ModBlocks.ANDESITE_BRICK_SLAB, ModBlocks.ANDESITE_BRICKS);
        stairsRecipe(exporter, RecipeCategory.MISC, ModBlocks.ANDESITE_BRICK_STAIRS, ModBlocks.ANDESITE_BRICKS);
        wallRecipe(exporter, RecipeCategory.MISC, ModBlocks.ANDESITE_BRICK_WALL, ModBlocks.ANDESITE_BRICKS);
        reversibleBrickRecipe(exporter, RecipeCategory.MISC, ModBlocks.ANDESITE_BRICKS, Blocks.ANDESITE);

        // Granite recipes
        block2x2Recipe(exporter, RecipeCategory.MISC, ModBlocks.GRANITE_BRICKS, Blocks.GRANITE);
        slabRecipe(exporter, RecipeCategory.MISC, ModBlocks.GRANITE_BRICK_SLAB, ModBlocks.GRANITE_BRICKS);
        stairsRecipe(exporter, RecipeCategory.MISC, ModBlocks.GRANITE_BRICK_STAIRS, ModBlocks.GRANITE_BRICKS);
        wallRecipe(exporter, RecipeCategory.MISC, ModBlocks.GRANITE_BRICK_WALL, ModBlocks.GRANITE_BRICKS);
        reversibleBrickRecipe(exporter, RecipeCategory.MISC, ModBlocks.GRANITE_BRICKS, Blocks.GRANITE);

        // Diorite recipes
        block2x2Recipe(exporter, RecipeCategory.MISC, ModBlocks.DIORITE_BRICKS, Blocks.DIORITE);
        slabRecipe(exporter, RecipeCategory.MISC, ModBlocks.DIORITE_BRICK_SLAB, ModBlocks.DIORITE_BRICKS);
        stairsRecipe(exporter, RecipeCategory.MISC, ModBlocks.DIORITE_BRICK_STAIRS, ModBlocks.DIORITE_BRICKS);
        wallRecipe(exporter, RecipeCategory.MISC, ModBlocks.DIORITE_BRICK_WALL, ModBlocks.DIORITE_BRICKS);
        reversibleBrickRecipe(exporter, RecipeCategory.MISC, ModBlocks.DIORITE_BRICKS, Blocks.DIORITE);

        // Calcite recipes
        slabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB, Blocks.CALCITE);
        stairsRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_STAIRS, Blocks.CALCITE);
        wallRecipe(exporter, RecipeCategory.MISC, ModBlocks.CALCITE_WALL, Blocks.CALCITE);
        block2x2Recipe(exporter, RecipeCategory.MISC, ModBlocks.CALCITE_BRICKS, Blocks.CALCITE);
        slabRecipe(exporter, RecipeCategory.MISC, ModBlocks.CALCITE_BRICK_SLAB, ModBlocks.CALCITE_BRICKS);
        stairsRecipe(exporter, RecipeCategory.MISC, ModBlocks.CALCITE_BRICK_STAIRS, ModBlocks.CALCITE_BRICKS);
        wallRecipe(exporter, RecipeCategory.MISC, ModBlocks.CALCITE_BRICK_WALL, ModBlocks.CALCITE_BRICKS);
        reversibleBrickRecipe(exporter, RecipeCategory.MISC, ModBlocks.CALCITE_BRICKS, Blocks.CALCITE);

        // Dripstone recipes
        slabRecipe(exporter, RecipeCategory.MISC, ModBlocks.DRIPSTONE_SLAB, Blocks.DRIPSTONE_BLOCK);
        stairsRecipe(exporter, RecipeCategory.MISC, ModBlocks.DRIPSTONE_STAIRS, Blocks.DRIPSTONE_BLOCK);
        wallRecipe(exporter, RecipeCategory.MISC, ModBlocks.DRIPSTONE_WALL, Blocks.DRIPSTONE_BLOCK);
        block2x2Recipe(exporter, RecipeCategory.MISC, ModBlocks.DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK);
        slabRecipe(exporter, RecipeCategory.MISC, ModBlocks.DRIPSTONE_BRICK_SLAB, ModBlocks.DRIPSTONE_BRICKS);
        stairsRecipe(exporter, RecipeCategory.MISC, ModBlocks.DRIPSTONE_BRICK_STAIRS, ModBlocks.DRIPSTONE_BRICKS);
        wallRecipe(exporter, RecipeCategory.MISC, ModBlocks.DRIPSTONE_BRICK_WALL, ModBlocks.DRIPSTONE_BRICKS);
        reversibleBrickRecipe(exporter, RecipeCategory.MISC, ModBlocks.DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK);

        //Blue Nether Brick recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_NETHER_BRICKS)
                .pattern("LB")
                .pattern("BL")
                .input('L', Items.LAPIS_LAZULI)
                .input('B', Items.NETHER_BRICK)
                .criterion("has_lapis", conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion("has_nether_brick", conditionsFromItem(Items.NETHER_BRICK))
                .offerTo(exporter);

        slabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_NETHER_BRICK_SLAB, ModBlocks.BLUE_NETHER_BRICKS);
        stairsRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_NETHER_BRICK_STAIRS, ModBlocks.BLUE_NETHER_BRICKS);
        wallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_NETHER_BRICK_WALL, ModBlocks.BLUE_NETHER_BRICKS);


        // Tool recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TROWEL)
                .pattern("  I")
                .pattern(" S ")
                .pattern("S  ")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
    }

    /* ---------- HELPER METHODS ---------- */

    private void slabRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible result, ItemConvertible input) {
        char key = firstLetter(input);
        ShapedRecipeJsonBuilder.create(category, result, 3)
                .pattern("" + key + key + key)
                .input(key, input)
                .criterion("has_" + getName(input), conditionsFromItem(input))
                .offerTo(exporter);
        stonecuttingRecipe(exporter, category, result, input);
    }
    private void stairsRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible result, ItemConvertible input) {
        char key = firstLetter(input);
        ShapedRecipeJsonBuilder.create(category, result, 4)
                .pattern("" + key + "  ")
                .pattern("" + key + key + " ")
                .pattern("" + key + key + key)
                .input(key, input)
                .criterion("has_" + getName(input), conditionsFromItem(input))
                .offerTo(exporter);
        stonecuttingRecipe(exporter, category, result, input);
    }

    private void wallRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible result, ItemConvertible input) {
        char key = firstLetter(input);
        ShapedRecipeJsonBuilder.create(category, result)
                .pattern("" + key + key + key)
                .pattern("" + key + key + key)
                .input(key, input)
                .criterion("has_" + getName(input), conditionsFromItem(input))
                .offerTo(exporter);
        stonecuttingRecipe(exporter, category, result, input);
    }

    private void block2x2Recipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible result, ItemConvertible input) {
        char key = firstLetter(input);
        ShapedRecipeJsonBuilder.create(category, result)
                .pattern("" + key + key)
                .pattern("" + key + key)
                .input(key, input)
                .criterion("has_" + getName(input), conditionsFromItem(input))
                .offerTo(exporter);
        stonecuttingRecipe(exporter, category, result, input);
    }

    private void stonecuttingRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible result, ItemConvertible input) {
        offerStonecuttingRecipe(exporter, category, result, input, 1);
    }

    private void reversibleBrickRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible brick, ItemConvertible original) {
        ShapelessRecipeJsonBuilder.create(category, original)
                .input(brick)
                .criterion("has_" + getName(brick), conditionsFromItem(brick))
                .offerTo(exporter);
    }

    private char firstLetter(ItemConvertible item) {
        return getName(item).charAt(0);
    }

    private String getName(ItemConvertible item) {
        return getItemId(item).getPath();
    }
}