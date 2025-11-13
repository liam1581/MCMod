package com.leonyk2.mcmod.compat;

import net.minecraftforge.fml.ModList;

public class CompatHandler {
    public static final String BOP_MODID = "biomesoplenty";

    public static boolean isBopLoaded() {
        return ModList.get().isLoaded(BOP_MODID);
    }
}
