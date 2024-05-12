package org.brokenarrow.storage.api.craftselltask;

/**
 * Interface for accessing data about the currently crafted item.
 */
public interface CraftingProvider extends CraftSellProvider {

		/**
		 * Retrieves the amount of this item type crafted.
		 *
		 * @return The amount crafted.
		 */
		int getAmountCrafted();

}
