package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Handle the pickup logic for the container.
 */
public interface ItemPickupTarget {

    /**
     * Attempts to transfer an item entity into a container.
     *
     * @param containerAddFunc function used to insert items into the container,
     *                        returns a map of remaining items that could not be inserted.
     * @param writeCallback   callback invoked with the number of successfully
     *                       transferred items (used for bookkeeping or statistics)
     */
    void pickupItem(@Nonnull final Function<ItemStack, Map<Integer, ItemStack>> containerAddFunc,@Nonnull final Consumer<Integer> writeCallback);

    /**
     * Returns the suction range used for item pickup.
     *
     * @return the configured suction range, either block-based or chunk-based
     */
    SuctionRange getSuctionRange();

}
