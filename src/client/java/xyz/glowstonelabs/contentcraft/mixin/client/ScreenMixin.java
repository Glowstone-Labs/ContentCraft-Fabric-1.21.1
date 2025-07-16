package xyz.glowstonelabs.contentcraft.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.glowstonelabs.contentcraft.util.Configs.ModConfigs;

@Mixin(Screen.class)
public abstract class ScreenMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void renderDevOverlay(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (ModConfigs.CONFIG.devModeConfig.mouseCursorPositionDisplay) {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client == null || client.textRenderer == null) return;

            int x = 5;
            int y = 5;
            int lineSpacing = 12;

            context.drawText(client.textRenderer, Text.literal("Dev Mode:"), x, y, 0xFFFFFF, true);
            y += lineSpacing;

            // FPS
            String fpsText = String.format("FPS: %d", client.getCurrentFps());
            context.drawText(client.textRenderer, Text.literal(fpsText), x, y, 0x55FF55, true);
            y += lineSpacing;

            // Mouse Position
            String mouseText = String.format("Mouse Position: X: %d, Y: %d", mouseX, mouseY);
            context.drawText(client.textRenderer, Text.literal(mouseText), x, y, 0xFFFFFF, true);
            y += lineSpacing;

            // Memory
            Runtime runtime = Runtime.getRuntime();
            long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
            long maxMem = runtime.maxMemory() / (1024 * 1024);
            String memText = String.format("Memory: %d/%dMB", usedMem, maxMem);
            context.drawText(client.textRenderer, Text.literal(memText), x, y, 0xFF5555, true);
            y += lineSpacing;
        }
    }
}
