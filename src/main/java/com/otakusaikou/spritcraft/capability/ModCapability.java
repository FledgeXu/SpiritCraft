package com.otakusaikou.spritcraft.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ModCapability {
    @CapabilityInject(ISpiritChunkCapability.class)
    public static Capability<ISpiritChunkCapability> SPIRIT_CHUNK_CAPABILITY;
}
