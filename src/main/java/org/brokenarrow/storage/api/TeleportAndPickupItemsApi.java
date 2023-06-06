package org.brokenarrow.storage.api;

import org.brokenarrow.storage.api.containerholders.InventoryHolder;
import org.brokenarrow.storage.api.util.builderclass.TeleportWraper;
import org.brokenarrow.storage.api.util.builderclass.TeleportWraper.Builder;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public interface TeleportAndPickupItemsApi {


	/**
	 * Build data you want to set in cache.
	 * This method do NOT set data i cache, only help method.
	 *
	 * @param builder the build you want to set.
	 * @return teleportWraper with your data set.
	 */
	@Nonnull
	TeleportWraper buildData(@Nonnull final Builder builder);

	/**
	 * Use this method to start teleport or suction task.
	 * It will take the settings from the container yml file to
	 * see if it has option to pick up and teleport items.
	 *
	 * @param holder the inventory holder to get all data for this container.
	 */
	void linkedContainerTask(@Nonnull final InventoryHolder holder);

	/**
	 * Remove all linked containers inventorys and locations from cache.
	 */
	void removeAllCachedLinkContainerInventorys();


	/**
	 * Save data to cache.
	 *
	 * @param builder the build you want to set.
	 */
	void saveToCache(@Nonnull final Builder builder);

	/**
	 * Save data to cache.
	 *
	 * @param teleportWraper data you want to set to cache.
	 */
	void saveToCache(@Nonnull final TeleportWraper teleportWraper);

	/**
	 * Remove the Suction/link container´s inventory from cache.
	 */
	void removeCachedContainerInventory();

	/**
	 * Add linked containers inventorys and locations to cache.
	 *
	 * This is treadsafe method to use.
	 *
	 * @param linkedTo the location you want to add to the link and suction container.
	 */
	void addCachedLinkedContainerInventory(@Nonnull final Location linkedTo);

	/**
	 * Remove linked containers inventorys and locations from cache.
	 *
	 * This is treadsafe method to use.
	 *
	 * @param linkedTo the location you want to remove from the link and suction container.
	 */
	void removeCachedLinkedContainerInventory(@Nonnull final Location linkedTo);

	/**
	 * Set teleport wraper to null and you need set new one, you can use this method to set new teleport wraper
	 * use @link {@link #saveToCache(org.brokenarrow.storage.api.util.builderclass.TeleportWraper)}.
	 * <p>
	 * Or you can also use {@link #linkedContainerTask(org.brokenarrow.storage.api.containerholders.InventoryHolder)} if you want to
	 * run suction and teleport task, it will set new teleport wraper if it is null.
	 *
	 * This is treadsafe method to use.
	 */
	void clearTeleportWraper();

	/**
	 * Get the map of stored inventorys on location. Is a snapshot of inventory/inventory`s
	 * on the containers you has link from your hopper/chest or barrel. Is use less resources
	 * when you cache it insted of call getState() all the time.
	 * <p>
	 * Keep in main this is only temporary snapshot, if chunk this container are located to get unloaded
	 * you has to replace with new snapshot of the inventory.
	 *
	 * This is not a treadsafe map.
	 *
	 * @return map with all cached data of current stored location with snapshot of inventory.
	 */
	@Nullable
	Map<Location, Inventory> getCachedLinkedInventorys();

	/**
	 * Get all data cached for the link and suction container.
	 *
	 * @return the teleport wraper, if it set.
	 */
	@Nullable
	TeleportWraper getTeleportWraper();

	/**
	 * Get the number of location it will process next, in the array for the containers some are linked
	 * to Suction/link container.
	 *
	 * @return the number it will process next or -1 if it are null.
	 */
	int getNumberInList();

	/**
	 * Get if items has successfully teleported items to container.
	 *
	 * @return true if the item has bee moved.
	 */
	boolean isTeleportedItems();

	/**
	 * Get if this container is added to cache.
	 *
	 * @return true if the container exist.
	 */
	boolean isLocationInCache();

}
