package com.otakusaikou.spritcraft.network;

import com.otakusaikou.spritcraft.gui.hud.ChunkSpiritHud;
import com.otakusaikou.spritcraft.spirit.Spirit;
import com.otakusaikou.spritcraft.spirit.SpiritLimit;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SpiritHubNetworkPack {
    private Spirit spirit;
    private SpiritLimit spiritLimit;

    public SpiritHubNetworkPack(PacketBuffer buffer) {
        this.spirit = new Spirit();
        this.spiritLimit = new SpiritLimit();
        bufferToSpirit(buffer, spirit);
        bufferToSpirit(buffer, spiritLimit);
    }

    private void bufferToSpirit(PacketBuffer buffer, Spirit spirit) {
        spirit.setMetal(buffer.readInt());
        spirit.setWooden(buffer.readInt());
        spirit.setWater(buffer.readInt());
        spirit.setFire(buffer.readInt());
        spirit.setEarth(buffer.readInt());
    }

    public SpiritHubNetworkPack(Spirit spirit, SpiritLimit spiritLimit) {
        this.spirit = spirit;
        this.spiritLimit = spiritLimit;
    }

    public void toBytes(PacketBuffer buf) {
        spiritToBuffer(buf, this.spirit);
        spiritToBuffer(buf, this.spiritLimit);
    }

    private void spiritToBuffer(PacketBuffer buffer, Spirit spirit) {
        buffer.writeInt(spirit.getMetal());
        buffer.writeInt(spirit.getWooden());
        buffer.writeInt(spirit.getWater());
        buffer.writeInt(spirit.getFire());
        buffer.writeInt(spirit.getEarth());
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ChunkSpiritHud.spirit = this.spirit;
            ChunkSpiritHud.spiritLimit = this.spiritLimit;
        });
        ctx.get().setPacketHandled(true);
    }
}
