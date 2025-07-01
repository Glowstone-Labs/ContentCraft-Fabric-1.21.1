package xyz.glowstonelabs.contentcraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import xyz.glowstonelabs.contentcraft.gui.HUDOverlay;
import xyz.glowstonelabs.contentcraft.gui.NewDayNotifier;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;

/**
 * Client-side initialization for the ContentCraft mod.
 * This is where rendering layers and HUD overlays are registered.
 */
public class ContentCraftClient implements ClientModInitializer {

	/**
	 * Called when the client is starting up. Use this to register render layers, HUD overlays, and other
	 * visual or client-only features.
	 */
	@Override
	public void onInitializeClient() {

		// ===============================
		// Render Layer Setup for Blocks
		// ===============================

		// Set the render layer for custom transparent/cutout blocks like saplings, doors, trapdoors.
		// 'getCutout()' is used for things with transparent pixels in their textures.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());

		// =====================================
		// Register HUD Overlay Rendering Logic
		// =====================================

		// Register the HUDOverlay class to render custom HUD elements (coordinates, clock, etc.)
		HudRenderCallback.EVENT.register(new HUDOverlay() {
			// This override is technically not needed unless extending behavior.
			// Calls HUDOverlay's implementation of onHudRender.
			@Override
			public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
				super.onHudRender(drawContext, renderTickCounter);
			}
		});

		// =================================================
		// Initialize the New Day Notifier HUD on Startup
		// =================================================

		// Immediately update the day title when the client initializes (optional early visual update)
		NewDayNotifier.updateDayTitle(MinecraftClient.getInstance());
	}
}
