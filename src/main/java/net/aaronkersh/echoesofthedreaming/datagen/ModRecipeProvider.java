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

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerBlasting(exporter, MOURNCRYST_SMELTABLES, RecipeCategory.MISC, ModItems.MOURNCRYST_BLACKENED,
                0.7f, 100, "mourncryst");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOURNCRYST, RecipeCategory.DECORATIONS,
                ModBlocks.MOURNCRYST_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOURNCRYST_BLACKENED, RecipeCategory.DECORATIONS,
                ModBlocks.MOURNCRYST_BLACKENED_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOURNSTEEL_INGOT, 1)
                .input(Items.IRON_INGOT, 8)
                .input(ModItems.MOURNCRYST_BLACKENED, 1)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.MOURNCRYST_BLACKENED), conditionsFromItem(ModItems.MOURNCRYST_BLACKENED))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MOURNSTEEL_INGOT)));
    }
}
