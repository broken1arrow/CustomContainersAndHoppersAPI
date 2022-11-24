package org.brokenarrow.storage.api.containerholders.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;

public class ItemMetadataUtillity {

	/**
	 * Get type of container it is.
	 *
	 * @param item the itemstack to check.
	 * @return the id or null if the item do not have the value.
	 */
	public static String getContainerId(final ItemStack item) {
		return null;
	}

	/**
	 * Get the filename  for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the filename or null if the item do not have the value.
	 */
	public static String getContainerFileName(final ItemStack item) {
		return null;

	}

	/**
	 * Get the upgrade for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the  upgrade or null if the item do not have the value.
	 */
	public static String getContainerUpgrade(final ItemStack item) {
		return null;

	}

	/**
	 * Get the contents for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the contents or null if the item do not have the value. It will be base64 string you need convert.
	 */
	public static String getContainerContents(final ItemStack item) {
		return null;
	}

	/**
	 * Get the amount of pages for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the amount of pages or null if the item do not have the value.
	 */
	public static String getContainerPagesAmount(final ItemStack item) {
		return null;
	}

	/**
	 * Get the amount of items for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the amount or 0 if the item do not have the value.
	 */
	public static BigInteger getContainerAmountOfItems(final ItemStack item) {
		return null;
	}

	/**
	 * Get the filter contents for this container.
	 *
	 * @param item the itemstack to check.
	 * @return the filter contents or null if the item do not have the value. It will be base64 string you need convert.
	 */
	public static String getContainerFilterContents(final ItemStack item) {
		return null;
	}

	/**
	 * Get if filter is set to black or white for this container.
	 *
	 * @param item the itemstack to check.
	 * @return true if it white list or false if it is black list alternatively the item do not have the value.
	 */
	public static boolean isContainerBlackOrWhite(final ItemStack item) {
		return false;
	}

	/**
	 * Get container owner for this container.
	 *
	 * @param item the itemstack to check.
	 * @return container owner or null if the item do not have the value.
	 */
	public static String getContainerOwner(final ItemStack item) {
		return null;
	}

	/**
	 * Get the time left before reset free placements for this container.
	 *
	 * @param item the itemstack to check.
	 * @return time or 0 if the item do not have the value.
	 */
	public static long getTimeLeftBeforeResetFreePlacements(final ItemStack item) {
		return 0;
	}

	/**
	 * Get the amount of free placements for this container.
	 *
	 * @param item the itemstack to check.
	 * @return placements or 0 if the item do not have the value.
	 */
	public static int getAmountOfFreePlacements(final ItemStack item) {
		return 0;
	}

	/**
	 * Get the location player, if it set or null.
	 *
	 * @param player to check for metadata.
	 * @return location for the container player open or null if player not has the value set.
	 */
	public static Location getLocation(final Player player) {
		return null;
	}

	/**
	 * Set the location player.
	 *
	 * @param player   to check for metadata.
	 * @param location location you want to set.
	 */
	public static void setLocation(final Player player, final Location location) {
	}

	/**
	 * Remove the location player.
	 *
	 * @param player you want to remove metadata.
	 */
	public static void removeLocation(final Player player) {
	}

	/**
	 * Set the metadata on player.
	 *
	 * @param player   you set the metadata on.
	 * @param metadata you want to set.
	 */
	public static void removeMetaData(final Player player, final String metadata) {

	}

	/**
	 * Set the metadata on player.
	 *
	 * @param player you set the metadata on.
	 * @param key    key for this metadata set.
	 * @param value  you want to set.
	 */
	public static void setMetaData(final Player player, final String key, final String value) {
	}

	/**
	 * Set the metadata on player.
	 *
	 * @param player you set the metadata on.
	 * @param key    key for this metadata set.
	 * @param value  object you want to set.
	 */
	public static void setMetaData(final Player player, final String key, final Object value) {
	}
}
