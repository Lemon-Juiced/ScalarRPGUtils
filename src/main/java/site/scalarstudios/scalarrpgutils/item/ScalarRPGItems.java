package site.scalarstudios.scalarrpgutils.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.scalarrpgutils.ScalarRPGUtils;
import site.scalarstudios.scalarrpgutils.item.custom.BurnisherItem;
import site.scalarstudios.scalarrpgutils.item.curios.AbstractCurioItem;
import site.scalarstudios.scalarrpgutils.item.custom.ComponentItem;

public class ScalarRPGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ScalarRPGUtils.MODID);

    // Burnishers
    public static final DeferredItem<Item> IRON_BURNISHER = ITEMS.registerItem("iron_burnisher", properties -> new BurnisherItem(properties, "iron"));
    public static final DeferredItem<Item> DIAMOND_BURNISHER = ITEMS.registerItem("diamond_burnisher", properties -> new BurnisherItem(properties, "diamond"));
    public static final DeferredItem<Item> NETHERITE_BURNISHER = ITEMS.registerItem("netherite_burnisher", properties -> new BurnisherItem(properties, "netherite"));

    // Components
    public static final DeferredItem<Item> COPPER_COMPONENT_LEVEL_1 = ITEMS.registerItem("copper_component_level_1", properties -> new ComponentItem(properties, 1));
    public static final DeferredItem<Item> COPPER_COMPONENT_LEVEL_2 = ITEMS.registerItem("copper_component_level_2", properties -> new ComponentItem(properties, 2));
    public static final DeferredItem<Item> COPPER_COMPONENT_LEVEL_3 = ITEMS.registerItem("copper_component_level_3", properties -> new ComponentItem(properties, 3));
    public static final DeferredItem<Item> DIAMOND_COMPONENT_LEVEL_1 = ITEMS.registerItem("diamond_component_level_1", properties -> new ComponentItem(properties, 1));
    public static final DeferredItem<Item> DIAMOND_COMPONENT_LEVEL_2 = ITEMS.registerItem("diamond_component_level_2", properties -> new ComponentItem(properties, 2));
    public static final DeferredItem<Item> DIAMOND_COMPONENT_LEVEL_3 = ITEMS.registerItem("diamond_component_level_3", properties -> new ComponentItem(properties, 3));
    public static final DeferredItem<Item> EMERALD_COMPONENT_LEVEL_1 = ITEMS.registerItem("emerald_component_level_1", properties -> new ComponentItem(properties, 1));
    public static final DeferredItem<Item> EMERALD_COMPONENT_LEVEL_2 = ITEMS.registerItem("emerald_component_level_2", properties -> new ComponentItem(properties, 2));
    public static final DeferredItem<Item> EMERALD_COMPONENT_LEVEL_3 = ITEMS.registerItem("emerald_component_level_3", properties -> new ComponentItem(properties, 3));
    public static final DeferredItem<Item> GOLD_COMPONENT_LEVEL_1 = ITEMS.registerItem("gold_component_level_1", properties -> new ComponentItem(properties, 1));
    public static final DeferredItem<Item> GOLD_COMPONENT_LEVEL_2 = ITEMS.registerItem("gold_component_level_2", properties -> new ComponentItem(properties, 2));
    public static final DeferredItem<Item> GOLD_COMPONENT_LEVEL_3 = ITEMS.registerItem("gold_component_level_3", properties -> new ComponentItem(properties, 3));
    public static final DeferredItem<Item> LAPIS_LAZULI_COMPONENT_LEVEL_1 = ITEMS.registerItem("lapis_lazuli_component_level_1", properties -> new ComponentItem(properties, 1));
    public static final DeferredItem<Item> LAPIS_LAZULI_COMPONENT_LEVEL_2 = ITEMS.registerItem("lapis_lazuli_component_level_2", properties -> new ComponentItem(properties, 2));
    public static final DeferredItem<Item> LAPIS_LAZULI_COMPONENT_LEVEL_3 = ITEMS.registerItem("lapis_lazuli_component_level_3", properties -> new ComponentItem(properties, 3));
    public static final DeferredItem<Item> NETHERITE_COMPONENT_LEVEL_1 = ITEMS.registerItem("netherite_component_level_1", properties -> new ComponentItem(properties, 1));
    public static final DeferredItem<Item> NETHERITE_COMPONENT_LEVEL_2 = ITEMS.registerItem("netherite_component_level_2", properties -> new ComponentItem(properties, 2));
    public static final DeferredItem<Item> NETHERITE_COMPONENT_LEVEL_3 = ITEMS.registerItem("netherite_component_level_3", properties -> new ComponentItem(properties, 3));
    public static final DeferredItem<Item> QUARTZ_COMPONENT_LEVEL_1 = ITEMS.registerItem("quartz_component_level_1", properties -> new ComponentItem(properties, 1));
    public static final DeferredItem<Item> QUARTZ_COMPONENT_LEVEL_2 = ITEMS.registerItem("quartz_component_level_2", properties -> new ComponentItem(properties, 2));
    public static final DeferredItem<Item> QUARTZ_COMPONENT_LEVEL_3 = ITEMS.registerItem("quartz_component_level_3", properties -> new ComponentItem(properties, 3));
    public static final DeferredItem<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_1 = ITEMS.registerItem("redstone_crystal_component_level_1", properties -> new ComponentItem(properties, 1));
    public static final DeferredItem<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_2 = ITEMS.registerItem("redstone_crystal_component_level_2", properties -> new ComponentItem(properties, 2));
    public static final DeferredItem<Item> REDSTONE_CRYSTAL_COMPONENT_LEVEL_3 = ITEMS.registerItem("redstone_crystal_component_level_3", properties -> new ComponentItem(properties, 3));

    // Registered Separately for Creative Tab
    public static final DeferredItem<Item> COPPER_GLOVES_LEVEL_1 = ITEMS.registerItem("copper_gloves_level_1", properties -> new AbstractCurioItem(properties, "copper", 1));

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
                        ITEMS.registerItem(itemName, properties -> new AbstractCurioItem(properties, resources[finalI], finalLevel));
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
