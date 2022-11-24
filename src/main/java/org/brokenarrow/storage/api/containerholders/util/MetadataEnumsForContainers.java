package org.brokenarrow.storage.api.containerholders.util;

import org.brokenarrow.storage.CCH;
import org.bukkit.plugin.Plugin;

/**
 * Keys for diffrent data for containers.
 */

public enum MetadataEnumsForContainers {

	PLAYER_PLACED_CONTAINER("PLAYER_PLACED_CONTAINER"),
	GET_AMOUNT_OF_ITEMS("GET_AMOUNT_OF_ITEMS"),
	WHITE_BLACKFILTER("WHITE_BLACKFILTER"),
	WHITE_BLACKFILTER_ITEMS("WHITE_BLACKFILTER_ITEMS"),
	CONTAINER("CONTAINER"),
	FILE_NAME("FILE_NAME"),
	LEVEL_OF_THIS_CONTAINER("LEVEL_OF_THIS_CONTAINER"),
	GET_CONTAINER_ITEMS("GET_CONTAINER_ITEMS"),
	PAGES_AMOUNT("PAGES_AMOUNT"),
	TIMELEFT("TIMELEFT"),
	AMOUNT_FREE_PLACEMENT("AMOUNT_FREE_PLACEMENT");

	private final String metadataKey;
	private final Plugin plugin = CCH.getInstance();

	MetadataEnumsForContainers(final String metadataKey) {
		this.metadataKey = metadataKey;
	}

	public String getMetadataKey() {
		return metadataKey;
	}

	public Plugin getPlugin() {
		return plugin;
	}


}
