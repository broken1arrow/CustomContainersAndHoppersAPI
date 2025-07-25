package org.brokenarrow.storage.api.runnable;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.block.Hopper;

import java.util.Map;

/**
 * This is for manually move items instead of relaying on a placeholder item
 * inside the container to trigger the move event.
 */
public interface HopperMoveTaskAPI {


	/**
	 * Will go through all containers some has hopes below and move items to a container.
	 */
	void runTask();

	/**
	 * When run the task to manually move items from custom container to hopper below.
	 *
	 * @param holder the InventoryHolder instance to run the task on.
	 */
	void moveItemsToHopperTask(final InventoryHolder holder);

	/**
	 * Get if it's the first start.
	 *
	 * @return true if this has not run yet.
	 */
	boolean isFirstStart();

	/**
	 * Set hopper to cache. This temporary cache hopper and it´s inventory
	 * so you not call get state all the time.
	 *
	 * @param containerLocation of the container you want to store.
	 * @param hopperInv         the inventory of the hopper.
	 */
	void setCachedHoppers(final Location containerLocation, final Hopper hopperInv);

	/**
	 * Check if this location already cache a hopper.
	 *
	 * @param location of the container.
	 * @return true if have cache hopper.
	 */
	boolean isCachedHoppers(final Location location);

	/**
	 * Get all cached hoppers.
	 *
	 * @return map with container locations and cached Hoppers.
	 */
	Map<Location, Hopper> getCachedHoppers();

	/**
	 * Remove cached hopper, because it stores a snapshot of the block
	 * It needs remove the old one when load the chunk after it have
	 * be unloaded.
	 *
	 * @param containerLocation of the container some are placed on top of the hopper.
	 */
	void removeCachedHoppers(final Location containerLocation);


	/**
	 * Add locations it shall sell or craftItems.
	 *
	 * @param location of the container.
	 */
	void addLocationInList(final Location location);

	/**
	 * Check if list contains location.
	 *
	 * @param location of the container.
	 * @return true if the list contains the container
	 */
	boolean isLocationInList(Location location);

	/**
	 * Remove location from the list.
	 *
	 * @param location of the container you want to remove.
	 */
	void removeLocationInList(final Location location);
}
