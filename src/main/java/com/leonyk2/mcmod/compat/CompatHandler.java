package com.leonyk2.mcmod.compat;

import net.minecraftforge.fml.ModList;

import static com.leonyk2.mcmod.util.Functions.println;

public class CompatHandler {
    public static final String BOP_MODID = "biomesoplenty";

    public static boolean isBopLoaded() {
        println("isBopLoaded() called! (" + ModList.get().isLoaded(BOP_MODID) + ")");
        return ModList.get().isLoaded(BOP_MODID);
    }
}
