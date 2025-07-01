package xyz.glowstonelabs.contentcraft.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import xyz.glowstonelabs.contentcraft.util.Configs.ModConfigs;

public class NewDayNotifier {
    // Keeps track of the last day displayed to avoid repeating notifications
    private static long lastDay = -1;

    /**
     * Checks the current in-game day and displays a title screen message when a new day starts.
     * This is only triggered once per day and only if the feature is enabled in the config.
     */
    public static void updateDayTitle(MinecraftClient client) {
        // If the New Day Notifier is disabled in the config or the world is null, do nothing
        if (ModConfigs.CONFIG.NewDayNotifier || client.world == null) return;

        // Calculate the current in-game day based on world time (1 day = 24000 ticks)
        long currentDay = client.world.getTimeOfDay() / 24000L;

        // Only trigger the title display if the day has changed
        if (currentDay != lastDay) {
            lastDay = currentDay; // Update the last displayed day

            // Show the new day as a title message (e.g., "Day 5")
            client.inGameHud.setTitle(Text.literal("Day " + currentDay));
            client.inGameHud.setSubtitle(Text.empty()); // Clear any subtitle
            client.inGameHud.setTitleTicks(10, 40, 10); // Fade in/out timing: in, stay, out (in ticks)
        }
    }
}
