package org.brokenarrow.storage.api.containerholders;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface InventoryHolders {

	/**
	 * Open container for player.
	 *
	 * @param player     player some open container.
	 * @param pageNumber witch page player shall open (if the container have pages).
	 */

	void openContainer(Player player, int pageNumber);


	/**
	 * Create inventory if not exist and add items if
	 * the gui has items before.
	 *
	 * @return the gui player open.
	 */


	Inventory createAndLoadInventory();

	/**
	 * Create inventory when hopper try add or remove items.
	 *
	 * @return inventory or null if it alredy created.
	 */
	Inventory setInventoryHopper();

	/**
	 * Get size some are set inside yml file.
	 *
	 * @return return int value of invetory size.
	 */

	int getguiSize();

	/**
	 * Set new page if it not exist.
	 *
	 * @param type  set type of inventory or null if
	 *              you want chest gui with size.
	 * @param size  size of the inventory.
	 * @param title The description of the gui
	 * @return return array of invetorys.
	 */
	Inventory setPage(InventoryType type, int size, String title);

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
	 * Get the page you want to open.
	 *
	 * @param location the container location.
	 * @param page     the page you whant to open of this container.
	 * @return inventory on that page number you put in.
	 */
	Inventory getPage(Location location, int page);

	/**
	 * Get number of the gui player has curent
	 * open.
	 *
	 * @param inventory inventory you looking for
	 * @return the page of the inventory you current has open.
	 */

	int getPageIndex(Inventory inventory);

	/**
	 * Get the number of pages for one container.
	 *
	 * @param location the container location.
	 * @return get number of pages the inventory has.
	 */
	int getPagesAmount(Location location);

	/**
	 * check if inventory exist for a conatiner.
	 *
	 * @param location of the container
	 * @return true if it exist.
	 */

	boolean isInventoryExist(Location location);

	/**
	 * Get a Inventory for a container.
	 *
	 * @param location location of the inventor want to find.
	 * @return return inventoy on location you has requested
	 * or null if it not find the gui.
	 */
	ArrayList<Inventory> getInventory(Location location);

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
	 *
	 * @return inventory with items.
	 */

	Inventory getEmptyPages();

	/**
	 * Get a list of all pages of items in the inventory.
	 *
	 * @return list Of Itemstacks inside.
	 */

	List<ItemStack> listAllPagesItems();

	/**
	 * Set item on a specific slot. Will override the old item if the slot
	 * already has an item. Use {@link #addItems(ItemStack...)} if you want
	 * to add items.
	 *
	 * @param slot      you want to set the item.
	 * @param itemStack item you want to set in the slot.
	 */
	void setItem(int slot, ItemStack itemStack);

	/**
	 * Get the item in a specific slot.
	 * <p>
	 * slot you want to get the item.
	 * item or null, if the slot does not, has any item.
	 */
	ItemStack getItem(int slot);

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
	 */

	Map<Integer, ItemStack> addItems(ItemStack... itemStacks);

	/**
	 * It are used for count items and that way
	 * calulate what page the item shall bee puted.
	 * See {@link InventoryholderDefultContiners#setContents(ItemStack...)} ()}
	 *
	 * @return count number of itemstacks and return
	 * a number of stacks some you put in.
	 * @see #setContents(ItemStack...) () org.broken.cheststorage.inventoryholders.InventoryHolderDefultchest
	 */


	int countItemStacks(ItemStack[] itemStacks);

	/**
	 * Check if chest are full.
	 *
	 * @param itemStack items some you add to the chest
	 * @param from      the inventory items are from.
	 * @return true if chest are not full.
	 */
	boolean checkIfChestFull(ItemStack itemStack, Inventory from);

	/**
	 * Check if chest is full. Will be some delay, so if you use this, you has to track last tranfered item
	 * and add item back to source. I do it auto in checkIfChestFull method.
	 *
	 * @return true if chest is full.
	 * @see #checkIfChestFull(ItemStack, Inventory).
	 */

	boolean isIfChestFull();


	/**
	 * Set items in the chest on this cords,
	 * if you have more an one page, it will
	 * set items on this too.
	 *
	 * @param itemStacks items you want to add
	 */
	void setContents(ItemStack... itemStacks);

	/**
	 * Save the items to cache.
	 *
	 * @param player get the player some close the gui.
	 */
	void onContainerClose(Player player);

	/**
	 * When you break container it collect all pages of items
	 * and drop it on the ground.
	 *
	 * @param event the event some get trigged when you break a container.
	 * @return return true after it has finished.
	 */

	boolean dropItemsOnBlockBreak(BlockBreakEvent event);

	/**
	 * Remove inventory on location
	 *
	 * @param location of the container you whan remove inventory
	 */

	void removeInventory(Location location);

	/**
	 * Get the amount of items inside the container.
	 *
	 * @return the amount of items in the container.
	 */
	BigInteger getAmount();

	/**
	 * When you break the continer it check what type of container
	 * and will return back right type of container and remove from
	 * cache both the inventory (if it exist) and the database.
	 *
	 * @param event the event some get trigged when you break the chest.
	 */

	void onContainerBreak(BlockBreakEvent event);

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
	 * Handle inventory clickevent. For ether when player add/remove items
	 * or change page.
	 * To see how it is set up for Storage Unit and rest of the chest use the defult one in See also.
	 *
	 * @param location location of the container.
	 * @param event    the event.
	 * @param player   player some interact with the chest.
	 * @return true if player successful can do the action in the inventory.
	 * @see InventoryholderStorageUnit#onClickingInsideGui(Location, InventoryClickEvent, Player)
	 * @see InventoryholderDefultContiners#onClickingInsideGui(Location, InventoryClickEvent, Player)
	 */

	boolean onClickingInsideGui(Location location, InventoryClickEvent event, Player player);

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


}
