package site.scalarstudios.scalarrpgutils.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.scalarrpgutils.ScalarRPGUtils;
import site.scalarstudios.scalarrpgutils.item.custom.BurnisherItem;

import java.util.function.Supplier;

public class ScalarRPGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(ScalarRPGUtils.MODID);

    // Gem Cutters
    public static final Supplier<Item> IRON_BURNISHER = ITEMS.register("iron_burnisher", () -> new BurnisherItem(new Item.Properties(), "iron"));
    public static final Supplier<Item> DIAMOND_BURNISHER = ITEMS.register("diamond_burnisher", () -> new BurnisherItem(new Item.Properties(), "diamond"));
    public static final Supplier<Item> NETHERITE_BURNISHER = ITEMS.register("netherite_burnisher", () -> new BurnisherItem(new Item.Properties(), "netherite"));

    // Gems
    public static final Supplier<Item> DIAMOND_LEVEL_1 = ITEMS.register("diamond_level_1", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DIAMOND_LEVEL_2 = ITEMS.register("diamond_level_2", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DIAMOND_LEVEL_3 = ITEMS.register("diamond_level_3", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> EMERALD_LEVEL_1 = ITEMS.register("emerald_level_1", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> EMERALD_LEVEL_2 = ITEMS.register("emerald_level_2", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> EMERALD_LEVEL_3 = ITEMS.register("emerald_level_3", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GOLD_LEVEL_1 = ITEMS.register("gold_level_1", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GOLD_LEVEL_2 = ITEMS.register("gold_level_2", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GOLD_LEVEL_3 = ITEMS.register("gold_level_3", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LAPIS_LAZULI_LEVEL_1 = ITEMS.register("lapis_lazuli_level_1", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LAPIS_LAZULI_LEVEL_2 = ITEMS.register("lapis_lazuli_level_2", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LAPIS_LAZULI_LEVEL_3 = ITEMS.register("lapis_lazuli_level_3", () -> new Item(new Item.Properties()));

    // Rings
    public static final Supplier<Item> DIAMOND_RING_LEVEL_1 = ITEMS.register("diamond_ring_level_1", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DIAMOND_RING_LEVEL_2 = ITEMS.register("diamond_ring_level_2", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DIAMOND_RING_LEVEL_3 = ITEMS.register("diamond_ring_level_3", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> EMERALD_RING_LEVEL_1 = ITEMS.register("emerald_ring_level_1", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> EMERALD_RING_LEVEL_2 = ITEMS.register("emerald_ring_level_2", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> EMERALD_RING_LEVEL_3 = ITEMS.register("emerald_ring_level_3", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GOLD_RING_LEVEL_1 = ITEMS.register("gold_ring_level_1", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GOLD_RING_LEVEL_2 = ITEMS.register("gold_ring_level_2", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GOLD_RING_LEVEL_3 = ITEMS.register("gold_ring_level_3", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LAPIS_LAZULI_RING_LEVEL_1 = ITEMS.register("lapis_lazuli_ring_level_1", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LAPIS_LAZULI_RING_LEVEL_2 = ITEMS.register("lapis_lazuli_ring_level_2", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LAPIS_LAZULI_RING_LEVEL_3 = ITEMS.register("lapis_lazuli_ring_level_3", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
