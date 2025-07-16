package xyz.glowstonelabs.contentcraft.init;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import xyz.glowstonelabs.contentcraft.util.ModTags;

import java.util.function.Supplier;

/**
 * Enum representing custom tool materials added by the mod.
 * Implements Minecraft's ToolMaterial interface to define behavior for tools using these materials.
 */
public enum ModToolMaterials implements ToolMaterial {

    /**
     * XAENON tool material:
     * - Uses vanilla diamond tool mining tag as a base for blocks that require diamond or better tools.
     * - Slightly better durability, mining speed, and attack damage than Netherite to make it a premium material.
     * - High enchantability for better enchantment results.
     * - Repair ingredient is the custom XAENON_INGOT item.
     */
    XAENON(
            BlockTags.NEEDS_DIAMOND_TOOL, // Blocks tagged to require diamond or better tools for mining
            2189,                          // Durability (higher than Netherite's 2031)
            10F,                           // Mining speed multiplier (Netherite is 9.0F)
            5F,                            // Base attack damage (Netherite is 4.0F)
            20,                            // Enchantability (Netherite is 15)
            () -> Ingredient.ofItems(ModItems.XAENON_INGOT) // Repair item
    ),

    /**
     * ARTIFICIAL_DIAMOND tool material:
     * - Slightly worse than vanilla diamond in durability, speed, damage, and enchantability.
     * - Meant to feel like a cheaper or synthetic version of real diamond tools.
     */
    ARTIFICIAL_DIAMOND(
            BlockTags.NEEDS_DIAMOND_TOOL,          // Still requires diamond-level mining tag
            1450,                                   // Slightly lower durability (vanilla diamond: 1561)
            7.5F,                                   // Slightly slower mining (vanilla: 8.0F)
            2.5F,                                   // Slightly lower attack damage bonus (vanilla: 3.0F)
            8,                                      // Lower enchantability (vanilla: 10)
            () -> Ingredient.ofItems(ModItems.ARTIFICIAL_DIAMOND) // Repair item
    );


    // Tag for blocks that this material is effective against
    private final TagKey<Block> inverseTag;

    // Durability of tools made from this material
    private final int itemDurability;

    // Mining speed multiplier
    private final float miningSpeed;

    // Extra attack damage
    private final float attackDamage;

    // Enchantability value
    private final int enchantability;

    // Repair ingredient (memoized for performance)
    private final Supplier<Ingredient> repairIngredient;

    /**
     * Constructor for the enum constants.
     *
     * @param inverseTag Tag for blocks requiring this level tool to mine.
     * @param itemDurability Max durability (tool life).
     * @param miningSpeed Speed multiplier for mining blocks.
     * @param attackDamage Extra attack damage.
     * @param enchantability Enchanting power.
     * @param repairIngredient Supplier returning the ingredient to repair the tool.
     */
    ModToolMaterials(final TagKey<Block> inverseTag,
                     final int itemDurability,
                     final float miningSpeed,
                     final float attackDamage,
                     final int enchantability,
                     final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    /** @return Max durability of the tool */
    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    /** @return Mining speed multiplier */
    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    /** @return Additional attack damage */
    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    /** @return Tag of blocks requiring this material to mine */
    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    /** @return Enchantability value of the tool */
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    /** @return Ingredient used for repairing this tool material */
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
