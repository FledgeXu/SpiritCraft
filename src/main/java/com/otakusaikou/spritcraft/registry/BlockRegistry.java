package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.block.GlassJar;
import com.otakusaikou.spritcraft.block.SpiritCrystalOre;
import com.otakusaikou.spritcraft.block.SpiritFurnace;
import com.otakusaikou.spritcraft.block.mark.MarkBlock;
import com.otakusaikou.spritcraft.group.ModGroup;
import com.otakusaikou.spritcraft.tileentity.mark.CollectiveMarkTileEntity;
import com.otakusaikou.spritcraft.tileentity.mark.CultivateMarkTileEntity;
import com.otakusaikou.spritcraft.tileentity.mark.HuntMarkTIleEntity;
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
    public static final RegistryObject<GlassJar> glassJar = registryWithItem("glass_jar", () -> new GlassJar(Block.Properties.create(Material.GLASS).notSolid()));
    public static final RegistryObject<MarkBlock> cultivateMarkBlock = registryWithItem("cultivate_mark", () -> new MarkBlock(Block.Properties.create(Material.WOOD).notSolid().hardnessAndResistance(0.5f), CultivateMarkTileEntity::new));
    public static final RegistryObject<MarkBlock> collectiveMarkBlock = registryWithItem("collective_mark", () -> new MarkBlock(Block.Properties.create(Material.WOOD).notSolid().hardnessAndResistance(0.5f), CollectiveMarkTileEntity::new));
    public static final RegistryObject<MarkBlock> huntMarkBlock = registryWithItem("hunt_mark", () -> new MarkBlock(Block.Properties.create(Material.WOOD).notSolid().hardnessAndResistance(0.5f), HuntMarkTIleEntity::new));
    public static final RegistryObject<SpiritFurnace> spiritFurnace = registryWithItem("spirit_furnace", () -> new SpiritFurnace(DEFAULT_PROPERTIES));

    public static <T extends Block> RegistryObject<T> registryWithItem(String name, final Supplier<T> sup) {
        RegistryObject<T> registryObject = BLOCKS.register(name, sup);
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(registryObject.get(), DEFAULT_BLOCK_ITEM_PROPERTIES));
        return registryObject;
    }
}
