package org.argo.voa.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.argo.voa.block.ModBlocks;

import java.util.List;
import java.util.Map;

public class MagicStaff extends Item {
    public MagicStaff(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        final Map<Block, Block> TRANSFORM_BLOCKS = Map.of(
                Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE,
                Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE,
                Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE,
                Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE,
                Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE,
                Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE,
                Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE
        );

        Level level = context.getLevel();
        Block block = level.getBlockState(context.getClickedPos()).getBlock();

        if(TRANSFORM_BLOCKS.containsKey(block)) {
            if(!level.isClientSide) {
                level.setBlockAndUpdate(context.getClickedPos(), TRANSFORM_BLOCKS.get(block).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.voa.items.magic_staff"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

