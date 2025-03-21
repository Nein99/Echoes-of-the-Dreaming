package net.aaronkersh.echoesofthedreaming.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.aaronkersh.echoesofthedreaming.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VANADINITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VANADIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_SAND);

        blockStateModelGenerator.registerTintableCross(ModBlocks.BISMUTH_CRYSTALSEED, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MOURNCRYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOURNCRYST_BLACKENED, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOURNSTEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOURNSTEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANADINITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANADIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANADIUM_PENTOXIDE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BISMUTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISMUTH_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.POWDERED_BISMUTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLANAR_TUNING_FORK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURSED_SOULSTONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.MOURNSTEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOURNSTEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOURNSTEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOURNSTEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOURNSTEEL_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BISMUTH_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BISMUTH_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BISMUTH_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BISMUTH_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BISMUTH_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BISMUTH_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BISMUTH_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BISMUTH_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BISMUTH_BOOTS));

        itemModelGenerator.register(ModItems.MOURNING_OREWALKER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

    }
}