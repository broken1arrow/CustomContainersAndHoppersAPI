package org.brokenarrow.storage.api.containerholder.itemtransfer;

import org.brokenarrow.storage.api.containerholder.teleport.TeleportTarget;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * The context for move item from one inventory to another inventory.
 */
public interface ItemTransferContext extends TeleportTarget {


    /**
     * Returns a snapshot of the contents of the target container.
     *
     * <p>
     * For more precise control over custom containers, consider using
     * {@link #slotBased()} or {@link #aggregated()} if those capabilities
     * are supported by the target.
     * </p>
     *
     * <p>
     * In some cases this method may return the contents of a virtual
     * inventory. Modifying the returned contents directly is only safe
     * when {@link #isCustom()} returns {@code false}.
     * </p>
     *
     * @return the contents of the target container
     */
    @NotNull
    ItemStack[] getContents();

    /**
     * Retrieve if the container have at least 1 empty slot.
     *
     * @return  The first empty Slot found, or -1 if no empty slots.
     */
    int firstEmpty();
}
