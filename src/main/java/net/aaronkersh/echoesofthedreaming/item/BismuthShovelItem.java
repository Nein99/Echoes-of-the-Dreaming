package net.aaronkersh.echoesofthedreaming.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class BismuthShovelItem extends BismuthToolItem {
    public BismuthShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, BlockTags.SHOVEL_MINEABLE, settings);
    }
}
