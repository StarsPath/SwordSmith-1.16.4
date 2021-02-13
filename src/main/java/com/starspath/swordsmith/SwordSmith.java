package com.starspath.swordsmith;

import com.starspath.swordsmith.common.items.Util.HeatControlUtil;
import com.starspath.swordsmith.core.init.BlockInit;
import com.starspath.swordsmith.core.init.ItemInit;
import com.starspath.swordsmith.core.init.RecipeInit;
import com.starspath.swordsmith.datagen.SteelConstructRecipe;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SwordSmith.MOD_ID)
public class SwordSmith
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "swordsmith";
    public static final SwordSmithItemGroup SSItemGroup = new SwordSmithItemGroup(SwordSmith.MOD_ID);

    public SwordSmith() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        RecipeInit.RECIPE_SERIALIZER.register(bus);

        new HeatControlUtil();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    public static class SwordSmithItemGroup extends ItemGroup{

        public SwordSmithItemGroup(String label){
            super(label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.HAMMER.get());
        }
    }

}
