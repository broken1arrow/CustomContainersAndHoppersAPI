package org.brokenarrow.storage.api.customevents;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.brokenarrow.storage.api.containerholder.teleport.TeleportTarget;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * This event is fired before Link/suction container try to add item to container.
 */
public class PreHopperTeleportEvent extends EventUtility {

	private static final HandlerList handlers = new HandlerList();
	private final Location fromLocation;
	private final InventoryHolder fromHolder;
	private final TeleportTarget target;
	private boolean shallRemoveFromHopper;
	private final ItemStack[] itemsMoved;
	private boolean cancelled;

	public PreHopperTeleportEvent(final Location fromLocation, final InventoryHolder fromHolder, final TeleportTarget target, final ItemStack[] itemsMoved) {
		super(handlers);
		this.fromLocation = fromLocation;
		this.fromHolder = fromHolder;
		this.target = target;
		this.itemsMoved = itemsMoved;
		registerEvent();
	}

	/**
	 * Get location it tries to add items to.
	 *
	 * @return location of the container it try to add items to.
	 */

	public Location getToLocation() {
		return target.targetLocation();
	}

	/**
	 * Get inventory it try to send items to.
	 *
	 * @return inventory some it tries to send items to.
	 */

	public TeleportTarget getTarget() {
		return target;
	}


	/**
	 * Get location where item are moved from.
	 *
	 * @return location of the container it try to add items to.
	 */
	public Location getFromLocation() {
		return fromLocation;
	}

	/**
	 * Get the custom inventoryHolder it try to send items from.
	 *
	 * @return inventory some it try to send items to.
	 */
	public InventoryHolder getFromHolder() {
		return fromHolder;
	}


	/**
	 * Get the items some hopper try to move to container.
	 *
	 * @return itemStacks with no air and null.
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

	public void setShallRemoveFromHopper(final boolean shallRemoveFromHopper) {
		this.shallRemoveFromHopper = shallRemoveFromHopper;
	}

	/**
	 * Get if teleport items event are canceled.
	 *
	 * @return return true if it canceled.
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
	public void setCancelled(final boolean toCancel) {
		this.cancelled = toCancel;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
