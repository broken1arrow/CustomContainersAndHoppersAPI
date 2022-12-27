package org.brokenarrow.storage.api.util.command;

import java.util.Arrays;
import java.util.List;

public class CommandBuilder {

	private final String prefix;
	private final String description;
	private final String permission;
	private final String permissionMessage;
	private final List<String> usageMessages;
	private final boolean showFirstCommandLable;
	private final CommandWarper executor;
	private final Builder builder;

	public CommandBuilder(final Builder builder) {
		this.prefix = builder.subLable;
		this.description = builder.description;
		this.permission = builder.permission;
		this.permissionMessage = builder.permissionMessage;

		this.usageMessages = builder.usageMessages;
		this.showFirstCommandLable = builder.showFirstCommandLable;
		this.executor = builder.executor;
		this.builder = builder;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getUsageMessages() {
		return usageMessages;
	}

	public String getPermission() {
		return permission;
	}

	public String getPermissionMessage() {
		return permissionMessage;
	}

	public boolean isShowFirstCommandLable() {
		return showFirstCommandLable;
	}

	public CommandWarper getExecutor() {
		return executor;
	}

	public Builder getBuilder() {
		return builder;
	}

	public static class Builder {
		private String subLable;
		private String description;
		private String permission;
		private String permissionMessage;
		private List<String> usageMessages;
		private boolean showFirstCommandLable;
		private final CommandWarper executor;

		/**
		 * Will set subLable auto if you want to override that
		 * use {@link #setSubLable(String)}.
		 *
		 * @param executor the class some you store what the command shall do when executed.
		 */

		public Builder(final CommandWarper executor) {
			this.executor = executor;
			this.subLable = executor.getCommandLable();
		}

		/**
		 * Set the prefix for subcommand. Use | like this
		 * first|second command to add two options for same
		 * command. It will be set with the constructor call
		 * but you can override it with this method.
		 *
		 * @param subLable the prefix you want as sublable.
		 * @return this class.
		 */
		public Builder setSubLable(final String subLable) {
			this.subLable = subLable;
			return this;
		}

		/**
		 * Set one or several messages to suggest to player how to use the command.
		 *
		 * @param usageMessages the message list.
		 * @return this class.
		 */
		public Builder setUsageMessages(final String... usageMessages) {
			this.usageMessages = Arrays.asList(usageMessages);
			return this;
		}

		/**
		 * Sett list of messages to suggest to player how to use the command.
		 *
		 * @param usageMessages the message list.
		 * @return this class.
		 */
		public Builder setUsageMessages(final List<String> usageMessages) {
			this.usageMessages = usageMessages;
			return this;
		}

		/**
		 * Description of the command.
		 *
		 * @param description type in a description message.
		 * @return this class.
		 */
		public Builder setDescription(final String description) {
			this.description = description;
			return this;
		}

		/**
		 * Set the command, if you not set this the command will always be accepted.
		 *
		 * @param permission permission you want to have.
		 * @return this class.
		 */
		public Builder setPermission(final String permission) {
			this.permission = permission;
			return this;
		}

		/**
		 * Set the message when player can't run the command. Use {perm} to replace
		 * it with the missing permission auto.
		 *
		 * @param permissionMessage the message when fail to run the command
		 * @return this class.
		 */
		public Builder setPermissionMessage(final String permissionMessage) {
			this.permissionMessage = permissionMessage;
			return this;
		}

		/**
		 * Set if it shall suggest the subcommand without permission or block usage of that command also.
		 *
		 * @param showFirstCommandLable false if you want to block the usage.
		 * @return this class.
		 */
		public Builder setShowFirstCommandLable(final boolean showFirstCommandLable) {
			this.showFirstCommandLable = showFirstCommandLable;
			return this;
		}

		public CommandBuilder build() {
			return new CommandBuilder(this);
		}
	}
}
