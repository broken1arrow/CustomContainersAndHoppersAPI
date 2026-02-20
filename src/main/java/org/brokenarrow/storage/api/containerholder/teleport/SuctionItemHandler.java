package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

@FunctionalInterface
public interface SuctionItemHandler {

   void apply(ItemPickupTarget itemPickupHelper, Predicate<ItemStack> item);



}
