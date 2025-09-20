package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;
import xyz.glowstonelabs.contentcraft.block.woodcrate.WoodCrateBlockEntity;

@SuppressWarnings("deprecation")
public class ModBlockEntityTypes {
    public static final BlockEntityType<WoodCrateBlockEntity> WOOD_CRATE = register("wood_crate",
            FabricBlockEntityTypeBuilder.create(WoodCrateBlockEntity::new, ModBlocks.WOOD_CRATE).build());

    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ContentCraft.MOD_ID, name), type);
    }

    public static void load() {}
}
