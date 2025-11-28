package site.scalarstudios.scalarrpgutils.creativetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.scalarrpgutils.ScalarRPGUtils;
import site.scalarstudios.scalarrpgutils.item.ScalarRPGItems;
import site.scalarstudios.scalarrpgutils.item.curios.AbstractCurioItem;

import java.util.ArrayList;

public class ScalarRPGCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ScalarRPGUtils.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCALAR_RPG_ITEMS_TAB = CREATIVE_MODE_TABS.register("scalarrpgutils_items" +
            "", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.scalarrpgutils.items"))
            .icon(() -> new ItemStack(ScalarRPGItems.NETHERITE_BURNISHER.get()))
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SCALAR_RPG_CURIOS_TAB = CREATIVE_MODE_TABS.register("scalarrpgutils_curios" +
            "", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.scalarrpgutils.curios"))
            .icon(() -> new ItemStack(ScalarRPGItems.COPPER_GLOVES_LEVEL_1.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == SCALAR_RPG_ITEMS_TAB.get()) {
            // Burnishers
            event.accept(ScalarRPGItems.IRON_BURNISHER.get());
            event.accept(ScalarRPGItems.DIAMOND_BURNISHER.get());
            event.accept(ScalarRPGItems.NETHERITE_BURNISHER.get());

            // Tiered Components
            event.accept(ScalarRPGItems.COPPER_COMPONENT_LEVEL_1.get());
            event.accept(ScalarRPGItems.COPPER_COMPONENT_LEVEL_2.get());
            event.accept(ScalarRPGItems.COPPER_COMPONENT_LEVEL_3.get());
            event.accept(ScalarRPGItems.DIAMOND_COMPONENT_LEVEL_1.get());
            event.accept(ScalarRPGItems.DIAMOND_COMPONENT_LEVEL_2.get());
            event.accept(ScalarRPGItems.DIAMOND_COMPONENT_LEVEL_3.get());
            event.accept(ScalarRPGItems.EMERALD_COMPONENT_LEVEL_1.get());
            event.accept(ScalarRPGItems.EMERALD_COMPONENT_LEVEL_2.get());
            event.accept(ScalarRPGItems.EMERALD_COMPONENT_LEVEL_3.get());
            event.accept(ScalarRPGItems.GOLD_COMPONENT_LEVEL_1.get());
            event.accept(ScalarRPGItems.GOLD_COMPONENT_LEVEL_2.get());
            event.accept(ScalarRPGItems.GOLD_COMPONENT_LEVEL_3.get());
            event.accept(ScalarRPGItems.LAPIS_LAZULI_COMPONENT_LEVEL_1.get());
            event.accept(ScalarRPGItems.LAPIS_LAZULI_COMPONENT_LEVEL_2.get());
            event.accept(ScalarRPGItems.LAPIS_LAZULI_COMPONENT_LEVEL_3.get());
            event.accept(ScalarRPGItems.NETHERITE_COMPONENT_LEVEL_1.get());
            event.accept(ScalarRPGItems.NETHERITE_COMPONENT_LEVEL_2.get());
            event.accept(ScalarRPGItems.NETHERITE_COMPONENT_LEVEL_3.get());
            event.accept(ScalarRPGItems.QUARTZ_COMPONENT_LEVEL_1.get());
            event.accept(ScalarRPGItems.QUARTZ_COMPONENT_LEVEL_2.get());
            event.accept(ScalarRPGItems.QUARTZ_COMPONENT_LEVEL_3.get());
            event.accept(ScalarRPGItems.REDSTONE_CRYSTAL_COMPONENT_LEVEL_1.get());
            event.accept(ScalarRPGItems.REDSTONE_CRYSTAL_COMPONENT_LEVEL_2.get());
            event.accept(ScalarRPGItems.REDSTONE_CRYSTAL_COMPONENT_LEVEL_3.get());

        } else if (event.getTab() == SCALAR_RPG_CURIOS_TAB.get()) {
            for (DeferredHolder<Item, ? extends Item> item : ScalarRPGItems.ITEMS.getEntries()) {
                if(item.get() instanceof AbstractCurioItem) {
                    event.accept(item.get());
                }
            }
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
