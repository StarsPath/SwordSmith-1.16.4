package com.starspath.swordsmith.core.init;

import com.starspath.swordsmith.SwordSmith;
import com.starspath.swordsmith.common.items.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SwordSmith.MOD_ID);

    public static final RegistryObject<Tamahagane> TAMAHAGANE = ITEMS.register("tamahagane",
            () -> new Tamahagane(new Item.Properties().group(SwordSmith.SSItemGroup).maxStackSize(1)));

    public static final RegistryObject<Item> SHINGANE = ITEMS.register("shingane",
            () -> new Item(new Item.Properties().group(SwordSmith.SSItemGroup)));

    public static final RegistryObject<Item> KAWAGANE = ITEMS.register("kawagane",
            () -> new Item(new Item.Properties().group(SwordSmith.SSItemGroup)));

    public static final RegistryObject<Shingane_stack> SHINGANE_STACK = ITEMS.register("shingane_stack",
            () -> new Shingane_stack(new Item.Properties().group(SwordSmith.SSItemGroup)));

    public static final RegistryObject<Kawagane_stack> KAWAGANE_STACK = ITEMS.register("kawagane_stack",
            () -> new Kawagane_stack(new Item.Properties().group(SwordSmith.SSItemGroup)));

    public static final RegistryObject<Item> STEEL_CONSTRUCT = ITEMS.register("steel_construct",
            () -> new Item(new Item.Properties().group(SwordSmith.SSItemGroup)));

    public static final RegistryObject<Item> ASH = ITEMS.register("ash",
            () -> new Item(new Item.Properties().group(SwordSmith.SSItemGroup)));

    public static final RegistryObject<ForgingTool> HAMMER = ITEMS.register("hammer",
            () -> new ForgingTool(new Item.Properties().group(SwordSmith.SSItemGroup).maxStackSize(1).maxDamage(250)));

    public static final RegistryObject<ForgingBlade> NEW_BLADE = ITEMS.register("new_blade",
            () -> new ForgingBlade(new Item.Properties().group(SwordSmith.SSItemGroup).maxStackSize(1)));

    public static final RegistryObject<Item> HANDLE = ITEMS.register("handle",
            () -> new Item(new Item.Properties().group(SwordSmith.SSItemGroup)));

    //Block Items
    public static final RegistryObject<BlockItem> TAMAHAGANE_BLOCK = ITEMS.register("tamahagane_block",
            () -> new BlockItem(BlockInit.TAMAHAGANE_BLOCK.get(),
                    new Item.Properties().group(SwordSmith.SSItemGroup)));
    
}
