package org.brokenarrow.storage.api.chunkevent;

import org.brokenarrow.storage.api.builders.ChunkCache;
import org.brokenarrow.storage.api.containerholder.key.ChunkKeyAPI;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
/**
 * Tracks player positions at the chunk level and updates chunk relevance.
 *
 * <p>
 * Implementations are responsible for maintaining per-player chunk centers
 * and notifying the underlying chunk cache when players enter or leave
 * tracked areas.
 *
 * <p>
 * This interface is typically used as the bridge between player lifecycle
 * events and {@link ChunkCache} updates.
 */
public interface PlayerChunkTrackerApi {

    /**
     * Starts tracking a player and applies relevance to the surrounding area.
     *
     * @param player the player to begin tracking
     */
    void trackPlayer(@Nonnull final Player player);

    /**
     * Stops tracking a player and removes relevance from the surrounding area.
     *
     * @param player the player to stop tracking
     */
    void untrackPlayer(@Nonnull final Player player);

    /**
     * Updates chunk relevance when a player changes chunk.
     *
     * <p>
     * If the source and destination chunks are equal, implementation
     * will safely ignore the call.
     *
     * @param player the player that moved
     * @param from   the previous chunk key
     * @param to     the new chunk key
     */
    void onPlayerChunkChange(@Nonnull final Player player,@Nonnull final ChunkKeyAPI from,@Nonnull final ChunkKeyAPI to);

}
