package org.brokenarrow.storage.api.containerholder;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public interface InventoryholderStorageUnit extends InventoryHolder {

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
	 * It will check if the amount you want exist or
	 * will return empty ItemStack array. Also You can´t get more an
	 * 4000 items if you not set bypassLimit to true.
	 *
	 * @param amount      you want to get from the container.
	 * @param bypassLimit set to true if you want to force more than 4000 items. If you set the amount too high it will cause problems.
	 * @return array if itemStack´s or null if a container is empty or you specify number bigger a contents container have.
	 */
	ItemStack[] getContents(int amount, boolean bypassLimit);

	/**
	 * This method return ether max amount left or max stacksize.
	 *
	 * @return one cloned item in the array with amount left or max stacksize.
	 */
	@Override
	@NotNull ItemStack[] getContents();

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
	 * Check if the item can be placeded inside the chest.
	 *
	 * @param itemStack the items some hopper or player try to add.
	 * @return true if you can place items inside.
	 */
	boolean canPlaceItemInsideContainer(ItemStack itemStack);


	/**
	 * Set´s the amount and itemstack to cache (will only save 1 item to cache).
	 * <p>
	 * See also this, for see what I use to set data it in cache.
	 *
	 * @param itemStack items you set to chache.
	 */
	void addItemsAmountInCache(ItemStack itemStack);

	/**
	 * Set´s the amount and itemstack to cache (will only save 1 item to cache).
	 * <p>
	 * See also this, for see what I use to set data it in cache.
	 * <p>
	 *
	 * @param itemStack items you set to chache.
	 * @param amount    set amount in chest.
	 */
	void addItemsAmountInCache(final ItemStack itemStack, final long amount);


	/**
	 * Create inventory/inventorys if not exist.
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
	BigInteger addSubtractAmount(final BigInteger amount, final boolean subtract);

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
	 * Save item and the amount to cache. Will override old
	 * amount and item added inside the container.
	 *
	 * @param itemStack the item you want to add.
	 * @param amount    amount you want to add in the container.
	 */
	void saveToCache(final ItemStack itemStack, final int amount);

}
