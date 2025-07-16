package xyz.glowstonelabs.contentcraft.Item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PoisonousCarrotItem extends Item {
    public PoisonousCarrotItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient) {
            // Apply Poison effect (same as Poisonous Potato)
            user.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.POISON, // Effect
                    100,  // Duration (5 seconds, since 20 ticks = 1 second)
                    0     // Amplifier (0 = base level)
            ));
        }
        return super.finishUsing(stack, world, user);
    }

    public boolean canPlantOn(BlockState state) {
        return false; // Prevents villagers from planting it
    }
}