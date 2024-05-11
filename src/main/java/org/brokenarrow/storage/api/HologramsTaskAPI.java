package org.brokenarrow.storage.api;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

import javax.annotation.Nonnull;

/**
 * Used to spawn holograms on the container.
 * Provide some basic information you can add.
 */
public interface HologramsTaskAPI  {

	/**
	 * The task to run for spawn the holograms.
	 */
	void runTask();

	/**
	 * Spawn or update hologram.
	 *
	 * @param location location of the container.
	 * @param holoText list of text you want to set on the hologram.
	 */
	void hologramsUpdate(Location location, String... holoText);

	/**
	 * Spawn or update hologram.
	 *
	 * @param location      location of the container.
	 * @param offlinePlayer some you can use for placeholderAPI.
	 * @param holoText      list of text you want to set on the hologram.
	 */
	void hologramsUpdate(Location location, OfflinePlayer offlinePlayer, String... holoText);

	/**
	 * If it should also check if user want holos to spawn and also check if it turn on in settings.
	 *
	 * @param location      location of the container.
	 * @param offlinePlayer some you can use for placeholderAPI.
	 * @param holoText      list of text you want to set on the hologram.
	 */
	void hologramsUpdateWithChecks(Location location, final OfflinePlayer offlinePlayer, final String... holoText);

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
