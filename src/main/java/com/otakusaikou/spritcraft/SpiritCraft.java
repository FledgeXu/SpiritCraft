package com.otakusaikou.spritcraft;

import com.otakusaikou.spritcraft.registries.BlockRegistry;
import com.otakusaikou.spritcraft.registries.ItemRegistry;
import com.otakusaikou.spritcraft.utils.ModConstants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConstants.MOD_ID)
public class SpiritCraft {
    public SpiritCraft() {
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
