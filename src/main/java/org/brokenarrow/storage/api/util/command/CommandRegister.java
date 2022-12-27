package org.brokenarrow.storage.api.util.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum CommandRegister {

	INSTANCE();
	/**
	 * Will use synchronized list becuse I allow others to register own commands
	 * and need then make sure the list is thread-safe.
	 */
	private final List<CommandBuilder> commands = Collections.synchronizedList(new ArrayList<>());

	public static CommandRegister getInstance() {
		return INSTANCE;
	}

	/**
	 * Register subcommand use {@link CommandBuilder.Builder} to build your
	 * command. Don't forget you also need create 1 command class for every
	 * sub command.
	 *
	 * @param commandBuilder register your build command.
	 */
	public void registerSubCommand(final CommandBuilder commandBuilder) {
	}

	/**
	 * Unregister your added command. You can't then run the command when is removed.
	 *
	 * @param subLable your command used and it will be unregisted.
	 */

	public void unregisterSubCommand(final String subLable) {
	}

	/**
	 * Get all registed commands.
	 *
	 * @return list of all commands added.
	 */
	public List<CommandBuilder> getCommands() {
		return null;
	}

	/**
	 * get a command from a subcommand lable.
	 *
	 * @param lable your comand lable you register with.
	 * @return CommandBuilder.
	 */

	public CommandBuilder getCommandBuilder(final String lable) {
		return getCommandBuilder(lable, false);
	}

	/**
	 * get a command from a subcommand lable.
	 *
	 * @param lable      your comand lable you register with.
	 * @param startsWith if it shall start compere on first letter you type.
	 * @return CommandBuilder.
	 */
	public CommandBuilder getCommandBuilder(final String lable, final boolean startsWith) {
		return null;
	}

	/**
	 * Get the set prefix message. Is list of first messages
	 * some get send to player (if they not type sub command).
	 *
	 * @return this class.
	 */
	public List<String> getHelpPrefixMessage() {
		return null;
	}

	/**
	 * Get the set suffix message. Is list of first messages
	 * some get send to player (if they not type sub command).
	 *
	 * @return list of set messages.
	 */
	public List<String> getHelpSuffixMessage() {
		return null;
	}

	/**
	 * Get the set command lable message, when player not has permission. Is list of first messages
	 * some get send to player (if they not type sub command).
	 *
	 * @return the set message.
	 */
	public String getCommandLableMessageNoPerms() {
		return null;
	}

	/**
	 * Get the set command lable message. Is list of first messages
	 * some get send to player (if they not type sub command).
	 *
	 * @return the set message.
	 */
	public String getCommandLableMessage() {
		return null;
	}

}
