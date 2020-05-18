package com.otakusaikou.spritcraft.registries;

import com.otakusaikou.spritcraft.utils.ModConstants;
import net.minecraft.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ModConstants.MOD_ID);
}
