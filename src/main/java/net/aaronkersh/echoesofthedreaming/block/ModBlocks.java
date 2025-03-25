package net.aaronkersh.echoesofthedreaming.block;

import net.aaronkersh.echoesofthedreaming.world.tree.AerowoodTreeGenerator;
import net.aaronkersh.echoesofthedreaming.world.tree.BismuthCrystalseedGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;

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
    public static final Block BISMUTH_ORE = registerBlock("bismuth_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block BISMUTH_DEEPSLATE_ORE = registerBlock("bismuth_deepslate_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block VANADIUM_BLOCK = registerBlock("vanadium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block BISMUTH_BLOCK = registerBlock("bismuth_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block BISMUTH_SAND = registerBlock("bismuth_sand",
            new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND).sounds(BlockSoundGroup.SAND)));

    public static final Block BISMUTH_CRYSTALSEED = registerBlock("bismuth_crystalseed",
            new SaplingBlock(new BismuthCrystalseedGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Block AEROWOOD_LOG = registerBlock("aerowood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block AEROWOOD_WOOD = registerBlock("aerowood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_AEROWOOD_LOG = registerBlock("stripped_aerowood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_AEROWOOD_WOOD = registerBlock("stripped_aerowood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block AEROWOOD_PLANKS = registerBlock("aerowood_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block AEROWOOD_LEAVES = registerBlock("aerowood_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));
    public static final Block AEROWOOD_ROOTS = registerBlock("aerowood_roots",
            new Block(FabricBlockSettings.copyOf(Blocks.MANGROVE_ROOTS).strength(4f).nonOpaque()));

    public static final Block AEROWOOD_SAPLING = registerBlock("aerowood_sapling",
            new SaplingBlock(new AerowoodTreeGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Identifier AEROWOOD_SIGN_TEXTURE = new Identifier(EchoesOfTheDreaming.MOD_ID, "entity/signs/aerowood");
    public static final Identifier AEROWOOD_HANGING_SIGN_TEXTURE = new Identifier(EchoesOfTheDreaming.MOD_ID, "entity/signs/hanging/aerowood");
    public static final Identifier AEROWOOD_HANGING_GUI_SIGN_TEXTURE = new Identifier(EchoesOfTheDreaming.MOD_ID, "textures/gui/hanging_signs/aerowood");

    public static final Block STANDING_AEROWOOD_SIGN = Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, "aerowood_standing_sign"),
            new TerraformSignBlock(AEROWOOD_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_AEROWOOD_SIGN = Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, "aerowood_wall_sign"),
            new TerraformWallSignBlock(AEROWOOD_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_AEROWOOD_SIGN = Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, "aerowood_hanging_sign"),
            new TerraformHangingSignBlock(AEROWOOD_HANGING_SIGN_TEXTURE, AEROWOOD_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_AEROWOOD_SIGN = Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, "aerowood_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(AEROWOOD_HANGING_SIGN_TEXTURE, AEROWOOD_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));

    public static final BlockFamily AEROWOOD_FAMILY = BlockFamilies.register(ModBlocks.AEROWOOD_PLANKS)
            .sign(ModBlocks.STANDING_AEROWOOD_SIGN, ModBlocks.WALL_AEROWOOD_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block AEROWOOD_STAIRS = registerBlock("aerowood_stairs",
            new StairsBlock(ModBlocks.AEROWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block AEROWOOD_SLAB = registerBlock("aerowood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block AEROWOOD_BUTTON = registerBlock("aerowood_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.IRON, 10, true));
    public static final Block AEROWOOD_PRESSURE_PLATE = registerBlock("aerowood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.IRON));

    public static final Block AEROWOOD_FENCE = registerBlock("aerowood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block AEROWOOD_FENCE_GATE = registerBlock("aerowood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), WoodType.OAK));
    public static final Block AEROWOOD_WALL = registerBlock("aerowood_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block AEROWOOD_DOOR = registerBlock("aerowood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque(), BlockSetType.OAK));
    public static final Block AEROWOOD_TRAPDOOR = registerBlock("aerowood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque(), BlockSetType.OAK));


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