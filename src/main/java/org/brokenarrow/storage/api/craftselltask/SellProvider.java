package org.brokenarrow.storage.api.craftselltask;

/**
 * interface that you can get what is currently sold.
 */
public interface SellProvider extends CraftSellProvider {

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
	double getCostAmount();
}
