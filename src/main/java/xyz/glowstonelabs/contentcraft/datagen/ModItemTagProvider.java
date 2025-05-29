package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
//                .add(ModItems.PINK_GARNET)
//                .add(ModItems.RAW_PINK_GARNET)
//                .add(Items.COAL)
//                .add(Items.STICK)
//                .add(Items.APPLE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.XAENON_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.XAENON_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.XAENON_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.XAENON_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.XAENON_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.XAENON_HELMET)
                .add(ModItems.XAENON_CHESTPLATE)
                .add(ModItems.XAENON_LEGGINGS)
                .add(ModItems.XAENON_BOOTS);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAPLE_LOG.asItem())
                .add(ModBlocks.MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_MAPLE_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.MAPLE_PLANKS.asItem());
    }
}
