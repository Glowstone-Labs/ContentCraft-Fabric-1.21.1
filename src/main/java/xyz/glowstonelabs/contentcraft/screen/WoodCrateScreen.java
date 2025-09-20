package xyz.glowstonelabs.contentcraft.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;
import xyz.glowstonelabs.contentcraft.block.woodcrate.WoodCrateScreenHandler;

public class WoodCrateScreen extends HandledScreen<WoodCrateScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(ContentCraft.MOD_ID, "textures/gui/wood_crate.png");

    public WoodCrateScreen(WoodCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 133;
        this.playerInventoryTitleY = 39;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}