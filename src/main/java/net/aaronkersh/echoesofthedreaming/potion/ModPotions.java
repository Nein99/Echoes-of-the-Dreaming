package net.aaronkersh.echoesofthedreaming.potion;


import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> MALIGNANT_AURA_POTION = registerPotion("malignant_aura_potion",
            new Potion(new StatusEffectInstance(ModEffects.MALIGNANT_AURA, 1200, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(EchoesOfTheDreaming.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        EchoesOfTheDreaming.LOGGER.info("Registering Mod Potions for " + EchoesOfTheDreaming.MOD_ID);
    }
}
