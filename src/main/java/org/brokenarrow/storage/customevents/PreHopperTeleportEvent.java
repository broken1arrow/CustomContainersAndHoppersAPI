package org.brokenarrow.storage.customevents;


import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * This event is fierd before Link/suction container try to add item to container.
 */

public class PreHopperTeleportEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private final Location toLocation;
	private final Location fromLocation;
	private final Inventory fromInventory;
	private final Inventory toInventory;
	private boolean shallRemoveFromHopper;
	private final ItemStack[] itemsMoved;
	private boolean cancelled;

	public PreHopperTeleportEvent(Location toLocation, Location fromLocation, Inventory fromInventory, Inventory toInventory, ItemStack[] itemsMoved) {
		this.toLocation = toLocation;
		this.fromLocation = fromLocation;
		this.fromInventory = fromInventory;
		this.toInventory = toInventory;
		this.itemsMoved = itemsMoved;
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
	 * Get if it shall remove items from hopper after hopper teleport the items.
	 *
	 * @return if it true it will remove items from hopper.
	 */
	public boolean isShallRemoveFromHopper() {
		return shallRemoveFromHopper;
	}

	/**
	 * If it shall remove items from hopper after hopper move the items.
	 *
	 * @param shallRemoveFromHopper set to true if it shall remove items from hopper.
	 */

	public void setShallRemoveFromHopper(boolean shallRemoveFromHopper) {
		this.shallRemoveFromHopper = shallRemoveFromHopper;
	}

	/**
	 * Get if teleport items event are cancelled.
	 *
	 * @return return true if it cancelled.
	 */
	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	/**
	 * Set this to true if you want to stop link/suction hopper to
	 * teleport items to container.
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
