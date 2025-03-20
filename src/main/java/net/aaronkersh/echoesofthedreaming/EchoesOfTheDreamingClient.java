package net.aaronkersh.echoesofthedreaming;

import net.aaronkersh.echoesofthedreaming.entity.ModEntities;
import net.aaronkersh.echoesofthedreaming.entity.client.MourningOrewalkerRenderer;
import net.aaronkersh.echoesofthedreaming.entity.client.ModModelLayers;
import net.aaronkersh.echoesofthedreaming.entity.client.MourningOrewalkerModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;

public class EchoesOfTheDreamingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.MOURNING_OREWALKER, MourningOrewalkerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOURNING_OREWALKER, MourningOrewalkerModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISMUTH_CRYSTALSEED, RenderLayer.getCutout());
    }
}
