package org.brokenarrow.storage.api.customevents;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.brokenarrow.storage.api.containerholder.teleport.TeleportTarget;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * This event is fired after Link/suction container has try to add item to container.
 */
public class PostHopperTeleportEvent extends EventUtility {
    private static final HandlerList handlers = new HandlerList();
    private final Location toLocation;
    private final InventoryHolder inventoryHolder;
    private final TeleportTarget teleportTarget;
    private final boolean hasTeleportItem;
    private final ItemStack[] itemsMoved;

    /**
     * The event instance after the items is teleported.
     *
     * @param containerLoc    the containers location
     * @param inventoryHolder the older used for the event.
     * @param teleportTarget  the target wrapper
     * @param teleportedItems the items teleported.
     * @param itemsMoved      The items moved.
     */
    public PostHopperTeleportEvent(@Nonnull final Location containerLoc, @Nonnull final InventoryHolder inventoryHolder, @Nonnull final TeleportTarget teleportTarget, final boolean teleportedItems, @Nonnull final ItemStack[] itemsMoved) {
        super(handlers);
        this.toLocation = containerLoc;
        this.inventoryHolder = inventoryHolder;
        this.teleportTarget = teleportTarget;
        this.itemsMoved = itemsMoved;
        this.hasTeleportItem = teleportedItems;
        registerEvent();
    }

    /**
     * Get location it tries to add items to.
     *
     * @return location of the container it try to add items to.
     */
    public Location getToLocation() {
        return toLocation;
    }

    /**
     * Retrieve the custom holder that is involved in the event.
     *
     * @return the instance of the inventory holder.
     */
    public InventoryHolder getInventoryHolder() {
        return inventoryHolder;
    }

    /**
     * Retrieve the target wrapper for the inventory involved in the event.
     *
     * @return Returns the instance of the target wrapper.
     */
    public TeleportTarget getTeleportTarget() {
        return teleportTarget;
    }

    /**
     * Get the items some hopper try to move to container.
     *
     * @return itemstacks with no air and null.
     */
    public ItemStack[] getItemsMoved() {
        return itemsMoved;
    }

    /**
     * if it has successfully moved item
     *
     * @return true if the item has been moved.
     */
    public boolean isItemTeleported() {
        return hasTeleportItem;
    }

    /**
     * Get the list of event handlers.
     *
     * @return the instance of the HandlerList;
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }
}