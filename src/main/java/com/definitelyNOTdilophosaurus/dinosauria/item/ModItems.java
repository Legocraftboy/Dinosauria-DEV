package com.definitelyNOTdilophosaurus.dinosauria.item;

import com.definitelyNOTdilophosaurus.dinosauria.DinosauriaMod;
import com.definitelyNOTdilophosaurus.dinosauria.entity.ModEntityTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DinosauriaMod.MOD_ID);

    public static final RegistryObject<Item> DILOPHOSAURUS_SKULL = ITEMS.register("dilophosaurus_skull",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DINOSAURIA_ITEMS).stacksTo(1)));

    public static final RegistryObject<Item> FOSSILIZED_DILOPHOSAURUS_SKULL = ITEMS.register("fossilized_dilophosaurus_skull",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DINOSAURIA_ITEMS).stacksTo(1)));

    public static final RegistryObject<Item> DILOPHOSAURUS_CREST = ITEMS.register("dilophosaurus_crest",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DINOSAURIA_ITEMS).stacksTo(2)));

    public static final RegistryObject<ForgeSpawnEggItem> DILOPHOSAURUS_SPAWN_EGG = ITEMS.register("dilophosaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DILOPHOSAURUS,0x948e8d, 0x3b3635,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
