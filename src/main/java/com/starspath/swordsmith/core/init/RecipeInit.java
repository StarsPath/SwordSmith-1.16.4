package com.starspath.swordsmith.core.init;

import com.starspath.swordsmith.SwordSmith;
import com.starspath.swordsmith.datagen.SteelConstructRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeInit {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SwordSmith.MOD_ID);

    public static final RegistryObject<SteelConstructRecipe.Serializer> STEEL_CONSTRUCT_RECIPE = RECIPE_SERIALIZER.register("steelcontruct", SteelConstructRecipe.Serializer::new);
}
