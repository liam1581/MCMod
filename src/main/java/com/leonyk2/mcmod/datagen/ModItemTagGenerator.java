package com.leonyk2.mcmod.datagen;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, McMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.BEATS_MUSIC_DISC.get())
                .add(ModItems.BEATS_BB_MUSIC_DISC.get())
                .add(ModItems.CRUSH_MUSIC_DISC.get())
                .add(ModItems.CRUSH_BB_MUSIC_DISC.get())
                .add(ModItems.TAGE_WACH_MUSIC_DISC.get())
                .add(ModItems.TAGE_WACH_BB_MUSIC_DISC.get());
    }
}
