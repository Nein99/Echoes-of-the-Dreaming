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
        addDrop(ModBlocks.BISMUTH_BLOCK);
        addDrop(ModBlocks.BISMUTH_SAND);

        addDrop(ModBlocks.BISMUTH_CRYSTALSEED);

        addDrop(ModBlocks.MOURNCRYST_ORE, copperLikeOreDrops(ModBlocks.MOURNCRYST_ORE, ModItems.MOURNCRYST));
        addDrop(ModBlocks.MOURNCRYST_DEEPSLATE_ORE, copperLikeOreDrops(ModBlocks.MOURNCRYST_DEEPSLATE_ORE, ModItems.MOURNCRYST));
        addDrop(ModBlocks.VANADINITE_ORE, copperLikeOreDrops(ModBlocks.VANADINITE_ORE, ModItems.VANADINITE));
        addDrop(ModBlocks.VANADINITE_DEEPSLATE_ORE, copperLikeOreDrops(ModBlocks.VANADINITE_DEEPSLATE_ORE, ModItems.VANADINITE));
        addDrop(ModBlocks.BISMUTH_ORE, copperLikeOreDrops(ModBlocks.BISMUTH_ORE, ModItems.RAW_BISMUTH));
        addDrop(ModBlocks.BISMUTH_DEEPSLATE_ORE, copperLikeOreDrops(ModBlocks.BISMUTH_DEEPSLATE_ORE, ModItems.RAW_BISMUTH));
        addDrop(ModBlocks.CORUNDUM_ORE, copperLikeOreDrops(ModBlocks.CORUNDUM_ORE, ModItems.UNCUT_CORUNDUM));
        addDrop(ModBlocks.CORUNDUM_DEEPSLATE_ORE, copperLikeOreDrops(ModBlocks.CORUNDUM_DEEPSLATE_ORE, ModItems.UNCUT_CORUNDUM));

        addDrop(ModBlocks.BLACK_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.BLUE_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.BROWN_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.GREEN_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.GREY_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.ORANGE_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.PINK_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.PURPLE_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.WHITE_SAPPHIRE_BLOCK);
        addDrop(ModBlocks.YELLOW_SAPPHIRE_BLOCK);

        addDrop(ModBlocks.AEROWOOD_LOG);
        addDrop(ModBlocks.AEROWOOD_WOOD);
        addDrop(ModBlocks.STRIPPED_AEROWOOD_LOG);
        addDrop(ModBlocks.STRIPPED_AEROWOOD_WOOD);
        addDrop(ModBlocks.AEROWOOD_PLANKS);

        addDrop(ModBlocks.AEROWOOD_LEAVES, leavesDrops(ModBlocks.AEROWOOD_LEAVES, ModBlocks.AEROWOOD_SAPLING, 0.0025f));
        addDrop(ModBlocks.AEROWOOD_ROOTS);

        addDrop(ModBlocks.AEROWOOD_STAIRS);
        addDrop(ModBlocks.AEROWOOD_TRAPDOOR);
        addDrop(ModBlocks.AEROWOOD_WALL);
        addDrop(ModBlocks.AEROWOOD_FENCE);
        addDrop(ModBlocks.AEROWOOD_FENCE_GATE);
        addDrop(ModBlocks.AEROWOOD_BUTTON);
        addDrop(ModBlocks.AEROWOOD_PRESSURE_PLATE);

        addDrop(ModBlocks.AEROWOOD_DOOR, doorDrops(ModBlocks.AEROWOOD_DOOR));
        addDrop(ModBlocks.AEROWOOD_SLAB, slabDrops(ModBlocks.AEROWOOD_SLAB));

        addDrop(ModBlocks.SUNBEAM_LOG);
        addDrop(ModBlocks.SUNBEAM_WOOD);
        addDrop(ModBlocks.STRIPPED_SUNBEAM_LOG);
        addDrop(ModBlocks.STRIPPED_SUNBEAM_WOOD);
        addDrop(ModBlocks.SUNBEAM_PLANKS);

        addDrop(ModBlocks.SUNBEAM_LEAVES, leavesDrops(ModBlocks.SUNBEAM_LEAVES, ModBlocks.SUNBEAM_SAPLING, 0.0025f));
        addDrop(ModBlocks.SUNBEAM_ROOTS);

        addDrop(ModBlocks.SUNBEAM_STAIRS);
        addDrop(ModBlocks.SUNBEAM_TRAPDOOR);
        addDrop(ModBlocks.SUNBEAM_WALL);
        addDrop(ModBlocks.SUNBEAM_FENCE);
        addDrop(ModBlocks.SUNBEAM_FENCE_GATE);
        addDrop(ModBlocks.SUNBEAM_BUTTON);
        addDrop(ModBlocks.SUNBEAM_PRESSURE_PLATE);

        addDrop(ModBlocks.SUNBEAM_DOOR, doorDrops(ModBlocks.SUNBEAM_DOOR));
        addDrop(ModBlocks.SUNBEAM_SLAB, slabDrops(ModBlocks.SUNBEAM_SLAB));
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
