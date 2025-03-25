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
                .add(ModBlocks.BISMUTH_BLOCK)
                .add(ModBlocks.BISMUTH_SAND);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.AEROWOOD_LOG)
                .add(ModBlocks.STRIPPED_AEROWOOD_LOG)
                .add(ModBlocks.AEROWOOD_WOOD)
                .add(ModBlocks.STRIPPED_AEROWOOD_WOOD)
                .add(ModBlocks.AEROWOOD_PLANKS)
                .add(ModBlocks.AEROWOOD_STAIRS)
                .add(ModBlocks.AEROWOOD_SLAB)
                .add(ModBlocks.AEROWOOD_FENCE)
                .add(ModBlocks.AEROWOOD_FENCE_GATE)
                .add(ModBlocks.AEROWOOD_BUTTON)
                .add(ModBlocks.AEROWOOD_PRESSURE_PLATE)
                .add(ModBlocks.AEROWOOD_DOOR)
                .add(ModBlocks.AEROWOOD_TRAPDOOR);

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

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.AEROWOOD_PLANKS);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN) // Even though it won’t burn, this allows it to work in crafting
                .add(ModBlocks.AEROWOOD_LOG)
                .add(ModBlocks.STRIPPED_AEROWOOD_LOG)
                .add(ModBlocks.AEROWOOD_WOOD)
                .add(ModBlocks.STRIPPED_AEROWOOD_WOOD);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.AEROWOOD_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.AEROWOOD_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.AEROWOOD_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.AEROWOOD_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.AEROWOOD_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.AEROWOOD_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.AEROWOOD_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.AEROWOOD_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.AEROWOOD_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.AEROWOOD_WALL);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.MOURNSTEEL_BLOCK);
    }
}
