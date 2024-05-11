package org.brokenarrow.storage.api.util.sign;

/**
 * This class sets the mode for sign placements.
 */
public enum PlacingSignMode {
	/**
	 * This mode is for player manually place the sign.
	 */
	Manual("You need to place the sign manually whale you crutching."),
	/**
	 * This mode is for automatic place the sign when you place the container.
	 */
	Auto("It will place the sign auto,matic on the chest"),
	/**
	 * This mode turn off the sign placing.
	 */
	Off("Turns if the sign placement completely.");

	private final String description;

	PlacingSignMode(final String description) {
		this.description = description;
	}

	/**
	 * The description what the mode does.
	 *
	 * @return the text description what the mode does.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the mode from a string.
	 *
	 * @param mode the mode you want to use.
	 * @return the mode or off if not found or mode is null.
	 */
	public static PlacingSignMode of(String mode) {
		if (mode == null)
			return Off;

		PlacingSignMode[] values = values();
		for (PlacingSignMode signMode : values) {
			if (signMode.name().equalsIgnoreCase(mode))
				return signMode;
		}
		return Off;
	}
}
