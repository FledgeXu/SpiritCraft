package com.otakusaikou.spritcraft.block;

import net.minecraft.block.Block;

public class SpiritCrystalOre extends Block {
    public SpiritCrystalOre(Properties properties) {
        super(properties.hardnessAndResistance(5, 2000).harvestLevel(1));
    }
}
