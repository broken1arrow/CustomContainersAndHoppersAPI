package org.brokenarrow.storage.api.runnable;

public interface AddItemsToStorageUnitAPI extends AddOrRemoveDataFromListAPI {

	void runTask();

	/**
	 * If it have check the container for items and
	 * can add more items.
	 *
	 * @return true if it have check the inventory.
	 */
	default boolean isHasCheckInventory() {
		return false;
	}

	/**
	 * Set if it have check container.
	 *
	 * @param hasCheckInventory true if it have check container.
	 */
	default void setHasCheckInventory(boolean hasCheckInventory) {
	}
}
