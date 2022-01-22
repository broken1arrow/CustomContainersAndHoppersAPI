package org.brokenarrow.storage;

import org.brokenarrow.storage.api.ContainerRegistryAPI;
import org.brokenarrow.storage.api.containerholders.InventoryHolders;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class InventoryHoldersCached {
	private static final ContainerRegistryAPI registry = ContainerRegistryAPI.getInstance();

	public static Map<Location, InventoryHolders> classes = new HashMap<>();

	public InventoryHolders createOrGetInventoryHolder(Location location, UUID player) {
		return getInventoryHolder(location);
	}

	public InventoryHolders getInventoryHolder(Location location) {
		if (location != null) {
			return classes.get(location);
		}
		return null;
	}

	public InventoryHolders removeInventoryHolder(Location location) {
		return classes.remove(location);

	}

	public boolean getClasses(InventoryHolders invetoryclass) {
		return classes.containsValue(invetoryclass);
	}
}
