package site.scalarstudios.scalarrpgutils.item.custom;

import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStackTemplate;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.jspecify.annotations.Nullable;

import java.util.Map;

public class BurnisherItem extends Item implements IItemExtension {
    private static final Map<String, Integer> TIER_DURABILITIES = Map.of(
        "iron", 250,
        "diamond", 1561,
        "netherite", 2031
    );

    private final int maxDamage;

    public BurnisherItem(Properties properties, String tier) {
        super(properties.durability(computeDurability(tier)).setNoCombineRepair().stacksTo(1));
        this.maxDamage = computeDurability(tier);
    }

    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(ItemInstance instance) {
        int durability = instance.getOrDefault(DataComponents.DAMAGE, 0);
        if (durability < this.maxDamage - 1) {
            DataComponentPatch patch = DataComponentPatch.builder()
                    .set(DataComponents.DAMAGE, durability + 1)
                    .build();
            return new ItemStackTemplate(instance.typeHolder(), 1, patch);
        }
        return null;
    }

    private static int computeDurability(String tier) {
        return TIER_DURABILITIES.get(tier);
    }
}
