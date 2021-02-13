package com.starspath.swordsmith.common.items.Util;

import com.starspath.swordsmith.core.init.ItemInit;
import net.minecraft.item.ItemStack;

public class TooltipUtil {
    public static String getToolTip(ItemStack stack){
        if(stack.isItemEqual(new ItemStack(ItemInit.TAMAHAGANE.get())))
            return "tooltip.tamahagane.info";
        if(stack.isItemEqual(new ItemStack(ItemInit.NEW_BLADE.get())))
            return "tooltip.new_blade.info";
        if(stack.isItemEqual(new ItemStack(ItemInit.HAMMER.get())))
            return "tooltip.hammer.info";
        if(stack.isItemEqual(new ItemStack(ItemInit.SHINGANE_STACK.get())))
            return "tooltip.shingane_stack.info";
        if(stack.isItemEqual(new ItemStack(ItemInit.KAWAGANE_STACK.get())))
            return "tooltip.kawagane_stack.info";


        return "tooltip.default.info";
    }
}
