package org.brokenarrow.storage.api;

import org.bukkit.Location;

import javax.annotation.Nonnull;

public interface SpawnContainerEffectsTaskAPI {

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
