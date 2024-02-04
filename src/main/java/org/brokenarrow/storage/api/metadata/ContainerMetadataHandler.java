package org.brokenarrow.storage.api.metadata;

import org.brokenarrow.storage.CCH;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

/**
 * Represents metadata keys associated with container items.
 */

public enum ContainerMetadataHandler implements ContainerMetadata {

	/**
	 * Metadata key for retrieving the player who placed the container.
	 */
	PLAYER_PLACED_CONTAINER("PLAYER_PLACED_CONTAINER"),
	/**
	 * Metadata key for retrieving the number of items in the container. This is used for containers
	 * that store a single item type and keep track of the quantity.
	 */
	GET_AMOUNT_OF_ITEMS("GET_AMOUNT_OF_ITEMS"),
	/**
	 * Metadata key for retrieving the filter type of the container.
	 * 'true' for a white list and 'false' for a black list.
	 */
	WHITE_BLACK_FILTER("WHITE_BLACKFILTER"),
	/**
	 * Metadata key for retrieving the filter contents of the container
	 * as a base64-encoded string from an ItemStack.
	 */
	WHITE_BLACK_FILTER_ITEMS("WHITE_BLACKFILTER_ITEMS"),
	/**
	 * Metadata key for the the retrieval of type of container being placed or broken by the player.
	 */
	CONTAINER("CONTAINER"),
	/**
	 * Metadata key for retrieving the type of container being placed or broken by the player.
	 */
	FILE_NAME("FILE_NAME"),
	/**
	 * Metadata key for retrieving the upgrade level of this container.
	 */
	LEVEL_OF_THIS_CONTAINER("LEVEL_OF_THIS_CONTAINER"),
	/**
	 * Metadata key for retrieving the container contents as a base64-encoded string.
	 */
	GET_CONTAINER_ITEMS("GET_CONTAINER_ITEMS"),
	/**
	 * Metadata key for retrieving the number of pages available in the container.
	 */
	PAGES_AMOUNT("PAGES_AMOUNT"),
	/**
	 * Metadata key for retrieving the time remaining before the
	 * container receives new free placements.
	 */
	TIME_LEFT("TIMELEFT"),
	/**
	 * Metadata key for retrieving the number of free placements remaining in the container.
	 */
	AMOUNT_FREE_PLACEMENT("AMOUNT_FREE_PLACEMENT"),

	LOCATION("Location");

	private final String key;
	private final CCH plugin = CCH.getInstance();

	ContainerMetadataHandler(final String key) {
		this.key = key;
	}

	@Override
	@NotNull
	public String getKey() {
		return key;
	}

	@Override
	public Plugin getPlugin() {
		return plugin;
	}

	@Override
	@Nonnull
	public ItemMetadataHelper getContainerMetadata() {
		return plugin.getItemMetadataUtility();
	}
}
