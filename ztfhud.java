package ro.ztf.hud;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ztfhud")
public class ZtfHud {
    public static final Logger LOGGER = LogManager.getLogger();

    public ZtfHud() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("ZTF HUD loaded!");
        MinecraftForge.EVENT_BUS.register(new HudRenderer());
        MinecraftForge.EVENT_BUS.register(new NetworkHandler());
    }
}

