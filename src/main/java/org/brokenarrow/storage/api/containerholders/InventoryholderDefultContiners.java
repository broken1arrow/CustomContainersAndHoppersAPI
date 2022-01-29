package org.brokenarrow.storage.api.containerholders;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface InventoryholderDefultContiners extends InventoryHolders {


	/**
	 * Create inventory if not exist and add items if
	 * the gu has items before.
	 *
	 * @return the gui player open.
	 */

	@Override
	Inventory createAndLoadInventory();

	/**
	 * @return return inventory or null if it allredy created.
	 */

	@Override
	Inventory setInventoryHopper();

	/**
	 * Set items in the chest on this cords,
	 * if you have more an one page, it will
	 * set items on this too (if a slot not has items
	 * it will return air or null (slots will be empty)).
	 */

	@Override
	void setContents(ItemStack... itemStack);

	/**
	 * Get the contents in the chest.
	 *
	 * @return items from curent gui you close, will save all pages.
	 */
	@Override
	ItemStack[] getContents();

	/**
	 * This event will check if player click outside of the gui and check both
	 * how many pages the chest has and max amount it can have from container settings
	 * inside one of the yml files.
	 *
	 * @param location location of the container.
	 * @param event    the event.
	 * @param player   player some interact with the chest.
	 * @return true if player successful can change page or false if the chest don´t have pages or player can´t change page.
	 */
	@Override
	boolean onClickingInsideGui(Location location, InventoryClickEvent event, Player player);

	/**
	 * Save the items to cache.
	 *
	 * @param player get the player some close the gui.
	 */

	@Override
	void onContainerClose(Player player);

}
