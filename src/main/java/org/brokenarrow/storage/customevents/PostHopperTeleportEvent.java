package org.brokenarrow.storage.customevents;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * This event is fierd after Link/suction container has try to add item to container.
 */
public class PostHopperTeleportEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	private final Location toLocation;
	private final Location fromLocation;
	private final Inventory fromInventory;
	private final Inventory toInventory;
	private final boolean hasTeleportItem;
	private final ItemStack[] itemsMoved;

	public PostHopperTeleportEvent(Location toLocation, Location fromLocation, Inventory fromInventory, Inventory toInventory, boolean hasTeleportItem, ItemStack[] itemsMoved) {
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
	 * Get inventory it try send items to.
	 *
	 * @return inventory some it try send items to;
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
	 * Get inventory it try send items from.
	 *
	 * @return inventory some it try send items to;
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
	 * @return true if the item has bee moved.
	 */
	public boolean isItemTeleported() {
		return hasTeleportItem;
	}

	@NotNull
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}