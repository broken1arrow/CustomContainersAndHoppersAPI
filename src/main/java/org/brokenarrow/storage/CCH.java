package org.brokenarrow.storage;

import org.brokenarrow.storage.api.*;
import org.brokenarrow.storage.util.ConsoleColors;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class CCH extends JavaPlugin {


	private final ContainerRegistryAPI registry = ContainerRegistryAPI.getInstance();
	private boolean hasLoadedSQL;
	private boolean hasStartLoadedToCache;
	private RecipeCacheAPI recipeCache;
	private InventoryHoldersCached inventoryHoldersCached;
	private boolean placeholderAPIMissing;
	private HopperMoveItemsListenerAPI hopperMoveItemsListener;
	private CheckItemsForCraftingApi checkItemsForCraftingApi;


	//private final SimpleCommandGroup mainCommand = new CommandsGroup();

	@Override
	public void onEnable() {
		long loadtime = System.currentTimeMillis();
		registerClasses();
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
		getAllPlayersAndCloseInventory();
		cleanBeforeReload();

	}


	public static CCH getInstance() {
		return CCH.getPlugin(CCH.class);
	}

	protected void cleanBeforeReload() {
	}
/*
	public Database getDatabase() {
		return database;
	}*/

	private void registerClasses() {
	}

	public InventoryHoldersCached getInventoryHoldersCached() {
		return inventoryHoldersCached;
	}

	public CheckItemsForCraftingApi getCheckItemsForCraftingApi() {
		return checkItemsForCraftingApi;
	}


	public TeleportAndPickupItemsApi getTeleportAndPickupItems() {
		return null;
	}

	public RecipeCacheAPI getRecipeCache() {
		return recipeCache;
	}

	public HopperMoveItemsListenerAPI getHopperMoveItemsListener() {
		return hopperMoveItemsListener;
	}

	/**
	 * If it load to cache.
	 *
	 * @return true if it have start to load to cache.
	 */

	public boolean isHasStartLoadedToCache() {
		return hasStartLoadedToCache;
	}

	public boolean isPlaceholderAPIMissing() {
		return placeholderAPIMissing;
	}

	public void loadInventory() {

	/*	for (Location location : registry.getContainerlocations())
			if (location != null && registry.isRegistered(location))
				CCH.getInstance().getInventoryHoldersCached().createOrGetInventoryHolder(location, registry.getPlayerUUID(location));
			else
				throw new IllegalArgumentException("This is not right location for a container ");*/

	}

	public void loadInventory(Location location) {
	/*	hasStartLoadedToCache = true;
		try {
			if (location != null && registry.isRegistered(location))
				CCH.getInstance().getInventoryHoldersCached().createOrGetInventoryHolder(location, registry.getPlayerUUID(location));
			else
				throw new IllegalArgumentException("This is not right location for a container ");
		} finally {
			hasStartLoadedToCache = false;
		}*/
	}
/*
	public @NonNull BukkitAudiences adventure() {
		if (this.adventure == null) {
			throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
		}
		return this.adventure;
	}*/

	public boolean Minecraftversion(String recipe) {
	/*	if (Bukkit.getServer().getBukkitVersion().equals("1.16.5-R0.1-SNAPSHOT"))
			if (recipe.equals("DEEPSLATE_TILE_WALL") || recipe.equals("DEEPSLATE_TILE_SLAB") ||
					recipe.equals("DEEPSLATE_TILE_STAIRS") || recipe.equals("DEEPSLATE_WALL") || recipe.equals("DEEPSLATE_BRICKS") ||
					recipe.equals("DEEPSLATE_TILES") || recipe.equals("DEEPSLATE_BRICK_SLAB") || recipe.equals("DEEPSLATE_STAIRS") ||
					recipe.equals("CUT_COPPER") || recipe.equals("WAXED_WEATHERED_CUT_COPPER_STAIRS") || recipe.equals("WAXED_WEATHERED_CUT_COPPER_SLAB") ||
					recipe.equals("WAXED_CUT_COPPER_SLAB") || recipe.equals("WAXED_CUT_COPPER_STAIRS") || recipe.equals("WAXED_OXIDIZED_CUT_COPPER_STAIRS") ||
					recipe.equals("WAXED_OXIDIZED_CUT_COPPER_SLAB") || recipe.equals("OXIDIZED_CUT_COPPER_SLAB") || recipe.equals("OXIDIZED_CUT_COPPER_STAIRS") ||
					recipe.equals("WEATHERED_CUT_COPPER_SLAB") || recipe.equals("WEATHERED_CUT_COPPER_STAIRS") || recipe.equals("CUT_COPPER_SLAB") ||
					recipe.equals("CUT_COPPER_STAIRS") || recipe.equals("EXPOSED_CUT_COPPER_SLAB") || recipe.equals("EXPOSED_CUT_COPPER_STAIRS") ||
					recipe.equals("COPPER_BLOCK") || recipe.equals("COBBLED_DEEPSLATE") || recipe.equals("TINTED_GLASS") || recipe.equals("POLISHED_DEEPSLATE") ||
					recipe.equals("POLISHED_DEEPSLATE_SLAB") || recipe.equals("POLISHED_DEEPSLATE_STAIRS") || recipe.equals("POLISHED_DEEPSLATE_WALL") ||
					recipe.equals("COBBLED_DEEPSLATE_SLAB") || recipe.equals("COBBLED_DEEPSLATE_STAIRS") || recipe.equals("COBBLED_DEEPSLATE_WALL")) {
				return true;
			}*/
		return false;
	}

	private void getAllPlayersAndCloseInventory() {
	/*	System.out.println("close inventorys ");
		System.out.println("testings " + Bukkit.getServer().getOnlinePlayers());
		Bukkit.getServer().getOnlinePlayers().forEach(HumanEntity -> {
			new InventoryCloseEvent(HumanEntity.getOpenInventory());
			System.out.println(" human " + HumanEntity);
		});*/

	}


	public boolean Minecraftversion(String... recipeIngredients) {
	/*	if (Bukkit.getServer().getBukkitVersion().equals("1.16.5-R0.1-SNAPSHOT"))
			for (String ingredient : recipeIngredients)
				if (ingredient != null)
					for (String ingredien : ingredient.split(",")) {
						if (ingredien.equals("COBBLED_DEEPSLATE") || ingredien.equals("POLISHED_DEEPSLATE") || ingredien.equals("MOSS_BLOCK")) {
							return true;
						}
					}*/
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
