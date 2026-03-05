package org.brokenarrow.storage.api.metadata;

import org.brokenarrow.storage.CCH;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;

/**
 * These methods are for set the metadata key on the player.
 */
public enum PlayerMetadataHandler implements PlayerMetadata {

	/**
	 * This key is used when admin activate debug mode.
	 */
    CCH_DEBUG("CCH_Debug");

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
