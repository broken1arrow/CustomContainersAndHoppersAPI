package org.brokenarrow.storage.api.containerholder.teleport;

import org.broken.arrow.library.logging.Validate;
import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public interface TeleportTarget {

    Location getLocation();

    Map<Integer, ItemStack> addItems(ItemStack... items);

    default Inventory getBukkit() {
        throw new Validate.ValidateExceptions("Not a Bukkit inventory target");
    }

    default InventoryHolder getCustom() {
        throw new Validate.ValidateExceptions("Not a custom inventory target");
    }

    boolean isCustom();
}
