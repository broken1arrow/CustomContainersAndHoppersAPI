package org.brokenarrow.storage.api.metadata;

import org.brokenarrow.storage.CCH;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;

/**
 * This methods is for set the metadata key on the player.
 */
public enum PlayerMetadataHandler implements PlayerMetadata {

	/**
	 * This key is used when player is in linking mode.
	 */
	INVENTORY_LINK_TO_CONTAINER("LinkingContainer"),
	/**
	 * This key is used when player is in linking mode.
	 */
	ACTIVATE_LINK_TO_CONTAINER("Activate_linking_to_Container"),
	/**
	 * This key is used when player open a container and need to remember the location.
	 */
	LOCATION_FOR_CONTAINER("Special_chest_location"),
	/**
	 * This key is used when player open a crafting container.
	 */
	INVENTORY_CRAFTING_GUI("INVENTORY_crafting_filter_items"),
	/**
	 * This key is used when player open a filter gui.
	 */
	INVENTORY_FILTER_GUI("INVENTORY_For_linking_chest/hoppers"),
	/**
	 * This key is used when player open settings gui.
	 */
	INVENTORY_SETTINGS_FOR_GUI_MENU("INVENTORY_SETTINGS_FOR_MAIN_GUI_MENU");
	private final String metadataKey;
	final Plugin plugin = CCH.getInstance();

	PlayerMetadataHandler(String metadataKey) {
		this.metadataKey = metadataKey;
	}

	@Override
	@Nonnull
	public String getKey() {
		return metadataKey;
	}

	@Override
	public Plugin getPlugin() {
		return plugin;
	}
}
