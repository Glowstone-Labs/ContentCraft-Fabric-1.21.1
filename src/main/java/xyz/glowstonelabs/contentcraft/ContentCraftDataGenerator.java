package xyz.glowstonelabs.contentcraft;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import xyz.glowstonelabs.contentcraft.datagen.*;

/**
 * Registers all data generation providers for the ContentCraft mod.
 * This is used to generate JSON files such as block tags, item models, recipes, loot tables, etc.
 */
public class ContentCraftDataGenerator implements DataGeneratorEntrypoint {

	/**
	 * Called when running the data generator (usually via a Gradle task like `runDatagen`).
	 * This method registers all the data providers your mod needs.
	 */
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		// Create a new data pack for ContentCraft
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		// Register a provider to generate block tags (e.g., "minecraft:mineable/pickaxe")
		pack.addProvider(ModBlockTagProvider::new);

		// Register a provider to generate item tags (e.g., "minecraft:tools")
		pack.addProvider(ModItemTagProvider::new);

		// Register a provider to generate loot tables (e.g., what items drop from blocks/mobs)
		pack.addProvider(ModLootTableProvider::new);

		// Register a provider to generate block and item models (for rendering)
		pack.addProvider(ModModelProvider::new);

		// Register a provider to generate crafting and smelting recipes
		pack.addProvider(ModRecipeProvider::new);
	}
}
