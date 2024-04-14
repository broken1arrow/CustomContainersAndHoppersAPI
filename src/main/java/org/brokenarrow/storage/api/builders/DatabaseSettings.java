package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.util.DatabaseType;

public interface DatabaseSettings {


    DatabaseSettingDataAPI getDatabaseSetting();

    void setDatabaseType(DatabaseType type);

    String getDatabaseType();

    boolean isCacheUserdata();

    boolean isCacheContainersData();

    boolean isCacheLoadWhenOpenContainer();

    boolean isCacheLoadWhenChunkLoaded();

    String getPathForFileDB();

    String getHostAddress();

    String getPort();

    String getDatabaseName();

    String getDatabaseUser();

    String getDatabasePassword();

    int getSavingTime();

    String getPrefixForDB();

    void reload();

    void save();
}
