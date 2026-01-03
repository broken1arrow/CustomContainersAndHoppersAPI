package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.brokenarrow.storage.api.stats.Stats;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.UUID;

/**
 * A per-player container that temporarily stores results of executed tasks.
 * <p>
 * Each entry is identified by a {@link TaskCacheKey} (e.g., location + material)
 * and contains a {@link TaskDataApi} with details about the task execution.
 * Data in this cache is short-lived and is typically cleared after being processed
 * or sent back to the player.
 * <p>
 *
 * @param <D> the type of task data stored in the cache
 * @param <S> the type of statistics associated with tasks
 */
public interface TaskExecutedCacheApi<D extends TaskDataApi, S extends Stats> {

    /**
     * Returns the unique identifier of the player that owns or placed this container.
     *
     * @return the player's UUID
     */
    UUID getUniqueId();

    /**
     * Returns all cached task results for this container.
     *
     * @return a map of {@link TaskCacheKey} to {@link D} representing the current cached tasks.
     */
    Map<TaskCacheKey, D> getTaskResults();

    /**
     * Retrieves a cached task result for a specific key.
     *
     * @param key the key identifying the cached task
     * @return the task data {@link D}, or {@code null} if no entry exists for the given key
     */
    @Nullable D getTaskResult(@Nonnull final TaskCacheKey key);

    /**
     * Adds or updates a cached task result.
     * <p>
     * If no statistics exist yet for the task type of the given data,
     * the provided {@code newStats} instance will be used.
     * <p>
     * To explicitly replace existing statistics for a task type,
     * use {@link #setStat(TypeOfTask, Stats)}.
     *
     * @param key      the key associated with the task
     * @param newStats the statistics instance to use if no stats are currently present
     *                 for the task type
     * @param data     the task data to store
     * @param amount   the amount produced by the task
     * @throws NullPointerException if any required argument is {@code null}
     */
    void putTaskResult(@Nonnull final TaskCacheKey key,@Nonnull final Stats newStats, @Nonnull final D data, final int amount);

    /**
     * Returns a map of all statistics for this container,
     * grouped by {@link TypeOfTask}.
     *
     * @return a map of task type to corresponding statistics
     */
    Map<TypeOfTask, S> getStats();

    /**
     * Retrieves the statistics for a specific task type.
     *
     * @param taskType the type of task
     * @return the statistics for the given task type
     */
    S getStat(@Nonnull TypeOfTask taskType);

    /**
     * Updates the statistics for a specific task type.
     *
     * @param taskType the type of task
     * @param stats    the updated statistics
     * @return the updated statistics
     */
    S setStat(@Nonnull TypeOfTask taskType, @Nonnull S stats);

    /**
     * Updates the statistics from a given task data object.
     * <p>
     * Typically called after a task is executed to record progress or results.
     *
     * @param craftSellData the task data used to update statistics
     * @param newStats the statistics instance to use if no stats are currently present
     *                 for the task type.
     * @param amount   the amount produced by the task
     */
    void updateStatFromData(@NotNull TaskDataApi craftSellData, @Nullable final Stats newStats, final int amount);

    /**
     * Removes a cached task result for the given key, if present.
     *
     * @param key the key of the task result to remove
     */
    void removeTaskResult(final TaskCacheKey key);

    /**
     * Clears all cached task results for this container.
     */
    void clearTaskResults();

}
