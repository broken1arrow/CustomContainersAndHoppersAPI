package org.brokenarrow.storage.api.crafting.stats;

import org.brokenarrow.storage.api.craftselltask.message.MessageCollectorApi;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.brokenarrow.storage.api.stats.Stats;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

/**
 * Provides message-definition logic for aggregated task statistics.
 * <p>
 * A {@code TaskStatsProvider} acts as a lightweight wrapper around a
 * {@link Stats} instance and is responsible for defining header and footer
 * message entries associated with a specific {@link TypeOfTask}.
 * <p>
 * This provider does not own, calculate, or mutate statistics. Instead, it
 * exposes existing aggregated data and contributes message keys and
 * placeholder values to a {@link MessageCollectorApi} for later resolution and
 * formatting.
 * <p>
 * Typical responsibilities include:
 * <ul>
 *   <li>Defining a header message describing task context</li>
 *   <li>Defining a footer message summarizing aggregated results</li>
 * </ul>
 * <p>
 * Message dispatching, formatting, and placeholder resolution are handled
 * outside of this provider.
 */
public interface TaskStatsProvider {

    /**
     * Defines the header message entry for a task message section.
     * <p>
     * This method contributes header-related message data (such as keys and
     * placeholder values) to the current {@link MessageCollectorApi}.
     * <p>
     * The header is typically rendered once per {@link TypeOfTask} and provides
     * contextual information (for example, a title or timestamp) for the
     * following body entries.
     * <p>
     * Implementations may choose to define no header if the underlying stats
     * are not considered valid or meaningful.
     *
     * @param player the player associated with the task execution context
     * @param sender the {@link MessageCollectorApi} used to collect message entries
     */
    void setHeaderMessage(@Nonnull final Player player, @Nonnull final MessageCollectorApi sender);

    /**
     * Defines the footer message entry for a task message section.
     * <p>
     * This method contributes footer-related message data (such as summary totals)
     * to the current {@link MessageCollectorApi}.
     * <p>
     * The footer is typically rendered once per {@link TypeOfTask} and may be
     * used to display aggregated statistics derived from the executed tasks.
     * <p>
     * Implementations may choose to define no footer if the underlying stats
     * are not considered valid or meaningful.
     *
     * @param player the player associated with the task execution context
     * @param sender the {@link MessageCollectorApi} used to collect message entries
     */
    void setFooterMessage(@Nonnull final Player player, @Nonnull final MessageCollectorApi sender);

    /**
     * Returns the statistics backing this provider.
     *
     * @return the stats associated with this task type
     */
    @Nonnull
    Stats getStats();

    /**
     * Creates a copy of this stats provider with an independent copy of its
     * underlying stats.
     * <p>
     * This is typically used to avoid shared mutable state when task message
     * sections are processed or rendered independently.
     *
     * @return a copy of this {@link TaskStatsProvider}
     */
    @Nonnull
    TaskStatsProvider copy();
}
