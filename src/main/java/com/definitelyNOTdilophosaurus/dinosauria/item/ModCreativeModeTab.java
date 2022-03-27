package com.definitelyNOTdilophosaurus.dinosauria.item;

import com.definitelyNOTdilophosaurus.dinosauria.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.swing.*;

public class ModCreativeModeTab {
    public static final CreativeModeTab DINOSAURIA_ITEMS = new CreativeModeTab("dinosauriaitems") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DILOPHOSAURUS_SKULL.get());
        }
    };

    public static final CreativeModeTab DINOSAURIA_BLOCKS = new CreativeModeTab("dinosauriablocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CYCAD_LOG.get());
        }
    };
}
