package net.aaronkersh.echoesofthedreaming.world;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> MOURNCRYST_ORE_PLACED_KEY = registerKey("mourncryst_ore_placed");
    public static final RegistryKey<PlacedFeature> VANADINITE_ORE_PLACED_KEY = registerKey("vanadinite_ore_placed");
    public static final RegistryKey<PlacedFeature> BISMUTH_ORE_PLACED_KEY = registerKey("bismuth_ore_placed");
    public static final RegistryKey<PlacedFeature> CORUNDUM_ORE_PLACED_KEY = registerKey("corundum_ore_placed");
    public static final RegistryKey<PlacedFeature> CHROMIUM_ORE_PLACED_KEY = registerKey("chromium_ore_placed");
    public static final RegistryKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore_placed");

    public static final RegistryKey<PlacedFeature> BISMUTH_CRYSTAL_PLACED_KEY =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("echoesofthedreaming", "bismuth_crystal"));

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, MOURNCRYST_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOURNCRYST_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(12))));
        register(context, VANADINITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VANADINITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(128))));
        register(context, BISMUTH_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BISMUTH_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(256))));
        register(context, CORUNDUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CORUNDUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(256))));
        register(context, CHROMIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHROMIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(256))));
        register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TITANIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(256))));

        register(context, BISMUTH_CRYSTAL_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BISMUTH_CRYSTAL_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(2), // Adjust rarity - higher number = less common
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(EchoesOfTheDreaming.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
