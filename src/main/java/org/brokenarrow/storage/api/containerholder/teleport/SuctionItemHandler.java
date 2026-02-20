package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface SuctionItemHandler {

   void apply(ItemPickupTarget itemPickupHelper);



}
