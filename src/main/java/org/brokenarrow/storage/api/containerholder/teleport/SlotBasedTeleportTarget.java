package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * A {@link TeleportTarget} that exposes slot-based access to its contents.
 *
 * <p>
 * Implementations provide direct read and write access to specific slots,
 * optionally across multiple pages.
 * </p>
 *
 * <p>
 * This is typically used for container types that maintain structured
 * inventories rather than aggregated quantity-based storage.
 * </p>
 */
public interface SlotBasedTeleportTarget extends TeleportTarget {

    /**
     * Returns the total number of slots per page.
     *
     * @return the slot count
     */
    int getSize();

    /**
     * Returns the number of available pages.
     *
     * @return the page count
     */
    int getCurrentSetPages();

    /**
     * Returns the item at the specified page and slot.
     *
     * @param page the page index
     * @param slot the slot index
     * @return the item in that position, or null if empty
     */
    @Nullable
    ItemStack getItem(final int page, final int slot);

    /**
     * Sets the item at the specified page and slot.
     *
     * @param page  the page index
     * @param slot  the slot index
     * @param stack the item to set
     */
    void setItem(final int page,final int slot, final ItemStack stack);
}