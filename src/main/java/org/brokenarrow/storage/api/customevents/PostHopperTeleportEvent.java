package org.brokenarrow.storage.api.customevents;

import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * This event is fired after Link/suction container has try to add item to container.
 */
public class PostHopperTeleportEvent extends EventUtility {
	private static final HandlerList handlers = new HandlerList();
	private final Location toLocation;
	private final Location fromLocation;
	private final Inventory fromInventory;
	private final Inventory toInventory;
	private final boolean hasTeleportItem;
	private final ItemStack[] itemsMoved;

	/**
	 * Create the event.
	 *
	 * @param toLocation Location where the items get teleported too.
	 * @param fromLocation where the items where.
	 * @param fromInventory the inventory the item was inside.
	 * @param toInventory the inventory it will add the items.
	 * @param hasTeleportItem if it has teleported the items.
	 * @param itemsMoved the items moved.
	 */
	public PostHopperTeleportEvent(Location toLocation, Location fromLocation, Inventory fromInventory, Inventory toInventory, boolean hasTeleportItem, ItemStack[] itemsMoved) {
		super(handlers);
		this.toLocation = toLocation;
		this.fromLocation = fromLocation;
		this.fromInventory = fromInventory;
		this.toInventory = toInventory;
		this.itemsMoved = itemsMoved;
		this.hasTeleportItem = hasTeleportItem;
	}

	/**
	 * Get location it try to add items to.
	 *
	 * @return location of the container it try add items to.
	 */
	public Location getToLocation() {
		return toLocation;
	}


	/**
	 * Get inventory it try to send items to.
	 *
	 * @return inventory some it try to send items to;
	 */
	public Inventory getToInventory() {
		return toInventory;
	}

	/**
	 * Get location where item are moved from.
	 *
	 * @return location of the container it try add items to.
	 */
	public Location getFromLocation() {
		return fromLocation;
	}

	/**
	 * Get inventory it try to send items from.
	 *
	 * @return inventory some it try to send items to;
	 */

	public Inventory getFromInventory() {
		return fromInventory;
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