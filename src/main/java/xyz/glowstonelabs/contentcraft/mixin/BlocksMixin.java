package xyz.glowstonelabs.contentcraft.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchflowerBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;
import xyz.glowstonelabs.contentcraft.util.Configs.ModConfigs;

@Mixin(value = Blocks.class, priority = 1001) // What doest this do again?
public abstract class BlocksMixin {

    @ModifyExpressionValue(method = "<clinit>",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;create()Lnet/minecraft/block/AbstractBlock$Settings;",
                    ordinal = 0),
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=torchflower")),
            require = 0) // Set require to 0 to make this optional
    private static AbstractBlock.Settings modifyTorchflower(AbstractBlock.Settings original) {
        if (!ModConfigs.CONFIG.torchflowerConfig.enabled) {
            return original;
        }
        return original.luminance(blockState -> ModConfigs.CONFIG.torchflowerConfig.brightness);
    }

    @ModifyExpressionValue(method = "createFlowerPotBlock(Lnet/minecraft/block/Block;)Lnet/minecraft/block/Block;",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;create()Lnet/minecraft/block/AbstractBlock$Settings;",
                    ordinal = 0),
            require = 0)
    private static AbstractBlock.Settings modifyPottedTorchflower(AbstractBlock.Settings original, Block block) {
        if (ModConfigs.CONFIG.torchflowerConfig.enabled && block == Blocks.TORCHFLOWER) {
            return original.luminance(blockState -> ModConfigs.CONFIG.torchflowerConfig.potBrightness);
        }
        return original;
    }

    @ModifyExpressionValue(method = "<clinit>",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/block/AbstractBlock$Settings;create()Lnet/minecraft/block/AbstractBlock$Settings;",
                    ordinal = 0),
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=torchflower_crop")),
            require = 0)
    private static AbstractBlock.Settings modifyTorchflowerCrop(AbstractBlock.Settings original) {
        if (!ModConfigs.CONFIG.torchflowerConfig.enabled) {
            return original;
        }

        return original.luminance(blockState -> switch (blockState.get(TorchflowerBlock.AGE)) {
            case 0 -> ModConfigs.CONFIG.torchflowerConfig.stage1Brightness;
            case 1 -> ModConfigs.CONFIG.torchflowerConfig.stage2Brightness;
            default -> ModConfigs.CONFIG.torchflowerConfig.brightness;
        });
    }
}