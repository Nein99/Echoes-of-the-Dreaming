package net.aaronkersh.echoesofthedreaming;

import net.aaronkersh.echoesofthedreaming.entity.ModEntities;
import net.aaronkersh.echoesofthedreaming.entity.client.MourningOrewalkerRenderer;
import net.aaronkersh.echoesofthedreaming.entity.client.ModModelLayers;
import net.aaronkersh.echoesofthedreaming.entity.client.MourningOrewalkerModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class EchoesOfTheDreamingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.MOURNING_OREWALKER, MourningOrewalkerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOURNING_OREWALKER, MourningOrewalkerModel::getTexturedModelData);
    }
}
