package org.brokenarrow.storage.api.customevents;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * event get fired when a suction/link container try pick up item on the ground.
 */

public class PreSuctionEvent extends EventUtility {
	private static final HandlerList handlers = new HandlerList();
	private final Location itemLocation;
	private final Location toLocation;
	private final InventoryHolder toInventoryHolder;
	private final ItemStack itemPickUp;
	private final boolean canPickUpItem;
	private boolean cancelled;

	/**
	 * Creates instance when container try to pick up items in an area.
	 *
	 * @param itemLocation the location of the item.
	 * @param itemPickUp the item it tries to pickup.
	 * @param toLocation the location where the item ends up.
	 * @param inventoryHolder the inventory the items end up.
	 * @param canPickUpItem if it could pick up items.
	 */
	public PreSuctionEvent(final Location itemLocation, final ItemStack itemPickUp, final Location toLocation, final InventoryHolder inventoryHolder, final boolean canPickUpItem) {
		super(handlers);
		this.itemLocation = itemLocation;
		this.toInventoryHolder = inventoryHolder;
		this.toLocation = toLocation;
		this.itemPickUp = itemPickUp;
		this.canPickUpItem = canPickUpItem;
		registerEvent();
	}

	/**
	 * get the location of the item it tries to pick up.
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
	 * get the inventory it tries to add the item in.
	 *
	 * @return The inventoryHolder instance involved in the event.
	 */
	public InventoryHolder getToInventoryHolder() {
		return this.toInventoryHolder;
	}

	/**
	 * get the item it tries to pickup.
	 *
	 * @return itemStack.
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
	 * Gets the cancellation state of this event. A canceled event will not
	 * be executed.
	 *
	 * @return true if this event is canceled
	 */
	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	/**
	 * Sets the cancellation state of this event. A canceled event will not
	 * be executed.
	 *
	 * @param cancel true if you wish to cancel this event
	 */
	@Override
	public void setCancelled(final boolean cancel) {
		this.cancelled = cancel;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
