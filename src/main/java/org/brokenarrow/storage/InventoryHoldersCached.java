package org.brokenarrow.storage;

import org.brokenarrow.storage.api.containerholders.InventoryHolder;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class InventoryHoldersCached {

	public static Map<Location, InventoryHolder> classes = new HashMap<>();

	public InventoryHolder createOrGetInventoryHolder(Location location, UUID player) {
		return getInventoryHolder(location);
	}

	public InventoryHolder getInventoryHolder(Location location) {
		if (location != null) {
			return classes.get(location);
		}
		return null;
	}

	public InventoryHolder removeInventoryHolder(Location location) {
		return classes.remove(location);

	}

	public boolean getClasses(InventoryHolder invetoryclass) {
		return classes.containsValue(invetoryclass);
	}
}
