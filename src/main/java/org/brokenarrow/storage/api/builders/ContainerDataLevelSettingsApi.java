package org.brokenarrow.storage.api.builders;

import java.util.List;

public interface ContainerDataLevelSettingsApi {

	/**
	 * Get what type container it is.
	 *
	 * @return the type of container.
	 * @see org.brokenarrow.storage.api.containerholders.util.TypeOfContainer
	 */
	String getContainerType();

	/**
	 * Get icon type this container type have.
	 *
	 * @return item enum name.
	 */
	String getIcon();

	/**
	 * Name it will have both as title inside inventory
	 * and as display mame when is a item.
	 *
	 * @return text you want to have as title.
	 */
	String getDisplayName();

	/**
	 * get limit of amount of items, are used for storage unit/container.
	 * <p>
	 * If method return -1 it will be unlimit amount and everything over 1 limit
	 * the amount of items.
	 *
	 * @return aomut of items max can be stored.
	 */
	String getLimitAmontOfItems();

	/**
	 * Get update key for this container.
	 *
	 * @return upgrade name.
	 */
	String getUppgrade();

	/**
	 * Get the max range it will pick up items.
	 * <p>
	 * If you want one chunk, set it to -1 or -1,2 if you want 9 chunks insted of
	 * only one (you can use biger number for example -1,5 it vill be 5 x biger area).
	 * Be carefully to not set the area too big it can cuse lag on the server.
	 * Set to -2 to disable or for example 5,8,5 will it be in blocks arund the container.
	 *
	 * @return the suction range.
	 */
	String getSuctionRange();

	/**
	 * Set how much cost shall increase in percent. For every updated
	 *
	 * @return aomunt of percent it will increase.
	 */
	String getExpandCostUpgradePages();

	/**
	 * Get lore on the item.
	 *
	 * @return list of text.
	 */
	List<String> getLore();

	/**
	 * Get effect when it pick up items
	 *
	 * @return ParticleEffect class.
	 */
	ParticleEffectApi getPickupEffect();

	/**
	 * Get effect on the suction border.
	 *
	 * @return ParticleEffect class.
	 */
	ParticleEffectApi getBorderEffect();

	/**
	 * Get cost for upgrade the container.
	 *
	 * @return cost with decimals.
	 */
	double getCostUpgrade();


	/**
	 * Get size on the inventory.
	 *
	 * @return size of the inventory.
	 */
	int getGuiSize();

	/**
	 * Get defult amount of pages container have.
	 *
	 * @return amount of pages.
	 */
	int getNumberOfPages();

	/**
	 * Get dropmode for the container.
	 * 1 Will dropp items on grund.
	 * 2 It will be stored "inside" the container.
	 *
	 * @return a number.
	 */
	int getWhenBrakeContainer();

	/**
	 * Get max range you can link your link/suction container to the container you link.
	 *
	 * @return number of blocks away the container you link to can be.
	 */
	int getLinkedRange();

	/**
	 * Get max amount of links you can do with this container.
	 *
	 * @return amount of links you can have.
	 */
	int getAmontOfLinks();

	/**
	 * Get max amount of pages the container can have.
	 *
	 * @return amount of pages the container can have max.
	 */
	int getMaxOfPages();


	/**
	 * Get how often it will run task
	 *
	 * @return amount in seconds
	 */
	int getRunTimedTask();

	/**
	 * Get if item shall glow or not in inventory.
	 *
	 * @return true if item shall have glow effect.
	 */
	boolean isDefultGlowOnOff();


	/**
	 * Get sellmode for container.
	 *
	 * @return true if this continer sel items.
	 */
	boolean isSellModeForContainer();


}
