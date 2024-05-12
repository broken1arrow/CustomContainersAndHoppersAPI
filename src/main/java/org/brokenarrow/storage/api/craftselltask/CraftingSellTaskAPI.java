package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.bukkit.Location;
import org.bukkit.Material;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Data provided when either sell or craft items and also the tasks
 * to sell and craft from a InventoryHolder is provided.
 */
public interface CraftingSellTaskAPI {

	/**
	 * The task for craft all items some match ingredients and added recipes in the container.
	 *
	 * @param inventoryHolder the inventory holder to get all data for this container.
	 */
	void craftingTask(@NotNull final InventoryHolder inventoryHolder);

	/**
	 * The task for sale all items in container.
	 *
	 * @param inventoryHolder the inventory holder to get all data for this container.
	 */
	void sellTask(@NotNull final InventoryHolder inventoryHolder);

	/**
	 * Get if it has finish crafting one item.
	 *
	 * @return true if it has finish craft one item.
	 */
	boolean isFinishCrafting();

	/**
	 * Get all curent data about items get crafted and selled items. Will be clered after player get the message.
	 *
	 * @return map with the data set.
	 */
	Map<CraftSellMapKey, CraftSellDataApi> getCachedTasks();

	/**
	 * Get specific data on one container.
	 *
	 * @param location location of the container.
	 * @param material the matrial output when crafting or the item some get sold.
	 * @return CraftSellData class with all data for that container.
	 */
	@Nullable
	CraftSellDataApi getCachedTasks(@NonNull Location location, @NonNull Material material);

	/**
	 * Checks if task in the cache.
	 *
	 * @param location location you want to check.
	 * @return true if it in cache.
	 */
	boolean isTaskCached(@NotNull Location location);


	/**
	 * Put data to cache. Will remove the old data and replace with the new data.
	 *
	 * @param location      location of the container.
	 * @param material      the matrial output when crafting or the item some get sold.
	 * @param craftSellData class you build data with.
	 */
	void putCachedTasks(@NonNull Location location, @NonNull Material material, @NonNull CraftSellDataApi craftSellData);



	/**
	 * Remove one container from the list.
	 *
	 * @param location   location of the container.
	 * @param material   the matrial output when crafting or the item some get sold.
	 * @param typeOfTask the type of task you run (sell or crafting).
	 */
	void removeCachedTasks(@NonNull Location location, @NonNull Material material, @NonNull TypeOfTask typeOfTask);

	/**
	 * Get the list of cached task some running (craft and sell tasks).
	 *
	 * @return list of curently saved data on items get sold or crafted.
	 */
	List<CraftSellProvider> getCachedCraftSellList();

	/**
	 * Get list of CraftSellProviders curently added.
	 *
	 * @return list of all curently saved data on items get sold or crafted.
	 */
	Collection<CraftSellDataApi> getCachedCraftSellProviderList();
}
