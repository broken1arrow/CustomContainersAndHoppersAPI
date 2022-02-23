package org.brokenarrow.storage.api.runnable;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public interface SelltasksAPI {

	/**
	 * Get the itemstack sold.
	 *
	 * @return itemstack some is sold.
	 */
	ItemStack getItemStack();

	/**
	 * Get the cost for the item
	 *
	 * @return the cost for 1 item.
	 */
	double getCostAmount();

	/**
	 * Get the total amount sold.
	 *
	 * @return amount sold.
	 */
	int getAmountItemsSold();

	/**
	 * Get the total amount sold.
	 *
	 * @return total amount sold.
	 */
	double getTotalCost();

	/**
	 * get the location of the container the item are sold in.
	 *
	 * @return location of the container.
	 */
	Location getLocation();
}
