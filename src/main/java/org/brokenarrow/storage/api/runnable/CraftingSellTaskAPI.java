package org.brokenarrow.storage.api.runnable;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface CraftingSellTaskAPI extends AddOrRemoveDataFromListAPI {

	void runCraftingSelltask();

	/**
	 * Get all keys in the crafting map.
	 *
	 * @return player UUID.
	 */
	Set<UUID> getKeysetCrafting();

	/**
	 * Get all items player have crafted in the map.
	 *
	 * @param uuid player UUID
	 * @return matrial player has crafted and amount.
	 */
	Map<Material, CraftingtasksAPI> getMapCrafting(UUID uuid);

	/**
	 * Remove player from map.
	 *
	 * @param uuid player UUID
	 */
	void removePlayerFromCraftingCache(UUID uuid);

	/**
	 * Clear all player´s from map.
	 */
	void clearPlayerFromCraftingCache();

	/**
	 * Get if it have finish crafing one item.
	 *
	 * @return true if it have finish craft one item.
	 */
	boolean isFinishCrafting();

	/**
	 * Get all items player have sold in the map.
	 *
	 * @param uuid player UUID
	 * @return matrial player has sold and amount.
	 */
	Map<Material, SelltasksAPI> getSellMatrial(UUID uuid);

	/**
	 * Get all keys in the sell map.
	 *
	 * @return player UUID.
	 */
	Set<UUID> getKeysetSell();

	/**
	 * Remove player from map.
	 *
	 * @param uuid player UUID
	 */
	void removePlayerInSellMap(UUID uuid);

	/**
	 * Clear all player´s from map.
	 */
	void clearPlayerInSellMap();

	/**
	 * Check if map is empty.
	 *
	 * @param player you want to check.
	 * @return true if the map is empty.
	 */
	boolean sellmapIsEmpty(Player player);

	void RemoveItemSell(Player player, Material material);
}
