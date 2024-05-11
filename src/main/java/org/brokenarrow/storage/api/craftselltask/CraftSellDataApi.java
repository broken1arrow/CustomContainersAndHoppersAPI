package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.bukkit.Location;

import java.util.UUID;

/**
 * Interface you want to retrieve crafting and sell data.
 */
public interface CraftSellDataApi {

	/**
	 * Get the instance of the CraftSellProvider.
	 *
	 * @return the CraftSellProvider instance.
	 */
	CraftSellProviderApi getCraftSellProviderApi();

	/**
	 * Get the type of task currently running.
	 *
	 * @return the type of task.
	 */
	TypeOfTask getTaskType();

	/**
	 * Get the total balance player currently has sell for.
	 *
	 * @return the amount se sold for.
	 */
	double getTotalSell();

	/**
	 * Get amount player currently crafted.
	 *
	 * @return the amount crafted.
	 */
	int getTotalCraft();
	/**
	 * Get the player that own the container that currently did
	 * crafting or sell task.
	 *
	 * @return the players uuid.
	 */
	UUID getUuid();

	/**
	 * Get the location of the container that currently did
	 * crafting or sell task.
	 *
	 * @return the location where this accrued.
	 */
	Location getLocation();

}
