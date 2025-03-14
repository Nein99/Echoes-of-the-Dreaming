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
    public static final ItemGroup ECHOESOFTHEDREAMING_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "mournsteel_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.echoesofthedreaming"))
                    .icon(() -> new ItemStack(ModItems.MOURNSTEEL_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MOURNCRYST);
                        entries.add(ModItems.MOURNCRYST_BLACKENED);
                        entries.add(ModItems.MOURNSTEEL_INGOT);

                        entries.add(ModBlocks.MOURNCRYST_ORE);
                        entries.add(ModBlocks.MOURNCRYST_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MOURNCRYST_BLOCK);
                        entries.add(ModBlocks.MOURNCRYST_BLACKENED_BLOCK);
                        entries.add(ModBlocks.MOURNSTEEL_BLOCK);

                        entries.add(ModItems.VANADINITE);
                        entries.add(ModBlocks.VANADINITE_ORE);
                        entries.add(ModBlocks.VANADINITE_DEEPSLATE_ORE);
                        entries.add(ModBlocks.VANADINITE_BLOCK);

                        entries.add(ModItems.VANADIUM);
                        entries.add(ModBlocks.VANADIUM_BLOCK);

                        entries.add(ModItems.RAW_BISMUTH);
                        entries.add(ModItems.BISMUTH);
                        entries.add(ModBlocks.BISMUTH_BLOCK);

                        entries.add(ModItems.PLANAR_TUNING_FORK);

                    }).build());


    public static void registerItemGroups() {
        EchoesOfTheDreaming.LOGGER.info("Registering Item Groups for " + EchoesOfTheDreaming.MOD_ID);
    }
}
