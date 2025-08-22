package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.brokenarrow.storage.api.stats.Stats;
import org.bukkit.Location;
import org.bukkit.Material;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;

/**
 * Data provided when either sell or craft items and also the tasks
 * to sell and craft from a InventoryHolder is provided.
 */
public interface CraftingSellTaskAPI {

    /**
     * The task for craft all items some match ingredients and added recipes in the container.
     *
     * @param inventoryHolder the inventory holder to get all data for this container.
     */
    void craftingTask(@NotNull final InventoryHolder inventoryHolder);

    /**
     * The task for sale all items in container.
     *
     * @param inventoryHolder the inventory holder to get all data for this container.
     */
    void sellTask(@NotNull final InventoryHolder inventoryHolder);

    /**
     * Get if it has finish crafting one item.
     *
     * @return true if it has finish craft one item.
     */
    boolean isFinishCrafting();

    /**
     * Returns all currently cached crafting and selling data for players.
     * <p>
     * The cache is cleared once the player has received their corresponding message.
     *
     * @return a map of player UUIDs to their cached task data
     */
    Map<UUID, TaskExecutedCacheApi<TaskDataApi, Stats>>  getLoggedCraftSellTasks();

    /**
     * Retrieves the entire cache of crafting and selling tasks for a player.
     *
     * @param uuid the player whose cache should be retrieved
     * @return the {@link TaskExecutedCacheApi} for the player,
     *         or {@code null} if none exists
     */
    @Nullable
    TaskExecutedCacheApi<TaskDataApi, Stats> getLoggedCraftSellTask(@Nonnull UUID uuid);

    /**
     * Retrieves the cached task data for a specific crafting or selling container.
     *
     * @param uuid     the player associated with the task
     * @param location the location of the container
     * @param material the output material when crafting, or the item sold
     * @return the {@link TaskDataApi} for the container, or {@code null} if none exists
     */
    @Nullable
    TaskDataApi getLoggedCraftSellTask(@Nonnull final UUID uuid, @Nonnull final Location location, @Nonnull final Material material);

    /**
     * Checks whether any task exists in the cache for the given location.
     * <p>
     * This method iterates over all cached tasks and their keys, which may be
     * computationally expensive. It is recommended not to call this method too
     * frequently in performance-critical sections. Use
     * {@link #isLoggedCraftSellTask(UUID, Location)} or
     * {@link #getLoggedCraftSellTask(UUID, Location, Material)}.
     *
     * @param location the location to check against cached tasks
     * @return {@code true} if a task is cached for the given location, otherwise {@code false}
     */
    boolean isLoggedCraftSellTask(@NotNull Location location);

    /**
     * Checks whether a task exists in the cache for the given player and location.
     *
     * @param uuid     the player associated with the task
     * @param location the location of the container
     * @return {@code true} if a task is cached for the given player and location, otherwise {@code false}
     */
    boolean isLoggedCraftSellTask(@Nonnull final UUID uuid, @NotNull Location location);

    /**
     * Adds or updates a crafting or selling task in the log cache.
     * <p>
     * If a task already exists for the same player, location, and material,
     * it will be replaced with the new data.
     * <p>
     * Tasks are grouped per player (by UUID), so each player maintains their
     * own set of logged tasks independently.
     *
     * @param uuid          the player associated with the task
     * @param location      the location of the container
     * @param material      the output material when crafting, or the item sold
     * @param craftSellData the task data to store in the cache
     */
    void putLoggedCraftSellTask(@Nonnull final UUID uuid, @NonNull Location location, @NonNull Material material, @NonNull TaskDataApi craftSellData);


    /**
     * Clear the players sell or crafting data from cache.
     *
     * @param uuid the player associated with the sell or crafting task done.
     */
    void removeLoggedCraftSellTask(@Nonnull UUID uuid);

    /**
     * Remove the sell or crafting data for the task.
     *
     * @param uuid     the player associated with the sell or crafting task done.
     * @param location location of the container.
     * @param material the material output when crafted or sold.
     */
    void removeLoggedCraftSellTask(@Nonnull UUID uuid, @Nonnull Location location, @Nonnull Material material);


}
