package org.brokenarrow.storage.api.containerholders;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface InventoryholderDefultContiners extends InventoryHolders {
	
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
	 * Get a list of all pages of items in the inventory.
	 *
	 * @return list Of Itemstacks inside.
	 */

	List<ItemStack> listAllPagesItems();

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
	 * This event will check if player click outside of the gui and check both
	 * how many pages the chest has and max amount it can have from container settings
	 * inside one of the yml files.
	 *
	 * @param event  the event.
	 * @param player player some interact with the chest.
	 * @return true if player successful can change page or false if the chest don´t have pages or player can´t change page.
	 */
	@Override
	boolean onClickingInsideGui(InventoryClickEvent event, Player player);
}
