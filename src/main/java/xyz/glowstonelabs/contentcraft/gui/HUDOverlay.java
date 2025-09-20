package xyz.glowstonelabs.contentcraft.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

@Environment(EnvType.CLIENT)
public class HUDOverlay implements HudRenderCallback {

    // ========================
    // HUD Position Constants
    // ========================
    private static final int X_XYZPOS = 185;       // X position of "XYZ:" label
    private static final int X_COORDPOS = 210;     // X position of coordinate values
    private static final int X_DIRPOS = 280;       // X position of direction text
    private static final int X_DAYPOS = 187;       // X position of "Day: n" text
    private static final int X_IGTPOS = 233;       // X position of in-game time text

    private static final int Y_COMPASS_POS = 221;  // Y position for compass-related info (coordinates + direction)
    private static final int Y_CLOCK_POS = 209;    // Default Y position for clock-related info

    // ========================
    // HUD Text Colors
    // ========================
    private static final int GOLD = 0xDCA62E;       // Golden color used for labels (XYZ and direction)
    private static final int WHITE = 0xFFFFFF;      // White color used for values

    /**
     * Converts a yaw angle into a cardinal direction (e.g., N, NE, E, etc.).
     * Used to display the player's facing direction next to coordinates.
     */
    private String getCardinalDirection(float yaw) {
        yaw = (yaw % 360 + 360) % 360; // Normalize angle to 0–360°
        if (yaw < 22.5) return "S";
        else if (yaw < 67.5) return "SW";
        else if (yaw < 112.5) return "W";
        else if (yaw < 157.5) return "NW";
        else if (yaw < 202.5) return "N";
        else if (yaw < 247.5) return "NE";
        else if (yaw < 292.5) return "E";
        else if (yaw < 337.5) return "SE";
        else return "S";
    }

    /**
     * Formats the Minecraft world time (ticks) into a readable 12-hour clock format.
     * Each Minecraft day is 24000 ticks long.
     */
    private String formatGameTime(long ticks) {
        int hours = (int)((ticks / 1000 + 6) % 24); // Shift by 6 to align with Minecraft's day start
        String period = hours < 12 ? "AM" : "PM";
        int displayHours = hours % 12 == 0 ? 12 : hours % 12;
        int minutes = (int)((ticks % 1000) / 16.666); // Approximate minutes from tick remainder
        return String.format("%d:%02d %s", displayHours, minutes, period);
    }

    /**
     * Main rendering logic for the HUD overlay.
     * Displays day/time if the player has a clock, and coordinates/direction if the player has a compass.
     */
    @Override
    public void onHudRender(DrawContext dc, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        if (player == null || client.world == null) return; // Safety check

        // Check if Minecraft's F1 mode is active (hides all HUD elements)
        if (client.options.hudHidden) return;

        // Check if the player is holding a clock or compass (main or offhand)
        boolean hasClock = hasItemInHotbarOrOffhand(player, Items.CLOCK);
        boolean hasCompass = hasItemInHotbarOrOffhand(player, Items.COMPASS);

        // Exit early if neither item is held (nothing to render)
        if (!hasClock && !hasCompass) return;

        // Get current day and tick time from the world
        long day = client.world.getTimeOfDay() / 24000L;
        long ticks = client.world.getTimeOfDay() % 24000;

        // If the player has a compass AND coordinate display is enabled, use normal clock Y position.
        // Otherwise (coords are hidden), move the clock down to the coordinate Y position to fill the gap.
        int clockYPos = hasCompass ? Y_CLOCK_POS : Y_COMPASS_POS;

        // === Time Display ===
        // Only render time if the player has a clock and the config allows it
        if (hasClock) { // && ModConfigs.CONFIG.hudConfig.timeDisplay
            // Display "Day: n"
            dc.drawTextWithShadow(client.textRenderer,
                    String.format("Day: %d | ", day),
                    X_DAYPOS, clockYPos, WHITE);

            // Display "IGT: h:mm AM/PM"
            dc.drawTextWithShadow(client.textRenderer,
                    String.format("IGT: %s", formatGameTime(ticks)),
                    X_IGTPOS, clockYPos, WHITE);
        }

        // === Coordinate & Direction Display ===
        // Only render coordinates if the player has a compass and the config allows it
        if (hasCompass) { // && ModConfigs.CONFIG.hudConfig.coordinateDisplay
            int x = (int)player.getX();
            int y = (int)player.getY();
            int z = (int)player.getZ();

            // Display "XYZ:" label
            dc.drawTextWithShadow(client.textRenderer, "XYZ:", X_XYZPOS, Y_COMPASS_POS, GOLD);

            // Display position values
            dc.drawTextWithShadow(client.textRenderer,
                    String.format("%d, %d, %d", x, y, z),
                    X_COORDPOS, Y_COMPASS_POS, WHITE);

            // Display direction player is facing
            dc.drawTextWithShadow(client.textRenderer,
                    getCardinalDirection(player.getYaw()),
                    X_DIRPOS, Y_COMPASS_POS, GOLD);
        }
    }

    /**
     * Utility method to check if the given item exists in the player's hotbar or offhand.
     * Used to detect if a compass or clock should trigger HUD rendering.
     */
    private boolean hasItemInHotbarOrOffhand(PlayerEntity player, Item item) {
        // Check hotbar slots (0–8)
        for (int i = 0; i < 9; i++) {
            if (player.getInventory().getStack(i).isOf(item)) {
                return true;
            }
        }
        // Check offhand slot (slot 40)
        return player.getInventory().getStack(40).isOf(item);
    }
}