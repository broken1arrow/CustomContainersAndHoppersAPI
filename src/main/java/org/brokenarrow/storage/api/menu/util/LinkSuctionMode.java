package org.brokenarrow.storage.api.menu.util;

/**
 * Defines the interaction mode for opening sign placement setting menus.
 */
public enum LinkSuctionMode {
    /**
     * Requires the player to hold the Shift key while right-clicking to open the menu.
     * Useful for preventing accidental menu triggers during normal block placement.
     */
	SHIFT_CLICK("You must shift and then right click open settings menu."),
    /**
     * Standard interaction where a simple left click to opens the settings menu.
     */
    LEFT_CLICK("You only need left click open settings menu."),
    /**
     * Disables the settings menu entirely during sign placement.
     */
    DISABLED("Turn off the menu.");

	private final String description;

	LinkSuctionMode(final String description) {
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
     * Parses a string to find the corresponding mode.
     *
     * @param mode The string name of the mode to look up.
     * @return The matching {@link LinkSuctionMode}, or {@link #DISABLED} if the mode is null or not found.
     */
	public static LinkSuctionMode of(String mode) {
		if (mode == null)
			return DISABLED;

		LinkSuctionMode[] values = values();
		for (LinkSuctionMode signMode : values) {
			if (signMode.name().equalsIgnoreCase(mode))
				return signMode;
		}
		return DISABLED;
	}
}
