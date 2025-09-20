package xyz.glowstonelabs.contentcraft.util.configs;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import me.fzzyhmstrs.fzzy_config.config.Config;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import xyz.glowstonelabs.contentcraft.util.configs.ContentcraftConfig;

/**
 * Class responsible for registering and managing all mod configuration instances.
 * Acts as a central place to initialize and hold config references.
 */
public class ModConfigs extends Config {

    /**
     * Static instance of ContentCraftConfig.
     * Registered and loaded as a client-only config via Fzzy Config API.
     * This means the config affects client-side behavior/UI, not server.
     */
    public static final ContentcraftConfig CONFIG = ConfigApiJava.registerAndLoadConfig(ContentcraftConfig::new, RegisterType.CLIENT);

    /**
     * Constructor which allows for more complex config initialization if needed.
     *
     * @param identifier Unique Identifier for this config instance
     * @param subfolder  Subfolder path where config file is stored
     * @param folder     Main folder path for config files
     * @param name       Filename for this config
     */
    public ModConfigs(@NotNull Identifier identifier, @NotNull String subfolder, @NotNull String folder, @NotNull String name) {
        super(identifier, subfolder, folder, name);
    }

    public static void init() {}

    //huh, configs are surprisingly easy with this api- ? or is it like, a lib? i think its a lib
}
