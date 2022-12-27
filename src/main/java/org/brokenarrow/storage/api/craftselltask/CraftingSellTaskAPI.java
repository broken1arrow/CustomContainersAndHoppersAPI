package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.containerholders.InventoryHolder;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.bukkit.Location;
import org.bukkit.Material;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CraftingSellTaskAPI {

	/**
	 * The task for craft all items some match ingredients and added recipes in the container.
	 *
	 * @param inventoryHolder the inventory holder to get all data for this container.
	 */
	void craftingTask(@NotNull final InventoryHolder inventoryHolder);

	/**
	 * The task for sell all items in container.
	 * '
	 *
	 * @param inventoryHolder the inventory holder to get all data for this container.
	 */
	void sellTask(@NotNull final InventoryHolder inventoryHolder);

	/**
	 * Get if it have finish crafing one item.
	 *
	 * @return true if it have finish craft one item.
	 */
	boolean isFinishCrafting();

	/**
	 * Get all curent data about items get crafted and selled items. Will be clered after player get the message.
	 *
	 * @return map with the data set.
	 */
	Map<String, CraftSellDataApi> getCachedTasks();

	/**
	 * Get specific data on one container.
	 *
	 * @param location location of the container.
	 * @param material the matrial output when crafting or the item some get sold.
	 * @return CraftSellData class with all data for that container.
	 */
	@Nullable
	CraftSellDataApi getCachedTasks(@NonNull Location location, @NonNull Material material);

	boolean isTaskCached(@NotNull Location location);

	/**
	 * Get the item and amount get crafted or sold.
	 *
	 * @param location   location of the container.
	 * @param material   the matrial output when crafting or the item some get sold.
	 * @param typeOfTask if it sell or craft task.
	 * @return
	 */
	@Nullable
	CraftSellProviderApi getCachedTasksProviderApi(@NonNull Location location, @NonNull Material material, @NonNull TypeOfTask typeOfTask);

	/**
	 * Put data to cache. Will remove the old data and replace with the new data.
	 *
	 * @param location      location of the container.
	 * @param material      the matrial output when crafting or the item some get sold.
	 * @param craftSellData class you build data with.
	 */
	void putCachedTasks(@NonNull Location location, @NonNull Material material, @NonNull CraftSellDataApi craftSellData);

	/**
	 * Put data to cache. Will remove the old data and replace with the new data.
	 *
	 * @param location             location of the container.
	 * @param material             the matrial output when crafting or the item some get sold.
	 * @param uuid                 player some this container belongs too.
	 * @param typeOfTask           the type of task you run (sell or crafting).
	 * @param craftSellProviderApi the class for specific set data for sold or crafted items.
	 */
	void putCachedTasks(@NonNull Location location, @NonNull Material material, @NonNull UUID uuid, @NonNull TypeOfTask typeOfTask, @NonNull CraftSellProviderApi craftSellProviderApi);

	/**
	 * Add data to cache. Will keep the old data and add new data ontop of this.
	 *
	 * @param location             location of the container.
	 * @param material             the matrial output when crafting or the item some get sold.
	 * @param uuid                 player some this container belongs too.
	 * @param typeOfTask           the type of task you run (sell or crafting).
	 * @param craftSellProviderApi the class for specific set data for sold or crafted items.
	 */
	void addCachedTasks(@NonNull Location location, @NonNull Material material, @NonNull UUID uuid, int amountMade, @NonNull TypeOfTask typeOfTask, @NonNull CraftSellProviderApi craftSellProviderApi);

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
	List<CraftSellProviderApi> getCachedCraftSellList();

	/**
	 * Get list of CraftSellProviders curently added.
	 *
	 * @return list of all curently saved data on items get sold or crafted.
	 */
	Collection<CraftSellDataApi> getCachedCraftSellPrividerList();
}
