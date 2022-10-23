package org.brokenarrow.storage.api;

import org.brokenarrow.storage.api.containerholders.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public interface TeleportAndPickupItemsApi {

	/**
	 * Use this method to start teleport or suction task.
	 * It will take the settings from the container yml file to
	 * see if it has option to pick up and teleport items.
	 *
	 * @param holder the inventory holder to get all data for this container.
	 */
	void linkedContainerTask(@NotNull final InventoryHolder holder);

	/**
	 * Remove all linked containers inventorys and locations from cache.
	 *
	 * @param containerLocation location of suction/link container you have link from.
	 */
	void removeCachedLinkedContainerInventory(Location containerLocation);

	/**
	 * Remove linked containers inventorys and locations from cache.
	 *
	 * @param containerLocation location of suction/link container you have link from.
	 * @param linkedTo          location of container you link to.
	 */

	void removeCachedLinkedContainerInventory(Location containerLocation, Location linkedTo);

	/**
	 * Put linked containers inventorys and locations to cache.
	 *
	 * @param containerLocation location of suction/link container you have link from.
	 * @param toInventory       inventory you want to cache.
	 * @param toLocation        location of the inventory you link to.
	 */

	void setCachedLinkedContainer(Location containerLocation, Inventory toInventory, Location toLocation);

	/**
	 * Put Suction/link container´s inventory to cache.
	 *
	 * @param containerLocation  location of suction/link container.
	 * @param containerInventory inventory you want to cache.
	 */
	void setCachedContainerInventory(Location containerLocation, Inventory containerInventory);

	/**
	 * remove Suction/link container´s inventory from cache.
	 *
	 * @param containerLocation location of suction/link container.
	 */

	void removeCachedContainerInventory(Location containerLocation);

	/**
	 * Remove Suction/link container´s from cache. This entity will be removed
	 * from cache.
	 *
	 * @param containerLocation location of suction/link container.
	 */
	void clearCachedContainer(Location containerLocation);

	/**
	 * Put Suction/link container´s next run time for this task.
	 *
	 * @param containerLocation location of suction/link container.
	 * @param delayTime         set time in milliseconds.
	 */

	void setDelayItemPicupTeleportInMilli(Location containerLocation, long delayTime);

	/**
	 * Put Suction/link container´s next run time for this task.
	 *
	 * @param containerLocation location of suction/link container.
	 * @param delayTime         set time in seconds.
	 */

	void setDelayItemPicupTeleportInSeconds(Location containerLocation, long delayTime);

	/**
	 * Set the number of location it will process next.
	 *
	 * @param containerLocation location of suction/link container.
	 * @param numberInList      set the number it shall process next.
	 */

	void setNumberInList(Location containerLocation, int numberInList);


	/**
	 * Set it to true if has sucessfull teleported the item to container.
	 *
	 * @param containerLocation location of suction/link container.
	 */
	void setTeleportedItems(Location containerLocation, boolean telportItems);

	/**
	 * Set amount of containers/inventory it goes thru from 0 to x amount
	 * from locations list in the cache.
	 *
	 * @param containerLocation location of suction/link container.
	 */
	void setAmountLocationsGoThrue(Location containerLocation, int amountOfTimes);

	/**
	 * clear the list of the number of inventories it has to go through.
	 *
	 * @param containerLocation location of suction/link container.
	 */
	void clearAmountLocationsGoThrue(Location containerLocation);

	/**
	 * Get the map of stored inventorys on location. Is a snapshot of inventory/inventory`s
	 * on the containers you has link from your hopper/chest or barrel. Is use less resources
	 * when you cache it insted of call getState() all the time.
	 * <p>
	 * Keep in main this is only temporary snapshot, if chunk this container are located to get unloaded
	 * you has to replace with new snapshot of the inventory.
	 *
	 * @param containerLocation location of suction/link container you have link from.
	 * @return map with all cached data of current stored location with snapshot of inventory.
	 */
	Map<Location, Inventory> getCachedLinkedInventory(Location containerLocation);

	/**
	 * Get your Suction/link container´s inventory on location. Is use less resources
	 * when you cache it insted of call getState() all the time.
	 * <p>
	 * Keep in main this is only temporary snapshot, if chunk this container are located to get unloaded
	 * you has to replace with new snapshot of the inventory.
	 *
	 * @param containerlocation location of suction/link container.
	 * @return a cached snapshot of container inventory.
	 */

	Inventory getCachedContainerInventory(Location containerlocation);

	/**
	 * Get the number of location it will process next, in the array for the containers some are linked
	 * to Suction/link container.
	 *
	 * @param containerLocation location of suction/link container.
	 * @return the number it will process next.
	 */

	int getNumberInList(Location containerLocation);

	/**
	 * Get if items has successfully teleported items to container.
	 *
	 * @param containerLocation location of suction/link container.
	 * @return true if the item has bee moved.
	 */
	boolean isTeleportedItems(Location containerLocation);

	/**
	 * Get if this container is added to cache.
	 *
	 * @param containerLocation location of suction/link container.
	 * @return true if the container exist.
	 */
	boolean isLocationInCache(Location containerLocation);

	/**
	 * Get the amount of inventories it goes thru from 0 to x amount inside the locations list.
	 *
	 * @param containerLocation location of suction/link container.
	 * @return list of amount containers it has to go through.
	 */
	Set<Integer> getAmountLocationsGoThrue(Location containerLocation);

}
