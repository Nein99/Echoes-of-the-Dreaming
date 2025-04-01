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
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.aaronkersh.echoesofthedreaming.world.gen.ModWorldGeneration;
import java.util.concurrent.ThreadLocalRandom;

public class EchoesOfTheDreaming implements ModInitializer {
	public static final String MOD_ID = "echoesofthedreaming";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	private static ItemStack getRandomGem() {
		double roll = ThreadLocalRandom.current().nextDouble() * 100;

		if (roll < 30.0) {
			return new ItemStack(ModItems.BLUE_SAPPHIRE); // 30%
		} else if (roll < 42.0) {
			return new ItemStack(ModItems.YELLOW_SAPPHIRE); // 12%
		} else if (roll < 50.0) {
			return new ItemStack(ModItems.PINK_SAPPHIRE); // 8%
		} else if (roll < 58.0) {
			return new ItemStack(ModItems.GREEN_SAPPHIRE); // 8%
		} else if (roll < 65.0) {
			return new ItemStack(ModItems.BROWN_SAPPHIRE); // 7%
		} else if (roll < 71.0) {
			return new ItemStack(ModItems.PURPLE_SAPPHIRE); // 6%
		} else if (roll < 77.0) {
			return new ItemStack(ModItems.BLACK_SAPPHIRE); // 6%
		} else if (roll < 83.0) {
			return new ItemStack(ModItems.RUBY); // 6%
		} else if (roll < 88.0) {
			return new ItemStack(ModItems.GREY_SAPPHIRE); // 5%
		} else if (roll < 92.0) {
			return new ItemStack(ModItems.ORANGE_SAPPHIRE); // 4%
		} else if (roll < 96.0) {
			return new ItemStack(ModItems.WHITE_SAPPHIRE); // 4%
		} else if (roll < 98.5) {
			return new ItemStack(ModItems.BLUE_STAR_SAPPHIRE); // 2.5%
		} else {
			return new ItemStack(ModItems.STAR_RUBY); // 1.5%
		}
	}


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

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.BLUE_SAPPHIRE_BLOCK)
				.lightWithItem(ModItems.PLANAR_TUNING_FORK)
				.destDimID(new Identifier(EchoesOfTheDreaming.MOD_ID, "elemental_water"))
				.tintColor(0x001C42)
				.registerPortal();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.BROWN_SAPPHIRE_BLOCK)
				.lightWithItem(ModItems.PLANAR_TUNING_FORK)
				.destDimID(new Identifier(EchoesOfTheDreaming.MOD_ID, "elemental_earth"))
				.tintColor(0x242424)
				.registerPortal();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.RUBY_BLOCK)
				.lightWithItem(ModItems.PLANAR_TUNING_FORK)
				.destDimID(new Identifier(EchoesOfTheDreaming.MOD_ID, "elemental_fire"))
				.tintColor(0xC76903)
				.registerPortal();

		InfiniteVerticalityHandler.register();

		StrippableBlockRegistry.register(ModBlocks.AEROWOOD_LOG, ModBlocks.STRIPPED_AEROWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.AEROWOOD_WOOD, ModBlocks.STRIPPED_AEROWOOD_WOOD);

		StrippableBlockRegistry.register(ModBlocks.SUNBEAM_LOG, ModBlocks.STRIPPED_SUNBEAM_LOG);
		StrippableBlockRegistry.register(ModBlocks.SUNBEAM_WOOD, ModBlocks.STRIPPED_SUNBEAM_WOOD);

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if (world.isClient) return ActionResult.PASS; // Only run on server

			BlockPos pos = hitResult.getBlockPos();
			BlockState state = world.getBlockState(pos);

			// Check if block is a Grindstone
			if (state.getBlock() instanceof GrindstoneBlock) {
				ItemStack heldItem = player.getStackInHand(hand);

				// Check if the player is holding Uncut Corundum
				if (heldItem.getItem() == ModItems.UNCUT_CORUNDUM && player.isSneaking()) {
					// Select a gem based on probabilities
					ItemStack cutGem = getRandomGem();

					// Replace Uncut Corundum with the new gem
					heldItem.decrement(1);
					player.getInventory().insertStack(cutGem);

					// Give XP to player
					player.addExperience(5); // Adjust XP amount as needed

					// Play a sound effect
					world.playSound(null, pos, SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);

					return ActionResult.SUCCESS;
				}
			}

			return ActionResult.PASS;
		});
	}
}