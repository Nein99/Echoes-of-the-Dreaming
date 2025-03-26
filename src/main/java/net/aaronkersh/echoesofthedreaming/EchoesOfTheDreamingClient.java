package net.aaronkersh.echoesofthedreaming;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.aaronkersh.echoesofthedreaming.entity.ModEntities;
import net.aaronkersh.echoesofthedreaming.entity.client.BismuthOrewalkerModel;
import net.aaronkersh.echoesofthedreaming.entity.client.MourningOrewalkerRenderer;
import net.aaronkersh.echoesofthedreaming.entity.client.BismuthOrewalkerRenderer;
import net.aaronkersh.echoesofthedreaming.entity.client.ModModelLayers;
import net.aaronkersh.echoesofthedreaming.entity.client.MourningOrewalkerModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

public class EchoesOfTheDreamingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.MOURNING_OREWALKER, MourningOrewalkerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOURNING_OREWALKER, MourningOrewalkerModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.BISMUTH_OREWALKER, BismuthOrewalkerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BISMUTH_OREWALKER, BismuthOrewalkerModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISMUTH_CRYSTALSEED, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AEROWOOD_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AEROWOOD_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AEROWOOD_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AEROWOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AEROWOOD_TRAPDOOR, RenderLayer.getCutout());

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.AEROWOOD_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.AEROWOOD_HANGING_SIGN_TEXTURE));

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUNBEAM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUNBEAM_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUNBEAM_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUNBEAM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUNBEAM_TRAPDOOR, RenderLayer.getCutout());

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.SUNBEAM_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.SUNBEAM_HANGING_SIGN_TEXTURE));
    }
}
