// Similar modifications for other tool types
package net.aaronkersh.echoesofthedreaming.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class BismuthPickaxeItem extends BismuthToolItem {
    public BismuthPickaxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, material, BlockTags.PICKAXE_MINEABLE, settings);
    }
}
