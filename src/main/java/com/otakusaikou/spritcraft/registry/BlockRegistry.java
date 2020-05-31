package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.block.SpiritCrystalOre;
import com.otakusaikou.spritcraft.group.ModGroup;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ModConstants.MOD_ID);
    private static final Block.Properties DEFAULT_PROPERTIES = Block.Properties.create(Material.ROCK);
    private static final Item.Properties DEFAULT_BLOCK_ITEM_PROPERTIES = new Item.Properties().group(ModGroup.DEFAULT_GROUP);
    public static final RegistryObject<SpiritCrystalOre> metalCrystalOre = registryWithItem("metal_crystal_ore", () -> new SpiritCrystalOre(DEFAULT_PROPERTIES));
    public static final RegistryObject<SpiritCrystalOre> woodenCrystalOre = registryWithItem("wooden_crystal_ore", () -> new SpiritCrystalOre(DEFAULT_PROPERTIES));
    public static final RegistryObject<SpiritCrystalOre> waterCrystalOre = registryWithItem("water_crystal_ore", () -> new SpiritCrystalOre(DEFAULT_PROPERTIES));
    public static final RegistryObject<SpiritCrystalOre> fireCrystalOre = registryWithItem("fire_crystal_ore", () -> new SpiritCrystalOre(DEFAULT_PROPERTIES));
    public static final RegistryObject<SpiritCrystalOre> earthCrystalOre = registryWithItem("earth_crystal_ore", () -> new SpiritCrystalOre(DEFAULT_PROPERTIES));

    public static <T extends Block> RegistryObject<T> registryWithItem(String name, final Supplier<T> sup) {
        RegistryObject<T> registryObject = BLOCKS.register(name, sup);
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(registryObject.get(), DEFAULT_BLOCK_ITEM_PROPERTIES));
        return registryObject;
    }
}
