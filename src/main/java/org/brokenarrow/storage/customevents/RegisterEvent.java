package org.brokenarrow.storage.customevents;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public class RegisterEvent {

	public static void register(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}
}
