package org.brokenarrow.storage.api.customevents;

import org.bukkit.event.HandlerList;

/**
 * It Will only fire if the database is loaded properly.
 */
public class PostLoadDatabase extends EventUtility {

	private static final HandlerList handlers = new HandlerList();
	private final boolean loadedDatabase;
	private final String typeOfDataBase;
	private final long time;

	/**
	 * This constructor create the instance and set your provided data.
	 *
	 * @param loadedDatabase if it has loaded the database.
	 * @param typeOfDataBase the type of database loaded.
	 * @param time the time it took to load.
	 */
	public PostLoadDatabase(boolean loadedDatabase, String typeOfDataBase, long time) {
		super(handlers, true);
		this.loadedDatabase = loadedDatabase;
		this.typeOfDataBase = typeOfDataBase;
		this.time = time;
	}

	/**
	 * Get if it loads to database or not.
	 *
	 * @return true if database is loaded.
	 */
	public boolean isLoadedDatabase() {
		return loadedDatabase;
	}

	/**
	 * Get the type of database loaded.
	 * Currently, it has Sqlittle and Mysql.
	 *
	 * @return database type.
	 */
	public String getTypeOfDataBase() {
		return typeOfDataBase;
	}

	/**
	 * Get time it load.
	 *
	 * @return amount of time it took to load.
	 */
	public long getTime() {
		return time;
	}

	/**
	 * The static handler.
	 *
	 * @return the handler.
	 */
	public static HandlerList getHandlerList() {
		return handlers;
	}
}
