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
	CraftSellProvider getCraftSellProviderApi();

	/**
	 * Get the type of task currently running.
	 *
	 * @return the type of task.
	 */
	TypeOfTask getTaskType();

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
