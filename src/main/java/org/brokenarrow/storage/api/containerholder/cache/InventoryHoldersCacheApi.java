package org.brokenarrow.storage.api.containerholder.cache;

import org.brokenarrow.storage.api.builders.ContainerWriter;
import org.brokenarrow.storage.api.containerholder.key.BlockKeyResolver;
import org.brokenarrow.storage.api.containerholder.key.ChunkKeyAPI;
import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * In this class you add your inventory holder.
 */
public interface InventoryHoldersCacheApi {

	/**
	 * If you want to add new container and not want to override the old one.
     * <p>
     * Not recommended to be used if you are unsure if the world is loaded and
     * not null, use the {@link #addInventoryHolder(BlockKeyResolver, ContainerWriter, UUID, boolean)}
     * as you can use the uuid for the world, and it will later on try to resolve the location.
	 *
	 * @param containerData the container data you set on this container.
	 * @param location the location of the container.
	 * @param containerOwner the owner of the container (not recommended to set this to null).
	 * @param forceInData if you want to override the old container set it to true.
	 */
	void addInventoryHolder(@NotNull final ContainerWriter containerData , @NotNull final Location location, @NotNull final UUID containerOwner, final boolean forceInData);

    /**
     * If you want to add new container and not want to override the old one.
     *
     * @param containerData the container data you set on this container.
     * @param keyResolver To set an wrapper around the location of the container.
     * @param containerOwner the owner of the container (not recommended to set this to null).
     * @param forceInData if you want to override the old container set it to true.
     */
    void addInventoryHolder(BlockKeyResolver keyResolver, @NotNull ContainerWriter containerData, @NotNull UUID containerOwner, boolean forceInData);

    /**
	 * This method will create empty ContainerData instance.
	 *
	 * @param location the location of the container.
	 * @param containerOwner the owner of the container (not recommended to set this to null).
	 * @return Inventory holder instance you created if owner is null it will try get cached instance or null if it not exist.
	 */
	@Nullable
    InventoryHolder createAndGetInventoryHolder(@NotNull final Location location, final UUID containerOwner);

	/**
	 * This method will create empty ContainerData instance.
	 * Recommended to use {@link #createAndGetInventoryHolder(org.bukkit.Location, java.util.UUID)}
	 *
	 * @param containerData the containerdata you set on this container.
	 * @param location the location of the container.
	 * @param containerOwner the owner of the container (not recommended to set this to null).
	 * @return Inventory holder instance you created if owner is null it will try get cached instance or null if it not exist.
	 */
	@Nullable
	InventoryHolder createAndGetInventoryHolder(@NotNull final ContainerWriter containerData , @NotNull final Location location, final UUID containerOwner);

    /**
	 * Get the cached inventory holder of this container.
	 *
	 *
	 * @param location of the container you want to get.
	 * @return Inventory holder instance or null if it not exist on this location.
	 */
	@Nullable
	InventoryHolder getInventoryHolder(final Location location);

	/**
	 * remove an inventory holder.
	 *
	 * @param location were you want to remove it.
	 * @return true if it could the old inventory holder.
	 */
	boolean removeInventoryHolder(final Location location);

	/**
	 * Retrieve the inventory holders cached.
	 *
	 * @return map with the inventory holders.
	 */
	Map<BlockKeyResolver, InventoryHolder> getInventoryHolders();

	/**
	 * Remove the location from the chunk list.
	 *
	 * @param location the container location you want to remove from chunk list.
	 * @return true if the location exist in the list.
	 */
	boolean removeLocationChunkData(Location location);

	/**
	 * Retrieve all worlds the containers is placed in.
	 *
	 * @return a set of worlds.
	 */
	Set<World> getSpawnChunk();

	/**
	 * Retrieve the Container data for the container location.
	 *
	 * @param location the location the container is placed in
	 * @return the container data or null if it does not exist.
	 */
	ContainerWriter getContainerData(Location location);

    /**
     * Retrieve list of locations from the specific chunk.
     *
     * @param chunk the chunk the container is placed in
     * @return the list of locations associated to that chunk.
     */
  @Nullable
    List<Location> getChunkData(ChunkKeyAPI chunk);

    /**
	 * Retrieve list of locations from the specific chunk.
	 *
	 * @param chunkSnapshot the chunk the container is placed in
	 * @return the list of locations associated to that chunk.
	 */
	List<Location> getChunkData(Object chunkSnapshot);

    Set<ChunkKeyAPI> getChunks();
}
