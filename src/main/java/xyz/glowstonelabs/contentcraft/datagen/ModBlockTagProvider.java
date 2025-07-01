package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.util.ModTags;

import java.util.concurrent.CompletableFuture;

/**
 * Generates block tags for ContentCraft blocks.
 * These tags are used for things like tool requirements, burnable logs, and more.
 * The output will be generated as JSON under `data/minecraft/tags/blocks/`.
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    /**
     * Constructor that connects the tag provider to the data generator system.
     *
     * @param output             Where the generated files will go.
     * @param registriesFuture   Future registry lookup for Minecraft objects like blocks.
     */
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    /**
     * Main configuration method to add your custom blocks to vanilla or custom tags.
     * Called automatically during data generation.
     */
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        // ============================
        // Pickaxe-Mineable Blocks
        // ============================
        // These blocks will require a pickaxe to break quickly and drop loot.
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.XAENON_BLOCK)
                .add(ModBlocks.RAW_XAENON_BLOCK)
                .add(ModBlocks.XAENON_ORE)
                .add(ModBlocks.ARTIFICIAL_DIAMOND_BLOCK);


        // ============================
        // Burnable Logs (Fuel & Campfire Use)
        // ============================
        // These blocks are treated as flammable logs by Minecraft (like oak logs).
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG)
                .add(ModBlocks.MAPLE_WOOD)
                .add(ModBlocks.STRIPPED_MAPLE_LOG)
                .add(ModBlocks.STRIPPED_MAPLE_WOOD);

        // ============================
        // Uncomment this block if using iron tool requirement
        // ============================
        // Blocks added to this tag will require at least an iron pickaxe to mine.
        // getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
        //         .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
    }
}
