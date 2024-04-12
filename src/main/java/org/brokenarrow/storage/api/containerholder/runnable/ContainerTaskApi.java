package org.brokenarrow.storage.api.containerholder.runnable;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * This class are for when you want to add location to your container
 * and want use this method {@link InventoryHolder#onRunTask()}.
 * <p>
 * You can also turn on fast Mode, it will then try run every tick (but that will quickly cuse lag
 * if you has over 800 location stored in this cache). The defult mode it will run every second and I not see
 * any reason why you want to run faster.
 */

public interface ContainerTaskApi {

	void runTask();

	boolean isFastMode();

	void setFastMode(final boolean fastMode);

	/**
	 * Get the size of the list.
	 *
	 * @return amount of containers cached.
	 */

	int getLocationsListSize();

	/**
	 * Check if list contains location.
	 *
	 * @param location of the continer.
	 * @return true if the list contains the container
	 */
	boolean isLocationInList(final Location location);

	/**
	 * Remove location from the list.
	 *
	 * @param location of the container you want to remove.
	 */
	void removeLocationInList(final @NonNull Location location);


	/**
	 * Add locations to the containerTask cache.This method should be threadsafe
	 * to use even asynchronous. After you add the location, it can take
	 * several ticks before it get added to cache.
	 *
	 * @param location of the continer.
	 */
	void addLocationInList(final @NonNull Location location);

}