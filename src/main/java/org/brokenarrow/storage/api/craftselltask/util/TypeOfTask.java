package org.brokenarrow.storage.api.craftselltask.util;

/**
 * The type of task currently executed.
 */
public enum TypeOfTask {

	/**
	 * If it crafts items.
	 */
	CRAFT_ITEMS("Crafted_item_header", "Crafted_item_line", "Crafted_item_footer"),

	/**
	 * If it sells items.
	 */
	SELL_ITEMS("Sold_item_header", "Sold_item_line", "Sold_item_footer"),

	/**
	 * If it does nether.
	 */
	DEFAULT("", "", "");

	private final String headerKey;
	private final String bodyKey;
	private final String footerKey;

	TypeOfTask(String headerKey, String bodyKey, String footerKey) {
		this.headerKey = headerKey;
		this.bodyKey = bodyKey;
		this.footerKey = footerKey;
	}

    /**
     * Get the header key used in the config.
     *
     * @return the header key.
     */
	public String headerKey() {
		return headerKey;
	}

    /**
     * Get the body key used in the config.
     *
     * @return the body key.
     */
	public String bodyKey() {
		return bodyKey;
	}

    /**
     * Get the footer key used in the config.
     *
     * @return the footer key.
     */
	public String footerKey() {
		return footerKey;
	}

}
