package org.brokenarrow.storage.api.containerholder.interaction;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Interface for handling interactions with the containers.
 * If you implement this class, it will often don't have checks
 * what blocks player interact with or explodes.
 */
public interface ContainerInteractionAPI {

    /**
     * Handles inventory click events.
     *
     * @param event The InventoryClickEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onInventoryClick(@NotNull final InventoryClickEvent event);

    /**
     * Handles item drag events.
     *
     * @param event The InventoryDragEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onItemDrag(@NotNull final InventoryDragEvent event);

    /**
     * Handles container interaction events.
     *
     * @param event The PlayerInteractEvent to handle.
     * @param page  The page number of the container.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onContainerInteract(@NotNull final PlayerInteractEvent event, int page);

    /**
     * Handles container close events.
     *
     * @param event The InventoryCloseEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onContainerClose(@NotNull final InventoryCloseEvent event);

    /**
     * Handles container place events.
     *
     * @param event The BlockPlaceEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onContainerPlace(@NotNull final BlockPlaceEvent event);

    /**
     * Handles container break events.
     *
     * @param event The BlockBreakEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onContainerBreak(@NotNull final BlockBreakEvent event);

    /**
     * Handles block explode events.
     *
     * @param event The EntityExplodeEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onBlockExplode(@NotNull final EntityExplodeEvent event);

    /**
     * Handles item pickup events.
     *
     * @param event The InventoryPickupItemEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onPickupItem(@NotNull final InventoryPickupItemEvent event);

    /**
     * Handles item move events.
     *
     * @param event    The InventoryMoveItemEvent to handle.
     * @param pushItem Whether the item is being pushed.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onMoveItem(@NotNull final InventoryMoveItemEvent event,final boolean pushItem);

    /**
     * Handles chunk load events.
     *
     * @param event The ChunkLoadEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onChunkLoad(@NotNull final ChunkLoadEvent event);

    /**
     * Handles chunk unload events.
     *
     * @param event The ChunkUnloadEvent to handle.
     * @return True if the event is successfully handled, false otherwise.
     */
    boolean onChunkUnload(@NotNull final ChunkUnloadEvent event);

    /**
     * Checks if the correct item is being pushed in an item move event.
     *
     * @param event The InventoryMoveItemEvent to check.
     * @param item  The ItemStack being pushed.
     * @return True if the correct item is being pushed, false otherwise.
     */
    boolean checkCorrectItemGetPushed(@NotNull final InventoryMoveItemEvent event, @NotNull final ItemStack item);

    void onJoin(PlayerJoinEvent e);

    void onMove(PlayerMoveEvent e);

    void onQuit(PlayerQuitEvent e);

    void onTeleport(PlayerTeleportEvent e);
}
