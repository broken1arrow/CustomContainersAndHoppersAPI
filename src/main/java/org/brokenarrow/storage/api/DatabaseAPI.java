package org.brokenarrow.storage.api;

import org.brokenarrow.storage.api.builders.PreferenceSettingsDataAPI;
import org.brokenarrow.storage.api.containerholders.InventoryHolder;
import org.bukkit.Location;

import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

/**
 * Warn do not use this if you don´t know what you are doing or do not know so much about SQL.
 * When using this wrongly it can cause data loss or wrong data added to the cache.
 */

public interface DatabaseAPI {

	/**
	 * the current connection to the database.
	 *
	 * @return the connection.
	 */
	Connection connect();

	/**
	 * If the database have fail to connect.
	 *
	 * @return false if it have successfully connect to database.
	 */
	boolean isHasCastExeption();

	/**
	 * Loading all players data from database to cache will override current data in cache.
	 *
	 * @return True if it successfully added data to cache.
	 */
	boolean loadFromSQLAllPlayerDataToCache();

	/**
	 * check if the plugin save data to database.
	 *
	 * @return true if it saving data.
	 */
	boolean isHasStartWriteToDb();

	/**
	 * Loading all players data from database to cache will override current data in cache.
	 *
	 * @param connection  conection to database
	 * @param loadToCache if it shall forceload data or only add if it not exist in cache.
	 * @return True if it successfully added data to cache.
	 */
	boolean loadFromSQLAllPlayerDataToCache(Connection connection, boolean loadToCache);

	/**
	 * save all player data from cache to database.
	 *
	 * @param preferenceSettingsRegistery cached data.
	 */
	void saveToSQLUserCache(final Map<UUID, PreferenceSettingsDataAPI> preferenceSettingsRegistery);

	/**
	 * remove playerdata from the database.
	 *
	 * @param player uuid;
	 */
	void removePlayerfromSQL(UUID player);

	/**
	 * Get one player´s data from database and it will be added to cache.
	 *
	 * @param player uuid;
	 * @return true if it find the data.
	 */
	boolean getPlayerDatafromSQL(UUID player);

	/**
	 * Loading all continers data from database to cache will override current data in cache.
	 *
	 * @return True if it successfully added data to cache.
	 */
	boolean loadFromSQLAllContainerdataToCache();

	/**
	 * Save containers from a map.
	 *
	 * @param continers map of containers some shall be stored.
	 */
	void saveContainerCacheToSQL(final Map<Location, InventoryHolder> continers);

	/**
	 * Loading all continers data from database to cache will override current data in cache.
	 *
	 * @param connection  conection to database
	 * @param loadToCache if it shall forceload data or only add if it not exist in cache.
	 * @return True if it successfully added data to cache.
	 */
	boolean loadFromSQLAllContainerdataToCache(Connection connection, boolean loadToCache);

	/**
	 * Remove a container from the database.
	 *
	 * @param location location of the container.
	 */
	void removeContainerfromSQL(Location location);

	/**
	 * Get one continer´s data and it will be added to cache.
	 *
	 * @param location of the container.
	 * @return true if it find the data.
	 */
	boolean getOneContainerfromSQL(Location location);

	/**
	 * if it has start load data
	 *
	 * @return true if it load data.
	 * @return true if it load data.
	 */
	boolean isStartLoadContainerdata();
}
