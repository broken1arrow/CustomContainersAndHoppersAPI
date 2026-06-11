package org.brokenarrow.storage.api.customevents;


import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.brokenarrow.storage.api.containerholder.itemtransfer.ItemTransferContext;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This event is fierd before hopper move item to or from container.
 */

public class PreHopperMoveItemEvent extends EventUtility {
	private static final HandlerList handlers = new HandlerList();
	private final InventoryHolder inventoryHolder;
	private final Location toLocation;
	private final Location fromLocation;
	private final ItemTransferContext sourceTransferContext;
	private final ItemTransferContext targetTransferContext;
	private final ItemStack item;
	private boolean cancelled;

	/**
	 * Before it moves the item.
	 *
	 * @param inventoryHolder the holder that currently evoke this event.
	 * @param sourceTransferContext The source container that move the item.
	 * @param targetTransferContext The target container that move the item too.
	 * @param item the item.
	 */
	public PreHopperMoveItemEvent(@NotNull final InventoryHolder inventoryHolder, final ItemTransferContext sourceTransferContext, final ItemTransferContext targetTransferContext, @NotNull final ItemStack item) {
		super(handlers);
		this. inventoryHolder = inventoryHolder;

		this.targetTransferContext = targetTransferContext;
		this.sourceTransferContext = sourceTransferContext;

		this.toLocation = targetTransferContext.targetLocation();
		this.fromLocation = sourceTransferContext.targetLocation();

		this.item = item;
		registerEvent();
	}

	/**
	 * Returns the {@link InventoryHolder} involved in this event.
	 *
	 * <p>
	 * This typically represents the hopper or container responsible
	 * for initiating the transfer.
	 * </p>
	 *
	 * @return the inventory holder involved in the transfer
	 */
	@NotNull
	public InventoryHolder getInventoryHolder() {
		return inventoryHolder;
	}

	/**
	 * Returns the location the item is being transferred to.
	 *
	 * @return the target container location
	 */
	@Nullable
	public Location getToLocation() {
		return toLocation;
	}

	/**
	 * Returns the transfer context representing the target container.
	 *
	 * @return the target transfer context
	 */
	@Nullable
	public ItemTransferContext getTarget() {
		return targetTransferContext;
	}


	/**
	 * Returns the location the item is being transferred from.
	 *
	 * @return the source container location
	 */
	@Nullable
	public Location getFromLocation() {
		return fromLocation;
	}

	/**
	 * Returns the transfer context representing the source container.
	 *
	 * @return the source transfer context
	 */
	public ItemTransferContext getSource() {
		return sourceTransferContext;
	}

	/**
	 * Returns the item the hopper is attempting to transfer.
	 *
	 * @return the item being moved
	 */
	@NotNull
	public ItemStack getItem() {
		return item;
	}

	/**
	 * Returns whether this transfer has been canceled.
	 *
	 * @return true if the transfer is canceled
	 */
	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	/**
	 * Cancels or allows the hopper transfer.
	 *
	 * @param cancel true to cancel the transfer
	 */
	@Override
	public void setCancelled(final boolean cancel) {
		this.cancelled = cancel;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}