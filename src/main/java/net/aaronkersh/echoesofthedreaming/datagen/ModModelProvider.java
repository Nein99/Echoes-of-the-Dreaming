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

        blockStateModelGenerator.registerLog(ModBlocks.AEROWOOD_LOG).log(ModBlocks.AEROWOOD_LOG).wood(ModBlocks.AEROWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_AEROWOOD_LOG).log(ModBlocks.STRIPPED_AEROWOOD_LOG).wood(ModBlocks.STRIPPED_AEROWOOD_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AEROWOOD_LEAVES);

        blockStateModelGenerator.registerTintableCross(ModBlocks.AEROWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool aerowood_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AEROWOOD_PLANKS);
        aerowood_pool.family(ModBlocks.AEROWOOD_FAMILY);

        aerowood_pool.stairs(ModBlocks.AEROWOOD_STAIRS);
        aerowood_pool.slab(ModBlocks.AEROWOOD_SLAB);
        aerowood_pool.button(ModBlocks.AEROWOOD_BUTTON);
        aerowood_pool.pressurePlate(ModBlocks.AEROWOOD_PRESSURE_PLATE);
        aerowood_pool.fence(ModBlocks.AEROWOOD_FENCE);
        aerowood_pool.fenceGate(ModBlocks.AEROWOOD_FENCE_GATE);
        aerowood_pool.wall(ModBlocks.AEROWOOD_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.AEROWOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.AEROWOOD_TRAPDOOR);

        blockStateModelGenerator.registerLog(ModBlocks.SUNBEAM_LOG).log(ModBlocks.SUNBEAM_LOG).wood(ModBlocks.SUNBEAM_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SUNBEAM_LOG).log(ModBlocks.STRIPPED_SUNBEAM_LOG).wood(ModBlocks.STRIPPED_SUNBEAM_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUNBEAM_LEAVES);

        blockStateModelGenerator.registerTintableCross(ModBlocks.SUNBEAM_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool sunbeam_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SUNBEAM_PLANKS);
        sunbeam_pool.family(ModBlocks.SUNBEAM_FAMILY);

        sunbeam_pool.stairs(ModBlocks.SUNBEAM_STAIRS);
        sunbeam_pool.slab(ModBlocks.SUNBEAM_SLAB);
        sunbeam_pool.button(ModBlocks.SUNBEAM_BUTTON);
        sunbeam_pool.pressurePlate(ModBlocks.SUNBEAM_PRESSURE_PLATE);
        sunbeam_pool.fence(ModBlocks.SUNBEAM_FENCE);
        sunbeam_pool.fenceGate(ModBlocks.SUNBEAM_FENCE_GATE);
        sunbeam_pool.wall(ModBlocks.SUNBEAM_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.SUNBEAM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SUNBEAM_TRAPDOOR);
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
        itemModelGenerator.register(ModItems.BISMUTH_OREWALKER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.HANGING_AEROWOOD_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModItems.HANGING_SUNBEAM_SIGN, Models.GENERATED);

    }
}