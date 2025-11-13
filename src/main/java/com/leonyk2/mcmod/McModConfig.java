package com.leonyk2.mcmod;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class McModConfig {
    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue enableDebugCommand;
        public final ForgeConfigSpec.BooleanValue enableNBTCommands;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("General Settings");

            enableDebugCommand = builder.define("enableDebugCommand", false);
            enableNBTCommands = builder.define("enableNBTCommands", false);

            builder.pop();
        }
    }
}
