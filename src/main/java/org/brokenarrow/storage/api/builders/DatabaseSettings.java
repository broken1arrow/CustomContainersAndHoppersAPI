package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.util.DatabaseType;

/**
 * This interface can you retrieve and set database settings.
 */
public interface DatabaseSettings {

    /**
     * Retrieve the settings for the database.
     *
     * @return  the settings cache.
     */
    DatabaseSettingDataAPI getDatabaseSetting();

    /**
     * set the type of database tpo load.
     *
     * @param type the type.
     */
    void setDatabaseType(DatabaseType type);

    /**
     * Retrieve the current database type is used.
     * @see DatabaseType
     *
     * @return the database type as string.
     */
    String getDatabaseType();

    /**
     * If it shall load all users data when server starts.
     *
     * @return true if it shall load users  from database when server starts.
     */
    boolean isCacheUserdata();

    /**
     * If it shall load all containers when server starts.
     *
     * @return true if it shall load containers from database when server starts.
     */
    boolean isCacheContainersData();

    /**
     * If it shall load containers when player open container.
     *
     * @return true if it shall load containers from database.
     */
    boolean isCacheLoadWhenOpenContainer();

    /**
     * If it shall load containers when chunk loads.
     *
     * @return true if it shall load containers from database.
     */
    boolean isCacheLoadWhenChunkLoaded();

    /**
     * Retrieve the address to the database.
     *
     * @return the address to the database.
     */
    String getPathForFileDB();

    /**
     * Retrieve the address to the database.
     *
     * @return the address to the database.
     */
    String getHostAddress();

    /**
     * Retrieve the port.
     *
     * @return the port number to connect to the database.
     */
    String getPort();

    /**
     * Retrieve the database name.
     *
     * @return the database name.
     */
    String getDatabaseName();

    /**
     * Retrieve the username for the database.
     * @return the username.
     */
    String getDatabaseUser();

    /**
     * Retrieve the password for the database.
     *
     * @return the password.
     */
    String getDatabasePassword();

    /**
     * Retrieve the intervals it save data to database.
     *
     * @return The intervals in minutes between savings.
     */
    int getSavingTime();

    /**
     * Retrieve the prefix for the table name.
     *
     * @return The prefix set.
     */
    String getPrefixForDB();

    /**
     * Reload the database settings.
     *
     */
    void reload();

    /**
     * This is not currently in use. Due to
     * it does only load the settings.
     */
    void save();
}
