package org.brokenarrow.storage.api.builders;

import org.bukkit.World;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ChunkKeyAPI {

    int getChunkX();

    int getChunkZ();

    @Nullable
    World getWorld();
}
