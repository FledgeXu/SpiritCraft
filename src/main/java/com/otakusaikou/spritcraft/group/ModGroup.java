package com.otakusaikou.spritcraft.group;

import com.otakusaikou.spritcraft.registry.ItemRegistry;
import com.otakusaikou.spritcraft.util.ModConstants;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroup {
    public static final ItemGroup DEFAULT_GROUP = new ItemGroup(ModConstants.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistry.fireCrystal.get());
        }
    };
}
