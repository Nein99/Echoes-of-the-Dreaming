package net.aaronkersh.echoesofthedreaming.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class StabilityEffect extends StatusEffect {

    public StabilityEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // This method determines when the effect's applyUpdateEffect method should be called
        return true;  // Call on every tick
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // Check if the entity has Malignant Aura
        if (entity.hasStatusEffect(ModEffects.MALIGNANT_AURA)) {
            // Remove the Malignant Aura effect
            entity.removeStatusEffect(ModEffects.MALIGNANT_AURA);
        }
    }
}
