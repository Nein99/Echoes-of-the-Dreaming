package net.aaronkersh.echoesofthedreaming.event;

import net.aaronkersh.echoesofthedreaming.block.ModBlocks;
import net.aaronkersh.echoesofthedreaming.entity.ModEntities;
import net.aaronkersh.echoesofthedreaming.entity.custom.MourningOrewalkerEntity;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class MiningEventHandler {
    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (!world.isClient() && (
                    state.isOf(ModBlocks.MOURNCRYST_ORE) ||
                            state.isOf(ModBlocks.MOURNCRYST_DEEPSLATE_ORE))) {

                // 20% chance to spawn an Orewalker
                if (world.getRandom().nextFloat() < 0.2f) {
                    spawnOrewalker((ServerWorld) world, pos, player.getPos());
                }
            }
        });
    }

    private static void spawnOrewalker(ServerWorld world, BlockPos orePos, Vec3d playerPos) {
        // Find a suitable location behind the player
        Direction playerFacing = Direction.fromRotation(world.getClosestPlayer(playerPos.x, playerPos.y, playerPos.z, 10, false).getYaw());
        Direction opposite = playerFacing.getOpposite();

        // Try to find a valid spawn position
        BlockPos spawnPos = null;
        int attempts = 0;

        while (spawnPos == null && attempts < 10) {
            // Try different positions behind the player
            BlockPos testPos = orePos.offset(opposite, 3 + attempts);

            // Check if there's space for the entity
            if (world.getBlockState(testPos).isAir() &&
                    world.getBlockState(testPos.up()).isAir()) {
                spawnPos = testPos;
            }

            attempts++;
        }

        // If we couldn't find a position, use the ore position
        if (spawnPos == null) {
            spawnPos = orePos.up();
        }

        // Spawn the Orewalker
        MourningOrewalkerEntity orewalker = ModEntities.MOURNING_OREWALKER.create(world);
        orewalker.refreshPositionAndAngles(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5, 0, 0);
        orewalker.initialize(world, world.getLocalDifficulty(spawnPos), SpawnReason.TRIGGERED, null, null);
        world.spawnEntity(orewalker);
    }
}
