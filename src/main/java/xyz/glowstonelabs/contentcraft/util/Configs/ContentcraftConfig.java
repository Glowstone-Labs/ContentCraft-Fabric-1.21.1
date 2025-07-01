package xyz.glowstonelabs.contentcraft.util.Configs;

import me.fzzyhmstrs.fzzy_config.api.FileType;
import me.fzzyhmstrs.fzzy_config.api.SaveType;
import me.fzzyhmstrs.fzzy_config.config.Config;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import xyz.glowstonelabs.contentcraft.ContentCraft;

/**
 * Main configuration class for ContentCraft mod.
 * Extends the generic Config class from Fzzy Config library.
 * Holds user-customizable settings for the mod.
 */
public class ContentcraftConfig extends Config {

    /**
     * Constructor sets the config identifier.
     * Uses the mod's ID for both namespace and path, making the config unique to the mod.
     */
    public ContentcraftConfig() {
        super(Identifier.of(ContentCraft.MOD_ID, ContentCraft.MOD_ID));
    }

    /**
     * Configuration option to toggle displaying a "New Day" notifier in-game.
     * Defaults to true.
     */
    public boolean NewDayNotifier = true;

    /**
     * Configuration option to toggle the display of player coordinates on HUD.
     * Defaults to true.
     */
    public boolean CordinateDisplay = true;

    /**
     * Configuration option to toggle the display of the in-game time on HUD.
     * Defaults to true.
     */
    public boolean TimeDisplay = true;

    /**
     * Configuration option to toggle the display of the in-game time on HUD.
     * Defaults to true.
     */
    public boolean MouseCursorPositionDisplay = false;
    /**
     * Defines the default permission level for accessing or changing this config.
     * 0 usually means available to all users or no restrictions.
     */
    @Override
    public int defaultPermLevel() {
        return 0;
    }

    /**
     * Defines the file format used for the config file.
     * JSON5 is chosen here, allowing for more readable and flexible JSON (comments allowed etc).
     */
    @Override
    public @NotNull FileType fileType() {
        return FileType.JSON5;
    }

    /**
     * Defines how the config is saved.
     * SaveType.SEPARATE means the config file is saved separately from others.
     */
    @Override
    public @NotNull SaveType saveType() {
        return SaveType.SEPARATE;
    }
}
