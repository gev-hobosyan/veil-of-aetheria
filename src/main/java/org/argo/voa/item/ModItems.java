package org.argo.voa.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.argo.voa.VeilofAetheria;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VeilofAetheria.MOD_ID);

    public static final DeferredItem<Item> EDRIUM_INGOT = ITEMS.register("ederium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_EDERIUM = ITEMS.register("raw_ederium",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
