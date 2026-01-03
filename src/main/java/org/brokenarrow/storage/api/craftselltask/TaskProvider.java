package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.craftselltask.message.MessageSenderApi;
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
	 * Sends the body messages for a multi-line message to the player.
	 * <p>
	 * Each executed task generates a separate body line, describing its results.
	 * For example:
	 * <ul>
	 *   <li>For crafting, this may show the item type and the amount crafted.</li>
	 *   <li>For selling, this may show the item type, amount sold, and earnings.</li>
	 * </ul>

	 * to send the header and footer around these body lines.
	 *
	 * @param player the player who will receive the messages
	 * @param sender the {@link MessageSenderApi} used to assemble and send each line
	 */
	void sendBodyMessage(@Nonnull final Player player, @Nonnull final MessageSenderApi sender);

}
