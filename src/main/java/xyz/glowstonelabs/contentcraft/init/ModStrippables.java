package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippables {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.MAPLE_LOG, ModBlocks.STRIPPED_MAPLE_LOG);
        StrippableBlockRegistry.register(ModBlocks.MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_WOOD);
    }

    public static void load() {
        registerStrippables();
    }
}
