package xyz.glowstonelabs.contentcraft.init;

import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;
import xyz.glowstonelabs.contentcraft.Item.PoisonousCarrotItem;
import xyz.glowstonelabs.contentcraft.Item.TrowelItem;

import static xyz.glowstonelabs.contentcraft.ContentCraft.MOD_ID;

public class ModItems {
    public static final Item ARTIFICIAL_DIAMOND = registerItem("artificial_diamond", new Item(new Item.Settings()));
    public static final Item XAENON_INGOT = registerItem("xaenon_ingot", new Item(new Item.Settings()));
    public static final Item RAW_XAENON = registerItem("raw_xaenon", new Item(new Item.Settings()));

    public static final Item XAENON_SWORD = registerItem("xaenon_sword",
            new SwordItem(ModToolMaterials.XAENON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.XAENON, 3, -2.4f))));
    public static final Item XAENON_PICKAXE = registerItem("xaenon_pickaxe",
            new PickaxeItem(ModToolMaterials.XAENON, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.XAENON, 1, -2.8f))));
    public static final Item XAENON_SHOVEL = registerItem("xaenon_shovel",
            new ShovelItem(ModToolMaterials.XAENON, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.XAENON, 1.5f, -3.0f))));
    public static final Item XAENON_AXE = registerItem("xaenon_axe",
            new AxeItem(ModToolMaterials.XAENON, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.XAENON, 6, -3.2f))));
    public static final Item XAENON_HOE = registerItem("xaenon_hoe",
            new HoeItem(ModToolMaterials.XAENON, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.XAENON, 0, -3f))));


    public static final Item XAENON_HELMET = registerItem("xaenon_helmet",
            new ArmorItem(ModArmorMaterials.XAENON_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item XAENON_CHESTPLATE = registerItem("xaenon_chestplate",
            new ArmorItem(ModArmorMaterials.XAENON_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item XAENON_LEGGINGS = registerItem("xaenon_leggings",
            new ArmorItem(ModArmorMaterials.XAENON_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item XAENON_BOOTS = registerItem("xaenon_boots",
            new ArmorItem(ModArmorMaterials.XAENON_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    // Sword: slightly less bonus damage than diamond (diamond: 3)
    public static final Item ARTIFICIAL_DIAMOND_SWORD = registerItem("artificial_diamond_sword",
            new SwordItem(ModToolMaterials.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ARTIFICIAL_DIAMOND,
                            2, -2.4f))));

    // Pickaxe: slightly lower bonus damage (diamond: 1)
    public static final Item ARTIFICIAL_DIAMOND_PICKAXE = registerItem("artificial_diamond_pickaxe",
            new PickaxeItem(ModToolMaterials.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ARTIFICIAL_DIAMOND,
                            0.5f, -2.9f))));

    // Shovel: slightly lower damage (diamond: 1.5)
    public static final Item ARTIFICIAL_DIAMOND_SHOVEL = registerItem("artificial_diamond_shovel",
            new ShovelItem(ModToolMaterials.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ARTIFICIAL_DIAMOND,
                            1.0f, -3.0f))));

    public static final Item ARTIFICIAL_DIAMOND_AXE = registerItem("artificial_diamond_axe",
            new AxeItem(ModToolMaterials.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ARTIFICIAL_DIAMOND,
                            5.0f, -3.2f))));

    public static final Item ARTIFICIAL_DIAMOND_HOE = registerItem("artificial_diamond_hoe",
            new HoeItem(ModToolMaterials.ARTIFICIAL_DIAMOND, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ARTIFICIAL_DIAMOND,
                            -0.5f, -3.2f))));

    public static final Item ARTIFICIAL_DIAMOND_HELMET = registerItem("artificial_diamond_helmet",
            new ArmorItem(ModArmorMaterials.ARTIFICIAL_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(28))));

    public static final Item ARTIFICIAL_DIAMOND_CHESTPLATE = registerItem("artificial_diamond_chestplate",
            new ArmorItem(ModArmorMaterials.ARTIFICIAL_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(28))));

    public static final Item ARTIFICIAL_DIAMOND_LEGGINGS = registerItem("artificial_diamond_leggings",
            new ArmorItem(ModArmorMaterials.ARTIFICIAL_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(28))));

    public static final Item ARTIFICIAL_DIAMOND_BOOTS = registerItem("artificial_diamond_boots",
            new ArmorItem(ModArmorMaterials.ARTIFICIAL_DIAMOND_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(28))));


    public static final Item OAK_BARK = registerItem("oak_bark", new Item(new Item.Settings()));
    public static final Item BIRCH_BARK = registerItem("birch_bark", new Item(new Item.Settings()));
    public static final Item SPRUCE_BARK = registerItem("spruce_bark", new Item(new Item.Settings()));
    public static final Item DARK_OAK_BARK = registerItem("dark_oak_bark", new Item(new Item.Settings()));
    public static final Item ACACIA_BARK = registerItem("acacia_bark", new Item(new Item.Settings()));
    public static final Item JUNGLE_BARK = registerItem("jungle_bark", new Item(new Item.Settings()));
    public static final Item MANGROVE_BARK = registerItem("mangrove_bark", new Item(new Item.Settings()));
    public static final Item CHERRY_BARK = registerItem("cherry_bark", new Item(new Item.Settings()));
    public static final Item WARPED_BARK = registerItem("warped_bark", new Item(new Item.Settings()));
    public static final Item CRIMSON_BARK = registerItem("crimson_bark", new Item(new Item.Settings()));
    public static final Item MAPLE_BARK = registerItem("maple_bark", new Item(new Item.Settings()));

    public static final Item POISONOUS_CARROT = registerItem("poisonous_carrot", new PoisonousCarrotItem((new Item.Settings()).food(FoodComponents.POISONOUS_POTATO)));

    public static final Item TROWEL = registerItem("trowel", new TrowelItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void load() { ContentCraft.LOGGER.info("Registering Mod Items for " + MOD_ID); }
}
