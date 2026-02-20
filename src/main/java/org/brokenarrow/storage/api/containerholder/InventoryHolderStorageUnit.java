package org.brokenarrow.storage.api.containerholder;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Map;

/**
 * The inventory holder for the chest that can only store 1 item
 * but with either unlimited amount or limit amount, depending on the settings.
 */
public interface InventoryHolderStorageUnit extends InventoryHolder {


    /**
     * Sets the item and its amount in this container.
     * <p>
     * This container type does not use an index; calling this method will override
     * any existing item and set the amount to match the provided {@code ItemStack}.
     * Use {@link #addItems(ItemStack...)} to add items without removing existing ones.
     * <p>
     * If lock mode is active, the item may be rejected if it does not match the
     * configured filter. The lock state can be checked via {@link #isLockModeActive()},
     * and item validity can be verified using {@link #isItemBlocked(ItemStack)}.
     *
     * @param index     ignored by this container type
     * @param itemStack the item to set
     */
    @Override
     void setItem(final int index, final ItemStack itemStack);

    /**
     * Attempts to add the given items to this container.
     * <p>
     * Items may fail to be added if the container is full, the item type is not
     * compatible with the container, or the item is rejected by an active lock
     * filter. If lock mode is active, only items matching the configured filter
     * are accepted.
     * <p>
     * The lock state can be checked via {@link #isLockModeActive()}, and item
     * validity can be verified using {@link #isItemBlocked(ItemStack)}.
     *
     * @param itemStacks the items to add
     * @return a map of items that could not be added, indexed by their original
     *         position in the input array
     */
    @Override
    @NotNull
    Map<Integer, ItemStack> addItems(final ItemStack... itemStacks);

    /**
     * Get items in the container. You have to define
     * the amount you want to get from container.
     * <p>
     * For check amount inside use {@link #getAmount()}
     * <p>
     * The idea behind this is the huge amount some can be stored
     * in this container and to reduce the strain on the server
     * it only creates stacks after the amount you specify.
     * <p>
     * It will check if the amount you want to exist or
     * will return empty ItemStack array. Also, you can´t get more than a
     * double chest of items if you not set bypassLimit to true.
     *
     * @param amount      you want to get from the container.
     * @param bypassLimit set to true if you want to force more than 4000 items. If you set the amount too high it will cause problems.
     * @return array if itemStack´s or null if a container is empty, or you specify number bigger a contents container have.
     */
    ItemStack[] getContents(int amount, boolean bypassLimit);

    /**
     * This method return a double chest of items if it more than what fits
     * inside that container or if it below it will fill the slots with the items left.
     * Due to how this container works, this is just copy and will not alter the actual
     * content inside the chest.
     *
     * @return one cloned item in the array with amount left or max stack size.
     */
    @Override
    @NotNull
    ItemStack[] getContents();

	/**
	 * This will convert items to itemstacks.
	 *
	 * @return true if it exist items in the container.
	 */
	@Override
	boolean dropItemsOnBlockBreak();

	/**
	 * Drop items 1 stack at the time, if you try drop 128 items
	 * they become invisible (but can be picked up). so to avoid
	 * this it will drop a maximum of 64 items at the same tick.
	 *
	 * @param itemStack add itemstacks some get converted to 64 items at max
	 *                  or the items max stack size.
	 */

	void dropItemsOnBlockBreak(ItemStack itemStack);

	/**
	 * Check if the item can be placed inside the chest.
	 *
	 * @param itemStack the items some hopper or player try to add.
	 * @return true if you can place items inside.
	 */
	boolean canPlaceItemInsideContainer(ItemStack itemStack);

    /**
     * Check if the item can be placed inside the chest.
     *
     * @param stack the itemStack added to the container.
     * @return true if you can place items inside.
     */
    boolean canAcceptItemType(ItemStack stack);


	/**
	 * Set´s the amount and itemStack to cache (will only save 1 item to cache).
	 * <p>
	 * See also this, for see what I use to set data it in cache.
	 *
	 * @param itemStack items you set to chache.
	 */
	void addItemsAmountInCache(ItemStack itemStack);

	/**
	 * Set´s the amount and itemStack to cache (will only save 1 item to cache).
	 * <p>
	 * See also this, for see what I use to set data it in cache.
	 * <p>&nbsp;</p>
	 * @param itemStack items you set to chache.
	 * @param amount    set amount in chest.
	 */
	void addItemsAmountInCache(final ItemStack itemStack, final long amount);

	/**
	 * Create inventory/inventories if not exist.
	 *
	 * @param player some open inventory.
	 * @return the inventory if it could create one.
	 */
	Inventory loadInventory(Player player);

	/**
	 * Get amount is left in the chest (if the container has limmit
	 * of amount you can add).
	 *
	 * @return amount is left inside the container.
	 */
	BigInteger getAmountLeft();

	/**
	 * Set the amount of items in the container.
	 *
	 * @param amount the amount of items you want to set.
	 */
	void setAmount(final BigInteger amount);

	/**
	 * Subtract the number of items from the container.
	 *
	 * @param amount the number of items you want to remove.
	 * @return the amount of items after subtract.
	 */
	BigInteger subtractAmount(final BigInteger amount);

	/**
	 * Add several items to the container.
	 *
	 * @param amount the number of items you want to add.
	 * @return the amount of items after add.
	 */
	BigInteger addAmount(final BigInteger amount);

	/**
	 * Add or Subtract the amount of items added to the container.
	 *
	 * @param amount   the amount of items you want to add/remove.
	 * @param subtract true if you want to remove items.
	 * @return the amount of items after add or subtract.
	 */
	BigInteger alterAmount(final BigInteger amount, final boolean subtract);

	/**
	 * Get the amount of items inside the container.
	 *
	 * @return the amount of items in the container.
	 */
	BigInteger getAmount();

	/**
	 * Get the amount of items inside the container.
	 * This method are not exact, if amount is over
	 * Intriger max value it will return Intriger max
	 * value.
	 *
	 * @return the amount of items in the container or Intriger max value.
	 */
	int getAmountInt();

	/**
	 * Get the max amount of items you can store inside the container.
	 *
	 * @return the amount of items in the container or -1 if it unlimit amount.
	 */
	BigInteger getMaxAmount();

	/**
	 * The maxamount of items you can stor inside this container type
	 * ,take settings from yml file.
	 *
	 * @return the amount you can store or -1 if it are unlimit amout you can store.
	 */
	BigInteger updateMaxAmount();


	/**
	 * Set the defult placeholders inside inventory if container are empty, on all slots
	 * but not center slot.
	 */
	void updateItemPlaceholders();

	/**
	 * Set items inside the inventory if it not empty.
	 *
	 * @param itemStack the itemstack it will show as placeholders.
	 */
	void updateItemPlaceholders(final ItemStack itemStack);

	/**
	 * Update the inventory title for container. With the amounts added or
	 * Set both to null to update it from cache.
	 *
	 * @param amounts amount of items inside the chest.
	 * @param cursor  items player add to the chest.
	 */
	void updateInventoryTitle(final BigInteger amounts, final ItemStack cursor);


    /**
     * Determines whether the container is currently operating in lock mode.
     * <p>
     * Lock mode is considered active when a filter exists and at least one
     * filter item has been configured. When active, only items matching the
     * filter are allowed.
     *
     * @return {@code true} if lock mode is active, otherwise {@code false}
     */
    boolean isLockModeActive() ;

    /**
     * Checks whether the given item is blocked by the container's filter.
     * <p>
     * An item is considered blocked when lock mode is active and the item does
     * not match any of the configured filter items. If lock mode is inactive,
     * this method always returns {@code false}.
     *
     * @param itemStack the item to check
     * @return {@code true} if the item is blocked by the filter, otherwise {@code false}
     */
    boolean isItemBlocked(@NotNull final ItemStack itemStack) ;

    /**
     * Returns the locked {@link ItemStack} for this container.
     *
     * @return the locked ItemStack, or an ItemStack of {@link org.bukkit.Material#AIR}
     *         if lock mode is inactive or no locked item is set.
     */
    @NotNull ItemStack getItemLocked();


}
