package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.util.ModTags;


public class ModCompostables {
    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.ACACIA_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BIRCH_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CHERRY_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CRIMSON_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.DARK_OAK_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.JUNGLE_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.MANGROVE_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.MAPLE_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.OAK_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.SPRUCE_BARK, 1.0f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.WARPED_BARK, 1.0f);
    }

    public static void load() {
        registerCompostables();
    }
}
