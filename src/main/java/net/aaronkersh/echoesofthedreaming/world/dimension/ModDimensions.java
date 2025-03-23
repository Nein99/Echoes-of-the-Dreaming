package net.aaronkersh.echoesofthedreaming.world.dimension;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> ELEMENTAL_AIR_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "elemental_air"));
    public static final RegistryKey<World> ELEMENTAL_AIR_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "elemental_air"));
    public static final RegistryKey<DimensionType> ELEMENTAL_AIR_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "elemental_air_type"));

    public static final RegistryKey<ChunkGeneratorSettings> ELEMENTAL_AIR_NOISE_KEY = RegistryKey.of(
            RegistryKeys.CHUNK_GENERATOR_SETTINGS,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "elemental_air_noise"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(ELEMENTAL_AIR_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }

    public static void bootstrapNoiseSettings(Registerable<ChunkGeneratorSettings> context) {
        // in JSON
    }
}