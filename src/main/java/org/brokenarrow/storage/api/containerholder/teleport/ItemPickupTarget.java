package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ItemPickupTarget {

    /**
     * Attempts to pick up an item entity into a container.
     *
     * @param containerAddFunc Function to add items into the container (returns leftover)
     * @param writeCallback    Runnable for bookkeeping (amount picked up, BigInteger, etc.)
     */
    void pickupItem(@Nonnull final Function<ItemStack, Map<Integer, ItemStack>> containerAddFunc,@Nonnull final Consumer<Integer> writeCallback);

    /**
     * Get the suction/pickup range for your items.
     * @return the range it will pick up items either in blocks or chunks.
     */
    SuctionRange getSuctionRange();

}
