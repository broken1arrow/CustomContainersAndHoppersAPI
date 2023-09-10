package org.brokenarrow.storage.api.metadata;

import org.brokenarrow.storage.CCH;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;

public enum PlayerMetadataHandler implements PlayerMetadata {

	INVENTORY_LINK_TO_CONTAINER("LinkingContainer"),
	ACTIVATE_LINK_TO_CONTAINER("Activate_linking_to_Container"),
	LOCATION_FOR_CONTAINER("Special_chest_location"),
	INVENTORY_CRAFTING_GUI("INVENTORY_crafting_filter_items"),
	INVENTORY_FILTER_GUI("INVENTORY_For_linking_chest/hoppers"),
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
