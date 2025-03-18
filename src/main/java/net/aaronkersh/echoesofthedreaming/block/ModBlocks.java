package net.aaronkersh.echoesofthedreaming.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MOURNSTEEL_BLOCK = registerBlock("mournsteel_block",
            RadioactiveBlocks.createStrongRadioactiveBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.METAL).ticksRandomly()));
    public static final Block MOURNCRYST_BLOCK = registerBlock("mourncryst_block",
            RadioactiveBlocks.createStrongRadioactiveBlock(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.STONE).ticksRandomly()));
    public static final Block MOURNCRYST_BLACKENED_BLOCK = registerBlock("mourncryst_blackened_block",
            RadioactiveBlocks.createMediumRadioactiveBlock(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.METAL).ticksRandomly()));
    public static final Block MOURNCRYST_ORE = registerBlock("mourncryst_ore",
            RadioactiveBlocks.createWeakRadioactiveBlock(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.STONE).ticksRandomly()));
    public static final Block MOURNCRYST_DEEPSLATE_ORE = registerBlock("mourncryst_deepslate_ore",
            RadioactiveBlocks.createMediumRadioactiveBlock(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.STONE).ticksRandomly()));
    public static final Block VANADINITE_BLOCK = registerBlock("vanadinite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block VANADINITE_ORE = registerBlock("vanadinite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block VANADINITE_DEEPSLATE_ORE = registerBlock("vanadinite_deepslate_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block VANADIUM_BLOCK = registerBlock("vanadium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block BISMUTH_BLOCK = registerBlock("bismuth_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block BISMUTH_SAND = registerBlock("bismuth_sand",
            new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).sounds(BlockSoundGroup.SAND)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EchoesOfTheDreaming.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        EchoesOfTheDreaming.LOGGER.info("Registering ModBlocks for " + EchoesOfTheDreaming.MOD_ID);
    }
}