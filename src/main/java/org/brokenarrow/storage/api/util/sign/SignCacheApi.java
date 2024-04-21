package org.brokenarrow.storage.api.util.sign;

import org.brokenarrow.storage.api.builders.PreferenceSettingsDataAPI;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Map;

public interface SignCacheApi {
	Map<Location, SignData> getSigns();

	void removeSign(Location location);

	SignData getSign(Location location);

	void putSign(Location location, SignData signData);

	void placeSign(PlayerInteractEvent event, Player player);

	void placeSign(@NotNull Location location, ItemStack itemStack, String amount, Player player);

	boolean placeSignAuto(@NotNull Location location,PreferenceSettingsDataAPI playerSettings, ItemStack itemStack, String amount);
	boolean placeSignManual(Location location, PreferenceSettingsDataAPI playerSettings, @Nullable ItemStack itemStack);
}
