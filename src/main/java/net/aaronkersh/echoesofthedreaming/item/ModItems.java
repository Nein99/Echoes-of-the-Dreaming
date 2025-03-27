package net.aaronkersh.echoesofthedreaming.item;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.aaronkersh.echoesofthedreaming.entity.ModEntities;
import net.aaronkersh.echoesofthedreaming.item.custom.BismuthArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.*;

public class ModItems {
    public static final Item MOURNSTEEL_INGOT = registerItem("mournsteel_ingot", new Item(new FabricItemSettings()));
    public static final Item MOURNSTEEL_NUGGET = registerItem("mournsteel_nugget", new Item(new FabricItemSettings()));
    public static final Item MOURNCRYST = registerItem("mourncryst", new Item(new FabricItemSettings()));
    public static final Item MOURNCRYST_BLACKENED = registerItem("mourncryst_blackened", new Item(new FabricItemSettings()));
    public static final Item VANADINITE = registerItem("vanadinite", new Item(new FabricItemSettings()));
    public static final Item VANADIUM = registerItem("vanadium", new Item(new FabricItemSettings()));
    public static final Item VANADIUM_PENTOXIDE = registerItem("vanadium_pentoxide", new Item(new FabricItemSettings()));
    public static final Item RAW_BISMUTH = registerItem("raw_bismuth", new Item(new FabricItemSettings()));
    public static final Item BISMUTH = registerItem("bismuth", new Item(new FabricItemSettings()));
    public static final Item BISMUTH_NUGGET = registerItem("bismuth_nugget", new Item(new FabricItemSettings()));
    public static final Item POWDERED_BISMUTH = registerItem("powdered_bismuth", new Item(new FabricItemSettings()));
    public static final Item PLANAR_TUNING_FORK = registerItem("planar_tuning_fork", new Item(new FabricItemSettings()));
    public static final Item CURSED_SOULSTONE = registerItem("cursed_soulstone", new Item(new FabricItemSettings()));

    public static final Item BLACK_SAPPHIRE = registerItem("black_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item BLUE_SAPPHIRE = registerItem("blue_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item BLUE_STAR_SAPPHIRE = registerItem("blue_star_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item BROWN_SAPPHIRE = registerItem("brown_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item GREEN_SAPPHIRE = registerItem("green_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item GREY_SAPPHIRE = registerItem("grey_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item ORANGE_SAPPHIRE = registerItem("orange_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item PINK_SAPPHIRE = registerItem("pink_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item PURPLE_SAPPHIRE = registerItem("purple_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item WHITE_SAPPHIRE = registerItem("white_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item YELLOW_SAPPHIRE = registerItem("yellow_sapphire",
            new Item(new FabricItemSettings()));
    public static final Item UNCUT_CORUNDUM = registerItem("uncut_corundum",
            new Item(new FabricItemSettings()));
    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings()));
    public static final Item STAR_RUBY = registerItem("star_ruby",
            new Item(new FabricItemSettings()));

    public static final Item MOURNSTEEL_PICKAXE = registerItem("mournsteel_pickaxe",
            new MournsteelPickaxeItem(MournsteelToolMaterial.MOURNSTEEL, 2, 2f, new FabricItemSettings()));
    public static final Item MOURNSTEEL_AXE = registerItem("mournsteel_axe",
            new MournsteelAxeItem(MournsteelToolMaterial.MOURNSTEEL, 3, 1f, new FabricItemSettings()));
    public static final Item MOURNSTEEL_SHOVEL = registerItem("mournsteel_shovel",
            new MournsteelShovelItem(MournsteelToolMaterial.MOURNSTEEL, 0, 0f, new FabricItemSettings()));
    public static final Item MOURNSTEEL_SWORD = registerItem("mournsteel_sword",
            new MournsteelSwordItem(MournsteelToolMaterial.MOURNSTEEL, 5, 3f, new FabricItemSettings()));
    public static final Item MOURNSTEEL_HOE = registerItem("mournsteel_hoe",
            new MournsteelHoeItem(MournsteelToolMaterial.MOURNSTEEL, 0, 0f, new FabricItemSettings()));

    public static final Item BISMUTH_PICKAXE = registerItem("bismuth_pickaxe",
            new BismuthPickaxeItem(BismuthToolMaterial.BISMUTH, 2, 2f, new FabricItemSettings()));
    public static final Item BISMUTH_AXE = registerItem("bismuth_axe",
            new BismuthAxeItem(BismuthToolMaterial.BISMUTH, 3, 1f, new FabricItemSettings()));
    public static final Item BISMUTH_SHOVEL = registerItem("bismuth_shovel",
            new BismuthShovelItem(BismuthToolMaterial.BISMUTH, 0, 0f, new FabricItemSettings()));
    public static final Item BISMUTH_SWORD = registerItem("bismuth_sword",
            new BismuthSwordItem(BismuthToolMaterial.BISMUTH, 5, 3f, new FabricItemSettings()));
    public static final Item BISMUTH_HOE = registerItem("bismuth_hoe",
            new BismuthHoeItem(BismuthToolMaterial.BISMUTH, 0, 0f, new FabricItemSettings()));

    public static final Item BISMUTH_HELMET = registerItem("bismuth_helmet",
            new BismuthArmorItem(ModArmorMaterials.BISMUTH, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item BISMUTH_CHESTPLATE = registerItem("bismuth_chestplate",
            new BismuthArmorItem(ModArmorMaterials.BISMUTH, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BISMUTH_LEGGINGS = registerItem("bismuth_leggings",
            new BismuthArmorItem(ModArmorMaterials.BISMUTH, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BISMUTH_BOOTS = registerItem("bismuth_boots",
            new BismuthArmorItem(ModArmorMaterials.BISMUTH, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item MOURNING_OREWALKER_SPAWN_EGG = registerItem("mourning_orewalker_spawn_egg",
            new SpawnEggItem(ModEntities.MOURNING_OREWALKER, 0x5C6078, 0x232431, new FabricItemSettings()));
    public static final Item BISMUTH_OREWALKER_SPAWN_EGG = registerItem("bismuth_orewalker_spawn_egg",
            new SpawnEggItem(ModEntities.BISMUTH_OREWALKER, 0xCB3EB0, 0x54A580, new FabricItemSettings()));

    public static final Item AEROWOOD_SIGN = registerItem("aerowood_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.STANDING_AEROWOOD_SIGN, ModBlocks.WALL_AEROWOOD_SIGN));
    public static final Item HANGING_AEROWOOD_SIGN = registerItem("aerowood_hanging_sign",
            new HangingSignItem(ModBlocks.HANGING_AEROWOOD_SIGN, ModBlocks.WALL_HANGING_AEROWOOD_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item SUNBEAM_SIGN = registerItem("sunbeam_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.STANDING_SUNBEAM_SIGN, ModBlocks.WALL_SUNBEAM_SIGN));
    public static final Item HANGING_SUNBEAM_SIGN = registerItem("sunbeam_hanging_sign",
            new HangingSignItem(ModBlocks.HANGING_SUNBEAM_SIGN, ModBlocks.WALL_HANGING_SUNBEAM_SIGN, new FabricItemSettings().maxCount(16)));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(MOURNSTEEL_INGOT);
        entries.add(MOURNSTEEL_NUGGET);
        entries.add(MOURNCRYST);
        entries.add(MOURNCRYST_BLACKENED);
        entries.add(VANADINITE);
        entries.add(VANADIUM);
        entries.add(RAW_BISMUTH);
        entries.add(BISMUTH);
        entries.add(POWDERED_BISMUTH);

    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EchoesOfTheDreaming.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EchoesOfTheDreaming.LOGGER.info("Registering Mod Items for " + EchoesOfTheDreaming.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
