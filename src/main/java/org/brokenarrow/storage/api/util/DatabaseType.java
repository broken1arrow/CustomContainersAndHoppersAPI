package org.brokenarrow.storage.api.util;

public enum DatabaseType {
	MySQL,
	SQlite,
	;


	public static DatabaseType getType(String type) {
		if (type == null) return null;

		for (DatabaseType value : values())
			if (value.name().equalsIgnoreCase(type))
				return value;
		return null;
	}

}
