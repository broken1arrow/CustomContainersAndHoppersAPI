package org.brokenarrow.storage.api.stats;

import org.brokenarrow.storage.api.craftselltask.TaskProvider;

import javax.annotation.Nonnull;

/**
 * Represents aggregated statistics for a specific type of task.
 * <p>
 * Implementations accumulate data from one or more executed tasks
 * (for example, crafting or selling) and expose both incremental
 * updates and summarized totals.
 */
public interface Stats {

    /**
     * Updates this statistics object using data from a completed task.
     *
     * @param data   the task data provider containing contextual information
     *               (for example, produced items or task-specific metadata)
     * @param amount the number of items affected by the task
     *               (such as items crafted or sold)
     */
    void updateFrom(@Nonnull final TaskProvider data, final int amount);

    /**
     * Returns the total number of items affected by all processed tasks.
     *
     * @return the total item amount
     */
    int getTotalAmount();

    /**
     * Creates a defensive copy of this statistics instance.
     *
     * @return a copy of this stats object
     */
    Stats copy();
}
