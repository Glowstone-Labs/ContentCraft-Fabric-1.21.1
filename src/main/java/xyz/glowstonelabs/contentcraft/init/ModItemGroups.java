package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;

public class ModItemGroups {
    public static final ItemGroup CONTENTCRAFT = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.XAENON_INGOT))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft"))
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
                    }).build());

    public static void load() { ContentCraft.LOGGER.info("Registering Mod ItemGroups (Creative Menu Tabs) for " + ContentCraft.MOD_ID); }
}
