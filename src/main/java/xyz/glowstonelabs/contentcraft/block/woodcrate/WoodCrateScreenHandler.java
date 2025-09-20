package xyz.glowstonelabs.contentcraft.block.woodcrate;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import xyz.glowstonelabs.contentcraft.init.ModBlocks;
import xyz.glowstonelabs.contentcraft.init.ModScreenHandlerTypes;
import xyz.glowstonelabs.contentcraft.network.BlockPosPayload;

public class WoodCrateScreenHandler extends ScreenHandler {
    private final WoodCrateBlockEntity blockEntity;
    private final ScreenHandlerContext context;

    // Client Constructor
    public WoodCrateScreenHandler(int syncId, PlayerInventory playerInventory, BlockPosPayload payload) {
        this(syncId, playerInventory, (WoodCrateBlockEntity) playerInventory.player.getWorld().getBlockEntity(payload.pos()), new SimpleInventory(5));
    }

    // Main Constructor - (Directly called from server)
    public WoodCrateScreenHandler(int syncId, PlayerInventory playerInventory, WoodCrateBlockEntity blockEntity, SimpleInventory inventory) {
        super(ModScreenHandlerTypes.WOOD_CRATE, syncId);

        this.blockEntity = blockEntity;
        this.context = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());

        for (int i = 0; i < 5; i++) {
            addSlot(new Slot(inventory, i, 44 + (i * 18), 20));
        }

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    private void addPlayerInventory(PlayerInventory playerInv) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + (column + (row * 9)), 8 + (column * 18), 51 + (row * 18)));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInv) {
        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, 8 + (column * 18), 109));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, ModBlocks.WOOD_CRATE);
    }

    public WoodCrateBlockEntity getBlockEntity() {
        return this.blockEntity;
    }
}
