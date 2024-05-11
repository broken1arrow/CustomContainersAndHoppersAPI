package org.brokenarrow.storage.api.util;

import org.bukkit.plugin.Plugin;

/**
 * Enum representing different versions of the Minecraft server.
 */
public enum ServerVersion {

	/**
	 * Represents server version 1.20.
	 */
	v1_20(20.0F),

	/**
	 * Represents server version 1.19.
	 */
	v1_19(19.0F),

	/**
	 * Represents server version 1.18.2.
	 */
	v1_18_2(18.2F),

	/**
	 * Represents server version 1.18.1.
	 */
	v1_18_1(18.1F),

	/**
	 * Represents server version 1.18.0.
	 */
	v1_18_0(18.0F),

	/**
	 * Represents server version 1.17.
	 */
	v1_17(17),

	/**
	 * Represents server version 1.16.
	 */
	v1_16(16),

	/**
	 * Represents server version 1.15.
	 */
	v1_15(15),

	/**
	 * Represents server version 1.14.
	 */
	v1_14(14),

	/**
	 * Represents server version 1.13.
	 */
	v1_13(13),

	/**
	 * Represents server version 1.12.
	 */
	v1_12(12),

	/**
	 * Represents server version 1.11.
	 */
	v1_11(11),

	/**
	 * Represents server version 1.10.
	 */
	v1_10(10),

	/**
	 * Represents server version 1.9.
	 */
	v1_9(9),

	/**
	 * Represents server version 1.8.
	 */
	v1_8(8),

	/**
	 * Represents server version 1.7.
	 */
	v1_7(7),

	/**
	 * Represents server version 1.6.
	 */
	v1_6(6),

	/**
	 * Represents server version 1.5.
	 */
	v1_5(5),

	/**
	 * Represents server version 1.4.
	 */
	v1_4(4),

	/**
	 * Represents server version 1.3 and below.
	 */
	v1_3_AND_BELOW(3);

	private final double version;
	private static double currentServerVersion;
	private static String serverName;

	/**
	 * Checks if the current server version equals the provided version.
	 * @param version The version to compare against.
	 *
	 * @return True if the server version equals the provided version, false otherwise.
	 */
	public static boolean equals(final ServerVersion version) {
		return serverVersion(version) == 0;
	}

	/**
	 * Checks if the current server version is at least the provided version.
	 *
	 * @param version The version to compare against.
	 * @return True if the server version is at least the provided version, false otherwise.
	 */
	public static boolean atLeast(final ServerVersion version) {
		return equals(version) || newerThan(version);
	}

	/**
	 * Checks if the current server version is newer than the provided version.
	 * @param version The version to compare against.
	 * @return True if the server version is newer than the provided version, false otherwise.
	 */
	public static boolean newerThan(final ServerVersion version) {
		return serverVersion(version) > 0;
	}

	/**
	 * Checks if the current server version is older than the provided version.
	 *
	 * @param version The version to compare against.
	 * @return True if the server version is older than the provided version, false otherwise.
	 */
	public static boolean olderThan(final ServerVersion version) {
		return serverVersion(version) < 0;
	}

	/**
	 * Computes the difference between the current server version and the provided version.
	 *
	 * @param version The version to compare against.
	 * @return A positive value if the current server version is greater, negative if it's smaller, and zero if they are equal.
	 */
	public static double serverVersion(final ServerVersion version) {
		return currentServerVersion - version.getVersion();
	}
	/**
	 * Gets the version number of the enum.
	 * @return The version number.
	 */
	public double getVersion() {
		return version;
	}

	/**
	 * Gets the current server version.
	 * @return The current server version.
	 */
	public static double getCurrentServerVersion() {
		return currentServerVersion;
	}

	/**
	 * Gets the name of the server.
	 * @return The server name.
	 */
	public static String getServerName() {
		return serverName;
	}

	/**
	 * Sets the server version based on the provided plugin.
	 *
	 * @param plugin The plugin providing server information.
	 */
	public static void setServerVersion(final Plugin plugin) {
		if (currentServerVersion > 0) return;
		final String[] strings = plugin.getServer().getBukkitVersion().split("\\.");
		final String firstNumber;
		String secondNumber;
		final String firstString = strings[1];
		if (firstString.contains("-")) {
			firstNumber = firstString.substring(0, firstString.lastIndexOf("-"));
			secondNumber = firstString.substring(firstString.lastIndexOf("-") + 1);

			final int index = secondNumber.toUpperCase().indexOf("R");
			if (index >= 0)
				secondNumber = secondNumber.substring(index + 1);
		} else {
			final String secondString = strings[2];
			firstNumber = firstString;
			secondNumber = secondString.substring(0, secondString.lastIndexOf("-"));
		}

		final float version = Float.parseFloat(firstNumber + "." + secondNumber);
		if (version < 18)
			currentServerVersion = (float) Math.floor(version);
		else
			currentServerVersion = version;

		serverName = plugin.getServer().getName();
	}

	/**
	 * Checks if the server is running on Paper.
	 * @return True if the server is Paper, false otherwise.
	 */
	public static boolean  isPaper() {
		return serverName.equals("Paper") || serverName.startsWith("Paper");
	}

	/**
	 * Constructs a ServerVersion enum with the given version.
	 * @param version The version number.
	 */
	ServerVersion(final float version) {
		this.version = version;

	}
}