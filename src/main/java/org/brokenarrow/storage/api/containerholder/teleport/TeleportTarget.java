package org.brokenarrow.storage.api.containerholder.teleport;

import org.broken.arrow.library.logging.Validate;
import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Optional;

public interface TeleportTarget {

    Location targetLocation();

    Map<Integer, ItemStack> addItems(ItemStack... items);

    default Inventory getBukkit() {
        throw new Validate.ValidateExceptions("Not a Bukkit inventory target");
    }

    default InventoryHolder getCustom() {
        throw new Validate.ValidateExceptions("Not a custom inventory target");
    }

    default Optional<SlotBasedTeleportTarget > slotBased() {
        if(this instanceof SlotBasedTeleportTarget  )
            return Optional.of((SlotBasedTeleportTarget) this);
        return Optional.empty();
    }

    default Optional<AggregatedStorageSupport> aggregated() {
        if(this instanceof AggregatedStorageSupport )
                    return Optional.of((AggregatedStorageSupport) this);
        return Optional.empty();
    }

    boolean isCustom();
}
