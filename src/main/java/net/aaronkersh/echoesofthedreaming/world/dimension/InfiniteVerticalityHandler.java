package net.aaronkersh.echoesofthedreaming.world.dimension;

import net.aaronkersh.echoesofthedreaming.EchoesOfTheDreaming;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InfiniteVerticalityHandler {
    // Store last teleport time to prevent teleport loops
    private static final Map<UUID, Long> lastTeleportTime = new HashMap<>();
    // Cooldown in milliseconds to prevent teleport loops/spam
    private static final long TELEPORT_COOLDOWN = 2000;

    // Vertical boundaries that trigger teleportation
    private static final double LOWER_BOUNDARY = -64.0;
    private static final double UPPER_BOUNDARY = 320.0;

    // Target Y-coordinates after teleportation
    private static final double LOWER_TARGET_Y = 322.0;  // High up in the sky
    private static final double UPPER_TARGET_Y = -62.0;  // Just above the bottom boundary

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(InfiniteVerticalityHandler::onServerTick);
        EchoesOfTheDreaming.LOGGER.info("Registered Infinite Verticality Handler for Elemental Air dimension");
    }

    private static void onServerTick(MinecraftServer server) {
        // Check all server worlds
        for (ServerWorld world : server.getWorlds()) {
            // Only apply to the Elemental Air dimension
            if (world.getRegistryKey().equals(ModDimensions.ELEMENTAL_AIR_LEVEL_KEY)) {
                // Check all players in this dimension
                for (PlayerEntity player : world.getPlayers()) {
                    checkPlayerPosition(player, world);
                }
            }
        }
    }

    private static void checkPlayerPosition(PlayerEntity player, ServerWorld world) {
        double y = player.getY();

        // Skip if player was teleported recently (avoids teleport loops)
        if (isOnCooldown(player.getUuid())) {
            return;
        }

        // Handle falling out of the bottom
        if (y < LOWER_BOUNDARY) {
            teleportPlayer(player, world, calculateTargetPosition(player, true));
        }
        // Handle flying above the top
        else if (y > UPPER_BOUNDARY) {
            teleportPlayer(player, world, calculateTargetPosition(player, false));
        }
    }

    private static TeleportTarget calculateTargetPosition(PlayerEntity player, boolean fallingOut) {
        // Get player's current position and velocity
        Vec3d currentPos = player.getPos();
        Vec3d currentVelocity = player.getVelocity();

        // Calculate new X and Z coordinates (inverting for the "mirror world" effect)
        double newX = -currentPos.x;
        double newZ = -currentPos.z;

        // Set Y coordinate based on direction
        double newY = fallingOut ? LOWER_TARGET_Y : UPPER_TARGET_Y;

        // Maintain the player's velocity for a smooth transition
        // Optional: We could also invert the X and Z components of velocity
        // if we want the player to maintain their directional momentum
        Vec3d newVelocity = new Vec3d(currentVelocity.x, currentVelocity.y, currentVelocity.z);

        // Create and return the teleport target
        return new TeleportTarget(
                new Vec3d(newX, newY, newZ),
                newVelocity,
                player.getYaw(),
                player.getPitch()
        );
    }

    private static void teleportPlayer(PlayerEntity player, ServerWorld world, TeleportTarget target) {
        // Update last teleport time
        lastTeleportTime.put(player.getUuid(), System.currentTimeMillis());

        // Cast to ServerPlayerEntity since we're in server code
        if (player instanceof net.minecraft.server.network.ServerPlayerEntity serverPlayer) {
            // Use the correct teleport method
            serverPlayer.teleport(
                    world,
                    target.position.x,
                    target.position.y,
                    target.position.z,
                    target.yaw,
                    target.pitch
            );

            // Apply the velocity after teleport for smooth transition
            player.setVelocity(target.velocity);

            // Log the teleport (optional)
            EchoesOfTheDreaming.LOGGER.info(
                    "Teleported player {} from ({}, {}, {}) to ({}, {}, {})",
                    player.getName().getString(),
                    player.getX(), player.getY(), player.getZ(),
                    target.position.x, target.position.y, target.position.z
            );
        }
    }

    private static boolean isOnCooldown(UUID playerUuid) {
        if (!lastTeleportTime.containsKey(playerUuid)) {
            return false;
        }

        long lastTeleport = lastTeleportTime.get(playerUuid);
        long now = System.currentTimeMillis();

        return now - lastTeleport < TELEPORT_COOLDOWN;
    }
}