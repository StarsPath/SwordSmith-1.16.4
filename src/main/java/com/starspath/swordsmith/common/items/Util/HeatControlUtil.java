package com.starspath.swordsmith.common.items.Util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;


import java.util.HashMap;

public class HeatControlUtil {
    public static HashMap<Block, Integer> heatSourceAmount = new HashMap<Block, Integer>();
    /*
//    public static HashMap<Block, BlockState> heatSourceExtinguish = new HashMap<Block, BlockState>();
//    public static HashMap<Block, Integer> heatSourceExtinguishChance = new HashMap<Block, Integer>();
    //public static int heatLossPerHammer = 15;

     */
    public HeatControlUtil(){
        initHeatAmount();
    }
    public void initHeatAmount(){
        heatSourceAmount.put(Blocks.CAMPFIRE, 20);
        heatSourceAmount.put(Blocks.SOUL_CAMPFIRE, 50);
        heatSourceAmount.put(Blocks.FIRE, 40);
        heatSourceAmount.put(Blocks.SOUL_FIRE, 80);
        heatSourceAmount.put(Blocks.MAGMA_BLOCK, 200);
        heatSourceAmount.put(Blocks.LAVA, 500);
    }
    /*
//    public void initHeatExtinguish(){
//        heatSourceExtinguish.put(Blocks.CAMPFIRE, Blocks.CAMPFIRE.getDefaultState().with(BlockStateProperties.LIT, false));
//        heatSourceExtinguish.put(Blocks.SOUL_CAMPFIRE, Blocks.SOUL_CAMPFIRE.getDefaultState().with(BlockStateProperties.LIT, false));
//        heatSourceExtinguish.put(Blocks.FIRE, Blocks.AIR.getDefaultState());
//        heatSourceExtinguish.put(Blocks.SOUL_FIRE, Blocks.AIR.getDefaultState());
//        heatSourceExtinguish.put(Blocks.MAGMA_BLOCK, Blocks.BLACKSTONE.getDefaultState());
//        heatSourceExtinguish.put(Blocks.LAVA, Blocks.BASALT.getDefaultState());
//    }
//    public void initHeatExtinguishChance(){
//        heatSourceExtinguishChance.put(Blocks.CAMPFIRE, 2);
//        heatSourceExtinguishChance.put(Blocks.SOUL_CAMPFIRE, 2);
//        heatSourceExtinguishChance.put(Blocks.FIRE, 5);
//        heatSourceExtinguishChance.put(Blocks.SOUL_FIRE, 5);
//        heatSourceExtinguishChance.put(Blocks.MAGMA_BLOCK, 5);
//        heatSourceExtinguishChance.put(Blocks.LAVA, 10);
//    }*/
}
