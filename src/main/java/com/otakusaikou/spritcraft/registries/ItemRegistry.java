package com.otakusaikou.spritcraft.registries;

import com.otakusaikou.spritcraft.groups.ModGroup;
import com.otakusaikou.spritcraft.utils.ModConstants;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    private static final Item.Properties DEFAULT_PROPERTIES = new Item.Properties().group(ModGroup.DEFAULT_GROUP);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ModConstants.MOD_ID);
    public static final RegistryObject<Item> metalCrystal = ITEMS.register("metal_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> woodenCrystal = ITEMS.register("wooden_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> waterCrystal = ITEMS.register("water_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> fireCrystal = ITEMS.register("fire_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> earthCrystal = ITEMS.register("earth_crystal", () -> new Item(DEFAULT_PROPERTIES));
}
