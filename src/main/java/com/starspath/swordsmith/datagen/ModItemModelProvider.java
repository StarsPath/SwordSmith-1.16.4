package com.starspath.swordsmith.datagen;

import com.starspath.swordsmith.SwordSmith;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, SwordSmith.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        //builder(itemGenerated, "tamahagane");
        builder(itemGenerated, "kawagane");
        builder(itemGenerated, "shingane");
        builder(itemGenerated, "steel_construct");
        //builder(itemGenerated, "kawagane_stack");
        //builder(itemGenerated, "shingane_stack");
        builder(itemGenerated, "hammer");
        builder(itemGenerated, "ash");

        for(int i = 0; i < 5; i++){
            doubleLayerBuilder(itemGenerated,"tamahagane", "heat"+(i+1));
        }

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                doubleLayerBuilder(itemGenerated, "stack_hammer"+(i+1), "heat"+j);
            }
        }
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name){
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    private ItemModelBuilder doubleLayerBuilder(ModelFile itemGenerated, String layer0, String layer1){
        return getBuilder(layer0+"_"+layer1).parent(itemGenerated)
                .texture("layer0", "item/" + layer0)
                .texture("layer1", "item/" + layer1);
    }
}
