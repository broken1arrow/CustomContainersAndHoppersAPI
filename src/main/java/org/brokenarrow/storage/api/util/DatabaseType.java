package org.brokenarrow.storage.api.util;

/**
 * The type of database currently used.
 */
public enum DatabaseType {
	/**
	 * MySQL
	 */
	MySQL,
	/**
	 * SQlite
	 */
	SQlite,
	/**
	 * H2
	 */
	H2,
	;

	/**
	 * Get the type from string.
	 *
	 * @param type the type of database.
	 * @return the type or null if could not find the type.
	 */
	public static DatabaseType getType(String type) {
		if (type == null) return null;

		for (DatabaseType value : values())
			if (value.name().equalsIgnoreCase(type))
				return value;
		return null;
	}

}
