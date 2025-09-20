package xyz.glowstonelabs.contentcraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ModBarkTypes {
    // Public immutable maps for each wood type
    public static final Map<Block, Block> OAK_BLOCKS = createOakMap();
    public static final Map<Block, Block> BIRCH_BLOCKS = createBirchMap();
    public static final Map<Block, Block> SPRUCE_BLOCKS = createSpruceMap();
    public static final Map<Block, Block> DARK_OAK_BLOCKS = createDarkOakMap();
    public static final Map<Block, Block> ACACIA_BLOCKS = createAcaciaMap();
    public static final Map<Block, Block> JUNGLE_BLOCKS = createJungleMap();
    public static final Map<Block, Block> MANGROVE_BLOCKS = createMangroveMap();
    public static final Map<Block, Block> CHERRY_BLOCKS = createCherryMap();
    public static final Map<Block, Block> WARPED_BLOCKS = createWarpedMap();
    public static final Map<Block, Block> CRIMSON_BLOCKS = createCrimsonMap();
    public static final Map<Block, Block> MAPLE_BLOCKS = createMapleMap();

    private ModBarkTypes() {} // Prevent instantiation

    // this is so long wtf T_T
    private static Map<Block, Block> createOakMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_OAK_LOG, Blocks.OAK_LOG);
        map.put(Blocks.STRIPPED_OAK_WOOD, Blocks.OAK_WOOD);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createBirchMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_LOG);
        map.put(Blocks.STRIPPED_BIRCH_WOOD, Blocks.BIRCH_WOOD);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createSpruceMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_LOG);
        map.put(Blocks.STRIPPED_SPRUCE_WOOD, Blocks.SPRUCE_WOOD);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createDarkOakMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_LOG);
        map.put(Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.DARK_OAK_WOOD);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createAcaciaMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_LOG);
        map.put(Blocks.STRIPPED_ACACIA_WOOD, Blocks.ACACIA_WOOD);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createJungleMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_LOG);
        map.put(Blocks.STRIPPED_JUNGLE_WOOD, Blocks.JUNGLE_WOOD);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createMangroveMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_LOG);
        map.put(Blocks.STRIPPED_MANGROVE_WOOD, Blocks.MANGROVE_WOOD);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createCherryMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_LOG);
        map.put(Blocks.STRIPPED_CHERRY_WOOD, Blocks.CHERRY_WOOD);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createWarpedMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_STEM);
        map.put(Blocks.STRIPPED_WARPED_HYPHAE, Blocks.WARPED_HYPHAE);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createCrimsonMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_STEM);
        map.put(Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.CRIMSON_HYPHAE);
        return Collections.unmodifiableMap(map);
    }

    private static Map<Block, Block> createMapleMap() {
        Map<Block, Block> map = new HashMap<>();
        map.put(ModBlocks.STRIPPED_MAPLE_LOG, ModBlocks.MAPLE_LOG);
        map.put(ModBlocks.STRIPPED_MAPLE_WOOD, ModBlocks.MAPLE_WOOD);
        return Collections.unmodifiableMap(map);
    }

    public static void initialize() {
        // Initialization happens automatically through static field loading
    }
}