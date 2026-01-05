package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.crafting.stats.TaskStatsProvider;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

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
public interface TaskExecutedCacheApi<D extends TaskDataApi, S extends TaskStatsProvider> {

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
     * the provided {@code statsProvider} instance is stored and used.
     * <p>
     * The supplied callback is invoked with the resolved stats provider,
     * allowing the caller to update task-specific statistics.
     * <p>
     * To explicitly replace existing statistics for a task type,
     * use {@link #setStat(TypeOfTask, TaskStatsProvider)}.
     *
     * @param key the key associated with the task
     * @param taskData the task data to store
     * @param statsProvider the stats provider to use if none exists yet
     *                     for the task type
     * @param callBack callback invoked with the resolved stats provider
     */
    void putTaskResult(@Nonnull final TaskCacheKey key, @Nonnull final D taskData,final @NotNull S statsProvider, @Nonnull final Consumer<S> callBack);

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
     * Resolves the {@link TaskStatsProvider} for the given task type and invokes the
     * supplied callback with it.
     * <p>
     * If no stats provider is currently registered for the task type, the provided
     * {@code taskStatsProvider} is stored and used. This method does not create
     * providers automatically. The caller is responsible for supplying the correct
     * implementation for the task type.
     * <p>
     * To explicitly replace an existing stats provider for a task type,
     * use {@link #setStat(TypeOfTask, TaskStatsProvider)} instead of this method.
     *
     * @param taskType the task type the stats belong to
     * @param taskStatsProvider the stats provider to register if none exists
     * @param callBack the callback invoked with the resolved stats provider
     */
    void getOrCreateStatsProvider(@Nonnull final TypeOfTask taskType, @Nonnull final S taskStatsProvider, @Nonnull final Consumer<S> callBack);

    /**
     * Updates the statistics for a specific task type.
     *
     * @param taskType the type of task
     * @param stats    the updated statistics
     * @return the updated statistics
     */
    S setStat(@Nonnull TypeOfTask taskType, @Nonnull S stats);


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
