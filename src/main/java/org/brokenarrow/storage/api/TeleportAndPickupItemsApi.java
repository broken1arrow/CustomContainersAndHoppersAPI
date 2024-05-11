package org.brokenarrow.storage.api;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.brokenarrow.storage.api.util.builderclass.TeleportWrapper;
import org.brokenarrow.storage.api.util.builderclass.TeleportWrapper.Builder;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * This build data to set in cache when either teleport or pick up items to a container.
 */
public interface TeleportAndPickupItemsApi {

	/**
	 * Build data you want to set in the cache.
	 * This method do NOT set data I cache, only help method.
	 *
	 * @param builder the build you want to set.
	 * @return teleportWrapper with your data set.
	 */
	@Nonnull
	TeleportWrapper buildData(@Nonnull final Builder builder);

	/**
	 * Use this method to start teleport or suction task.
	 * It will take the settings from the container yml file to
	 * see if it has option to pick up and teleport items.
	 *
	 * @param holder the inventory holder to get all data for this container.
	 */
	void linkedContainerTask(@Nonnull final InventoryHolder holder);

	/**
	 * Remove all linked containers inventory's and locations from the cache.
	 */
	void removeAllCachedLinkContainerInventors();


	/**
	 * Save data to cache.
	 *
	 * @param builder the build you want to set.
	 */
	void saveToCache(@Nonnull final Builder builder);

	/**
	 * Save data to cache.
	 *
	 * @param teleportWrapper data you want to set to cache.
	 */
	void saveToCache(@Nonnull final TeleportWrapper teleportWrapper);

	/**
	 * Remove the Suction/link container's inventory from the cache.
	 */
	void removeCachedContainerInventory();

	/**
	 * Add linked containers inventory's and locations to cache.
	 *
	 * This is tread safe method to use.
	 *
	 * @param linkedTo the location you want to add to the link and suction container.
	 */
	void addCachedLinkedContainerInventory(@Nonnull final Location linkedTo);

	/**
	 * Remove linked containers inventory's and locations from the cache.
	 *
	 * This is tread safe method to use.
	 *
	 * @param linkedTo the location you want to remove from the link and suction container.
	 */
	void removeCachedLinkedContainerInventory(@Nonnull final Location linkedTo);

	/**
	 * Set teleport wrapper to null, and you need set new one, you can use this method to set a new teleport wrapper
	 * use @link {@link #saveToCache(org.brokenarrow.storage.api.util.builderclass.TeleportWrapper)}.
	 * <p>
	 * Or you can also use {@link #linkedContainerTask(InventoryHolder)} if you want to
	 * run suction and teleport task, it will set a new teleport wrapper if it is null.
	 *
	 * This is tread safe method to use.
	 */
	void clearTeleportWrapper();

	/**
	 * Get the map of stored inventory's on location. Is a snapshot of inventory/inventory's
	 * on the containers you have linked from your hopper/chest or barrel. Is use less resources
	 * when you cache it instead of call getState() all the time.
	 * <p>
	 * Keep in main this is only temporary snapshot, if chunk this container is located to get unloaded
	 * you have to replace with a new snapshot of the inventory.
	 *
	 * This is not a tread safe map.
	 *
	 * @return map with all cached data of current stored location with a snapshot of inventory.
	 */
	@Nullable
	Map<Location, Inventory> getCachedLinkedInventors();

	/**
	 * Get all data cached for the link and suction container.
	 *
	 * @return the teleport wrapper, if it set.
	 */
	@Nullable
	TeleportWrapper getTeleportWrapper();

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
	 * @return true if the item has been moved.
	 */
	boolean isTeleportedItems();

	/**
	 * Get if this container is added to cache.
	 *
	 * @return true if the container exist.
	 */
	boolean isLocationInCache();

}
