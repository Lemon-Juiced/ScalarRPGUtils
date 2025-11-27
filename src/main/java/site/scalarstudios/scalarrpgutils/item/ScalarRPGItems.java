package site.scalarstudios.scalarrpgutils.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.scalarrpgutils.ScalarRPGUtils;
import site.scalarstudios.scalarrpgutils.item.custom.BurnisherItem;
import site.scalarstudios.scalarrpgutils.item.curios.AbstractCurioItem;
import site.scalarstudios.scalarrpgutils.item.custom.ComponentItem;

import java.util.function.Supplier;

public class ScalarRPGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(ScalarRPGUtils.MODID);

    // Burnishers
    public static final Supplier<Item> IRON_BURNISHER = ITEMS.register("iron_burnisher", () -> new BurnisherItem(new Item.Properties(), "iron"));
    public static final Supplier<Item> DIAMOND_BURNISHER = ITEMS.register("diamond_burnisher", () -> new BurnisherItem(new Item.Properties(), "diamond"));
    public static final Supplier<Item> NETHERITE_BURNISHER = ITEMS.register("netherite_burnisher", () -> new BurnisherItem(new Item.Properties(), "netherite"));

    // Components
    public static final Supplier<Item> COPPER_COMPONENT_LEVEL_1 = ITEMS.register("copper_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> COPPER_COMPONENT_LEVEL_2 = ITEMS.register("copper_component_level_1", () -> new ComponentItem(2));
    public static final Supplier<Item> COPPER_COMPONENT_LEVEL_3 = ITEMS.register("copper_component_level_1", () -> new ComponentItem(3));
    public static final Supplier<Item> DIAMOND_COMPONENT_LEVEL_1 = ITEMS.register("diamond_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> DIAMOND_COMPONENT_LEVEL_2 = ITEMS.register("diamond_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> DIAMOND_COMPONENT_LEVEL_3 = ITEMS.register("diamond_component_level_3", () -> new ComponentItem(3));
    public static final Supplier<Item> EMERALD_COMPONENT_LEVEL_1 = ITEMS.register("emerald_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> EMERALD_COMPONENT_LEVEL_2 = ITEMS.register("emerald_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> EMERALD_COMPONENT_LEVEL_3 = ITEMS.register("emerald_component_level_3", () -> new ComponentItem(3));
    public static final Supplier<Item> GOLD_COMPONENT_LEVEL_1 = ITEMS.register("gold_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> GOLD_COMPONENT_LEVEL_2 = ITEMS.register("gold_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> GOLD_COMPONENT_LEVEL_3 = ITEMS.register("gold_component_level_3", () -> new ComponentItem(3));
    public static final Supplier<Item> LAPIS_LAZULI_COMPONENT_LEVEL_1 = ITEMS.register("lapis_lazuli_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> LAPIS_LAZULI_COMPONENT_LEVEL_2 = ITEMS.register("lapis_lazuli_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> LAPIS_LAZULI_COMPONENT_LEVEL_3 = ITEMS.register("lapis_lazuli_component_level_3", () -> new ComponentItem(3));
    public static final Supplier<Item> NETHERITE_COMPONENT_LEVEL_1 = ITEMS.register("netherite_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> NETHERITE_COMPONENT_LEVEL_2 = ITEMS.register("netherite_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> NETHERITE_COMPONENT_LEVEL_3 = ITEMS.register("netherite_component_level_3", () -> new ComponentItem(3));
    public static final Supplier<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_1 = ITEMS.register("redstone_crystal_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_2 = ITEMS.register("redstone_crystal_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_3 = ITEMS.register("redstone_crystal_component_level_3", () -> new ComponentItem(3));

    // Gloves
    public static final Supplier<Item> DIAMOND_GLOVES_LEVEL_1 = ITEMS.register("diamond_gloves_level_1", () -> new AbstractCurioItem("diamond", 1));
    public static final Supplier<Item> DIAMOND_GLOVES_LEVEL_2 = ITEMS.register("diamond_gloves_level_2", () -> new AbstractCurioItem("diamond", 2));
    public static final Supplier<Item> DIAMOND_GLOVES_LEVEL_3 = ITEMS.register("diamond_gloves_level_3", () -> new AbstractCurioItem("diamond", 3));
    public static final Supplier<Item> EMERALD_GLOVES_LEVEL_1 = ITEMS.register("emerald_gloves_level_1", () -> new AbstractCurioItem("emerald", 1));
    public static final Supplier<Item> EMERALD_GLOVES_LEVEL_2 = ITEMS.register("emerald_gloves_level_2", () -> new AbstractCurioItem("emerald", 2));
    public static final Supplier<Item> EMERALD_GLOVES_LEVEL_3 = ITEMS.register("emerald_gloves_level_3", () -> new AbstractCurioItem("emerald", 3));
    public static final Supplier<Item> GOLD_GLOVES_LEVEL_1 = ITEMS.register("gold_gloves_level_1", () -> new AbstractCurioItem("gold", 1));
    public static final Supplier<Item> GOLD_GLOVES_LEVEL_2 = ITEMS.register("gold_gloves_level_2", () -> new AbstractCurioItem("gold", 2));
    public static final Supplier<Item> GOLD_GLOVES_LEVEL_3 = ITEMS.register("gold_gloves_level_3", () -> new AbstractCurioItem("gold", 3));
    public static final Supplier<Item> LAPIS_LAZULI_GLOVES_LEVEL_1 = ITEMS.register("lapis_lazuli_gloves_level_1", () -> new AbstractCurioItem("lapis_lazuli", 1));
    public static final Supplier<Item> LAPIS_LAZULI_GLOVES_LEVEL_2 = ITEMS.register("lapis_lazuli_gloves_level_2", () -> new AbstractCurioItem("lapis_lazuli", 2));
    public static final Supplier<Item> LAPIS_LAZULI_GLOVES_LEVEL_3 = ITEMS.register("lapis_lazuli_gloves_level_3", () -> new AbstractCurioItem("lapis_lazuli", 3));

    // Necklaces
    public static final Supplier<Item> DIAMOND_NECKLACE_LEVEL_1 = ITEMS.register("diamond_necklace_level_1", () -> new AbstractCurioItem("diamond", 1));
    public static final Supplier<Item> DIAMOND_NECKLACE_LEVEL_2 = ITEMS.register("diamond_necklace_level_2", () -> new AbstractCurioItem("diamond", 2));
    public static final Supplier<Item> DIAMOND_NECKLACE_LEVEL_3 = ITEMS.register("diamond_necklace_level_3", () -> new AbstractCurioItem("diamond", 3));
    public static final Supplier<Item> EMERALD_NECKLACE_LEVEL_1 = ITEMS.register("emerald_necklace_level_1", () -> new AbstractCurioItem("emerald", 1));
    public static final Supplier<Item> EMERALD_NECKLACE_LEVEL_2 = ITEMS.register("emerald_necklace_level_2", () -> new AbstractCurioItem("emerald", 2));
    public static final Supplier<Item> EMERALD_NECKLACE_LEVEL_3 = ITEMS.register("emerald_necklace_level_3", () -> new AbstractCurioItem("emerald", 3));
    public static final Supplier<Item> GOLD_NECKLACE_LEVEL_1 = ITEMS.register("gold_necklace_level_1", () -> new AbstractCurioItem("gold", 1));
    public static final Supplier<Item> GOLD_NECKLACE_LEVEL_2 = ITEMS.register("gold_necklace_level_2", () -> new AbstractCurioItem("gold", 2));
    public static final Supplier<Item> GOLD_NECKLACE_LEVEL_3 = ITEMS.register("gold_necklace_level_3", () -> new AbstractCurioItem("gold", 3));
    public static final Supplier<Item> LAPIS_LAZULI_NECKLACE_LEVEL_1 = ITEMS.register("lapis_lazuli_necklace_level_1", () -> new AbstractCurioItem("lapis_lazuli", 1));
    public static final Supplier<Item> LAPIS_LAZULI_NECKLACE_LEVEL_2 = ITEMS.register("lapis_lazuli_necklace_level_2", () -> new AbstractCurioItem("lapis_lazuli", 2));
    public static final Supplier<Item> LAPIS_LAZULI_NECKLACE_LEVEL_3 = ITEMS.register("lapis_lazuli_necklace_level_3", () -> new AbstractCurioItem("lapis_lazuli", 3));

    // Rings
    public static final Supplier<Item> DIAMOND_RING_LEVEL_1 = ITEMS.register("diamond_ring_level_1", () -> new AbstractCurioItem("diamond", 1));
    public static final Supplier<Item> DIAMOND_RING_LEVEL_2 = ITEMS.register("diamond_ring_level_2", () -> new AbstractCurioItem("diamond", 2));
    public static final Supplier<Item> DIAMOND_RING_LEVEL_3 = ITEMS.register("diamond_ring_level_3", () -> new AbstractCurioItem("diamond", 3));
    public static final Supplier<Item> EMERALD_RING_LEVEL_1 = ITEMS.register("emerald_ring_level_1", () -> new AbstractCurioItem("emerald", 1));
    public static final Supplier<Item> EMERALD_RING_LEVEL_2 = ITEMS.register("emerald_ring_level_2", () -> new AbstractCurioItem("emerald", 2));
    public static final Supplier<Item> EMERALD_RING_LEVEL_3 = ITEMS.register("emerald_ring_level_3", () -> new AbstractCurioItem("emerald", 3));
    public static final Supplier<Item> GOLD_RING_LEVEL_1 = ITEMS.register("gold_ring_level_1", () -> new AbstractCurioItem("gold", 1));
    public static final Supplier<Item> GOLD_RING_LEVEL_2 = ITEMS.register("gold_ring_level_2", () -> new AbstractCurioItem("gold", 2));
    public static final Supplier<Item> GOLD_RING_LEVEL_3 = ITEMS.register("gold_ring_level_3", () -> new AbstractCurioItem("gold", 3));
    public static final Supplier<Item> LAPIS_LAZULI_RING_LEVEL_1 = ITEMS.register("lapis_lazuli_ring_level_1", () -> new AbstractCurioItem("lapis_lazuli", 1));
    public static final Supplier<Item> LAPIS_LAZULI_RING_LEVEL_2 = ITEMS.register("lapis_lazuli_ring_level_2", () -> new AbstractCurioItem("lapis_lazuli", 2));
    public static final Supplier<Item> LAPIS_LAZULI_RING_LEVEL_3 = ITEMS.register("lapis_lazuli_ring_level_3", () -> new AbstractCurioItem("lapis_lazuli", 3));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
