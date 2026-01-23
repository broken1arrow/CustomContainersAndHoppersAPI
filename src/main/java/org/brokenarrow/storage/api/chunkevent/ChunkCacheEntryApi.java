package org.brokenarrow.storage.api.chunkevent;

public interface ChunkCacheEntryApi {

    int getPlayerRefs();

    boolean isForceLoaded();

    long getLastSeenTick();

    Relevance getRelevance(long now);

    void addPlayerRefs(int delta);

    void seen(long tick);

    void setForceLoaded(boolean forceLoaded);

}