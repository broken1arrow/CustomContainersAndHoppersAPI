package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;

/**
 * Represents a teleport target that supports aggregated, amount-based storage.
 *
 * <p>
 * Unlike standard inventory-based targets, aggregated storage does not
 * operate on individual slots. Instead, it accepts a requested item type
 * and amount, and returns the amount that was successfully stored.
 * </p>
 *
 * <p>
 * This is typically used for large-capacity or virtual storage systems
 * that track quantities rather than physical slot contents.
 * </p>
 */
public interface AggregatedStorageSupport {

    /**
     * Attempts to insert a specific amount of an item type into the storage.
     *
     * @param stack   the item type to insert
     * @param amount  the requested amount to store
     * @return the amount that was successfully accepted.
     */
    BigInteger accept(ItemStack stack, BigInteger amount);
}