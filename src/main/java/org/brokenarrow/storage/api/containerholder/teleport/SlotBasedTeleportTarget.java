package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

public interface SlotBasedTeleportTarget extends TeleportTarget {

    int getSize();

    int getCurrentSetPages();

    ItemStack getItem(final int page, final int slot);

    void setItem(final int page,final int slot, final ItemStack stack);
}