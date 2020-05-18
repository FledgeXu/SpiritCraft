package com.otakusaikou.spritcraft.groups;

import com.otakusaikou.spritcraft.registries.ItemRegistry;
import com.otakusaikou.spritcraft.utils.ModConstants;
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
