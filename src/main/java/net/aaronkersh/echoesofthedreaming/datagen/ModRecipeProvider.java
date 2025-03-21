package net.aaronkersh.echoesofthedreaming.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.aaronkersh.echoesofthedreaming.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MOURNCRYST_SMELTABLES = List.of(ModBlocks.MOURNCRYST_BLOCK);
    private static final List<ItemConvertible> VANADINITE_SMELTABLES = List.of(ModBlocks.VANADINITE_ORE, ModBlocks.VANADINITE_DEEPSLATE_ORE);
    private static final List<ItemConvertible> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE);
    private static final List<ItemConvertible> BISMUTH_NUGGET_SMELTABLES = List.of(ModItems.POWDERED_BISMUTH);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerBlasting(exporter, MOURNCRYST_SMELTABLES, RecipeCategory.MISC, ModItems.MOURNCRYST_BLACKENED,
                0.7f, 100, "mourncryst");

        offerSmelting(exporter, VANADINITE_SMELTABLES, RecipeCategory.MISC, ModItems.VANADIUM,
                0.7f, 100, "vanadium");
        offerBlasting(exporter, VANADINITE_SMELTABLES, RecipeCategory.MISC, ModItems.VANADIUM,
                0.7f, 100, "vanadium");

        offerSmelting(exporter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH,
                0.7f, 100, "bismuth");
        offerBlasting(exporter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH,
                0.7f, 100, "bismuth");
        offerSmelting(exporter, BISMUTH_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH_NUGGET,
                0.7f, 100, "bismuth_nugget");
        offerBlasting(exporter, BISMUTH_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH_NUGGET,
                0.7f, 100, "bismuth_nugget");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOURNCRYST, RecipeCategory.DECORATIONS,
                ModBlocks.MOURNCRYST_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOURNCRYST_BLACKENED, RecipeCategory.DECORATIONS,
                ModBlocks.MOURNCRYST_BLACKENED_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANADINITE, RecipeCategory.DECORATIONS,
                ModBlocks.VANADINITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANADIUM, RecipeCategory.DECORATIONS,
                ModBlocks.VANADIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BISMUTH, RecipeCategory.DECORATIONS,
                ModBlocks.BISMUTH_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.POWDERED_BISMUTH, RecipeCategory.DECORATIONS,
                ModBlocks.BISMUTH_SAND);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOURNSTEEL_INGOT, 1)
                .input(Items.IRON_INGOT, 7)
                .input(ModItems.MOURNCRYST_BLACKENED, 1)
                .input(ModItems.VANADIUM, 1)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.MOURNCRYST_BLACKENED), conditionsFromItem(ModItems.MOURNCRYST_BLACKENED))
                .criterion(hasItem(ModItems.VANADIUM), conditionsFromItem(ModItems.VANADIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MOURNSTEEL_INGOT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PLANAR_TUNING_FORK, 1)
                .input(ModItems.MOURNSTEEL_INGOT, 1)
                .input(ModItems.BISMUTH, 1)
                .criterion(hasItem(ModItems.MOURNSTEEL_INGOT), conditionsFromItem(ModItems.MOURNSTEEL_INGOT))
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PLANAR_TUNING_FORK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BISMUTH_CRYSTALSEED, 1)
                .input(ModItems.RAW_BISMUTH, 1)
                .input(ModItems.POWDERED_BISMUTH, 2)
                .input(Items.REDSTONE, 1)
                .criterion(hasItem(ModItems.RAW_BISMUTH), conditionsFromItem(ModItems.RAW_BISMUTH))
                .criterion(hasItem(ModItems.POWDERED_BISMUTH), conditionsFromItem(ModItems.POWDERED_BISMUTH))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BISMUTH_CRYSTALSEED)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1)
                .input(ModItems.VANADINITE, 1)
                .criterion(hasItem(ModItems.VANADINITE), conditionsFromItem(ModItems.VANADINITE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.YELLOW_DYE)));
    }
}
