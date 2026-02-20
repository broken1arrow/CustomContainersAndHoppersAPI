package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public interface Filter {

    ItemPickupTarget allowIf(final Predicate<ItemStack> filter);
}
