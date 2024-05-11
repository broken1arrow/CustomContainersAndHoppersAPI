package org.brokenarrow.storage.api.hooks;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * The protections checks used.
 */
public interface Protection {

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
     * @param player the player exicute acction.
     * @param containerPlaceLocation the location of this handling.
     * @return true if player allows to place container.
     */
    boolean checkIfProviderAllowPlace(Player player, Location containerPlaceLocation);

    /**
     * check if all protection allow break the container
     *
     * @param player the player execute action.
     * @param location the location of this handling.
     * @param event the break event when player break the container.
     * @return true if player allows to break container.
     */
    boolean checkIfProviderAllowBreak(Player player, Location location, BlockBreakEvent event);

    /**
     * check if all protection allow to explode the container
     *
     * @param player the player execute action.
     * @param location location of the container
     * @return true if all protections on that location allows to explode the container.
     */
    boolean checkIfProviderAllowExplodeContainer(Player player, Location location);
}
