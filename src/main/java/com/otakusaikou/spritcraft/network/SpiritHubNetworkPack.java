package com.otakusaikou.spritcraft.network;

import com.otakusaikou.spritcraft.gui.hud.ChunkSpiritHud;
import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritLimit;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SpiritHubNetworkPack {
    private final Spirit spirit;
    private final SpiritLimit spiritLimit;

    public SpiritHubNetworkPack(PacketBuffer buffer) {
        this.spirit = new Spirit();
        this.spiritLimit = new SpiritLimit();
        bufferToSpirit(buffer, spirit);
        bufferToSpirit(buffer, spiritLimit);
    }

    public SpiritHubNetworkPack(Spirit spirit, SpiritLimit spiritLimit) {
        this.spirit = spirit;
        this.spiritLimit = spiritLimit;
    }

    private void bufferToSpirit(PacketBuffer buffer, Spirit spirit) {
        spirit.metal = buffer.readInt();
        spirit.wooden = buffer.readInt();
        spirit.water = buffer.readInt();
        spirit.fire = buffer.readInt();
        spirit.earth = buffer.readInt();
    }

    public void toBytes(PacketBuffer buf) {
        spiritToBuffer(buf, this.spirit);
        spiritToBuffer(buf, this.spiritLimit);
    }

    private void spiritToBuffer(PacketBuffer buffer, Spirit spirit) {
        buffer.writeInt(spirit.metal);
        buffer.writeInt(spirit.wooden);
        buffer.writeInt(spirit.water);
        buffer.writeInt(spirit.fire);
        buffer.writeInt(spirit.earth);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ChunkSpiritHud.spirit = this.spirit;
            ChunkSpiritHud.spiritLimit = this.spiritLimit;
        });
        ctx.get().setPacketHandled(true);
    }
}
