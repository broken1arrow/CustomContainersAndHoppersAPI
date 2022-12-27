package org.brokenarrow.storage.api.builders;

import java.util.Map;

public interface ContainerDataWraperAPI {

	/**
	 * Get the settings for this container.
	 *
	 * @return Container settings for this container.
	 */
	ContainerDataSettingsApi getContainerDataSettings();

	/**
	 * Get the upgrade settings for this container.
	 *
	 * @param level the level you want to get.
	 * @return det data or null if the level not exist.
	 */
	ContainerDataLevelSettingsApi getContainerDataLevelSettings(String level);

	/**
	 * Get the map with all levels and levelsettings
	 *
	 * @return a map with all upgrades for this container.
	 */
	Map<String, ContainerDataLevelSettingsApi> getContainerDataLevelSettings();
}
