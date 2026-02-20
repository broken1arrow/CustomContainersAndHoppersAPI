package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ItemPickupTarget {

    void pickupItem(@Nonnull final Function<ItemStack, Map<Integer, ItemStack>> containerAddFunc,@Nonnull final Consumer<Integer> writeCallback);

    SuctionRange getSuctionRange();

    void filter(Function<ItemStack,Boolean> item);
}
