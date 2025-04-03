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
            RadioactiveBlocks.createStrongRadioactiveBlock(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.METAL).ticksRandomly()));
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

    public static final Block CHROMIUM_ORE = registerBlock("chromium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block CHROMIUM_DEEPSLATE_ORE = registerBlock("chromium_deepslate_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block RAW_CHROMIUM_BLOCK = registerBlock("raw_chromium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block CHROMIUM_BLOCK = registerBlock("chromium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)));

    public static final Block TITANIUM_ORE = registerBlock("titanium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block TITANIUM_DEEPSLATE_ORE = registerBlock("titanium_deepslate_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)));

    public static final Block CORUNDUM_ORE = registerBlock("corundum_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block CORUNDUM_DEEPSLATE_ORE = registerBlock("corundum_deepslate_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE).sounds(BlockSoundGroup.STONE)));
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block BLACK_SAPPHIRE_BLOCK = registerBlock("black_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block BLUE_SAPPHIRE_BLOCK = registerBlock("blue_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block BROWN_SAPPHIRE_BLOCK = registerBlock("brown_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block GREEN_SAPPHIRE_BLOCK = registerBlock("green_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block GREY_SAPPHIRE_BLOCK = registerBlock("grey_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block ORANGE_SAPPHIRE_BLOCK = registerBlock("orange_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block PINK_SAPPHIRE_BLOCK = registerBlock("pink_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block PURPLE_SAPPHIRE_BLOCK = registerBlock("purple_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block WHITE_SAPPHIRE_BLOCK = registerBlock("white_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));
    public static final Block YELLOW_SAPPHIRE_BLOCK = registerBlock("yellow_sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.METAL)));

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

    public static final Block SUNBEAM_LOG = registerBlock("sunbeam_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block SUNBEAM_WOOD = registerBlock("sunbeam_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_SUNBEAM_LOG = registerBlock("stripped_sunbeam_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_SUNBEAM_WOOD = registerBlock("stripped_sunbeam_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block SUNBEAM_PLANKS = registerBlock("sunbeam_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block SUNBEAM_LEAVES = registerBlock("sunbeam_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));
    public static final Block SUNBEAM_ROOTS = registerBlock("sunbeam_roots",
            new Block(FabricBlockSettings.copyOf(Blocks.MANGROVE_ROOTS).strength(4f).nonOpaque()));

    public static final Block SUNBEAM_SAPLING = registerBlock("sunbeam_sapling",
            new SaplingBlock(new AerowoodTreeGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Identifier SUNBEAM_SIGN_TEXTURE = new Identifier(EchoesOfTheDreaming.MOD_ID, "entity/signs/sunbeam");
    public static final Identifier SUNBEAM_HANGING_SIGN_TEXTURE = new Identifier(EchoesOfTheDreaming.MOD_ID, "entity/signs/hanging/sunbeam");
    public static final Identifier SUNBEAM_HANGING_GUI_SIGN_TEXTURE = new Identifier(EchoesOfTheDreaming.MOD_ID, "textures/gui/hanging_signs/sunbeam");

    public static final Block STANDING_SUNBEAM_SIGN = Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, "sunbeam_standing_sign"),
            new TerraformSignBlock(SUNBEAM_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_SUNBEAM_SIGN = Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, "sunbeam_wall_sign"),
            new TerraformWallSignBlock(SUNBEAM_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_SUNBEAM_SIGN = Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, "sunbeam_hanging_sign"),
            new TerraformHangingSignBlock(SUNBEAM_HANGING_SIGN_TEXTURE, SUNBEAM_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_SUNBEAM_SIGN = Registry.register(Registries.BLOCK, new Identifier(EchoesOfTheDreaming.MOD_ID, "sunbeam_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(SUNBEAM_HANGING_SIGN_TEXTURE, SUNBEAM_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));

    public static final BlockFamily SUNBEAM_FAMILY = BlockFamilies.register(ModBlocks.SUNBEAM_PLANKS)
            .sign(ModBlocks.STANDING_SUNBEAM_SIGN, ModBlocks.WALL_SUNBEAM_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block SUNBEAM_STAIRS = registerBlock("sunbeam_stairs",
            new StairsBlock(ModBlocks.SUNBEAM_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block SUNBEAM_SLAB = registerBlock("sunbeam_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block SUNBEAM_BUTTON = registerBlock("sunbeam_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.IRON, 10, true));
    public static final Block SUNBEAM_PRESSURE_PLATE = registerBlock("sunbeam_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), BlockSetType.IRON));

    public static final Block SUNBEAM_FENCE = registerBlock("sunbeam_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block SUNBEAM_FENCE_GATE = registerBlock("sunbeam_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), WoodType.OAK));
    public static final Block SUNBEAM_WALL = registerBlock("sunbeam_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block SUNBEAM_DOOR = registerBlock("sunbeam_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque(), BlockSetType.OAK));
    public static final Block SUNBEAM_TRAPDOOR = registerBlock("sunbeam_trapdoor",
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