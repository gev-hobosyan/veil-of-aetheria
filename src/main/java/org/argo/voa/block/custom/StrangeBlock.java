package org.argo.voa.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.argo.voa.item.ModItems;
import org.argo.voa.util.ModTags;

public class StrangeBlock extends Block {
    public StrangeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if (isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(ModItems.EDRIUM_INGOT.get(), itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, state, entity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }
}
