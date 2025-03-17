package net.aaronkersh.echoesofthedreaming.effect;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect MALIGNANT_AURA = Registry.register(
            Registries.STATUS_EFFECT,
            new Identifier("echoesofthedreaming", "malignant_aura"),
            new MalignantAuraEffect(StatusEffectCategory.HARMFUL, 0x660033) // Dark purple color
    );


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(EchoesOfTheDreaming.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        EchoesOfTheDreaming.LOGGER.info("Registering Mod Effects for " + EchoesOfTheDreaming.MOD_ID);
    }
}
