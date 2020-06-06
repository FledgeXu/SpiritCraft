package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.gui.SpiritFurnaceContainer;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeRegistry {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, ModConstants.MOD_ID);
    public static RegistryObject<ContainerType<SpiritFurnaceContainer>> spiritFurnaceContainer = CONTAINERS.register("spirit_furnace",
            () -> IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data)
                    -> new SpiritFurnaceContainer(windowId, inv, Minecraft.getInstance().world, data.readBlockPos())));
}
