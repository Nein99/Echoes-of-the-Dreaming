package net.aaronkersh.echoesofthedreaming.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public record BismuthCrystalFeatureConfig(
        BlockStateProvider blockStateProvider,
        int maxSize,
        int stepSize,
        float satelliteCrystalChance,
        int maxSatelliteCrystals
) implements FeatureConfig {

    public static final Codec<BismuthCrystalFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    BlockStateProvider.TYPE_CODEC.fieldOf("block_provider").forGetter(BismuthCrystalFeatureConfig::blockStateProvider),
                    Codec.INT.fieldOf("max_size").forGetter(BismuthCrystalFeatureConfig::maxSize),
                    Codec.INT.fieldOf("step_size").forGetter(BismuthCrystalFeatureConfig::stepSize),
                    Codec.FLOAT.fieldOf("satellite_crystal_chance").forGetter(BismuthCrystalFeatureConfig::satelliteCrystalChance),
                    Codec.INT.fieldOf("max_satellite_crystals").forGetter(BismuthCrystalFeatureConfig::maxSatelliteCrystals)
            ).apply(instance, BismuthCrystalFeatureConfig::new)
    );
}