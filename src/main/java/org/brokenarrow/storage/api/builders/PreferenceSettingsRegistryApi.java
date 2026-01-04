package org.brokenarrow.storage.api.builders;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Cache for players settings and party list of players
 */
public interface PreferenceSettingsRegistryApi {

	/**
	 * Retrieve all players set preferences.
	 * @return returns the map with the players preferences.
	 */
	@Nonnull
	Map<UUID, PreferenceSettingsDataAPI> getAllSettingsData();

	/**
	 * Retrieve the players set preferences.
	 *
	 * @param player the player you want to get the settings.
	 * @return returns the players preferences.
	 */
	@Nullable
	PreferenceSettingsDataAPI getPlayerSettings(Player player);

	/**
	 * Retrieve the players set preferences.
	 *
	 * @param uuid the player from the uuid.
	 * @return returns the players preferences.
	 */
	@Nullable
	PreferenceSettingsDataAPI getPlayerSettings(UUID uuid);

    /**
     * Adds or updates a player's preference data in the cache.
     * <p>
     * The provided callback is invoked to modify the player's preferences
     * before they are stored.
     *
     * @param player the player whose preferences should be cached;
     *               the player's UUID will be used as the cache key
     * @param preferencesCallback a callback used to modify the player's
     *                            preference settings
     */
	void setInCache(final Player player, final Consumer<PreferenceSettingModify> preferencesCallback);

    /**
     * Adds or updates a player's preference data in the cache.
     * <p>
     * The provided callback is invoked to modify the player's preferences
     * before they are stored.
     *
     * @param uuid the UUID of the player whose preferences should be cached
     * @param preferencesCallback a callback used to modify the player's
     *                            preference settings
     */
	void setInCache(final UUID uuid, final Consumer<PreferenceSettingModify> preferencesCallback);
	
	/**
	 * Add player to cache.
	 *
	 * @param playerUUID    player you want to add.
	 * @param preferenceSettings  data player has
	 * @param forceLoadData if you want to override old data in cache (old data will be lost).
	 */

	void setPlayerData(UUID playerUUID, PreferenceSettingsDataAPI preferenceSettings, boolean forceLoadData);

	/**
	 * Get the party-list of players, player currently have.
	 *
	 * @param player you want tog get the party-list from.
	 * @return list of players or if not exist empty arraylist.
	 */

	List<UUID> getPlayersFromParty(Player player);

	/**
	 * Get the partylist of players, player curently have.
	 *
	 * @param playerUuid you want tog get the partylist from.
	 * @return list of players or if not exist empty arraylist.
	 */
	List<UUID> getPlayersFromParty(UUID playerUuid);

	/**
	 * Remove a player from party-list.
	 *
	 * @param player      some has added player.
	 * @param addedPlayer the player some has joined party.
	 */
	void removePlayerFromParty(Player player, UUID addedPlayer);
	
	/**
	 * Remove a player from party-list.
	 *
	 * @param player      some has added player.
	 * @param addedPlayer the player some has joined party.
	 */
	void removePlayerFromParty(UUID player, UUID addedPlayer);
	
	/**
	 * Remove all players in the party-list
	 *
	 * @param player some this cache contains.
	 */
	void removeAllPlayer(Player player);
	
	/**
	 * Remove all players in the party-list
	 *
	 * @param player some this cache contains.
	 */
	void removeAllPlayer(UUID player);
	
	/**
	 * add a player to the party-list
	 *
	 * @param player      some add the player to the party-list.
	 * @param addedPlayer the player some shall be added.
	 */

	void addPlayerToParty(Player player, Player addedPlayer);
	
	/**
	 * add a player to the party-list
	 *
	 * @param player      some add the player to the party-list.
	 * @param addedPlayer the player some shall be added.
	 */
	
	void addPlayerToParty(UUID player, OfflinePlayer addedPlayer);
	
	
	/**
	 * add a player to the party-list some are offline.
	 *
	 * @param player      some add the player to the party-list.
	 * @param addedPlayer the player some shall be added.
	 */
	void addPlayerToParty(Player player, OfflinePlayer addedPlayer);

}
