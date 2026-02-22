package org.brokenarrow.storage.api.builders;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * The containers settings.
 */
public interface ContainerSettings {

    /**
     * Get the name of the file that set these settings.
     *
     * @return the file name.
     */
    @Nonnull
    String getFileName();

    /**
	 * Get the settings for this container.
	 *
	 * @return Container settings for this container.
	 */
	@Nullable
	ContainerSettingsApi getContainerSettings();

	/**
	 * Get the upgrade settings for this container.
	 *
	 * @param level the level you want to get.
	 * @return det data or null if the level not exist.
	 */
	@Nullable
	ContainerLevelSettingsApi getContainerLevelSettings(String level);

	/**
	 * Get the map with all levels and level settings
	 *
	 * @return a map with all upgrades for this container.
	 */
	@Nonnull
	Map<String, ContainerLevelSettingsApi> getContainerLevelSettings();
}
