package com.otakusaikou.spritcraft.network;

import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class HubChannel {
    public static SimpleChannel INSTANCE;
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(ModConstants.MOD_ID, "hud_channel"),
                () -> "1.0",
                (s) -> true,
                (s) -> true
        );
        INSTANCE.registerMessage(
                nextID(),
                SpiritHubNetworkPack.class,
                SpiritHubNetworkPack::toBytes,
                SpiritHubNetworkPack::new,
                SpiritHubNetworkPack::handler
        );
    }
}
