package com.leonyk2.mcmod.block;


import com.leonyk2.mcmod.McMod;
import com.leonyk2.mcmod.block.custom.TableBlock;
import com.leonyk2.mcmod.compat.CompatHandler;
import com.leonyk2.mcmod.item.ModItems;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, McMod.MOD_ID);

    public static final RegistryObject<Block> OAK_TABLE = registerBlock("oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_TABLE = registerBlock("birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_TABLE = registerBlock("dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_TABLE = registerBlock("jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRUCE_TABLE = registerBlock("spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_TABLE = registerBlock("acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_TABLE = registerBlock("mangrove_table",
            () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHERRY_TABLE = registerBlock("cherry_table",
            () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));


    public static RegistryObject<Block> FIR_TABLE;
    public static RegistryObject<Block> REDWOOD_TABLE;
    public static RegistryObject<Block> MAHOGANY_TABLE;
    public static RegistryObject<Block> JACARANDA_TABLE;
    public static RegistryObject<Block> PALM_TABLE;
    public static RegistryObject<Block> WILLOW_TABLE;
    public static RegistryObject<Block> DEAD_TABLE;
    public static RegistryObject<Block> MAGIC_TABLE;
    public static RegistryObject<Block> UMBRAN_TABLE;
    public static RegistryObject<Block> HELLBARK_TABLE;

    public static void regitserBopBlocks() {
        FIR_TABLE = registerBlock("fir_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        REDWOOD_TABLE = registerBlock("redwood_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        MAHOGANY_TABLE = registerBlock("mahogany_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        JACARANDA_TABLE = registerBlock("jacaranda_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        PALM_TABLE = registerBlock("palm_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        WILLOW_TABLE = registerBlock("willow_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        DEAD_TABLE = registerBlock("dead_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        MAGIC_TABLE = registerBlock("magic_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        UMBRAN_TABLE = registerBlock("umbran_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
        HELLBARK_TABLE = registerBlock("hellbark_table", () -> new TableBlock(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).sound(SoundType.WOOD)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

        if (CompatHandler.isBopLoaded()) {
            regitserBopBlocks();
        }
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
