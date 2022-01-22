package org.brokenarrow.storage.customevents;


import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * This event is fierd before hopper move item to or from container.
 */

public class PreHopperMoveItemEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private final Location toLocation;
	private final Location fromLocation;
	private final Inventory fromInventory;
	private final Inventory toInventory;
	private final ItemStack item;
	private boolean cancelled;

	public PreHopperMoveItemEvent(Location toLocation, Location fromLocation, Inventory fromInventory, Inventory toInventory, ItemStack item) {
		this.toLocation = toLocation;
		this.fromLocation = fromLocation;
		this.fromInventory = fromInventory;
		this.toInventory = toInventory;
		this.item = item;

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
	 * @return itemstacks.
	 */
	public ItemStack getItems() {
		return item;
	}

	/**
	 * Get if move items event are cancelled.
	 *
	 * @return return true if it cancelled.
	 */

	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	/**
	 * Set this to true if you want to stop hopper move item to or from container.
	 *
	 * @param toCancel set it to true if you want to cancel event.
	 */
	@Override
	public void setCancelled(boolean toCancel) {
		this.cancelled = toCancel;
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