package net.aaronkersh.echoesofthedreaming.item;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.block.Block;

public class BismuthToolItem extends MiningToolItem {
    public BismuthToolItem(float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> blockTag, Settings settings) {
        super(attackDamage, attackSpeed, material, blockTag, settings);
    }
}