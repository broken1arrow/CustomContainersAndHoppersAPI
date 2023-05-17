package org.brokenarrow.storage.api.containerholders;

import org.brokenarrow.storage.api.TeleportAndPickupItemsApi;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public interface InventoryHolderLinkSuction extends InventoryHolder {


	String getSuctionRange();

	int getLinkRange();

	TeleportAndPickupItemsApi getTeleportAndPickupItems();

	/**
	 * Check if the item is allowed to be added to container or removed.
	 *
	 * @param itemStack the itemstack that will be check.
	 * @param pullItems if it pull or push items to the container.
	 * @return true if the itemstack match.
	 */
	boolean itemMatching(@Nonnull ItemStack itemStack, @Nullable Inventory targetInventory, boolean pullItems);
}
