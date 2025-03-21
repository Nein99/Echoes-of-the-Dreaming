package net.aaronkersh.echoesofthedreaming.mixin;

import net.aaronkersh.echoesofthedreaming.item.BismuthToolItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "dropStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)V",
            at = @At("HEAD"),
            cancellable = true)
    private static void onDropStacks(BlockState state, World world, BlockPos pos, BlockEntity blockEntity,
                                     Entity entity, ItemStack stack, CallbackInfo ci) {
        // Check if the tool is a Bismuth tool
        if (stack.getItem() instanceof BismuthToolItem) {
            if (!world.isClient && world instanceof ServerWorld) {
                // Only drop the block itself instead of its drops
                Block.dropStack(world, pos, new ItemStack(state.getBlock().asItem()));
                ci.cancel(); // Cancel the original method to prevent normal drops
            }
        }
    }
}
