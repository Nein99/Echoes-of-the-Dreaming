package net.aaronkersh.echoesofthedreaming.world.biome;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.entity.ModEntities;
import net.aaronkersh.echoesofthedreaming.world.ModPlacedFeatures;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> BISMUTH_DESERT = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "bismuth_desert"));

    public static void boostrap(Registerable<Biome> context) {
        context.register(BISMUTH_DESERT, bismuthDesert(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
    }

    public static Biome bismuthDesert(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.BISMUTH_OREWALKER, 5, 4, 4));

        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);

        // Add the bismuth crystal feature
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.BISMUTH_CRYSTAL_PLACED_KEY);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.0f)
                .temperature(1.0f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x32A598)
                        .waterFogColor(0x3F76E4)
                        .skyColor(0x6EB1FF)
                        .grassColor(0xBFB755)
                        .foliageColor(0xAEA42A)
                        .fogColor(0x22a1e6)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.CREATIVE).build())
                        .build();
    }
}
