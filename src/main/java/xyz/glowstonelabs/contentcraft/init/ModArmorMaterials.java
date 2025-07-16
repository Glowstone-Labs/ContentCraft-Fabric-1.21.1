package xyz.glowstonelabs.contentcraft.init;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import xyz.glowstonelabs.contentcraft.ContentCraft;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * Class to define and register custom armor materials for the mod.
 * Armor materials define durability, protection, enchantability, equip sounds, repair materials, etc.
 */
public class ModArmorMaterials {

    /**
     * XAENON_ARMOR_MATERIAL defines the custom armor material "xaenon" with specific stats.
     * Uses an EnumMap to set protection values per armor piece (boots, leggings, chestplate, helmet).
     * Sets durability, equip sound, repair ingredient, texture layers, and other properties.
     */
    public static final RegistryEntry<ArmorMaterial> XAENON_ARMOR_MATERIAL =
            registerArmorMaterial("xaenon",
                    () -> new ArmorMaterial(
                            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                                // Protection values for each armor piece
                                map.put(ArmorItem.Type.BOOTS, 2);
                                map.put(ArmorItem.Type.LEGGINGS, 4);
                                map.put(ArmorItem.Type.CHESTPLATE, 6);
                                map.put(ArmorItem.Type.HELMET, 2);
                                map.put(ArmorItem.Type.BODY, 4); // Additional body part? (may not be used)
                            }),
                            20, // Durability multiplier: affects total durability of armor pieces
                            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, // Sound played when equipping this armor
                            () -> Ingredient.ofItems(ModItems.XAENON_INGOT), // Item used to repair this armor in an anvil
                            List.of(new ArmorMaterial.Layer(Identifier.of(ContentCraft.MOD_ID,
                                    "xaenon"))), // Armor texture layer(s)
                            0, // Enchantability (higher = better enchantments)
                            0  // Toughness (reduces damage taken from attacks)
                    )
            );

    public static final RegistryEntry<ArmorMaterial> ARTIFICIAL_DIAMOND_ARMOR_MATERIAL =
            registerArmorMaterial("artificial_diamond",
                    () -> new ArmorMaterial(
                            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                                map.put(ArmorItem.Type.BOOTS, 2);        // Diamond is 3
                                map.put(ArmorItem.Type.LEGGINGS, 5);     // Diamond is 6
                                map.put(ArmorItem.Type.CHESTPLATE, 7);   // Diamond is 8
                                map.put(ArmorItem.Type.HELMET, 2);       // Diamond is 3
                            }),
                            28, // Durability multiplier (Diamond: 33)
                            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, // Optional: could keep Netherite sound if intended
                            () -> Ingredient.ofItems(ModItems.ARTIFICIAL_DIAMOND),
                            List.of(new ArmorMaterial.Layer(Identifier.of(ContentCraft.MOD_ID,
                                    "artificial_diamond"))),
                            8,  // Enchantability (Diamond is 10)
                            1   // Toughness (Diamond is 2)
                    )
            );


    /**
     * Helper method to register the armor material in Minecraft's registry.
     * This returns a RegistryEntry reference for use elsewhere.
     *
     * @param name     The identifier name of the armor material (e.g., "xaenon").
     * @param material A supplier that creates an instance of the ArmorMaterial.
     * @return A RegistryEntry for the registered armor material.
     */
    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.of(ContentCraft.MOD_ID, name),
                material.get()
        );
    }
}