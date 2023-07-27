package org.brokenarrow.storage.api.containerholders.util;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterItems {

	private final List<ItemStack> itemStacks = new ArrayList<>();
	private TypeOfFilter filterType;

	public FilterItems(final ItemStack[] itemStacks, final TypeOfFilter filterType) {
		this.itemStacks.addAll(Arrays.asList(itemStacks));
		this.filterType = filterType;
	}

	public static FilterItems of(final ItemStack[] itemStacks, TypeOfFilter filterType) {
		if (filterType == null)
			filterType = TypeOfFilter.META_MATCH;
		return new FilterItems(itemStacks, filterType);
	}

	public ItemStack[] getItemStacks() {
		return this.itemStacks.toArray(new ItemStack[itemStacks.size()]);
	}

	public TypeOfFilter getFilterType() {
		return filterType;
	}

	public void setFilterType(final TypeOfFilter filterType) {
		this.filterType = filterType;
	}

	public List<ItemStack> clonedFilterItems() {
		return this.itemStacks.stream().map(ItemStack::new).collect(Collectors.toList());
	}

	public boolean addItem(final ItemStack itemStack) {
		return this.itemStacks.add(itemStack);
	}

	public boolean removeItem(final ItemStack itemStack) {
		return this.itemStacks.remove(itemStack);
	}

	public boolean removeItem(final int index) {
		return this.itemStacks.remove(index) != null;
	}

	public void clearItems() {
		this.itemStacks.clear();
	}
}
