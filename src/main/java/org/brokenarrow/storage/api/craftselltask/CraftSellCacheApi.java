package org.brokenarrow.storage.api.craftselltask;

import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.UUID;

/**
 * A per-player cache that temporarily stores logs/results of crafting
 * and selling tasks.
 * <p>
 * Each entry is identified by a {@link CraftSellMapKey} (location + material),
 * and contains a {@link CraftSellDataApi} with details about the task.
 * Data in this cache is short-lived and typically cleared after being processed
 * or shown to the player.
 */
public interface CraftSellCacheApi {

    /**
     * Retrieve the players UUID.
     * @return the UUID.
     */
    UUID getUniqueId();

    /**
     * Returns all cached task results for this player.
     *
     * @return a map of {@link CraftSellMapKey} to {@link CraftSellDataApi},
     *         representing the current cached logs
     */
    Map<CraftSellMapKey, CraftSellDataApi> getTaskResults();

    /**
     * Retrieves a cached task result for a specific key.
     *
     * @param craftSellMapKey the key identifying the cached task
     * @return the {@link CraftSellDataApi} instance, or {@code null}
     *         if no entry exists for the given key
     */
    @Nullable
    CraftSellDataApi getTaskResult(final CraftSellMapKey craftSellMapKey);

    /**
     * Adds or updates a cached task result.
     * <p>
     * If a result already exists for the given key, it will be replaced.
     *
     * @param craftSellKey   the key associated with the task
     * @param craftSellData  the data to store
     */
    void putTaskResult(final CraftSellMapKey craftSellKey, @Nonnull final  CraftSellDataApi craftSellData);

    /**
     * Removes a cached task result for the given key, if present.
     *
     * @param craftSellKey the key of the result to remove
     */
    void removeTaskResult(final CraftSellMapKey craftSellKey);

    /**
     * Clears all cached crafting and selling logs for this player.
     */
    void clearTaskResults();

}
