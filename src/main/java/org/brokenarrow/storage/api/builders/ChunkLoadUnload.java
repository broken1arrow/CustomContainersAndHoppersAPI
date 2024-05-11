package org.brokenarrow.storage.api.builders;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.util.Map;

/**
 * Interface for managing chunk load and unload events.
 */
public interface ChunkLoadUnload {

    /**
     * Adds a chunk snapshot to the cache.
     *
     * @param containerLocation The location of the container.
     * @param chunkSnapshot     The snapshot of the chunk to add to the cache.
     */
    void addToCache(Location containerLocation, ChunkSnapshot chunkSnapshot);

    /**
     * Sets chunk data in the cache.
     *
     * @param chunk The chunk to cache.
     */
    void setCachedChunks(Chunk chunk);

    /**
     * Sets chunk data in the cache based on location.
     *
     * @param location The location of the chunk to cache.
     */
    void setCachedChunks(final Location location);

    /**
     * Loads chunk data to the cache.
     *
     * @param chunkSnapshot The chunk snapshot to load to the cache.
     */
    void loadToCache(final Object chunkSnapshot);

    /**
     * Retrieves the cached chunks.
     *
     * @return A map containing cached chunks.
     */
    Map<String, Chunk> getCachedChunks();

    /**
     * Handles chunk load events.
     *
     * @param event The ChunkLoadEvent to handle.
     */
    void chunkLoad(ChunkLoadEvent event);

    /**
     * Handles chunk unload events.
     *
     * @param event The ChunkUnloadEvent to handle.
     */
    void chunkUnLoad(ChunkUnloadEvent event);

    /**
     * Checks if the cache contains data for a specific location.
     *
     * @param location The location to check.
     * @return True if the cache contains data for the location, false otherwise.
     */
    boolean cachedChunksContainsKey(Location location);

    /**
     * Retrieves chunk data based on chunk coordinates.
     *
     * @param chunkX The X-coordinate of the chunk.
     * @param chunkZ The Z-coordinate of the chunk.
     * @return The chunk data.
     */
    Chunk getChunkData(int chunkX, int chunkZ);

    /**
     * Retrieves chunk data based on location.
     *
     * @param location The location of the chunk.
     * @return The chunk data.
     */
    Chunk getChunkData(Location location);
}
