package com.definitelyNOTdilophosaurus.dinosauria.entity;

import com.definitelyNOTdilophosaurus.dinosauria.DinosauriaMod;
import com.definitelyNOTdilophosaurus.dinosauria.entity.custom.DilophosaurusEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.io.DataInput;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, DinosauriaMod.MOD_ID);

    public static final RegistryObject<EntityType<DilophosaurusEntity>> DILOPHOSAURUS = ENTITY_TYPES.register("dilophosaurus",
            () -> EntityType.Builder.of(DilophosaurusEntity::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(DinosauriaMod.MOD_ID, "dilophosaurus").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
