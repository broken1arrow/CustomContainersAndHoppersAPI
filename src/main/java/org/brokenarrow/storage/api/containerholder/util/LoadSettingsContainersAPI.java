package org.brokenarrow.storage.api.containerholder.util;

import org.brokenarrow.storage.api.builders.ContainerLevelSettingsApi;
import org.brokenarrow.storage.api.builders.ContainerSettingsApi;
import org.brokenarrow.storage.api.builders.ContainerSettingsWrapperAPI;

import javax.annotation.Nullable;
import java.util.Map;

public interface LoadSettingsContainersAPI {

	/**
	 * Settings data from the file for this container.
	 *
	 * @param fileName the filename for get containers settings.
	 * @return ContainerSettingsWrapperAPI to access all data for this file.
	 */
	@Nullable
	ContainerSettingsWrapperAPI getContainerSettingsWrapper(final String fileName);

	/**
	 * Get the settings for this container type.
	 *
	 * @param fileName the filename for get containers settings.
	 * @return the settings for the container from the file.
	 */
	ContainerSettingsApi getContainerDataSettings(final String fileName);

	/**
	 * Get the level settings for this container type. So
	 *
	 * @param fileName the filename for get containers settings.
	 * @param containerUpdate the update if the container ether current or next update you want to get.
	 * @return the level settings for the container from the file.
	 */
	ContainerLevelSettingsApi getContainerSettingsInCache(final String fileName, final String containerUpdate);


	/**
	 * Setings data for all containers.
	 *
	 * @return the map with all values for all containers.
	 */
	Map<String, ContainerSettingsWrapperAPI> getContainerSettings();
}
