package com.starspath.swordsmith.datagen;

import com.google.gson.JsonObject;
import com.starspath.swordsmith.SwordSmith;
import com.starspath.swordsmith.core.init.ItemInit;
import com.starspath.swordsmith.core.init.RecipeInit;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.AirItem;
import net.minecraft.item.Item;
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

    private final ResourceLocation id;

    public SteelConstructRecipe(ResourceLocation idIn){
        id = idIn;
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        boolean shingane = false;
        boolean kawagane = false;
        int sCount = 0;
        int kCount = 0;

        for(int i = 0; i < inv.getSizeInventory(); i++) {
            ItemStack itemStack = inv.getStackInSlot(i);
            if(itemStack.isEmpty() || itemStack.getItem() instanceof AirItem)
                continue;
            CompoundNBT nbt = itemStack.getOrCreateTag();

            if(itemStack.getItem() == ItemInit.SHINGANE_STACK.get() &&
                    nbt.getInt("ForgeStage") == 0 && nbt.getInt("HeatStage") > 0){
                shingane = true;
                sCount += 1;
            }
            if(itemStack.getItem() == ItemInit.KAWAGANE_STACK.get() &&
                    nbt.getInt("ForgeStage") == 2 && nbt.getInt("HeatStage") > 0){
                kawagane = true;
                kCount += 1;
            }
        }
        boolean decision = shingane && kawagane && sCount == 1 && kCount == 1;
        System.out.print(decision);
        return decision;
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory inv) {
        return new ItemStack(ItemInit.STEEL_CONSTRUCT.get());
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ItemInit.STEEL_CONSTRUCT.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeInit.STEEL_CONSTRUCT_RECIPE.get();
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
