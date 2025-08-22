package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.Crafting.util.MessageSenderApi;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
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
	 * Use this to tell how every executed task data shall be sent to the player.
	 * <p>
	 * For selling or crafting is this used to tell the item type and either amount
	 * of money you get or items crafted of one item type. So it will create new chat
	 * line for every item type. You can set header and footer inside {@link TaskExecutedCacheApi#sendHeaderMessage(TypeOfTask, Player, MessageSenderApi)}  and
	 * {@link TaskExecutedCacheApi#sendFooterMessage(TypeOfTask, Player, MessageSenderApi)}
	 */
	void sendBodyMessage(@Nonnull final Player player, @Nonnull final MessageSenderApi sender);

}
