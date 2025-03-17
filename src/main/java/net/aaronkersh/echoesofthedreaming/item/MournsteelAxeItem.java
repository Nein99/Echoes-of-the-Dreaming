package net.aaronkersh.echoesofthedreaming.item;

import net.aaronkersh.echoesofthedreaming.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.math.random.Random;

// Custom Mournsteel Axe
public class MournsteelAxeItem extends AxeItem {
    private static final float EFFECT_CHANCE = 0.75f;
    private static final int BASE_DURATION = 200;
    private static final int AMPLIFIER = 0;

    public MournsteelAxeItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.postHit(stack, target, attacker);

        if (Random.create().nextFloat() < EFFECT_CHANCE) {
            target.addStatusEffect(new StatusEffectInstance(
                    ModEffects.MALIGNANT_AURA,
                    BASE_DURATION,
                    AMPLIFIER
            ));
        }

        return result;
    }
}
