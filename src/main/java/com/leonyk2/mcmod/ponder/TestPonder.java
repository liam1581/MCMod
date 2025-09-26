package com.leonyk2.mcmod.ponder;

import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;

public class TestPonder {
    public static void ponder(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);

        scene.title("test", "Ponder");
        scene.configureBasePlate(0, 0, 6);
        scene.showBasePlate();
        scene.world().showSection(util.select().layer(0), Direction.UP);

        scene.addKeyframe();
        scene.idle(5);
        scene.world().setBlock(new BlockPos(1, 1, 0), Blocks.DIRT.defaultBlockState(), true);
        scene.idle(1);
        scene.world().setBlock(new BlockPos(2, 1, 0), Blocks.DIRT.defaultBlockState(), true);
        scene.idle(1);
        scene.world().setBlock(new BlockPos(3, 1, 0), Blocks.DIRT.defaultBlockState(), true);
        scene.idle(1);
        scene.world().setBlock(new BlockPos(1, 2, 0), Blocks.DIRT.defaultBlockState(), true);
        scene.idle(1);
        scene.world().setBlock(new BlockPos(1, 3, 0), Blocks.DIRT.defaultBlockState(), true);

    }
}
