package org.brokenarrow.storage.api.containerholder;

import org.brokenarrow.storage.api.TeleportAndPickupItemsApi;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * The inventory holder for containers that pick up items on ground or teleport items between containers.
 */
public interface InventoryHolderLinkSuction extends InventoryHolder {

	/**
	 * Get the suction range for this container.
	 *
	 * @return the suction range or empty sting if range not set.
	 */
	@Nonnull
	String getSuctionRange();

	/**
	 * Get the link range for this container.
	 *
	 * @return the link range or -1 if this is not set.
	 */
	int getLinkRange();

	/**
	 * Get the instance of the class that contains the
	 * methods for the teleport and pick up items.
	 *
	 * @return the TeleportAndPickupItems instance.
	 */
	@Nonnull
	TeleportAndPickupItemsApi getTeleportAndPickupItems();

	/**
	 * Check if the item is allowed to be added to container or removed.
	 *
	 * @param itemStack       the itemStack that will be checked.
	 * @param pullItems       if it pulls or push items to the container.
	 * @param targetInventory The inventory items get pushed too.
	 * @return true if the itemStack match.
	 */
	boolean itemMatching(@Nonnull ItemStack itemStack, @Nullable Inventory targetInventory, boolean pullItems);
}
