package net.aaronkersh.echoesofthedreaming.entity.client;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.entity.custom.BismuthOrewalkerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BismuthOrewalkerRenderer extends MobEntityRenderer<BismuthOrewalkerEntity, BismuthOrewalkerModel<BismuthOrewalkerEntity>> {
    private static final Identifier TEXTURE = new Identifier(EchoesOfTheDreaming.MOD_ID, "textures/entity/bismuth_orewalker.png");

    public BismuthOrewalkerRenderer(EntityRendererFactory.Context context) {
        super(context, new BismuthOrewalkerModel<>(context.getPart(BismuthOrewalkerModel.BISMUTH_OREWALKER)), 0.5f);
    }

    @Override
    public Identifier getTexture(BismuthOrewalkerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BismuthOrewalkerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
