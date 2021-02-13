package com.starspath.swordsmith.common.entities.player;

import com.starspath.swordsmith.SwordSmith;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;


@Mod.EventBusSubscriber(modid = SwordSmith.MOD_ID, bus = Bus.FORGE)
public class PlayerEventHandler {

//    @OnlyIn(Dist.CLIENT)
//    @SubscribeEvent
//    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event){
//        PlayerEntity player = event.getPlayer();
//        BlockPos blockPos = event.getPos();
//        World world = event.getWorld();
//
//        BlockState blk = world.getBlockState(blockPos);
//        System.out.print("Hi");
//
//        if(player.getHeldItemMainhand().isItemEqual(new ItemStack(ItemInit.HAMMER.get())) &&
//                blk.getBlock() == Blocks.ANVIL){
//            System.out.print("player left clicked on anvil with hammer\n");
//            world.playSound(player, blockPos, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 0.5f, 1.2f);
//
//            player.getCooldownTracker().setCooldown(player.getHeldItemMainhand().getItem(), 30);
//        }
//        //System.out.print("player left clicked a block\n");
//
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    @SubscribeEvent
//    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event){
//        PlayerEntity player = event.getPlayer();
//        BlockPos blockPos = event.getPos();
//        World world = event.getWorld();
//
//        BlockState blk = world.getBlockState(blockPos);
//
//
//
//        /* Raytracing is buggy in 1.16
//        RayTraceResult target = Minecraft.getInstance().objectMouseOver;
//
//        if(target != null){
//            Vector3d blockVector = target.getHitVec();
//            blk = world.getBlockState(new BlockPos(blockVector.x, blockVector.y, blockVector.z)).getBlock();
//        }
//        else{
//            System.out.print("null target raytrace\n");
//        }
//        */
//
//        if(player.getHeldItemMainhand().isItemEqual(new ItemStack(ItemInit.TAMAHAGANE.get()))){
//            if(blk.hasProperty(BlockStateProperties.LIT) && !blk.get(BlockStateProperties.LIT))
//                return;
//            if(HeatControl.heatSourceAmount.containsKey(blk.getBlock())){
//                int i = (int)Math.floor(Math.random() * 101);
//                if(i < HeatControl.heatSourceExtinguishChance.get(blk.getBlock())){
//                    System.out.print("Extinguished\n");
//                    world.setBlockState(blockPos, HeatControl.heatSourceExtinguish.get(blk.getBlock()).getDefaultState());
//                    if(world.getBlockState(blockPos).hasProperty(BlockStateProperties.LIT)){
//                        world.setBlockState(blockPos, world.getBlockState(blockPos).with(BlockStateProperties.LIT, false));
//                    }
//                }
//                world.playSound(player, blockPos, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.BLOCKS, 0.5f, 1f);
//                System.out.print("Clicked on heatsource with tamahagene; heat: "+HeatControl.heatSourceAmount.get(blk.getBlock()) + "\n");
//            }
//        }
//    }
}
