package org.brokenarrow.storage.api.containerholder.teleport;

import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;

public interface AggregatedStorageSupport {


    BigInteger accept(ItemStack stack, BigInteger amount);
}