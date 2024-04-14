package org.brokenarrow.storage.api.builders;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.util.Map;

public interface ChunkLoadUnload {


    void addToCache(Location containerLocation, ChunkSnapshot chunkSnapshot);

    /**
     * Set chunk data in cache.
     *
     * @param chunk the chunk of the object.
     */
    void setCachedChunks(Chunk chunk);

    /**
     * Set chunk data in cache.
     *
     * @param location location of object.
     */
    void setCachedChunks(final Location location);
    void loadToCache(final Object chunkSnapshot);
    Map<String, Chunk> getCachedChunks();

    void chunkLoad(ChunkLoadEvent event);

    void chunkUnLoad(ChunkUnloadEvent event);

    boolean cachedChunksContainsKey(Location location);
    Chunk getChunkData(int chunkX, int chunkZ);
    Chunk getChunkData(Location location);
}
