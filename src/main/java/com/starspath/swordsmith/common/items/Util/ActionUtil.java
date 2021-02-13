package com.starspath.swordsmith.common.items.Util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;

public class ActionUtil {

    public static boolean clickOnHeatSource(BlockState blockState){
        if(HeatControlUtil.heatSourceAmount.containsKey(blockState.getBlock()))
            return !blockState.hasProperty(BlockStateProperties.LIT) || blockState.get(BlockStateProperties.LIT);
        return false;
    }
    public static boolean clickedOnCoolSource(BlockState blockState){
        return blockState.hasProperty(BlockStateProperties.LEVEL_0_3) && blockState.get(BlockStateProperties.LEVEL_0_3) > 0;
    }
    public static boolean clickedOnGrindstone(BlockState blockState){
        return blockState.getBlock() == Blocks.GRINDSTONE;
    }
}
