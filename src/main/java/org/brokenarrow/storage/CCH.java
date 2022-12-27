package org.brokenarrow.storage;

import org.brokenarrow.storage.api.Crafting.RecipeCacheAPI;
import org.brokenarrow.storage.api.DatabaseAPI;
import org.brokenarrow.storage.api.HologramsTaskAPI;
import org.brokenarrow.storage.api.SpawnContainerEffectsTaskAPI;
import org.brokenarrow.storage.api.TeleportAndPickupItemsApi;
import org.brokenarrow.storage.api.builders.PreferenceSettingsRegisteryApi;
import org.brokenarrow.storage.api.containerholders.cache.InventoryHoldersCacheApi;
import org.brokenarrow.storage.api.containerholders.runnable.ContainerTaskApi;
import org.brokenarrow.storage.api.containerholders.util.AddItemToContainerTaskAPI;
import org.brokenarrow.storage.api.containerholders.util.ContainerListenerHandlerAPI;
import org.brokenarrow.storage.api.containerholders.util.ItemMetadataUtillityApi;
import org.brokenarrow.storage.api.containerholders.util.LoadSettingsContainersAPI;
import org.brokenarrow.storage.api.runnable.HopperMoveTaskAPI;
import org.brokenarrow.storage.api.util.command.CommandRegister;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Level;

public class CCH extends JavaPlugin {

	@Override
	public void onEnable() {
		final long loadtime = System.currentTimeMillis();
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

		sendLogMsg(Level.INFO, "Has loaded the API, took " + (System.currentTimeMillis() - loadtime) + " ms to load all data.");

	}

	@Override
	public void onDisable() {
		cleanBeforeReload();

	}

	public static CCH getInstance() {
		return CCH.getPlugin(CCH.class);
	}

	public static String getPluginName() {
		return null;
		//	return CCH.getPlugin(CCH.class);
	}

	protected void cleanBeforeReload() {

	}

/*	public RegisterNbtAPI getNbtApi() {
		return nbtApi;
	}
	*/
	public DatabaseAPI getDatabaseApi() {
		return null;
	}

	private void registerClasses() {

	}

	public ChunkData getChunkData() {
		return null;
	}

	public InventoryHoldersCacheApi getInventoryHoldersCached() {
		return null;
	}

	public PreferenceSettingsRegisteryApi getPreferenceSettingsRegistery() {
		return null;
	}

/*	public EconomyProvider getEconomyProvider() {
		return economyProvider;
	}

	public ProtectionProvider getProtectionProvider() {
		return protectionProvider;
	}

	public HeavyTasks getHeavyTasks() {
		return heavyTasks;
	}


	public CraftingSellTask getCraftingSellTask() {
		return craftingSellTask;
	}

	public FilterCheckItems getFilterItems() {
		return filterCheckItems;
	}


	public StackerProvider getStackerProvider() {
		return stackerProvider;
	}

	public TickTask getTickTask() {
		return tickTask;
	}

	public ContainerPlaceListener getContainerPlaceListener() {
		return containerPlaceListener;
	}
*/

/*
	public ServerManagementPluginsProvider getCMIAndEssentialsXProvider() {
		return serverManagementPluginsProvider;
	}
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

	public SpawnContainerEffectsTaskAPI getSpawnContainerEffectsTask() {
		return null;
	}

	public HologramsTaskAPI getHologramsTask() {
		return null;
	}

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

	public RecipeCacheAPI getRecipeCache() {
		return null;
	}

/*	public RegisterMenuAPI getRegisterClass() {
		return null;
	}*/

	public ContainerTaskApi getContainerTask() {
		return null;
	}

	/**
	 * Get all loaded spawnchunks.
	 *
	 * @return list of chunks loaded or null if the chunks are not loaded.
	 */

	public List<Chunk> getLoadedSpawnChunksList() {
		return null;
	}

	/**
	 * If it load to cache.
	 *
	 * @return true if it have start to load to cache.
	 */

	public boolean isHasStartLoadedToCache() {
		return false;
	}

	public CommandRegister getCommandRegister() {
		return null;
	}

	public ItemStack getRandomStack() {
		return null;
	}

	public double getRandomStackNumber() {
		return -1;
	}

	public AddItemToContainerTaskAPI getAddItemToContainerTask() {
		return null;
	}

	public ItemMetadataUtillityApi getItemMetadataUtillity() {
		return null;
	}


	public LoadSettingsContainersAPI getSettingsForContainers() {
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
	 * @return true if it want to stop the check.
	 */
	public boolean isStopChunkCheck() {
		return false;
	}

	/**
	 * Set this if you not want to load or unload any containers, when you load and unload a chunk.
	 * You need sett this to false when you are done.
	 *
	 * @param stopChunkCheck set to true to stop it to load or unload contaier in that chunk in cache.
	 */
	public void setStopChunkCheck(final boolean stopChunkCheck) {
	}

	public void sendLogMsg(final Level logLevel, final String msg) {
		this.getServer().getLogger().log(logLevel, "[" + this.getName() + "] " + msg);
	}

}
