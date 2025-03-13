package net.aaronkersh.echoesofthedreaming.item;

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

                    }).build());


    public static void registerItemGroups() {
        EchoesOfTheDreaming.LOGGER.info("Registering Item Groups for " + EchoesOfTheDreaming.MOD_ID);
    }
}
