package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;

public class ModItemGroups {
    public static final ItemGroup CONTENTCRAFT_ORE_OVERHAUL = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_ore_overhaul"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.XAENON_ORE.asItem(), 1))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_ore_overhaul"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.XAENON_INGOT);
                        entries.add(ModItems.RAW_XAENON);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND);
                        entries.add(new ItemStack(ModBlocks.ARTIFICIAL_DIAMOND_BLOCK, 1));
                        entries.add(new ItemStack(ModBlocks.XAENON_ORE, 1));
                        entries.add(new ItemStack(ModBlocks.RAW_XAENON_BLOCK, 1));



                    }).build());

    public static final ItemGroup CONTENTCRAFT_EXPLORATION = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_exploration"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.COMPASS))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_exploration"))
                    .entries((displayContext, entries) -> {
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


                    }).build());

    public static final ItemGroup CONTENTCRAFT_ARSENAL = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ContentCraft.MOD_ID, "contentcraft_arsenal"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.XAENON_SWORD))
                    .displayName(Text.translatable("itemgroup.contentcraft.contentcraft_arsenal"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.XAENON_HELMET);
                        entries.add(ModItems.XAENON_CHESTPLATE);
                        entries.add(ModItems.XAENON_LEGGINGS);
                        entries.add(ModItems.XAENON_BOOTS);

                        entries.add(ModItems.XAENON_SWORD);
                        entries.add(ModItems.XAENON_AXE);
                        entries.add(ModItems.XAENON_PICKAXE);
                        entries.add(ModItems.XAENON_SHOVEL);
                        entries.add(ModItems.XAENON_HOE);

                        entries.add(ModItems.ARTIFICIAL_DIAMOND_HELMET);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_LEGGINGS);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_BOOTS);

                        entries.add(ModItems.ARTIFICIAL_DIAMOND_SWORD);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_AXE);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_PICKAXE);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_SHOVEL);
                        entries.add(ModItems.ARTIFICIAL_DIAMOND_HOE);
                    }).build());



    public static void load() {
        ContentCraft.LOGGER.info("Registering Item Groups for " + ContentCraft.MOD_ID);
    }
}