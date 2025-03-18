package net.aaronkersh.echoesofthedreaming.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class RadioactiveBlocks {
    // Constants for different radiation strengths
    public static final int STRONG_RADIATION_RANGE = 5;
    public static final float STRONG_RADIATION_CHANCE = 0.08f;
    public static final int STRONG_RADIATION_DURATION = 300; // 15 seconds
    public static final int STRONG_RADIATION_AMPLIFIER = 1; // Level II
    public static final int STRONG_TICK_RATE = 20; // Every 1 second

    public static final int MEDIUM_RADIATION_RANGE = 4;
    public static final float MEDIUM_RADIATION_CHANCE = 0.05f;
    public static final int MEDIUM_RADIATION_DURATION = 200; // 10 seconds
    public static final int MEDIUM_RADIATION_AMPLIFIER = 0; // Level I
    public static final int MEDIUM_TICK_RATE = 40; // Every 2 seconds

    public static final int WEAK_RADIATION_RANGE = 3;
    public static final float WEAK_RADIATION_CHANCE = 0.03f;
    public static final int WEAK_RADIATION_DURATION = 160; // 8 seconds
    public static final int WEAK_RADIATION_AMPLIFIER = 0; // Level I
    public static final int WEAK_TICK_RATE = 60; // Every 3 seconds

    // Create blocks with different radiation strengths
    public static RadioactiveBlock createStrongRadioactiveBlock(FabricBlockSettings settings) {
        return new RadioactiveBlock(
                settings,
                STRONG_RADIATION_RANGE,
                STRONG_RADIATION_CHANCE,
                STRONG_RADIATION_DURATION,
                STRONG_RADIATION_AMPLIFIER,
                STRONG_TICK_RATE
        );
    }

    public static RadioactiveBlock createMediumRadioactiveBlock(FabricBlockSettings settings) {
        return new RadioactiveBlock(
                settings,
                MEDIUM_RADIATION_RANGE,
                MEDIUM_RADIATION_CHANCE,
                MEDIUM_RADIATION_DURATION,
                MEDIUM_RADIATION_AMPLIFIER,
                MEDIUM_TICK_RATE
        );
    }

    public static RadioactiveBlock createWeakRadioactiveBlock(FabricBlockSettings settings) {
        return new RadioactiveBlock(
                settings,
                WEAK_RADIATION_RANGE,
                WEAK_RADIATION_CHANCE,
                WEAK_RADIATION_DURATION,
                WEAK_RADIATION_AMPLIFIER,
                WEAK_TICK_RATE
        );
    }
}
