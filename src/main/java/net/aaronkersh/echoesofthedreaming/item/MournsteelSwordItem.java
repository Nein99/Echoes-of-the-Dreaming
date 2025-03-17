package net.aaronkersh.echoesofthedreaming.item;

import net.aaronkersh.echoesofthedreaming.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.math.random.Random;

// Custom Mournsteel Sword
public class MournsteelSwordItem extends SwordItem {
    private static final float EFFECT_CHANCE = 0.75f; // 75% chance to apply effect
    private static final int BASE_DURATION = 200; // 10 seconds
    private static final int AMPLIFIER = 0; // Level 1 effect

    public MournsteelSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Apply the parent class behavior first
        boolean result = super.postHit(stack, target, attacker);

        // Apply Malignant Aura effect with a chance
        if (Random.create().nextFloat() < EFFECT_CHANCE) {
            target.addStatusEffect(new StatusEffectInstance(
                    ModEffects.MALIGNANT_AURA, // Your registered effect
                    BASE_DURATION,
                    AMPLIFIER
            ));
        }

        return result;
    }
}
