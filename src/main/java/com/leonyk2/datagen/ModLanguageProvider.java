package com.leonyk2.datagen;

import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.item.ModItems;
import com.leonyk2.mcmod.keybind.Keybinds;
import com.leonyk2.mcmod.sound.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import static com.leonyk2.datagen.util.LangFunctions.addLang;

public class ModLanguageProvider extends LanguageProvider {
    private final String locale;

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, McMod.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        addLang(this::add, this::add, this::add, locale);
    }
}
