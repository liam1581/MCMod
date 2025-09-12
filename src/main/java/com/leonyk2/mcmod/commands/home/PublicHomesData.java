package com.leonyk2.mcmod.commands.home;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

public class PublicHomesData extends SavedData {
	public final Map<Integer, CompoundTag> homes = new HashMap<>();

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag tag) {
        CompoundTag homesTag = new CompoundTag();
        for (var entry : homes.entrySet()) {
            homesTag.put(entry.getKey().toString(), entry.getValue());
        }
        tag.put("Homes", homesTag);
        return tag;
    }

    public static PublicHomesData load(CompoundTag tag) {
        PublicHomesData data = new PublicHomesData();
        CompoundTag homesTag = tag.getCompound("Homes");
        for (String key : homesTag.getAllKeys()) {
            data.homes.put(Integer.parseInt(key), homesTag.getCompound(key));
        }
        return data;
    }
}
