package org.brokenarrow.storage.api.chunkevent;

import javax.annotation.Nonnull;

/**
 * Represents volatile, per-chunk state used to determine {@link Relevance}.
 *
 * <p>
 * A cache entry tracks player presence, forced loading state, and the
 * last tick at which the chunk was observed. Entries contain no chunk
 * or snapshot data and are intended to be lightweight and short-lived.
 *
 * <p>
 * Instances are created and managed by {@link org.brokenarrow.storage.api.builders.ChunkCache} and are
 * typically updated by player movement logic (for example {@code PlayerChunkTracker}).
 */
public interface ChunkCacheEntryApi {

    /**
     * Returns the current number of player references affecting this chunk.
     *
     * @return the player reference count (never negative)
     */
    int getPlayerRefs();

    /**
     * Indicates whether this chunk is marked as force-loaded.
     *
     * @return {@code true} if force-loaded, otherwise {@code false}
     */
    boolean isForceLoaded();

    /**
     * Returns the last tick at which this chunk was observed or updated.
     *
     * @return the last seen tick
     */
    long getLastSeenTick();

    /**
     * Computes the current relevance of this chunk.
     *
     * <p>
     * Relevance is derived from player references, forced state, and
     * the time elapsed since {@link #seen(long)} was last called.
     *
     * @param now the current server tick
     * @return the computed relevance
     */
    @Nonnull
    Relevance getRelevance(long now);

    /**
     * Adjusts the player reference count by the given delta.
     *
     * <p>
     * Implementations must ensure the reference count never becomes negative.
     *
     * @param delta the amount to add or subtract
     */
    void addPlayerRefs(int delta);

    /**
     * Marks this chunk as observed at the given tick.
     *
     * @param tick the current server tick
     */
    void seen(long tick);

    /**
     * Sets whether this chunk should be treated as force-loaded.
     *
     * @param forceLoaded {@code true} to force relevance, {@code false} otherwise
     */
    void setForceLoaded(boolean forceLoaded);

}