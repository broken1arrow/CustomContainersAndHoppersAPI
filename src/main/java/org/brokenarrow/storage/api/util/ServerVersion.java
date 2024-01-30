package org.brokenarrow.storage.api.util;

import org.bukkit.plugin.Plugin;

public enum ServerVersion {
	v1_20(20.0F),
	v1_19(19.0F),
	v1_18_2(18.2F),
	v1_18_1(18.1F),
	v1_18_0(18.0F),
	v1_17(17),
	v1_16(16),
	v1_15(15),
	v1_14(14),
	v1_13(13),
	v1_12(12),
	v1_11(11),
	v1_10(10),
	v1_9(9),
	v1_8(8),
	v1_7(7),
	v1_6(6),
	v1_5(5),
	v1_4(4),
	v1_3_AND_BELOW(3);
	private final double version;
	private static double currentServerVersion;
	private static String serverName;
	public static boolean equals(final ServerVersion version) {
		return serverVersion(version) == 0;
	}

	public static boolean atLeast(final ServerVersion version) {
		return equals(version) || newerThan(version);
	}

	public static boolean newerThan(final ServerVersion version) {
		return serverVersion(version) > 0;
	}

	public static boolean olderThan(final ServerVersion version) {
		return serverVersion(version) < 0;
	}

	public static double serverVersion(final ServerVersion version) {
		return currentServerVersion - version.getVersion();
	}

	public double getVersion() {
		return version;
	}

	public static double getCurrentServerVersion() {
		return currentServerVersion;
	}

	public static String getServerName() {
		return serverName;
	}

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
	public static boolean  isPaper() {
		return serverName.equals("Paper") || serverName.startsWith("Paper");
	}
	ServerVersion(final float version) {
		this.version = version;

	}

}