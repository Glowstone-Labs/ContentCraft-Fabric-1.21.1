package xyz.glowstonelabs.contentcraft.init;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;

public class ModItems {
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


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ContentCraft.MOD_ID, name), item);
    }

    public static void load() { ContentCraft.LOGGER.info("Registering Mod Items for " + ContentCraft.MOD_ID); }
}
