package org.brokenarrow.storage.api.containerholder.util;

/**
 * All different chest types stored here. If one container
 * are not valid type it will return DEFAULT.
 * <p>
 * The type of containers are (that inside "" is the string value).
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

	/**
	 * paged_chest
	 */
	PAGEDCONTAINER("paged_chest"),

	/**
	 * craft_chest
	 */
	CRAFTINGCONTAINER("craft_chest"),

	/**
	 * sell_chest
	 */
	SELLCHEST("sell_chest"),

	/**
	 * bigchest
	 */
	STORAGEUNIT("bigchest"),
	/**
	 * hopper
	 */
	LINKEDCONTAINER("hopper"),

	/**
	 * storage_container
	 */
	STORAGE_CONTAINER("storage_container"),
	/**
	 * the link suction container.
	 */
	LINK_SUCTION_CONTAINER("link_suction_container"),
	/**
	 * the paged container.
	 */
	PAGED_CONTAINER("paged_container"),
	/**
	 * the craft container.
	 */
	CRAFTING_CONTAINER("craft_container"),
	/**
	 * the sell container.
	 */
	SELL_CONTAINER("sell_container"),
	/**
	 * Is not a valid container.
	 */
	DEFAULT("null");
	private final String type;

	/**
	 * Construct a container type.
	 *
	 * @param type the type.
	 */
	TypeOfContainer(final String type) {
		this.type = type;
	}

	/**
	 * Get the type of container. Will return {@link #DEFAULT}
	 * if not find right type.
	 *
	 * @param type the type of container.
	 * @return type of container or {@link #DEFAULT} if it not finds the type.
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

	/**
	 * Old way to convert the name to the new format.
	 * @param container the container type.
	 *
	 * @return the type.
	 */
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

	/**
	 * Retrieve the type of container.
	 *
	 * @return the type.
	 */
	public String getType() {
		return type;
	}

}

