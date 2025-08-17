package org.brokenarrow.storage;

import org.broken.arrow.library.command.CommandRegister;
import org.brokenarrow.storage.api.Crafting.RecipeCacheAPI;
import org.brokenarrow.storage.api.*;
import org.brokenarrow.storage.api.builders.ChunkLoadUnload;
import org.brokenarrow.storage.api.builders.DatabaseSettings;
import org.brokenarrow.storage.api.builders.PreferenceSettingsRegistryApi;
import org.brokenarrow.storage.api.containerholder.cache.InventoryHoldersCacheApi;
import org.brokenarrow.storage.api.containerholder.runnable.ContainerTaskApi;
import org.brokenarrow.storage.api.containerholder.util.AddItemToContainerTaskAPI;
import org.brokenarrow.storage.api.containerholder.util.ContainerListenerHandlerAPI;
import org.brokenarrow.storage.api.containerholder.util.LoadSettingsContainersAPI;
import org.brokenarrow.storage.api.hooks.Protection;
import org.brokenarrow.storage.api.metadata.ItemMetadataHelper;
import org.brokenarrow.storage.api.runnable.HopperMoveTaskAPI;
import org.brokenarrow.storage.api.util.sign.SignCacheApi;
import org.brokenarrow.storage.api.util.time.ConvertTime;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.logging.Level;

/**
 * Main class of the CCH plugin.
 */
public class CCH extends JavaPlugin {

	@Override
	public void onEnable() {
		final long loadTime = System.currentTimeMillis();
		registerClasses();
		sendLogMsg(Level.SEVERE, "Has loaded this API, should not be added as normal jar, " +
				"becuse this api not contains the needed code.");
		sendLogMsg(Level.SEVERE, "Tell the developer of the plugin some use this api, to not provide this as a plugin or compile it with he's plugin.");

		sendLogMsg(Level.INFO, "=====================");
		sendLogMsg(Level.INFO, " _____  _____  _   _ ");
		sendLogMsg(Level.INFO, "/  __ \\/  __ \\| | | |");
		sendLogMsg(Level.INFO, "| /  \\/| /  \\/| |_| |");
		sendLogMsg(Level.INFO, "| |    | |    |  _  |");
		sendLogMsg(Level.INFO, "| \\__/\\| \\__/\\| | | |");
		sendLogMsg(Level.INFO, " \\____/ \\____/\\_| |_/");
		sendLogMsg(Level.INFO, "=====================");

		sendLogMsg(Level.INFO, "Has loaded the API, took " + (System.currentTimeMillis() - loadTime) + " ms to load all data.");

	}

	@Override
	public void onDisable() {
		cleanBeforeReload();

	}

	/**
	 * Retrieves the instance of the CCH plugin.
	 *
	 * @return The instance of the CCH plugin.
	 */
	public static CCH getInstance() {
		return CCH.getPlugin(CCH.class);
	}

	/**
	 * Retrieves the name of the plugin.
	 *
	 * @return The name of the plugin.
	 */
	public static String getPluginName() {
		return null;
		//	return CCH.getPlugin(CCH.class);
	}

	/**
	 * Cleans up resources before plugin reload.
	 */
	protected void cleanBeforeReload() {

	}

/*	public RegisterNbtAPI getNbtApi() {
		return nbtApi;
	}
	*/

	/**
	 * Get the database data.
	 * @return the database interface.
	 */
	public DatabaseAPI getDatabaseApi() {
		return null;
	}

	/**
	 * The classes register on start.
	 */

	private void registerClasses() {

	}

	/**
	 * Retrieve the chunk data.
	 *
	 * @return the chunk data instance.
	 */
	public ChunkData getChunkData() {
		return null;
	}

	/**
	 * Retrieve the inventory holder cache.
	 *
	 * @return the inventory holder instance
	 */
	public InventoryHoldersCacheApi getInventoryHoldersCached() {
		return null;
	}

	/**
	 * Retrieve the players preferred settings cache.
	 *
	 * @return the PreferenceSettingsRegistry interface.
	 */
	public PreferenceSettingsRegistryApi getPreferenceSettingsRegistery() {
		return null;
	}

	/**
	 * Retrieve the TeleportAndPickupItems builder.
	 *
	 * @return the interface where you can build the data from.
	 */
	public TeleportAndPickupItemsApi getTeleportAndPickupItems() {
		return null;
	}

/*//todo no api for this.
	public CheckChunkLoadUnload getCheckChunkLoadUnload() {
		return checkChunkLoadUnload;
	}

	public BlockPlacementPayment getBlockPlacementPayment() {
		return blockPlacementPayment;
	}
*/

	/**
	 * Retrieve the container effects where you can add locations or remove.
	 *
	 * @return the interface with the container effects.
	 */
	public SpawnContainerEffectsTaskAPI getSpawnContainerEffectsTask() {
		return null;
	}

	/**
	 * Handle the  holograms.
	 *
	 * @return  interface where you can add your own holograms too.
	 */
	public HologramsTaskAPI getHologramsTask() {
		return null;
	}

	/**
	 * The move the hopper items from the custom containers.
	 * This will only work if you turn it on in settings.
	 *
	 * @return the interface to add locations to.
	 */
	public HopperMoveTaskAPI getHopperMoveTask() {
		return null;
	}

	/**
	 * All events used for check diffrent acctions preformend on the continer.
	 * Like items puched to or from the container, player open container or break it.
	 *
	 *
	 * @return the container handler api.
	 */
	public ContainerListenerHandlerAPI getContainerListenerHandlerAPI() {
		return null;
	}

	/**
	 * Loading the server recipes.
	 */
	public void loadRecipes() {

	}

	/**
	 * Retrieves the cached recipe data.
	 *
	 * @return The RecipeCacheAPI containing cached recipe data.
	 */
	public RecipeCacheAPI getRecipeCache() {
		return null;
	}

/*	public RegisterMenuAPI getRegisterClass() {
		return null;
	}*/
	/**
	 * Retrieves the container task API.
	 *
	 * @return The ContainerTaskApi instance.
	 */
	public ContainerTaskApi getContainerTask() {
		return null;
	}

	/**
	 * Retrieves the database manager.
	 *
	 * @return The DatabaseDataHandler instance.
	 */
	public DatabaseDataHandler getDatabaseManager() {
		return null;
	}

	/**
	 * Retrieves a list of loaded spawn chunks.
	 *
	 * @return A list of loaded spawn chunks, or null if none are loaded.
	 */
	public List<Chunk> getLoadedSpawnChunksList() {
		return null;
	}

	/**
	 * Checks if data has started to load to cache.
	 *
	 * @return True if data has started to load to cache, otherwise false.
	 */
	public boolean isHasStartLoadedToCache() {
		return false;
	}

	/**
	 * Retrieves the command register.
	 *
	 * @return The CommandRegister instance.
	 */
	public CommandRegister getCommandRegister() {
		return null;
	}

	/**
	 * Retrieves a random ItemStack.
	 *
	 * @return A random ItemStack.
	 */
	public ItemStack getRandomStack() {
		return null;
	}

	/**
	 * Retrieves a random number.
	 *
	 * @return A random number.
	 */
	public double getRandomStackNumber() {
		return -1;
	}

	/**
	 * Retrieves the add item to container task API.
	 *
	 * @return The AddItemToContainerTaskAPI instance.
	 */
	public AddItemToContainerTaskAPI getAddItemToContainerTask() {
		return null;
	}

	/**
	 * Retrieves the item metadata utility.
	 *
	 * @return The ItemMetadataHelper instance.
	 */
	public ItemMetadataHelper getItemMetadataUtility() {
		return null;
	}

	/**
	 * Retrieves the settings for containers and their levels.
	 *
	 * @return The LoadSettingsContainersAPI instance.
	 */
	public LoadSettingsContainersAPI getSettingsForContainers() {
		return null;
	}

	/**
	 * Retrieves the database settings cache.
	 *
	 * @return The DatabaseSettings instance.
	 */
	public DatabaseSettings getDatabaseSettingCache() {return null;}

	/**
	 * Retrieves the class for chunk load and unloading events.
	 *
	 * @return The ChunkLoadUnload instance.
	 */
	public ChunkLoadUnload getCheckChunkLoadUnload() {
		return null;
	}
	/**
	 * Load inventory on location.
	 *
	 * @param location the location to load to cache from.
	 */
	public void loadInventory(final Location location) {
	}

	/**
	 * Get if it has set it should not check for containers when load or unload chunk.
	 * Usefull if you planed to only load a chunk for brief moment.
	 *
	 * @return true if it wants to stop the check.
	 */
	public boolean isStopChunkCheck() {
		return false;
	}

	/**
	 * Use this to convert time. Default it will be formatted
	 *  day hour minute second (depending on what numbers is more than zero).
	 *
	 * @return the time class.
	 */
	public ConvertTime timeConversion() {
		return null;
	}

	/**
	 * Set this if you not want to load or unload any containers, when you load and unload a chunk.
	 * You need set this to false when you are done.
	 *
	 * @param stopChunkCheck set to true to stop it to load or unload a container in that chunk in a cache.
	 */
	public void setStopChunkCheck(final boolean stopChunkCheck) {
	}

	/**
	 * Sends a log message with the specified log level and message.
	 *
	 * @param logLevel The log level of the message.
	 * @param msg      The message to log.
	 */
	public void sendLogMsg(final Level logLevel, final String msg) {
		this.getServer().getLogger().log(logLevel, "[" + this.getName() + "] " + msg);
	}

	/**
	 * Sends a message to a player or console if player is null.
	 *
	 * @param player the player or null if not provided.
	 * @param key the key from the file to locate the message.
	 * @param placeholders the placeholders to replace.
	 */
	public void sendMessage(@Nullable final Player player, @Nonnull final String key,@Nullable final Object... placeholders) {
	}

	/**
	 * Sends a message to a player or console if player is null.
	 *
	 * @param level the level if not player is provided.
	 * @param player the player or null if not provided.
	 * @param key the key from the file to locate the message.
	 * @param placeholders the placeholders to replace.
	 */
	public void sendMessage(@Nullable final Level level, @Nullable final Player player, @Nonnull final String key,@Nullable final Object... placeholders) {
	}

	/**
	 * Retrieve the placeholders from cache.
	 * @param key the key from the file to locate the message.
	 * @param placeholders the placeholders you want to replace with.
	 * @return the placeholder text.
	 */
	public String getPlaceholder(@Nonnull final String key,@Nullable final Object... placeholders) {
		return "";
	}

	/**
	 * retrieve the sign cache.
	 *
	 * @return the Sign cache interface.
	 */
	public SignCacheApi getSignCache() {
		return null;
	}

	/**
	 * Get the protection provider.
	 *
	 * @return the Protection interface.
	 */
	public Protection getProtectionProvider() {
        return null;
    }
}
