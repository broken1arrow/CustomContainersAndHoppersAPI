package org.brokenarrow.storage.api.containerholder.util;

import org.bukkit.Location;

import javax.annotation.Nonnull;

/**
 * Run the task to add items to a container.
 */
public interface AddItemToContainerTaskAPI {

	/**
	 * run the container task
	 */
	void runTask();

	/**
	 * check if it already checks the location.
	 *
	 * @param location the location you want to cech.
	 * @return true if it already check the location.
	 */
	boolean isAlreadyChecked(Location location);

	/**
	 * Add locations it shall sell or craftItems.
	 *
	 * @param location of the continer.
	 */
	void removeOrAddCustomItem(@Nonnull final Location location);

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

	/**
	 * If it shall remove the item inside inventory. It will
	 * remove the placeholder item if the container has matching item.
	 *
	 * @param location of the container.
	 * @param isremoveItem true if the item shall be removed.
	 */
	void removeOrAddCustomItem(@Nonnull final Location location, boolean isremoveItem);

}
