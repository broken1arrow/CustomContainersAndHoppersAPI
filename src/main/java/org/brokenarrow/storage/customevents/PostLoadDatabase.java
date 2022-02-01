package org.brokenarrow.storage.customevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * It Will only fire if the database is loaded properly.
 */
public class PostLoadDatabase extends Event {

	private static final HandlerList handlers = new HandlerList();
	private final boolean loadedDatabase;
	private final String typeOfDataBase;
	private final long time;

	public PostLoadDatabase(boolean loadedDatabase, String typeOfDataBase, long time) {
		super(true);
		this.loadedDatabase = loadedDatabase;
		this.typeOfDataBase = typeOfDataBase;
		this.time = time;
	}

	/**
	 * Get if it load to database or not.
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

	@NotNull
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
