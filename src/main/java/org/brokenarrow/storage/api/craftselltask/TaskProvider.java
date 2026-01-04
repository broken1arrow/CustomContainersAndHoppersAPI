package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.craftselltask.message.MessageCollectorApi;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * Provides access to the result/output of a task execution.
 * <p>
 * For example:
 * <ul>
 *   <li>In a crafting task, this would be the crafted item.</li>
 *   <li>In a selling task, this would be the item that was sold.</li>
 * </ul>
 */
public interface TaskProvider {

	/**
	 * Get the output item produced by this task, if any.
	 *
	 * @return the resulting {@link ItemStack}, or {@code null}
	 *         if the task did not produce a tangible item
	 */
	@Nullable
	ItemStack getItemStack();

    /**
     * Defines a body message entry for this task execution.
     * <p>
     * Each executed task contributes exactly one body entry, describing the
     * outcome of that specific task (for example, items crafted or sold).
     * <p>
     * This method should not send messages directly. Instead, it registers a
     * message key and placeholder values with the provided
     * {@link MessageCollectorApi}, allowing message resolution and formatting to be
     * handled at a later stage.
     *
     * @param player the player associated with this task execution
     * @param sender the {@link MessageCollectorApi} used to collect message entries
     */
	void sendBodyMessage(@Nonnull final Player player, @Nonnull final MessageCollectorApi sender);

}
