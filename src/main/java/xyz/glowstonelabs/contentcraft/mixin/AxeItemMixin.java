package xyz.glowstonelabs.contentcraft.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;

import java.util.*;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin {
    @Unique
    private static final int LOG_BARK_DROP_COUNT = 1;
    @Unique
    private static final int WOOD_BARK_DROP_COUNT = 4;

    @Unique
    private static Map<Block, Item> barkDropMap;

    @Unique
    private static Map<Block, Item> getBarkDropMap() {
        if (barkDropMap == null) {
            Map<Block, Item> map = new HashMap<>();

            // Logs
            map.put(Blocks.OAK_LOG, ModItems.OAK_BARK);
            map.put(Blocks.SPRUCE_LOG, ModItems.SPRUCE_BARK);
            map.put(Blocks.BIRCH_LOG, ModItems.BIRCH_BARK);
            map.put(Blocks.JUNGLE_LOG, ModItems.JUNGLE_BARK);
            map.put(Blocks.ACACIA_LOG, ModItems.ACACIA_BARK);
            map.put(Blocks.DARK_OAK_LOG, ModItems.DARK_OAK_BARK);
            map.put(Blocks.MANGROVE_LOG, ModItems.MANGROVE_BARK);
            map.put(Blocks.CHERRY_LOG, ModItems.CHERRY_BARK);
            map.put(Blocks.CRIMSON_STEM, ModItems.CRIMSON_BARK);
            map.put(Blocks.WARPED_STEM, ModItems.WARPED_BARK);
            map.put(ModBlocks.MAPLE_LOG, ModItems.MAPLE_BARK);

            // Wood
            map.put(Blocks.OAK_WOOD, ModItems.OAK_BARK);
            map.put(Blocks.SPRUCE_WOOD, ModItems.SPRUCE_BARK);
            map.put(Blocks.BIRCH_WOOD, ModItems.BIRCH_BARK);
            map.put(Blocks.JUNGLE_WOOD, ModItems.JUNGLE_BARK);
            map.put(Blocks.ACACIA_WOOD, ModItems.ACACIA_BARK);
            map.put(Blocks.DARK_OAK_WOOD, ModItems.DARK_OAK_BARK);
            map.put(Blocks.MANGROVE_WOOD, ModItems.MANGROVE_BARK);
            map.put(Blocks.CHERRY_WOOD, ModItems.CHERRY_BARK);
            map.put(Blocks.CRIMSON_HYPHAE, ModItems.CRIMSON_BARK);
            map.put(Blocks.WARPED_HYPHAE, ModItems.WARPED_BARK);
            map.put(ModBlocks.MAPLE_WOOD, ModItems.MAPLE_BARK);

            barkDropMap = Collections.unmodifiableMap(map);
        }
        return barkDropMap;
    }

    @Inject(
            method = "tryStrip",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"
            )
    )
    private void handleBarkDrops(World world, BlockPos pos, PlayerEntity player, BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir) {
        if (world.isClient()) return;

        Block block = state.getBlock();
        Item barkItem = getBarkDropMap().get(block);

        if (barkItem != null) {
            // Determine drop count based on block type
            boolean isWood = block == Blocks.OAK_WOOD || block == Blocks.SPRUCE_WOOD ||
                    block == Blocks.BIRCH_WOOD || block == Blocks.JUNGLE_WOOD ||
                    block == Blocks.ACACIA_WOOD || block == Blocks.DARK_OAK_WOOD ||
                    block == Blocks.MANGROVE_WOOD || block == Blocks.CHERRY_WOOD ||
                    block == Blocks.CRIMSON_HYPHAE || block == Blocks.WARPED_HYPHAE ||
                    block == ModBlocks.MAPLE_WOOD;

            int dropCount = isWood ? WOOD_BARK_DROP_COUNT : LOG_BARK_DROP_COUNT;

            // Calculate spawn position
            Vec3d spawnPos = player != null
                    ? player.raycast(8, 0, false).getPos()
                    : Vec3d.ofCenter(pos);

            // Create and spawn item entity
            ItemEntity itemEntity = new ItemEntity(
                    world,
                    spawnPos.x,
                    spawnPos.y,
                    spawnPos.z,
                    new ItemStack(barkItem, dropCount)
            );
            world.spawnEntity(itemEntity);
        }
    }
}