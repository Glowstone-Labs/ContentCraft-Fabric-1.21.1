package xyz.glowstonelabs.contentcraft.Item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

import java.util.HashMap;
import java.util.Map;

public class BarkItem extends Item {
    private final Map<Block, Block> barkMap;

    public BarkItem(Settings settings, Map<Block, Block> barkMap) {
        super(settings);
        this.barkMap = Map.copyOf(barkMap); // Make immutable copy
    }

    public Map<Block, Block> getBarkMap() {
        return barkMap;
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