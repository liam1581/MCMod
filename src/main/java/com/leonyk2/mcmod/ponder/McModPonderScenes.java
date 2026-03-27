package com.leonyk2.mcmod.ponder;

import com.leonyk2.mcmod.block.ModBlocks;
import com.leonyk2.mcmod.ponder.ponders.TestPonder;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;

public class McModPonderScenes {
	public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
		PonderSceneRegistrationHelper<RegistryObject<?>> HELPER = helper.withKeyFunction(RegistryObject::getId);
		
		HELPER.forComponents(ModBlocks.PONDER_TEST_BLOCK)
                .addStoryBoard("test_ponder/test", TestPonder::ponder, AllCreatePonderTags.REDSTONE);
	}
}
