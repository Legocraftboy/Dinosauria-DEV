package com.definitelyNOTdilophosaurus.dinosauria.entity.client;

import com.definitelyNOTdilophosaurus.dinosauria.DinosauriaMod;
import com.definitelyNOTdilophosaurus.dinosauria.entity.custom.DilophosaurusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DilophosaurusModel extends AnimatedGeoModel<DilophosaurusEntity> {
    @Override
    public ResourceLocation getModelLocation(DilophosaurusEntity object) {
        return new ResourceLocation(DinosauriaMod.MOD_ID, "geo/dilophosaurus.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DilophosaurusEntity object) {
        return new ResourceLocation(DinosauriaMod.MOD_ID, "textures/entity/dilophosaurus/dilophosaurus.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DilophosaurusEntity animatable) {
        return new ResourceLocation(DinosauriaMod.MOD_ID, "animation/dilophosaurus.animation.json");
    }
}
