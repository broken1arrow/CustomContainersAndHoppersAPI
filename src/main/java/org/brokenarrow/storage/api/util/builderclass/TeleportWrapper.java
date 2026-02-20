package org.brokenarrow.storage.api.util.builderclass;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper class for teleport items.
 */
public class TeleportWrapper {
	private  Map<Location, Inventory> cachedLinkedInventory = new HashMap<>();
	private  Inventory cachedContainerInventory;
	private  int locationNumberInList;
	private  int lastNumberInList;
	private  boolean teleportedItems;
    private int addCurrentTeleportedItems;

    /**
     * Sets the cached linked inventory map.
     *
     * @param cachedLinkedInventory The map containing cached linked inventories.
     * @return The builder instance.
     */
    public TeleportWrapper setCachedLinkedInventory(final Map<Location, Inventory> cachedLinkedInventory) {
        this.cachedLinkedInventory = cachedLinkedInventory;
        return this;
    }

    /**
     * Sets the cached container inventory.
     *
     * @param cachedContainerInventory The cached container inventory.
     * @return The builder instance.
     */
    public TeleportWrapper setCachedContainerInventory(final Inventory cachedContainerInventory) {
        this.cachedContainerInventory = cachedContainerInventory;
        return this;
    }

    /**
     * Sets the location number in the list.
     *
     * @param locationNumberInList The location number in the list.
     * @return The builder instance.
     */
    public TeleportWrapper setLocationNumberInList(final int locationNumberInList) {
        this.locationNumberInList = locationNumberInList;
        return this;
    }

    /**
     * Sets the last number in the list.
     *
     * @param lastNumberInList The last number in the list.
     * @return The builder instance.
     */
    public TeleportWrapper setLastNumberInList(final int lastNumberInList) {
        this.lastNumberInList = lastNumberInList;
        return this;
    }

    /**
     * Sets whether items were teleported.
     *
     * @param teleportedItems True if items were teleported, false otherwise.
     * @return The builder instance.
     */
    public TeleportWrapper setTeleportedItems(final boolean teleportedItems) {
        this.teleportedItems = teleportedItems;
        return this;
    }


    /**
	 * Gets the last number in the list.
	 *
	 * @return The last number in the list.
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
	 * Gets the location number in the list.
	 *
	 * @return The location number in the list.
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
	 * The map with all locations and inventory's for this
	 * link and suction container.
	 * <p>
	 * This is not a tread safe map.
	 *
	 * @return the map with all cached inventory's.
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

    public void addCurrentTeleportedItems(final int add) {
        this.addCurrentTeleportedItems += add;

    }

    public int getAddCurrentTeleportedItems() {
        return addCurrentTeleportedItems;
    }

    public void clearAddCurrentTeleportedItems() {
        addCurrentTeleportedItems = 0;
    }
}