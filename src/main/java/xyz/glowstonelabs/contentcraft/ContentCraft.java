package xyz.glowstonelabs.contentcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.glowstonelabs.contentcraft.data.ModStrippableBlocks;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItemGroups;
import xyz.glowstonelabs.contentcraft.init.ModItems;
import xyz.glowstonelabs.contentcraft.util.Configs.ModConfigs;

/**
 * Main class for the ContentCraft mod.
 * Implements ModInitializer, so Fabric calls onInitialize() on mod startup.
 * Responsible for loading and registering all mod content such as items, blocks, config, and behaviors.
 */
public class ContentCraft implements ModInitializer {

	/**
	 * The mod ID string used throughout the mod for namespacing resources.
	 */
	public static final String MOD_ID = "contentcraft";

	/**
	 * The mod logger instance for logging messages during initialization and runtime.
	 * Uses SLF4J LoggerFactory for structured logging.
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/**
	 * This method is called by Fabric once the mod is loaded on startup.
	 * It is the main initialization entry point.
	 */
	@Override
	public void onInitialize() {
		LOGGER.info("=== Starting ContentCraft mod initialization ===");

		ModItems.load();LOGGER.info("ModItems loaded successfully.");
		ModBlocks.load();LOGGER.info("ModBlocks loaded successfully.");
		ModItemGroups.load();LOGGER.info("ModItemGroups (Creative Inventory Tabs) loaded successfully.");
		ModConfigs.init();LOGGER.info("ModConfigs initialized.");

		// Register blocks that can be stripped with an axe: maple log and wood		StrippableBlockRegistry.register(ModBlocks.MAPLE_LOG, ModBlocks.STRIPPED_MAPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_WOOD);
		LOGGER.info("Strippable blocks registered: Maple log and wood.");

		FlammableBlockRegistry flammable = FlammableBlockRegistry.getDefaultInstance();

		ModStrippableBlocks.registerStrippables();

		// Logs and wood blocks have moderate flammability and burn duration
		flammable.add(ModBlocks.MAPLE_LOG, 5, 5);
		flammable.add(ModBlocks.MAPLE_WOOD, 5, 5);

		// Stripped variants also flammable
		flammable.add(ModBlocks.STRIPPED_MAPLE_LOG, 5, 5);
		flammable.add(ModBlocks.STRIPPED_MAPLE_WOOD, 5, 5);

		// Planks are easier to catch fire and burn longer
		flammable.add(ModBlocks.MAPLE_PLANKS, 5, 20);

		// Leaves are highly flammable and burn quickly
		flammable.add(ModBlocks.MAPLE_LEAVES, 30, 60);




		LOGGER.info("Flammable blocks registered with their burn properties.");

		LOGGER.info("=== ContentCraft mod initialization completed successfully! ===");
	}
}
