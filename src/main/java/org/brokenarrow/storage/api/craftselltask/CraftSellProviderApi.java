package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface CraftSellProviderApi {


	/**
	 * Get the output item some ether get crafted or sold.
	 *
	 * @return output item.
	 */
	@Nullable
	ItemStack getItemStack();

	/**
	 * Get the type of task curently running.
	 *
	 * @return the type of task.
	 */
	TypeOfTask getTaskType();

	/**
	 * Get the cost for the item
	 *
	 * @return the cost for 1 item type.
	 */
	default double getCostAmount() {
		return 0;
	}

	/**
	 * Get the total amount of this item type sold.
	 *
	 * @return amount sold.
	 */
	default int getAmountItemsSold() {
		return 0;
	}

	/**
	 * Get the amount of this item type crafted.
	 *
	 * @return the amount crafted.
	 */
	default int getAmountCrafted() {
		return 0;
	}

}
