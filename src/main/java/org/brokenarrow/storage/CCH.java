package org.brokenarrow.storage;

import org.brokenarrow.storage.api.DatabaseAPI;
import org.brokenarrow.storage.api.HopperMoveItemsListenerAPI;
import org.brokenarrow.storage.api.RecipeCacheAPI;
import org.brokenarrow.storage.api.TeleportAndPickupItemsApi;
import org.brokenarrow.storage.api.runnable.*;
import org.brokenarrow.storage.util.ConsoleColors;
import org.brokenarrow.storage.util.command.CommandRegister;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class CCH extends JavaPlugin {

	@Override
	public void onEnable() {
		long loadtime = System.currentTimeMillis();
		registerClasses();
		sendLogMsg(Level.SEVERE, "Has loaded this API, should not be added as nurmal jar, " +
				"becuse this api not contains the needed code.");
		sendLogMsg(Level.SEVERE, "Tell the developer of the plugin, stop use this api that way.");

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

	protected void cleanBeforeReload() {
	}

	private void registerClasses() {
	}

	/**
	 * Get all inventorys in cache and also data some is cached.
	 * Like contents if container is linked and soo on.
	 *
	 * @return InventoryHoldersCached instance.
	 */

	public InventoryHoldersCached getInventoryHoldersCached() {
		return null;
	}

	public DatabaseAPI getDatabaseApi() {
		return null;
	}


	public TeleportAndPickupItemsApi getTeleportAndPickupItems() {
		return null;
	}

	public RecipeCacheAPI getRecipeCache() {
		return null;
	}

	public HopperMoveItemsListenerAPI getHopperMoveItemsListener() {
		return null;
	}

	public CraftingSellTaskAPI getCraftingSellTask() {
		return null;
	}

	public AddItemsToStorageUnitAPI getAddItemsToStorageUnit() {
		return null;
	}

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
	 * the class to register sub command, in this plugin.
	 *
	 * @return CommandRegister class (should never be null).
	 */
	public CommandRegister getCommandRegister() {
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

	/**
	 * Check if placeholder api is installed on server or not.
	 *
	 * @return true if it exist.
	 */
	public boolean isPlaceholderAPIMissing() {
		return false;
	}

	public void registerEvent(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, this);
	}

	public void sendLogMsg(Level logLevel, String msg) {
		String color, msgColor;
		if (logLevel == Level.WARNING) {
			color = ConsoleColors.RED_BRIGHT;
			msgColor = ConsoleColors.BLUE_BOLD_BRIGHT;
		} else if (logLevel == Level.SEVERE) {
			color = ConsoleColors.RED;
			msgColor = ConsoleColors.BLUE_BOLD_BRIGHT;
		} else {
			color = ConsoleColors.GREEN;
			msgColor = ConsoleColors.WHITE;
		}
		this.getServer().getLogger().log(logLevel, color + "[" + this.getName() + "] " + msgColor + msg + ConsoleColors.RESET);
	}


}
