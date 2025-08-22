package org.brokenarrow.storage.api.craftselltask;

import org.bukkit.Location;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a composite key used for caching executed task results.
 * <p>
 * Each key is based on the container's {@link Location} and the
 * {@link Material} associated with the task. This ensures uniqueness
 * when identifying task results in a cache.
 */
public interface TaskCacheKey {

    /**
     * Returns the location associated with this key.
     *
     * @return the {@link Location} of the container
     */
    @NotNull
    Location getLocation();

    /**
     * Returns the material associated with this key.
     *
     * @return the {@link Material} set for this key
     */
    Material getMaterial();
}
