package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.chunkevent.ChunkCacheEntryApi;
import org.brokenarrow.storage.api.chunkevent.PlayerChunkTrackerApi;
import org.brokenarrow.storage.api.chunkevent.Relevance;
import org.brokenarrow.storage.api.containerholder.key.ChunkKeyAPI;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Volatile cache tracking player-driven chunk relevance.
 *
 * <p>
 * This cache does not store chunks or snapshots. It maintains transient
 * per-chunk state (player references, forced state, last-seen tick) used
 * to compute {@link Relevance}.
 *
 * <p>
 * Updates are primarily driven by {@code PlayerChunkTracker} via player
 * movement and lifecycle events, with additional signals from chunk
 * load and unload events.
 */
public interface ChunkCache {

    /**
     * Modifies cached chunk data using a callback, resolved from a chunk key.
     *
     * <p>
     * If no cache entry exists for the resolved chunk key, a new entry is created
     * before invoking the callback.
     *
     * @param location the location used to resolve the chunk key
     * @param callback a consumer used to modify the cached chunk entry
     */
    void setChunkLoadContainerTask(@Nonnull final Location location, @Nonnull final Consumer<ChunkCacheEntryApi> callback);

    /**
     * Modifies cached chunk data using a callback, resolved from a chunk key.
     *
     * <p>
     * If no cache entry exists for the resolved chunk key, a new entry is created
     * before invoking the callback.
     *
     * @param key      the chunk key identifying the cached entry
     * @param callback a consumer used to modify the cached chunk entry
     */
    void setChunkLoadContainerTask(@Nonnull final ChunkKeyAPI key, @Nonnull final Consumer<ChunkCacheEntryApi> callback);

    /**
     * Determines the current relevance state of the chunk at the given location.
     *
     * <p>
     * Relevance is typically influenced by player proximity, movement,
     * or other activity tracked by the implementation.
     *
     * @param location the location used to resolve the chunk
     * @return the relevance state of the chunk see {@link Relevance} for what it returns.
     */
    @Nonnull
    Relevance getRelevance(@Nonnull final Location location);

    /**
     * Determines whether the chunk at the given location is loaded or not.
     *
     * <p>
     * This method is a convenience wrapper around {@link #getRelevance(Location)}
     * that maps the returned {@link Relevance} to a boolean result.
     *
     * <p>
     * If more detailed information about the evaluated state is required, use
     * {@link #isLocationLoaded(Location, Consumer)} to observe the relevance result.
     *
     * @param location the location used to resolve the chunk
     * @return {@code true} if the chunk is considered loaded, otherwise {@code false}
     */
    boolean isLocationLoaded(@NotNull final Location location);

    /**
     * Determines whether the chunk at the given location is loaded or not, also exposing
     * the evaluated {@link Relevance} state.
     *
     * <p>
     * The observer does not influence the outcome of this method, it is purely
     * observational. Callers that require full control of the result are recommended
     * to use {@link #getRelevance(Location)} instead.
     *
     * @param location the location used to resolve the chunk
     * @param observer an optional consumer that will receive the evaluated relevance
     * @return {@code true} if the chunk is considered loaded, otherwise {@code false}
     */
    boolean isLocationLoaded(@NotNull final Location location, @Nullable final Consumer<Relevance> observer);

    /**
     * Loads a chunk snapshot directly into the cache for the
     * {@link org.brokenarrow.storage.api.containerholder.cache.InventoryHoldersCacheApi}
     * and not update the chunk cache.
     * <p>
     * This method does not require the chunk to be currently loaded.
     *
     * @param chunkKey the snapshot to update the InventoryHolders set.
     */
    void loadContainerHolderTask(@NotNull ChunkKeyAPI chunkKey);

    /**
     * Loads a chunk snapshot directly into the cache for the
     * {@link org.brokenarrow.storage.api.containerholder.cache.InventoryHoldersCacheApi}
     * and not update the chunk cache.
     * <p>
     * This method does not require the chunk to be currently loaded.
     *
     * @param chunkKey      the snapshot to update the InventoryHolders set.
     * @param chunkSnapshot the snapshot to update the InventoryHolders set.
     */
    void loadContainerHolderTask(@NotNull final ChunkKeyAPI chunkKey, @Nullable final ChunkSnapshot chunkSnapshot);

    /**
     * Handles a chunk load event.
     *
     * <p>
     * Typically used to initialize or update cached chunk data.
     *
     * @param event the chunk load event
     */
    void chunkLoad(final ChunkLoadEvent event);

    /**
     * Handles a chunk unload event.
     *
     * <p>
     * Implementations may choose to retain or remove cached data
     * associated with the unloaded chunk.
     *
     * @param event the chunk unload event
     */
    void chunkUnLoad(final ChunkUnloadEvent event);

    /**
     * Handles player join events.
     *
     * <p>
     * Often used to initialize relevance tracking for nearby chunks.
     *
     * @param event the player join event
     */
    void onJoin(final PlayerJoinEvent event);

    /**
     * Handles player quit events.
     *
     * <p>
     * Typically used to clean up relevance tracking associated with the player.
     *
     * @param event the player quit event
     */
    void onQuit(final PlayerQuitEvent event);

    /**
     * Handles player movement events.
     *
     * <p>
     * Used to update chunk relevance as the player moves between chunks.
     *
     * @param event the player move event
     */
    void onMove(final PlayerMoveEvent event);

    /**
     * Handles player teleport events.
     *
     * <p>
     * Teleports may invalidate large areas of relevance at once.
     *
     * @param event the player teleport event
     */
    void onTeleport(final PlayerTeleportEvent event);


    /**
     * Returns the full internal chunk cache.
     *
     * <p>
     * Cached entries returned by this map are not automatically removed
     * when a chunk unloads.
     *
     * @return a map of chunk keys to cached chunk entries
     */
    Map<ChunkKeyAPI, ChunkCacheEntryApi> getCache();

    /**
     * Retrieves a cached chunk entry based on a location.
     *
     * @param location the location used to resolve the chunk key
     * @return the cached entry, or {@code null} if not present
     */
    @Nullable
    ChunkCacheEntryApi getCache(@Nonnull final Location location);

    /**
     * Retrieves a cached chunk entry by chunk key.
     *
     * @param chunkKey the chunk key
     * @return the cached entry, or {@code null} if not present
     */
    @Nullable
    ChunkCacheEntryApi getCache(@Nonnull final ChunkKeyAPI chunkKey);

    /**
     * Checks whether cached data exists for the chunk at the given location.
     *
     * @param location the location used to resolve the chunk key
     * @return {@code true} if cached data exists, {@code false} otherwise
     */
    boolean cachedChunksContainsKey(@Nonnull final Location location);

    /**
     * Removes cached chunk data resolved from a location.
     *
     * @param location the location used to resolve the chunk key
     */
    void removeChunk(@Nonnull final Location location);

    /**
     * Removes cached chunk data by chunk key.
     *
     * @param chunkKey the chunk key identifying the cache entry
     */
    void removeChunk(@Nonnull final ChunkKeyAPI chunkKey);

    /**
     * Returns the player chunk tracker used to drive chunk relevance updates.
     *
     * <p>
     * The returned tracker is responsible for translating player lifecycle
     * and movement events into relevance changes within this cache.
     *
     * @return the player chunk tracker instance
     */
    @Nonnull
    PlayerChunkTrackerApi getPlayerChunkTracker();
}
