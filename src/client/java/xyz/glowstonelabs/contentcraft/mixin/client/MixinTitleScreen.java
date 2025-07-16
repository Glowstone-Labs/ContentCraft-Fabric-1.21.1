package xyz.glowstonelabs.contentcraft.mixin.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.glowstonelabs.contentcraft.util.Configs.ModConfigs;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen extends Screen {
    protected MixinTitleScreen() {
        super(Text.literal(""));
    }

    @Inject(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)I",
                    ordinal = 0
            )
    )
    private void onRender(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        String mousePos = String.format("X: %d Y: %d", mouseX, mouseY);
        context.drawTextWithShadow(
                this.textRenderer,
                Text.translatable("contentcraft.titlescreen_text").getString(),
                2,
                250,
                0xFFFFFF
        );

        if (ModConfigs.CONFIG.MouseCursorPositionDisplay) {
            context.drawTextWithShadow(
                    this.textRenderer,
                    mousePos,
                    mouseX + 15,
                    mouseY,
                    0xFFFFFF
            );
        }
    }
}
