package xyz.glowstonelabs.contentcraft.init;

import net.minecraft.component.type.FoodComponent;

public class ModFoods {
    public static final FoodComponent BOILED_EGG_COMPONENT = new FoodComponent.Builder().nutrition(1).saturationModifier(0.5F).build();

    public static final FoodComponent BLUEBERRY_COMPONENT = new FoodComponent.Builder().nutrition(2).saturationModifier(0.15f)
            .snack().build();}
