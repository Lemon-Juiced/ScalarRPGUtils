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
    public static final Supplier<Item> COPPER_COMPONENT_LEVEL_2 = ITEMS.register("copper_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> COPPER_COMPONENT_LEVEL_3 = ITEMS.register("copper_component_level_3", () -> new ComponentItem(3));
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
    public static final Supplier<Item> QUARTZ_COMPONENT_LEVEL_1 = ITEMS.register("quartz_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> QUARTZ_COMPONENT_LEVEL_2 = ITEMS.register("quartz_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> QUARTZ_COMPONENT_LEVEL_3 = ITEMS.register("quartz_component_level_3", () -> new ComponentItem(3));
    public static final Supplier<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_1 = ITEMS.register("redstone_crystal_component_level_1", () -> new ComponentItem(1));
    public static final Supplier<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_2 = ITEMS.register("redstone_crystal_component_level_2", () -> new ComponentItem(2));
    public static final Supplier<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_3 = ITEMS.register("redstone_crystal_component_level_3", () -> new ComponentItem(3));

    // Registered Separately for Creative Tab
    public static final Supplier<Item> COPPER_GLOVES_LEVEL_1 = ITEMS.register("copper_gloves_level_1", () -> new AbstractCurioItem("copper", 1));

    public static void generateCurioItemsFactory() {
        String[] resources = {"copper", "diamond", "emerald", "gold", "lapis_lazuli", "netherite", "quartz", "redstone_crystal"};
        String[] types = {"gloves", "necklace", "ring"};
        for (int i = 0; i < resources.length; i++) {
            for (int j = 0; j < types.length; j++) {
                for (int level = 1; level <= 3; level++) {
                    String itemName = resources[i] + "_" + types[j] + "_level_" + level;
                    int finalI = i;
                    int finalLevel = level;

                    // Make an example for Copper Gloves Level 1, so it can be easily registered for the Creative Tab (Do not register here)
                    if (!(resources[i].equals("copper") && types[j].equals("gloves") && level == 1)) {
                        ITEMS.register(itemName, () -> new AbstractCurioItem(resources[finalI], finalLevel));
                    }
                }
            }
        }
    }

    public static void register(IEventBus eventBus) {
        generateCurioItemsFactory();
        ITEMS.register(eventBus);
    }
}
