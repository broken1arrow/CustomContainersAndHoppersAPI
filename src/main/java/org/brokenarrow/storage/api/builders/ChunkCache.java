package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.chunkevent.ChunkCacheEntryApi;
import org.brokenarrow.storage.api.chunkevent.Relevance;
import org.brokenarrow.storage.api.containerholder.key.ChunkKeyAPI;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Interface for managing chunk load and unload events.
 */
public interface ChunkCache {

    /**
     * Adds a chunk snapshot to the cache.
     *
     * @param containerLocation The location of the container.
     * @param chunkSnapshot     The snapshot of the chunk to add to the cache.
     */
    void addToCache(Location containerLocation, ChunkSnapshot chunkSnapshot);

    void setChunkData(@Nonnull Location location, Consumer<ChunkCacheEntryApi> callback);

    @Nonnull
    Relevance getRelevance(Location location);

    /**
     * Loads chunk data to the cache.
     *
     * @param chunk The chunk to retrieve the chunk snapshot to add.
     */
    void loadToCache(@NotNull final Chunk chunk);

    /**
     * Loads chunk data to the cache.
     *
     * @param chunkSnapshot The chunk snapshot to add.
     */
    void loadToCache(@NotNull final ChunkSnapshot chunkSnapshot);

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
     * Retrieves the cached chunks. This cache can
     * contain outdated chunk data, as it only contains
     * the snapshot of the actual chunk. It does not get
     * live updates.
     *
     * @return A map containing cached chunks.
     */
    Map<ChunkKeyAPI, ChunkCacheEntryApi> getCache();

    @Nullable
    ChunkCacheEntryApi getCache(Location location);

    @Nullable
    ChunkCacheEntryApi getCache(ChunkKeyAPI chunkKey);

    /**
     * Checks if the cache contains data for a specific location.
     *
     * @param location The location to check.
     * @return True if the cache contains data for the location, false otherwise.
     */
    boolean cachedChunksContainsKey(Location location);

    void setChunkData(@Nonnull ChunkKeyAPI key, Consumer<ChunkCacheEntryApi> callback);

    void removeChunk(Location location);

    void removeChunk(ChunkKeyAPI chunkKey);


    void logNotFoundChunk(@NotNull Location location);
}
