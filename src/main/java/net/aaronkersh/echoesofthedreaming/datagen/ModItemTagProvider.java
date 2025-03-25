package net.aaronkersh.echoesofthedreaming.datagen;

import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.aaronkersh.echoesofthedreaming.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BISMUTH_HELMET, ModItems.BISMUTH_CHESTPLATE, ModItems.BISMUTH_LEGGINGS, ModItems.BISMUTH_BOOTS);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.AEROWOOD_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.AEROWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_AEROWOOD_LOG.asItem())
                .add(ModBlocks.AEROWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_AEROWOOD_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.AEROWOOD_FENCE.asItem());
    }
}