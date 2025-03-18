package net.aaronkersh.echoesofthedreaming.world;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOURNCRYST_ORE_KEY = registerKey("mourncryst_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VANADINITE_ORE_KEY = registerKey("vanadinite_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldMourncrystOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.MOURNCRYST_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.MOURNCRYST_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldVanadiniteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.VANADINITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.VANADINITE_DEEPSLATE_ORE.getDefaultState()));

        register(context, MOURNCRYST_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMourncrystOres, 5));
        register(context, VANADINITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldVanadiniteOres, 5));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EchoesOfTheDreaming.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
