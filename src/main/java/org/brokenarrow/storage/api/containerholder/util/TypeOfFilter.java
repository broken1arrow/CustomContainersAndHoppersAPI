package org.brokenarrow.storage.api.containerholder.util;

/**
 * The type of filter used.
 */
public enum TypeOfFilter {

	/**
	 * If it should only match the item type.
	 */
	TYPE_MATCH("Only match type of item."),

	/**
	 * The need to be exact match.
	 */
	META_MATCH("Need to match exactly the item."),

	/**
	 * Only some parts need to match.
	 */
	PARTLY_MATCH("Match name, lore, and type of items with the same meta, ignoring damage.");

	private final String description;

	TypeOfFilter(final String description) {
		this.description = description;
	}

	/**
	 * Retrieve the filter type.
	 * @param filterType the name of the type you want to get.
	 * @return the type or null if it does not fund a match.
	 */
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

	/**
	 * Get the type from the index.
	 * @param index the index you want to get your match
	 * @return the type.
	 */
	public static TypeOfFilter getType(final int index) {
		if (index >= values().length) return TYPE_MATCH;
		return values()[index];
	}

	/**
	 * The description for different filter types.
	 * @return the description set.
	 */
	public String getDescription() {
		return description;
	}
}