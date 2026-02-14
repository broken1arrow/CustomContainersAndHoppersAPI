package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.containerholder.util.FilterItems;
import org.brokenarrow.storage.api.containerholder.util.TypeOfContainer;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * Interface to set and build the data.
 */
public interface ContainerWrite extends ContainerRead{

	/**
	 * Set the player some placed the container.
	 *
	 * @param playerId player uuid.
	 * @return builder instance.
	 */
	ContainerWrite setPlayerId(UUID playerId);

	/**
	 * Set update of this container. It used when read yaml file for get right update.
	 *
	 * @param upgrade name, use a yaml key to get the update.
	 * @return builder instance.
	 */
	ContainerWrite setUpgrade(String upgrade);

	/**
	 * Set Chesttype of this container.
	 *
	 * @param typeOfContainer type of container.
	 * @return builder instance.
	 */
	ContainerWrite setTypeOfContainer(TypeOfContainer typeOfContainer);

	/**
	 * The filename for this container type.
	 *
	 * @param containerFileName the yaml filename the conainer shall take settings from.
	 * @return builder instance.
	 */
	ContainerWrite setContainerFileName(String containerFileName);

	/**
	 * Set number of pages for this container
	 *
	 * @param numberOfPages the amount of pages to set.
	 * @return builder instance.
	 */
	ContainerWrite setNumberOfPages(int numberOfPages);

	/**
	 * Set amount free placements.
	 *
	 * @param remainingFreePlacements you set.
	 * @return builder instance.
	 */
	ContainerWrite setRemainingFreePlacements(int remainingFreePlacements);

	/**
	 * Set amount of item container pickup.
	 *
	 * @param totalAmountPickedUp total amount picked up.
	 * @return builder instance.
	 */
	ContainerWrite setTotalAmountPickedUp(long totalAmountPickedUp);

	/**
	 * Add amount of item container pickup.
	 *
	 * @param amountPickedUp total amount picked up.
	 * @return builder instance.
	 */
	ContainerWrite addTotalAmountPickedUp(long amountPickedUp);

	/**
	 * Set total amount of items teleported.
	 *
	 * @param totalAmountTeleportedItems total amount teleported items.
	 * @return builder instance.
	 */
	ContainerWrite setTotalAmountTeleportedItems(long totalAmountTeleportedItems);

	/**
	 * Add amount of items teleported.
	 *
	 * @param amountTeleportedItems total amount teleported items.
	 * @return builder instance.
	 */
	ContainerWrite addTotalAmountTeleportedItems(long amountTeleportedItems);

	/**
	 * Set total amount of items sold.
	 *
	 * @param totalAmountItemsSold total amount items sold.
	 * @return builder instance.
	 */
	ContainerWrite setTotalAmountItemsSold(long totalAmountItemsSold);

	/**
	 * Add amount of items sold.
	 *
	 * @param amountItemsSold total amount items sold.
	 * @return builder instance.
	 */
	ContainerWrite addTotalAmountItemsSold(long amountItemsSold);

	/**
	 * Set total amount of items crafted.
	 *
	 * @param totalCraftAmount total craft amount.
	 * @return builder instance.
	 */
	ContainerWrite setTotalCraftAmount(long totalCraftAmount);

	/**
	 * add amount of item crafted.
	 *
	 * @param craftAmount total amount crafted.
	 * @return builder instance.
	 */
	ContainerWrite addTotalCraftAmount(long craftAmount);

	/**
	 * Set time on container before it reset the counter,
	 * for free placements.
	 *
	 * @param timeBeforeReset the continer curently have.
	 * @return builder instance.
	 */
	ContainerWrite setTimeBeforeReset(long timeBeforeReset);

	/**
	 * Set amount of item sold.
	 *
	 * @param totalSoldAmount total amount sold.
	 * @return builder instance.
	 */
	ContainerWrite setTotalSoldAmount(double totalSoldAmount);

	/**
	 * Set amount of item sold.
	 *
	 * @param soldAmount amount sold.
	 * @return builder instance.
	 */
	ContainerWrite addTotalSoldAmount(double soldAmount);

	/**
	 * Set if it shall be white or black list.
	 *
	 * @param filterWhiteBlack set it to true if you want white list.
	 * @return builder instance.
	 */
	ContainerWrite setFilterWhiteBlack(boolean filterWhiteBlack);

	/**
	 * Set if this container has a hopper
	 * below the container.
	 *
	 * @param hasHopperBelow set to true if is placed hopper below container
	 * @return builder instance.
	 */
	ContainerWrite setHasHopperBelow(boolean hasHopperBelow);

	/**
	 * Set filteritems.
	 *
	 * @param filterItems the items you want to add.
	 * @return builder instance.
	 */
	ContainerWrite setFilterItems(FilterItems filterItems);

	/**
	 * Save container contents.
	 *
	 * @param chestContents the itemstacks some shall be saved
	 * @return builder instance.
	 */
	ContainerWrite setChestContents(ItemStack[] chestContents);

	/**
	 * Set locations for the container has linked too.
	 *
	 * @param linkContainerLinkedToLocation location of the container you has linked too.
	 * @return builder instance.
	 */
	ContainerWrite setLinkContainerLinkedToLocation(List<Location> linkContainerLinkedToLocation);

	/**
	 * Set amount of items continer have.
	 *
	 * @param amountOfItems amount of items.
	 * @return builder instance.
	 */
	ContainerWrite setAmountOfItems(BigInteger amountOfItems);

	/**
	 * Build your data you have changed and add to cache.
	 *
	 * @return the instance of ContainerDataApi.
	 */
	ContainerRead build();
}