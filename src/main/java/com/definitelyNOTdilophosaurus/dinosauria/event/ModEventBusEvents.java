package com.definitelyNOTdilophosaurus.dinosauria.event;

import com.definitelyNOTdilophosaurus.dinosauria.DinosauriaMod;
import com.definitelyNOTdilophosaurus.dinosauria.entity.ModEntityTypes;
import com.definitelyNOTdilophosaurus.dinosauria.entity.custom.DilophosaurusEntity;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = DinosauriaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static  void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                    event) {
        event.getRegistry().registerAll(


        );
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.DILOPHOSAURUS.get(), DilophosaurusEntity.setAttributes());
    }
}
