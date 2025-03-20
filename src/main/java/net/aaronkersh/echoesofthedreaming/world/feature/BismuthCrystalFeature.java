package net.aaronkersh.echoesofthedreaming.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class BismuthCrystalFeature extends Feature<BismuthCrystalFeatureConfig> {
    public BismuthCrystalFeature(Codec<BismuthCrystalFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<BismuthCrystalFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        BismuthCrystalFeatureConfig config = context.getConfig();

        // Check if we have space to generate
        if (!isValidLocation(world, origin)) {
            return false;
        }

        // Generate the main crystal
        generateCrystal(world, origin, random, config);

        // Possibly generate smaller satellite crystals
        if (random.nextFloat() < config.satelliteCrystalChance()) {
            int satelliteCount = random.nextBetween(1, config.maxSatelliteCrystals());
            for (int i = 0; i < satelliteCount; i++) {
                int xOffset = random.nextBetween(-5, 5);
                int zOffset = random.nextBetween(-5, 5);
                BlockPos satellitePos = origin.add(xOffset, 0, zOffset);

                // Make sure satellite position is valid
                if (isValidLocation(world, satellitePos)) {
                    int satelliteSize = random.nextBetween(2, Math.max(2, config.maxSize() / 2));
                    generateCrystal(world, satellitePos, random,
                            new BismuthCrystalFeatureConfig(
                                    config.blockStateProvider(),
                                    satelliteSize,
                                    config.stepSize(),
                                    config.satelliteCrystalChance(),
                                    config.maxSatelliteCrystals()
                            )
                    );
                }
            }
        }

        return true;
    }

    private boolean isValidLocation(StructureWorldAccess world, BlockPos pos) {
        // Check if the position is on solid ground and has space above
        return world.getBlockState(pos.down()).isSolid() && world.isAir(pos);
    }

    private void generateCrystal(StructureWorldAccess world, BlockPos origin, Random random, BismuthCrystalFeatureConfig config) {
        BlockStateProvider blockProvider = config.blockStateProvider();
        int maxSize = random.nextBetween(config.maxSize() / 2, config.maxSize());
        int stepSize = config.stepSize();

        // Sometimes generate an inverted crystal pointing in other directions
        // TODO: this doesn't actually work, all crystals are vertical
        if (random.nextFloat() < 0.2f) {
            generateCrystalDirection(world, origin.down(), random, blockProvider,
                    Math.max(2, maxSize / 2), stepSize, Direction.NORTH);
        }

        if (random.nextFloat() < 0.4f) {
            generateCrystalDirection(world, origin.down(), random, blockProvider,
                    Math.max(2, maxSize / 2), stepSize, Direction.SOUTH);
        }

        if (random.nextFloat() < 0.6f) {
            generateCrystalDirection(world, origin.down(), random, blockProvider,
                    Math.max(2, maxSize / 2), stepSize, Direction.EAST);
        }

        if (random.nextFloat() < 0.8f) {
            generateCrystalDirection(world, origin.down(), random, blockProvider,
                    Math.max(2, maxSize / 2), stepSize, Direction.WEST);
        }

        if (random.nextFloat() < 0.9f) {
            generateCrystalDirection(world, origin.down(), random, blockProvider,
                    Math.max(2, maxSize / 2), stepSize, Direction.DOWN);
        }

        if (random.nextFloat() < 1.0f) {
            generateCrystalDirection(world, origin.down(), random, blockProvider,
                    Math.max(2, maxSize / 2), stepSize, Direction.UP);
        }
    }

    private void generateCrystalDirection(StructureWorldAccess world, BlockPos origin, Random random,
                                          BlockStateProvider blockProvider, int maxSize, int stepSize, Direction direction) {
        int height = 0;
        int currentSize = maxSize;

        while (currentSize > 0) {
            // Generate the current layer as a square
            for (int x = -currentSize / 2; x <= currentSize / 2; x++) {
                for (int z = -currentSize / 2; z <= currentSize / 2; z++) {
                    // Only place blocks on the perimeter for a hollow effect
                    if (x == -currentSize / 2 || x == currentSize / 2 ||
                            z == -currentSize / 2 || z == currentSize / 2) {

                        BlockPos pos = origin.add(x, direction == Direction.UP ? height : -height, z);
                        BlockState state = blockProvider.get(random, pos);

                        // Add some randomness to make crystals look more natural
                        if (random.nextFloat() > 0.15f) { // chance to skip a block for variety
                            world.setBlockState(pos, state, 2);
                        }
                    }
                }
            }

            // Move up and decrease the size for next layer
            height++;
            if (height % stepSize == 0) {
                currentSize -= 2;
            }
        }
    }
}