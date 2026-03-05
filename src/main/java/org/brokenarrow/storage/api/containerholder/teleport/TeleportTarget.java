package org.brokenarrow.storage.api.containerholder.teleport;

import org.broken.arrow.library.logging.Validate;
import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Optional;

/**
 * Represents a generic destination for item teleportation between containers.
 *
 * <p>
 * This abstraction removes the need for manual casting between different
 * inventory types (e.g., Bukkit inventories, custom inventories, or
 * slot-based implementations) by exposing a unified contract.
 * </p>
 *
 * <p>
 * Implementations may support additional capabilities such as slot-based
 * insertion or aggregated storage handling. These capabilities can be
 * discovered using the provided optional accessors.
 * </p>
 */
public interface TeleportTarget {

    /**
     * Returns the physical location associated with this teleport target.
     *
     * <p>
     * This is typically the block or container location where items
     * will be inserted.
     * </p>
     *
     * @return the target {@link Location}
     */
    Location targetLocation();

    /**
     * Attempts to add the given items to this teleport target.
     *
     * <p>
     * The returned map contains any items that could not be inserted,
     * following Bukkit's {@link Inventory#addItem(ItemStack...)} behavior.
     * </p>
     *
     * @param items the items to insert
     * @return a map of slot index to remaining {@link ItemStack} that
     * could not be added
     */
    Map<Integer, ItemStack> addItems(ItemStack... items);

    /**
     * Returns the underlying Bukkit {@link Inventory}, if this target
     * represents a Bukkit-based container.
     *
     * @return the Bukkit inventory
     * @throws Validate.ValidateExceptions if this target does not
     *                                     represent a Bukkit inventory
     */
    default Inventory getBukkit() {
        throw new Validate.ValidateExceptions("Not a Bukkit inventory target");
    }

    /**
     * Returns the underlying custom {@link InventoryHolder}, if this
     * target represents a custom container implementation.
     *
     * @return the custom inventory holder
     * @throws Validate.ValidateExceptions if this target does not
     *                                     represent a custom inventory
     */
    default InventoryHolder getCustom() {
        throw new Validate.ValidateExceptions("Not a custom inventory target");
    }

    /**
     * Returns an optional slot-based view of this teleport target.
     *
     * <p>
     * If the implementation supports slot-specific teleport behavior,
     * this method provides access to that capability.
     * </p>
     *
     * @return an {@link Optional} containing the slot-based target,
     * or empty if not supported
     */
    default Optional<SlotBasedTeleportTarget> slotBased() {
        if (this instanceof SlotBasedTeleportTarget)
            return Optional.of((SlotBasedTeleportTarget) this);
        return Optional.empty();
    }

    /**
     * Returns an optional aggregated storage view of this teleport target.
     *
     * <p>
     * Implementations that support aggregated storage systems
     * (e.g., merged inventories or virtual storage backends)
     * can expose that capability through this method.
     * </p>
     *
     * @return an {@link Optional} containing aggregated storage support,
     * or empty if not supported
     */
    default Optional<AggregatedStorageSupport> aggregated() {
        if (this instanceof AggregatedStorageSupport)
            return Optional.of((AggregatedStorageSupport) this);
        return Optional.empty();
    }

    /**
     * Indicates whether this teleport target represents a custom
     * inventory implementation rather than a standard Bukkit inventory.
     *
     * @return {@code true} if this target is custom-based,
     * {@code false} otherwise
     */
    boolean isCustom();
}
