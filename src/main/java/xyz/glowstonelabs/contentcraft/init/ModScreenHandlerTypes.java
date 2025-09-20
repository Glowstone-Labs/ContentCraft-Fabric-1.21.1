package xyz.glowstonelabs.contentcraft.init;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import xyz.glowstonelabs.contentcraft.ContentCraft;
import xyz.glowstonelabs.contentcraft.block.woodcrate.WoodCrateScreenHandler;
import xyz.glowstonelabs.contentcraft.network.BlockPosPayload;

public class ModScreenHandlerTypes {
    public static final ScreenHandlerType<WoodCrateScreenHandler> WOOD_CRATE =
            register("wood_crate", WoodCrateScreenHandler::new, BlockPosPayload.PACKET_CODEC);

    public static <T extends ScreenHandler, D extends CustomPayload> ExtendedScreenHandlerType<T, D> register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(ContentCraft.MOD_ID, name), new ExtendedScreenHandlerType<>(factory, codec));
    }

    public static void load() {}
}
