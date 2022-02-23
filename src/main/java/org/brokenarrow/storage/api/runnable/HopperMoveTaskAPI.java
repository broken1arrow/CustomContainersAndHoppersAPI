package org.brokenarrow.storage.api.runnable;

import org.bukkit.Location;
import org.bukkit.block.Hopper;

import java.util.Map;

public interface HopperMoveTaskAPI extends AddOrRemoveDataFromListAPI {

	void runTask();

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
	 * Check if this location alredy cache an hopper.
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
	 * Remove cached hopper, becuse it store a snapshot of the block
	 * It need remove the old one when load the chunk after it have
	 * be unloaded.
	 *
	 * @param containerLocation of the container some are placed ontop of the hopper.
	 */
	void removeCachedHoppers(final Location containerLocation);
}