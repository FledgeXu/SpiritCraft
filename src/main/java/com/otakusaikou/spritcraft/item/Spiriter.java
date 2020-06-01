package com.otakusaikou.spritcraft.item;

import com.otakusaikou.spritcraft.capability.ISpiritChunkCapability;
import com.otakusaikou.spritcraft.capability.ModCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.LazyOptional;

public class Spiriter extends Item {
    public Spiriter(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND && playerIn.isCreative()) {
            Chunk chunk = (Chunk) worldIn.getChunk(playerIn.getPosition());
            LazyOptional<ISpiritChunkCapability> capability = chunk.getCapability(ModCapability.SPIRIT_CHUNK_CAPABILITY);
            capability.ifPresent((cap) -> {
                playerIn.sendMessage(new StringTextComponent("Spirit: " + cap.getSpirit().toString()));
                playerIn.sendMessage(new StringTextComponent("Spirit Limit: " + cap.getSpiritLimit().toString()));
                playerIn.sendMessage(new StringTextComponent("Spirit Rate: " + cap.getSpiritGrowRate().toString()));
            });

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
