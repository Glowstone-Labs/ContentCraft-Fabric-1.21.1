package xyz.glowstonelabs.contentcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.ArmorItem;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        
        BlockStateModelGenerator.BlockTexturePool mapleWoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAPLE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.XAENON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_XAENON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.XAENON_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.MAPLE_LOG).log(ModBlocks.MAPLE_LOG).wood(ModBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAPLE_LOG).log(ModBlocks.STRIPPED_MAPLE_LOG).wood(ModBlocks.STRIPPED_MAPLE_WOOD);

        blockStateModelGenerator.registerSingleton(ModBlocks.MAPLE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


        mapleWoodPool.stairs(ModBlocks.MAPLE_STAIRS);
        mapleWoodPool.slab(ModBlocks.MAPLE_SLAB);

        mapleWoodPool.button(ModBlocks.MAPLE_BUTTON);
        mapleWoodPool.pressurePlate(ModBlocks.MAPLE_PRESSURE_PLATE);

        mapleWoodPool.fence(ModBlocks.MAPLE_FENCE);
        mapleWoodPool.fenceGate(ModBlocks.MAPLE_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.MAPLE_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.MAPLE_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.XAENON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_XAENON, Models.GENERATED);


        itemModelGenerator.register(ModItems.XAENON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.XAENON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.XAENON_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.XAENON_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.XAENON_HOE, Models.HANDHELD);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.XAENON_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.XAENON_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.XAENON_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.XAENON_BOOTS));
    }
}
