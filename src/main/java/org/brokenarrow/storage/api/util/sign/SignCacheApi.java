package org.brokenarrow.storage.api.util.sign;

import org.bukkit.Location;

import java.util.Map;

public interface SignCacheApi {
	Map<Location, SignData> getSigns();

	void removeSign(Location location);

	SignData getSign(Location location);

	void putSign(Location location, SignData signData);
}
