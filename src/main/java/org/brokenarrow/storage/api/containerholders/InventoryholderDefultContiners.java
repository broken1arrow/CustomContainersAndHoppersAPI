package org.brokenarrow.storage.api.containerholders;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface InventoryholderDefultContiners extends InventoryHolder {


	/**
	 * Create inventory/inventorys if not exist.
	 */
	void loadInventory();

	/**
	 * Create inventory/inventorys if not exist.
	 *
	 * @param player some open inventory.
	 * @return the inventory if it could create one.
	 */
	@Nullable
	Inventory loadInventory(final Player player);

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

	/**
	 * Set all need pages in the inventory if needed.
	 * Will check if it can set more pages or if it has max amount of
	 * pages.
	 *
	 * @param size          size of the inventory.
	 * @param numberOfPages number of pages you want the containber shall have.
	 * @param type          type of container
	 * @param title         inventory titel.
	 */
	void setPagesInCache(int size, int numberOfPages, @Nullable InventoryType type, String title);
}
