package site.scalarstudios.scalarrpgutils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import site.scalarstudios.scalarrpgutils.creativetab.ScalarRPGCreativeTabs;
import site.scalarstudios.scalarrpgutils.item.ScalarRPGItems;
import site.scalarstudios.scalarrpgutils.item.curios.AbstractCurioItem;
import top.theillusivec4.curios.api.CuriosApi;

@Mod(ScalarRPGUtils.MODID)
public class ScalarRPGUtils {
    public static final String MODID = "scalarrpgutils";

    public ScalarRPGUtils(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register Items
        ScalarRPGItems.register(modEventBus);

        // Register Creative Tabs
        ScalarRPGCreativeTabs.register(modEventBus);
        modEventBus.addListener(ScalarRPGCreativeTabs::registerTabs);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
