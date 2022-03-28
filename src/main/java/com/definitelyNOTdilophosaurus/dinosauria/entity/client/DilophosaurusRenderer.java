package com.definitelyNOTdilophosaurus.dinosauria.entity.client;

import com.definitelyNOTdilophosaurus.dinosauria.DinosauriaMod;
import com.definitelyNOTdilophosaurus.dinosauria.entity.custom.DilophosaurusEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DilophosaurusRenderer extends GeoEntityRenderer<DilophosaurusEntity> {
    public DilophosaurusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DilophosaurusModel());
        this.shadowRadius = 2.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(DilophosaurusEntity instance) {
        return new ResourceLocation(DinosauriaMod.MOD_ID, "textures/entity/dilophosaurus/dilophosaurus.png");
    }

    @Override
    public RenderType getRenderType(DilophosaurusEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0F, 1.0F, 1.0F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}