package xyz.glowstonelabs.contentcraft.mixin.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Mixin(AxeItem.class)
public class AxeItemMixin {

    @Unique
    private static Map<Block, Item> logToBarkMap;
    @Unique
    private static Map<Block, Item> woodToBarkMap;

    @Unique
    private static void ensureMapsInitialized() {
        if (logToBarkMap != null && woodToBarkMap != null) return;

        Map<Block, Item> logs = new HashMap<>();
        Map<Block, Item> woods = new HashMap<>();

        // Logs
        logs.put(Blocks.OAK_LOG, ModItems.OAK_BARK);
        logs.put(Blocks.SPRUCE_LOG, ModItems.SPRUCE_BARK);
        logs.put(Blocks.BIRCH_LOG, ModItems.BIRCH_BARK);
        logs.put(Blocks.JUNGLE_LOG, ModItems.JUNGLE_BARK);
        logs.put(Blocks.ACACIA_LOG, ModItems.ACACIA_BARK);
        logs.put(Blocks.DARK_OAK_LOG, ModItems.DARK_OAK_BARK);
        logs.put(Blocks.MANGROVE_LOG, ModItems.MANGROVE_BARK);
        logs.put(Blocks.CHERRY_LOG, ModItems.CHERRY_BARK);
        logs.put(Blocks.CRIMSON_STEM, ModItems.CRIMSON_BARK);
        logs.put(Blocks.WARPED_STEM, ModItems.WARPED_BARK);
        logs.put(ModBlocks.MAPLE_LOG, ModItems.MAPLE_BARK); // safe now

        // Woods
        woods.put(Blocks.OAK_WOOD, ModItems.OAK_BARK);
        woods.put(Blocks.SPRUCE_WOOD, ModItems.SPRUCE_BARK);
        woods.put(Blocks.BIRCH_WOOD, ModItems.BIRCH_BARK);
        woods.put(Blocks.JUNGLE_WOOD, ModItems.JUNGLE_BARK);
        woods.put(Blocks.ACACIA_WOOD, ModItems.ACACIA_BARK);
        woods.put(Blocks.DARK_OAK_WOOD, ModItems.DARK_OAK_BARK);
        woods.put(Blocks.MANGROVE_WOOD, ModItems.MANGROVE_BARK);
        woods.put(Blocks.CHERRY_WOOD, ModItems.CHERRY_BARK);
        woods.put(Blocks.CRIMSON_HYPHAE, ModItems.CRIMSON_BARK);
        woods.put(Blocks.WARPED_HYPHAE, ModItems.WARPED_BARK);
        woods.put(ModBlocks.MAPLE_WOOD, ModItems.MAPLE_BARK); // safe now

        logToBarkMap = Collections.unmodifiableMap(logs);
        woodToBarkMap = Collections.unmodifiableMap(woods);
    }

    @Inject(method = "tryStrip", at = @At("RETURN"))
    private void dropBarkOnStrip(World world, BlockPos pos, PlayerEntity player, BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir) {
        Optional<BlockState> strippedState = cir.getReturnValue();
        if (strippedState.isPresent() && !world.isClient) {
            ensureMapsInitialized(); // <-- Important!

            Block block = state.getBlock();

            if (logToBarkMap.containsKey(block)) {
                Block.dropStack(world, pos, new ItemStack(logToBarkMap.get(block), 1));
            } else if (woodToBarkMap.containsKey(block)) {
                Block.dropStack(world, pos, new ItemStack(woodToBarkMap.get(block), 2));
            }
        }
    }
}
