package net.aaronkersh.echoesofthedreaming.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.aaronkersh.echoesofthedreaming.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MOURNCRYST_BLOCK);
        addDrop(ModBlocks.MOURNCRYST_BLACKENED_BLOCK);
        addDrop(ModBlocks.MOURNSTEEL_BLOCK);
        addDrop(ModBlocks.VANADINITE_BLOCK);
        addDrop(ModBlocks.VANADIUM_BLOCK);

        addDrop(ModBlocks.MOURNCRYST_ORE, copperLikeOreDrops(ModBlocks.MOURNCRYST_ORE, ModItems.MOURNCRYST));
        addDrop(ModBlocks.MOURNCRYST_DEEPSLATE_ORE, copperLikeOreDrops(ModBlocks.MOURNCRYST_DEEPSLATE_ORE, ModItems.MOURNCRYST));
        addDrop(ModBlocks.VANADINITE_ORE, copperLikeOreDrops(ModBlocks.VANADINITE_ORE, ModItems.VANADINITE));
        addDrop(ModBlocks.VANADINITE_DEEPSLATE_ORE, copperLikeOreDrops(ModBlocks.VANADINITE_DEEPSLATE_ORE, ModItems.VANADINITE));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
