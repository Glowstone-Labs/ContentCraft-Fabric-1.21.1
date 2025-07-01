package xyz.glowstonelabs.contentcraft.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;

/**
 * This class holds all custom tag definitions for blocks and items used by the mod.
 * Tags are used to group similar blocks/items for conditional logic, like tool requirements.
 */
public class ModTags {

    /**
     * Nested static class holding block-related tags.
     */
    public static class Blocks {

        /**
         * Tag for blocks that specifically require the Xaenon tool to mine effectively.
         * Used to check if a player has the proper tool before mining.
         */
        public static final TagKey<Block> NEEDS_XAENON_TOOL = createTag("needs_xaenon_tool");

        /**
         * Tag for blocks that are considered inappropriate or ineffective to mine with Xaenon tools.
         */
        public static final TagKey<Block> INCORRECT_FOR_XAENON_TOOL = createTag("incorrect_for_xaenon_tool");

        /**
         * Helper method to create a TagKey for blocks under this mod's namespace.
         *
         * @param name The name of the tag
         * @return TagKey<Block> with mod namespace
         */
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ContentCraft.MOD_ID, name));
        }
    }

    /**
     * Nested static class holding item-related tags.
     */
    public static class Items {

        /**
         * Tag grouping all hammer items defined in the mod.
         * Allows for easy checking of whether an item is considered a hammer.
         */
        public static final TagKey<Item> HAMMERS = createTag("hammers");
        public static final TagKey<Item> WOOD_BARKS = createTag("wood_barks");


        /**
         * Helper method to create a TagKey for items under this mod's namespace.
         *
         * @param name The name of the tag
         * @return TagKey<Item> with mod namespace
         */
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ContentCraft.MOD_ID, name));
        }
    }
}
