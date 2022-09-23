package org.brokenarrow.storage.api.containerholders;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface InventoryholderDefultContiners extends InventoryHolder {

	/**
	 * Get first page with matching item inside.
	 *
	 * @param item item you want to check.
	 * @return inventory some contains at lest 1 matching item.
	 */
	Inventory getFirstPageWithItems(ItemStack item);

	/**
	 * Get amount of one item type
	 *
	 * @param itemStack item you want to check amount.
	 * @return amount of this itemStack.
	 */
	int getAmountOfOneItem(ItemStack itemStack);

	/**
	 * Get the page some has items, if one page
	 * are emty it will check next page for items
	 * or the page befor if it has items.
	 * <p>
	 * <p>
	 * If inventory not exist, it will create new one automatic
	 * with right amount of pages.
	 *
	 * @return inventory with 1 or more empty slots.
	 */

	Inventory getEmptyPage();

	/**
	 * Get the number of pages for one container.
	 *
	 * @return get number of pages the inventory has.
	 */
	int getPagesAmount();

	/**
	 * Get the page you want to open.
	 *
	 * @param page the page you whant to open of this container.
	 * @return inventory on that page number you put in.
	 */
	Inventory getPage(int page);

	/**
	 * Get page number of the inventory.
	 *
	 * @param inventory inventory you whant to get the page.
	 * @return the page of the inventory.
	 */

	int getPageIndex(final Inventory inventory);
}
