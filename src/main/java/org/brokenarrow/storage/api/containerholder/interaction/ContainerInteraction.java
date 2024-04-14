package org.brokenarrow.storage.api.containerholder.interaction;

import org.brokenarrow.storage.CCH;
import org.brokenarrow.storage.api.builders.DatabaseSettings;
import org.brokenarrow.storage.api.containerholder.InventoryHolder;
import org.brokenarrow.storage.api.containerholder.cache.InventoryHoldersCacheApi;
import org.brokenarrow.storage.api.metadata.PlayerMetadataHandler;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ContainerInteraction {
    private final CCH plugin = CCH.getInstance();
    private final PlayerMetadataHandler metadataActivateLinkMode = PlayerMetadataHandler.ACTIVATE_LINK_TO_CONTAINER;
    private final InventoryHoldersCacheApi inventoryHoldersCached = plugin.getInventoryHoldersCached();
    public boolean onContainerOpen(final PlayerInteractEvent event, final int pageNumber) {
        final Block clickedBlock = event.getClickedBlock();
        final Player player = event.getPlayer();
        if (event.useInteractedBlock() == Event.Result.DENY) return false;
        if (clickedBlock == null) return false;

        Location containerLocation = clickedBlock.getLocation();

        if (!metadataActivateLinkMode.hasMetadata(player) && player.isSneaking()
                && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() == null)
                event.setCancelled(true);
            return false;
        }
        DatabaseSettings databaseSettings= plugin.getDatabaseSettingCache();

        if (!databaseSettings.isCacheContainersData() && databaseSettings.isCacheLoadWhenOpenContainer()) {
            plugin.getDatabaseManager().addContainerFromDb(containerLocation);
            plugin.loadInventory(containerLocation);
        }
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_BLOCK)) {
            final InventoryHolder inventoryHolder = inventoryHoldersCached.getInventoryHolder(containerLocation);

            if (inventoryHolder != null && !plugin.getProtectionProvider().checkIfProviderAllowOpen(event.getPlayer(), containerLocation, event))
                return true;

            if (inventoryHolder != null && !metadataActivateLinkMode.hasMetadata(player)) {
                if (inventoryHolder.getTimeRunTask() > 0 && !plugin.getContainerTask().isLocationInList(containerLocation))
                    plugin.getCheckChunkLoadUnload().addToCache(containerLocation, containerLocation.getChunk().getChunkSnapshot());
                return inventoryHolder.onOpenContainer(event, player, pageNumber);
            }
        }
        return false;
    }

}
