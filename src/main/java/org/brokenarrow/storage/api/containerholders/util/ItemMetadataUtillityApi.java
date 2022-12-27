package org.brokenarrow.storage.api.containerholders.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;

public interface ItemMetadataUtillityApi {

	/**
	 * Get type of container it is.
	 *
	 * @param item the itemstack to check.
	 * @return the id or null if the item do not have the value.
	 */
	String getContainerId(final ItemStack item);

	/**
	 * Get the filename  for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the filename or null if the item do not have the value.
	 */
	String getContainerFileName(final ItemStack item);

	/**
	 * Get the upgrade for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the  upgrade or null if the item do not have the value.
	 */
	String getContainerUpgrade(final ItemStack item);

	/**
	 * Get the contents for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the contents or null if the item do not have the value. It will be base64 string you need convert.
	 */
	String getContainerContents(final ItemStack item);

	/**
	 * Get the amount of pages for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the amount of pages or null if the item do not have the value.
	 */
	String getContainerPagesAmount(final ItemStack item);

	/**
	 * Get the amount of items for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the amount or 0 if the item do not have the value.
	 */
	BigInteger getContainerAmountOfItems(final ItemStack item);

	/**
	 * Get the filter contents for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the filter contents or null if the item do not have the value. It will be base64 string you need convert.
	 */
	String getContainerFilterContents(final ItemStack item);

	/**
	 * Get if filter is set to black or white for this container.
	 *
	 * @param item the itemstack to check.
	 * @return true if it white list or false if it is black list alternatively the item do not have the value.
	 */
	boolean isContainerBlackOrWhite(final ItemStack item);

	/**
	 * Get container owner for this container.
	 *
	 * @param item the itemstack to check.
	 * @return container owner or null if the item do not have the value.
	 */
	String getContainerOwner(final ItemStack item);

	/**
	 * Get the time left before reset free placements for this container.
	 *
	 * @param item the itemstack to check.
	 * @return time or 0 if the item do not have the value.
	 */
	long getTimeLeftBeforeResetFreePlacements(final ItemStack item);

	/**
	 * Get the amount of free placements for this container.
	 *
	 * @param item the itemstack to check.
	 * @return placements or 0 if the item do not have the value.
	 */
	int getAmountOfFreePlacements(final ItemStack item);

	/**
	 * Get the location player, if it set or null.
	 *
	 * @param player to check for metadata.
	 * @return location for the container player open or null if player not has the value set.
	 */
	Location getLocation(final Player player);

	/**
	 * Set the location player.
	 *
	 * @param player   to check for metadata.
	 * @param location location you want to set.
	 */
	void setLocation(final Player player, final Location location);

	/**
	 * Remove the location player.
	 *
	 * @param player you want to remove metadata.
	 */
	void removeLocation(final Player player);

	/**
	 * Set the metadata on player.
	 *
	 * @param player   you set the metadata on.
	 * @param metadata you want to set.
	 */
	void removeMetaData(final Player player, final String metadata);

	/**
	 * Set the metadata on player.
	 *
	 * @param player you set the metadata on.
	 * @param key    key for this metadata set.
	 * @param value  you want to set.
	 */
	void setMetaData(final Player player, final String key, final String value);

	/**
	 * Set the metadata on player.
	 *
	 * @param player you set the metadata on.
	 * @param key    key for this metadata set.
	 * @param value  object you want to set.
	 */
	void setMetaData(final Player player, final String key, final Object value);
}
