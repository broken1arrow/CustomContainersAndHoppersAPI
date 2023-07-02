package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.containerholders.util.TypeOfContainer;
import org.brokenarrow.storage.api.containerholders.util.TypeOfFilter;
import org.brokenarrow.storage.api.containerholders.util.FilterItems;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ContainerDataApi {

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
	String getCurentUpgrade();

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
	 * @return amount  if pages this continer have.
	 */
	int getNumberOfPages();

	/**
	 * Get number of free placments.
	 *
	 * @return amount of free placments.
	 */
	int getAmountPlaceForFree();

	/**
	 * Get the number of items the continer have picked up.
	 *
	 * @return total amount.
	 */
	long getTotalAmountPickedUp();

	/**
	 * Get the number of items the continer have teleported.
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

	FilterItems getFilter();

	/**
	 * Get container contients (itemstacks).
	 *
	 * @return itemstaks or air if no item exist.
	 */
	ItemStack[] getChestContents();

	/**
	 * Get link and suction contianer all location it are linked too.
	 *
	 * @return list of location or null/empty list of not exist any locations.
	 */
	List<Location> getLinkContainerLinkedToLocation();

	/**
	 * Get total amount of items inside the container.
	 *
	 * @return amount of items the contriner have.
	 */
	BigInteger getAmountOfItems();

	/**
	 * Get instance of the builder class to get set values
	 * and change old values.
	 *
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder getBulder();

	/**
	 * Get the serilzed data from this file.
	 *
	 * @return map with the serialized data.
	 */
	Map<String, Object> serialize();

}

