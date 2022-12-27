package org.brokenarrow.storage.api.containerholders.util;

import org.brokenarrow.storage.api.builders.ContainerDataLevelSettingsApi;
import org.brokenarrow.storage.api.builders.ContainerDataSettingsApi;
import org.brokenarrow.storage.api.builders.ContainerDataWraperAPI;

import java.util.Map;

public interface LoadSettingsContainersAPI {

	/**
	 * Setings data from the file for this container.
	 *
	 * @param fileName the filename for get containers settings.
	 * @return ContainerDataWraperAPI to acces all data for this file.
	 */
	ContainerDataWraperAPI getContainerType(final String fileName);

	/**
	 * Get the settings for this container type.
	 *
	 * @param fileName the filename for get containers settings.
	 * @return the settings for the container from the file.
	 */
	ContainerDataSettingsApi getContainerDataSettings(final String fileName);

	/**
	 * Get the level settings for this container type. So
	 *
	 * @param fileName the filename for get containers settings.
	 * @param containerUpdate the update if the container ether current or other update you want to get.
	 * @return the level settings for the container from the file.
	 */
	ContainerDataLevelSettingsApi getContainerSettingsInCache(final String fileName, final String containerUpdate);


	/**
	 * Setings data for all containers.
	 *
	 * @return the map with all values for all containers.
	 */
	Map<String, ContainerDataWraperAPI> getContainerSettings();
}
