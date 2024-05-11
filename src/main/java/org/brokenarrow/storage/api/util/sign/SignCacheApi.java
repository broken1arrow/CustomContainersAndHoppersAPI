package org.brokenarrow.storage.api.util.sign;

import org.brokenarrow.storage.api.builders.PreferenceSettingsDataAPI;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Interface for managing sign caches.
 */
public interface SignCacheApi {

	/**
	 * Gets a map of all signs in the cache.
	 *
	 * @return A map containing the locations of signs and their associated data.
	 */
	Map<Location, SignData> getSigns();

	/**
	 * Removes a sign from the cache.
	 *
	 * @param location The location of the sign to remove.
	 */
	void removeSign(Location location);

	/**
	 * Retrieves sign data for a specified location.
	 *
	 * @param location The location of the sign.
	 * @return The sign data associated with the specified location, or null if not found.
	 */
	SignData getSign(Location location);

	/**
	 * Adds sign data to the cache.
	 *
	 * @param location The location of the sign.
	 * @param signData The sign data to add.
	 */
	void putSign(Location location, SignData signData);

	/**
	 * Places a sign based on a player interaction event.
	 *
	 * @param event  The PlayerInteractEvent triggering the sign placement.
	 * @param player The player placing the sign.
	 */
	void placeSign(PlayerInteractEvent event, org.bukkit.entity.Player player);

	/**
	 * Places a sign at the specified location with the given item stack and amount.
	 *
	 * @param location  The location to place the sign.
	 * @param itemStack The item stack representing the sign.
	 * @param amount    The amount associated with the sign.
	 * @param player    The player placing the sign.
	 */
	void placeSign(@NotNull Location location, ItemStack itemStack, String amount, org.bukkit.entity.Player player);

	/**
	 * Attempts to automatically place a sign at the specified location based on player preferences.
	 *
	 * @param location        The location to place the sign.
	 * @param playerSettings  The player's preference settings.
	 * @param itemStack       The item stack representing the sign.
	 * @param amount          The amount associated with the sign.
	 * @return True if the sign was successfully placed, false otherwise.
	 */
	boolean placeSignAuto(@NotNull Location location, PreferenceSettingsDataAPI playerSettings, ItemStack itemStack, String amount);

	/**
	 * Manually places a sign at the specified location based on player preferences.
	 *
	 * @param location        The location to place the sign.
	 * @param playerSettings  The player's preference settings.
	 * @param itemStack       The item stack representing the sign.
	 * @return True if the sign was successfully placed, false otherwise.
	 */
	boolean placeSignManual(Location location, PreferenceSettingsDataAPI playerSettings, @Nullable ItemStack itemStack);
}
