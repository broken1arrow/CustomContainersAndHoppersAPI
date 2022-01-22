package org.brokenarrow.storage.customevents;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * event get fierd when a suction/link container try pick up item on the ground.
 */

public class PreSuctionEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private final Location itemLocation;
	private final Location toLocation;
	private final Inventory toInventory;
	private final ItemStack itemPickUp;
	private final boolean canPickUpItem;
	private boolean cancelled;

	public PreSuctionEvent(Location itemLocation, ItemStack itemPickUp, Location toLocation, Inventory toInventory, boolean canPickUpItem) {
		this.itemLocation = itemLocation;
		this.toInventory = toInventory;
		this.toLocation = toLocation;
		this.itemPickUp = itemPickUp;
		this.canPickUpItem = canPickUpItem;
	}

	/**
	 * get the location of the item it try pick up.
	 *
	 * @return location of the item.
	 */
	public Location getItemLocation() {
		return this.itemLocation;
	}

	/**
	 * get the location of the inventory
	 * item get added to.
	 *
	 * @return location of the inventory.
	 */
	public Location getToLocation() {
		return toLocation;
	}

	/**
	 * get the inventory it try add the item in.
	 *
	 * @return location of the item.
	 */
	public Inventory getToInventory() {
		return this.toInventory;
	}

	/**
	 * get the item it try pickup.
	 *
	 * @return itemstack.
	 */
	public ItemStack getItemsPickUp() {
		return this.itemPickUp;
	}

	/**
	 * If it can pick up the item or if the hopper filter stops the
	 * item (items are not on the white list or are blacklisted).
	 *
	 * @return true if the item is allowed.
	 */
	public boolean isCanPickUpItem() {
		return canPickUpItem;
	}

	/**
	 * Gets the cancellation state of this event. A cancelled event will not
	 * be executed.
	 *
	 * @return true if this event is cancelled
	 */
	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	/**
	 * Sets the cancellation state of this event. A cancelled event will not
	 * be executed.
	 *
	 * @param cancel true if you wish to cancel this event
	 */
	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
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
