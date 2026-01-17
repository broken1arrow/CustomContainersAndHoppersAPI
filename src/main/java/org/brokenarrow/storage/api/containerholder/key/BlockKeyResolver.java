package org.brokenarrow.storage.api.containerholder.key;

import org.bukkit.Location;

import javax.annotation.Nullable;

public interface BlockKeyResolver {

    @Nullable
    Location getLocation();

    boolean isSet();
}