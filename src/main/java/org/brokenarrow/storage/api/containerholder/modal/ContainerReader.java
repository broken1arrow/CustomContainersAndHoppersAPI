package org.brokenarrow.storage.api.containerholder.modal;

import org.brokenarrow.storage.api.containerholder.util.TypeOfContainer;
import org.brokenarrow.storage.api.containerholder.util.TypeOfFilter;
import org.brokenarrow.storage.api.containerholder.util.FilterItems;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * The container data set.
 */
public interface ContainerReader {

	/**
	 * Get the player some place the container.
	 *
	 * @return player uuid.
	 */
	UUID getPlayerId();

	/**
	 * Get the update of this container.
	 *
	 * @return current update.
	 */
	String getCurrentUpgrade();

	/**
	 * Get type of container.
	 *
	 * @return container type.
	 */
	TypeOfContainer getTypeOfContainer();

	/**
	 * Get Container FileName.
	 *
	 * @return container filename.
	 */
	String getContainerFileName();

	/**
	 * Get number of pages the container have.
	 *
	 * @return amount  if pages this container have.
	 */
	int getNumberOfPages();

	/**
	 * Get number of free placements.
	 *
	 * @return amount of free placements.
	 */
	int getRemainingFreePlacements();

	/**
	 * Get the number of items the container have picked up.
	 *
	 * @return total amount.
	 */
	long getTotalAmountPickedUp();

	/**
	 * Get the number of items the container have teleported.
	 *
	 * @return total amount.
	 */
	long getTotalAmountTeleportedItems();

	/**
	 * Get the number of items the continer have sold.
	 *
	 * @return total amount.
	 */
	long getTotalAmountItemsSold();

	/**
	 * Get the number of items the continer have crafted.
	 *
	 * @return total amount.
	 */
	long getTotalCraftAmount();

	/**
	 * Get time before it will reset free placement.
	 *
	 * @return total amount.
	 */
	long getTimeBeforeReset();

	/**
	 * Get the amount of money it have sold for.
	 *
	 * @return total amount.
	 */
	double getTotalSoldAmount();

	/**
	 * Get if it set to white or blacklist.
	 *
	 * @return true if it a whitelist.
	 */
	boolean isFilterWhiteBlack();

	/**
	 * Get if this container has a hopper
	 * below the container.
	 *
	 * @return true if is placed hopper below container
	 */
	boolean isHasHopperBelow();

	/**
	 * Get filteritems inside the white/blacklist gui.
	 *
	 * @return itemstaks or air if no item exist.
	 */
	ItemStack[] getFilterItems();

	/**
	 * Get type of filter used. If it shall match all meta, only the type
	 * or partial match the item (not all data on the item match).
	 *
	 * @return filter type.
	 */
	TypeOfFilter getFilterType();

	/**
	 * Retrieve the filter items.
	 *
	 * @return the FilterItems instance with the list of filter items.
	 */
	FilterItems getFilter();

	/**
	 * Get container contents (itemStacks).
	 *
	 * @return itemstacks or air if no item exist.
	 */
	ItemStack[] getChestContents();

	/**
	 * Get link and suction container all location it are linked too.
	 *
	 * @return list of location or null/empty list of not exist any locations.
	 */
	List<Location> getLinkedLocations();

	/**
	 * Get total amount of items inside the container.
	 *
	 * @return amount of items the container have.
	 */
	BigInteger getAmountOfItems();

    /**
     * Returns the minimum number of items that must remain
     * in this container after a transfer operation.
     *
     * @return  the reserve amount, zero means no minimum is enforced.
     */
    BigInteger getThreshold();

	/**
	 * Get the serilzed data from this file.
	 *
	 * @return map with the serialized data.
	 */
	Map<String, Object> serialize();

}

