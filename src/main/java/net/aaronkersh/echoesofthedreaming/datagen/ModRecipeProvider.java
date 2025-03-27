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
        // Mournsteel recipes

        offerBlasting(exporter, MOURNCRYST_SMELTABLES, RecipeCategory.MISC, ModItems.MOURNCRYST_BLACKENED,
                0.7f, 100, "mourncryst");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOURNCRYST, RecipeCategory.DECORATIONS,
                ModBlocks.MOURNCRYST_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOURNCRYST_BLACKENED, RecipeCategory.DECORATIONS,
                ModBlocks.MOURNCRYST_BLACKENED_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MOURNSTEEL_BLOCK, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.MOURNSTEEL_INGOT)
                .criterion(hasItem(ModItems.MOURNSTEEL_INGOT), conditionsFromItem(ModItems.MOURNSTEEL_INGOT))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "mournsteel_block_from_ingots"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOURNSTEEL_INGOT, 1)
                .input(Items.IRON_INGOT, 7)
                .input(ModItems.MOURNCRYST_BLACKENED, 1)
                .input(ModItems.VANADIUM, 1)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.MOURNCRYST_BLACKENED), conditionsFromItem(ModItems.MOURNCRYST_BLACKENED))
                .criterion(hasItem(ModItems.VANADIUM), conditionsFromItem(ModItems.VANADIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MOURNSTEEL_INGOT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOURNSTEEL_INGOT, 9)
                .input(ModBlocks.MOURNSTEEL_BLOCK)
                .criterion(hasItem(ModBlocks.MOURNSTEEL_BLOCK), conditionsFromItem(ModBlocks.MOURNSTEEL_BLOCK))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "mournsteel_ingots_from_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOURNSTEEL_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.MOURNSTEEL_NUGGET)
                .criterion(hasItem(ModItems.MOURNSTEEL_NUGGET), conditionsFromItem(ModItems.MOURNSTEEL_NUGGET))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "mournsteel_ingot_from_nuggets"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MOURNSTEEL_NUGGET, 9)
                .input(ModItems.MOURNSTEEL_INGOT)
                .criterion(hasItem(ModItems.MOURNSTEEL_INGOT), conditionsFromItem(ModItems.MOURNSTEEL_INGOT))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "mournsteel_nuggets_from_ingot"));

        // Vanadium recipes

        offerSmelting(exporter, VANADINITE_SMELTABLES, RecipeCategory.MISC, ModItems.VANADIUM,
                0.7f, 100, "vanadium");
        offerBlasting(exporter, VANADINITE_SMELTABLES, RecipeCategory.MISC, ModItems.VANADIUM,
                0.7f, 100, "vanadium");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANADINITE, RecipeCategory.DECORATIONS,
                ModBlocks.VANADINITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VANADIUM, RecipeCategory.DECORATIONS,
                ModBlocks.VANADIUM_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VANADIUM_PENTOXIDE, 9)
                .input(ModItems.VANADINITE, 1)
                .criterion(hasItem(ModItems.VANADINITE), conditionsFromItem(ModItems.VANADINITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VANADIUM_PENTOXIDE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.ORANGE_DYE, 9)
                .input(ModItems.VANADIUM_PENTOXIDE, 1)
                .criterion(hasItem(ModItems.VANADIUM_PENTOXIDE), conditionsFromItem(ModItems.VANADIUM_PENTOXIDE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.ORANGE_DYE)));

        // Bismuth recipes

        offerSmelting(exporter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH,
                0.7f, 100, "bismuth");
        offerBlasting(exporter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH,
                0.7f, 100, "bismuth");
        offerSmelting(exporter, BISMUTH_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH_NUGGET,
                0.7f, 100, "bismuth_nugget");
        offerBlasting(exporter, BISMUTH_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH_NUGGET,
                0.7f, 100, "bismuth_nugget");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BISMUTH, RecipeCategory.DECORATIONS,
                ModBlocks.BISMUTH_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.POWDERED_BISMUTH, RecipeCategory.DECORATIONS,
                ModBlocks.BISMUTH_SAND);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BISMUTH_CRYSTALSEED, 1)
                .input(ModItems.RAW_BISMUTH, 1)
                .input(ModItems.POWDERED_BISMUTH, 2)
                .input(Items.REDSTONE, 1)
                .criterion(hasItem(ModItems.RAW_BISMUTH), conditionsFromItem(ModItems.RAW_BISMUTH))
                .criterion(hasItem(ModItems.POWDERED_BISMUTH), conditionsFromItem(ModItems.POWDERED_BISMUTH))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BISMUTH_CRYSTALSEED)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POWDERED_BISMUTH, 1)
                .input(ModItems.BISMUTH_NUGGET)
                .criterion(hasItem(ModItems.BISMUTH_NUGGET), conditionsFromItem(ModItems.BISMUTH_NUGGET))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "powdered_bismuth_from_nuggets"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POWDERED_BISMUTH, 9)
                .input(ModItems.RAW_BISMUTH)
                .criterion(hasItem(ModItems.RAW_BISMUTH), conditionsFromItem(ModItems.RAW_BISMUTH))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "powdered_bismuth_from_raw_bismuth"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BISMUTH, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.BISMUTH_NUGGET)
                .criterion(hasItem(ModItems.BISMUTH_NUGGET), conditionsFromItem(ModItems.BISMUTH_NUGGET))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "bismuth_from_nuggets"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BISMUTH_NUGGET, 9)
                .input(ModItems.BISMUTH)
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "bismuth_nuggets_from_bismuth"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.WHITE_DYE, 9)
                .input(ModItems.POWDERED_BISMUTH, 1)
                .criterion(hasItem(ModItems.POWDERED_BISMUTH), conditionsFromItem(ModItems.POWDERED_BISMUTH))
                .offerTo(exporter, new Identifier(getRecipeName(Items.WHITE_DYE)));

        // Corundum recipes

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.BLACK_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BLUE_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.BLUE_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BROWN_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.BROWN_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GREEN_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.GREEN_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GREY_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.GREY_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ORANGE_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.ORANGE_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.PINK_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PURPLE_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.PURPLE_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.WHITE_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.WHITE_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOW_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.YELLOW_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);

        // Aerowood recipes

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_PLANKS, 4)
                .input(ModBlocks.AEROWOOD_LOG)
                .criterion(hasItem(ModBlocks.AEROWOOD_LOG), conditionsFromItem(ModBlocks.AEROWOOD_LOG))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "aerowood_planks_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_PLANKS, 4)
                .input(ModBlocks.STRIPPED_AEROWOOD_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_AEROWOOD_LOG), conditionsFromItem(ModBlocks.STRIPPED_AEROWOOD_LOG))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "aerowood_planks_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_PLANKS, 4)
                .input(ModBlocks.AEROWOOD_WOOD)
                .criterion(hasItem(ModBlocks.AEROWOOD_WOOD), conditionsFromItem(ModBlocks.AEROWOOD_WOOD))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "aerowood_planks_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_PLANKS, 4)
                .input(ModBlocks.STRIPPED_AEROWOOD_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_AEROWOOD_WOOD), conditionsFromItem(ModBlocks.STRIPPED_AEROWOOD_WOOD))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "aerowood_planks_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_STAIRS, 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .input('P', ModBlocks.AEROWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_SLAB, 6)
                .pattern("PPP")
                .input('P', ModBlocks.AEROWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_FENCE, 3)
                .pattern("PSP")
                .pattern("PSP")
                .input('P', ModBlocks.AEROWOOD_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_FENCE_GATE, 1)
                .pattern("SPS")
                .pattern("SPS")
                .input('P', ModBlocks.AEROWOOD_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.AEROWOOD_DOOR, 3)
                .pattern("PP")
                .pattern("PP")
                .pattern("PP")
                .input('P', ModBlocks.AEROWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.AEROWOOD_TRAPDOOR, 2)
                .pattern("PPP")
                .pattern("PPP")
                .input('P', ModBlocks.AEROWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.AEROWOOD_BUTTON, 1)
                .input(ModBlocks.AEROWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.AEROWOOD_PRESSURE_PLATE, 1)
                .pattern("PP")
                .input('P', ModBlocks.AEROWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AEROWOOD_WALL, 6)
                .pattern("SSS")
                .pattern("PPP")
                .input('P', ModBlocks.AEROWOOD_PLANKS)
                .input('S', ModBlocks.AEROWOOD_SLAB)
                .criterion(hasItem(ModBlocks.AEROWOOD_PLANKS), conditionsFromItem(ModBlocks.AEROWOOD_PLANKS))
                .criterion(hasItem(ModBlocks.AEROWOOD_SLAB), conditionsFromItem(ModBlocks.AEROWOOD_SLAB))
                .offerTo(exporter);

        // Sunbeam recipes

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_PLANKS, 4)
                .input(ModBlocks.SUNBEAM_LOG)
                .criterion(hasItem(ModBlocks.SUNBEAM_LOG), conditionsFromItem(ModBlocks.SUNBEAM_LOG))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "sunbeam_planks_from_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_PLANKS, 4)
                .input(ModBlocks.STRIPPED_SUNBEAM_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_SUNBEAM_LOG), conditionsFromItem(ModBlocks.STRIPPED_SUNBEAM_LOG))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "sunbeam_planks_from_stripped_log"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_PLANKS, 4)
                .input(ModBlocks.SUNBEAM_WOOD)
                .criterion(hasItem(ModBlocks.SUNBEAM_WOOD), conditionsFromItem(ModBlocks.SUNBEAM_WOOD))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "sunbeam_planks_from_wood"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_PLANKS, 4)
                .input(ModBlocks.STRIPPED_SUNBEAM_WOOD)
                .criterion(hasItem(ModBlocks.STRIPPED_SUNBEAM_WOOD), conditionsFromItem(ModBlocks.STRIPPED_SUNBEAM_WOOD))
                .offerTo(exporter, new Identifier("echoesofthedreaming", "sunbeam_planks_from_stripped_wood"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_STAIRS, 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .input('P', ModBlocks.SUNBEAM_PLANKS)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_SLAB, 6)
                .pattern("PPP")
                .input('P', ModBlocks.SUNBEAM_PLANKS)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_FENCE, 3)
                .pattern("PSP")
                .pattern("PSP")
                .input('P', ModBlocks.SUNBEAM_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_FENCE_GATE, 1)
                .pattern("SPS")
                .pattern("SPS")
                .input('P', ModBlocks.SUNBEAM_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SUNBEAM_DOOR, 3)
                .pattern("PP")
                .pattern("PP")
                .pattern("PP")
                .input('P', ModBlocks.SUNBEAM_PLANKS)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SUNBEAM_TRAPDOOR, 2)
                .pattern("PPP")
                .pattern("PPP")
                .input('P', ModBlocks.SUNBEAM_PLANKS)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SUNBEAM_BUTTON, 1)
                .input(ModBlocks.SUNBEAM_PLANKS)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SUNBEAM_PRESSURE_PLATE, 1)
                .pattern("PP")
                .input('P', ModBlocks.SUNBEAM_PLANKS)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNBEAM_WALL, 6)
                .pattern("SSS")
                .pattern("PPP")
                .input('P', ModBlocks.SUNBEAM_PLANKS)
                .input('S', ModBlocks.SUNBEAM_SLAB)
                .criterion(hasItem(ModBlocks.SUNBEAM_PLANKS), conditionsFromItem(ModBlocks.SUNBEAM_PLANKS))
                .criterion(hasItem(ModBlocks.SUNBEAM_SLAB), conditionsFromItem(ModBlocks.SUNBEAM_SLAB))
                .offerTo(exporter);

        // Other recipes

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PLANAR_TUNING_FORK, 1)
                .input(ModItems.MOURNSTEEL_INGOT, 1)
                .input(ModItems.BISMUTH, 1)
                .criterion(hasItem(ModItems.MOURNSTEEL_INGOT), conditionsFromItem(ModItems.MOURNSTEEL_INGOT))
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PLANAR_TUNING_FORK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 18)
                .input(ModItems.POWDERED_BISMUTH, 1)
                .input(ModItems.VANADIUM_PENTOXIDE, 1)
                .criterion(hasItem(ModItems.POWDERED_BISMUTH), conditionsFromItem(ModItems.POWDERED_BISMUTH))
                .criterion(hasItem(ModItems.VANADIUM_PENTOXIDE), conditionsFromItem(ModItems.VANADIUM_PENTOXIDE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.YELLOW_DYE)));
    }
}
