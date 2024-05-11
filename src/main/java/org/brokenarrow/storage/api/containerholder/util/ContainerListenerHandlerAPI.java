package org.brokenarrow.storage.api.containerholder.util;

import org.brokenarrow.storage.api.containerholder.interaction.ContainerInteractionAPI;
import org.bukkit.event.Listener;

/**
 * The Interface handle all listener events for the containers.
 */
public interface ContainerListenerHandlerAPI extends Listener {
    /**
     * Retrieve the methods used for the container events.
     *
     * @return the instance with all methods used to
     * check if it valid container or normal container.
     */
    ContainerInteractionAPI getContainerInteraction();


}
