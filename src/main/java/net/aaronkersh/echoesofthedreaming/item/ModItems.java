package net.aaronkersh.echoesofthedreaming.item;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
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
    public static final Item MOURNCRYST = registerItem("mourncryst", new Item(new FabricItemSettings()));
    public static final Item MOURNCRYST_BLACKENED = registerItem("mourncryst_blackened", new Item(new FabricItemSettings()));
    public static final Item VANADINITE = registerItem("vanadinite", new Item(new FabricItemSettings()));
    public static final Item VANADIUM = registerItem("vanadium", new Item(new FabricItemSettings()));
    public static final Item RAW_BISMUTH = registerItem("raw_bismuth", new Item(new FabricItemSettings()));
    public static final Item BISMUTH = registerItem("bismuth", new Item(new FabricItemSettings()));
    public static final Item PLANAR_TUNING_FORK = registerItem("planar_tuning_fork", new Item(new FabricItemSettings()));

    public static final Item MOURNSTEEL_PICKAXE = registerItem("mournsteel_pickaxe",
            new MournsteelPickaxeItem(ModToolMaterial.MOURNSTEEL, 2, 2f, new FabricItemSettings()));
    public static final Item MOURNSTEEL_AXE = registerItem("mournsteel_axe",
            new MournsteelAxeItem(ModToolMaterial.MOURNSTEEL, 3, 1f, new FabricItemSettings()));
    public static final Item MOURNSTEEL_SHOVEL = registerItem("mournsteel_shovel",
            new MournsteelShovelItem(ModToolMaterial.MOURNSTEEL, 0, 0f, new FabricItemSettings()));
    public static final Item MOURNSTEEL_SWORD = registerItem("mournsteel_sword",
            new MournsteelSwordItem(ModToolMaterial.MOURNSTEEL, 5, 3f, new FabricItemSettings()));
    public static final Item MOURNSTEEL_HOE = registerItem("mournsteel_hoe",
            new MournsteelHoeItem(ModToolMaterial.MOURNSTEEL, 0, 0f, new FabricItemSettings()));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(MOURNSTEEL_INGOT);
        entries.add(MOURNCRYST);
        entries.add(MOURNCRYST_BLACKENED);
        entries.add(VANADINITE);
        entries.add(VANADIUM);
        entries.add(RAW_BISMUTH);
        entries.add(BISMUTH);

    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EchoesOfTheDreaming.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EchoesOfTheDreaming.LOGGER.info("Registering Mod Items for " + EchoesOfTheDreaming.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
