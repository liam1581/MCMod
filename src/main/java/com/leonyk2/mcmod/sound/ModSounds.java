package com.leonyk2.mcmod.sound;

import com.leonyk2.mcmod.McMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, McMod.MOD_ID);

    public static final RegistryObject<SoundEvent> BEATS = registerSoundEvents("beats");
    public static final RegistryObject<SoundEvent> BEATS_BB = registerSoundEvents("beats_bb");
    public static final RegistryObject<SoundEvent> CRUSH = registerSoundEvents("crush");
    public static final RegistryObject<SoundEvent> CRUSH_BB = registerSoundEvents("crush_bb");
    public static final RegistryObject<SoundEvent> TAGE_WACH = registerSoundEvents("tage_wach");
    public static final RegistryObject<SoundEvent> TAGE_WACH_BB = registerSoundEvents("tage_wach_bb");
    public static final RegistryObject<SoundEvent> LEICHE = registerSoundEvents("leiche");



    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(McMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
