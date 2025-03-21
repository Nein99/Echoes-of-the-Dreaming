package net.aaronkersh.echoesofthedreaming.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.aaronkersh.echoesofthedreaming.entity.custom.MourningOrewalkerEntity;
import net.aaronkersh.echoesofthedreaming.entity.custom.BismuthOrewalkerEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MourningOrewalkerEntity> MOURNING_OREWALKER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "mourning_orewalker"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MourningOrewalkerEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 2.5f)).build());
    public static final EntityType<BismuthOrewalkerEntity> BISMUTH_OREWALKER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(EchoesOfTheDreaming.MOD_ID, "bismuth_orewalker"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BismuthOrewalkerEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 2.5f)).build());

}