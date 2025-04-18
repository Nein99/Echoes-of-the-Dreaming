package net.aaronkersh.echoesofthedreaming.item;

import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MINERALS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "minerals"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.minerals"))
                    .icon(() -> new ItemStack(ModItems.BLUE_SAPPHIRE)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.CORUNDUM_ORE);
                        entries.add(ModBlocks.CORUNDUM_DEEPSLATE_ORE);
                        entries.add(ModItems.UNCUT_CORUNDUM);

                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.STAR_RUBY);
                        entries.add(ModItems.BLACK_SAPPHIRE);
                        entries.add(ModItems.BLUE_SAPPHIRE);
                        entries.add(ModItems.BLUE_STAR_SAPPHIRE);
                        entries.add(ModItems.BROWN_SAPPHIRE);
                        entries.add(ModItems.GREEN_SAPPHIRE);
                        entries.add(ModItems.GREY_SAPPHIRE);
                        entries.add(ModItems.ORANGE_SAPPHIRE);
                        entries.add(ModItems.PINK_SAPPHIRE);
                        entries.add(ModItems.PURPLE_SAPPHIRE);
                        entries.add(ModItems.WHITE_SAPPHIRE);
                        entries.add(ModItems.YELLOW_SAPPHIRE);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.BLACK_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.BLUE_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.BROWN_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.GREEN_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.GREY_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.ORANGE_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.PINK_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.PURPLE_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.WHITE_SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.YELLOW_SAPPHIRE_BLOCK);

                        entries.add(ModBlocks.CHROMIUM_ORE);
                        entries.add(ModBlocks.CHROMIUM_DEEPSLATE_ORE);
                        entries.add(ModItems.RAW_CHROMIUM);
                        entries.add(ModBlocks.RAW_CHROMIUM_BLOCK);
                        entries.add(ModItems.CHROMIUM_INGOT);
                        entries.add(ModItems.CHROMIUM_NUGGET);
                        entries.add(ModItems.POWDERED_CHROMIUM);
                        entries.add(ModBlocks.CHROMIUM_BLOCK);

                        entries.add(ModBlocks.TITANIUM_ORE);
                        entries.add(ModBlocks.TITANIUM_DEEPSLATE_ORE);
                        entries.add(ModItems.RAW_TITANIUM);
                        entries.add(ModBlocks.RAW_TITANIUM_BLOCK);
                        entries.add(ModItems.TITANIUM_INGOT);
                        entries.add(ModItems.TITANIUM_NUGGET);
                        entries.add(ModItems.POWDERED_TITANIUM);
                        entries.add(ModBlocks.TITANIUM_BLOCK);

                        entries.add(ModBlocks.VANADINITE_ORE);
                        entries.add(ModBlocks.VANADINITE_DEEPSLATE_ORE);
                        entries.add(ModItems.VANADINITE);
                        entries.add(ModItems.VANADIUM_PENTOXIDE);
                        entries.add(ModBlocks.VANADINITE_BLOCK);
                        entries.add(ModItems.VANADIUM);
                        entries.add(ModItems.POWDERED_VANADIUM);
                        entries.add(ModBlocks.VANADIUM_BLOCK);

                        entries.add(ModBlocks.BISMUTH_ORE);
                        entries.add(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        entries.add(ModItems.RAW_BISMUTH);
                        entries.add(ModItems.BISMUTH);
                        entries.add(ModItems.BISMUTH_NUGGET);
                        entries.add(ModItems.POWDERED_BISMUTH);
                        entries.add(ModBlocks.BISMUTH_BLOCK);
                        entries.add(ModBlocks.BISMUTH_SAND);

                        entries.add(ModItems.POWDERED_IRON);

                        entries.add(ModItems.BISMUTH_PICKAXE);
                        entries.add(ModItems.BISMUTH_AXE);
                        entries.add(ModItems.BISMUTH_SHOVEL);
                        entries.add(ModItems.BISMUTH_SWORD);
                        entries.add(ModItems.BISMUTH_HOE);

                        entries.add(ModItems.BISMUTH_HELMET);
                        entries.add(ModItems.BISMUTH_CHESTPLATE);
                        entries.add(ModItems.BISMUTH_LEGGINGS);
                        entries.add(ModItems.BISMUTH_BOOTS);

                    }).build());

    public static final ItemGroup AKAHN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "akahn"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.akahn"))
                    .icon(() -> new ItemStack(ModItems.MOURNSTEEL_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MOURNCRYST);
                        entries.add(ModItems.MOURNCRYST_BLACKENED);
                        entries.add(ModItems.MOURNSTEEL_INGOT);
                        entries.add(ModItems.MOURNSTEEL_NUGGET);

                        entries.add(ModBlocks.MOURNCRYST_ORE);
                        entries.add(ModBlocks.MOURNCRYST_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MOURNCRYST_BLOCK);
                        entries.add(ModBlocks.MOURNCRYST_BLACKENED_BLOCK);
                        entries.add(ModBlocks.MOURNSTEEL_BLOCK);

                        entries.add(ModBlocks.BISMUTH_CRYSTALSEED);

                        entries.add(ModItems.PLANAR_TUNING_FORK);
                        entries.add(ModItems.CURSED_SOULSTONE);

                        entries.add(ModItems.MOURNSTEEL_PICKAXE);
                        entries.add(ModItems.MOURNSTEEL_AXE);
                        entries.add(ModItems.MOURNSTEEL_SHOVEL);
                        entries.add(ModItems.MOURNSTEEL_SWORD);
                        entries.add(ModItems.MOURNSTEEL_HOE);

                        entries.add(ModItems.MOURNING_OREWALKER_SPAWN_EGG);
                        entries.add(ModItems.BISMUTH_OREWALKER_SPAWN_EGG);


                    }).build());

    public static final ItemGroup ELEMENTALPLANES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "elementalplanes"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.elementalplanes"))
                    .icon(() -> new ItemStack(ModBlocks.SUNBEAM_LOG)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.AEROWOOD_LOG);
                        entries.add(ModBlocks.AEROWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_AEROWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_AEROWOOD_WOOD);
                        entries.add(ModBlocks.AEROWOOD_PLANKS);
                        entries.add(ModBlocks.AEROWOOD_LEAVES);
                        entries.add(ModBlocks.AEROWOOD_SAPLING);
                        entries.add(ModBlocks.AEROWOOD_ROOTS);
                        entries.add(ModBlocks.AEROWOOD_STAIRS);
                        entries.add(ModBlocks.AEROWOOD_SLAB);
                        entries.add(ModBlocks.AEROWOOD_FENCE);
                        entries.add(ModBlocks.AEROWOOD_FENCE_GATE);
                        entries.add(ModBlocks.AEROWOOD_WALL);
                        entries.add(ModBlocks.AEROWOOD_BUTTON);
                        entries.add(ModBlocks.AEROWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.AEROWOOD_DOOR);
                        entries.add(ModBlocks.AEROWOOD_TRAPDOOR);
                        entries.add(ModItems.AEROWOOD_SIGN);
                        entries.add(ModItems.HANGING_AEROWOOD_SIGN);
                        entries.add(ModBlocks.SUNBEAM_LOG);
                        entries.add(ModBlocks.SUNBEAM_WOOD);
                        entries.add(ModBlocks.STRIPPED_SUNBEAM_LOG);
                        entries.add(ModBlocks.STRIPPED_SUNBEAM_WOOD);
                        entries.add(ModBlocks.SUNBEAM_PLANKS);
                        entries.add(ModBlocks.SUNBEAM_LEAVES);
                        entries.add(ModBlocks.SUNBEAM_SAPLING);
                        entries.add(ModBlocks.SUNBEAM_ROOTS);
                        entries.add(ModBlocks.SUNBEAM_STAIRS);
                        entries.add(ModBlocks.SUNBEAM_SLAB);
                        entries.add(ModBlocks.SUNBEAM_FENCE);
                        entries.add(ModBlocks.SUNBEAM_FENCE_GATE);
                        entries.add(ModBlocks.SUNBEAM_WALL);
                        entries.add(ModBlocks.SUNBEAM_BUTTON);
                        entries.add(ModBlocks.SUNBEAM_PRESSURE_PLATE);
                        entries.add(ModBlocks.SUNBEAM_DOOR);
                        entries.add(ModBlocks.SUNBEAM_TRAPDOOR);
                        entries.add(ModItems.SUNBEAM_SIGN);
                        entries.add(ModItems.HANGING_SUNBEAM_SIGN);
                    }).build());


    public static void registerItemGroups() {
        EchoesOfTheDreaming.LOGGER.info("Registering Item Groups for " + EchoesOfTheDreaming.MOD_ID);
    }
}
