package org.brokenarrow.storage.api;

import org.bukkit.Location;

import javax.annotation.Nonnull;

/**
 * Interface for handle the surrounding logic to add och remove the effects at the specific location to cache.
 */
public interface SpawnContainerEffectsTaskAPI {
	/**
	 * To run the effect task .
	 */
	void runTask();

	/**
	 * Add locations it shall sell or craftItems.
	 *
	 * @param location of the continer.
	 */
	void addLocationInList(@Nonnull final Location location);

	/**
	 * Check if list contains location.
	 *
	 * @param location of the continer.
	 * @return true if the list contains the container
	 */
	boolean isLocationInList(@Nonnull final Location location);

	/**
	 * Remove location from the list.
	 *
	 * @param location of the container you want to remove.
	 */
	void removeLocationInList(@Nonnull final Location location);
}
