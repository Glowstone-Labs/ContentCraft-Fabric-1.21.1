package xyz.glowstonelabs.contentcraft.util.configs;

import me.fzzyhmstrs.fzzy_config.annotations.Action;
import me.fzzyhmstrs.fzzy_config.annotations.Comment;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.annotations.Translation;
import me.fzzyhmstrs.fzzy_config.api.FileType;
import me.fzzyhmstrs.fzzy_config.api.SaveType;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import me.fzzyhmstrs.fzzy_config.util.Translatable;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import xyz.glowstonelabs.contentcraft.ContentCraft;

public class ContentcraftConfig extends Config {

    public DevModeConfig devModeConfig = new DevModeConfig();
    public HUDConfig hudConfig = new HUDConfig();
    public TorchflowerConfig torchflowerConfig = new TorchflowerConfig();

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

    public static class TorchflowerConfig extends ConfigSection {
        @RequiresAction(action = Action.RESTART)public boolean enabled = true;
        @RequiresAction(action = Action.RESTART)public int brightness = 12;
        @RequiresAction(action = Action.RESTART)public int potBrightness = 14;
        @RequiresAction(action = Action.RESTART)public int stage1Brightness = 3;
        @RequiresAction(action = Action.RESTART)public int stage2Brightness = 7;
        // the amount of fucking lang files for this is fkn annoying

        public TorchflowerConfig() {
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