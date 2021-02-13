package com.starspath.swordsmith.client.util;

import com.starspath.swordsmith.SwordSmith;
import com.starspath.swordsmith.core.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = SwordSmith.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ArrayList<Item> ForgeItemGroup = new ArrayList<Item>();
        ForgeItemGroup.add(ItemInit.KAWAGANE_STACK.get());
        ForgeItemGroup.add(ItemInit.SHINGANE_STACK.get());

        for(Item item : ForgeItemGroup){
            ItemModelsProperties.registerProperty(item, new ResourceLocation(SwordSmith.MOD_ID, "heat"),
                    (stack, world, entity)->{
                        CompoundNBT nbt = stack.getOrCreateTag();
                        return (float)nbt.getInt("HeatStage");
                    });
            ItemModelsProperties.registerProperty(item, new ResourceLocation(SwordSmith.MOD_ID, "stage"),
                    (stack, world, entity)->{
                        CompoundNBT nbt = stack.getOrCreateTag();
                        return (float)nbt.getInt("ForgeStage");
                    });
            ItemModelsProperties.registerProperty(item, new ResourceLocation(SwordSmith.MOD_ID, "hammer"),
                    (stack, world, entity)->{
                        CompoundNBT nbt = stack.getOrCreateTag();
                        return (float)nbt.getInt("Hammer");
                    });
        }

        ItemModelsProperties.registerProperty(ItemInit.TAMAHAGANE.get(), new ResourceLocation(SwordSmith.MOD_ID, "heat"),
                (stack, world, entity)->{
                    CompoundNBT nbt = stack.getOrCreateTag();
                    return (float)nbt.getInt("Heat")/10000;
                });
    }
}
