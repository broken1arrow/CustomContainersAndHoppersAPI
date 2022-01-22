package org.brokenarrow.storage.api;

import org.brokenarrow.storage.util.TypeOfContainers;
import org.brokenarrow.storage.util.builderclass.ContainerData;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * All cached containers.
 */
public interface ContainerRegistryAPI {

	/**
	 * Get the ContainerRegistry instance.
	 *
	 * @return ContainerRegistry class instance.
	 */

	static ContainerRegistryAPI getInstance() {
		return ContainerRegistryAPI.getInstance();
	}

	/**
	 * Add container data to cache.
	 *
	 * @param location          location of the container.
	 * @param whoPlaced         ho some place the container.
	 * @param typeOfContainer   the containertype.
	 * @param containerFileName the yaml filename the conainer shall take settings from.
	 * @param currentUpdate     The current update off the container.
	 * @param pagesAmount       the amount off pages for the container.
	 */
	void addChest(Location location, UUID whoPlaced, TypeOfContainers.TypeOfContainer typeOfContainer, String containerFileName, String currentUpdate, int pagesAmount);

	/**
	 * Add link/suction container data to cache.
	 *
	 * @param location             location of the container.
	 * @param whoPlaced            ho some place the container.
	 * @param typeOfContainer      the containertype.
	 * @param containerFileName    the yaml filename the conainer shall take settings from.
	 * @param currentUpdate        The current update off the container.
	 * @param filterWhiteBlackList the defult if it shall bee black or white list as defult.
	 */
	void addHopperChestLinked(Location location, UUID whoPlaced, TypeOfContainers.TypeOfContainer typeOfContainer, String containerFileName, String currentUpdate, boolean filterWhiteBlackList);

	/**
	 * Remove container from both database and cache.
	 *
	 * @param location of the container.
	 */

	void removeContainer(Location location);

	/**
	 * Check if the container is registred on this location.
	 *
	 * @param location of the container.
	 * @return true if the container are registred.
	 */

	boolean isRegistered(Location location);

	/**
	 * Find a chest from locations.
	 *
	 * @param location of the container.
	 * @return map with all container data.
	 */
	ContainerData findChest(Location location);

	/**
	 * List of all containers locations.
	 *
	 * @return keyset of locations.
	 */

	Set<Location> getContainerlocations();

	/**
	 * Get all continers inside cache.
	 *
	 * @return map with location and all continerdata.
	 */

	Map<Location, ContainerData> getContainerDataMap();

	/**
	 * Get the chunks containers are placed in.
	 *
	 * @return chunk data.
	 */
	Set<Object> getChunkData();

	/**
	 * Save number of pages for this container
	 *
	 * @param location      of the container.
	 * @param numberOfPages the amount of pages to save.
	 */
	void setAmountOfPagesForContainer(Location location, int numberOfPages);

	/**
	 * Add data to cache
	 *
	 * @param location      of the container.
	 * @param containerData helpclass for save data to cache
	 * @param forceInData   overwrite data in cache (old data will be lost).
	 */
	void addContainerToCacheFromSQL(Location location, ContainerData containerData, boolean forceInData);

	/**
	 * Get the chest contents. For one container.
	 *
	 * @param location location of the container.
	 * @return the itemstacks for the container.
	 */

	ItemStack[] getContainercontents(Location location);

	/**
	 * Save container contents.
	 *
	 * @param location  of the container.
	 * @param itemStack the itemstacks some shall be saved
	 */
	void setContainercontents(Location location, ItemStack[] itemStack);

	/**
	 * Remove the contents for this container in cache.
	 *
	 * @param location location of the container.
	 */

	void removeContents(Location location);

	/**
	 * Get players uuid some place this container.
	 *
	 * @param location location of the container.
	 * @return player if it exist or null
	 */

	UUID getPlayerUUID(Location location);

	/**
	 * Get offlineplayer some place this container.
	 *
	 * @param location location of the container.
	 * @return player if it exist or null
	 */

	OfflinePlayer getOfflinePlayer(Location location);

	/**
	 * Get player some place this container.
	 *
	 * @param location location of the container.
	 * @return player if it exist or null
	 */

	Player getPlayer(Location location);

	/**
	 * Transform string name to typeOfcontainer enum.
	 *
	 * @param typeOfContainer string name of your containertype.
	 * @return the containertype enum.
	 */

	TypeOfContainers.TypeOfContainer transformStringToTypeofContainer(String typeOfContainer);

	/**
	 * check the chesttype of this container.
	 *
	 * @param typeOfContainer type of container.
	 * @return return the chesttype.
	 */

	String getTypeofContainer(String typeOfContainer);

	/**
	 * Get chesttype of this chest on specific location.
	 *
	 * @param location location of the container.
	 * @return return the chesttype.
	 */

	TypeOfContainers.TypeOfContainer getTypeofContainer(Location location);

	/**
	 * Get amount of pages this continer has.
	 *
	 * @param location location of the container.
	 * @return number of pages or 1 if it is null or less an 1.
	 */

	int getAmountOfPages(Location location);

	/**
	 * Get settings for specifc container,
	 * it use filename to find right settings.
	 *
	 * @param location location of the container.
	 * @return the Yaml filename for this container.
	 */

	String getContainerFileName(Location location);

	/**
	 * Get the filter items of the container. Used to black or white list items
	 * and recipe containers.
	 *
	 * @param location location of the container.
	 * @return the filter items or null/air if no items exist.
	 */
	ItemStack[] getFiltreritems(Location location);

	/**
	 * Set filteritems in cache for this container.
	 *
	 * @param location    location of the container.
	 * @param filteritems the items you want to add.
	 */

	void setFiltreritems(Location location, ItemStack[] filteritems);

	/**
	 * Set locations for the container has linked too.
	 *
	 * @param containerLocation the location of link container in cache.
	 * @param location          location of the container you has linked too.
	 */
	void setLinkContainerLinkedToLocation(Location containerLocation, Location location);

	/**
	 * Remove linked containers in cache.
	 *
	 * @param location          location of the container you has linked too.
	 * @param chestdatalocation the location of link container in cache.
	 */
	void removeLinkContainerLinkedToThisContainer(Location location, Location chestdatalocation);

	/**
	 * Get containers locations some is linked to link container.
	 *
	 * @param location of the link container.
	 * @return a list of containers some is linked from link container.
	 */

	List<Location> getLinkContainerLinkedToLocation(Location location);

	/**
	 * Get amount of items for storageunit
	 *
	 * @param location of the container.
	 * @return amount of items or 0 if it empty or null.
	 */

	BigInteger getAmontOfItems(Location location);

	/**
	 * Set amount of items continer have in cache.
	 *
	 * @param location   of the container.
	 * @param itemAmount amount of items.
	 */

	void setAmontOfItems(Location location, BigInteger itemAmount);

	/**
	 * Get current update of the container.
	 *
	 * @param location of the container.
	 * @return the curent update.
	 */

	String getCurrentUpdate(Location location);

	/**
	 * Set next update in cache. This plugin read from settings file inside folder Chest and hopper settings
	 * For a key you can see in one of the defult files.
	 *
	 * @param location    of the container.
	 * @param nextUpgrade set the upgrade name.
	 */
	void setNextUppdate(Location location, String nextUpgrade);

	/**
	 * Check if it set to white or black list of items.
	 *
	 * @param location of the container.
	 * @return true if it whitelist.
	 */
	boolean isFilterWhiteBlack(Location location);

	/**
	 * set if it shall be white or black list.
	 *
	 * @param location           of the container.
	 * @param isFilterWhiteBlack set it to true if you want white list.
	 */
	void setFilterWhiteBlack(Location location, boolean isFilterWhiteBlack);

	/**
	 * Get amount crafted total of the chest.
	 *
	 * @param location of the container.
	 * @return number of items it has crafted.
	 */

	long getTotalCraftAmount(Location location);

	/**
	 * Set amount of item crafted.
	 *
	 * @param location         of the container.
	 * @param totalCraftAmount total amount crafted.
	 */

	void setTotalCraftAmount(Location location, long totalCraftAmount);

	/**
	 * Get amount sold total of the chest.
	 *
	 * @param location of the container.
	 * @return number of items it has sold.
	 */

	double getTotalSoldAmount(Location location);

	/**
	 * Set amount of item sold. Will automatic add the old amount
	 * with the new amount.
	 *
	 * @param location        of the container.
	 * @param totalSoldAmount total amount sold.
	 */

	void setTotalSoldAmount(Location location, double totalSoldAmount);

	/**
	 * Get how maney items the hopper pick up on the ground.
	 *
	 * @param location of the container.
	 * @return number of items it has picked up.
	 */
	long getTotalAmountPickedUp(Location location);

	/**
	 * Set amount of item container pickup.
	 *
	 * @param location            of the container.
	 * @param totalAmountPickedUp total amount picked up.
	 */
	void setTotalAmountPickedUp(Location location, long totalAmountPickedUp);

	/**
	 * Get how many items the hopper has moved to a container.
	 *
	 * @param location of the container.
	 * @return amount of items hopper has move to container.
	 */

	long getTotalAmountTeleportedItems(Location location);

	/**
	 * Set amount of items teleported between containers.
	 *
	 * @param location                   of the container.
	 * @param totalAmountTeleportedItems amount of items teleported.
	 */
	void setTotalAmountTeleportedItems(Location location, long totalAmountTeleportedItems);

	/**
	 * Get amount items sold inside the container.
	 *
	 * @param location of the container.
	 * @return amount of items sold.
	 */

	long getTotalAmountSoldItems(Location location);

	/**
	 * Set amount of item is sold.
	 *
	 * @param location             of the container.
	 * @param totalAmountSoldItems amount of items teleported.
	 */

	void setTotalAmountSoldItems(Location location, long totalAmountSoldItems);

	/**
	 * Get time befor it reset the counter for free placements.
	 *
	 * @param location of the container.
	 * @return tiime left of the free placements.
	 */
	long getTimeBeforeReset(Location location);

	/**
	 * Set time on container before it reset the counter,
	 * for free placements.
	 *
	 * @param location of the container.
	 * @param time     the continer curently have.
	 */
	void setTimeBeforeReset(Location location, long time);

	/**
	 * Amount of placements for free.
	 *
	 * @param location of the container.
	 * @return amount of free placements.
	 */
	int getAmountPlaceForFree(Location location);

	/**
	 * Set amount free placements.
	 *
	 * @param location         of the container.
	 * @param amountPlacements you set for free.
	 */
	void setAmountPlaceForFree(Location location, int amountPlacements);
}
