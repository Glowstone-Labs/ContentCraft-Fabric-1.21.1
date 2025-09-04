package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammables {
    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MAPLE_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MAPLE_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MAPLE_LEAVES, 30, 60);
    }

    public static void load() {
        registerFlammables();
    }
}
