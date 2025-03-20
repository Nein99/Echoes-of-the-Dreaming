package net.aaronkersh.echoesofthedreaming.world.biome.surface;

import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.aaronkersh.echoesofthedreaming.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(ModBlocks.BISMUTH_BLOCK);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(ModBlocks.BISMUTH_SAND);
    private static final MaterialRules.MaterialRule BISMUTH_BLOCK = makeStateRule(ModBlocks.BISMUTH_BLOCK);
    private static final MaterialRules.MaterialRule SAND = makeStateRule(ModBlocks.BISMUTH_SAND);
    private static final MaterialRules.MaterialRule BISMUTH_SAND = makeStateRule(ModBlocks.BISMUTH_SAND);
    private static final MaterialRules.MaterialRule SANDSTONE = makeStateRule(ModBlocks.BISMUTH_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, BISMUTH_SAND), BISMUTH_BLOCK);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.BISMUTH_DESERT),
                                MaterialRules.condition(MaterialRules.stoneDepth(0, true, VerticalSurfaceType.FLOOR), BISMUTH_SAND)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, BISMUTH_BLOCK)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
