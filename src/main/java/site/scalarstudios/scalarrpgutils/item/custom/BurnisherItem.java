package site.scalarstudios.scalarrpgutils.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.Map;

public class BurnisherItem extends Item {
    private static final Map<String, Integer> TIER_DURABILITIES = Map.of(
        "iron", 250,
        "diamond", 1561,
        "netherite", 2031
    );

    private final int maxDamage;

    public BurnisherItem(Properties properties, String tier) {
        super(properties.durability(computeDurability(tier)).setNoRepair().stacksTo(1));
        this.maxDamage = computeDurability(tier);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true; // Always provide a remaining item for this item type
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        int durability = itemStack.getDamageValue();
        if (durability < this.maxDamage - 1) {
            ItemStack newStack = itemStack.copy();
            newStack.setDamageValue(durability + 1);
            return newStack;
        }
        return ItemStack.EMPTY;
    }

    private static int computeDurability(String tier) {
        return TIER_DURABILITIES.get(tier);
    }
}
