package net.aaronkersh.echoesofthedreaming.effect;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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

    // Map to track applied effects per entity
    private static final Map<UUID, Set<StatusEffect>> entityEffectsMap = new HashMap<>();

    public MalignantAuraEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
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
        UUID entityId = entity.getUuid();

        // Ensure the entity has an entry in our tracking map
        if (!entityEffectsMap.containsKey(entityId)) {
            entityEffectsMap.put(entityId, new HashSet<>());
        }

        Set<StatusEffect> appliedEffects = entityEffectsMap.get(entityId);

        // Check for blindness
        if (random.nextFloat() < BLINDNESS_CHANCE) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 0));
            appliedEffects.add(StatusEffects.BLINDNESS);
        }

        // Check for nausea
        if (random.nextFloat() < NAUSEA_CHANCE) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
            appliedEffects.add(StatusEffects.NAUSEA);
        }

        // Check for slowness
        if (random.nextFloat() < SLOWNESS_CHANCE) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 150, amplifier > 0 ? 1 : 0));
            appliedEffects.add(StatusEffects.SLOWNESS);
        }

        // Check for weakness
        if (random.nextFloat() < WEAKNESS_CHANCE) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, amplifier > 0 ? 1 : 0));
            appliedEffects.add(StatusEffects.WEAKNESS);
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);

        UUID entityId = entity.getUuid();

        // Check if we have effects to clean up for this entity
        if (entityEffectsMap.containsKey(entityId)) {
            Set<StatusEffect> appliedEffects = entityEffectsMap.get(entityId);

            // Handle removal safely using the server executor if on the server side
            if (!entity.getWorld().isClient()) {
                entity.getWorld().getServer().execute(() -> {
                    for (StatusEffect effect : appliedEffects) {
                        entity.removeStatusEffect(effect);
                    }
                    entityEffectsMap.remove(entityId);
                });
            } else {
                // Direct removal on client side
                for (StatusEffect effect : appliedEffects) {
                    entity.removeStatusEffect(effect);
                }
                entityEffectsMap.remove(entityId);
            }
        }
    }
}