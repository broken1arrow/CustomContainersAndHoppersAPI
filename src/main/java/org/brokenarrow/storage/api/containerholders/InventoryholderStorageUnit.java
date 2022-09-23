package org.brokenarrow.storage.api.containerholders;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Map;

public interface InventoryholderStorageUnit extends InventoryHolder {

	/**
	 * Set item and amount (this type of container don´t use index). Will override the old item and set the amount
	 * to the amount you set your itemstack to. Use {@link #addItems(ItemStack...)} if you want
	 * to add items and not remove old items.
	 *
	 * @param index     you want to set the item.
	 * @param itemStack item you want to set in the index.
	 */
	@Override
	void setItem(int index, ItemStack itemStack);

	/**
	 * Get the item in a specific slot. You get item or air if the ccontainer is empty.
	 * If you try get items outside the array length you get a exeption.
	 *
	 * @param index set number to zero becuse it is not used on this container type.
	 * @return itemstack.
	 */
	@Override
	ItemStack getItem(int index);

	/**
	 * This method will try add items to container and
	 * check it wrong type or the continer are full.
	 *
	 * @param itemStacks items you want to add
	 * @return items some ether not fit the continer or try
	 * add items some not match items inside the container.
	 */
	@Override
	@NotNull
	Map<Integer, ItemStack> addItems(ItemStack... itemStacks);

	/**
	 * Set items in the container. It will override all old items
	 * you have stored inside the container and the amount.
	 * <p>
	 * <p>
	 * <p>
	 * This container don´t have a real inventory. So it will calculate amount
	 * of stacks you try to add and amount of every stack. You can´t add diffrent
	 * types of item so it will compere your first stack and if you have other types
	 * added in the array it will ignore it.
	 *
	 * @param itemStacks items you want to set.
	 */
	@Override
	void setContents(ItemStack... itemStacks);

	/**
	 * Will only return 3000 cloned item.
	 *
	 * @return 3000 cloned item.
	 */
	@NotNull
	@Override
	ItemStack[] getContents();

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
	 * This type of container has no pages, so will only return one.
	 *
	 * @param type  set type of inventory or null if
	 *              you want chest gui with size.
	 * @param size  size of the inventory.
	 * @param title The description of the gui
	 * @return one inventory.
	 */
	@Override
	void setPagesInCache(InventoryType type, int size, String title);

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

	@Override
	void dropItemsOnGround(ItemStack itemStack);

	/**
	 * This event are used when player add or remove items (will detect how many items player try add).
	 *
	 * @param event  the event.
	 * @param player player some interact with the chest.
	 * @return false if it can´t add the item or if contanier can´t have more items.
	 */
	@Override
	boolean onClickingInsideGui(@NotNull InventoryClickEvent event, @NotNull Player player);

	/**
	 * Check if the item can be placeded inside the chest.
	 *
	 * @param itemStack the items some hopper or player try to add.
	 * @return true if you can place items inside.
	 */
	@Override
	boolean canPlaceItemInsideContainer(ItemStack itemStack);

	/**
	 * Set the itemstack type placeholders inside the chest.
	 *
	 * @param itemStack the itemstack some are added
	 */
	void setItemStack(ItemStack itemStack);

	/**
	 * Set´s the amount and itemstack to cache (will only save 1 item to cache).
	 * <p>
	 *
	 * @param itemStack items you set to chache.
	 */
	void addItemsAmountInCache(ItemStack itemStack);

	/**
	 * Set the amount of items in chest.
	 * <p>
	 * See also this, for see what I use to amount it in cache.
	 *
	 * @param amount set amount in chest.
	 */
	void addItemsAmountInCache(long amount);

	/**
	 * Set´s the amount and itemstack to cache (will only save 1 item to cache).
	 * <p>
	 *
	 * @param itemStack items you set to chache.
	 * @param amount    set amount in chest.
	 */
	void addItemsAmountInCache(final ItemStack itemStack, final long amount);

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
	@Override
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
	BigInteger getMaxAmountOfItemsFromYmlSettings();


	/**
	 * Set the defult placeholders inside inventory if container are empty, on all slots
	 * but not center slot.
	 */
	@Override
	void setItemPlaceholderEmptyChest();

	/**
	 * Set items inside the inventory if it not empty.
	 *
	 * @param itemStack the itemstack it will show as placeholders.
	 */
	void setItemPlaceholders(final ItemStack itemStack);

	/**
	 * Update the inventory title for container.
	 *
	 * @param amounts amount of items inside the chest.
	 * @param cursor  items player add to the chest.
	 */
	@Override
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
