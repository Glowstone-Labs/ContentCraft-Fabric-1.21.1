package xyz.glowstonelabs.contentcraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItemGroups;
import xyz.glowstonelabs.contentcraft.init.ModItems;
import xyz.glowstonelabs.contentcraft.util.ModLootTableModifiers;

public class ContentCraft implements ModInitializer {
	public static final String MOD_ID = "contentcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading ContentCraft's Content...");
		//------load Mod classes here!------

		ModBlocks.load(); LOGGER.info("Loading ContentCraft's ModBlocks...");
		ModItems.load(); LOGGER.info("Loading ContentCraft's ModItems...");
		ModItemGroups.load(); LOGGER.info("Loading ContentCraft's ModItemGroups (Creative Inventory Tabs)...");
		StrippableBlockRegistry.register(ModBlocks.MAPLE_LOG, ModBlocks.STRIPPED_MAPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks.MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_WOOD);

		// y tf do i have to add this, fabric is weird asf fr
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MAPLE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MAPLE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LEAVES, 30, 60);

		ModLootTableModifiers.modifyLootTables();


		//----------------------------------
		LOGGER.info("ContentCraft Loaded!");
		
	}
}