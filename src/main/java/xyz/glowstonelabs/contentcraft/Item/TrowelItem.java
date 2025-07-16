package xyz.glowstonelabs.contentcraft.Item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrowelItem extends Item {

    public TrowelItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if (player == null) return ActionResult.PASS;

        // Get all valid blocks from hotbar
        List<ItemStack> placeableBlocks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (isPlaceable(stack)) {
                placeableBlocks.add(stack);
            }
        }

        if (placeableBlocks.isEmpty()) {
            return ActionResult.CONSUME_PARTIAL;
        }

        // Select random block from hotbar
        Random random = new Random();
        ItemStack selectedStack = placeableBlocks.get(random.nextInt(placeableBlocks.size()));
        BlockItem selectedBlockItem = (BlockItem) selectedStack.getItem();

        // Simulate right-click with the selected block
        ItemStack savedHeldItem = player.getStackInHand(context.getHand());
        player.setStackInHand(context.getHand(), selectedStack);

        // Raycast to find where to place the block
        BlockHitResult hitResult = Item.raycast(context.getWorld(), player, RaycastContext.FluidHandling.NONE);
        BlockPos placementPos = hitResult.getBlockPos().offset(hitResult.getSide());

        ActionResult result = selectedBlockItem.useOnBlock(new ItemUsageContext(
                player,
                context.getHand(),
                hitResult
        ));

        // Restore original item in hand
        player.setStackInHand(context.getHand(), savedHeldItem);

        // Damage the trowel if successful
        if (result.isAccepted() && !player.isCreative()) {
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
        }

        return result;
    }

    private boolean isPlaceable(ItemStack stack) {
        if (stack.isEmpty()) return false;
        return stack.getItem() instanceof BlockItem;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Allow both right-click air and right-click block
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}