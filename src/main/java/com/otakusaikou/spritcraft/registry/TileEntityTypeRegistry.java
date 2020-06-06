package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.tileentity.GlassJarTileEntity;
import com.otakusaikou.spritcraft.tileentity.SpiritFurnaceTileEntity;
import com.otakusaikou.spritcraft.tileentity.mark.CollectiveMarkTileEntity;
import com.otakusaikou.spritcraft.tileentity.mark.CultivateMarkTileEntity;
import com.otakusaikou.spritcraft.tileentity.mark.HuntMarkTIleEntity;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ModConstants.MOD_ID);
    public static final RegistryObject<TileEntityType<CultivateMarkTileEntity>> cultivateMarkTileEntity = TILE_ENTITIES.register("cultivate_mark", () -> TileEntityType.Builder.create(CultivateMarkTileEntity::new, BlockRegistry.cultivateMarkBlock.get()).build(null));
    public static final RegistryObject<TileEntityType<CollectiveMarkTileEntity>> collectiveMarkTileEntity = TILE_ENTITIES.register("collective_mark", () -> TileEntityType.Builder.create(CollectiveMarkTileEntity::new, BlockRegistry.collectiveMarkBlock.get()).build(null));
    public static final RegistryObject<TileEntityType<HuntMarkTIleEntity>> huntMarkTileEntity = TILE_ENTITIES.register("hunt_mark", () -> TileEntityType.Builder.create(HuntMarkTIleEntity::new, BlockRegistry.huntMarkBlock.get()).build(null));
    public static final RegistryObject<TileEntityType<GlassJarTileEntity>> glassJarTileEntity = TILE_ENTITIES.register("glass_jar", () -> TileEntityType.Builder.create(GlassJarTileEntity::new, BlockRegistry.glassJar.get()).build(null));
    public static final RegistryObject<TileEntityType<SpiritFurnaceTileEntity>> spiritFurnaceTileEntity = TILE_ENTITIES.register("spirit_furnace", () -> TileEntityType.Builder.create(SpiritFurnaceTileEntity::new, BlockRegistry.spiritFurnace.get()).build(null));
}
