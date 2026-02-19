package org.brokenarrow.storage.api.containerholder.teleport;

import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class TeleportDestination {
    private final Location targetLocation;
    private final Inventory bukkitInventory;
    private final InventoryHolder customHolder;

    public TeleportDestination(@Nonnull final Location targetLocation,@Nullable final Inventory bukkitInventory,@Nullable final InventoryHolder customHolder) {
        this.targetLocation = targetLocation;
        this.bukkitInventory = bukkitInventory;
        this.customHolder = customHolder;
    }

    public boolean isCustom() {
        return customHolder != null;
    }

    public Location getTargetLocation() {
        return targetLocation;
    }

    @Nullable
    public Inventory getBukkitInventory() {
        return bukkitInventory;
    }

    @Nullable
    public InventoryHolder getCustomHolder() {
        return customHolder;
    }
}