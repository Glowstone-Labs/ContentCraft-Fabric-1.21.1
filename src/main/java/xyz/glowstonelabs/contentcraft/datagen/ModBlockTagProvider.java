package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;

import java.util.concurrent.CompletableFuture;

/**
 * Generates block tags for ContentCraft blocks.
 * These tags define block properties like mineability, tool requirements, and block categories.
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Mining tool tags
        registerToolRequiredTags();

        // Block category tags
        registerBlockCategoryTags();

        // Wood and plant tags
        registerWoodAndPlantTags();
    }

    private void registerToolRequiredTags() {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.XAENON_BLOCK)
                .add(ModBlocks.XAENON_STAIRS)
                .add(ModBlocks.XAENON_SLAB)
                .add(ModBlocks.RAW_XAENON_BLOCK)
                .add(ModBlocks.XAENON_ORE)

                .add(ModBlocks.ANDESITE_BRICKS)
                .add(ModBlocks.ANDESITE_BRICK_SLAB)
                .add(ModBlocks.ANDESITE_BRICK_STAIRS)
                .add(ModBlocks.ANDESITE_BRICK_WALL)

                .add(ModBlocks.GRANITE_BRICKS)
                .add(ModBlocks.GRANITE_BRICK_SLAB)
                .add(ModBlocks.GRANITE_BRICK_STAIRS)
                .add(ModBlocks.GRANITE_BRICK_WALL)

                .add(ModBlocks.DIORITE_BRICKS)
                .add(ModBlocks.DIORITE_BRICK_SLAB)
                .add(ModBlocks.DIORITE_BRICK_STAIRS)
                .add(ModBlocks.DIORITE_BRICK_WALL)

                .add(ModBlocks.CALCITE_SLAB)
                .add(ModBlocks.CALCITE_STAIRS)
                .add(ModBlocks.CALCITE_WALL)

                .add(ModBlocks.DRIPSTONE_SLAB)
                .add(ModBlocks.DRIPSTONE_STAIRS)
                .add(ModBlocks.DRIPSTONE_WALL)

                .add(ModBlocks.CALCITE_BRICKS)
                .add(ModBlocks.CALCITE_BRICK_SLAB)
                .add(ModBlocks.CALCITE_BRICK_STAIRS)
                .add(ModBlocks.CALCITE_BRICK_WALL)

                .add(ModBlocks.DRIPSTONE_BRICKS)
                .add(ModBlocks.DRIPSTONE_BRICK_SLAB)
                .add(ModBlocks.DRIPSTONE_BRICK_STAIRS)
                .add(ModBlocks.DRIPSTONE_BRICK_WALL)
        ;

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.DIRT_STAIRS)
                .add(ModBlocks.DIRT_SLAB)
                .add(ModBlocks.SAND_SLAB)
                .add(ModBlocks.SAND_STAIRS)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD)
                .add(ModBlocks.MAPLE_SLAB)
                .add(ModBlocks.MAPLE_STAIRS)
        ;
    }

    private void registerBlockCategoryTags() {
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.DIRT_SLAB)
                .add(ModBlocks.MAPLE_SLAB)
                .add(ModBlocks.SAND_SLAB)
                .add(ModBlocks.XAENON_SLAB)
                .add(ModBlocks.ANDESITE_BRICK_SLAB)
                .add(ModBlocks.GRANITE_BRICK_SLAB)
                .add(ModBlocks.DIORITE_BRICK_SLAB)
                .add(ModBlocks.CALCITE_SLAB)
                .add(ModBlocks.CALCITE_BRICK_SLAB)
                .add(ModBlocks.DRIPSTONE_BRICK_SLAB)
        ;

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.MAPLE_STAIRS)
                .add(ModBlocks.DIRT_STAIRS)
                .add(ModBlocks.SAND_STAIRS)
                .add(ModBlocks.XAENON_STAIRS)
                .add(ModBlocks.ANDESITE_BRICK_STAIRS)
                .add(ModBlocks.GRANITE_BRICK_STAIRS)
                .add(ModBlocks.DIORITE_BRICK_STAIRS)
                .add(ModBlocks.CALCITE_STAIRS)
                .add(ModBlocks.CALCITE_BRICK_STAIRS)
                .add(ModBlocks.DRIPSTONE_BRICK_STAIRS)
        ;

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ANDESITE_BRICK_WALL)
                .add(ModBlocks.GRANITE_BRICK_WALL)
                .add(ModBlocks.DIORITE_BRICK_WALL)
                .add(ModBlocks.CALCITE_WALL)
                .add(ModBlocks.CALCITE_BRICK_WALL)
                .add(ModBlocks.DRIPSTONE_BRICK_WALL)
                .add(ModBlocks.BLUE_NETHER_BRICK_WALL)
        ;

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.MAPLE_DOOR)
        ;
    }

    private void registerWoodAndPlantTags() {
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD);
    }
}