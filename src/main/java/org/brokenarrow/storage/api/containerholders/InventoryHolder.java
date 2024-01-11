package org.brokenarrow.storage.api.containerholders;

import org.brokenarrow.storage.api.builders.ContainerDataApi;
import org.brokenarrow.storage.api.builders.ContainerLevelSettingsApi;
import org.brokenarrow.storage.api.builders.ContainerSettingsApi;
import org.brokenarrow.storage.api.builders.ContainerSettingsWrapperAPI;
import org.brokenarrow.storage.api.builders.particle.ParticleEffectUtility;
import org.brokenarrow.storage.api.containerholders.util.TypeOfContainer;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface InventoryHolder extends InventoryEvents {

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
	 * <p>
	 * For the StorageUnit this will return different type of array because
	 * it not stores items inside the inventory. See {@link  InventoryholderStorageUnit#getContents()}
	 *
	 * @return items from curent gui you close, will save all pages.
	 */
	@Nonnull
	ItemStack[] getContents();

	/**
	 * Add items to the chest and change page if first is full.
	 * If chest are full it will return the items some not fit.
	 *
	 * @param itemStacks items hopper try to add
	 * @return items some not fit in the gui.
	 * @see InventoryholderStorageUnit
	 */
	@Nonnull
	Map<Integer, ItemStack> addItems(final ItemStack... itemStacks);

	/**
	 * Set items in the container. It will override all old items
	 * you have stored inside the container.
	 * <p>
	 * If this container have more pages it will automatic add items when
	 * first inventory is full (it will also respect empty slots).
	 *
	 * @param itemStacks items you want to set.
	 */
	void setContents(final ItemStack[] itemStacks);

	/**
	 * Get a Inventory for a container. Will return first
	 * page always.
	 *
	 * @return return first inventory or null if it not contains any inventorys.
	 */
	Inventory getInventory();


	/**
	 * Get size some are set inside yml file.
	 *
	 * @return return int value of inventory size.
	 */
	int getSize();

	/**
	 * Get the title on the container.
	 *
	 * @return title on the container.
	 */
	String getTitle();
	/*
	 * ##########################################
	 * Custom methods to container.
	 */

	/**
	 * Get a Inventory for a container. Type what page you want to get.
	 *
	 * @param page of the inventory.
	 * @return return inventory you has requested
	 * or null if it not find the inventory.
	 */
	@javax.annotation.Nullable
	Inventory getInventory(final int page);

	/**
	 * Get a Inventory for a container.
	 *
	 * @return return inventoy on location you has requested
	 * or null if it not find the gui.
	 */
	List<Inventory> getInventorys();

	/**
	 * Check if it has loaded inventorys contents.
	 *
	 * @return true if it has loaded items to container.
	 */
	boolean isLoadedInventory();


	/**
	 * If it has set max amount if pages/inventorys fir this container.
	 *
	 * @param numberOfPages Check if it set x amount of pages.
	 * @return true if it has set max amount of pages.
	 */
	boolean hasSetMaxInventorys(int numberOfPages);


	/**
	 * Create an inventory for containers.
	 *
	 * @param inventoryType Set type of container like chest or hopper
	 *                      set it to null to generate chest gui with size.
	 * @param title         set the title on the gui some be created.
	 * @param inventorySize set inventory size, as defult it will take settings from containers yml files.
	 * @return A inventory with your settings.
	 * @deprecated minecraft not use Strings, but Component to set text (I use this method to set titles {@link #updateTitle}).
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
	 * @return number of players viwe the page.
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
	 * Get players currently wivers the curent inventory.
	 *
	 * @return map with players and the page they are on.
	 */
	Map<UUID, Integer> getWivers();


	/**
	 * Remove player from cache.
	 *
	 * @param player remove the players cache data for page.
	 */
	void removePlayerViwePage(final Player player);

	/**
	 * Override this method if you want to reset data,
	 * when they run the reload command.
	 */
	void reloadContainer();

	/**
	 * Update data if new data added when the plugin runing or if it not exist.
	 *
	 * @param player the player some open the container.
	 */
	void updateData(final Player player);

	/**
	 * Update the inventory title for container, it will update all
	 * currently viewers of the inventory.
	 *
	 * @param title you want to set on container.
	 * @param page  current page player open.
	 */
	void updateTitle(String title, int page);

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
	 * Get container location inventory/inventory´s are linked to.
	 *
	 * @return cloned location of this container.
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
	OfflinePlayer getOfflineOwner();

	/**
	 * Get the owner of the container.
	 *
	 * @return owner´s UUID.
	 */
	UUID getOwner();

	/**
	 * Get the time when run the task
	 *
	 * @return time in ticks
	 */
	long getTimeRunTask();

	/**
	 * Set time in ticks when run a task.
	 *
	 * @param timeRunTask time in ticks when run task.
	 */
	void setTimeRunTask(long timeRunTask);

	/**
	 * When player open inventory, will check if inventory is null or not.
	 *
	 * @param player    the player some open inventory.
	 * @param inventory the inventory to open.
	 */
	void openInventory(@Nonnull Player player, @Nullable Inventory inventory);

	/**
	 * Sound when close container.
	 *
	 * @return sound or null.
	 */
	@Nullable
	Sound getSoundWhenClose();

	/**
	 * Sound when upen container.
	 *
	 * @return sound or null.
	 */
	@Nullable
	Sound getSoundWhenOpen();

	/**
	 * Sound when run task on container.
	 *
	 * @return sound or null.
	 */
	@Nullable
	Sound getSoundWhenRunTask();

	/**
	 * Effect when run task on container.
	 *
	 * @return particle or null.
	 */
	@Nullable
	ParticleEffectUtility<?> getEffectWhenRunTask();

	/**
	 * When run a task. You can set how often this will be called with
	 * {@link #setTimeRunTask(long)}.
	 *
	 * @return true if you want to run task or false and it will remove the location from list.
	 */
	boolean onRunTask();

	/**
	 * Get amount of pages.
	 *
	 * @return amnount of pages.
	 */
	int getCurrentAmountOfPages();

	boolean isFirstCheckOfPlaceholderItem();

	void setFirstCheckOfPlaceholderItem(final boolean firstCheckOfPlaceholderItem);

	/*
	 * ################################################
	 * Data handle methods.
	 */

	/**
	 * Use this method to save the contents to {@link ContainerDataApi} cache.
	 */
	void saveToCache();

	/**
	 * Get containerdata.
	 *
	 * @return the data for the container.
	 */
	@Nonnull
	ContainerDataApi getContainerData();


	/**
	 * Set containerdata for this container.
	 *
	 * @param containerData The container data you want to set on this container.
	 */
	void setContainerData(@Nonnull final ContainerDataApi containerData);

	/*
	 * ################################################
	 * Get static settings for the container type.
	 */

	/**
	 * Get all set data for this container type, from the yaml file.
	 *
	 * @return the wrapper used to set both serttings and
	 * the level upgrades for the container.
	 */
	@Nonnull
	ContainerSettingsWrapperAPI getSettingsWrapper();

	/**
	 * Get the current level of settings for this container.
	 *
	 * @return The current level specific settings for the container.
	 */
	@Nullable
	ContainerLevelSettingsApi getLevelSettings();

	/**
	 * Get the settings for a specific level for this container.
	 *
	 * @param level The level you want to check the settings for.
	 * @return The settings for the level or null if level settings
	 * are not set or the level not exist.
	 */
	@Nullable
	ContainerLevelSettingsApi getLevelSettings(@Nonnull String level);

	/**
	 * Get the static settings, some not change with the level
	 * of the container.
	 *
	 * @return The set settings for the container. Will return null
	 * if could not find the settings for this container.
	 */
	@Nullable
	ContainerSettingsApi getSettings();

}


