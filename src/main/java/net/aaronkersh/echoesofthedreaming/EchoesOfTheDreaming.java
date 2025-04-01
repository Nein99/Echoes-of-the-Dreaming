package net.aaronkersh.echoesofthedreaming;

import net.aaronkersh.echoesofthedreaming.effect.ModEffects;
import net.aaronkersh.echoesofthedreaming.entity.ModEntities;
import net.aaronkersh.echoesofthedreaming.entity.custom.BismuthOrewalkerEntity;
import net.aaronkersh.echoesofthedreaming.entity.custom.MourningOrewalkerEntity;
import net.aaronkersh.echoesofthedreaming.event.MiningEventHandler;
import net.aaronkersh.echoesofthedreaming.item.ModItemGroups;
import net.aaronkersh.echoesofthedreaming.item.PlanarTuningForkItem;
import net.aaronkersh.echoesofthedreaming.potion.ModPotions;
import net.aaronkersh.echoesofthedreaming.util.PowderedMetalUtil;
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
import net.minecraft.block.Blocks;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.aaronkersh.echoesofthedreaming.world.gen.ModWorldGeneration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	private static ActionResult attemptMaterialRealignment(PlayerEntity player, World world, BlockPos lodestonePos) {
		ItemStack mainHandItem = player.getStackInHand(Hand.MAIN_HAND);
		ItemStack offHandItem = player.getStackInHand(Hand.OFF_HAND);

		if (!(mainHandItem.getItem() instanceof PlanarTuningForkItem)) {
			return ActionResult.PASS;
		}

		CorundumType targetGem = CorundumType.fromItem(offHandItem.getItem());
		if (targetGem == null || targetGem.isStarGem()) {
			return ActionResult.FAIL;
		}

		List<ItemEntity> nearbyItems = world.getEntitiesByClass(ItemEntity.class, new Box(lodestonePos).expand(0.5, 0.5, 0.5), item -> true);

		ItemStack inputGem = null;
		Map<Item, Integer> foundPowders = new HashMap<>();

		for (ItemEntity itemEntity : nearbyItems) {
			ItemStack stack = itemEntity.getStack();
			CorundumType type = CorundumType.fromItem(stack.getItem());

			if (type != null && !type.isStarGem()) {
				inputGem = stack;
			} else if (PowderedMetalUtil.isPowderedMetal(stack.getItem())) {
				foundPowders.put(stack.getItem(), foundPowders.getOrDefault(stack.getItem(), 0) + stack.getCount());
			}
		}

		if (inputGem == null) return ActionResult.FAIL;

		List<Item> requiredMetals = targetGem.getRequiredMetals();
		boolean isWhiteSapphireConversion = targetGem == CorundumType.WHITE_SAPPHIRE;

		if (!isWhiteSapphireConversion) {
			if (inputGem.getItem() != CorundumType.WHITE_SAPPHIRE.getItem()) return ActionResult.FAIL;
			for (Item metal : requiredMetals) {
				if (foundPowders.getOrDefault(metal, 0) == 0) return ActionResult.FAIL;
			}
		}

		world.playSound(null, lodestonePos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);

		inputGem.decrement(1);
		for (Item metal : requiredMetals) {
			removePowderItem(nearbyItems, metal);
		}

		ItemEntity newGemEntity = new ItemEntity(world, lodestonePos.getX() + 0.5, lodestonePos.getY() + 1, lodestonePos.getZ() + 0.5, new ItemStack(targetGem.getItem()));
		world.spawnEntity(newGemEntity);

		return ActionResult.SUCCESS;
	}

	private static void removePowderItem(List<ItemEntity> itemEntities, Item metal) {
		for (ItemEntity entity : itemEntities) {
			ItemStack stack = entity.getStack();
			if (stack.getItem() == metal) {
				stack.decrement(1);
				if (stack.isEmpty()) entity.remove(Entity.RemovalReason.DISCARDED);
				return;
			}
		}
	}

	public enum CorundumType {
		BLUE_SAPPHIRE(ModItems.BLUE_SAPPHIRE, List.of(ModItems.POWDERED_IRON, ModItems.POWDERED_TITANIUM)),
		YELLOW_SAPPHIRE(ModItems.YELLOW_SAPPHIRE, List.of(ModItems.POWDERED_IRON)),
		PINK_SAPPHIRE(ModItems.PINK_SAPPHIRE, List.of(ModItems.POWDERED_CHROMIUM)),
		GREEN_SAPPHIRE(ModItems.GREEN_SAPPHIRE, List.of(ModItems.POWDERED_IRON)),
		BROWN_SAPPHIRE(ModItems.BROWN_SAPPHIRE, List.of(ModItems.POWDERED_IRON)),
		PURPLE_SAPPHIRE(ModItems.PURPLE_SAPPHIRE, List.of(ModItems.POWDERED_VANADIUM)),
		BLACK_SAPPHIRE(ModItems.BLACK_SAPPHIRE, List.of(ModItems.POWDERED_IRON, ModItems.POWDERED_TITANIUM)),
		RUBY(ModItems.RUBY, List.of(ModItems.POWDERED_CHROMIUM)),
		GREY_SAPPHIRE(ModItems.GREY_SAPPHIRE, List.of(ModItems.POWDERED_IRON, ModItems.POWDERED_TITANIUM)),
		ORANGE_SAPPHIRE(ModItems.ORANGE_SAPPHIRE, List.of(ModItems.POWDERED_IRON, ModItems.POWDERED_CHROMIUM)),
		WHITE_SAPPHIRE(ModItems.WHITE_SAPPHIRE, List.of()), // No powdered metals
		STAR_SAPPHIRE(ModItems.BLUE_STAR_SAPPHIRE, List.of()), // Cannot be crafted
		STAR_RUBY(ModItems.STAR_RUBY, List.of()); // Cannot be crafted

		private final Item item;
		private final List<Item> requiredMetals;

		CorundumType(Item item, List<Item> requiredMetals) {
			this.item = item;
			this.requiredMetals = requiredMetals;
		}

		public Item getItem() {
			return item;
		}

		public List<Item> getRequiredMetals() {
			return requiredMetals;
		}

		public boolean isStarGem() {
			return this == STAR_SAPPHIRE || this == STAR_RUBY;
		}

		public static CorundumType fromItem(Item item) {
			for (CorundumType type : values()) {
				if (type.item == item) return type;
			}
			return null;
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

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if (world.isClient()) return ActionResult.PASS;

			BlockPos pos = hitResult.getBlockPos();
			BlockState state = world.getBlockState(pos);

			if (state.isOf(Blocks.LODESTONE)) {
				return attemptMaterialRealignment(player, world, pos);
			}
			return ActionResult.PASS;
		});
	}
}