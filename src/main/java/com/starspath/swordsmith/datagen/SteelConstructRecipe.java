package com.starspath.swordsmith.datagen;

import com.google.gson.JsonObject;
import com.starspath.swordsmith.SwordSmith;
import com.starspath.swordsmith.core.init.ItemInit;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.AirItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class SteelConstructRecipe implements ICraftingRecipe {

    private final ItemStack steelConstruct = new ItemStack(ItemInit.STEEL_CONSTRUCT.get());

    private final ResourceLocation id;

    public SteelConstructRecipe(ResourceLocation idIn){
        id = idIn;
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
        boolean shingane = false;
        boolean kawagane = false;

        for(int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack itemStack = inv.getStackInSlot(i);
            if(itemStack.isEmpty() || itemStack.getItem() instanceof AirItem)
                continue;
            CompoundNBT nbt = itemStack.getOrCreateTag();

            if(itemStack.getItem() == ItemInit.SHINGANE_STACK.get() &&
                    nbt.getInt("ForgeStage") == 0 && nbt.getInt("HeatStage") > 0)
                shingane = true;
            if(itemStack.getItem() == ItemInit.KAWAGANE_STACK.get() &&
                    nbt.getInt("ForgeStage") == 2 && nbt.getInt("HeatStage") > 0)
                kawagane = true;
            itemList.add(itemStack);
        }
        return itemList.size() == 2 && shingane && kawagane;
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory inv) {
        return steelConstruct;
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return steelConstruct;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return null;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SteelConstructRecipe>{

        @Override
        public SteelConstructRecipe read(ResourceLocation recipeId, JsonObject json) {
            return new SteelConstructRecipe(recipeId);
        }

        @Nullable
        @Override
        public SteelConstructRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            return new SteelConstructRecipe(recipeId);
        }

        @Override
        public void write(PacketBuffer buffer, SteelConstructRecipe recipe) {

        }
    }
}
