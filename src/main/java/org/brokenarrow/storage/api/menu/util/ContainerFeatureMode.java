package org.brokenarrow.storage.api.menu.util;

/**
 * Defines the operational status of linking and suction features for containers.
 */
public enum ContainerFeatureMode {
    /**
     * Both linking and suction features are fully operational.
     */
    ENABLED("The link and suction features are enabled."),
    /**
     * Disables the linking feature while keeping suction active.
     */
    LINK_DISABLED("Linking is disabled, but suction remains active."),
    /**
     * Disables the suction feature while keeping linking active.
     */
    SUCTION_DISABLED("Suction is disabled, but linking remains active."),
    /**
     * Completely disables both linking and suction features.
     */
    BOTH_DISABLED("Both linking and suction are completely disabled.");

	private final String description;

	ContainerFeatureMode(final String description) {
		this.description = description;
	}

    /**
     * Gets the description of what the mode does.
     *
     * @return The text description of the interaction requirements.
     */
	public String getDescription() {
		return description;
	}

    /**
     * Checks if the link mode is still enabled.
     *
     * @return returns tru if linking is enabled.
     */
    public boolean isLinkEnabled() {
        return this == ENABLED || this == SUCTION_DISABLED;
    }

    /**
     * Checks if the suction mode is still enabled.
     *
     * @return returns true if suction is enabled.
     */
    public boolean isSuctionEnabled() {
        return this == ENABLED || this == LINK_DISABLED;
    }

    /**
     * Parses a string to find the corresponding feature mode.
     *
     * @param mode The string name of the mode to look up.
     * @return The matching {@link ContainerFeatureMode}, or {@link #ENABLED} if null or not found.
     */
	public static ContainerFeatureMode of(String mode) {
		if (mode == null)
			return ENABLED;

		ContainerFeatureMode[] values = values();
		for (ContainerFeatureMode signMode : values) {
			if (signMode.name().equalsIgnoreCase(mode))
				return signMode;
		}
		return ENABLED;
	}
}