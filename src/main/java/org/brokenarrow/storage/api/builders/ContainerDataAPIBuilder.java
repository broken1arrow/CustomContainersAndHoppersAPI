package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.containerholders.util.TypeOfContainer;
import org.brokenarrow.storage.api.containerholders.util.FilterItem;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * Helpclass to build your data.
 */
public interface ContainerDataAPIBuilder {
	/**
	 * Set the player some placed the container.
	 *
	 * @param playerId player uuid.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setPlayerId(UUID playerId);

	/**
	 * Set update of this container. It used when read yaml file for get right update.
	 *
	 * @param upgrade name, use a yaml key to get the update.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setUpgrade(String upgrade);

	/**
	 * Set Chesttype of this container.
	 *
	 * @param typeOfContainer type of container.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setTypeOfContainer(TypeOfContainer typeOfContainer);

	/**
	 * The filename for this container type.
	 *
	 * @param containerFileName the yaml filename the conainer shall take settings from.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setContainerFileName(String containerFileName);

	/**
	 * Set number of pages for this container
	 *
	 * @param numberOfPages the amount of pages to set.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setNumberOfPages(int numberOfPages);

	/**
	 * Set amount free placements.
	 *
	 * @param amountPlaceForFree you set.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setAmountPlaceForFree(int amountPlaceForFree);

	/**
	 * Set amount of item container pickup.
	 *
	 * @param totalAmountPickedUp total amount picked up.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setTotalAmountPickedUp(long totalAmountPickedUp);

	/**
	 * Add amount of item container pickup.
	 *
	 * @param amountPickedUp total amount picked up.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder addTotalAmountPickedUp(long amountPickedUp);

	/**
	 * Set total amount of items teleported.
	 *
	 * @param totalAmountTeleportedItems total amount teleported items.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setTotalAmountTeleportedItems(long totalAmountTeleportedItems);

	/**
	 * Add amount of items teleported.
	 *
	 * @param amountTeleportedItems total amount teleported items.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder addTotalAmountTeleportedItems(long amountTeleportedItems);

	/**
	 * Set total amount of items sold.
	 *
	 * @param totalAmountItemsSold total amount items sold.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setTotalAmountItemsSold(long totalAmountItemsSold);

	/**
	 * Add amount of items sold.
	 *
	 * @param amountItemsSold total amount items sold.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder addTotalAmountItemsSold(long amountItemsSold);

	/**
	 * Set total amount of items crafted.
	 *
	 * @param totalCraftAmount total craft amount.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setTotalCraftAmount(long totalCraftAmount);

	/**
	 * add amount of item crafted.
	 *
	 * @param craftAmount total amount crafted.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder addTotalCraftAmount(long craftAmount);

	/**
	 * Set time on container before it reset the counter,
	 * for free placements.
	 *
	 * @param timeBeforeReset the continer curently have.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setTimeBeforeReset(long timeBeforeReset);

	/**
	 * Set amount of item sold.
	 *
	 * @param totalSoldAmount total amount sold.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setTotalSoldAmount(double totalSoldAmount);

	/**
	 * Set amount of item sold.
	 *
	 * @param soldAmount amount sold.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder addTotalSoldAmount(double soldAmount);

	/**
	 * Set if it shall be white or black list.
	 *
	 * @param filterWhiteBlack set it to true if you want white list.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setFilterWhiteBlack(boolean filterWhiteBlack);

	/**
	 * Set if this container has a hopper
	 * below the container.
	 *
	 * @param hasHopperBelow set to true if is placed hopper below container
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setHasHopperBelow(boolean hasHopperBelow);

	/**
	 * Set filteritems.
	 *
	 * @param filterItems the items you want to add.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setFilterItems(FilterItem filterItems);

	/**
	 * Save container contents.
	 *
	 * @param chestContents the itemstacks some shall be saved
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setChestContents(ItemStack[] chestContents);

	/**
	 * Set locations for the container has linked too.
	 *
	 * @param linkContainerLinkedToLocation location of the container you has linked too.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setLinkContainerLinkedToLocation(List<Location> linkContainerLinkedToLocation);

	/**
	 * Set amount of items continer have.
	 *
	 * @param amountOfItems amount of items.
	 * @return builder instance.
	 */
	ContainerDataAPIBuilder setAmountOfItems(BigInteger amountOfItems);

	ContainerDataApi build();
}