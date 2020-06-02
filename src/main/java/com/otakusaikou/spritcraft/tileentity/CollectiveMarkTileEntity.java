package com.otakusaikou.spritcraft.tileentity;

import com.otakusaikou.spritcraft.capability.ISpiritChunkCapability;
import com.otakusaikou.spritcraft.registry.TileEntityTypeRegistry;
import com.otakusaikou.spritcraft.spirit.Spirit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.List;


public class CollectiveMarkTileEntity extends SpiritConsumeTileEntity {
    public CollectiveMarkTileEntity() {
        super(TileEntityTypeRegistry.collectiveMarkTileEntity.get(), new Spirit(0, 5, 5, 5, 1), 3 * 20);
    }

    @Override
    public void doTick() {
        TileEntity tileEntity = this.world.getTileEntity(this.pos.down());
        if (tileEntity == null) {
            return;
        }
        LazyOptional<ISpiritChunkCapability> spiritChunkCapability = getSpiritChunkCap();
        LazyOptional<IItemHandler> itemHandlerCapability = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
        itemHandlerCapability.ifPresent((cap) -> {
            consumeSpiritThenDo(() -> {
                BlockPos blockInit = new BlockPos(this.pos).add(-4, -4, -4);
                BlockPos blockEnd = new BlockPos(this.pos).add(4, 4, 4);
                //Get nearby ItemEntity.
                List<Entity> list = this.world.getEntitiesInAABBexcluding(null, new AxisAlignedBB(blockInit, blockEnd), null);
                for (Entity dropEntity : list) {
                    if (dropEntity instanceof ItemEntity) {
                        ItemEntity itemEntity = (ItemEntity) dropEntity;
                        //Try to insert into container;
                        for (int i = 0; i < cap.getSlots(); i++) {
                            ItemStack stack = cap.insertItem(i, itemEntity.getItem(), false);
                            // Clean the world's ItemEntity;
                            if (stack.isEmpty()) {
                                itemEntity.remove();
                                break;
                            } else {
                                itemEntity.setItem(stack);
                            }
                        }
                    }
                }
                return null;
            });
        });
    }
}
