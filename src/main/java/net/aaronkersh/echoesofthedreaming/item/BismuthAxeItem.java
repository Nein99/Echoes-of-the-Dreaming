package net.aaronkersh.echoesofthedreaming.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class BismuthAxeItem extends BismuthToolItem {
    public BismuthAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, settings);
    }
}
