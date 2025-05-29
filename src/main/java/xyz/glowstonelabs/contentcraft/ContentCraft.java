package xyz.glowstonelabs.contentcraft;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentCraft implements ModInitializer {
	public static final String MOD_ID = "contentcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading ContentCraft's Content...");
		//------load Mod classes here!------



		//----------------------------------
		LOGGER.info("ContentCraft Loaded!");
	}
}