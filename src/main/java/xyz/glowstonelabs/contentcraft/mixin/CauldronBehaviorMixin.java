package xyz.glowstonelabs.contentcraft.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(CauldronBehavior.class)
public interface CauldronBehaviorMixin {
    //this doenst work in creative T_T why is it so fucking hard, it like duplicates shit dude jsut make it easy devs T_T 🔪🔫🩸
    @Inject(method = "registerBehavior", at = @At("TAIL"))
    private static void registerWashingBehavior(CallbackInfo ci) {
        final boolean[] sentMessage = {false};
        Map<Item, CauldronBehavior> waterBehaviors = CauldronBehavior.WATER_CAULDRON_BEHAVIOR.map();

        CauldronBehavior WASH_DYEABLE_BLOCK = (state, world, pos, player, hand, stack) -> {
            Item item = stack.getItem();
            Item whiteVariant = getWhiteVariant(item);

            // Special case for firework stars
            if (item.toString().toLowerCase().contains("firework_star")) {
                if (!world.isClient) {
                    world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2.0f, World.ExplosionSourceType.NONE);
                    LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                    stack.decrement(1);
                    world.playSound(player, pos, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.emitGameEvent(null, GameEvent.EXPLODE, pos);
                }
                return ItemActionResult.success(world.isClient);
            }

            if (whiteVariant == null) {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }

            if (!world.isClient) {
                if (player.isCreative()) {
                    if (!sentMessage[0]) {
                        player.sendMessage(Text.of(
                                        "§e§l[ContentCraft Warning]§r" +
                                                "§f Please Note that cauldron washing is very buggy in creative mode," +
                                                " but works as intended in survival!"),
                                false);
                        sentMessage[0] = true;
                    }
                    ItemStack whiteStack = new ItemStack(whiteVariant, stack.getCount());
                    if (!player.giveItemStack(whiteStack)) {
                        player.dropItem(whiteStack, false);
                    }
                } else {
                    ItemStack whiteStack = new ItemStack(whiteVariant, stack.getCount());
                    player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, whiteStack));
                    LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                }

                player.incrementStat(Stats.CLEAN_ARMOR);
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
            }

            return ItemActionResult.success(world.isClient);
        };

        registerColoredBlocks(waterBehaviors, WASH_DYEABLE_BLOCK);
    }

    @Unique
    private static void registerColoredBlocks(Map<Item, CauldronBehavior> behaviors, CauldronBehavior behavior) {
        // Wool
        behaviors.put(Items.RED_WOOL, behavior);
        behaviors.put(Items.ORANGE_WOOL, behavior);
        behaviors.put(Items.YELLOW_WOOL, behavior);
        behaviors.put(Items.LIME_WOOL, behavior);
        behaviors.put(Items.GREEN_WOOL, behavior);
        behaviors.put(Items.CYAN_WOOL, behavior);
        behaviors.put(Items.LIGHT_BLUE_WOOL, behavior);
        behaviors.put(Items.BLUE_WOOL, behavior);
        behaviors.put(Items.PURPLE_WOOL, behavior);
        behaviors.put(Items.MAGENTA_WOOL, behavior);
        behaviors.put(Items.PINK_WOOL, behavior);
        behaviors.put(Items.BROWN_WOOL, behavior);
        behaviors.put(Items.GRAY_WOOL, behavior);
        behaviors.put(Items.LIGHT_GRAY_WOOL, behavior);
        behaviors.put(Items.BLACK_WOOL, behavior);

        // Terracotta
        behaviors.put(Items.RED_TERRACOTTA, behavior);
        behaviors.put(Items.ORANGE_TERRACOTTA, behavior);
        behaviors.put(Items.YELLOW_TERRACOTTA, behavior);
        behaviors.put(Items.LIME_TERRACOTTA, behavior);
        behaviors.put(Items.GREEN_TERRACOTTA, behavior);
        behaviors.put(Items.CYAN_TERRACOTTA, behavior);
        behaviors.put(Items.LIGHT_BLUE_TERRACOTTA, behavior);
        behaviors.put(Items.BLUE_TERRACOTTA, behavior);
        behaviors.put(Items.PURPLE_TERRACOTTA, behavior);
        behaviors.put(Items.MAGENTA_TERRACOTTA, behavior);
        behaviors.put(Items.PINK_TERRACOTTA, behavior);
        behaviors.put(Items.BROWN_TERRACOTTA, behavior);
        behaviors.put(Items.GRAY_TERRACOTTA, behavior);
        behaviors.put(Items.LIGHT_GRAY_TERRACOTTA, behavior);
        behaviors.put(Items.BLACK_TERRACOTTA, behavior);
        behaviors.put(Items.WHITE_TERRACOTTA, behavior);

        // Stained Glass
        behaviors.put(Items.RED_STAINED_GLASS, behavior);
        behaviors.put(Items.ORANGE_STAINED_GLASS, behavior);
        behaviors.put(Items.YELLOW_STAINED_GLASS, behavior);
        behaviors.put(Items.LIME_STAINED_GLASS, behavior);
        behaviors.put(Items.GREEN_STAINED_GLASS, behavior);
        behaviors.put(Items.CYAN_STAINED_GLASS, behavior);
        behaviors.put(Items.LIGHT_BLUE_STAINED_GLASS, behavior);
        behaviors.put(Items.BLUE_STAINED_GLASS, behavior);
        behaviors.put(Items.PURPLE_STAINED_GLASS, behavior);
        behaviors.put(Items.MAGENTA_STAINED_GLASS, behavior);
        behaviors.put(Items.PINK_STAINED_GLASS, behavior);
        behaviors.put(Items.BROWN_STAINED_GLASS, behavior);
        behaviors.put(Items.GRAY_STAINED_GLASS, behavior);
        behaviors.put(Items.LIGHT_GRAY_STAINED_GLASS, behavior);
        behaviors.put(Items.BLACK_STAINED_GLASS, behavior);

        // Stained Glass Panes
        behaviors.put(Items.RED_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.ORANGE_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.YELLOW_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.LIME_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.GREEN_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.CYAN_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.LIGHT_BLUE_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.BLUE_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.PURPLE_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.MAGENTA_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.PINK_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.BROWN_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.GRAY_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.LIGHT_GRAY_STAINED_GLASS_PANE, behavior);
        behaviors.put(Items.BLACK_STAINED_GLASS_PANE, behavior);

        // Candles
        behaviors.put(Items.RED_CANDLE, behavior);
        behaviors.put(Items.ORANGE_CANDLE, behavior);
        behaviors.put(Items.YELLOW_CANDLE, behavior);
        behaviors.put(Items.LIME_CANDLE, behavior);
        behaviors.put(Items.GREEN_CANDLE, behavior);
        behaviors.put(Items.CYAN_CANDLE, behavior);
        behaviors.put(Items.LIGHT_BLUE_CANDLE, behavior);
        behaviors.put(Items.BLUE_CANDLE, behavior);
        behaviors.put(Items.PURPLE_CANDLE, behavior);
        behaviors.put(Items.MAGENTA_CANDLE, behavior);
        behaviors.put(Items.PINK_CANDLE, behavior);
        behaviors.put(Items.BROWN_CANDLE, behavior);
        behaviors.put(Items.GRAY_CANDLE, behavior);
        behaviors.put(Items.LIGHT_GRAY_CANDLE, behavior);
        behaviors.put(Items.BLACK_CANDLE, behavior);
        behaviors.put(Items.WHITE_CANDLE, behavior);

        // Concrete
        behaviors.put(Items.RED_CONCRETE, behavior);
        behaviors.put(Items.ORANGE_CONCRETE, behavior);
        behaviors.put(Items.YELLOW_CONCRETE, behavior);
        behaviors.put(Items.LIME_CONCRETE, behavior);
        behaviors.put(Items.GREEN_CONCRETE, behavior);
        behaviors.put(Items.CYAN_CONCRETE, behavior);
        behaviors.put(Items.LIGHT_BLUE_CONCRETE, behavior);
        behaviors.put(Items.BLUE_CONCRETE, behavior);
        behaviors.put(Items.PURPLE_CONCRETE, behavior);
        behaviors.put(Items.MAGENTA_CONCRETE, behavior);
        behaviors.put(Items.PINK_CONCRETE, behavior);
        behaviors.put(Items.BROWN_CONCRETE, behavior);
        behaviors.put(Items.GRAY_CONCRETE, behavior);
        behaviors.put(Items.LIGHT_GRAY_CONCRETE, behavior);
        behaviors.put(Items.BLACK_CONCRETE, behavior);

        // Concrete Powder
        behaviors.put(Items.RED_CONCRETE_POWDER, behavior);
        behaviors.put(Items.ORANGE_CONCRETE_POWDER, behavior);
        behaviors.put(Items.YELLOW_CONCRETE_POWDER, behavior);
        behaviors.put(Items.LIME_CONCRETE_POWDER, behavior);
        behaviors.put(Items.GREEN_CONCRETE_POWDER, behavior);
        behaviors.put(Items.CYAN_CONCRETE_POWDER, behavior);
        behaviors.put(Items.LIGHT_BLUE_CONCRETE_POWDER, behavior);
        behaviors.put(Items.BLUE_CONCRETE_POWDER, behavior);
        behaviors.put(Items.PURPLE_CONCRETE_POWDER, behavior);
        behaviors.put(Items.MAGENTA_CONCRETE_POWDER, behavior);
        behaviors.put(Items.PINK_CONCRETE_POWDER, behavior);
        behaviors.put(Items.BROWN_CONCRETE_POWDER, behavior);
        behaviors.put(Items.GRAY_CONCRETE_POWDER, behavior);
        behaviors.put(Items.LIGHT_GRAY_CONCRETE_POWDER, behavior);
        behaviors.put(Items.BLACK_CONCRETE_POWDER, behavior);

        // Beds
        behaviors.put(Items.RED_BED, behavior);
        behaviors.put(Items.ORANGE_BED, behavior);
        behaviors.put(Items.YELLOW_BED, behavior);
        behaviors.put(Items.LIME_BED, behavior);
        behaviors.put(Items.GREEN_BED, behavior);
        behaviors.put(Items.CYAN_BED, behavior);
        behaviors.put(Items.LIGHT_BLUE_BED, behavior);
        behaviors.put(Items.BLUE_BED, behavior);
        behaviors.put(Items.PURPLE_BED, behavior);
        behaviors.put(Items.MAGENTA_BED, behavior);
        behaviors.put(Items.PINK_BED, behavior);
        behaviors.put(Items.BROWN_BED, behavior);
        behaviors.put(Items.GRAY_BED, behavior);
        behaviors.put(Items.LIGHT_GRAY_BED, behavior);
        behaviors.put(Items.BLACK_BED, behavior);

        // Carpets
        behaviors.put(Items.RED_CARPET, behavior);
        behaviors.put(Items.ORANGE_CARPET, behavior);
        behaviors.put(Items.YELLOW_CARPET, behavior);
        behaviors.put(Items.LIME_CARPET, behavior);
        behaviors.put(Items.GREEN_CARPET, behavior);
        behaviors.put(Items.CYAN_CARPET, behavior);
        behaviors.put(Items.LIGHT_BLUE_CARPET, behavior);
        behaviors.put(Items.BLUE_CARPET, behavior);
        behaviors.put(Items.PURPLE_CARPET, behavior);
        behaviors.put(Items.MAGENTA_CARPET, behavior);
        behaviors.put(Items.PINK_CARPET, behavior);
        behaviors.put(Items.BROWN_CARPET, behavior);
        behaviors.put(Items.GRAY_CARPET, behavior);
        behaviors.put(Items.LIGHT_GRAY_CARPET, behavior);
        behaviors.put(Items.BLACK_CARPET, behavior);

        // Shulker Boxes
        behaviors.put(Items.RED_SHULKER_BOX, behavior);
        behaviors.put(Items.ORANGE_SHULKER_BOX, behavior);
        behaviors.put(Items.YELLOW_SHULKER_BOX, behavior);
        behaviors.put(Items.LIME_SHULKER_BOX, behavior);
        behaviors.put(Items.GREEN_SHULKER_BOX, behavior);
        behaviors.put(Items.CYAN_SHULKER_BOX, behavior);
        behaviors.put(Items.LIGHT_BLUE_SHULKER_BOX, behavior);
        behaviors.put(Items.BLUE_SHULKER_BOX, behavior);
        behaviors.put(Items.PURPLE_SHULKER_BOX, behavior);
        behaviors.put(Items.MAGENTA_SHULKER_BOX, behavior);
        behaviors.put(Items.PINK_SHULKER_BOX, behavior);
        behaviors.put(Items.BROWN_SHULKER_BOX, behavior);
        behaviors.put(Items.GRAY_SHULKER_BOX, behavior);
        behaviors.put(Items.LIGHT_GRAY_SHULKER_BOX, behavior);
        behaviors.put(Items.BLACK_SHULKER_BOX, behavior);

        // Leather Armor
        behaviors.put(Items.LEATHER_HELMET, behavior);
        behaviors.put(Items.LEATHER_CHESTPLATE, behavior);
        behaviors.put(Items.LEATHER_LEGGINGS, behavior);
        behaviors.put(Items.LEATHER_BOOTS, behavior);

        // Firework Stars
        behaviors.put(Items.FIREWORK_STAR, behavior);
    }

    @Unique
    private static Item getWhiteVariant(Item coloredItem) {
        String itemName = coloredItem.toString().toLowerCase();

        // Wool
        if (itemName.contains("wool") && !coloredItem.equals(Items.WHITE_WOOL)) {
            return Items.WHITE_WOOL;
        }
        // Terracotta
        else if (itemName.contains("terracotta") && !coloredItem.equals(Items.TERRACOTTA) && !coloredItem.equals(Items.WHITE_TERRACOTTA)) {
            return Items.TERRACOTTA;
        }
        // Stained Glass
        else if (itemName.contains("stained_glass") && !coloredItem.equals(Items.GLASS)) {
            return Items.GLASS;
        }
        // Stained Glass Pane
        else if (itemName.contains("stained_glass_pane") && !coloredItem.equals(Items.GLASS_PANE)) {
            return Items.GLASS_PANE;
        }
        // Candles
        else if (coloredItem.equals(Items.WHITE_CANDLE)) {
            return Items.CANDLE;
        }
        else if (itemName.contains("candle") && !coloredItem.equals(Items.CANDLE) && !coloredItem.equals(Items.WHITE_CANDLE)) {
            return Items.WHITE_CANDLE;
        }
        // Concrete
        else if (itemName.contains("concrete") && !itemName.contains("powder") && !coloredItem.equals(Items.WHITE_CONCRETE)) {
            return Items.WHITE_CONCRETE;
        }
        // Concrete Powder → White Concrete
        else if (itemName.contains("concrete_powder")) {
            return Items.WHITE_CONCRETE;
        }
        // Beds → White Bed
        else if (itemName.contains("bed") && !coloredItem.equals(Items.WHITE_BED)) {
            return Items.WHITE_BED;
        }
        // Carpets → White Carpet
        else if (itemName.contains("carpet") && !coloredItem.equals(Items.WHITE_CARPET)) {
            return Items.WHITE_CARPET;
        }
        // Shulker Boxes → White Shulker Box
        else if (itemName.contains("shulker_box") && !coloredItem.equals(Items.WHITE_SHULKER_BOX)) {
            return Items.WHITE_SHULKER_BOX;
        }
        // Leather Armor → return null (no white variant in vanilla)
        else if (itemName.contains("leather_") && (itemName.contains("helmet") || itemName.contains("chestplate") ||
                itemName.contains("leggings") || itemName.contains("boots"))) {
            return null;
        }
        // Firework Stars - handled separately in the behavior
        else if (itemName.contains("firework_star")) {
            return null;
        }

        return null;
    }
}