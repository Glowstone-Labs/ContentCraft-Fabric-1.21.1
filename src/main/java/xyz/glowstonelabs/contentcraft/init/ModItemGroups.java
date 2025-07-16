package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;

public class ModItemGroups {
    public static final ItemGroup CONTENTCRAFT_ORE_EXPANSION = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_ore_expansion"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.XAENON_ORE))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_ore_expansion"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.XAENON_INGOT);
                        entries.add(ModItems.RAW_XAENON);
                        entries.add(ModBlocks.XAENON_BLOCK);
                        entries.add(ModBlocks.RAW_XAENON_BLOCK);
                        entries.add(ModBlocks.XAENON_ORE);
                        entries.add(ModItems.XAENON_SWORD);
                        entries.add(ModItems.XAENON_PICKAXE);
                        entries.add(ModItems.XAENON_SHOVEL);
                        entries.add(ModItems.XAENON_AXE);
                        entries.add(ModItems.XAENON_HOE);
                        entries.add(ModItems.XAENON_HELMET);
                        entries.add(ModItems.XAENON_CHESTPLATE);
                        entries.add(ModItems.XAENON_LEGGINGS);
                        entries.add(ModItems.XAENON_BOOTS);

                        entries.add(ModItems.ARTIFICIAL_DIAMOND);
                        entries.add(ModBlocks.ARTIFICIAL_DIAMOND_BLOCK);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_SWORD);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_PICKAXE);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_SHOVEL);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_AXE);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_HOE);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_HELMET);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_LEGGINGS);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_BOOTS);
                    }).build());

    public static final ItemGroup CONTENTCRAFT_EXPLORATION = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_contentcraft_exploration"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.OAK_BARK))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_exploration"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MAPLE_LOG);
                        entries.add(ModBlocks.MAPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_MAPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_MAPLE_WOOD);
                        entries.add(ModBlocks.MAPLE_PLANKS);
                        entries.add(ModBlocks.MAPLE_STAIRS);
                        entries.add(ModBlocks.MAPLE_SLAB);
                        entries.add(ModBlocks.MAPLE_PRESSURE_PLATE);
                        entries.add(ModBlocks.MAPLE_BUTTON);
                        entries.add(ModBlocks.MAPLE_FENCE);
                        entries.add(ModBlocks.MAPLE_FENCE_GATE);
                        entries.add(ModBlocks.MAPLE_DOOR);
                        entries.add(ModBlocks.MAPLE_TRAPDOOR);
                        entries.add(ModBlocks.MAPLE_LEAVES);
                        entries.add(ModBlocks.MAPLE_SAPLING);

                        entries.add(ModItems.OAK_BARK);
                        entries.add(ModItems.BIRCH_BARK);
                        entries.add(ModItems.SPRUCE_BARK);
                        entries.add(ModItems.DARK_OAK_BARK);
                        entries.add(ModItems.ACACIA_BARK);
                        entries.add(ModItems.JUNGLE_BARK);
                        entries.add(ModItems.MANGROVE_BARK);
                        entries.add(ModItems.CHERRY_BARK);
                        entries.add(ModItems.WARPED_BARK);
                        entries.add(ModItems.CRIMSON_BARK);
                        entries.add(ModItems.MAPLE_BARK);

                    }).build());

    public static final ItemGroup CONTENTCRAFT_AGRICULTURE = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_contentcraft_agriculture"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.POISONOUS_CARROT))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_agriculture"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.POISONOUS_CARROT);

                    }).build());

    public static final ItemGroup CONTENTCRAFT_DECO = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_contentcraft_deco"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DIRT_SLAB))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_deco"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.DIRT_SLAB);
                    }).build());

    public static final ItemGroup CONTENTCRAFT_TOOLS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_contentcraft_tools"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DIRT_SLAB))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_tools"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TROWEL);
                    }).build());



    public static void load() { ContentCraft.LOGGER.info("Registering Mod ItemGroups (Creative Menu Tabs) for " + ContentCraft.MOD_ID); }
}
