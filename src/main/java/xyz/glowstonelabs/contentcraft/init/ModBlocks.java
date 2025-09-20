package xyz.glowstonelabs.contentcraft.init;

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
import xyz.glowstonelabs.contentcraft.block.BlueBerryBushBlock;
import xyz.glowstonelabs.contentcraft.block.RankerBlock;
import xyz.glowstonelabs.contentcraft.block.woodcrate.WoodCrateBlock;


import java.util.Optional;

public class ModBlocks {
    public static final Block XAENON_BLOCK = registerBlock("xaenon_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block XAENON_SLAB = registerBlock("xaenon_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.XAENON_BLOCK)));

    public static final Block XAENON_STAIRS = registerBlock("xaenon_stairs",
            new StairsBlock(ModBlocks.XAENON_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.copy(ModBlocks.XAENON_BLOCK)));

    public static final Block RAW_XAENON_BLOCK = registerBlock("raw_xaenon_block",
            new Block(AbstractBlock.Settings.copy(ModBlocks.XAENON_BLOCK).strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block XAENON_ORE = registerBlock("xaenon_ore",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERRACK)));

    public static final Block MAPLE_LOG = registerBlock("maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG).mapColor(MapColor.BROWN)));

    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(ModBlocks.MAPLE_LOG)));

    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(ModBlocks.MAPLE_LOG)));

    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(ModBlocks.MAPLE_WOOD)));

    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));

    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES).mapColor(MapColor.ORANGE)));

    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
            new SaplingBlock(new SaplingGenerator("tree_maple",
                    Optional.empty(), Optional.of(RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,
                    Identifier.of(ContentCraft.MOD_ID, "tree_maple"))),
                    Optional.empty()),
                    SaplingBlock.Settings.copy(Blocks.SPRUCE_SAPLING)
                            .mapColor(MapColor.ORANGE)));

    public static final Block MAPLE_STAIRS = registerBlock("maple_stairs",
            new StairsBlock(ModBlocks.MAPLE_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.copy(ModBlocks.MAPLE_PLANKS)));

    public static final Block MAPLE_SLAB = registerBlock("maple_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.MAPLE_PLANKS)));

    public static final Block MAPLE_BUTTON = registerBlock("maple_button",
            new ButtonBlock(BlockSetType.OAK, 2, AbstractBlock.Settings.copy(ModBlocks.MAPLE_PLANKS).noCollision()));

    public static final Block MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            new PressurePlateBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.copy(ModBlocks.MAPLE_PLANKS)));

    public static final Block MAPLE_FENCE = registerBlock("maple_fence",
            new FenceBlock(AbstractBlock.Settings.copy(ModBlocks.MAPLE_PLANKS)));

    public static final Block MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.copy(ModBlocks.MAPLE_PLANKS)));

    public static final Block MAPLE_DOOR = registerBlock("maple_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(ModBlocks.MAPLE_PLANKS).nonOpaque()));

    public static final Block MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(ModBlocks.MAPLE_PLANKS).nonOpaque()));

    public static final Block ARTIFICIAL_DIAMOND_BLOCK = registerBlock("artificial_diamond_block",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK)));

    public static final Block DIRT_SLAB = registerBlock("dirt_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DIRT)));

    public static final Block DIRT_STAIRS = registerBlock("dirt_stairs",
            new StairsBlock(Blocks.DIRT.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.DIRT)));

    public static final Block SAND_SLAB = registerBlock("sand_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.SAND)));

    public static final Block SAND_STAIRS = registerBlock("sand_stairs",
            new StairsBlock(Blocks.SAND.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.SAND)));

    public static final Block ANDESITE_BRICKS = registerBlock("andesite_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.ANDESITE)));

    public static final Block ANDESITE_BRICK_SLAB = registerBlock("andesite_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.ANDESITE_SLAB)));

    public static final Block ANDESITE_BRICK_STAIRS = registerBlock("andesite_brick_stairs",
            new StairsBlock(ModBlocks.ANDESITE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.ANDESITE_STAIRS)));

    public static final Block ANDESITE_BRICK_WALL = registerBlock("andesite_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.ANDESITE_WALL)));


    public static final Block GRANITE_BRICKS = registerBlock("granite_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.GRANITE)));

    public static final Block GRANITE_BRICK_SLAB = registerBlock("granite_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.GRANITE_SLAB)));

    public static final Block GRANITE_BRICK_STAIRS = registerBlock("granite_brick_stairs",
            new StairsBlock(ModBlocks.ANDESITE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.GRANITE_STAIRS)));

    public static final Block GRANITE_BRICK_WALL = registerBlock("granite_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.GRANITE_WALL)));


    public static final Block DIORITE_BRICKS = registerBlock("diorite_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.DIORITE)));

    public static final Block DIORITE_BRICK_SLAB = registerBlock("diorite_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DIORITE_SLAB)));

    public static final Block DIORITE_BRICK_STAIRS = registerBlock("diorite_brick_stairs",
            new StairsBlock(ModBlocks.DIORITE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.DIORITE_STAIRS)));

    public static final Block DIORITE_BRICK_WALL = registerBlock("diorite_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.DIORITE_WALL)));


    public static final Block CALCITE_SLAB = registerBlock("calcite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE)));

    public static final Block CALCITE_STAIRS = registerBlock("calcite_stairs",
            new StairsBlock(Blocks.CALCITE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.CALCITE)));

    public static final Block CALCITE_WALL = registerBlock("calcite_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE)));

    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.CALCITE)));

    public static final Block CALCITE_BRICK_SLAB = registerBlock("calcite_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.CALCITE_SLAB)));

    public static final Block CALCITE_BRICK_STAIRS = registerBlock("calcite_brick_stairs",
            new StairsBlock(ModBlocks.CALCITE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(ModBlocks.CALCITE_STAIRS)));

    public static final Block CALCITE_BRICK_WALL = registerBlock("calcite_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(ModBlocks.CALCITE_BRICKS)));

    public static final Block DRIPSTONE_SLAB = registerBlock("dripstone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_STAIRS = registerBlock("dripstone_stairs",
            new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_WALL = registerBlock("dripstone_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_BRICKS = registerBlock("dripstone_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)));

    public static final Block DRIPSTONE_BRICK_SLAB = registerBlock("dripstone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.CALCITE_SLAB)));

    public static final Block DRIPSTONE_BRICK_STAIRS = registerBlock("dripstone_brick_stairs",
            new StairsBlock(ModBlocks.CALCITE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.copy(ModBlocks.CALCITE_STAIRS)));

    public static final Block DRIPSTONE_BRICK_WALL = registerBlock("dripstone_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(ModBlocks.CALCITE_BRICKS)));

    public static final Block BLUE_NETHER_BRICKS = registerBlock("blue_nether_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS).mapColor(MapColor.DARK_AQUA)));

    public static final Block BLUE_NETHER_BRICK_STAIRS = registerBlock("blue_nether_brick_stairs",
            new StairsBlock(BLUE_NETHER_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_STAIRS).mapColor(MapColor.DARK_AQUA)));

    public static final Block BLUE_NETHER_BRICK_SLAB = registerBlock("blue_nether_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_SLAB).mapColor(MapColor.DARK_AQUA)));

    public static final Block BLUE_NETHER_BRICK_WALL = registerBlock("blue_nether_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_WALL).mapColor(MapColor.DARK_AQUA)));


    public static final WoodCrateBlock WOOD_CRATE = (WoodCrateBlock) registerBlock("wood_crate",
            new WoodCrateBlock(AbstractBlock.Settings.create()));

    public static final Block RANKER_BLOCK = registerBlock("ranker_block",
            new RankerBlock(AbstractBlock.Settings.create()));



    // TODO: Add Grass Slab With Working biome textures, it was such a fucking mess
    // TODO: Add Vertical Slabs for blocks with slab variant


    public static final Block BLUEBERRY_BUSH = registerBlockWithoutBlockItem("blueberry_bush",
            new BlueBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ContentCraft.MOD_ID, name), block);
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ContentCraft.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ContentCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void load() {}
}
