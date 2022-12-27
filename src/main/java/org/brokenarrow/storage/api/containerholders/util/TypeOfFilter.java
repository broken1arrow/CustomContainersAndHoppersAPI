package org.brokenarrow.storage.api.containerholders.util;

public enum TypeOfFilter {

	TYPE_MATCH("Only match type of item"),
	META_MATCH("Need to match exacly the item"),
	PARTLY_MATCH("Match name, lore, type and both item has meta or not");

	private final String description;

	TypeOfFilter(final String description) {
		this.description = description;
	}

	public static TypeOfFilter getType(final String filterType) {
		final TypeOfFilter[] values = values();
		if (filterType == null) return null;

		for (final TypeOfFilter value : values) {
			if (value.name().equals(filterType.toUpperCase())) {
				return value;
			}
		}
		return null;
	}

	public static TypeOfFilter getType(final int index) {
		if (index >= values().length) return TYPE_MATCH;
		return values()[index];
	}

	public String getDescription() {
		return description;
	}
}