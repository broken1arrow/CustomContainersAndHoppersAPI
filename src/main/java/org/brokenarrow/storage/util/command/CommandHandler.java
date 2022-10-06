package org.brokenarrow.storage.util.command;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public interface CommandHandler {

	/**
	 * Calling while command executed by specified sender. So it can be ether player or other sender.
	 * So check if it is a player before cast it to player.
	 *
	 * @param sender       The command sender but will automatically convert to specified instance
	 * @param commandLabel The command prefix (/cch = cch)
	 * @param cmdArg       The arguments (/cch menu will will open menu)
	 */
	void onCommand(final CommandSender sender, @NotNull final String commandLabel, @NotNull final String[] cmdArg);

	/**
	 * Calling while sender trying to tab-complete/type the command. This method is uesed to to
	 * suggest next part of the command. After first part.
	 *
	 * @param sender       The command sender but will automatically convert to specified instance
	 * @param commandLabel The command prefix (/cch = cch)
	 * @param cmdArg       The arguments (/cch menu [TAB] will open menu)
	 * @return list of command suggestions.
	 */
	@Nullable
	default List<String> onTabComplete(@NotNull final CommandSender sender, @NotNull final String commandLabel, @NotNull final String[] cmdArg) {
		return Collections.emptyList();
	}
}
