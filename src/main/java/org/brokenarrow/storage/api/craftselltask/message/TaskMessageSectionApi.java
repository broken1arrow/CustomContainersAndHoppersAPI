package org.brokenarrow.storage.api.craftselltask.message;

import org.brokenarrow.storage.api.craftselltask.TaskDataApi;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.bukkit.Location;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public interface TaskMessageSectionApi {
    /**
     * Retrieve the containers' location.
     *
     * @return the location of the container.
     */
    @Nonnull
    Location getLocation();

    /**
     * This method function go through the body messages one by one.
     *
     * @param body the body to part where you have a task done, for example for every craft or sell added as a list to the player.
     * @return This instance to retrieve other methods in this class.
     */
    TaskMessageSectionApi body(Consumer<TaskDataApi> body);

    /**
     * The type of task this tore data for.
     *
     * @return the task typ for example sell or crafting.
     */
    TypeOfTask getTaskType();
}
