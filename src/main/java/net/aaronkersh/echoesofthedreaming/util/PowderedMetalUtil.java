package net.aaronkersh.echoesofthedreaming.util;

import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;
import net.aaronkersh.echoesofthedreaming.item.ModItems;

public class PowderedMetalUtil {
    private static final Map<Item, String> METAL_MAP = new HashMap<>();

    static {
        METAL_MAP.put(ModItems.POWDERED_IRON, "iron");
        METAL_MAP.put(ModItems.POWDERED_TITANIUM, "titanium");
        METAL_MAP.put(ModItems.POWDERED_CHROMIUM, "chromium");
        METAL_MAP.put(ModItems.POWDERED_VANADIUM, "vanadium");
    }

    public static boolean isPowderedMetal(Item item) {
        return METAL_MAP.containsKey(item);
    }

    public static String getMetalType(Item item) {
        return METAL_MAP.get(item);
    }
}