package net.aaronkersh.echoesofthedreaming;

import net.aaronkersh.echoesofthedreaming.effect.ModEffects;
import net.aaronkersh.echoesofthedreaming.entity.ModEntities;
import net.aaronkersh.echoesofthedreaming.entity.custom.BismuthOrewalkerEntity;
import net.aaronkersh.echoesofthedreaming.entity.custom.MourningOrewalkerEntity;
import net.aaronkersh.echoesofthedreaming.event.MiningEventHandler;
import net.aaronkersh.echoesofthedreaming.item.ModItemGroups;
import net.aaronkersh.echoesofthedreaming.potion.ModPotions;
import net.aaronkersh.echoesofthedreaming.world.ModConfiguredFeatures;
import net.aaronkersh.echoesofthedreaming.world.dimension.InfiniteVerticalityHandler;
import net.fabricmc.api.ModInitializer;

import net.aaronkersh.echoesofthedreaming.item.ModItems;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.aaronkersh.echoesofthedreaming.world.gen.ModWorldGeneration;

public class EchoesOfTheDreaming implements ModInitializer {
	public static final String MOD_ID = "echoesofthedreaming";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModConfiguredFeatures.registerFeatures();
		ModWorldGeneration.generateModWorldGen();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		FabricDefaultAttributeRegistry.register(ModEntities.MOURNING_OREWALKER, MourningOrewalkerEntity.createMourningOrewalkerAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BISMUTH_OREWALKER, BismuthOrewalkerEntity.createBismuthOrewalkerAttributes());

		MiningEventHandler.register();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.WHITE_SAPPHIRE_BLOCK)
				.lightWithItem(ModItems.PLANAR_TUNING_FORK)
				.destDimID(new Identifier(EchoesOfTheDreaming.MOD_ID, "elemental_air"))
				.tintColor(0x78A7FF)
				.registerPortal();

		InfiniteVerticalityHandler.register();

		StrippableBlockRegistry.register(ModBlocks.AEROWOOD_LOG, ModBlocks.STRIPPED_AEROWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.AEROWOOD_WOOD, ModBlocks.STRIPPED_AEROWOOD_WOOD);

		StrippableBlockRegistry.register(ModBlocks.SUNBEAM_LOG, ModBlocks.STRIPPED_SUNBEAM_LOG);
		StrippableBlockRegistry.register(ModBlocks.SUNBEAM_WOOD, ModBlocks.STRIPPED_SUNBEAM_WOOD);
	}
}