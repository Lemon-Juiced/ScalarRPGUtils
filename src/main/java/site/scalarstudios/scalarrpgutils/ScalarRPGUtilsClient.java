package site.scalarstudios.scalarrpgutils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = ScalarRPGUtils.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = ScalarRPGUtils.MODID, value = Dist.CLIENT)
public class ScalarRPGUtilsClient {
    public ScalarRPGUtilsClient(ModContainer container) {}

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {}
}
