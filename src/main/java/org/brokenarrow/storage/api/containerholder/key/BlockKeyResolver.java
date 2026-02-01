package org.brokenarrow.storage.api.containerholder.key;

import org.bukkit.Location;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;

/**
 * Resolves a stable block reference to a Bukkit {@link Location}.
 *
 * <p>
 * Implementations act as a safe indirection layer over {@link Location},
 * which may be unstable due to world unloading, cloning, or lifecycle
 * changes in the Bukkit API.
 *
 * <p>
 * The resolved location may be {@code null} if the underlying world
 * is not currently available.
 */
public interface BlockKeyResolver {

    /**
     * Resolves the current {@link Location} of this block.
     *
     * @return the resolved location, or {@code null} if unavailable
     */
    @Nullable
    Location getLocation();
    /**
     * The x location.
     *
     * @return the block X coordinate
     */
    int getX();

    /**
     * The y location.
     *
     * @return the block Y coordinate
     */
    int getY();

    /**
     * The z location.
     *
     * @return the block Z coordinate
     */
    int getZ();

    /**
     * Returns the unique identifier of the world this block belongs to.
     *
     * @return the world UUID
     */
    UUID getWorldId();

    /**
     * Indicates whether this resolver has a valid block reference set.
     * <p>
     *
     * @return {@code true} if a block reference is present, otherwise {@code false}
     */
    boolean isSet();

    /**
     * Serializes this block reference into a primitive map representation.
     *
     * <p>
     * The returned map contains the world identifier and block coordinates
     * and is safe to use for configuration storage or persistence.
     * It must not depend on runtime-only objects.
     *
     * @return a non-null serialized representation of this block key
     */
    @Nonnull
    Map<String, Object> serialize();
}