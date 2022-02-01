package org.brokenarrow.storage.util;

/**
 * All diffrent chest types stored here. If one container
 * are not valid type it will return DEFAULT.
 * <p>
 * The type of continers are:
 * <p>
 * PAGEDCONTAINER("paged_chest")
 * <p>
 * CRAFTINGCONTAINER("craft_chest")
 * <p>
 * SELLCHEST("sell_chest")
 * <p>
 * STORAGEUNIT("bigchest")
 * <p>
 * LINKEDCONTAINER("hopper")
 * <p>
 * DEFAULT("null")
 */
public enum TypeOfContainer {

	PAGEDCONTAINER("paged_chest"), CRAFTINGCONTAINER("craft_chest"), SELLCHEST("sell_chest"),
	STORAGEUNIT("bigchest"), LINKEDCONTAINER("hopper"), DEFAULT("null");
	private final String type;

	TypeOfContainer(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

