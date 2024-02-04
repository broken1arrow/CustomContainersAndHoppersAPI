package org.brokenarrow.storage.api.util.sign;

public enum PlacingSignMode {

	Manual("You need to place the sign manually whale you crutching."),
	Auto("It will place the sign auto,matic on the chest"),
	Off("Turns if the sign placement completely.");

	private final String description;

	PlacingSignMode(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

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
