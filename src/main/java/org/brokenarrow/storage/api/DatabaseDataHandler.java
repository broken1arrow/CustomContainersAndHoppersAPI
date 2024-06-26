package org.brokenarrow.storage.api;

import org.brokenarrow.storage.api.util.DatabaseType;
import org.bukkit.Location;

import java.util.List;
import java.util.UUID;

/**
 * The DatabaseDataHandler interface provides methods for managing the plugin's data.
 * It is recommended to call these methods asynchronously to avoid blocking the main thread.
 */
public interface DatabaseDataHandler {

	/**
	 * Loads data from the database to the cache. This method ensures that the tables exist
	 * and then loads the data into the cache.
	 */
	void loadAll();

	/**
	 * Saves all data from the cache to the database. This method saves data for all tables.
	 */
	void saveAll();

	/**
	 * Sets the tables in the cache.
	 */
	void setTables();

	/**
	 * Sets a new database instance.
	 *
	 * @param database the new database type.
	 */
	void setDataBase(DatabaseType database);

	/**
	 * Load all containers to cache.
	 */
	void loadAllContainers();

	/**
	 * Load all container data from database to temporary cache.
	 */
	void loadAllContainersTemp();

	/**
	 * Removes a container from the database.
	 *
	 * @param location the location of the container.
	 */
	void removeContainerFromDb(Location location);

	/**
	 * Adds a container to the database.
	 *
	 * @param blockLocation the location of the container.
	 */
	void addContainerFromDb(Location blockLocation);

	/**
	 * Gets the table name for containers.
	 *
	 * @return the table name.
	 */
	String getContainerTableName();

	/**
	 * Load a players settings to the cache.
	 */
	void loadAllPlayers();

	/**
	 * Load all players settings to temporary cache.
	 */
	void loadAllPlayersTemp();
	/**
	 * Adds a player to the database.
	 *
	 * @param uniqueId the player's unique ID.
	 */
	void addPlayerFromDb(UUID uniqueId);

	/**
	 * Gets the table name for players.
	 *
	 * @return the table name.
	 */
	String getPlayerTableName();

	/**
	 * Save all data to database.
	 *
	 * @param tableName the name of the tabel.
	 * @param temp the list of data to save.
	 */
	void saveAllToDatabase(String tableName, List<?> temp);

	/**
	 * Gets the table name for players.
	 *
	 * @return the table name.
	 */
	boolean isHasStartWriteToDb();

	/**
	 * Get the current database type
	 *
	 * @return the type of database set.
	 */
	DatabaseType getDatabaseType();

	/**
	 * Retrieves the table name for the signs.
	 *
	 * @return the name of the signs table.
	 */
	String getSignTableName();
}
