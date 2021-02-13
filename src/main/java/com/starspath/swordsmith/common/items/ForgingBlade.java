package com.starspath.swordsmith.common.items;

import com.starspath.swordsmith.client.util.KeyboardHelper;
import com.starspath.swordsmith.common.items.Util.ActionUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ForgingBlade extends ForgingItem {
    public ForgingBlade(Properties properties){
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        CompoundNBT nbt = stack.getOrCreateTag();

        if(KeyboardHelper.isHoldingLeftCtrl()){
            tooltip.add(new StringTextComponent("Polish: " + nbt.getInt("Polish")));
            tooltip.add(new StringTextComponent("Durability: " + nbt.getInt("Durability")));
        }
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        CompoundNBT nbt = stack.getOrCreateTag();
        nbt.putInt("Durability", 1000);
        super.onCreated(stack, worldIn, playerIn);
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

        if(KeyboardHelper.isHoldingLeftShift() && ActionUtil.clickedOnGrindstone(blockState)){
            nbt.putInt("Polish", nbt.getInt("Polish") + 1);
            nbt.putInt("Durability", nbt.getInt("Durability") - (int)(0.8 * nbt.getInt("Durability")));
            world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.5f, 1f);
        }
        return super.onItemUse(context);
    }

    //    @Override
//    public ActionResultType onItemUse(ItemUseContext context) {
//        PlayerEntity playerEntity = context.getPlayer();
//        ItemStack itemStack = context.getItem();
//        Hand hand = context.getHand();
//        World world = context.getWorld();
//        BlockPos blockPos = context.getPos();
//
//        BlockState blockState = world.getBlockState(blockPos);
//        CompoundNBT nbt = itemStack.getOrCreateTag();
//
//        if(ActionUtil.clickOnHeatSource(blockState)){
//            nbt.putInt("Heat", nbt.getInt("Heat") + HeatControlUtil.heatSourceAmount.get(blockState.getBlock()));
//            if (nbt.getInt("Heat") > 1500){
//                itemStack.shrink(1);
//            }
//            world.playSound(playerEntity, blockPos, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 0.5f, 1f);
//        }
//
//        if(ActionUtil.clickedOnCoolSource(blockState) && nbt.getInt("Heat") > 0){
//            nbt.putInt("Heat", 0);
//            world.setBlockState(blockPos, blockState.with(BlockStateProperties.LEVEL_0_3,blockState.get(BlockStateProperties.LEVEL_0_3) -1 ));
//            world.playSound(playerEntity, blockPos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 0.5f, 1f);
//        }
//
//        if(KeyboardHelper.isHoldingLeftCtrl() && ActionUtil.clickedOnGrindstone(blockState)){
//            nbt.putInt("Polish", nbt.getInt("Polish") + 1);
//            nbt.putInt("Durability", nbt.getInt("Durability") - (int)(0.8 * nbt.getInt("Durability")));
//            world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.5f, 1f);
//        }
//
//        return super.onItemUse(context);
//    }

}
