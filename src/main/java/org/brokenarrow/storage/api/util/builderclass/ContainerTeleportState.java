package org.brokenarrow.storage.api.util.builderclass;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Persistent runtime state for a container's teleport system.
 *
 * <p>
 * This object stores cached inventories and traversal metadata used
 * to distribute teleport attempts across linked containers in a
 * round-robin fashion.
 * </p>
 *
 * <p>
 * The traversal indices are preserved between teleport runs to ensure
 * fair distribution and to avoid repeatedly targeting the same container
 * when multiple links are configured.
 * </p>
 *
 * <p>
 * Per-run transfer statistics (such as the current teleported amount)
 * are reset before each teleport execution.
 * </p>
 *
 * <p>
 * This class is not thread-safe and is intended for synchronous use
 * within the server thread.
 * </p>
 */
public class ContainerTeleportState {
	private  Map<Location, Inventory> cachedLinkedInventory = new HashMap<>();
	private  Inventory cachedContainerInventory;
	private  int locationNumberInList;
	private  int lastNumberInList;
	private  boolean teleportedItems;
    private int currentTeleportedItems;

    /**
     * Sets the cached linked inventory map.
     *
     * @param cachedLinkedInventory The map containing cached linked inventories.
     * @return The builder instance.
     */
    public ContainerTeleportState setCachedLinkedInventory(final Map<Location, Inventory> cachedLinkedInventory) {
        this.cachedLinkedInventory = cachedLinkedInventory;
        return this;
    }

    /**
     * Sets the cached container inventory.
     *
     * @param cachedContainerInventory The cached container inventory.
     * @return The builder instance.
     */
    public ContainerTeleportState setCachedContainerInventory(final Inventory cachedContainerInventory) {
        this.cachedContainerInventory = cachedContainerInventory;
        return this;
    }

    /**
     * Sets the location number in the list.
     *
     * @param locationNumberInList The location number in the list.
     * @return The builder instance.
     */
    public ContainerTeleportState setLocationNumberInList(final int locationNumberInList) {
        this.locationNumberInList = locationNumberInList;
        return this;
    }

    /**
     * Sets the last number in the list.
     *
     * @param lastNumberInList The last number in the list.
     * @return The builder instance.
     */
    public ContainerTeleportState setLastNumberInList(final int lastNumberInList) {
        this.lastNumberInList = lastNumberInList;
        return this;
    }

    /**
     * Sets whether items were teleported.
     *
     * @param teleportedItems True if items were teleported, false otherwise.
     * @return The builder instance.
     */
    public ContainerTeleportState setTeleportedItems(final boolean teleportedItems) {
        this.teleportedItems = teleportedItems;
        return this;
    }

    /**
     * Returns the last index within the resolved target location list.
     *
     * @return the last traversal index
     */
	public int getLastNumberInList() {
		return lastNumberInList;
	}

	/**
	 * Get the inventory for this container.
	 *
	 * @return the inventory or null.
	 */
	@Nullable
	public Inventory getCachedContainerInventory() {
		return cachedContainerInventory;
	}

    /**
     * Returns the current index within the resolved target location list.
     *
     * @return the zero-based traversal index
     */
	public int getLocationNumberInList() {
		return locationNumberInList;
	}

	/**
	 * Checks if items were teleported.
	 *
	 * @return True if items were teleported, false otherwise.
	 */
	public boolean isTeleportedItems() {
		return teleportedItems;
	}


     /**
     * Returns the cached linked inventories resolved for this teleport cycle.
     *
     * <p>
     * The map keys represent linked container locations, and the values
     * are their corresponding inventories.
     * </p>
     *
     * <p>
     * This map is not thread-safe.
     * </p>
	 * @return the map with all cached inventories.
	 */
	@Nullable
	public Map<Location, Inventory> getCachedLinkedInventory() {
		return cachedLinkedInventory;
	}

	/**
	 * Get the linked inventory from the cache.
	 * <p>
	 * This is not a tread safe map you access.
	 *
	 * @param location of the container that is linked to the link and suction container.
	 * @return the inventory or null if it not exists.
	 */
	@Nullable
	public Inventory getCachedLinkedInventory(final Location location) {
		final Map<Location, Inventory> linkedInventors = this.getCachedLinkedInventory();
		if (linkedInventors != null)
			return linkedInventors.get(location);
		return null;
	}

    /**
     * Add amount teleported.
     *
     * @param add amount to add.
     */
    public void addCurrentTeleportedItems(final int add) {
        this.currentTeleportedItems += add;

    }

    /**
     * Retrieve current teleported amount.
     *
     * @return Returns the amount currently teleported.
     */
    public int getCurrentTeleportedItems() {
        return currentTeleportedItems;
    }

    /**
     * Reset the amount of teleported items.
     */
    public void resetCurrentTeleportedItems() {
        currentTeleportedItems = 0;
    }
}