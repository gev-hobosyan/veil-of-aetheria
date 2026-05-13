package org.argo.voa.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.argo.voa.VeilofAetheria;
import org.argo.voa.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VeilofAetheria.MOD_ID);

    public static final Supplier<CreativeModeTab> EDERIUM_ITEMS_TAB = CREATIVE_MODE_TAB.
            register("ederium_items_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_EDERIUM.get()))
                            .title(Component.translatable("creativetab.voa.ederium_items"))
                            .displayItems((itemDisplayParametrs, output) -> {
                                output.accept(ModItems.RAW_EDERIUM);
                                output.accept(ModItems.EDRIUM_INGOT);

                                output.accept(ModBlocks.EDERIUM_BLOCK);
                                output.accept(ModBlocks.EDERIUM_ORE);
                            })
                            .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);
    }
}
