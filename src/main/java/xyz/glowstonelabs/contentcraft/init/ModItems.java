package xyz.glowstonelabs.contentcraft.init;

import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;
import xyz.glowstonelabs.contentcraft.Item.BarkItem;
import xyz.glowstonelabs.contentcraft.Item.PoisonousCarrotItem;
import xyz.glowstonelabs.contentcraft.Item.TrowelItem;
import xyz.glowstonelabs.contentcraft.registry.BarkTypeRegistry;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.item.Items.register;
import static xyz.glowstonelabs.contentcraft.ContentCraft.MOD_ID;

public class ModItems {
    public static final Item ARTIFICIAL_DIAMOND = registerItem("artificial_diamond", new Item(new Item.Settings()));
    public static final Item XAENON_INGOT = registerItem("xaenon_ingot", new Item(new Item.Settings()));
    public static final Item RAW_XAENON = registerItem("raw_xaenon", new Item(new Item.Settings()));

    public static final Item XAENON_SWORD = registerItem("xaenon_sword",
            new SwordItem(ModTools.XAENON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModTools.XAENON, 3, -2.4f))));
    public static final Item XAENON_PICKAXE = registerItem("xaenon_pickaxe",
            new PickaxeItem(ModTools.XAENON, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModTools.XAENON, 1, -2.8f))));
    public static final Item XAENON_SHOVEL = registerItem("xaenon_shovel",
            new ShovelItem(ModTools.XAENON, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModTools.XAENON, 1.5f, -3.0f))));
    public static final Item XAENON_AXE = registerItem("xaenon_axe",
            new AxeItem(ModTools.XAENON, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModTools.XAENON, 6, -3.2f))));
    public static final Item XAENON_HOE = registerItem("xaenon_hoe",
            new HoeItem(ModTools.XAENON, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModTools.XAENON, 0, -3f))));


    public static final Item XAENON_HELMET = registerItem("xaenon_helmet",
            new ArmorItem(ModArmors.XAENON_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item XAENON_CHESTPLATE = registerItem("xaenon_chestplate",
            new ArmorItem(ModArmors.XAENON_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item XAENON_LEGGINGS = registerItem("xaenon_leggings",
            new ArmorItem(ModArmors.XAENON_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item XAENON_BOOTS = registerItem("xaenon_boots",
            new ArmorItem(ModArmors.XAENON_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    // Sword: slightly less bonus damage than diamond (diamond: 3)
    public static final Item ARTIFICIAL_DIAMOND_SWORD = registerItem("artificial_diamond_sword",
            new SwordItem(ModTools.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModTools.ARTIFICIAL_DIAMOND,
                            2, -2.4f))));

    // Pickaxe: slightly lower bonus damage (diamond: 1)
    public static final Item ARTIFICIAL_DIAMOND_PICKAXE = registerItem("artificial_diamond_pickaxe",
            new PickaxeItem(ModTools.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModTools.ARTIFICIAL_DIAMOND,
                            0.5f, -2.9f))));

    // Shovel: slightly lower damage (diamond: 1.5)
    public static final Item ARTIFICIAL_DIAMOND_SHOVEL = registerItem("artificial_diamond_shovel",
            new ShovelItem(ModTools.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModTools.ARTIFICIAL_DIAMOND,
                            1.0f, -3.0f))));

    public static final Item ARTIFICIAL_DIAMOND_AXE = registerItem("artificial_diamond_axe",
            new AxeItem(ModTools.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModTools.ARTIFICIAL_DIAMOND,
                            5.0f, -3.2f))));

    public static final Item ARTIFICIAL_DIAMOND_HOE = registerItem("artificial_diamond_hoe",
            new HoeItem(ModTools.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModTools.ARTIFICIAL_DIAMOND,
                            -0.5f, -3.2f))));

    public static final Item ARTIFICIAL_DIAMOND_HELMET = registerItem("artificial_diamond_helmet",
            new ArmorItem(ModArmors.ARTIFICIAL_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(28))));

    public static final Item ARTIFICIAL_DIAMOND_CHESTPLATE = registerItem("artificial_diamond_chestplate",
            new ArmorItem(ModArmors.ARTIFICIAL_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(28))));

    public static final Item ARTIFICIAL_DIAMOND_LEGGINGS = registerItem("artificial_diamond_leggings",
            new ArmorItem(ModArmors.ARTIFICIAL_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(28))));

    public static final Item ARTIFICIAL_DIAMOND_BOOTS = registerItem("artificial_diamond_boots",
            new ArmorItem(ModArmors.ARTIFICIAL_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(28))));

    public static final Item POISONOUS_CARROT = registerItem("poisonous_carrot", new PoisonousCarrotItem((new Item.Settings()).food(FoodComponents.POISONOUS_POTATO)));

    public static final Item TROWEL = registerItem("trowel", new TrowelItem(new Item.Settings()));

    public static final Item BOILED_EGG = registerItem("boiled_egg", new Item(new Item.Settings().food(ModFoods.BOILED_EGG_COMPONENT).maxCount(16)));

    // In your ModItems class
    public static final Item OAK_BARK = registerItem("oak_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.OAK_BLOCKS));

    public static final Item BIRCH_BARK = registerItem("birch_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.BIRCH_BLOCKS));

    public static final Item SPRUCE_BARK = registerItem("spruce_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.SPRUCE_BLOCKS));

    public static final Item DARK_OAK_BARK = registerItem("dark_oak_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.DARK_OAK_BLOCKS));

    public static final Item ACACIA_BARK = registerItem("acacia_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.ACACIA_BLOCKS));

    public static final Item JUNGLE_BARK = registerItem("jungle_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.JUNGLE_BLOCKS));

    public static final Item MANGROVE_BARK = registerItem("mangrove_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.MANGROVE_BLOCKS));

    public static final Item CHERRY_BARK = registerItem("cherry_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.CHERRY_BLOCKS));

    public static final Item WARPED_BARK = registerItem("warped_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.WARPED_BLOCKS));

    public static final Item CRIMSON_BARK = registerItem("crimson_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.CRIMSON_BLOCKS));

    public static final Item MAPLE_BARK = registerItem("maple_bark",
            new BarkItem(new Item.Settings(), BarkTypeRegistry.MAPLE_BLOCKS));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void load() { ContentCraft.LOGGER.info("Registering Mod Items for " + MOD_ID); }
}
