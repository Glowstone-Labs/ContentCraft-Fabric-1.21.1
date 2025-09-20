package xyz.glowstonelabs.contentcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.glowstonelabs.contentcraft.init.*;
import xyz.glowstonelabs.contentcraft.util.ModLootTableModifiers;

public class ContentCraft implements ModInitializer {
	public static final String MOD_ID = "contentcraft";
	public static final String READABLE_MOD_ID = "ContentCraft";
	public static final String MOD_VERSION = FabricLoader.getInstance().getModContainer("contentcraft").orElseThrow().getMetadata().getVersion().getFriendlyString();
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading ContentCraft's Content...");
		//------load Mod classes here!------

		ModBlocks.load();
		ModItems.load();
		ModItemGroups.load();
		ModBlockEntityTypes.load();
		ModScreenHandlerTypes.load();
		ModStrippables.load();
		ModLootTableModifiers.load();
		ModCompostables.load();
		ModFlammables.load();

		//----------------------------------
		LOGGER.info("ContentCraft Loaded!");
	}
}