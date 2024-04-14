package org.brokenarrow.storage.api.hooks;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface Protections {

    /**
     * check if all protection allow open the container
     *
     * @param player            some open the container
     * @param containerLocation location of the container
     * @param event             when player open container
     * @return true if it allows player to open
     */
    boolean checkIfProviderAllowOpen(Player player, Location containerLocation, PlayerInteractEvent event);

    /**
     * If it allows t0o place the container.
     *
     * @param player
     * @param containerPlaceLocation
     * @return
     */
    boolean checkIfProviderAllowPlace(Player player, Location containerPlaceLocation);

    /**
     * check if all protection allow break the container
     *
     * @param player
     * @param location
     * @param event
     * @return
     */
    boolean checkIfProviderAllowBreak(Player player, Location location, BlockBreakEvent event);

    /**
     * check if all protection allow to explode the container
     *
     * @param location location of the container
     * @return true if all protections on that location allows to explode the container.
     */
    boolean checkIfProviderAllowExplodeContainer(Player player, Location location);
}
