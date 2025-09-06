package xyz.glowstonelabs.contentcraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class RankerBlock extends Block {
    public static final EnumProperty<Tier> TIER = EnumProperty.of("tier", Tier.class);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public RankerBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(
                this.stateManager.getDefaultState()
                        .with(TIER, Tier.S)
                        .with(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TIER, FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }



    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos,
                                 PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            Tier current = state.get(TIER);
            Tier next = current.next();
            world.setBlockState(pos, state.with(TIER, next), Block.NOTIFY_ALL);
            player.sendMessage(Text.literal("Tier: " + next.asString().toUpperCase()), true);
        }
        return ActionResult.SUCCESS;
    }

    public enum Tier implements StringIdentifiable {
        S("s"), A("a"), B("b"), C("c"), D("d");

        private final String name;

        Tier(String name) {
            this.name = name;
        }

        @Override
        public String asString() {
            return name;
        }

        public Tier next() {
            return switch (this) {
                case S -> A;
                case A -> B;
                case B -> C;
                case C -> D;
                case D -> S;
            };
        }
    }
}
