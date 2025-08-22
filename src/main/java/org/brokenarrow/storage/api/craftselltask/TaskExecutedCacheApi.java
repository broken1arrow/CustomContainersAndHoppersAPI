package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.craftselltask.message.MessageSenderApi;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.brokenarrow.storage.api.stats.Stats;
import org.bukkit.entity.Player;
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
     * If a result already exists for the given key, it will be replaced.
     *
     * @param key  the key associated with the task
     * @param data the task data to store
     */
    void putTaskResult(@Nonnull final TaskCacheKey key, @Nonnull final D data);

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
    S updateStat(@Nonnull TypeOfTask taskType, @Nonnull S stats);

    /**
     * Updates the statistics from a given task data object.
     * <p>
     * Typically called after a task is executed to record progress or results.
     *
     * @param data the task data used to update statistics
     */
    void updateStatFromData(@NotNull D data);

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

    /**
     * Sends the header for a multi-line message to the player.
     * <p>
     * The header is sent once per {@link TypeOfTask} and is typically used to
     * provide context for the following body messages, such as a title or timestamp.
     *
     * @param taskType the type of task (e.g., crafting or selling) this header belongs to
     * @param player   the player who will receive the message
     * @param sender   the {@link MessageSenderApi} used to assemble and send the message
     */
    void sendHeaderMessage(@Nonnull TypeOfTask taskType, @NotNull Player player, @NotNull MessageSenderApi sender);

    /**
     * Sends the footer for a multi-line message to the player.
     * <p>
     * The footer is sent once per {@link TypeOfTask} and is typically used to
     * summarize the results of the executed tasks, such as totals or earnings.
     *
     * @param taskType the type of task (e.g., crafting or selling) this footer belongs to
     * @param player   the player who will receive the message
     * @param sender   the {@link MessageSenderApi} used to assemble and send the message
     */
    void sendFooterMessage(@Nonnull TypeOfTask taskType, @NotNull Player player, @NotNull MessageSenderApi sender);


}
