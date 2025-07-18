package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;


/**
 * Responsible for generating blockstate and item models for ContentCraft mod.
 * This automates creation of JSON files that define how blocks and items look in-game.
 */
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


        // Create a reusable texture template for these blocks to simplify model registration
        BlockStateModelGenerator.BlockTexturePool mapleWoodTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);

        BlockStateModelGenerator.BlockTexturePool DirtTemplate =
                blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.DIRT);


        // Register simple cube blocks that use the same texture on all sides
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.XAENON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARTIFICIAL_DIAMOND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_XAENON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.XAENON_ORE);

        // Register logs with separate textures for log sides and top/bottom (log and wood variants)
        blockStateModelGenerator.registerLog(ModBlocks.MAPLE_LOG)
                .log(ModBlocks.MAPLE_LOG)
                .wood(ModBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAPLE_LOG)
                .log(ModBlocks.STRIPPED_MAPLE_LOG)
                .wood(ModBlocks.STRIPPED_MAPLE_WOOD);

        // Register leaves with the vanilla leaves model and tinting support
        blockStateModelGenerator.registerSingleton(ModBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);

        // Register saplings with cross-shaped model (no tinting)
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        // Register maple wood variants using the texture pool for stairs, slabs, buttons, etc.
        mapleWoodTemplate.stairs(ModBlocks.MAPLE_STAIRS);
        mapleWoodTemplate.slab(ModBlocks.MAPLE_SLAB);

        mapleWoodTemplate.button(ModBlocks.MAPLE_BUTTON);
        mapleWoodTemplate.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);

        mapleWoodTemplate.fence(ModBlocks.MAPLE_FENCE);
        mapleWoodTemplate.fenceGate(ModBlocks.MAPLE_FENCE_GATE);

        // Register door and trapdoor models with built-in helpers
        blockStateModelGenerator.registerDoor(ModBlocks.MAPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAPLE_TRAPDOOR);

        DirtTemplate.slab(ModBlocks.DIRT_SLAB);
        //Grass Slab defined manually cuz it uses multiple textures, i hate fucking with json GRRRR T_T ts pmo why do i do this to myself :(

    }

    /**
     * Generate item models (how items appear in inventory and when held).
     * Uses built-in model types for generated textures and handheld items.
     */
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        // Register ingots and raw materials with the "generated" model (flat 2D texture)
        itemModelGenerator.register(ModItems.XAENON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_XAENON, Models.GENERATED);

        itemModelGenerator.register(ModItems.ARTIFICIAL_DIAMOND, Models.GENERATED);

        // Register tools and weapons with the "handheld" model (rotated to look natural in hand)
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

        // Register armor items, which require special model handling
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.XAENON_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.XAENON_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.XAENON_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.XAENON_BOOTS));

        // Register armor items, which require special model handling
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARTIFICIAL_DIAMOND_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARTIFICIAL_DIAMOND_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARTIFICIAL_DIAMOND_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARTIFICIAL_DIAMOND_BOOTS));

        itemModelGenerator.register(ModItems.POISONOUS_CARROT, Models.GENERATED);

        itemModelGenerator.register(ModItems.TROWEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.BOILED_EGG, Models.GENERATED);
    }

}