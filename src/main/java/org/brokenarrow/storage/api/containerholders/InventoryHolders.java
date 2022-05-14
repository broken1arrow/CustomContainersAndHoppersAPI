package org.brokenarrow.storage.api.containerholders;

import org.brokenarrow.storage.util.TypeOfContainer;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface InventoryHolders {

	/**
	 * Set item on a specific index. Will override the old item if the index
	 * already has an item. Use {@link #addItems(ItemStack...)} if you want
	 * to add items.
	 *
	 * @param index     you want to set the item.
	 * @param itemStack item you want to set in the index.
	 */
	void setItem(int index, ItemStack itemStack);

	/**
	 * Get the item in a specific index.
	 * <p>
	 * index you want to get the item.
	 * item or null, if the index does not, has any item.
	 *
	 * @param index number you want to get the item.
	 * @return itemstack.
	 */
	ItemStack getItem(int index);

	/**
	 * Get the contents in the chest.
	 *
	 * @return items from curent gui you close, will save all pages.
	 */

	ItemStack[] getContents();

	/**
	 * Add items to the chest and change page if first is full.
	 * If chest are full it will return the items some not fit.
	 *
	 * @param itemStacks items hopper try to add
	 * @return items some not fit in the gui.
	 * @see InventoryholderStorageUnit
	 * @see InventoryholderDefultContiners
	 */

	Map<Integer, ItemStack> addItems(ItemStack... itemStacks);
	
	/**
	 * Set items in the container. It will override all old items
	 * you have stored inside the container.
	 * <p>
	 * <p>
	 * <p>
	 * If this container have more pages it will automatic add items when
	 * first inventory is full (it will also respect empty slots).
	 *
	 * @param itemStacks items you want to set.
	 */
	void setContents(ItemStack[] itemStacks);

	/**
	 * It are used for count items and that way
	 * calulate what page the item shall bee puted.
	 * See {@link InventoryHolders#setContents(ItemStack...)} ()}
	 *
	 * @return count number of itemstacks and return
	 * a number of stacks some you put in.
	 * @see #setContents(ItemStack...) () org.broken.cheststorage.inventoryholders.InventoryHolderDefultchest
	 */

	int countItemStacks(ItemStack[] itemStacks);


	/**
	 * Get a Inventory for a container. Will return first
	 * page always.
	 *
	 * @return return first inventory or null if it not contains any inventorys.
	 */
	Inventory getInventory();

	/**
	 * Get a Inventory for a container. Type what page you want to get.
	 *
	 * @param page of the inventory.
	 * @return return inventory you has requested
	 * or null if it not find the inventory.
	 */
	Inventory getInventory(int page);

	/**
	 * Get a Inventory for a container.
	 *
	 * @return return inventoy on location you has requested
	 * or null if it not find the gui.
	 */
	List<Inventory> getInventorys();

	/**
	 * Get size some are set inside yml file.
	 *
	 * @return return int value of inventory size.
	 */

	int getSize();


	/*
	 * ##########################################
	 * Custom methods to container.
	 */

	/**
	 * Create inventory if not exist and add items if
	 * the gui has items before.
	 *
	 * @return inventory if player is not null.
	 */
	Inventory loadInventory();

	/**
	 * Create inventory if not exist and add items if
	 * the gui has items before.
	 *
	 * @param player some open inventory.
	 * @return inventory if player is not null.
	 */
	Inventory loadInventory(Player player);

	/**
	 * Set inventory in cache, return false if {@link #getInventorys()}
	 * exist and amount of pages is same as amount stored in the list.
	 *
	 * @param type of inventory.
	 * @return return true if it have created inventorys.
	 */
	boolean setInventory(InventoryType type);

	/**
	 * Set new page if it not exist.
	 *
	 * @param type  set type of inventory or null if
	 *              you want chest gui with size.
	 * @param size  size of the inventory.
	 * @param title The description of the gui
	 * @return return array of invetorys.
	 */
	void setPagesInCache(InventoryType type, int size, String title);

	/**
	 * Create an inventory for containers.
	 *
	 * @param inventoryType Set type of container like chest or hopper
	 *                      set it to null to generate chest gui with size.
	 * @param title         set the title on the gui some be created.
	 * @param inventorySize set inventory size, as defult it will take settings from containers yml files.
	 * @return A inventory with your settings.
	 * @deprecated minecraft not use Strings, but Component to set text (I use this method to set titles {@link #updateInventoryTitle}).
	 * <p> Use {@link InventoryHolders#createInventory(InventoryType, Component, Integer)}
	 */
	@Deprecated()
	Inventory createInventory(InventoryType inventoryType, String title, Integer inventorySize);

	/**
	 * Not fixed yet. Will fix in futcher and this will only work on paper.
	 * <p>
	 * Create an inventory for containers.
	 *
	 * @param inventoryType Set type of container like chest or hopper
	 *                      set it to null to generate chest gui with size.
	 * @param title         set the title on the gui some be created.
	 * @param inventorySize set inventory size, as defult it will take settings from containers yml files.
	 * @return A inventory with your settings.
	 */

	Inventory createInventory(InventoryType inventoryType, Component title, Integer inventorySize);


	/**
	 * Get page number of the inventory.
	 *
	 * @param inventory you whant to get the page.
	 * @return the page of the inventory.
	 */

	int getPageIndex(Inventory inventory);


	/**
	 * check if inventory exist for a container.
	 *
	 * @param inventory of the container
	 * @return true if it exist.
	 */

	boolean containsClickedInventory(Inventory inventory);


	/**
	 * Save the items to cache.
	 */
	void saveToCache();

	/**
	 * When you break container it collect all pages of items
	 * and drop it on the ground.
	 *
	 * @param event the event some get trigged when you break a container.
	 * @return return true after it has finished.
	 */

	boolean dropItemsOnBlockBreak(BlockBreakEvent event);

	/**
	 * Remove all inventorys for this
	 * inventoryholder.
	 */
	void removeInventorys();

	/**
	 * Get the amount of items inside the container.
	 *
	 * @return the amount of items in the container.
	 */
	BigInteger getAmount();

	/**
	 * Drop items 1 stack at the time, if you try drop 128 items
	 * they become invisible (but can be picked up). so to avoid
	 * this it will drop a maximum of 64 items at the same tick.
	 *
	 * @param itemStack add itemstacks some get converted to 64 items at max
	 *                  or the items max stack size.
	 */

	void dropItemsOnGround(ItemStack itemStack);

	/**
	 * Check if the item can be placeded inside the chest.
	 *
	 * @param itemStack the items some hopper or player try to add.
	 * @return true if you can place items inside.
	 */
	boolean canPlaceItemInsideContainer(ItemStack itemStack);

	/**
	 * Get type of continer this holder is conected too.
	 *
	 * @return type of container.
	 */
	TypeOfContainer getTypeofContainer();

	/**
	 * Set the page player open and it also set the player some open container.
	 *
	 * @param player     set the player.
	 * @param pageNumber set pagenumber player shall open.
	 */
	void setPlayerViwePage(Player player, int pageNumber);

	/**
	 * Get what page a player curently has open
	 * (will not say if he has the inventory open or not).
	 *
	 * @param player get the player some open the gui.
	 */

	int getPlayerViwePage(Player player);

	/**
	 * Method to see if cache are empty.
	 *
	 * @param player check if the cache are empty.
	 * @return true if player exist.
	 */
	boolean isPlayerViwePageEmpty(Player player);

	/**
	 * Set the defult placeholders inside inventory if container are empty, on all slots
	 * but not center slot.
	 */
	void setItemPlaceholderEmptyChest();

	/**
	 * Remove player from cache.
	 *
	 * @param player remove the players cache data for page.
	 */
	void removePlayerViwePage(Player player);


	/**
	 * Update data if new data added whern the plugin runing or if it not exist.
	 *
	 * @param location of the container
	 * @param player   the player some open the container.
	 */
	void updateData(Location location, Player player);

	/**
	 * Update the inventory title for container, it take the tittle
	 * from the yml file.
	 *
	 * @param amounts amount of items in BigInteger value.
	 * @param cursor  items added to the chest (can be set to null).
	 */

	void updateInventoryTitle(BigInteger amounts, ItemStack cursor);

	/**
	 * Get if container are open or not.
	 *
	 * @return true if player have open the container.
	 */

	boolean isIfContainerAreOpen();

	/**
	 * Get wivers of inventory.
	 *
	 * @param page you want to get the inventory.
	 * @return amount of current viwers or -1 if inventory is null.
	 */
	int getViewersAmount(int page);

	/**
	 * Get wivers of inventory.
	 *
	 * @param inventory inventory you want to check.
	 * @return amount of current viwers or -1 if inventory is null.
	 */
	int getViewersAmount(Inventory inventory);

	/**
	 * Get container location inventory/inventory´s are linked to.
	 *
	 * @return location of this container or null.
	 */
	Location getLocation();

	/**
	 * Get the last user of the container.
	 *
	 * @return player some open the container last.
	 */
	Player getPlayer();

	/**
	 * Get the owner of the container.
	 *
	 * @return Offline owner of this inventory.
	 */
	OfflinePlayer getOwner();

	/**
	 * Get the owner of the container.
	 *
	 * @return owner´s UUID.
	 */
	UUID getOwnerUUID();

	/*
	 * ################################################
	 * Player actions, when player open,break or close inventory.
	 */

	/**
	 * Open container for player.
	 *
	 * @param player     player some open container.
	 * @param pageNumber witch page player shall open (if the container have pages).
	 */

	void openContainer(Player player, int pageNumber);

	/**
	 * Handle inventory clickevent. For ether when player add/remove items
	 * or change page.
	 * To see how it is set up for Storage Unit and rest of the chest use the defult one in See also.
	 *
	 * @param event  the event.
	 * @param player player some interact with the chest.
	 * @return true if player successful can do the action in the inventory.
	 * @see InventoryholderStorageUnit#onClickingInsideGui(InventoryClickEvent, Player)
	 * @see InventoryholderDefultContiners#onClickingInsideGui(InventoryClickEvent, Player)
	 */

	boolean onClickingInsideGui(InventoryClickEvent event, Player player);

	/**
	 * When you break the continer it check what type of container
	 * and will return back right type of container and remove from
	 * cache both the inventory (if it exist) and the database.
	 *
	 * @param event the event some get trigged when you break the chest.
	 */

	void onContainerBreak(BlockBreakEvent event);

	/**
	 * when player close innventory.
	 *
	 * @param player get the player some close the gui.
	 */
	void onContainerClose(Player player);


}
