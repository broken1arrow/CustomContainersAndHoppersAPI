package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

/**
 * Set the filter for the pickup.
 */
public interface SuctionFilter {

    /**
     * Allows items matching the given predicate to be eligible for pickup,
     * and returns the target used to perform the pickup operation.
     *
     * @param filter predicate used to evaluate whether an item can be picked up
     * @return the pickup target used to execute the suction operation
     */
    ItemPickupTarget allowIf(final Predicate<ItemStack> filter);
}
