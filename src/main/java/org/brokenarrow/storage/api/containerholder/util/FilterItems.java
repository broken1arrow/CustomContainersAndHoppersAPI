package org.brokenarrow.storage.api.containerholder.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sets the filter items used for crafting and
 * the suction and lick hopper what it allows to pickup.
 */
public class FilterItems {

	private final List<ItemStack> itemStacks = new ArrayList<>();
	private TypeOfFilter filterType;

	/**
	 * Creates the instance with your set values.
	 *
	 * @param itemStacks the items you want to add to the filter.
	 * @param filterType the type of filter.
	 */
	public FilterItems(final ItemStack[] itemStacks, final TypeOfFilter filterType) {
		this.itemStacks.addAll(Arrays.asList(itemStacks));
		this.filterType = filterType;
	}

	/**
	 * Creates the instance of the FilterItems class.
	 *
	 * @param itemStacks the items you want to add to the filter.
	 * @param filterType the type of filter.
	 * @return instance of this class.
	 */
	public static FilterItems of(final ItemStack[] itemStacks, TypeOfFilter filterType) {
		if (filterType == null)
			filterType = TypeOfFilter.META_MATCH;
		return new FilterItems(itemStacks, filterType);
	}

	/**
	 * Retrieve all itemsStacks set.
	 *
	 * @return array of itemstacks.
	 */
	public ItemStack[] getItemStacks() {
		return this.itemStacks.toArray(new ItemStack[0]);
	}

	/**
	 * Check what type of matching, should match the item exact or
	 * type.
	 * @return the filter type.
	 */
	public TypeOfFilter getFilterType() {
		return filterType;
	}

	/**
	 * Set the filter type.
	 *
	 * @param filterType the filter type it should use.
	 */
	public void setFilterType(final TypeOfFilter filterType) {
		this.filterType = filterType;
	}

	/**
	 * Retrieves a immutable list if items.
	 *
	 * @return list of filter items.
	 */
	public List<ItemStack> clonedFilterItems() {
		return this.itemStacks.stream().map(ItemStack::new).collect(Collectors.toList());
	}
    /**
     * This method check if the stacks is set or the list is empty.
     *
     * @return Returns true if the list is empty.
     */
    public boolean isEmpty() {
        return this.itemStacks.isEmpty();
    }
	/**
	 * Add the item to the list.
	 *
	 * @param itemStack the itemstack you want to add to the list.
	 * @return the items.
	 */
	public boolean addItem(final ItemStack itemStack) {
		return this.itemStacks.add(itemStack);
	}

	/**
	 * Remove the first matched item from the list.
	 *
	 * @param itemStack the itemstack you want to remove from the list.
	 * @return the items.
	 */
	public boolean removeItem(final ItemStack itemStack) {
		return this.itemStacks.remove(itemStack);
	}

	/**
	 * Remove the item from the index.
	 *
	 * @param index the index you want to remove from the list.
	 * @return the items.
	 */
	public boolean removeItem(final int index) {
		return this.itemStacks.remove(index) != null;
	}

    /**
     * Check if is any items is set and not air.
     *
     * @return Returns {@code true} if it finds a match and {@code false} if the list is empty.
     */
    public boolean findMatch(@NotNull final ItemStack itemStack) {
        if(this.itemStacks.isEmpty())
            return false;
        return this.itemStacks.stream().noneMatch(stack -> stack.isSimilar(itemStack));
    }

    /**
     * Check if is any items is set and not air.
     *
     * @return Returns {@code true} if all items is not air.
     */
    public boolean isItemsSet() {
        if(this.itemStacks.isEmpty())
            return false;

        return this.itemStacks.stream().allMatch(itemStack -> {
            return itemStack != null && itemStack.getType() != Material.AIR;
        });
    }

	/**
	 * Clear the list.
	 *
	 */
	public void clearItems() {
		this.itemStacks.clear();
	}
}
