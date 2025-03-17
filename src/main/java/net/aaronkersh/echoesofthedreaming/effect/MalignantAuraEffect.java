package net.aaronkersh.echoesofthedreaming.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.random.Random;

public class MalignantAuraEffect extends StatusEffect {
    // Constants for effect chances and timings
    private static final float BLINDNESS_CHANCE = 0.15f;
    private static final float NAUSEA_CHANCE = 0.20f;
    private static final float SLOWNESS_CHANCE = 0.25f;
    private static final float WEAKNESS_CHANCE = 0.30f;

    // Random intervals between health loss (in ticks)
    private static final int MIN_DAMAGE_INTERVAL = 10; // 0.5 seconds
    private static final int MAX_DAMAGE_INTERVAL = 50; // 2.5 seconds

    // Track timing between damage applications
    private int tickCounter = 0;
    private int nextDamageInterval = 60; // Start with 3 seconds

    private final Random random = Random.create();

    public MalignantAuraEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // This method determines when the effect's applyUpdateEffect method should be called
        // For random intervals, we'll always return true and handle timing in applyUpdateEffect
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // Increment our tick counter
        tickCounter++;

        // Check if it's time to apply damage (like wither effect)
        if (tickCounter >= nextDamageInterval) {
            // Reset counter and generate new random interval
            tickCounter = 0;
            nextDamageInterval = random.nextBetween(MIN_DAMAGE_INTERVAL, MAX_DAMAGE_INTERVAL);

            // Apply damage like wither effect
            entity.damage(entity.getDamageSources().wither(), 1.0F + amplifier);

            // Apply random additional effects based on chances
            applyRandomAdditionalEffects(entity, amplifier);
        }
    }

    private void applyRandomAdditionalEffects(LivingEntity entity, int amplifier) {
        // Check for blindness
        if (random.nextFloat() < BLINDNESS_CHANCE) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 0));
        }

        // Check for nausea
        if (random.nextFloat() < NAUSEA_CHANCE) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
        }

        // Check for slowness
        if (random.nextFloat() < SLOWNESS_CHANCE) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 150, amplifier > 0 ? 1 : 0));
        }

        // Check for weakness
        if (random.nextFloat() < WEAKNESS_CHANCE) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, amplifier > 0 ? 1 : 0));
        }
    }

    // clear all secondary effects when Malignant Aura is removed
    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);

        // Remove all the secondary effects when the main effect expires
        entity.removeStatusEffect(StatusEffects.BLINDNESS);
        entity.removeStatusEffect(StatusEffects.NAUSEA);
        entity.removeStatusEffect(StatusEffects.SLOWNESS);
        entity.removeStatusEffect(StatusEffects.WEAKNESS);
    }
}