package org.brokenarrow.storage.api.containerholders;

import org.brokenarrow.storage.api.ContainerRegistryAPI;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.Map;

public interface InventoryholderStorageUnit extends InventoryHolders {

	/**
	 * Create inventory if not exist and add items if
	 * the inventory has items before.
	 *
	 * @return the gui player open.
	 */
	@Override
	Inventory createAndLoadInventory();


	/**
	 * When close container, It will play sound and update holograms.
	 *
	 * @param player get the player some close the gui.
	 */

	@Override
	void onContainerClose(Player player);

	/**
	 * @return return inventory or null if it allredy created.
	 */
	@Override
	Inventory setInventoryHopper();

	/**
	 * This type of container has no pages, so will only return one.
	 *
	 * @param type  set type of inventory or null if
	 *              you want chest gui with size.
	 * @param size  size of the inventory.
	 * @param title The description of the gui
	 * @return one inventory.
	 */
	Inventory setPage(InventoryType type, int size, String title);

	/**
	 * This method will try add items to container and
	 * check it wrong type or the continer are full.
	 *
	 * @param itemStacks items hopper try to add
	 * @return items some ether not fit the continer or try
	 * add items some not match items inside the container.
	 */

	@Override
	Map<Integer, ItemStack> addItems(ItemStack... itemStacks);

	/**
	 * This will convert items to itemstacks.
	 *
	 * @param event the event some get trigged when you break a container.
	 * @return true if it exist items in the container.
	 */
	@Override
	boolean dropItemsOnBlockBreak(BlockBreakEvent event);

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
	 * @param location location of the container.
	 * @param event    the event.
	 * @param player   player some interact with the chest.
	 * @return false if it can´t add the item or if contanier can´t have more items.
	 */
	@Override
	boolean onClickingInsideGui(Location location, InventoryClickEvent event, Player player);

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
	 * {@link ContainerRegistryAPI#setAmontOfItems(Location, BigInteger)}
	 * {@link ContainerRegistryAPI#setContainercontents(Location, ItemStack[])}
	 *
	 * @param itemStack items you set to chache.
	 */
	void setItemsAmountInCache(ItemStack itemStack);

	/**
	 * Set the amount of items in chest.
	 * <p>
	 * See also this, for see what I use to amount it in cache.
	 * <p>
	 * {@link ContainerRegistryAPI#setAmontOfItems(Location, BigInteger)}
	 *
	 * @param amount set amount in chest.
	 */
	void setItemsAmountInCache(long amount);

	/**
	 * Set´s the amount and itemstack to cache (will only save 1 item to cache).
	 * <p>
	 * See also this, for see what I use to set data it in cache.
	 * <p>
	 * {@link ContainerRegistryAPI#setAmontOfItems(Location, BigInteger)}
	 * {@link ContainerRegistryAPI#setContainercontents(Location, ItemStack[])}
	 *
	 * @param itemStack items you set to chache.
	 * @param amount    set amount in chest.
	 */
	void setItemsAmountInCache(ItemStack itemStack, long amount);

	/**
	 * Get amount is left in the chest (if the container has limmit
	 * of amount you can add).
	 *
	 * @return amount is left inside the container.
	 */
	BigInteger getAmountLeft();

	/**
	 * Set the amount of items added to the container.
	 *
	 * @param amount the amount of items from you add/remove items.
	 */
	void setAmount(BigInteger amount);

	/**
	 * Get the amount of items inside the container.
	 *
	 * @return the amount of items in the container.
	 */
	@Override
	BigInteger getAmount();

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


}
