package net.aaronkersh.echoesofthedreaming.world;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.aaronkersh.echoesofthedreaming.world.feature.BismuthCrystalFeature;
import net.aaronkersh.echoesofthedreaming.world.feature.BismuthCrystalFeatureConfig;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOURNCRYST_ORE_KEY = registerKey("mourncryst_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VANADINITE_ORE_KEY = registerKey("vanadinite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BISMUTH_ORE_KEY = registerKey("bismuth_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BISMUTH_CRYSTAL_KEY = registerKey("bismuth_crystal");

    public static void registerFeatures() {
        BISMUTH_CRYSTAL_FEATURE = Registry.register(
                Registries.FEATURE,
                new Identifier(EchoesOfTheDreaming.MOD_ID, "bismuth_crystal"),
                new BismuthCrystalFeature(BismuthCrystalFeatureConfig.CODEC)
        );
    }

    public static Feature<BismuthCrystalFeatureConfig> BISMUTH_CRYSTAL_FEATURE;

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldMourncrystOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.MOURNCRYST_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.MOURNCRYST_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldVanadiniteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.VANADINITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.VANADINITE_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldBismuthOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.BISMUTH_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.BISMUTH_DEEPSLATE_ORE.getDefaultState()));

        register(context, MOURNCRYST_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMourncrystOres, 5));
        register(context, VANADINITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldVanadiniteOres, 5));
        register(context, BISMUTH_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldVanadiniteOres, 5));

        if (BISMUTH_CRYSTAL_FEATURE != null) {
            register(context, BISMUTH_CRYSTAL_KEY, BISMUTH_CRYSTAL_FEATURE,
                    new BismuthCrystalFeatureConfig(
                            BlockStateProvider.of(ModBlocks.BISMUTH_BLOCK),
                            32,    // maxSize - determines how large the crystal can be
                            1,    // stepSize - how many layers before the crystal steps inward
                            0.8f, // chance to generate satellite crystals
                            12     // maximum number of satellite crystals
                    ));
        } else {
            EchoesOfTheDreaming.LOGGER.error("Failed to register bismuth crystal feature: Feature not initialized");
        }
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EchoesOfTheDreaming.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}