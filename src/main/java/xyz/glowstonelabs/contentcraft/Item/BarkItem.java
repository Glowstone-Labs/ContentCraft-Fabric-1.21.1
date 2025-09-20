package xyz.glowstonelabs.contentcraft.Item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

import static net.minecraft.block.Block.dropStack;

public class BarkItem extends Item {
    private final Map<Block, Block> barkMap;

    public BarkItem(Settings settings, Map<Block, Block> barkMap) {
        super(settings);
        this.barkMap = Map.copyOf(barkMap); // Make immutable copy
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()) {
            return ActionResult.PASS;
        }

        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        Block targetBlock = state.getBlock();

        // Check if the targeted block is in our bark map
        if (barkMap.containsKey(targetBlock)) {
            Block replacementBlock = barkMap.get(targetBlock);
            context.getWorld().setBlockState(
                    context.getBlockPos(),
                    replacementBlock.getStateWithProperties(state)
            );

            if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                context.getStack().decrement(1);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }
}