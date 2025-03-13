package net.aaronkersh.echoesofthedreaming;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoesOfTheDreaming implements ModInitializer {
	public static final String MOD_ID = "echoes_of_the_dreaming";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}