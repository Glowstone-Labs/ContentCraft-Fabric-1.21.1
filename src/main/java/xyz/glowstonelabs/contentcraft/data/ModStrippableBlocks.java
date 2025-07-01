package xyz.glowstonelabs.contentcraft.data;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        // Use Fabric's API instead of accessing the protected field directly
        StrippableBlockRegistry.register(ModBlocks.MAPLE_LOG, ModBlocks.STRIPPED_MAPLE_LOG);
        StrippableBlockRegistry.register(ModBlocks.MAPLE_WOOD, ModBlocks.STRIPPED_MAPLE_WOOD);
    }
}