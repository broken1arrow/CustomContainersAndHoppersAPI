package org.brokenarrow.storage.api.util.builderclass;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nullable;
import java.util.Map;

public class TeleportWraper {
	private final Map<Location, Inventory> cachedLinkedInventory;
	private final Inventory cachedContainerInventory;
	private final int locationNumberInList;
	private final int lastNumberInList;
	private final boolean teleportedItems;
	private final Builder builder;

	private TeleportWraper(final Builder builder) {
		this.cachedLinkedInventory = builder.cachedLinkedInventory;
		this.cachedContainerInventory = builder.cachedContainerInventory;
		this.locationNumberInList = builder.locationNumberInList;
		this.lastNumberInList = builder.lastNumberInList;
		this.teleportedItems = builder.teleportedItems;
		this.builder = builder;
	}

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

	public int getLocationNumberInList() {
		return locationNumberInList;
	}


	public boolean isTeleportedItems() {
		return teleportedItems;
	}

	/**
	 * The map with all locations and inventorys for this
	 * link and suction container.
	 *
	 * @return the map with all cached inventorys.
	 * @apiNote This is not a treadsafe map.
	 */
	@Nullable
	public Map<Location, Inventory> getCachedLinkedInventory() {
		return cachedLinkedInventory;
	}

	/**
	 * Get the linked inventory from cache.
	 *
	 *
	 * @param location of the contaner that are linked to the link and suction container.
	 * @return the inventory or null if it not exist.
	 * @apiNote This is not a treadsafe map you access.
	 */
	@Nullable
	public Inventory getCachedLinkedInventory(final Location location) {
		final Map<Location, Inventory> linkedInventorys = this.getCachedLinkedInventory();
		if (linkedInventorys != null)
			return linkedInventorys.get(location);
		return null;
	}

	public Builder getBuilder() {
		return builder;
	}

	public static class Builder {

		private Map<Location, Inventory> cachedLinkedInventory;
		private Inventory cachedContainerInventory;
		private int locationNumberInList;
		private int lastNumberInList;
		private boolean teleportedItems;

		public Builder setCachedLinkedInventory(final Map<Location, Inventory> cachedLinkedInventory) {
			this.cachedLinkedInventory = cachedLinkedInventory;
			return this;
		}

		public Builder setCachedContainerInventory(final Inventory cachedContainerInventory) {
			this.cachedContainerInventory = cachedContainerInventory;
			return this;
		}

		public Builder setLocationNumberInList(final int locationNumberInList) {
			this.locationNumberInList = locationNumberInList;
			return this;
		}

		public Builder setLastNumberInList(final int lastNumberInList) {
			this.lastNumberInList = lastNumberInList;
			return this;
		}

		public Builder setTeleportedItems(final boolean teleportedItems) {
			this.teleportedItems = teleportedItems;
			return this;
		}

		public TeleportWraper build() {
			return new TeleportWraper(this);
		}
	}

}