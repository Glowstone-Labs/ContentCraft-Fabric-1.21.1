package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;

import java.util.Optional;

/**
 * This class registers all custom blocks added by the mod.
 * Blocks are sorted and grouped to match the same order as ModItemGroups for consistency.
 */
public class ModBlocks {

    // ========================
    //      Xaenon Blocks
    // ========================
    public static final Block XAENON_BLOCK = registerWithItem("xaenon_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block RAW_XAENON_BLOCK = registerWithItem("raw_xaenon_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block XAENON_ORE = registerWithItem("xaenon_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERRACK)));

    // ========================
    //      Maple WoodSet
    // ========================
    public static final Block MAPLE_LOG = registerWithItem("maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block MAPLE_WOOD = registerWithItem("maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_MAPLE_LOG = registerWithItem("stripped_maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_MAPLE_WOOD = registerWithItem("stripped_maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block MAPLE_PLANKS = registerWithItem("maple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block MAPLE_STAIRS = registerWithItem("maple_stairs",
            new StairsBlock(MAPLE_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()));

    public static final Block MAPLE_SLAB = registerWithItem("maple_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()));

    public static final Block MAPLE_BUTTON = registerWithItem("maple_button",
            new ButtonBlock(BlockSetType.OAK, 2,
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
                            .noCollision()));

    public static final Block MAPLE_PRESSURE_PLATE = registerWithItem("maple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()));

    public static final Block MAPLE_FENCE = registerWithItem("maple_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()));

    public static final Block MAPLE_FENCE_GATE = registerWithItem("maple_fence_gate",
            new FenceGateBlock(WoodType.OAK,
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()));

    public static final Block MAPLE_DOOR = registerWithItem("maple_door",
            new DoorBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
                            .nonOpaque()));

    public static final Block MAPLE_TRAPDOOR = registerWithItem("maple_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
                            .nonOpaque()));

    public static final Block MAPLE_LEAVES = registerWithItem("maple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    /** Maple sapling block, uses a custom SaplingGenerator linked to mod's tree feature */
    public static final Block MAPLE_SAPLING = registerWithItem("maple_sapling",
            new SaplingBlock(
                    new SaplingGenerator(
                            "tree_maple",
                            Optional.empty(),
                            Optional.of(RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,
                                    Identifier.of(ContentCraft.MOD_ID, "tree_maple"))),
                            Optional.empty()
                    ),
                    SaplingBlock.Settings.copy(Blocks.OAK_SAPLING)
            ));

    // ========================
    //   Artificial Diamond
    // ========================
    public static final Block ARTIFICIAL_DIAMOND_BLOCK = registerWithItem("artificial_diamond_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DIAMOND_BLUE)
                    .strength(20.0F, 6.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ContentCraft.MOD_ID, name), block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ModItems.registerBlockItem(name, registered, settings);
        return registered;
    }

    public static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());
    }

    /**
     * Log info on mod block registration, called during mod initialization.
     */
    public static void load() {
        ContentCraft.LOGGER.info("Registering Mod Blocks for " + ContentCraft.MOD_ID);
    }
}
