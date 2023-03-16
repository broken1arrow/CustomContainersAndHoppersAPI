package org.brokenarrow.storage.api.containerholders;

import org.brokenarrow.storage.api.TeleportAndPickupItemsApi;

public interface InventoryHolderLinkSuction extends InventoryHolder {


	String getSuctionRange();
	int getLinkRange();
	TeleportAndPickupItemsApi getTeleportAndPickupItems();
}
