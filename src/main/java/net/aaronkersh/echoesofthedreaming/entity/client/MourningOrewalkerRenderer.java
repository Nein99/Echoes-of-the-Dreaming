package net.aaronkersh.echoesofthedreaming.entity.client;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.entity.custom.MourningOrewalkerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MourningOrewalkerRenderer extends MobEntityRenderer<MourningOrewalkerEntity, MourningOrewalkerModel<MourningOrewalkerEntity>> {
    private static final Identifier TEXTURE = new Identifier(EchoesOfTheDreaming.MOD_ID, "textures/entity/mourning_orewalker.png");

    public MourningOrewalkerRenderer(EntityRendererFactory.Context context) {
        super(context, new MourningOrewalkerModel<>(context.getPart(MourningOrewalkerModel.MOURNING_OREWALKER)), 0.5f);
    }

    @Override
    public Identifier getTexture(MourningOrewalkerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MourningOrewalkerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
