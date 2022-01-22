package org.brokenarrow.storage.api.builder;

import org.bukkit.inventory.ItemStack;

import java.util.Set;

public interface RecipeCacheDataAPI {

	Set<ItemStack> getMatrial1();

	Set<ItemStack> getMatrial2();

	Set<ItemStack> getMatrial3();

	Set<ItemStack> getMatrial4();

	Set<ItemStack> getMatrial5();

	int getAmount1();

	int getAmount2();

	int getAmount3();

	int getAmount4();

	int getAmount5();

	int getTotalAmount();


}
