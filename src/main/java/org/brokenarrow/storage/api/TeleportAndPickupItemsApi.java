package org.brokenarrow.storage.api;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.brokenarrow.storage.api.containerholder.teleport.SuctionItemHandler;
import org.brokenarrow.storage.api.containerholder.teleport.TeleportItemHandler;
import org.brokenarrow.storage.api.containerholder.teleport.TeleportTarget;
import org.brokenarrow.storage.api.util.builderclass.TeleportWrapper;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Consumer;

/**
 * API for handling item teleportation and ground item suction
 * linked to a container.
 * <p>
 * Implementations manage cached container data and execute
 * teleport or pickup logic based on container configuration.
 */
public interface TeleportAndPickupItemsApi {

    /**
     * Starts the linked container task (teleportation and/or suction).
     * <p>
     * The container configuration (YAML) determines whether
     * teleporting and/or item pickup is enabled.
     *
     * @param holder   the inventory holder representing the source container
     * @param callback callback invoked after the task initializes
     */
    void linkedContainerTask(@NotNull InventoryHolder holder, Consumer<TeleportAndPickupItemsApi> callback);

    /**
     * Sets the handler responsible for teleporting items.
     * <p>
     * The handler is executed after validating that the target container
     * can accept the items.
     * <p>
     * The {@link TeleportTarget} provides access to both vanilla and custom
     * inventories. Always check {@link TeleportTarget#isCustom()} before
     * directly accessing a custom inventory implementation, as doing so
     * without validation may cause errors.
     *
     * @param teleportHandler handler responsible for processing item teleportation
     */
    void setTeleportHandler(@Nonnull TeleportItemHandler teleportHandler);

    /**
     * Sets the handler responsible for suction (picking up) ground items.
     * <p>
     * This method is executed only for valid item entities (not mobs).
     * It may run multiple times if multiple item stacks are processed.
     *
     * @param suctionHandler handler responsible for processing item pickup
     */
    void setSuctionHandler(SuctionItemHandler suctionHandler);

    /**
     * Saves data to the cache using a {@link TeleportWrapper}.
     *
     * @param consumer consumer used to modify or initialize the teleport wrapper
     */
    void saveToCache(@Nonnull Consumer<TeleportWrapper> consumer);

    /**
     * Removes this container’s cached inventory data.
     */
    void removeCachedInventories();

    /**
     * Adds a linked container's inventory and location to the cache.
     * <p>
     * This method is thread-safe.
     *
     * @param linkedTo the location of the linked container
     */
	void addCachedLinkedContainerInventory(@Nonnull final Location linkedTo);

    /**
     * Removes a linked container's inventory and location from the cache.
     * <p>
     * This method is thread-safe.
     *
     * @param linkedTo the location of the linked container
     */
	void removeCachedLinkedContainerInventory(@Nonnull final Location linkedTo);

    /**
     * Clears the current {@link TeleportWrapper}.
     * <p>
     * After calling this method, a new wrapper must be set using
     * {@link #saveToCache(Consumer)}.
     * <p>
     * Alternatively, calling {@link #linkedContainerTask(InventoryHolder, Consumer)}
     * will automatically create a new wrapper if none exists.
     * <p>
     * This method is thread-safe.
     */
	void clearTeleportWrapper();

    /**
     * Returns a snapshot of cached linked container inventories.
     * <p>
     * This snapshot reduces resource usage compared to repeatedly calling
     * {@code getState()} on containers.
     * <p>
     * Note: The snapshot is temporary. If the chunk containing a linked
     * container unloads, the snapshot becomes invalid and must be refreshed.
     * <p>
     * This map is NOT thread-safe.
     *
     * @return a map of linked container locations to their cached inventory snapshots,
     *         or {@code null} if none exist.
     */
	@Nullable
	Map<Location, Inventory> getCachedLinkedInventors();

    /**
     * Returns the cached {@link TeleportWrapper}.
     *
     * @return the teleport wrapper, or {@code null} if not set
     */
	@Nullable
	TeleportWrapper getTeleportWrapper();

    /**
     * Returns the index of the next linked container to be processed.
     *
     * @return the next index to process, or {@code -1} if no containers exist
     */
	int getNumberInList();

    /**
     * Indicates whether items were successfully teleported.
     *
     * @return {@code true} if at least one item was moved
     */
	boolean isTeleportedItems();

    /**
     * Indicates whether this container is currently stored in the cache.
     *
     * @return {@code true} if the container exists in the cache
     */
	boolean isLocationInCache();

}
