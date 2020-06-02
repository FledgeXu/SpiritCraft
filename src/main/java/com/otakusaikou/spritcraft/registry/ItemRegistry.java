package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.group.ModGroup;
import com.otakusaikou.spritcraft.item.Spiriter;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ModConstants.MOD_ID);
    private static final Item.Properties DEFAULT_PROPERTIES = new Item.Properties().group(ModGroup.DEFAULT_GROUP);
    public static final RegistryObject<Item> metalCrystal = ITEMS.register("metal_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> woodenCrystal = ITEMS.register("wooden_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> waterCrystal = ITEMS.register("water_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> fireCrystal = ITEMS.register("fire_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> earthCrystal = ITEMS.register("earth_crystal", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> spiriter = ITEMS.register("spiriter", () -> new Spiriter(DEFAULT_PROPERTIES));
}
