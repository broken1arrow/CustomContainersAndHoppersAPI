package org.brokenarrow.storage.api.containerholders.util;

/**
 * All diffrent chest types stored here. If one container
 * are not valid type it will return DEFAULT.
 * <p>
 * The type of continers are (that inside "" is the string value):
 * <p>
 * <ul>
 * <li>
 * SELLCHEST = "sell_chest"
 * </li>
 * <li>
 * STORAGE_CONTAINER = "storage_container"
 * </li>
 * <li>
 * LINK_SUCTION_CONTAINER = "link_suction_container"
 * </li>
 * <li>
 * PAGED_CONTAINER = "paged_container"
 * </li>
 * <li>
 * CRAFTING_CONTAINER = "craft_container"
 * </li>
 * <li>
 * SELL_CONTAINER = "sell_container"
 * </li>
 * <li>
 * DEFAULT = "null"
 * </li>
 * </ul>
 */

public enum TypeOfContainer {


	PAGEDCONTAINER("paged_chest"),
	CRAFTINGCONTAINER("craft_chest"),
	SELLCHEST("sell_chest"),
	STORAGEUNIT("bigchest"),
	LINKEDCONTAINER("hopper"),
	STORAGE_CONTAINER("storage_container"),
	LINK_SUCTION_CONTAINER("link_suction_container"),
	PAGED_CONTAINER("paged_container"),
	CRAFTING_CONTAINER("craft_container"),
	SELL_CONTAINER("sell_container"),
	DEFAULT("null");
	private final String type;

	TypeOfContainer(final String type) {
		this.type = type;
	}

	/**
	 * Get the type of container. Will return {@link #DEFAULT}
	 * if not find right type.
	 *
	 * @param type
	 * @return type of container or {@link #DEFAULT} if it not find the type.
	 */
	public static TypeOfContainer getType(String type) {
		if (type == null) return DEFAULT;
		final String typeClone = type.toLowerCase();
		type = type.toUpperCase();
		for (final TypeOfContainer containerType : TypeOfContainer.values()) {
			if (containerType.name().equals(type))
				return containerType;
			else if (containerType.getType().equals(typeClone))
				return containerType;
		}
		return DEFAULT;
	}

	/**
	 * Check type of container. If is not valid type it will return false.
	 *
	 * @param container you want to check.
	 * @return true if it valid container (if it not a match or container is null this will return false).
	 */
	public boolean checkContainerType(final TypeOfContainer container) {
		if (container == null) return false;
		if (this == container)
			return true;
		switch (this) {
			case CRAFTING_CONTAINER:
				if (container == CRAFTINGCONTAINER)
					return true;
				break;
			case LINK_SUCTION_CONTAINER:
				if (container == LINKEDCONTAINER)
					return true;
				break;
			case PAGED_CONTAINER:
				if (container == PAGEDCONTAINER)
					return true;
				break;
			case SELL_CONTAINER:
				if (container == SELLCHEST)
					return true;
				break;
			case STORAGE_CONTAINER:
				if (container == STORAGEUNIT)
					return true;
				break;
			case DEFAULT:
				break;
		}
		return false;
	}

	public static TypeOfContainer covertOldFormat(final TypeOfContainer container) {

		if (container == CRAFTINGCONTAINER)
			return CRAFTING_CONTAINER;
		else if (container == LINKEDCONTAINER)
			return LINK_SUCTION_CONTAINER;
		else if (container == PAGEDCONTAINER)
			return PAGED_CONTAINER;
		else if (container == SELLCHEST)
			return SELL_CONTAINER;
		else if (container == STORAGEUNIT)
			return STORAGE_CONTAINER;
		else
			return container;
	}

	public String getType() {
		return type;
	}

}

