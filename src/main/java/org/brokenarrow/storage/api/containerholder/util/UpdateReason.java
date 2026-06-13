package org.brokenarrow.storage.api.containerholder.util;

/**
 * The reason it updates the container.
 */
public enum UpdateReason {
    /**
     * When loading the containers inventories.
     */
    LOAD_CONTAINER,
    /**
     * When open the container.
     */
    OPEN_CONTAINER,
    /**
     * When reload the plugin.
     */
    RELOAD
}
