package org.brokenarrow.storage.api.util;

import org.broken.arrow.library.version.VersionUtil;
import org.bukkit.plugin.Plugin;

/**
 * Enum representing different versions of the Minecraft server.
 */
public enum ServerVersion {

    /**
     * Represents server version 1.20.
     */
    v1_20(20.0),

    /**
     * Represents server version 1.19.
     */
    v1_19(19.0),

    /**
     * Represents server version 1.18.2.
     */
    v1_18_2(18.2),

    /**
     * Represents server version 1.18.1.
     */
    v1_18_1(18.1),

    /**
     * Represents server version 1.18.0.
     */
    v1_18_0(18.0),

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
    v1_10(10.0),

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
    private static VersionUtil versionUtil;

    /**
     * Checks if the current server version is at least the provided version.
     *
     * @param version The version to compare against.
     * @return True if the server version is at least the provided version, false otherwise.
     */
    public static boolean atLeast(final ServerVersion version) {
        return versionUtil.compareTo((int) version.version, 0).atLeast();
    }

    /**
     * Checks if the current server version is newer than the provided version.
     *
     * @param version The version to compare against.
     * @return True if the server version is newer than the provided version, false otherwise.
     */
    public static boolean newerThan(final ServerVersion version) {
        return versionUtil.compareTo((int) version.version, 0).newer();
    }

    /**
     * Checks if the current server version is older than the provided version.
     *
     * @param version The version to compare against.
     * @return True if the server version is older than the provided version, false otherwise.
     */
    public static boolean olderThan(final ServerVersion version) {
        return versionUtil.compareTo((int) version.version, 0).older();
    }

    /**
     * Gets the name of the server.
     *
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
        if (versionUtil != null) return;

        versionUtil = new VersionUtil(plugin);
        System.out.println("versionUtil.versionNewer major: " + versionUtil.getVersion().getMajor() + " m " + versionUtil.getVersion().getMinor() + " p " + versionUtil.getVersion().getPatch());
        System.out.println("versionUtil.compareTo((int) version.version, 0).newer();" + versionUtil.compareTo((int) ServerVersion.v1_10.version, 0).newer());
        serverName = plugin.getServer().getName();
    }

    /**
     * Checks if the server is running on Paper.
     *
     * @return True if the server is Paper, false otherwise.
     */
    public static boolean isPaper() {
        return serverName.equals("Paper") || serverName.startsWith("Paper");
    }

    /**
     * Constructs a ServerVersion enum with the given version.
     *
     * @param version The version number.
     */
    ServerVersion(final double version) {
        this.version = version;

    }
}