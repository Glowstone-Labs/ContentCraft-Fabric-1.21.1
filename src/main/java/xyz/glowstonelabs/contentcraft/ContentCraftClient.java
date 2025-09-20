package xyz.glowstonelabs.contentcraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import xyz.glowstonelabs.contentcraft.gui.HUDOverlay;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModScreenHandlerTypes;
import xyz.glowstonelabs.contentcraft.screen.WoodCrateScreen;

public class ContentCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Set up cutout rendering for transparent blocks
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_BUSH, RenderLayer.getCutout());

		HandledScreens.register(ModScreenHandlerTypes.WOOD_CRATE, WoodCrateScreen::new);

		HudRenderCallback.EVENT.register(new HUDOverlay());
	}
}