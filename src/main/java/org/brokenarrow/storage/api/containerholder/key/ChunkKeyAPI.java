package org.brokenarrow.storage.api.containerholder.key;

import org.bukkit.World;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents an immutable identifier for a Minecraft chunk.
 *
 * <p>
 * A chunk key provides the chunk X/Z coordinates and a reference to the
 * associated world. It is intended to be used as a stable key in caches
 * and maps rather than as a direct handle to a loaded chunk.
 *
 * <p>
 * Implementations may resolve the world lazily and {@link #getWorld()}
 * may return {@code null} if the world is not available.
 */
public interface ChunkKeyAPI {

    /**
     * Returns the chunk X coordinate.
     *
     * @return the chunk X coordinate
     */
    int getChunkX();

    /**
     * Returns the chunk Z coordinate.
     *
     * @return the chunk Z coordinate
     */
    int getChunkZ();

    /**
     * Returns the world associated with this chunk key.
     *
     * <p>
     * The world may be {@code null} if it is not currently loaded
     * or cannot be resolved.
     *
     * @return the world, or {@code null} if unavailable
     */
    @Nullable
    World getWorld();
}
