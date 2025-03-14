package net.aaronkersh.echoesofthedreaming.datagen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MOURNCRYST_ORE)
                .add(ModBlocks.MOURNCRYST_DEEPSLATE_ORE)
                .add(ModBlocks.MOURNCRYST_BLOCK)
                .add(ModBlocks.MOURNCRYST_BLACKENED_BLOCK)
                .add(ModBlocks.MOURNSTEEL_BLOCK)
                .add(ModBlocks.VANADINITE_ORE)
                .add(ModBlocks.VANADINITE_DEEPSLATE_ORE)
                .add(ModBlocks.VANADINITE_BLOCK)
                .add(ModBlocks.VANADIUM_BLOCK)
                .add(ModBlocks.BISMUTH_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BISMUTH_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.VANADINITE_ORE)
                .add(ModBlocks.VANADINITE_DEEPSLATE_ORE)
                .add(ModBlocks.VANADINITE_BLOCK)
                .add(ModBlocks.VANADIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MOURNCRYST_ORE)
                .add(ModBlocks.MOURNCRYST_DEEPSLATE_ORE)
                .add(ModBlocks.MOURNCRYST_BLOCK)
                .add(ModBlocks.MOURNCRYST_BLACKENED_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.MOURNSTEEL_BLOCK);
    }
}
