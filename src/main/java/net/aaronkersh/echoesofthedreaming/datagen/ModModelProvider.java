package net.aaronkersh.echoesofthedreaming.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.aaronkersh.echoesofthedreaming.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOURNCRYST_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOURNCRYST_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOURNCRYST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOURNCRYST_BLACKENED_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOURNSTEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VANADINITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VANADINITE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VANADINITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VANADIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MOURNCRYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOURNCRYST_BLACKENED, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOURNSTEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANADINITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANADIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BISMUTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH, Models.GENERATED);

    }
}