package com.starspath.swordsmith.core.init;

import com.starspath.swordsmith.SwordSmith;
import com.starspath.swordsmith.common.blocks.TamahaganeBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SwordSmith.MOD_ID);

    public static final RegistryObject<TamahaganeBlock> TAMAHAGANE_BLOCK = BLOCKS.register("tamahagane_block",
            ()-> new TamahaganeBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(30f, 9f)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(2)
                    .sound(SoundType.METAL)));
}
