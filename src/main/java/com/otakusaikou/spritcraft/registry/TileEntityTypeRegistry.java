package com.otakusaikou.spritcraft.registry;

import com.otakusaikou.spritcraft.tileentity.CultivateMarkTileEntity;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ModConstants.MOD_ID);
    public static final RegistryObject<TileEntityType<CultivateMarkTileEntity>> cultivateMark = TILE_ENTITIES.register("cultivate_mark", () -> TileEntityType.Builder.create(CultivateMarkTileEntity::new, BlockRegistry.cultivateMark.get()).build(null));
}
