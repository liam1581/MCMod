package com.leonyk2.mcmod.ponder.ponders;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.Direction;

public class TestPonder {
    public static void ponder(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);

        scene.title("test", "Test Ponder");
        scene.configureBasePlate(0, 0, 6);
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.DOWN);

        scene.addKeyframe();
        scene.idle(5);
        scene.world().setKineticSpeed(util.select().position(0,1,1), 64);
        scene.world().showSection(util.select().everywhere(), Direction.DOWN);


    }
}
