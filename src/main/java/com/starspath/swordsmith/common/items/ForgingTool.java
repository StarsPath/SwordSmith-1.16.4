package com.starspath.swordsmith.common.items;

import com.starspath.swordsmith.client.util.KeyboardHelper;
import com.starspath.swordsmith.common.items.Util.TooltipUtil;
import com.starspath.swordsmith.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ForgingTool extends Item{
    public ForgingTool(Item.Properties properties){
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        String toolTip = TooltipUtil.getToolTip(stack);

        if(KeyboardHelper.isHoldingLeftShift()){
            tooltip.add(new TranslationTextComponent(toolTip));
        }
        else{
            tooltip.add(new TranslationTextComponent("tooltip.special_item.hold_shift"));
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
        Block block = blockState.getBlock();

        if(playerEntity.getHeldItemMainhand().getItem() != ItemInit.HAMMER.get())
            return super.onItemUse(context);

        if(KeyboardHelper.isHoldingLeftShift()){
            if(block == Blocks.ANVIL || block == Blocks.CHIPPED_ANVIL || block == Blocks.DAMAGED_ANVIL){
                //System.out.print("Clicked on Anvil with hammer\n");
                ItemStack offhandItemStack = playerEntity.getHeldItemOffhand();
                if(offhandItemStack.getItem() instanceof ForgingItem){

                    playerEntity.swingArm(hand);
                    playerEntity.getCooldownTracker().setCooldown(this, 20);
                    itemStack.damageItem(1, playerEntity, (x)->{x.sendBreakAnimation(EquipmentSlotType.MAINHAND);});
                    world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.5f, 1f);

                    CompoundNBT nbt = offhandItemStack.getOrCreateTag();
                    if(nbt.getInt("Heat") < 400){
                        if(offhandItemStack.getItem() == ItemInit.TAMAHAGANE.get()){
                            dropItem(playerEntity, (int)((1.0 - ((float)nbt.getInt("Impurity")/100)) * 7) + 1);
                        }
                        offhandItemStack.shrink(1);
                    }
                    else {
                        //nbt.putInt("Heat", nbt.getInt("Heat") - HeatControl.heatLossPerHammer);
                        nbt.putInt("Heat", nbt.getInt("Heat") - (int)(0.1 * nbt.getInt("Heat")));
                        nbt.putInt("HeatStage", nbt.getInt("Heat")/250);
                        nbt.putInt("Hammer", nbt.getInt("Hammer") + 1);
                        if(nbt.contains("Impurity"))
                            nbt.putInt("Impurity", nbt.getInt("Impurity") - (int)((Math.random() * 0.1 + 0.1) * nbt.getInt("Impurity")));
                        if(offhandItemStack.getItem() == ItemInit.KAWAGANE_STACK.get() || offhandItemStack.getItem() == ItemInit.SHINGANE_STACK.get()){
                            nbt.putInt("ForgeStage", nbt.getInt("Hammer")/2%4);
                        }
                    }
                }
            }
        }
        return super.onItemUse(context);
    }

    public void dropItem(PlayerEntity playerEntity, int rolls){
        for(int i = 0; i < rolls; i++){
            double random = Math.random();
            if(random < 0.6)
                playerEntity.dropItem(new ItemStack(ItemInit.SHINGANE.get()), false);
            else
                playerEntity.dropItem(new ItemStack(ItemInit.KAWAGANE.get()), false);
        }
    }
}
