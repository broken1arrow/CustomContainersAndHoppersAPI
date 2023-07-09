package org.brokenarrow.storage.api.containerholders.util;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

public interface ContainerListenerHandlerAPI extends Listener {

	boolean onInventoryClick(InventoryClickEvent event);

	boolean onItemDrag(InventoryDragEvent event);

	boolean onContainerInteract(final PlayerInteractEvent event);

	boolean onContainerOpen(PlayerInteractEvent event, int pageNumber);

	boolean onContainerClose(InventoryCloseEvent event);

	boolean onContainerPlace(final BlockPlaceEvent event);

	boolean onContainerBreak(BlockBreakEvent event);

	boolean onBlockExplode(final EntityExplodeEvent event);

	boolean onPickupItem(InventoryPickupItemEvent event);

	boolean onMoveItem(InventoryMoveItemEvent event, boolean pushItem);

	boolean onChunkLoad(final ChunkLoadEvent event);

	boolean onChunkUnload(final ChunkUnloadEvent event);
}
