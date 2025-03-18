package net.aaronkersh.echoesofthedreaming.block;

import net.aaronkersh.echoesofthedreaming.effect.ModEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class RadioactiveBlock extends Block {
    private final int radiationRange;
    private final float radiationChance;
    private final int radiationDuration;
    private final int radiationAmplifier;
    private final int tickRate;

    public RadioactiveBlock(Settings settings, int radiationRange, float radiationChance,
                            int radiationDuration, int radiationAmplifier, int tickRate) {
        super(settings);
        this.radiationRange = radiationRange;
        this.radiationChance = radiationChance;
        this.radiationDuration = radiationDuration;
        this.radiationAmplifier = radiationAmplifier;
        this.tickRate = tickRate;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        super.randomTick(state, world, pos, random);

        // Apply radiation to nearby entities
        applyRadiationEffect(world, pos, random);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        super.scheduledTick(state, world, pos, random);

        // Schedule the next tick
        world.scheduleBlockTick(pos, this, this.tickRate);

        // Apply radiation effect
        applyRadiationEffect(world, pos, random);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        // Apply a stronger effect when stepped on directly
        if (!world.isClient() && entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(
                    ModEffects.MALIGNANT_AURA,
                    this.radiationDuration * 2, // Longer duration when stepped on
                    this.radiationAmplifier,
                    false, // ambient
                    true,  // show particles
                    true   // show icon
            ));
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);

        // Schedule the first tick when block is placed
        if (!world.isClient() && !oldState.isOf(this)) {
            world.scheduleBlockTick(pos, this, this.tickRate);
        }
    }

    private void applyRadiationEffect(World world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        if (world.isClient()) return;

        // Create a box centered on the block with radius equal to radiationRange
        Box box = new Box(
                pos.getX() - radiationRange, pos.getY() - radiationRange, pos.getZ() - radiationRange,
                pos.getX() + radiationRange + 1, pos.getY() + radiationRange + 1, pos.getZ() + radiationRange + 1
        );

        // Get all living entities within the box
        List<LivingEntity> entities = world.getNonSpectatingEntities(LivingEntity.class, box);

        for (LivingEntity entity : entities) {
            // Calculate distance-based chance (closer entities have higher chance)
            double distance = Math.sqrt(entity.squaredDistanceTo(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5));
            float distanceModifier = (float) (radiationRange - distance) / radiationRange;
            float effectiveChance = radiationChance * distanceModifier;

            // Apply effect with calculated chance
            if (random.nextFloat() < effectiveChance) {
                entity.addStatusEffect(new StatusEffectInstance(
                        ModEffects.MALIGNANT_AURA,
                        this.radiationDuration,
                        this.radiationAmplifier,
                        false, // ambient
                        true,  // show particles
                        true   // show icon
                ));
            }
        }
    }
}
