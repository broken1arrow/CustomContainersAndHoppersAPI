package org.brokenarrow.storage.api.containerholder;

import org.brokenarrow.storage.api.containerholder.util.Reason;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Inventory actions, for example when container is open, broken, close
 * or when items get moved from one inventory to other inventory.
 */
public interface InventoryEvents {

    /**
     * Used to open a container. By default, this method typically only accepts left-click actions on blocks.
     * <p>
     * Note: Only a valid container with an inventory is accepted by default. This behavior can be adjusted if implemented in a custom class.
     *
     * @param clickedBlock The block that the player is clicking on.
     * @param clickAction  The action performed by the player.
     * @param player       The player who is opening the inventory.
     * @param pageNumber   The page to open, starting from 0 to a certain amount. If the container has multiple pages, it will open the
     *                     specified page; otherwise, it will open the first page.
     * @return True if the player was able to open the container.
     */
    boolean onOpenContainer(@Nonnull final Block clickedBlock, @Nonnull final Action clickAction, @Nonnull final Player player, final int pageNumber);

    /**
     * When player interact with a container.
     *
     * @param event      the event some get trigger when player clicking on or interacting with the block.
     * @param player     the player some clicking.
     * @param pageNumber the page to open or set it to 0 if you want the first page
     *                   or not needed to provide the specific page.
     * @return true if it shall cancel event.
     */
    boolean onContainerInteract(@Nonnull final PlayerInteractEvent event, @Nonnull final Player player, final int pageNumber);

    /**
     * Handle inventory click-event. For ether when player add/remove items
     * or change page.
     *
     * @param inventoryClick the event some get triggered.
     * @param player         player some interact with the chest.
     * @return if this return true, so can't player/players take item/items from the clicked inventory.
     */
    boolean onClickingInsideGui(@Nonnull final InventoryClickEvent inventoryClick, @Nonnull final Player player);

    /**
     * This is triggered when player drag items
     * inside the inventory.
     *
     * @param event       the event some get triggered when drag items.
     * @param clickedItem the item currently clicked on.
     * @return true if you want to cancel the event.
     */
    boolean onInventoryItemDrag(@Nonnull InventoryDragEvent event, @Nonnull ItemStack clickedItem);

    /**
     * When you break the container this will be called, I remove all cached data
     * and depending on settings I set it on the item, or the data get lost (only data
     * some are needed for place it again is keeped).
     *
     * @param player some break the container.
     * @param block  some get removed.
     * @return true if it shall cancel the event.
     */
    boolean onContainerBreak(@Nullable final Player player, @Nonnull final Block block);

    /**
     * When player close inventory.
     *
     * @param player some close the inventory.
     * @return true if valid container some get closed.
     */
    boolean onContainerClose(@Nonnull final Player player);

    /**
     * When you place the container this will get trigger after
     * the task is running, so you can't cancel the
     * placement of the container.
     *
     * @param player    some place the container.
     * @param container some get placed.
     * @return true if it has successfully executed the task.
     */
    boolean onContainerPlace(@Nonnull final Player player, @Nonnull final ItemStack container);

    /**
     * When container pick up items. This get triggered when item is on top of a hopper.
     *
     * @param event the event some used when container pick up items.
     * @return true if you want to cancel event.
     */
    boolean onPickupItem(@Nonnull InventoryPickupItemEvent event);

    /**
     * When container move items between containers. This get triggered when item get moved.
     *
     * @param event          the event some used when container move items between containers.
     * @param pushItem       true if you push item to custom container or false drag/pull items from a container.
     * @param destinationInv The destination inventory for the items.
     * @return true if you want to cancel event.
     */
    boolean onMoveItem(@Nonnull final Inventory destinationInv, @Nonnull InventoryMoveItemEvent event, boolean pushItem);

    /**
     * When it removes the task when chunk is no longer loaded or
     * the time is set below zero.
     *
     * @param reason The reason for the removal.
     */
    void removedFromTask(@Nonnull final Reason reason);
}
