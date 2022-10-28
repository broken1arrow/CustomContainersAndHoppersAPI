package org.brokenarrow.storage.api.containerholders;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Inventory actions, for example when continer is open, breaked, close
 * or when items get moved from one inventory to other inventory.
 */

public interface InventoryEvents {

	/**
	 * Used when player try open container and this will be trigged.
	 *
	 * @param event      some are used to open container.
	 * @param player     player some open container.
	 * @param pageNumber witch page player shall open (if the container have pages).
	 * @return true if it could open container.
	 */

	boolean onOpenContainer(@NotNull final PlayerInteractEvent event, @NotNull final Player player, final int pageNumber);

	/**
	 * When player interact with other container. For example link container
	 * to x amount of other containers.
	 *
	 * @param event         some are used to track the clicked block.
	 * @param linkingPlayer the player some clicking.
	 * @return true if shall cancel event.
	 */
	boolean onContainerLinking(@NotNull final PlayerInteractEvent event, @NotNull final Player linkingPlayer);

	/**
	 * Handle inventory clickevent. For ether when player add/remove items
	 * or change page.
	 *
	 * @param inventoryClick the event some get trigged.
	 * @param player         player some interact with the chest.
	 * @return if this return true, so can't player/players take item/items from the clicked inventory.
	 */
	boolean onClickingInsideGui(@NotNull final InventoryClickEvent inventoryClick, @NotNull final Player player);

	/**
	 * This is trigged when player drag items
	 * inside the inventory.
	 *
	 * @param event the event some get trigged when drag items.
	 * @return true if you want to cancel the event.
	 */
	boolean onInventoryItemDrag(@NotNull InventoryDragEvent event, @NotNull ItemStack clickedItem);

	/**
	 * When you break the continer this will be called, i remove all cached data
	 * and depending on settings I set it on the item or the data get lost (only data
	 * some are needed for place it again is keeped).
	 *
	 * @param player some break the container.
	 * @param block  some get removed.
	 * @return true if it shall cancel the event.
	 */
	boolean onContainerBreak(@Nullable final Player player, @NotNull final Block block);

	/**
	 * When player close inventory.
	 *
	 * @param player some close the inventory.
	 * @return true if valid container some get closed.
	 */
	boolean onContainerClose(@NotNull final Player player);

	/**
	 * When you place the continer this will get trigged after
	 * the task is running, so you can't cancel the
	 * placement of the container.
	 *
	 * @param player    some place the container.
	 * @param container some get placed.
	 * @return true if it has successful executed the task.
	 */
	boolean onContainerPlace(@NotNull final Player player, @NotNull final ItemStack container);

	/**
	 * When container pick up items. This get trigged when item end up ontop of a hopper or hopper minecart.
	 *
	 * @param event the event some used when container pick up items.
	 * @return true if you want to cancel event.
	 */
	boolean onPickupItem(InventoryPickupItemEvent event);

	/**
	 * When container move items between containers. This get trigged when item get moved.
	 *
	 * @param event    the event some used when container move items between containers.
	 * @param pushItem true if you push item to custom continer or false drag/pull items from container.
	 * @return true if you want to cancel event.
	 */
	boolean onMoveItem(InventoryMoveItemEvent event, boolean pushItem);

}
