package derp.flinttools;

import derp.flinttools.init.FlintToolsItems;
import derp.flinttools.init.FlintToolsTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value="flinttools")
public class FlintTools {
    public static final Logger LOGGER = LogManager.getLogger(FlintTools.class);
    public static final String MODID = "flinttools";

    public FlintTools() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        FlintToolsTabs.register(bus);
        FlintToolsItems.REGISTRY.register(bus);
    }
}
