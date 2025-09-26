package com.leonyk2.mcmod;

import com.leonyk2.mcmod.ponder.McModPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class McModClient {

    public static void onCtorClient(IEventBus modEventBus, IEventBus forgeEventBus) {
        modEventBus.addListener(McModClient::onClientInit);
    }

    public static void onClientInit(final FMLClientSetupEvent event) {
        //PonderIndex.addPlugin(new McModPonderPlugin());
    }
}
