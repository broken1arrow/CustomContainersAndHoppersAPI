package org.brokenarrow.storage.api.runnable;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public interface CraftingtasksAPI {

	/**
	 * Get the output item crafted
	 *
	 * @return output item you crafted.
	 */
	ItemStack getItemStack();

	/**
	 * get the amount crafted.
	 *
	 * @return the amount crafted.
	 */
	int getAmountCrafted();

	/**
	 * get the total amount crafted.
	 *
	 * @return the total amount crafted.
	 */
	int getTotalAmountCrafted();

	/**
	 * get the location of the container.
	 *
	 * @return location of the container.
	 */
	Location getLocation();
}
