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
	
	void setInCache(final Player player, final Consumer<PreferenceSettingModify> preferencesCallback);
	
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

	/**
	 * if player has suction border on or off.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isShowSuctionBorderWhenPlaceContainer(UUID player);

	/**
	 * set true or false if it shall show the border when placed.
	 *
	 * @param player                              some has set this setting.
	 * @param showBorderSuctionWhenPlaceContainer set it to true if you want to show border.
	 */
	void setShowSuctionBorderWhenPlaceContainer(Player player, boolean showBorderSuctionWhenPlaceContainer);

	/**
	 * if player has holograms on or off.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isShowHologramsOnPlacedContainer(Player player);

	/**
	 * if player has holograms on or off.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isShowHologramsOnPlacedContainer(UUID player);

	/**
	 * set true or false if it shall show the holograms.
	 *
	 * @param player                         some has set this setting.
	 * @param showHologramsOnPlacedContainer set it to true if you want to show holograms.
	 */
	void setShowHologramsOnPlacedContainer(final UUID player, boolean showHologramsOnPlacedContainer);

	/**
	 * if player has time on or off. If this is true
	 * player will have limit time before it turn of
	 * automatic.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isTimerSettingWhenLinkHopper(UUID player);

	/**
	 * Set true if it shall automatically turn off linkmode.
	 *
	 * @param player        some has set this setting.
	 * @param timmerOnOrOff set it to true if you want to automatic turn off linkmode.
	 */
	void setTimerSettingWhenLinkHopper(Player player, boolean timmerOnOrOff);

	/**
	 * If this is true random particle effects will spawn on the
	 * container.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isEffectsOnContainer(UUID player);

	/**
	 * Set if it shall spawn particles on these players
	 * containers.
	 *
	 * @param player            some has set this setting.
	 * @param effectOnContainer set to true if you want to spawn effects.
	 */
	void setEffectsOnContainer(Player player, boolean effectOnContainer);

	/**
	 * If this is true it will spawn effects on container when player place it.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isEffectsOnContainerWhenPlace(UUID player);

	/**
	 * If this is true it will spawn effects on container when player place it.
	 *
	 * @param player                     some has set this setting.
	 * @param effectOnContainerWhenPlace set to true if you want to spawn effects.
	 */
	void setEffectsOnContainerWhenPlace(Player player, boolean effectOnContainerWhenPlace);

	/**
	 * if it shall show effects when craft items.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isShowEffectsWhenCrafItems(UUID player);

	/**
	 * Set if it shall show effects when craft.
	 *
	 * @param player                   some has set this setting.
	 * @param showEffectsWhenCrafItems set to true if you want to spawn effects.
	 */
	void setShowEffectsWhenCrafItems(Player player, boolean showEffectsWhenCrafItems);

	/**
	 * if it shall show effects when sell items.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isShowEffectsWhenSellItems(UUID player);

	/**
	 * Set if it shall show effects when sold.
	 *
	 * @param player                   some has set this setting.
	 * @param showEffectsWhenSellItems set to true if you want to spawn effects.
	 */
	void setShowEffectsWhenSellItems(Player player, boolean showEffectsWhenSellItems);

	/**
	 * If this is true, it will play a sound when crafted.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenCrafItems(UUID player);

	/**
	 * If this is true, it will play a sound when crafted.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenCrafItems(OfflinePlayer player);

	/**
	 * Set if it shall play a sound when craft.
	 *
	 * @param player                    some has set this setting.
	 * @param soundEffectsWhenCraftItems set to true if you want to have sound effect when container craft items.
	 */
	void setSoundEffectsWhenCraftItems(Player player, boolean soundEffectsWhenCraftItems);

	/**
	 * If this is true, it will play a sound when sell.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenSellItems(UUID player);

	/**
	 * Set if it shall play a sound when sell items.
	 *
	 * @param player                    some has set this setting.
	 * @param soundEffectsWhenSellItems set to true if you want to have sound effect when container sell items.
	 */
	void setSoundEffectsWhenSellItems(Player player, boolean soundEffectsWhenSellItems);

	/**
	 * If this is true,it will play a sound when open container.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenOpenClose(UUID player);

	/**
	 * Set if it shall play a sound when open container.
	 *
	 * @param player                    some has set this setting.
	 * @param soundEffectsWhenOpenClose set to true if you want to have sound effect when open container.
	 */
	void setSoundEffectsWhenOpenClose(Player player, boolean soundEffectsWhenOpenClose);

	/**
	 * If this is true,it will show the owner of the container
	 * on the hologram.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isDisplayPlayerNameOnHolo(UUID player);


	/**
	 * Set if you want to show the owner of the container or not.
	 *
	 * @param player                  some has set this setting.
	 * @param displayPlayerNameOnHolo set to true if you want to show the owner.
	 */
	void setDisplayPlayerNameOnHolo(Player player, boolean displayPlayerNameOnHolo);

	/**
	 * If it shall play sound when pick up items.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenContainerPickUpItems(UUID player);

	/**
	 * Sett if it shall play sound or not when the container pick up items.
	 *
	 * @param player                               some has set this setting.
	 * @param soundEffectsWhenContainerPickUpItems set to true if you want a sound when pick up items.
	 */
	void setSoundEffectsWhenContainerPickUpItems(Player player, boolean soundEffectsWhenContainerPickUpItems);

	/**
	 * If it shall play sound when place the container.
	 *
	 * @param player some has set this setting.
	 * @return true if the player has it on.
	 */
	boolean isSoundEffectsWhenPlaceContainer(UUID player);

	/**
	 * Sett if it shall play sound or not when place the container.
	 *
	 * @param player                some has set this setting.
	 * @param soundEffectsWhenPlace set to true if you want a sound when place the container.
	 */
	void setSoundEffectsWhenPlaceContainer(Player player, boolean soundEffectsWhenPlace);

	/**
	 * If it should show a notes when player craft or sell items.
	 *
	 * @param player the player-
	 * @return true if the player could be found.
	 */
	boolean isShowNotesMessage(UUID player);

	/**
	 * Set if it should show notes messages.
	 *
	 * @param player the player to set it on.
	 * @param showNotes true if it shall show notes.
	 */
	void setShowNotesMessage(Player player, boolean showNotes);
	

}
