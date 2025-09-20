package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import xyz.glowstonelabs.contentcraft.block.BlueBerryBushBlock;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;

/**
 * Responsible for generating blockstate and item models for ContentCraft mod.
 * This automates creation of JSON files that define how blocks and items look in-game.
 */
@SuppressWarnings("deprecation")
public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    /**
     * Generate block state models (how blocks are rendered in the world).
     * Uses built-in helper methods for common block types.
     */
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Xaenon blocks
        BlockStateModelGenerator.BlockTexturePool xaenonTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.XAENON_BLOCK);
        xaenonTemplate.slab(ModBlocks.XAENON_SLAB);
        xaenonTemplate.stairs(ModBlocks.XAENON_STAIRS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_XAENON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.XAENON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARTIFICIAL_DIAMOND_BLOCK);

        // Maple wood blocks
        BlockStateModelGenerator.BlockTexturePool mapleTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);
        blockStateModelGenerator.registerLog(ModBlocks.MAPLE_LOG)
                .log(ModBlocks.MAPLE_LOG)
                .wood(ModBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAPLE_LOG)
                .log(ModBlocks.STRIPPED_MAPLE_LOG)
                .wood(ModBlocks.STRIPPED_MAPLE_WOOD);
        blockStateModelGenerator.registerSingleton(ModBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        mapleTemplate.stairs(ModBlocks.MAPLE_STAIRS);
        mapleTemplate.slab(ModBlocks.MAPLE_SLAB);
        mapleTemplate.button(ModBlocks.MAPLE_BUTTON);
        mapleTemplate.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);
        mapleTemplate.fence(ModBlocks.MAPLE_FENCE);
        mapleTemplate.fenceGate(ModBlocks.MAPLE_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.MAPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAPLE_TRAPDOOR);

        // Dirt and sand blocks
        BlockStateModelGenerator.BlockTexturePool dirtTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.DIRT);
        BlockStateModelGenerator.BlockTexturePool sandTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.SAND);
        dirtTemplate.slab(ModBlocks.DIRT_SLAB);
        dirtTemplate.stairs(ModBlocks.DIRT_STAIRS);
        sandTemplate.slab(ModBlocks.SAND_SLAB);
        sandTemplate.stairs(ModBlocks.SAND_STAIRS);

        // Andesite variant blocks
        BlockStateModelGenerator.BlockTexturePool andesiteTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ANDESITE_BRICKS);
        andesiteTemplate.slab(ModBlocks.ANDESITE_BRICK_SLAB);
        andesiteTemplate.stairs(ModBlocks.ANDESITE_BRICK_STAIRS);
        andesiteTemplate.wall(ModBlocks.ANDESITE_BRICK_WALL);

        // Granite variant blocks
        BlockStateModelGenerator.BlockTexturePool graniteTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRANITE_BRICKS);
        graniteTemplate.slab(ModBlocks.GRANITE_BRICK_SLAB);
        graniteTemplate.stairs(ModBlocks.GRANITE_BRICK_STAIRS);
        graniteTemplate.wall(ModBlocks.GRANITE_BRICK_WALL);

        // Diorite variant blocks
        BlockStateModelGenerator.BlockTexturePool dioriteTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DIORITE_BRICKS);
        dioriteTemplate.slab(ModBlocks.DIORITE_BRICK_SLAB);
        dioriteTemplate.stairs(ModBlocks.DIORITE_BRICK_STAIRS);
        dioriteTemplate.wall(ModBlocks.DIORITE_BRICK_WALL);

        // Calcite variant blocks
        BlockStateModelGenerator.BlockTexturePool calciteTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.CALCITE);
        BlockStateModelGenerator.BlockTexturePool calciteBricksTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CALCITE_BRICKS);
        calciteTemplate.slab(ModBlocks.CALCITE_SLAB);
        calciteTemplate.stairs(ModBlocks.CALCITE_STAIRS);
        calciteTemplate.wall(ModBlocks.CALCITE_WALL);
        calciteBricksTemplate.slab(ModBlocks.CALCITE_BRICK_SLAB);
        calciteBricksTemplate.stairs(ModBlocks.CALCITE_BRICK_STAIRS);
        calciteBricksTemplate.wall(ModBlocks.CALCITE_BRICK_WALL);

        // Dripstone variant blocks
        BlockStateModelGenerator.BlockTexturePool dripstoneBricksTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DRIPSTONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool dripstoneTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.DRIPSTONE_BLOCK);
        dripstoneTemplate.slab(ModBlocks.DRIPSTONE_SLAB);
        dripstoneTemplate.stairs(ModBlocks.DRIPSTONE_STAIRS);
        dripstoneTemplate.wall(ModBlocks.DRIPSTONE_WALL);
        dripstoneBricksTemplate.slab(ModBlocks.DRIPSTONE_BRICK_SLAB);
        dripstoneBricksTemplate.stairs(ModBlocks.DRIPSTONE_BRICK_STAIRS);
        dripstoneBricksTemplate.wall(ModBlocks.DRIPSTONE_BRICK_WALL);

        // Blue nether brick variants
        BlockStateModelGenerator.BlockTexturePool blueNetherBricksTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLUE_NETHER_BRICKS);
        blueNetherBricksTemplate.stairs(ModBlocks.BLUE_NETHER_BRICK_STAIRS);
        blueNetherBricksTemplate.slab(ModBlocks.BLUE_NETHER_BRICK_SLAB);
        blueNetherBricksTemplate.wall(ModBlocks.BLUE_NETHER_BRICK_WALL);

        // Special blocks (blueberry bush)
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(
                ModBlocks.BLUEBERRY_BUSH,
                BlockStateModelGenerator.TintType.NOT_TINTED,
                BlueBerryBushBlock.AGE,
                0, 1, 2, 3
        );
    }

    /**
     * Generate item models (how items appear in inventory and when held).
     * Uses built-in model types for generated textures and handheld items.
     */
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Materials and resources
        itemModelGenerator.register(ModItems.XAENON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_XAENON, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARTIFICIAL_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.OAK_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIRCH_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPRUCE_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_OAK_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACACIA_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.JUNGLE_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANGROVE_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHERRY_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARPED_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_BARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAPLE_BARK, Models.GENERATED);

        // Tools and weapons
        itemModelGenerator.register(ModItems.XAENON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.XAENON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.XAENON_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.XAENON_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.XAENON_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARTIFICIAL_DIAMOND_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARTIFICIAL_DIAMOND_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARTIFICIAL_DIAMOND_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARTIFICIAL_DIAMOND_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARTIFICIAL_DIAMOND_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TROWEL, Models.GENERATED);

        // Armor sets
        itemModelGenerator.registerArmor((ArmorItem) ModItems.XAENON_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.XAENON_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.XAENON_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.XAENON_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARTIFICIAL_DIAMOND_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARTIFICIAL_DIAMOND_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARTIFICIAL_DIAMOND_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARTIFICIAL_DIAMOND_BOOTS);

        // Miscellaneous items
        itemModelGenerator.register(ModItems.POISONOUS_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOILED_EGG, Models.GENERATED);
    }
}