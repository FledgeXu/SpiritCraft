package com.otakusaikou.spritcraft;

import com.otakusaikou.spritcraft.registry.BlockRegistry;
import com.otakusaikou.spritcraft.registry.ItemRegistry;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConstants.MOD_ID)
public class SpiritCraft {
    public SpiritCraft() {
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
