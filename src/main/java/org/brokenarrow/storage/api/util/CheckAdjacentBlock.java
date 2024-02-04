package org.brokenarrow.storage.api.util;

import org.brokenarrow.storage.CCH;
import org.brokenarrow.storage.api.util.sign.SignData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckAdjacentBlock {
	private static List<Location> locationList = new ArrayList<>();
	private static Map<Location, Material> locationMat = new HashMap<>();
	private static CCH plugin = CCH.getInstance();

	public static boolean isAirOrAttachedToContainer(Location center) {
		if (center.getWorld() == null) return false;
		int radius = 1;
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					Block block = center.getWorld().getBlockAt(center.getBlockX() + x, center.getBlockY() + y, center.getBlockZ() + z);
					SignData signData = getSignData(block);
					if (signData != null) {
						block.setType(Material.AIR);
						plugin.getSignCache().removeSign(block.getLocation());
						return true;
					}
				}
			}
		}
		//check(center);
		return false;
	}

	private static SignData getSignData(Block block) {
		//System.out.println("working " + block.getType());
		locationList.add(block.getLocation());
		return plugin.getSignCache().getSign(block.getLocation());
	}

	private static void check(Location center) {
		locationList.forEach(loc -> {
			if (locationMat.get(loc) == null)
				locationMat.put(loc, loc.getBlock().getType());
			loc.getBlock().setType(Material.AIR);
		});
		Bukkit.getScheduler().runTaskLater(CCH.getInstance(), () -> center.getBlock().setType(Material.GOLD_BLOCK), 1);

		Bukkit.getScheduler().runTaskLater(CCH.getInstance(), () -> {
			locationMat.forEach((key, value) -> {
				if (key.equals(center))
					center.getBlock().setType(Material.AIR);
				else
					key.getBlock().setType(value);
			});
		}, 20 * 5);
	}
}
