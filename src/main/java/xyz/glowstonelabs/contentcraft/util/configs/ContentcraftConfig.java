package xyz.glowstonelabs.contentcraft.util.configs;

import me.fzzyhmstrs.fzzy_config.annotations.Action;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.api.FileType;
import me.fzzyhmstrs.fzzy_config.api.SaveType;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import xyz.glowstonelabs.contentcraft.ContentCraft;

public class ContentcraftConfig extends Config {

    public DevModeConfig devModeConfig = new DevModeConfig();
    public HUDConfig hudConfig = new HUDConfig();

    public static class DevModeConfig extends ConfigSection {
        public boolean mouseCursorPositionDisplay = false;

        public DevModeConfig() {
            super();
        }
    }

    public static class HUDConfig extends ConfigSection {
        public boolean newDayNotifier = true;
        public boolean coordinateDisplay = true;
        public boolean timeDisplay = true;

        public HUDConfig() {
            super();
        }
    }



    @Override
    public int defaultPermLevel() {
        return 0;
    }

    @Override
    public @NotNull FileType fileType() {
        return FileType.JSON5;
    }

    @Override
    public @NotNull SaveType saveType() {
        return SaveType.SEPARATE;
    }

    public ContentcraftConfig() {
        super(Identifier.of(ContentCraft.MOD_ID, ContentCraft.MOD_ID));
    }
}