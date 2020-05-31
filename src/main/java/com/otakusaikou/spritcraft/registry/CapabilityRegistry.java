package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.capability.ISpiritChunkCapability;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistry {
    @SubscribeEvent
    public static void onCapabilityRegistry(FMLCommonSetupEvent event) {
        registryCapability(ISpiritChunkCapability.class);
    }

    public static <T> void registryCapability(Class<T> clazz) {
        CapabilityManager.INSTANCE.register(
                clazz,
                new Capability.IStorage<T>() {
                    @Nullable
                    @Override
                    public INBT writeNBT(Capability<T> capability, T instance, Direction side) {
                        return null;
                    }

                    @Override
                    public void readNBT(Capability<T> capability, T instance, Direction side, INBT nbt) {

                    }
                },
                () -> null
        );
    }
}
