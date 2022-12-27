package org.brokenarrow.storage.api.customevents;


import org.brokenarrow.storage.api.containerholders.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This event is fierd before hopper move item to or from container.
 */

public class PreHopperMoveItemEvent extends EventUtility {

	private static final HandlerList handlers = new HandlerList();
	private final Object inventoryHolder;
	private final Location toLocation;
	private final Location fromLocation;
	private final Inventory fromInventory;
	private final Inventory toInventory;
	private final ItemStack item;
	private boolean cancelled;

	public PreHopperMoveItemEvent(@NotNull final InventoryHolder inventoryHolder, final Location toLocation, final Location fromLocation, final Inventory fromInventory, final Inventory toInventory, @NotNull final ItemStack item) {
		super(handlers);
		this.inventoryHolder = inventoryHolder;
		this.toLocation = toLocation;
		this.toInventory = toInventory;
		this.fromLocation = fromLocation;
		this.fromInventory = fromInventory;
		this.item = item;
		registerEvent();
	}

	/**
	 * Get the inventoryHolder some is involved in this event. You get acces to everything inside
	 * {@link InventoryHolder} and other classes some exstends InventoryHolder interface (need then cast to right class if you want acces all methods).
	 *
	 * @return inventoryHolder instance.
	 */
	@NotNull
	public Object getInventoryHolder() {
		return inventoryHolder;
	}

	/**
	 * Get location it try to add items to.
	 *
	 * @return location of the container it try add items to.
	 */
	@Nullable
	public Location getToLocation() {
		return toLocation;
	}

	/**
	 * Get inventory it try send items to.
	 *
	 * @return inventory some it try send items to;
	 */
	@Nullable
	public Inventory getToInventory() {
		return toInventory;
	}


	/**
	 * Get location where item are moved from.
	 *
	 * @return location of the container it try add items to.
	 */

	@Nullable
	public Location getFromLocation() {
		return fromLocation;
	}

	/**
	 * Get inventory it try send items from.
	 *
	 * @return inventory some it try send items to;
	 */
	@Nullable
	public Inventory getFromInventory() {
		return fromInventory;
	}

	/**
	 * Get the items some hopper try to move to container.
	 *
	 * @return itemstack it currently transfer.
	 */
	@NotNull
	public ItemStack getItem() {
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
	 * @param cancel set it to true if you want to cancel event.
	 */
	@Override
	public void setCancelled(final boolean cancel) {
		this.cancelled = cancel;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}