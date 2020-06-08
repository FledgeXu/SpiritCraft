package com.otakusaikou.spritcraft.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ModCapability {
    @CapabilityInject(ISpiritChunkCapability.class)
    public static Capability<ISpiritChunkCapability> SPIRIT_CHUNK_CAPABILITY;

    @CapabilityInject(ISpiritContainerCapability.class)
    public static Capability<ISpiritContainerCapability> SPIRIT_CONTAINER_CAPABILITY;
}
