package org.brokenarrow.storage.api.craftselltask;

import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.bukkit.Location;

import java.util.UUID;

/**
 * Interface you want to retrieve crafting and sell data.
 */
public interface TaskDataApi {

	/**
	 * Returns a unique identifier for this task execution.
	 *
	 * @return the ID for this task result
	 */
	int getID();

	/**
	 * Returns the provider that supplied this task data.
	 *
	 * @return the {@link TaskProvider} instance
	 */
	TaskProvider getCraftSellProviderApi();

	/**
	 * Returns the type of task that was executed.
	 *
	 * @return the {@link TypeOfTask}
	 */
	TypeOfTask getTaskType();

	/**
	 * Returns the player who owns the container that executed the task.
	 *
	 * @return the owning player's {@link UUID}
	 */
	UUID getUuid();

	/**
	 * Returns the location of the container that executed the task.
	 *
	 * @return the {@link Location} where the task occurred
	 */
	Location getLocation();

}
