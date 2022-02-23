package org.brokenarrow.storage.api.runnable;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

public interface HologramsTaskAPI extends AddOrRemoveDataFromListAPI {

	void runTask();

	/**
	 * Spawn or update hologram.
	 *
	 * @param location location of the container.
	 * @param holoText list of text you want to set on the hologram.
	 */
	void hologramsupdate(Location location, String... holoText);

	/**
	 * Spawn or update hologram.
	 *
	 * @param location      location of the container.
	 * @param offlinePlayer some you can use for placeholderAPI.
	 * @param holoText      list of text you want to set on the hologram.
	 */
	void hologramsupdate(Location location, OfflinePlayer offlinePlayer, String... holoText);
}
