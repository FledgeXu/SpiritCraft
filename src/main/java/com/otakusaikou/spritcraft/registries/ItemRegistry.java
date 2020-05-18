package com.otakusaikou.spritcraft.registries;

import com.otakusaikou.spritcraft.utils.ModConstants;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ModConstants.MOD_ID);
}
