package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.bukkit.Location;

import java.util.UUID;

public interface CraftSellDataApi {


	CraftSellProviderApi getCraftSellProviderApi();

	/**
	 * Get the type of task curently running.
	 *
	 * @return the type of task.
	 */
	TypeOfTask getTaskType();

	double getTotalSell();

	int getTotalCraft();

	UUID getUuid();

	Location getLocation();

}
