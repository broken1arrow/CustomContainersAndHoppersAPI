package org.brokenarrow.storage.api.stats;

/**
 * Represents aggregated statistics for a specific type of task.
 * <p>
 * Implementations accumulate data from one or more executed tasks
 * (for example, crafting or selling) and expose both incremental
 * updates and summarized totals.
 */
public interface Stats {

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
