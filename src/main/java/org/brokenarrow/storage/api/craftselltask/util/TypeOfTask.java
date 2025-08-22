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

	public String headerKey() {
		return headerKey;
	}

	public String bodyKey() {
		return bodyKey;
	}

	public String footerKey() {
		return footerKey;
	}

}
