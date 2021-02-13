package com.starspath.swordsmith.common.items;

import com.starspath.swordsmith.client.util.KeyboardHelper;
import com.starspath.swordsmith.common.items.Util.ActionUtil;
import com.starspath.swordsmith.common.items.Util.HeatControlUtil;
import com.starspath.swordsmith.common.items.Util.TooltipUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ForgingItem extends Item {
    public ForgingItem(Properties properties){
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        String toolTip = TooltipUtil.getToolTip(stack);

        CompoundNBT nbt = stack.getOrCreateTag();

        if(KeyboardHelper.isHoldingLeftShift()){
            tooltip.add(new TranslationTextComponent(toolTip));
        }
        if(KeyboardHelper.isHoldingLeftCtrl()){
            tooltip.add(new StringTextComponent("Heat: " + nbt.getInt("Heat")));
            tooltip.add(new StringTextComponent("Hammer: " + nbt.getInt("Hammer")));
        }
        if(!KeyboardHelper.isKeyPressed()){
            tooltip.add(new TranslationTextComponent("tooltip.special_item.hold_shift"));
            tooltip.add(new TranslationTextComponent("tooltip.special_item.hold_ctrl"));
        }

    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getItem();
        Hand hand = context.getHand();
        World world = context.getWorld();
        BlockPos blockPos = context.getPos();

        BlockState blockState = world.getBlockState(blockPos);
        CompoundNBT nbt = itemStack.getOrCreateTag();

        if(ActionUtil.clickOnHeatSource(blockState)){
            nbt.putInt("Heat", nbt.getInt("Heat") + HeatControlUtil.heatSourceAmount.get(blockState.getBlock()));
            nbt.putInt("HeatStage", nbt.getInt("Heat")/250);
            if (nbt.getInt("Heat") > 1500){
                itemStack.shrink(1);
            }
            world.playSound(playerEntity, blockPos, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 0.5f, 1f);
        }

        if(ActionUtil.clickedOnCoolSource(blockState) && nbt.getInt("Heat") > 0){
            nbt.putInt("Heat", 0);
            nbt.putInt("HeatStage", 0);
            world.setBlockState(blockPos, blockState.with(BlockStateProperties.LEVEL_0_3,blockState.get(BlockStateProperties.LEVEL_0_3) -1 ));
            world.playSound(playerEntity, blockPos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 0.5f, 1f);
        }

        return super.onItemUse(context);
    }
}
