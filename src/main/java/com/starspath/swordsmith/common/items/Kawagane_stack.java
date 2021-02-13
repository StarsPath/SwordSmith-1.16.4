package com.starspath.swordsmith.common.items;

import com.starspath.swordsmith.client.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class Kawagane_stack extends ForgingItem{
    public Kawagane_stack(Properties properties){
        super(properties);
    }
    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        CompoundNBT nbt = stack.getOrCreateTag();
        if(KeyboardHelper.isHoldingLeftCtrl()){
            tooltip.add(new StringTextComponent("HeatStage: " + nbt.getInt("HeatStage")));
            tooltip.add(new StringTextComponent("ForgeStage: " + nbt.getInt("ForgeStage")));
        }
    }
}
