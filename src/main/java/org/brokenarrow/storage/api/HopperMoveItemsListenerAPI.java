package org.brokenarrow.storage.api;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.util.Map;

public interface HopperMoveItemsListenerAPI {


	/**
	 * Get hoppers some are stored teporary in a cache.
	 * You get all hoppers some try pull items to a
	 * container (Is for suction and/or teleport containers).
	 *
	 * @return map with invewntory on that location.
	 */
	Map<Location, Inventory> getTempCacheHopper();

	/**
	 * Remove hopper on a specific location. Becuse it is a snapshot
	 * of a inventory I have to remove old inventory on chunk load.
	 *
	 * @param containerLocation location if continer some are stored.
	 */
	void removeTempCacheHopper(Location containerLocation);

}
