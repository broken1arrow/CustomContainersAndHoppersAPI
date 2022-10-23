package org.brokenarrow.storage.api.containerholders;


import org.brokenarrow.storage.util.TypeOfContainer;
import org.brokenarrow.storage.util.builderclass.ContainerData;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface InventoryHolder {

	/**
	 * Set item on a specific index. Will override the old item if the index
	 * already has an item. Use {@link #addItems(ItemStack...)} if you want
	 * to add items.
	 *
	 * @param index     you want to set the item.
	 * @param itemStack item you want to set in the index.
	 */
	void setItem(final int index, final ItemStack itemStack);

	/**
	 * Get the item in a specific index. You get item or air/null if the ccontainer is empty.
	 * If you try get items outside the array length you get ArrayIndexOutOfBoundsException.
	 *
	 * @param index number you want to get the item.
	 * @return itemstack.
	 * @throws ArrayIndexOutOfBoundsException if index is out of bound.
	 */
	@Nullable
	ItemStack getItem(final int index);

	/**
	 * Get the contents in the chest.
	 *
	 * @return items from curent gui you close, will save all pages.
	 */
	@NotNull
	ItemStack[] getContents();

	/**
	 * Add items to the chest and change page if first is full.
	 * If chest are full it will return the items some not fit.
	 *
	 * @param itemStacks items hopper try to add
	 * @return items some not fit in the gui.
	 * @see ContainerHolderStorageUnit
	 */
	@NotNull
	Map<Integer, ItemStack> addItems(final ItemStack... itemStacks);

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
	void setContents(final ItemStack[] itemStacks);

	/**
	 * It are used for count items and that way
	 * calulate what page the item shall bee puted.
	 * See {@link InventoryHolder#setContents(ItemStack...)} ()}
	 *
	 * @return count number of itemstacks and return
	 * a number of stacks some you put in.
	 * @see #setContents(ItemStack...) () org.broken.cheststorage.inventoryholders.ContainerHolderDefultchest
	 */

	int countItemStacks(final ItemStack[] itemStacks);

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
	Inventory getInventory(final int page);

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
	@Nullable
	Inventory loadInventory();

	/**
	 * Create inventory if not exist and add items if
	 * the gui has items before.
	 *
	 * @param player some open inventory.
	 * @return inventory if player is not null.
	 */
	@Nullable
	Inventory loadInventory(final Player player);

	/**
	 * Set inventory in cache, return false if {@link #getInventorys()}
	 * exist and amount of pages is same as amount stored in the list.
	 *
	 * @param type of inventory.
	 * @return return true if it have created inventorys.
	 */
	boolean setInventory(final InventoryType type);

	/**
	 * Set new page if it not exist.
	 *
	 * @param type  set type of inventory or null if
	 *              you want chest gui with size.
	 * @param size  size of the inventory.
	 * @param title The description of the gui
	 * @return return array of invetorys.
	 */
	void setPagesInCache(final InventoryType type, final int size, final String title);

	/**
	 * Create an inventory for containers.
	 *
	 * @param inventoryType Set type of container like chest or hopper
	 *                      set it to null to generate chest gui with size.
	 * @param title         set the title on the gui some be created.
	 * @param inventorySize set inventory size, as defult it will take settings from containers yml files.
	 * @return A inventory with your settings.
	 * @deprecated minecraft not use Strings, but Component to set text (I use this method to set titles {@link #updateInventoryTitle}).
	 * <p> Use {@link InventoryHolder#createInventory(InventoryType, Component, Integer)}
	 */
	@Deprecated()
	Inventory createInventory(final InventoryType inventoryType, final String title, final Integer inventorySize);

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

	Inventory createInventory(final InventoryType inventoryType, final Component title, final Integer inventorySize);

	/**
	 * check if inventory exist for a container.
	 *
	 * @param inventory of the container
	 * @return true if it exist.
	 */

	boolean containsClickedInventory(final Inventory inventory);


	/**
	 * When you break container it collect all pages of items
	 * and drop it on the ground.
	 *
	 * @return return true after it has finished.
	 */
	boolean dropItemsOnBlockBreak();

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

	void dropItemsOnGround(final ItemStack itemStack);

	/**
	 * Check if the item can be placeded inside the chest.
	 *
	 * @param itemStack the items some hopper or player try to add.
	 * @return true if you can place items inside.
	 */
	boolean canPlaceItemInsideContainer(final ItemStack itemStack);

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
	void setPlayerViwePage(final Player player, final int pageNumber);

	/**
	 * Get what page a player curently has open
	 * (will not say if he has the inventory open or not).
	 *
	 * @param player get the player some open the gui.
	 */

	int getPlayerViwePage(final Player player);

	/**
	 * Method to see if cache are empty.
	 *
	 * @param player check if the cache are empty.
	 * @return true if player exist.
	 */
	boolean isPlayerViwePageEmpty(final Player player);

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
	void removePlayerViwePage(final Player player);


	/**
	 * Update data if new data added whern the plugin runing or if it not exist.
	 *
	 * @param location of the container
	 * @param player   the player some open the container.
	 */
	void updateData(final Location location, final Player player);

	/**
	 * Update the inventory title for container, it take the tittle
	 * from the yml file.
	 *
	 * @param amounts amount of items in BigInteger value.
	 * @param cursor  items added to the chest (can be set to null).
	 */

	void updateInventoryTitle(final BigInteger amounts, final ItemStack cursor);

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
	int getViewersAmount(final int page);

	/**
	 * Get wivers of inventory.
	 *
	 * @param inventory inventory you want to check.
	 * @return amount of current viwers or -1 if inventory is null.
	 */
	int getViewersAmount(final Inventory inventory);

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
	 * Used when player try open container and this will be trigged.
	 *
	 * @param event      some are used to open container.
	 * @param player     player some open container.
	 * @param pageNumber witch page player shall open (if the container have pages).
	 * @return true if it could open container.
	 */

	boolean openContainer(@NotNull final PlayerInteractEvent event, @NotNull final Player player, final int pageNumber);

	/**
	 * When player interact with other container. For example link container
	 * to x amount of other containers.
	 *
	 * @param event         some are used to track the clicked block.
	 * @param linkingPlayer the player some clicking.
	 * @return true if shall cancel event.
	 */
	boolean onContainerLinking(@NotNull final PlayerInteractEvent event, @NotNull final Player linkingPlayer);

	/**
	 * Handle inventory clickevent. For ether when player add/remove items
	 * or change page. To see how it is set up for Storage Unit and rest of
	 * the chest use the defult one in see also.
	 *
	 * @param inventoryClick the event some get trigged.
	 * @param player         player some interact with the chest.
	 * @return if this return true, so can't player/players take item/items from the clicked inventory.
	 * @see InventoryholderStorageUnit#onClickingInsideGui(InventoryClickEvent, Player)
	 * @see InventoryholderDefultContiners#onClickingInsideGui(InventoryClickEvent, Player)
	 */
	boolean onClickingInsideGui(@NotNull final InventoryClickEvent inventoryClick, @NotNull final Player player);

	/**
	 * When you break the continer this will be called, i remove all cached data
	 * and depending on settings I set it on the item or the data get lost (only data
	 * some are needed for place it again is keeped).
	 *
	 * @param player some break the container.
	 * @param block  some get removed.
	 * @return true if it shall cancel the event.
	 */
	boolean onContainerBreak(@NotNull final Player player, @NotNull final Block block);

	/**
	 * When player close inventory.
	 *
	 * @param player some close the inventory.
	 * @return true if valid container some get closed.
	 */
	boolean onContainerClose(@NotNull final Player player);

	/**
	 * When you place the continer this will get trigged after
	 * the task is running, so you can't cancel the
	 * placement of the container.
	 *
	 * @param player    some place the container.
	 * @param container some get placed.
	 * @return true if it has successful executed the task.
	 */
	boolean onContainerPlace(@NotNull final Player player, @NotNull final ItemStack container);

	/**
	 * When container pick up items. This get trigged when item end up ontop of a hopper or hopper minecart.
	 *
	 * @param event the event some used when container pick up items.
	 * @return true if you want to cancel event.
	 */
	boolean onPickupItem(InventoryPickupItemEvent event);


	/**
	 * When container move items between containers. This get trigged when item get moved.
	 *
	 * @param event    the event some used when container move items between containers.
	 * @param pushItem true if you push item to custom continer or false drag/pull items from container.
	 * @return true if you want to cancel event.
	 */
	boolean onMoveItem(InventoryMoveItemEvent event, boolean pushItem);

	/*
	 * ################################################
	 * when run a task.
	 */

	/**
	 * Get the time when run the task
	 *
	 * @return time in ticks
	 */
	long getTimeRunTask();

	void setTimeRunTask(long timeRunTask);

	/**
	 * When run a task. You can set how often this will be called with
	 * {@link #setTimeRunTask(long)}.
	 *
	 * @return true if you want to run task or false and it will remove the location from list.
	 */
	boolean onRunTask();
	/*
	 * ################################################
	 * Data handle methods.
	 */

	/**
	 * Use this method to save the contents to {@link ContainerData} cache.
	 */
	void saveToCache();

	/**
	 * Get containerdata.
	 *
	 * @return the data for the container.
	 */
	ContainerData getContainerData();

	/**
	 * Set containerdata for this container.
	 */
	void setContainerData(@NotNull final ContainerData containerData);
}


