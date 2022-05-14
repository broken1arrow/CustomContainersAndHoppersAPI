package org.brokenarrow.storage.api.containerholders;

import org.brokenarrow.storage.api.ContainerRegistryAPI;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.Map;

public interface InventoryholderStorageUnit extends InventoryHolders {

	/**
	 * Set item and amount (this type of container don´t use index). Will override the old item and set the amount
	 * to the amount you set your itemstack to. Use {@link #addItems(ItemStack...)} if you want
	 * to add items and not remove old items.
	 *
	 * @param index     you want to set the item.
	 * @param itemStack item you want to set in the index.
	 */
	@Override
	public void setItem(int index, ItemStack itemStack);

	/**
	 * Get the item in a specific slot.
	 * <p>
	 * slot you want to get the item.
	 * item or null, if the slot does not, has any item.
	 *
	 * @param index number you want to get the item.
	 * @return itemstack.
	 */
	@Override
	public ItemStack getItem(int index);

	/**
	 * This method will try add items to container and
	 * check it wrong type or the continer are full.
	 *
	 * @param itemStacks items you want to add
	 * @return items some ether not fit the continer or try
	 * add items some not match items inside the container.
	 */
	@Override
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
	public void setContents(ItemStack... itemStacks);

	/**
	 * Will only return 3000 cloned item.
	 *
	 * @return 3000 cloned item.
	 */

	@Override
	public ItemStack[] getContents();

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
	public ItemStack[] getContents(int amount, boolean bypassLimit);

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
	 * See also this, for see what I use to set data it in cache.
	 * <p>
	 * {@link ContainerRegistryAPI#addAmount(Location, BigInteger)}
	 * {@link ContainerRegistryAPI#setContainercontents(Location, ItemStack[])}
	 *
	 * @param itemStack items you set to chache.
	 */
	void addItemsAmountInCache(ItemStack itemStack);

	/**
	 * Set the amount of items in chest.
	 * <p>
	 * See also this, for see what I use to amount it in cache.
	 * <p>
	 * {@link ContainerRegistryAPI#addAmount(Location, BigInteger)}
	 *
	 * @param amount set amount in chest.
	 */
	void addItemsAmountInCache(long amount);

	/**
	 * Set´s the amount and itemstack to cache (will only save 1 item to cache).
	 * <p>
	 * See also this, for see what I use to set data it in cache.
	 * <p>
	 * {@link ContainerRegistryAPI#addAmount(Location, BigInteger)}
	 * {@link ContainerRegistryAPI#setContainercontents(Location, ItemStack[])}
	 *
	 * @param itemStack items you set to chache.
	 * @param amount    set amount in chest.
	 */
	void addItemsAmountInCache(ItemStack itemStack, long amount);

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
	void setAmount(BigInteger amount);

	/**
	 * Subtract the number of items from the container.
	 *
	 * @param amount the number of items you want to remove.
	 */
	void subtractAmount(BigInteger amount);

	/**
	 * Add several items to the container.
	 *
	 * @param amount the number of items you want to add.
	 */
	void addAmount(BigInteger amount);
	
	/**
	 * Add or Subtract the amount of items added to the container.
	 *
	 * @param subtract true if you want to remove items.
	 * @param amount   the amount of items you want to add/remove.
	 * @param subtract if you shall add or subtract amount.
	 */
	void addSubtractAmount(BigInteger amount, boolean subtract);

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
	 * Get the type of item stored inside the chest or air
	 * if it empty.
	 *
	 * @return return the stored item or air.
	 */
	ItemStack getItemStack();

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
	void setItemPlaceholders(ItemStack itemStack);

	/**
	 * Update the inventory title for container.
	 *
	 * @param amounts amount of items inside the chest.
	 * @param cursor  items player add to the chest.
	 */
	@Override
	void updateInventoryTitle(BigInteger amounts, ItemStack cursor);

	/**
	 * This event are used when player add or remove items (will detect how many items player try add).
	 *
	 * @param event  the event.
	 * @param player player some interact with the chest.
	 * @return false if it can´t add the item or if contanier can´t have more items.
	 */
	@Override
	boolean onClickingInsideGui(InventoryClickEvent event, Player player);

	/**
	 * This will convert items to itemstacks.
	 *
	 * @param event the event some get trigged when you break a container.
	 * @return true if it exist items in the container.
	 */
	@Override
	boolean dropItemsOnBlockBreak(BlockBreakEvent event);

}
