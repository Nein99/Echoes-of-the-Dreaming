package net.aaronkersh.echoesofthedreaming;

import net.aaronkersh.echoesofthedreaming.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;

import net.aaronkersh.echoesofthedreaming.item.ModItems;
import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
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
		ModWorldGeneration.generateModWorldGen();
	}
}