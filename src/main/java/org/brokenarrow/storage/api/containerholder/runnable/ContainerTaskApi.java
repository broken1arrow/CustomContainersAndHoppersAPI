package org.brokenarrow.storage.api.containerholder.runnable;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * This class are for when you want to add location to your container or set to fast mode.
 * The {@link #runTask()} method will invoke this method {@link InventoryHolder#onRunTask()} if
 * chunk is loaded and the time has count down.
 * <p>
 * You can also turn on fast Mode, it will then try to run every tick (but that will quickly cause lag
 * if you have over 800 location stored in this cache). The default mode it will run every second and I not see
 * any reason why you want to run faster.
 */

public interface ContainerTaskApi {

    /**
     * Run the containers tasks, and it will also make sure the chunk is loaded.
     */
    void runTask();

    /**
     * Retrieve If it should run so fast as it could.
     *
     * @return if this is set to true it will run the task so fast as it could.
     */
    boolean isFastMode();

    /**
     * Set if it should run the task every tick, no mater what.
     *
     * @param fastMode set to true if it should ignore the performance impact.
     */
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