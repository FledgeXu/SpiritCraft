package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.tileentity.CollectiveMarkTileEntity;
import com.otakusaikou.spritcraft.tileentity.CultivateMarkTileEntity;
import com.otakusaikou.spritcraft.tileentity.HuntMarkTIleEntity;
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


}
